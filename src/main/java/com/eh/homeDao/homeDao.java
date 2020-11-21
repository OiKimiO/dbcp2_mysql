package com.eh.homeDao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.eh.homeDao.homeServiceImpl;
import com.eh.homeVo.homeVo;

@Repository("homeDao")
public class homeDao{
	
	@Inject 
	private SqlSession sqlSession;
	
	
	public List<homeVo> readDB() {
		List<homeVo> selectEngineer = sqlSession.selectList("homeMap.selectDB");
		System.out.println("selectEngineer의 결과값 : "+selectEngineer);
	
		return selectEngineer;
	}
	
	
}
