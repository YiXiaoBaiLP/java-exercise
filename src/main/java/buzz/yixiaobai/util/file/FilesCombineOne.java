package buzz.yixiaobai.util.file;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilesCombineOne {

	/** 文件路径 */
	static final String FILE_PATH = "";
	/** 文件结果输出路径 */
	static final String FILE_OUT_PATH = "";
	/** 文件后缀 */
	static final String FILE_SUFFIX = ".properties";
	/** 记录文件数 */
	static int fileAllCount = 0;
	/** */
	static int fieldCount = 0;
	/** 文件读取 */
	static BufferedReader readFile = null;
	/** 文件写入 */
	static BufferedWriter writerFile = null;
	/** 需要查找的字符串 */
	static final String[] CONTAINS_STRING_ALL = {
			"NOT_OUT_BANK_CUST_FLG",
			"notout"
	};
	
	@Test
	public void test() throws IOException {
		try {
			if(readFile(FILE_PATH)) {
				System.out.println("文件读取完成；共读取了：" + fileAllCount + "个文件。");
				System.out.println("包含的字段共出现了：" + fieldCount + "次。");
			}
		} catch (IOException e) {
			System.err.println("文件读取失败");
		}finally {
			readFile.close();
			writerFile.close();
		}
	}
	
	public static boolean readFile(String filePath)  throws IOException{
		// 获取所有文件路径
		File[] filesPath = new File(filePath).listFiles();
		
		for (File file : filesPath) {
			// 过滤隐藏文件
			if(!file.isHidden()) {
				// 判断是否为一个目录
				if(file.isDirectory()) {
					readFile(file.getPath());
				}else if(file.isFile()) {
					fileAllCount++;
					writeFile(file);
				}else {
					System.err.println("文件名称：" + file.getName() +" 文件读取失败！！！");
					return false;
				}
			}
		}
		return true;
	}
	
	private static void writeFile(File filePath) throws IOException {
	
		if(null == writerFile) {
			writerFile = new BufferedWriter(new FileWriter(FILE_OUT_PATH));
		}
		readFile = new BufferedReader(new FileReader(filePath));
		String line = null;
		boolean bl = false;
		int count = 0;
		while((line = readFile.readLine()) != null) {
			count++;
			for(String str : CONTAINS_STRING_ALL) {
				bl = line.contains(str);
				if(bl) {
					fieldCount++;
					writerFile.write(filePath.toString() + " \r\n" + "包含的字符串是“" + 
					str + "”；在" + count + "行：" + line);
					writerFile.newLine();
				}
			}
		}
	}
}
