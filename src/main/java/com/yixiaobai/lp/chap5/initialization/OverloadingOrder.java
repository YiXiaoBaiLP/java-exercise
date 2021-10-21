package com.yixiaobai.lp.chap5.initialization;

/**
 *  参数顺序的不同也可以区分重载。
 *    f()方法声明了相同的参数，但是顺序不同，因此得以区分。
 * 
 * @author liupeng
 * @version 1.0.0
 */
public class OverloadingOrder {

	// 两个相同名称的方法，只是参数的顺序不同，也可以重载。
	static void f(String s, int i) {
		System.out.println("String: " + s + ", int: " + i);
	}
	
	static void f(int i, String s) {
		System.out.println("int: " + i + ", String: " + s);
	}
	
	public static void main(String[] args) {
		f("String first", 11);
		f(99, "Int first");
	}
}
