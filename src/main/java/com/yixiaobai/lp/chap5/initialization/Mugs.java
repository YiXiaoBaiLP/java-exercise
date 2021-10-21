package com.yixiaobai.lp.chap5.initialization;

/**
 * 
 *  非静态实例的初始化。
 *  每次调用时都会被初始化一次.
 * @author liupeng
 * @version
 */
public class Mugs {

	Mug mug1;
	Mug mug2;
	// 初始化块
	// 在构造器之前调用,确保能够可以正常初始化.
	{
		// 每次创建新的对象时,此处都会进行初始化操作.
		mug1 = new Mug(1);
		mug2 = new Mug(2);
		System.out.println("mug1 & mug2 的初始化.");
	}
	
	Mugs() {
		System.out.println("Mugs()");
	}
	
	Mugs(int i) {
		System.out.println("Mugs(int)");
	}
	
	public static void main(String[] args) {
		System.out.println("Inside main()");
		// 调用Mugs的无参构造函数时,mug1&mug2会被初始化.
		new Mugs();
		System.out.println("new Mugs(); completed");
		// 调用Mugs(int)构造器时,mug1&mug2还会被初始化一次.
		new Mugs(1);
		System.out.println("new Mugs(1) completed");
	}
}

class Mug {
	// 带有一个int参数的构造器
	Mug(int marker) {
		System.out.println("Mug(" + marker + ")");
	}
	// 一个需要一个int参数；并没有返回值的方法。
	void f(int marker) {
		System.out.println("f(" + marker + ")");
	}
}
