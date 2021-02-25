package com.yixiaobai.lp.ch6.housekeeping;

/**
 *  重载构造器与方法
 * @author liupeng
 *
 */
public class Overloading {
	
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			Tree t = new Tree(i);
			t.info();
			t.info("overloading method");
		}
		
		new Tree(); 
	}
}

/**
 * 
 *  重载的构造器，与重载的方法
 * @author liupeng
 *
 */
class Tree {
	
	int height;
	Tree() {
		System.out.println("Planting s seedling");
		height = 0;
	}
	
	Tree(int initalHeight) {
		
		height = initalHeight;
		System.out.println("Creating new Tree that is " + height + " feet tall");
	}
	
	void info() {
		
		System.out.println("Tree is " + height + " feet tall");
	}
	
	void info(String s) {
		
		System.out.println(s + ": Tree is " + height + "feet tall");
	}
}