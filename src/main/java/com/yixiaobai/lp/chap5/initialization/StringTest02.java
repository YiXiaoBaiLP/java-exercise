package com.yixiaobai.lp.chap5.initialization;

public class StringTest02 {
	
	// 2)创建一个类，它包含一个在定义时就被初始化了的String域，以及另一个通过构造器初始化的String域。这两种方式有什么区别。

	public static void main(String[] args) {
		
		String st1 = "st1";
		String st2 = "st2";
		String st3 = "st3";
		
		String st4 = new String("st1");
		String st5 = new String("st2");
		String st6 = new String("st3");
		
		System.out.println(st1 == st4);
		System.out.println(st2 == st5);
		System.out.println(st3 == st6);
		
		System.out.println(st1.equals(st4));
	}
}
