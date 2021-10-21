package com.yixiaobai.lp.access;

/**
 * 
 * 	protected 修饰符的使用方法，子类中也可以调用此方法
 * 	 不是子类时则不可以调用，用此修饰符修饰的方法。
 * @author liupeng
 * @version 1.0.0
 */
public class Cookie {
	
	public Cookie() {
		System.out.println("Cookie Constructor(构造函数)");
	}
	
	protected void bite() {
		System.out.println("bite");
	}
}
