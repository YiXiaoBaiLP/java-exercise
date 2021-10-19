package com.lp.java1_6.initialization.ch5;

/**
 * 有参的方法也可以初始化一个变量，但前提参数必须有值。
 * @author liupeng
 * @version
 */
public class MethodInit02 {

	int i = f();
	//通过返回值来初始化，但i必须有值
	int j = g(i);
	
	int f() {
		return 10;
	}
	
	int g(int i) {
		return i * 20;
	}
}
