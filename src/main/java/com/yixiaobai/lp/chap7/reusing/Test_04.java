package com.yixiaobai.lp.chap7.reusing;

/**
 * 	1.练习4:
 * 		证明基类构造器：（a)总是会被调用；
 * 					 （b）在导出类构造器之前被调用。
 * 	
 * @author liupeng
 *
 */
public class Test_04 extends Art04{

	public Test_04() {
		System.out.println("Test_04 Constructor");
	}
	
	public Test_04(String str) {
		System.out.println("Test_04 str:" + str);
	}
	
	public Test_04(int age) {
		System.out.println("Test_04 今年多少岁：" + age);
	}
	public static void main(String[] args) {
		new Test_04();
		new Test_04("Hell World!!!");
		new Test_04(18);
	}
}

class Art04 {
	
	Art04() {
		System.out.println("Art04 Constructor");
	}
}