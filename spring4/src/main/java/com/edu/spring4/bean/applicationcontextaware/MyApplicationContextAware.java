package com.edu.spring4.bean.applicationcontextaware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 *  实现 ApplicationContextAware 可以方便获得ApplicationContext中的所有bean。
 * @author Administrator
 *
 */
@Component
public class MyApplicationContextAware implements ApplicationContextAware{

	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
