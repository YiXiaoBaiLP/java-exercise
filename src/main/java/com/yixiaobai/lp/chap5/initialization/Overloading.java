package com.yixiaobai.lp.chap5.initialization;

/**
 * 重载构造器和重载的方法，小例子。
 * @author liupeng
 * @version 1.0.0
 */
public class Overloading {
	
	public static void main(String[] args) {
		
		for(int i = 0; i < 5; i++ ) {
			//调用Tree的有参构造函数。
			Tree t = new Tree(i);
			t.info();
			t.info("overloaded method");
		}
		//调用Tree的无参构造函数。
		new Tree();
	}
}

class Tree {
	
	int height;
	// 一个默认无参构造器
	Tree(){
		System.out.println("Planting a seedling");
		height = 0;
	}
	// 重载了默认构造器，带有一个参数。
	Tree(int initlalHeight){
		height = initlalHeight;
		System.out.println("Createing new Tree that is " + height + " feet tall");
	}
	//一个普通的方法
	void info() {
		System.out.println("Tree is " + height + " feet tall");
	}
	// 次方法重载了上面的方法，并传入一个String参数。
	void info(String s) {
		System.out.println(s + "Tree is " + height + " feet tall");
	}
}