package com.yixiaobai.lp.chap5.initialization;

public class Spoon {
	// 静态初始化。
	static int i;
	
	// 静态初始化块。
	// 这里买你定义的都是静态
	// 这个方法只执行一次
	static {
		i = 27;
		String st;
	   // ...
	}

}
