package com.yixiaobai.lp.chap5.initialization;

/** 
 * 可变参数列表
 * @author liupeng
 * @version 1.0.0
 */
class A {}
public class NewVarArgs {

	static void printArray(Object... objects ) {
		for(Object obj : objects) {
			System.out.print(obj + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		printArray(new Integer(47), new Float(3.14), new Double(11.11));
		printArray(47, 3.14F, 11.11);
		printArray("one", "two", "three");
		printArray(new A(), new A(), new A());
		printArray((Object[])new Integer[] {1, 2, 3, 4, 5});
	}
}