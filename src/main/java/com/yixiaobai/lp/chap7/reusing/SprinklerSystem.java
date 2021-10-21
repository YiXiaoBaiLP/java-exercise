package com.yixiaobai.lp.chap7.reusing;

public class SprinklerSystem {

	// 定义私有的全局变量
	private String value1, value2, value3, value4;
	private WaterSource source = new WaterSource();
	private int i;
	private float f;

	// 重写 SprinklerSystem的toString()方法
	public String toString() {
		return " value1 =  " + value1 + " " +
			" value2 =  " + value2 + " " +
			" value3 =  " + value3 + " " +
			" value4 =  " + value4 + "\n" +
			" i = " + i + " " + " f = " + f + " \n" +
			" source = " + source;
	}
	
	public static void main(String[] args) {
	
		SprinklerSystem sprinklerSystem = new SprinklerSystem();
		sprinklerSystem.toString();
		System.out.println(sprinklerSystem);
	}
	
}

class WaterSource {
	
	private String s;
	
	WaterSource() {
		System.out.println("WaterSource() 的构造函数创建。");
		s = "Constructed(构造函数创建对象s)";
	}
	
	/**
	 * 	重写WaterSource的toString()方法
	 */
	public String toString() {
		return s;
	}
}