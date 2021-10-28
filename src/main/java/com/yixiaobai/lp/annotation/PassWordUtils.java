package com.yixiaobai.lp.annotation;

import java.util.List;

/**
 * 使用自定义注解
 * @author yixiaobai
 * @version 1.0.0
 */
public class PassWordUtils {

	@UseCase(id = 50, description = "PassWord must contain at last one numeric")
	public boolean validatePassWord(String passWord) {
		return (passWord.matches("\\w*\\d\\w*"));
	}
	
	@UseCase(id = 48)
	public String encryptPassword(String password) {
		return new StringBuffer(password).reverse().toString();
	}
	
	@UseCase(id = 100, description = "New passwords can't equal previously use ones")
	public boolean checkForNewPassword(List<String> prevPasswords, String password) {
		return !prevPasswords.contains(password);
	}
}
