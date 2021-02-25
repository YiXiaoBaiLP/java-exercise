package com.yixiaobai.lp.ch8.reuse;

public class SprinklerSystem {
	
	private String value1, value2, value3, value4;
	
	private WateSource wateSource = new WateSource();
	
	private int i;
	
	private float f;
	
	public String toString() {
		return "value1 = " + value1 + "	" +
			   "value2 = " + value2 + "	" +
			   "value3 = " + value3 + "	" +
			   "value4 = " + value4 + "\r" + 
			   "i = " + i + " " + " f = " + f + "\r" +
			   // 这里会调用WateSource类的toString方法。
			   "wateSource = " + wateSource;
	}
	public static void main(String[] args) {
		
		SprinklerSystem source = new SprinklerSystem();
		// 此输出会调用toString()方法
		System.out.println(source);
	}

}

class WateSource {

	private String s;
	
	WateSource() {
		System.out.println("WateSource()");
		s = "Constructed";
	}
	
	@Override
	public String toString() {
		return s;
	}
}
