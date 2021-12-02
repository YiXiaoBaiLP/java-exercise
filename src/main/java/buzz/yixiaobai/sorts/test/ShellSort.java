package buzz.yixiaobai.sorts.test;

/**
 * 希尔排序
 * @author yixiaobai
 *
 */
public class ShellSort {
	public static void main(String[] args) {
		
		int[] nums = {49, 38, 65, 97, 76, 
				13, 27, 49, 78, 34, 12, 64, 1 };
		
		System.out.println("排序之前：");
		for(int i : nums) {
			System.out.print(i + " ");
		}
		
		int num = nums.length;
		while(true) {
			num = num/2;
			for(int x = 0; x < num; x++) {
				for(int i = x + num; i < nums.length; i = i + num) {
					int temp = nums[i];
					int j;
					for(j = i - num; j >= 0 &&
							nums[j] > temp; j = j - num) {
						nums[j + num] = nums[j];
					}
					nums[j + num] = temp;
					System.out.print("\r\n" + temp);
				}
			}
			if(num == 1) {
				break;
			}
		}
		System.out.println("-------------------------------------");
		System.out.println("排序之后：");
		for(int i : nums) {
			System.out.println(i + " ");
		}
	}
}