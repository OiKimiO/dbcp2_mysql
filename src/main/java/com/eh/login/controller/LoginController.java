package com.eh.login.controller;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eh.login.service.LoginService;
import com.eh.login.service.UserDetailsServiceCustom;

@RequestMapping("/login")
@Controller
public class LoginController {
	
	@Inject LoginService loginService;
	
	@RequestMapping(value = "/page")
	public String login(HttpServletRequest request,HttpServletResponse res, Model model) {						
		// 요청 시점의 사용자 URI 정보를 Session의 Attribute에 담아서 전달(잘 지워줘야 함)
		// 로그인이 틀려서 다시 하면 요청 시점의 URI가 로그인 페이지가 되므로 조건문 설정
		
		String uri = request.getHeader("Referer");
		if (!uri.contains("/login/page")) {
			request.getSession().setAttribute("prevPage",
					request.getHeader("Referer"));
		}
		
		model.addAttribute("msg", request.getAttribute("loginFailMsg"));	
		
		return "login";
	}
	
	@RequestMapping(value = "/join")
	public String join(Model model) {								
		return "join";
	}
	
	@RequestMapping(value = "/joinMember")
	public String joinMember(@RequestParam HashMap<String,Object> param) throws Exception {								
		loginService.insertMember(param);
		return "login";
	}
	
	
	
}
