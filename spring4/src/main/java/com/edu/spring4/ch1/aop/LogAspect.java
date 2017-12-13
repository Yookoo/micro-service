package com.edu.spring4.ch1.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	@Pointcut("@annotation(com.edu.spring4.ch1.aop.Action)")
	void annotationPointCut() {};
	
	@After("annotationPointCut()")
	void after(JoinPoint joinPoint) {
		MethodSignature signature= (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println(String.format("注解式拦截 %s", action.name()));
	}
	
	@Before("execution(* com.edu.spring4.ch1.aop.DemoMethodService.*(..))")
	void before(JoinPoint joinPoint) {
		MethodSignature signature= (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println(String.format("方法规则拦截 %s", method.getName()));
	}
}
