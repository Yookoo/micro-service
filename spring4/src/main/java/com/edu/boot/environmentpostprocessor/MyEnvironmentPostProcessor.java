package com.edu.boot.environmentpostprocessor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;
/**
 * EnvironmentPostProcessor 动态的注入配置文件
 * 
 * @author Administrator
 *
 */
@Component
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		
		try {
			//如何读取classpath下的配置文件
			InputStream inputStream = this.getClass().getResourceAsStream("/application2.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource("properties1", properties);
			environment.getPropertySources().addLast(propertiesPropertySource);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
