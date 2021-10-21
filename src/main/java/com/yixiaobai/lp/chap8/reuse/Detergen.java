package com.yixiaobai.lp.chap8.reuse;

/**
 *  继承
 * @author liupeng
 *
 */
public class Detergen extends Cleanser{
	
	// 覆写父类的方法
	@Override
	public void scrub() {
		append(" Detergen.scrub() ");
		// 调用父类的方法
		super.scrub();
	}
	
	// 在接口中添加方法：
	public void foam() {
		append(" foam() ");
	}
	
	public static void main(String[] args) {
		Detergen dete = new Detergen();
		dete.dilute();
		dete.apply();
		dete.scrub();
		dete.foam();
		System.out.println(dete);
		System.out.println("Testing base class: ");
		Cleanser.main(args);
	}
}
