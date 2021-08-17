package com.yixiaobai.lp.chap5.enumTest;

/**
 *  枚举类-测试类
 * @author yixiaobai
 *
 */
public enum EnumTest {
	SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
	
	private String abbreviation;
	
	private EnumTest(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	public String getAbbreviation() {
		return abbreviation;
	}
}
