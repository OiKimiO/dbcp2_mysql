package com.eh.login.dao;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {
	
	@Inject 
	private SqlSession sqlSession;
	
	public void insertMember(HashMap<String, Object> param) throws Exception{
		sqlSession.insert("loginMap.join",param);
	}

	public void insertAuthority(HashMap<String, Object> param) throws Exception {
		sqlSession.insert("loginMap.auth",param);
	}

}
