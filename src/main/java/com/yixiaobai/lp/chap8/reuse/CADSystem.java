package com.yixiaobai.lp.chap8.reuse;

/**
 * 		保证适当的清理
 * 		我们不知道垃圾收集器是什么时候调用，也不知道垃圾收集器是否会执行，
 * 		所以我们要显示的调用垃圾收集器。
 * 
 * 	一个屏幕上绘图的例子
 * 
 * @author liupeng
 *
 */
public class CADSystem {

}

class Shape {
	// 有参构造函数
	Shape(int i){
		System.out.println(" Shape constructor ");
	}
	
	void dispose() {
		System.out.println(" Shape dispose ");
	}
}

class Circle extends Shape{
	Circle(int i){
		super(i);
		System.out.println(" Circle constructor ");
	}

	@Override
	void dispose() {
		System.out.println(" Erasing Circle ");
	}
}