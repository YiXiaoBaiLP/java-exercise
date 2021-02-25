package com.yixiaobai_lp.ch7.reusing;

/**
 * 	练习8：
 * 		1、创建一个基类，他仅有一个非默认构造器
 * 		2、在创建一个导出类，它带有默认构造器于非默认构造器
 * 		3、在导出类的构造器中调用基类的构造器。
 * 
 * 
 * @author liupeng
 *
 */
public class Test_08 {
	
	public static void main(String[] args) {
		new BoardGame("我是导出类的有参构造器");
	}

}


class Geam {
	// 基类的非默认构造器
	public Geam(String str) {
		System.out.println("Geam str: " + str);
	}
}

class BoardGame extends Geam {
	// 导出类的默认构造器
	public BoardGame() {
		// 调用基类的构造器
		super("BoardGame()");
	}
	// 导出类的有参构造器
	public BoardGame(String str) {
		// 调用基类的有参构造器。
		super(str);
	}
	
}