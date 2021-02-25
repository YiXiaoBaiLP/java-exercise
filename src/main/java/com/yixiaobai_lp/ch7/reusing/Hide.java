package com.yixiaobai_lp.ch7.reusing;

/**
 * 	名称屏蔽
 *  使用注解	@Override 来复写父类中的某个方法，返回值。参数都不变，改变其核心逻辑。
 * @author liupeng
 *
 */
public class Hide {

	public static void main(String[] args) {
		Bart b = new Bart();
		b.doh(1);
		b.doh('x');
		b.doh(new Milhouse());
	}
}

class Homer {
	
	char doh(char c) {
		System.out.println("doh(char)");
		return 'd';
	}
	
	float doh(float f) {
		System.out.println("doh(float)");
		return 1.0f;
	}
}

class Milhouse {}

class Bart extends Homer {
	
	void doh(Milhouse m) {
		System.out.println("doh(Milhouse)");
	}
	
	@Override
	char doh(char c) {
		System.out.println(c);
		return '1';
	}
}
