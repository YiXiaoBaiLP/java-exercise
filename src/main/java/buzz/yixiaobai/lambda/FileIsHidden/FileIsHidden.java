package buzz.yixiaobai.lambda.FileIsHidden;

import java.io.File;
import java.io.FileFilter;

/**
 * 	查看文件目录下是否有隐藏文件
 * @author yixiaobai
 *
 */
public class FileIsHidden {

	public static void main(String[] args) {
		
		// java8 之前的做法
		// 使用匿名类来判断当前目录下是否有隐藏文件
		File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
			// 判断此文件是不是一个隐藏文件
			public boolean accept(File file) {
				return file.isHidden();
			}
		});
		 
		System.out.println("Java8 之前的做法，当前目录下有几个隐藏文件：" + hiddenFiles.length);
		for(File fileName : hiddenFiles) {
			System.out.println("隐藏的文件名称。为：" + fileName.getName());
		}
		
		// Java8 的做法
		File[] hiddenFiles8 = new File(".").listFiles(File :: isHidden);
		System.out.println("Java8的做法，当前目录下有几个隐藏文件：" + hiddenFiles8.length);
		for(File fileName : hiddenFiles8) {
			System.out.println("隐藏的文件名称为：" + fileName.getName());
		}
	}
}
