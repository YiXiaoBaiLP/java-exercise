package com.lp.java1_6.initialization.ch5;

/**
 * 
 * 
 *  当传入的数据类型（实际参数类型）小于方法中声明的形式参数类型，实际参数类型就会被提升。
 * 
 * @author liupeng
 *
 */
public class PrimitiveOverloading {

	void f1(char x) { System.out.print("f1(cahr) "); }
	void f1(byte x) { System.out.print("f1(byte) "); }
	void f1(short x) { System.out.print("f1(short) "); }
	void f1(int x) { System.out.print("f1(int) "); }
	void f1(long x) { System.out.print("f1(long) "); }
	void f1(float x) { System.out.print("f1(float) "); }
	void f1(double x) { System.out.print("f1(double) "); }

	void f2(byte x) { System.out.print("f2(byte) "); }
	void f2(short x) { System.out.print("f2(short) "); }
	void f2(int x) { System.out.print("f2(int) "); }
	void f2(long x) { System.out.print("f2(long) "); }
	void f2(float x) { System.out.print("f2(float) "); }
	void f2(double x) { System.out.print("f2(double) "); }
	
	void f3(short x) { System.out.print("f3(short) "); }
	void f3(int x) { System.out.print("f3(int) "); }
	void f3(long x) { System.out.print("f3(long) "); }
	void f3(float x) { System.out.print("f3(float) "); }
	void f3(double x) { System.out.print("f3(double) "); }
	
	void f4(int x) { System.out.print("f4(int) "); }
	void f4(long x) { System.out.print("f4(long) "); }
	void f4(float x) { System.out.print("f4(float) "); }
	void f4(double x) { System.out.print("f4(double) "); }
	
	void f5(long x) { System.out.print("f5(long) "); }
	void f5(float x) { System.out.print("f5(float) "); }
	void f5(double x) { System.out.print("f5(double) "); }
	
	void f6(float x) { System.out.print("f6(float) "); }
	void f6(double x) { System.out.print("f6(double) "); }
	
	void f7(double x) { System.out.print("f7(double) "); }
	
	void testConstVal() {
		
		System.out.print("输入5会调用哪一个方法: ");
		f1(5);
		f2(5);
		f3(5);
		f4(5);
		f5(5);
		f6(5);
		f7(5);
		System.out.println();
	}
	
	void testChar() {
		// 当无法找到可以接受char的参数的方法，会将char类型提升为int类型。
		char x = 'x';
		System.out.print("输入x字符会调用哪一个方法： ");
		f1(x);
		f2(x);
		f3(x);
		f4(x);
		f5(x);
		f6(x);
		f7(x);
		System.out.println();
	}
	
	void testByte() {
		byte x = 0;
		System.out.print("输入byte字节会调用哪一个方法： ");
		f1(x);
		f2(x);
		f3(x);
		f4(x);
		f5(x);
		f6(x);
		f7(x);
		System.out.println();
	}
	
	void testShort() {
		short x = 0;
		System.out.print("输入short类型调用哪一个方法： ");
		f1(x);
		f2(x);
		f3(x);
		f4(x);
		f5(x);
		f6(x);
		f7(x);
		System.out.println();
	}
	
	void testInt() {
		int x = 0;
		System.out.print("输入Int类型调用哪一个方法： ");
		f1(x);
		f2(x);
		f3(x);
		f4(x);
		f5(x);
		f6(x);
		f7(x);
		System.out.println();
	}
	
	void testLong() {
		long x = 0;
		System.out.print("输入long类型调用哪一个方法： ");
		f1(x);
		f2(x);
		f3(x);
		f4(x);
		f5(x);
		f6(x);
		f7(x);
		System.out.println();
	}
	
	void testFloat() {
		float x = 0;
		System.out.print("输入float类型调用哪一个方法： ");
		f1(x);
		f2(x);
		f3(x);
		f4(x);
		f5(x);
		f6(x);
		f7(x);
		System.out.println();
	}
	
	void testDouble() {
		double x = 0;
		System.out.print("输入double类型调用哪一个方法： ");
		f1(x);
		f2(x);
		f3(x);
		f4(x);
		f5(x);
		f6(x);
		f7(x);
		System.out.println();
	}
	public static void main(String[] args) {
		PrimitiveOverloading p = new PrimitiveOverloading();
		p.testConstVal();
		p.testChar();
		p.testByte();
		p.testShort();
		p.testInt();
		p.testLong();
		p.testFloat();
		p.testDouble();
	}
}
