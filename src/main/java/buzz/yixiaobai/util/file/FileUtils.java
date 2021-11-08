package buzz.yixiaobai.util.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Test;

public class FileUtils {
	
	@Test
	public void test() {
		String filePath = "D:\\ART\\ART\\BD\\Common Line\\05_Data Model\\40_IDCT初始数据配置\\权限\\questionnaire";
		List<File> quesFiles = getAllFileInDir(filePath, "DataPermissionQuestionnair*");
		quesFiles.forEach(fileName -> System.out.println(fileName.getName()));
	}
	
	/**
	 * 指定目录下查找文件
	 * @param filePath 文件路径
	 * @param fileName 包含此字符串的文件
	 * @return 查找到的文件
	 */
	public static List<File> getAllFileInDir(String filePath, String fileName){
		List<File> result = new ArrayList<>();
		File[] files = new File(filePath).listFiles();
		for (int i = 0; i < files.length; i++) {
			if(files[i].isDirectory()) {
				// 递归判断
				List<File> subFiles = getAllFileInDir(files[i].getAbsolutePath(), fileName);
				result.addAll(subFiles);
			}else if(isStrMatchWildCard(files[i].getName(), fileName)){
				result.add(files[i]);
			}
		}
		return result;
	}
	
	/**
	 * 判断文件名称是否包含某段字符串
	 * @param str 文件名称
	 * @param wildCard 是否包含此字符串
	 * @return 文件是否匹配
	 */
	public static boolean isStrMatchWildCard(String str, String wildCard) {
 		String patternStr = wildCard.replace("*", ".*");
		patternStr = patternStr.replace("?", ".{1}");
		return Pattern.compile(patternStr).matcher(str).matches();
	}
	
}
