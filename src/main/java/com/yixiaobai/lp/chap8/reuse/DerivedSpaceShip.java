package com.yixiaobai.lp.chap8.reuse;

public class DerivedSpaceShip extends SpaceShipControls{

	private String name;
	
	public DerivedSpaceShip(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static void main(String[] args) {
		DerivedSpaceShip derivedSpaceShip = 
				new DerivedSpaceShip("NSEA Protector");
		derivedSpaceShip.forward(100);
	}
}
