package com.yixiaobai.lp.chap8.reuse;

/**
 * 		结合组合与继承
 * @author liupeng
 *
 */
public class PlaceSetting extends Utensil{

	private Spoon sp;
	private Fork frk;
	private Knife kn;
	private DinnerPlate pl;

	// 有参的构造函数
	public PlaceSetting(int i) {

		// 初始化基类的有参构造,并初始化。
		super(i + 1);
		sp = new Spoon(i + 2);
		frk = new Fork(i + 3);
		kn = new Knife(i + 4);
		pl = new DinnerPlate(i + 5);
		System.out.println(" PlaceSetting constructor ");
	}

	public static void main(String[] args) {

		// 调用有参构造，初始化基类的构造器
		PlaceSetting x = new PlaceSetting(9);
	}
}

class Plate {
	Plate(int i){
		System.out.println(" Plate constructor ");
	}
}

class DinnerPlate extends Plate {
	
	public DinnerPlate(int i) {
		super(i);
		System.out.println(" DinnerPlate constructor ");
	}
}	
 
class Utensil {

	Utensil(int i){
		System.out.println(" Utensil constructor ");
	}
}

class Spoon extends Utensil{

	Spoon(int i ){
		super(i);
		System.out.println(" Spoon constructor ");
	}
}

class Fork extends Utensil {

	Fork(int i){
		super(i);
		System.out.println(" Fork constructor ");
	}
}

class Knife extends Utensil {

	Knife(int i){
		super(i);
		System.out.println(" Knife constructor ");
	}
}

class Custom {

	Custom(int i) {
		System.out.println( " Custom constructor ");
	}
}
