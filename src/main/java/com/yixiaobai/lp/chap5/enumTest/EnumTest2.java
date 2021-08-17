package com.yixiaobai.lp.chap5.enumTest;

import java.util.Scanner;

/**
 * enum类测试
 * @author yixiaobai
 *
 */
public class EnumTest2 {
	
	public static void main(String[] args) {
		// 从控制台获取用户输入的参数
		Scanner in = new Scanner(System.in);
		// 提示可以输入的参数
		System.out.println("Enter a size : (SMALL, MEDIUM, LARGE, EXRA_LARGE)");
		// 获取用户输入的参数并将其转换成大写
		String input = in.next().toUpperCase();
		// 获取enum类的enum类型名
		Size size = Enum.valueOf(Size.class, input);
		System.out.println("size = " + size);
		System.out.println("abbreviation = " + size.getAbbreviation());
		if(size == Size.EXRA_LARGE) {
			System.out.println("Good job--you paid attention too the _.");
		}
	}
}

enum Size {
	
	SMALL("S"), MEDIUM("M"), LARGE("L"), EXRA_LARGE("XL");
	
	private String abbreviation;
	
	// 只能创建private或者没有修饰符的构造函数
	private Size(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	public String getAbbreviation() {
		return abbreviation;
	}
}