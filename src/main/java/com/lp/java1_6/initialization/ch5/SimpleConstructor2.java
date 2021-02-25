package com.lp.java1_6.initialization.ch5;


/**
 * 一个有参的简单构造器
 * @author liupeng
 *
 */
public class SimpleConstructor2 {

	public static void main(String[] args) {
		
		for(int i = 0; i < 10; i++) {
			new Rock2(i);
		}
	}
}

class Rock2 {
	// 带有一个参数的构造器
	Rock2(int i){
		System.out.print("Rock" + i + " ");
	}
}
