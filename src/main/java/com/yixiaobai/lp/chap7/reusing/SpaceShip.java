package com.yixiaobai.lp.chap7.reusing;

/**
 * 		使用 继承方式，不过这样会暴露SpaceShipControls类的所有方法。
 * 		在SpaceShipDelegation类中解决了此问题
 * @author liupeng
 *
 */
public class SpaceShip extends SpaceShipControls {

	private String name;
	public SpaceShip(String name) {
		this.name = name;
	}
	public String toString() {
		return name;
	}
	public static void main(String[] args) {
		SpaceShip spaceShip = new SpaceShip("NSEA Protector");
		spaceShip.forward(100);
	}
}
