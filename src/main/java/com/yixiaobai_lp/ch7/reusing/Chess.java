package com.yixiaobai_lp.ch7.reusing;

/**
 * 	使用 super关键字调用父类的构造函数
 * @author liupeng
 *
 */
public class Chess extends BoarGame {

	Chess(){
		super(11);
		System.out.println("Chess constructor");
	}
	public static void main(String[] args) {
		Chess c = new Chess();
	}
}

class Game {
	Game(int i) {
		System.out.println("Game constructor");
	}
}

class BoarGame extends Game {
	BoarGame(int i ) {
		super(i);
		System.out.println("BoarGame constructor");
	}
}
