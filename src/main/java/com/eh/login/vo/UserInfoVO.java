package com.eh.login.vo;

public class UserInfoVO {
	private String userId;
	private String userPw;
	
	public UserInfoVO(String userId, String userPw) {		
		this.userId = userId;
		this.userPw = userPw;
	}

	public UserInfoVO() {
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	@Override
	public String toString() {
		return "UserInfoVO [userId=" + userId + ", userPw=" + userPw + "]";
	}
	
	
	
}
