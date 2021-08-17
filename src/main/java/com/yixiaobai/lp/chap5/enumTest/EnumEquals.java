package com.yixiaobai.lp.chap5.enumTest;

/**
 * enum 类进行比较
 * @author yixiaobai
 *
 */
public class EnumEquals {

	public static void main(String...strings ) {
		// enum中不推荐适应equals方法来进行比较
		Boolean boolEnum = EnumTest.EXTRA_LARGE.equals(EnumTest.EXTRA_LARGE);
		System.out.println(boolEnum);
		
		// enum推荐使用“==”进行两个enum的值
		boolean isEnum = EnumTest.LARGE == EnumTest.LARGE;
		System.out.println(isEnum);
	}
}
