package com.edu.spring4.profile;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	/**
	@Bean(destroyMethod="shutdown")
	@Profile("dev")
	DataSource embeddedDataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:schema.sql")
				.addScript("classpath:test-data.sql")
				.build();
	}
	
	@Bean
	@Profile("prod")
	DataSource jndiDataSource() {	
		JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setJndiName("jdbc/myDS");
		jndiObjectFactoryBean.setResourceRef(true);
		jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
		return (DataSource)jndiObjectFactoryBean;
	}
	
	@Bean
	@Profile("qa")
	DataSource basicDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:h2:tcp://dbserver/~/test");
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("sa");
		dataSource.setPassword("password");
		dataSource.setInitialSize(20);
		return dataSource;
	}
	*/
}
