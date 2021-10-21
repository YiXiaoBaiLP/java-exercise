package com.yixiaobai.lp.chap7.reusing;

/**
 * 	初始化基类（父类）
 * 
 * 	继承Drawing 顺便还继承了Drawing的父类Art
 * @author liupeng
 *
 */
public class Cartoon extends Drawing{

	public static void main(String[] args) {
		// 1.先执行Art的构造函数（父类）
		// 2.再执行Drawing的构造函数（Art的子类，Cartoon的父类）
		// 3.最后执行Cartoon的构造函数（Art和Drawing的子类）
		Cartoon car = new Cartoon();
	}
	
	Cartoon(){
		System.out.println("Cartoon constructor");
	}
}

/**
 *	父类 
 * @author liupeng
 *
 */
class Art{
	Art() {
		System.out.println("Art constructor");
	}
}

/**
 * 	继承 Art类
 * @author liupeng
 *
 */
class Drawing extends Art {
	Drawing() {
		System.out.println("Drawing constructor");
	}
}
