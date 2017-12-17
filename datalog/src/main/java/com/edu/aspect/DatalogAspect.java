package com.edu.aspect;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.edu.entity.Action;
import com.edu.entity.ActionType;
import com.edu.entity.ChangeItem;
import com.edu.repository.ActionRepository;
import com.edu.repository.ProductRepository;
import com.edu.utils.DiffUtils;

	/**
	 * AOP 的核心方法
	 * 
	 * 定义切点和 和 方法
	 *
     * 1\判断是什么类型的操作,增加\删除\还是更新
     *  增加/更新 save(Product),通过id区分是增加还是更新
     *  删除delete(id)
     * 2\获取changeitem
     *   (1)新增操作,before直接获取,after记录下新增之后的id
     *   (2)更新操作,before获取操作之前的记录,after获取操作之后的记录,然后diff
     *   (3)删除操作,before根据id取记录
     * 3\保存操作记录
     *    actionType
     *    objectId
     *    objectClass
     *
	 * 
	 * @author Administrator
	 *
	 */
@Component
@Aspect
public class DatalogAspect {

	private static final Logger logger = LoggerFactory.getLogger(DatalogAspect.class);
	
	@Autowired
	private ActionRepository actionRepository;
	
	@Pointcut("execution(public * com.edu.repository.*.save*(..))")
	public void save() {}
	
	@Pointcut("execution(public * com.edu.repository.*.delete*(..))")
	public void delete() {}
	
	@Around("save()||delete()")
	public Object addOperateLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("--------enter aspect----------");
		Object target = pjp.getTarget();
		Class<? extends Object> cls = target.getClass();
		
		String methodName = pjp.getSignature().getName();
		Object args = pjp.getArgs()[0];	

		Action action = new Action();	
		ActionType actionType = null;

		Object id = null;
		Object result = null;
		Object oldObj = null;
		Object newObj = null;
		try {
			//TODO 方法执行之前需要做的
			//判断是什么类型的操作
			if(!StringUtils.isEmpty(methodName) && methodName.startsWith("save")) {
				//判断id是否存在
				id = PropertyUtils.getProperty(args, "id");
				newObj = args;
				if(id == null) {
					//新增
					actionType = actionType.INSERT;
					//添加变更列表
					List<ChangeItem> changeItems = DiffUtils.getInsertChangeItems(newObj);
					action.getChanges().addAll(changeItems);
					
				}else {
					//修改
					actionType = actionType.UPDATE;
					//获取老对象
					oldObj = DiffUtils.getObjectById(target, id);
					List<ChangeItem> changeItems = DiffUtils.getChangeItems(oldObj, newObj);
					action.getChanges().addAll(changeItems);
					
				}
			}else if(!StringUtils.isEmpty(methodName) && methodName.startsWith("delete")){
				//删除时传入的参数就是id;
				id = args;
				//删除
				actionType = actionType.DELETE;
				oldObj = DiffUtils.getObjectById(target, id);
				List<ChangeItem> changeItems = DiffUtils.getDeleteChangeItems(oldObj);
				action.getChanges().addAll(changeItems);
			}
			//
			//构造Action
			action.setOperatorTime(new Date());
			action.setObjId(id);
			action.setObjClass(cls.getName());
			//TODO 
			action.setOperator("user");
			action.setActionType(actionType);
			System.out.println("-------proceed------------");
			result = pjp.proceed();
			
			//TODO AFTER OPERATION save action
            action.setActionType(actionType);
            if(ActionType.INSERT == actionType){
                //new id
                Object newId = PropertyUtils.getProperty(result,"id");
                action.setObjId(newId);

            }
            action.setOperator("admin"); //dynamic get from threadlocal/session
            actionRepository.save(action);
			
		} catch (Throwable e) {
			System.out.println("ex:"+ e.getMessage());
			throw e;
		}
		return result;
	}
	
}
