package com.yixiaobai.lp.ch8.reuse;

/**
 * 	委托
 * 		Java不直接支持的第三种重用关系称为委托。
 * 		这介于继承和组合之间，因为你将一个成员对象放在正在构建的类中(比如组合)，
 * 		但同时又在新类中公开来自成员对象的所有方法(比如继承)。
 * @author liupeng
 *
 */
public class SpaceShipControls {
	
	void up(int velocity) {}
	void down(int velocity) {}
	void left(int velocity) {}
	void right(int velociry) {}
	void forward(int velociry) {}
	void back(int velocity) {}
	void turboBoost() {}

}
