package com.yixiaobai.lp.annotation;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * java的注解处理器（java8之后的版本）
 * 
 * @author yixiaobai
 * @version 1.0.0
 */
public class UseCaseTracker02 {

	public static void main(String[] args) {
		List<Integer> useCases = IntStream
				.range(47,100)
				.boxed()
				.collect(Collectors.toList());
		trackUseCases(useCases, PassWordUtils.class);
	}
	
	public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
		for(Method m : cl.getDeclaredMethods()) {
			// 获取所有的注解
			UseCase us = m.getAnnotation(UseCase.class);
			if(us != null){
				System.out.println("Found Use Case " + us.id() + "\n" + us.description());
				useCases.remove(Integer.valueOf(us.id()));
			}
		}
		// java8 Lambda 语法
		useCases.forEach(i -> System.out.println("Missing use case" + i));
	}
}
