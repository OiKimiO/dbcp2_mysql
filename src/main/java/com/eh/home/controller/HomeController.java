package com.eh.home.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eh.home.service.homeService;
import com.eh.home.vo.homeVo;

@Controller
public class HomeController {		
		@Inject homeService service;
		
		@RequestMapping(value = "/")
		public String first(Model model, Authentication authentication) {
			String url = "login";
			
			if (authentication != null) {
				url = "home";
				System.out.println("타입정보 : " + authentication.getClass());
				
				// 세션 정보 객체 반환
				WebAuthenticationDetails web = (WebAuthenticationDetails)authentication.getDetails();
				System.out.println("세션ID : " + web.getSessionId());
				System.out.println("접속IP : " + web.getRemoteAddress());

				// UsernamePasswordAuthenticationToken에 넣었던 UserDetails 객체 반환
				UserDetails userVO = (UserDetails) authentication.getPrincipal();
				System.out.println("ID정보 : " + userVO.getUsername());
				
				List<homeVo> vo = service.readDB();
				model.addAttribute("example", vo);
			}
			
				
			return url;			
		}		
		
	/*
	 * @RequestMapping(value = "/transSms") public String transSms(Model
	 * model,HttpServletRequest reqeust) throws Exception{
	 * service.transSms(reqeust); return "home"; }
	 */
		
}
