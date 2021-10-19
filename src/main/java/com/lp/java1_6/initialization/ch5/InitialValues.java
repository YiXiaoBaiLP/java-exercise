package com.lp.java1_6.initialization.ch5;

/**
 *
 * 系统默认会给类变量进行默认初始化。
 * 注：char类型的字符串输出比较输出。
 */
public class InitialValues {
	
	boolean t;
	char c;
	byte b;
	short s;
	int i;
	long l;
	float f;
	double d;
	InitialValues reference;
	
	void printInitialValue() {
		System.out.println("Data Type Initial value");
		System.out.println("boolean " + t);
		System.out.println("char [" + c + "]");
		System.out.println("cher类型字符串拼接，char后的字符串不进行拼接");
		System.out.println("byte " + b);
		System.out.println("short " + s);
		System.out.println("int " + i);
		System.out.println("long " + l);
		System.out.println("float " + f);
		System.out.println("double " + d);
		System.out.println("reference " + reference);
	}

	public static void main(String[] args) {
		InitialValues iv = new InitialValues();
		iv.printInitialValue();
	}
}
