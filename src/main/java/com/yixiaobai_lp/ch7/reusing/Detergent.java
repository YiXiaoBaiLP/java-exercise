package com.yixiaobai_lp.ch7.reusing;

/**
 *  继承语法
 *  	子类
 * @author liupeng
 *
 */
public class Detergent extends Cleanser{

	public void scrub() {
		append(" Detergent.scrub() ");
		// 使用super关键子可以明确指出，这个方法是父类的方法。
		super.scrub();
	}
	// Add methods to the interface;
	public void foam() {
		append(" foam() ");
	}
	
	public static void main(String[] args) {
		Detergent x = new Detergent();
		x.dilute();
		x.apply();
		x.scrub();
		x.foam();
		System.out.println("Testing base class;");
		Cleanser.main(args);
	}
	
}
/**
 * 父类 
 * @author liupeng
 *
 */
class Cleanser {
	
	private String s = "Cleanser";
	public void append(String a) {
		s += a;
	}
	public void dilute() {
		append(" dilute() ");
	}
	public void apply() {
		append(" apply() ");
	}
	public void scrub() {
		append(" scrub() ");
	}
	public String toString() {
		return s;
	}
	
	public static void main(String[] args) {
		Cleanser x = new Cleanser();
		x.dilute();
		x.apply();
		x.scrub();
		System.out.println(x);
	}
	
}
