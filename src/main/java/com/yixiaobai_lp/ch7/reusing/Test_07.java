package com.yixiaobai_lp.ch7.reusing;

/**
 * 	练习7:
 * 			使用A和B以带参数的构造器取代默认构造器。为C写一个构造器，并在其中执行所有初始化。
 * 
 * @author liupeng
 *
 */
public class Test_07 extends C07{
	public static void main(String[] args) {
		new Test_07();
	}
}

class A07 {
	A07(int i) {
		System.out.println("A constructor");
	}
}

class B07 {
	B07(int i){
		System.out.println("B constructor");
	}
}

class C07 extends A07{
	C07() {
		super(1);
		new B07(1);
	}
}
