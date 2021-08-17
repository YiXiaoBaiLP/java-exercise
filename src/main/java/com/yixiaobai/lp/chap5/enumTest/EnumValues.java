package com.yixiaobai.lp.chap5.enumTest;

/**
 * 通过values方法获取enum类中的所有值的数组。
 * @author yixiaobai
 *
 */
public class EnumValues {

	public static void main(String...strings ) {
		// values方法返回一个包含所有枚举值的数组。
		EnumTest[] enumTest = EnumTest.values();
		for(EnumTest enumStr : enumTest) {
			System.out.println(enumStr);
		}
	}
}
