package com.eh.home.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.eh.home.dao.homeDao;
import com.eh.home.service.homeService;
import com.eh.home.vo.homeVo;
import com.eh.msg.manageSms;

@Service("homeService")
public class homeServiceImpl implements homeService {
	
	@Resource(name="homeDao")
	private homeDao homeDao;

	@Override
	public List<homeVo> readDB() {	
		return homeDao.readDB();
	}

	@Override
	public void transSms(HttpServletRequest reqeust) throws Exception {
		manageSms sms = new manageSms();		
		sms.transSms(reqeust);
	}
	
	

}
