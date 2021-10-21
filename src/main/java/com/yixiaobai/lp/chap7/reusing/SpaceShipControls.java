package com.yixiaobai.lp.chap7.reusing;

/**
 * 	代理类：
 * 		第三种关系称为代理，Java并没有提供对他的直接支持。
 * 		这是继承于组合之间的中庸之道，因为我们将一个成员对象置于所要构造的类中（就像是组合），
 * 		但于此同时我们在新类中暴露了该成员对象的所有方法（就像是继承）。
 * 
 * @author liupeng
 *
 */
public class SpaceShipControls {
	
	void up(int velocity) {	}
	void down(int velocity) {}
	void left(int velocity) {}
	void right(int velocity) {}
	void forward(int veloity) {}
	void back(int veloity) {}
	void turboBoost() {}
}
