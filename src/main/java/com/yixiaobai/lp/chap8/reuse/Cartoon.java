package com.yixiaobai.lp.chap8.reuse;

/**
 *   	继承时构造函数的使用
 * @author liupeng
 *
 */
public class Cartoon extends Drawing{

	public Cartoon() {
		// 最后加载
		System.out.println("Cartoon constructor");
	}
	
	public static void main(String[] args) {
		
		// 首先会先加载基类的构造函数
		Cartoon c = new Cartoon();
	}
}

class Art {
	
	// 第一个加载
	Art() {
		System.out.println("Art constructor");
	}
}

class Drawing extends Art {
	// 第二个加载
	Drawing() {
		System.out.println("Drawing constructor");
	}
}
