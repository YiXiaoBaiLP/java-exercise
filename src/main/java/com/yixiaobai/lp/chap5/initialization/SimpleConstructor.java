package com.yixiaobai.lp.chap5.initialization;


/***
 * 
 * 	一个带有构造器的简单类。
 * @author liupeng
 * @version 1.0.0
 */
public class SimpleConstructor {
	
	public static void main(String[] args) {
		
		for(int i = 0; i < 10; i++) {
			new Rock();
		}
	}
}

class Rock {
	
	Rock(){
		System.out.println("Rock ");
	}
}