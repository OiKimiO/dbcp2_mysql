package com.eh.login.handler;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
			
			// 디폴트 URI
			String uri = "/"; 
			
			// Security가 요청을 가로챈 경우 사용자가 원래 요청했던 URI 정보를 저장한 객체
			RequestCache requestCache = new HttpSessionRequestCache();
			SavedRequest savedRequest = requestCache.getRequest(request, response);
			
			
			/* 로그인 버튼 눌러 접속했을 경우의 데이터 get */
			String prevPage = (String) request.getSession().getAttribute("prevPage");
			
			if (prevPage != null) {
				request.getSession().removeAttribute("prevPage");
			}
			
			// null이 아니라면 강제 인터셉트 당했다는 것
			if (savedRequest != null) {
				uri = savedRequest.getRedirectUrl();

			// ""가 아니라면 직접 로그인 페이지로 접속한 것
			} else if (prevPage != null && !prevPage.equals("")) {
				uri = prevPage;
			}

			// 세 가지 케이스에 따른 URI 주소로 리다이렉트
			response.sendRedirect(uri);
		
	}
}