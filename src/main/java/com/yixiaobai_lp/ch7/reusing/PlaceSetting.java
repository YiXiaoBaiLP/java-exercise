package com.yixiaobai_lp.ch7.reusing;

/**
 * 	结合使用组合和继承
 * @author liupeng
 *
 */
public class PlaceSetting extends Custom {

	private Spoon sp;
	private Fork frk;
	private Knife kn;
	private DinnerPlate pl;
	public PlaceSetting(int i) {
		super(i + 1);
		sp = new Spoon(i + 2);
		frk = new Fork(i + 3);
		kn = new Knife(i + 4);
		pl = new DinnerPlate(i +５);
		System.out.println("PlaceSetting constructor");
	}
	
	public static void main(String[] args) {
		PlaceSetting x = new PlaceSetting(9);
	}
	
}

class Plate {
	// 默认构造器
	public Plate(int i) {
		System.out.println("Plate constrctor");
	}
}

class DinnerPlate extends Plate {
	public DinnerPlate(int i ) {
		// 使用super可以调用基类的有参构造器
		super(i);
		System.out.println("DinnerPate constrctor");
	}
}

class Utensil {
	public Utensil(int i) {
		System.out.println("Utensil constrctor");
	}
}

class Spoon extends Utensil {
	public Spoon(int i) {
		super(i);
		System.out.println("Spoon constrctor");
	}
}

class Fork extends Spoon {
	public Fork(int i) {
		super(i);
		System.out.println("Fork constrctor");
	}
}

class Knife extends Utensil {
	public Knife(int i) {
		super(i);
		System.out.println("Knife constrctor");
	}
}

class Custom {
	public Custom(int i) {
		System.out.println("Custom constrctor");
	}
}