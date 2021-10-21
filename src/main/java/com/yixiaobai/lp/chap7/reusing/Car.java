package com.yixiaobai.lp.chap7.reusing;

/**
 * 	在组合与继承之间选择
 * 
 * @author liupeng
 *
 */
public class Car {
	
	public Engine engine = new Engine();
	public Wheel[] wheel = new Wheel[4];
	public Door 
		left = new Door(),
		right = new Door();
	public Car() {
		for(int i = 0; i < 4; i++) {
			wheel[i] = new Wheel();
		}
	}
	
	/**
	 * 	当使用new对象的时候就可以用 ’.’ 调出方法里面的成员变量
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Car car = new Car();
		car.left.window.rollup();
		car.wheel[0].inflate(72);
		System.out.println("我执行了嘛？");
	}
		
	

}

class Engine {
	// 开始
	public void start() {}
	// 发动
	public void rev() {}
	// 停止
	public void stop() {}
	
}

/**
 *  车轮
 * @author liupeng
 *
 */
class Wheel {
	public void inflate(int psi) {
		
	}
}

/**
 * 	窗户
 * @author liupeng
 *
 */
class Window {
	public void rollup() {}
	public void rolldown() {}
}

/**
 * 门 
 * @author liupeng
 *
 */
class Door {
	public Window window = new Window();
	public void open() {}
	public void close() {}
}
