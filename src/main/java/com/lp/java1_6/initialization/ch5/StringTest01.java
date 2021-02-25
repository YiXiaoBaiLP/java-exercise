package com.lp.java1_6.initialization.ch5;

/**
 * 	第五章 初始化与清理  练习
 * 	
 * @author liupeng
 *
 */
public class StringTest01 {
	
	//1》创建一个类，他包含一个未初始化的String引用。验证该引用被Java初始化成为了null。

	//一个没有初始化的String的引用。
	static String st;
	
	public static void main(String[] args) {
		// 此String的引用被Java初始化为 null;
		System.out.println(st);
	}
}
