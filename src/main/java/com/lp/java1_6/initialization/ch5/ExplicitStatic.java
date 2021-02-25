package com.lp.java1_6.initialization.ch5;

/**
 * 	静态初始化动作只执行一次。
 * 
 * @author liupeng
 *
 */
public class ExplicitStatic {
	
	public static void main(String[] args) {
		Cups cup = new Cups();
		// 此行会执行Cpus的静态方法初始化操作。
		Cups.cup1.f(88);
		
		
	}
// 此处会执行Cups类的静态方法初始化操作，不管创建几个u对象，静态初始化操作只执行一次。
//	static Cups cups1 = new Cups();
//	static Cups cups2 = new Cups();

}

class Cup {
	Cup(int marker){
		System.out.println("Cup(" + marker + ")");
	}
	
	void f(int marker) {
		System.out.println("f(" + marker + ")");
	}
}

class Cups {
	// 最先初始化静态资源
	static Cup cup1;
	static Cup cup2;
	static {
		cup1 = new Cup(1);
		cup2 = new Cup(2);
	}
	
	Cups(){
		System.out.println("Cups()");
	}
}
