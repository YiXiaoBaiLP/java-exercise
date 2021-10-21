package com.yixiaobai.lp.chap8.reuse;

/**
 * 
 * java委托的类
 *  	使用 JetBrains Idea IDE 可以自动生成此类
 * @author liupeng
 *
 */
public class SpaceShipDelegation {
	
	private String name;
	
	public SpaceShipDelegation(String name) {
		
		this.name = name;
	}
	
	private SpaceShipControls controls = 
			new SpaceShipControls();
	
	// Delegated methods:
	// 可以使用IDEA工具生成
	public void back(int velocity) {
		controls.back(velocity);
	}

	public void down(int velocity) {
		controls.down(velocity);
	}

	public void forward(int velocity) {
		controls.forward(velocity);
	}

	public void left(int velocity) {
		controls.left(velocity);
	}

	public void right(int velocity) {
		controls.right(velocity);
	}

	public void turboBoost() {
		controls.turboBoost();
	}

	public void up(int velocity) {
		controls.up(velocity);
	}
	
	public static void main(String[] args) {
		SpaceShipDelegation protector = 
				new SpaceShipDelegation("NSEA Protector");
		protector.forward(100);
	}

}
