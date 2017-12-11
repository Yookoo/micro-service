package com.edu.spring4.ch1.di;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * @Configuration 声明当前类为配置类
 * @ComponentScan("com.edu.spring4.ch1.di") 配置自动扫描包下所有组件
 * @author Administrator
 * 
 */
@Configuration
@ComponentScan("com.edu.spring4.ch1.di")
public class DiConfig {

}
