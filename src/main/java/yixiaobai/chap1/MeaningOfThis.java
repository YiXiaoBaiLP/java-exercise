package yixiaobai.chap1;

/**	
 * 	匿名类的谜题
 * 	下面代码执行的代码执行的时候到底输出多少？
 * @author yixiaobai
 *
 */
public class MeaningOfThis {

	public final int value = 4;
	public void doIt() {
		int value = 6;
		Runnable r = new Runnable() {
			// 匿名类
			public final int value = 5;
			public void run() {
				int value = 10;
				// this.value 指向的是类的value。
				System.out.println(this.value);
			}
		};
		// 调用匿名类中的方法。
		r.run();
	}
	public static void main(String... args) {
		MeaningOfThis m = new MeaningOfThis();
		m.doIt();
	}
}
