package com.eh.home.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.eh.home.vo.homeVo;

public interface homeService {

	public List<homeVo> readDB();

	public void transSms(HttpServletRequest reqeust) throws Exception;

}
