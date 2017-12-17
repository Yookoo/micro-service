package com.edu.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.edu.anno.Datalog;
import com.edu.entity.ChangeItem;

public class DiffUtils {

	private static final Logger logger = LoggerFactory.getLogger(DiffUtils.class);

	/**
	 * 
	 * @param oldObj
	 * @param newObj
	 * @return
	 */
	public static List<ChangeItem> getChangeItems(Object oldObj, Object newObj) {

		Class<? extends Object> cls = oldObj.getClass();
		List<ChangeItem> changeItems = new ArrayList<>();

		Map<String, String> fieldCnNameMap = getFieldShowNameMap(cls);

		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(oldObj.getClass(), Object.class);

			for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
				String field = propertyDescriptor.getName();

				String oldProp = getValue(PropertyUtils.getProperty(oldObj, field));
				String newProp = getValue(PropertyUtils.getProperty(newObj, field));

				// update
				if (!oldProp.equals(newProp)) {

					ChangeItem changeItem = new ChangeItem();
					changeItem.setField(field);
					String cnName = fieldCnNameMap.get(field);
					changeItem.setFieldShowName(StringUtils.isEmpty(cnName) ? field : cnName);
					changeItem.setOldValue(oldProp);
					changeItem.setNewValue(newProp);
					changeItems.add(changeItem);
				}
			}

		} catch (Throwable e) {
			logger.error("There is error when convert change item", e);
			e.printStackTrace();
		}
		return changeItems;
	}

	/**
	 * 记录添加方法的日志方法
	 * 
	 * @param args
	 * @return
	 */
	public static List<ChangeItem> getInsertChangeItems(Object newObj) {
		Map<String, String> fieldCnNameMap = getFieldShowNameMap(newObj.getClass());
		List<ChangeItem> items = new ArrayList<>();

		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(newObj.getClass(), Object.class);

			for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
				// 获取参数中的属性和值
				String field = propertyDescriptor.getName();
				String newProp = getValue(PropertyUtils.getProperty(newObj, field));
				ChangeItem changeItem = new ChangeItem();
				changeItem.setField(field);
				String cnName = fieldCnNameMap.get(field);
				changeItem.setFieldShowName(StringUtils.isEmpty(cnName) ? field : cnName);
				changeItem.setNewValue(newProp);
				items.add(changeItem);
			}
		} catch (Throwable e) {
			logger.error("There is error when convert change item", e);
			e.printStackTrace();
		}
		return items;
	}

	/**
	 * 删除操作的字段变更记录
	 * 
	 * @param oldObj
	 * @return
	 */
	public static List<ChangeItem> getDeleteChangeItems(Object oldObj) {

		ChangeItem changeItem = new ChangeItem();
		changeItem.setOldValue(JSON.toJSONString(oldObj));
		changeItem.setNewValue("");
		return null;
	}

	/**
	 * 将不同类型转换为字符串
	 * 
	 * @param property
	 * @return
	 */
	private static String getValue(Object obj) {
		if (obj == null) {
			return "";
		}
		if (obj instanceof Date) {
			return formatDateW3C((Date) obj);
		} else {
			return obj.toString();
		}
	}

	/**
	 * 
	 * @param date
	 * @return
	 */

	public static String formatDateW3C(Date date) {
		Instant instant = date.toInstant();
		LocalDateTime time = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		return time.toString();
	}

	/**
	 * 从注解读取中文名
	 * 
	 * @param clz
	 * @return
	 */
	public static Map<String, String> getFieldShowNameMap(Class<? extends Object> cls) {
		Map<String, String> map = new HashMap<>();
		for (Field field : cls.getDeclaredFields()) {
			if (field.isAnnotationPresent(Datalog.class)) {
				Datalog datalog = field.getAnnotation(Datalog.class);
				map.put(field.getName(), datalog.name());
			}
		}
		return map;
	}
	/**
	 * 使用反射调用查询方法
	 * @param target
	 * @param id
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Object getObjectById(Object target, Object id) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method findMethod = target.getClass().getDeclaredMethod("findOne", Long.class);
		Object oldObj = findMethod.invoke(target, id);
		return oldObj;
	}
}
