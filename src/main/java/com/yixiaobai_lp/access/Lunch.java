package com.yixiaobai_lp.access;

public class Lunch {

	void textPrivate() {
		//私有构造函数，类外无法通过new 创建
//		Soup1 soup = new Soup1();
	}
	
	void testStatic() {
		Soup1 soup = Soup1.makeSoup();
	}
	
	void testStringleton() {
		Soup2.access().f();//可以访问内部方法。
	}
	
}

class Soup1 {

	private Soup1 () {
		
	}
	public static Soup1 makeSoup() {
		return new Soup1();
	}
}

class Soup2{
	private Soup2(){
		
	}
	private static Soup2 ps1 = new Soup2();
	
	public static Soup2 access() {
		return ps1;
	}
	
	public void f() {
		
	}
}