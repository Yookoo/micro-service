package com.edu.spring4.bean.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
/**
 * 
 * bean 的生命周函数，分别在bean初始化前后调用。每初始化一个bean调用一次。
 * @author Administrator
 *
 */
@Component
public class EchoBeanPostProcessor implements BeanPostProcessor{
	/**
	 * bean初始化前调用,在bean的属性设置之后调用。
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("-------------"+beanName+"--Bean BeforeInitialization----------------------------");
		return bean;
	}
	/**
	 * bean初始化后调用
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("-------------"+beanName+"--Bean BeforeInitialization----------------------------");
		return bean;
	}

}
