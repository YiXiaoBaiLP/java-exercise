package com.lp.java1_6.initialization.ch5;


/***
 * 
 *  通过调用某个返回值来初始化变量。
 *  
 * @author liupeng
 * @version 1.0.0
 */
public class MethodInit {
	//通过返回值来初始化变量。
	int i = f();
	
	int f() {
		return 10;
	}
}
