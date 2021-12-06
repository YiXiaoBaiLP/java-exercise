package com.yixiaobai.lp.access;

/**
 * 
 * 	private 的使用规则
 *  构造器使用 private
 * 
 * @author liupeng
 * @version 1.0.0
 */
public class IceCream {

	public static void main(String[] args) {
		// 无法调用 Sundae的默认构造函数
		// 因为此构造函数是一个私有（private）的方法
	//	Sundae sun = new Sundae();
		Sundae sun = Sundae.makeAsSundae();
		if(sun == null) {
			System.out.println("sun对象创建失败！！！");
		}else {
			System.out.println("sun对象创建成功，值为：" + sun.hashCode());
		}
	}
}

class Sundae{
	
	// 一个私有的 构造函数，类外无法调用
	private Sundae() {
		
	}
	// 此方法返回一个默认的构造函数。
	static Sundae makeAsSundae() {
		return new Sundae();
	}
}
