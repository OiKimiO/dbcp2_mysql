package com.eh.homcontroller;

import static org.junit.Assert.*;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;

public class DBEncrypt {

	@Test
	public void test() {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor(); 
		encryptor.setPassword("somePassword"); 
		encryptor.setAlgorithm("PBEWithMD5AndDES"); 
		String str = "jdbc:log4jdbc:mysql://localhost:3306/test1?useSSL=false&useUnicode=yes&characterEncoding=utf8&serverTimezone=Asia/Seoul"; 		
		String encStr = encryptor.encrypt(str); 
		String decStr = encryptor.decrypt(encStr); 
		System.out.println("비밀번호 암호화 ::: " +encStr +" :: " + str);

	}

}
