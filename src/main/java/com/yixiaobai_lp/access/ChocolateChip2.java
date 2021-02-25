package com.yixiaobai_lp.access;

/**
 * 
 *  子类继承父类，调用 protected 修饰的方法
 * 
 * @author liupeng
 *
 */

public class ChocolateChip2 extends Cookie{

	public ChocolateChip2() {
		System.out.println("ChocolateChip2 constructor");
	}
	public void chomp () {
		// bite 方法为 父类方法 
		bite();
	}
	public static void main(String[] args) {
		ChocolateChip2 x = new ChocolateChip2();
		x.chomp();
	}
}
