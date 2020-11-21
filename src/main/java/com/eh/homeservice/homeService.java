package com.eh.homeservice;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.eh.homeVo.homeVo;

public interface homeService {

	public List<homeVo> readDB();

	public void transSms(HttpServletRequest reqeust) throws Exception;

}
