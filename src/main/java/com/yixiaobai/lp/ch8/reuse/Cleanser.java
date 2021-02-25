package com.yixiaobai.lp.ch8.reuse;

/**
 * 	继承语法
 * @author liupeng
 *
 */
public class Cleanser {
	
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
	
	// 重写toString()方法
	@Override
	public String toString() {
		return s;
	}
	
	public static void main(String[] args) {
		
		Cleanser clean = new Cleanser();
		clean.dilute();
		clean.apply();
		clean.scrub();
		System.out.println(clean);
		
	}
}
