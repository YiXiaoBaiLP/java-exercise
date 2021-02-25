package com.lp.java1_6.initialization.ch5;

public class Flower {

	// 定一个int类型的常量。
	int petalCount = 0;
	// 定义一个String类型的常量
	String s = "initial value";
	// 创建一个可以传入int类型的常量。
	Flower(int petals){
		petalCount = petals;
		System.out.println("Constructor w/ int arg only . petalCount = " + petalCount );
	}
	// 创建一个可以传入String类型的常量参数。
	Flower(String ss){
		s = ss;
		System.out.println("Constructor w/ String arg only . s = " + ss);
	}
	// 创建一个有参构造器，参数为 String  int 类型的参数。
	Flower(String s, int petals){
		// 使用this关键子来调用其他构造器。
		this(petals);
		//this.(s);  // this 调用其他构造器只能写在最前面；且只能有一个。
		this.s = s; // 使用this关键字来区分类常量与参数名称。
		System.out.println("String & int args");
	}
	// 手动创建无参构造器
	Flower(){
		this("hi", 47); // 调用有惨构造
		System.out.println("default constructor (no args)");
	}
	
	void printPetalCount() {
//		this(11); // 不能在方法中使用this来调用构造器。
		System.out.println("petalCount = " + petalCount + " s = " + s);
	}
	
	public static void main(String[] args) {
		Flower flower = new Flower();
		flower.printPetalCount();
	}
}
