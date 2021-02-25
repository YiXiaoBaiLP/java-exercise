package com.yixiaobai.lp.ch8.reuse;

/**
 * 	初始化基类
 * 	调用有参的构造函数
 * @author liupeng
 *
 */
public class Chess extends BoarGame{

	Chess() {
		// 调用父类的有参构造
		super(11);
		System.out.println(" Chess constructor ");
	}
	
	public static void main(String[] args) {
		Chess x = new Chess();
	}
}

class Game {
	
	Game(int i) {
		System.out.println(" Game constructor ");
	}
}

class BoarGame extends Game {
	BoarGame(int i) {
		// 调用父类的构造函数
		// 必须放到第一位
		super(i);
		System.out.println(" BoarGame constructor ");
	}
}
