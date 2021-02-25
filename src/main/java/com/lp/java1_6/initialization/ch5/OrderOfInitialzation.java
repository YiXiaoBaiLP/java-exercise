package com.lp.java1_6.initialization.ch5;

/**
 * 变量会在任何方法或构造器之前就进行初始化。
 * 
 * @author liupeng
 *
 */
public class OrderOfInitialzation {

	public static void main(String[] args) {
		House h = new House();
		h.f();
	}

}

class Window {

	Window(int marker) {
		System.out.println("Window (" + marker + ")");
	}
}

// 按照变量的顺序执行
// 将所有的变量初始化完成之后，在进行初始化构造器，最后调用方法。
class House {

	Window w1 = new Window(1);

	House() {
		System.out.println("House()");
		w3 = new Window(33);
	}

	Window w2 = new Window(2);

	void f() {
		System.out.println("f()");
	}

 	Window w3 = new Window(3);
}