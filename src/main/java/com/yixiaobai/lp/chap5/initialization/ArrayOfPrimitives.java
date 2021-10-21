package com.yixiaobai.lp.chap5.initialization;
/**
 * 
 * 	创建一个数组,并初始化
 * 	数组是一个引用类型, 可以将一个数组的引用赋值给另一个变量.
 * 
 * @author liupeng
 */
public class ArrayOfPrimitives {

	public static void main(String[] args) {
		// 定义了一个数组,它的引用为 a1,并对其进行了初始化操作.
		int[] a1 = {1, 2, 3, 4, 5, 6, 7};
		// 定义了一个数组,它的引用为 a2 ,没有进行初始操作.
		int[] a2;
		// 将 a1 的引用赋值给 a2 .
		a2 = a1;
		// 将 a2 数组中的所有元素进行 +1
		for(int i = 0; i < a2.length; i++) {
			a2[i] = a2[i] + 1;
		}
		// 打印出 a1 中的所有元素,此处与 a2 中 +1 后的值一样.
		for(int i = 0 ; i < a1.length; i++) {
			
			System.out.println("a1[" + i +"] = " + a1[i]);
		}
	}
}
