package com.yixiaobai.lp.chap5.initialization;

/***
 * 
 * 	使用this关键字类传递对象。
 * @author liupeng
 * @version 1.0.0
 */

public class PassingThis {
	
	public static void main(String[] args) {
		Apple apple = new Apple();
		new Person().eat(apple);
	}
}

@SuppressWarnings("unused")
class Person{
	public void eat(Apple apple) {

		Apple peeled = apple.getPeeled();
		System.out.println("Yummy");
	}
}

class Peeler{

	static Apple peel(Apple apple) {
		return apple;
	}
}

class Apple{
	
	Apple getPeeled() {
		//return Peeler.peel(new Apple());
		// this 代表当前类
		return Peeler.peel(this);
	}
}
