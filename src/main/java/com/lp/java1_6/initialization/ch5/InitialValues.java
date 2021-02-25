package com.lp.java1_6.initialization.ch5;

/**
 *
 * 系统默认会给类变量进行默认初始化。
 *
 *
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
		System.out.println("Data Type 		Initial value");
		System.out.println("boolean 		" + t);
		System.out.println("char 			[" + c + "]");
		System.out.println("byte   			" + b );
	}

	public static void main(String[] args) {
		
		InitialValues iv = new InitialValues();
		iv.printInitialValue();
	}
}
