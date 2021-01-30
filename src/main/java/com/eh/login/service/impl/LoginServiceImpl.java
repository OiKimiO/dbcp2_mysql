package com.eh.login.service.impl;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eh.login.dao.LoginDao;
import com.eh.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Inject 
	LoginDao loginDao;
	
	@Inject
	private BCryptPasswordEncoder pwEncoder;
	
	@Override
	public void insertMember(HashMap<String, Object> param) throws Exception {
		String password = (String) param.get("userPw");
		String encodePw = pwEncoder.encode(password);		
		param.put("userPw", encodePw);
		loginDao.insertMember(param);
		loginDao.insertAuthority(param);
	}
	
}
