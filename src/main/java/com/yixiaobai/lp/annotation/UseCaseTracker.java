package com.yixiaobai.lp.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 使用java8之前的方式使用注解
 * 
 * @author yixiaobai
 * @version 1.0.0
 */
public class UseCaseTracker {

	public static void main(String[] args) {
		List<Integer> useCaseList = new ArrayList<>();
		Collections.addAll(useCaseList, 47, 48, 49, 50, 100);
		trackUseCases(useCaseList, PassWordUtils.class);
	}
	
	public static void trackUseCases(List<Integer> useCase, Class<?> cl) {
		
		// 使用了反射，获取类中的所有方法
		for(Method m : cl.getDeclaredMethods()) {
			// 获取所有类的注解
			UseCase uc = m.getAnnotation(UseCase.class);
			if(uc != null) {
				System.out.println("Found Use Case:" + uc.id() + " " + uc.description());
				// 通过注解中ID的值，来删除List集合中的元素
				useCase.remove(Integer.valueOf(uc.id()));
			}
		}
		for(int i : useCase) {
			System.out.println("Waring: Missing use case-" + i);
		}
	}
}
