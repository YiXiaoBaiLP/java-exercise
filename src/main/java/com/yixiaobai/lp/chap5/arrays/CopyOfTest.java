package com.yixiaobai.lp.chap5.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 使用反射便携泛型数组代码
 * @author yixiaobai
 *
 */
public class CopyOfTest {

	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		a = (int[]) goodCopyOf(a, 10);
		System.out.print(Arrays.toString(a));
		
		String[] b = {"Tom", "Dick", "Harry"};
		b = (String[]) goodCopyOf(b, 10);
		System.out.println(Arrays.toString(b));
		
		System.out.println("");
		b = (String[]) badCopyOf(b, 10);
		
	}
	
	/**
	 * This method attempts to fgrow an array by allocating a new array and copying all elements
	 * @param a the array to grow
	 * @param newLength the new length
	 * @return a larger array that contains all elements of a. However, the returned array has
	 * type Object[], not the same type as a
	 */
	public static Object[] badCopyOf(Object[] a, int newLength) { // not useful
		
		Object[] newArray = new Object[newLength];
		System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
		return newArray;
	}
	
	/**
	 * This method grows an array by allocating a new array of the same type and
	 * copying all elements.
	 * @param a the array to grow, This can be an object array or a primitive
	 * @param newLength 
	 * @return a larger array that contains all elements of a
	 */
	public static Object goodCopyOf(Object a, int newLength) {
		
		Class<?> cl = a.getClass();
		// 判断此类型是否是一个集合类型
		if(!cl.isArray()) {
			return null;
		}
	    // 获取具体的参数类型
		Class<?> componentType = cl.getComponentType();
	    // 获取集合的长度
		int length = Array.getLength(a);
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
		return newArray;
	}
}
