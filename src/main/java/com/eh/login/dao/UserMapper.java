package com.eh.login.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.eh.home.vo.homeVo;
import com.eh.login.vo.UserInfoVO;

@Repository
public class UserMapper{
	
	@Inject 
	private SqlSession sqlSession;	

	public List<String> selectUserAuthOne(String inputUserId) {
		return sqlSession.selectList("loginMap.selectUserAuthOne",inputUserId);
	}

	public UserInfoVO selectUserInfoOne(String inputUserId) {
		return sqlSession.selectOne("loginMap.selectUserInfoOne",inputUserId);
	}
}
