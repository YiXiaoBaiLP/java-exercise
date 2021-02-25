package com.yixiaobai_lp.ch7.reusing;

public class Bath {
	
	private String	// Initalizing at point of definition; 
		s1 = "Happy",
		s2 = "Happy",
		s3, s4;
	
	private Soap castille;
	private int i;
	private float toy;
	// Bath的无参构造函数
	public Bath() {
		System.out.println("Inside Bath()");
		// 初始化全局变量 s3
		s3 = "Joy";
		toy = 3.14f;
		castille = new Soap();
	}
	{
		i = 47;
	}
	// 重写 Bath的toString()方法
	public String toString() {
		if( s4 == null) {
			s4 = "Joy";
		}
		return 
				"s1 = " + s1 + "\n" +
				"s2 = " + s2 + "\n" +
				"s3 = " + s3 + "\n" +
				"s4 = " + s4 + "\n" +
				"toy = " + toy + "\n" +
				"castille = " + castille;
	}

	public static void main(String[] args) {
		
		Bath b = new Bath();
		// 输出Bath的toString()方法。
		System.out.println(b);
	}
}

class Soap {
	private String s;
	
	//创建默认构造函数
	Soap(){
		System.out.println("Soap()");
		s = "Constructed!";
	}
	
	// 每一个类都有一个toString()方法
	public String toString() {
		return s;
	}
}
