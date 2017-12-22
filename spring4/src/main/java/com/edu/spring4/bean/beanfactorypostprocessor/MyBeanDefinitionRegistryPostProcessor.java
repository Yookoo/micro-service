package com.edu.spring4.bean.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import com.edu.spring4.bean.User;
/**
 * BeanDefinitionRegistryPostProcessor 可以动态的向Spring容器中注入Bean
 * @extends BeanFactoryPostProcessor
 * @author Administrator
 *
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0) throws BeansException {
	}
	/**
	 * 向Spring容器中注入10个user
	 */
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
		for (int i = 0; i < 10; i++) {
			BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(User.class);
			bdb.addPropertyValue("name", "user"+i);
			bdb.addPropertyValue("age", i);
			
			//context.registerBeanDefinition() 也可以动态注入用法同beanDefinitionRegistryj
			beanDefinitionRegistry.registerBeanDefinition("user" + i, bdb.getBeanDefinition());
		}
	}

}
