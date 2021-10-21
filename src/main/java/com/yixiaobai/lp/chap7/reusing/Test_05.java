package com.yixiaobai.lp.chap7.reusing;

/**
 * 	练习5:
 * 			创建两个带有默认构造（空参数列表）的类A和类B。
 * 			从A中继承产生一个新类C，并在C内创建一个B类的成员。
 * 			不要给C编写构造器。创建一个C类的对象并观察其结果。
 * 	
 * @author liupeng
 *
 */
public class Test_05 {

	public static void main(String[] args) {
		C c = new C();
	}
}

class A {
	
	A() {
		System.out.println("A 类的默认构造函数");
	}
}

class B {
	
	B() {
		System.out.println("B 类的默认构造函数");
	}
}

class C extends A{
	
	B b;
}