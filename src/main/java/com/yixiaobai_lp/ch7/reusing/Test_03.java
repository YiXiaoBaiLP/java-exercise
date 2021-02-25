package com.yixiaobai_lp.ch7.reusing;

/**
 * 	练习3: 即使不为Cartoon()创建构造器，编译器也会初始化基类
 * 
 * @author liupeng
 *
 */
public class Test_03 extends Drawing02 {

	public static void main(String[] args) {
		// Art02、Drawing02 都得到了初始化
		Test_03 test03 =new Test_03();
	}
}

/**
 * 	父类
 * @author liupeng
 *
 */
class Art02 {
	
	Art02(){
		System.out.println("Art02 constructor");
	}
}

/**
 * 	Test_03的父类
 * @author liupeng
 *
 */
class Drawing02 extends Art02 {
	
	Drawing02() {
		System.out.println("Drawing02 constrcuctor");
	}
}
