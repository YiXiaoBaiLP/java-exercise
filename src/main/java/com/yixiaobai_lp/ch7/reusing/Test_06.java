package com.yixiaobai_lp.ch7.reusing;

/**
 * 
 * 	练习6: 	调用基类的构造器必须是在子类中的第一件事。
 * 
 * @author liupeng
 *
 */
public class Test_06 extends BoardGame06{

	Test_06(){
		//如果不使用super调用父类的构造函数，
		//则编译器就不会知道你要调用哪一个父类的构造函数，
		//所以需要在子类的构造函数中显示的调用。
		//super(11);
		System.out.println("Test_06 constructor");
	}
	public static void main(String[] args) {
		Test_06 test06 =new Test_06();
	}
}

class Game06 {
	Game06(int i){
		System.out.println("Game06 constructor");
	}
}

class BoardGame06 extends Game06{
	BoardGame06(int i) {
		super(11);
		System.out.println("BoardGame06 constructor");
	}
}
