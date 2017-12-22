package com.edu.spring4.bean.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
/**
 * BeanFactoryPostProcessor 用于获取 BeanFactory
 * 
 * @author Administrator
 *
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("-----------------------"+beanFactory.getBeanDefinitionCount()+"-------------------");
	}

}
