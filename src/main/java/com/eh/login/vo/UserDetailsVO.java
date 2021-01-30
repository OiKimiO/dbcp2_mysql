package com.eh.login.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/* Spring Security 로그인을 위한 UserDetails VO 객체 */
public class UserDetailsVO implements UserDetails {

	// 안만들어도 상관없지만 Warning이 발생함
	private static final long serialVersionUID = 1L;

	private String username; // ID
	private String password; // PW
	private List<GrantedAuthority> authorities;

	// setter
	public void setUsername(String username) {
		this.username = username;
	}

	// setter
	public void setPassword(String password) {
		this.password = password;
	}

	/* 권한을 담는 setter
	   1. 권한을 담는 로직
	    ** 권한의 경우 GrantedAuthority 인터페이스를 구현한 SimpleGrantedAuthority 클래스에 하나씩 담아주면 됨
	      -- SimpleGrantedAhority에 권한을 담는 방법 : new SimpleGrantedAuthority(권한명)
	    ** 권한의 경우 여러가지가 담길 수 있음으로 데이터 타입이 list로 되어 있음
	    ** 리스트에 담기는 배열의 데이터 타입은 String으로 구성되어 있음
	 */
	// setter
	public void setAuthorities(List<String> authList) {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (int i = 0; i < authList.size(); i++) {
			authorities.add(new SimpleGrantedAuthority(authList.get(i)));
		}

		this.authorities = authorities;
	}

	@Override
	// ID
	public String getUsername() {

		return username;
	}

	@Override
	// PW
	public String getPassword() {

		return password;
	}

	@Override
	// 권한
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}
	/* 계정 예외 처리 설정(만들면서 확인)
	     ** isAccountNonExpired()     : DB에서 계정의 만료여부(컬럼)를 확인
	     ** isAccountNonLocked()      : DB에서 계정의 잠김(컬럼)을 확인
	     ** isCredentialsNonExpired() : DB에서 패스워드의 잠금(컬럼)을 확인 
	     ** isEnabled()               : DB에서 계정의 잠금(컬럼)을 확인
	       -- 만료가 되었다면 false, 만료가 되지 않았다면 true
 
	 */
	@Override
	// 계정이 만료(계정의 사용기간?) 되지 않았는가?
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	// 계정이 잠기지 않았는가?
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	// 패스워드가 만료되지 않았는가?
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	// 계정이 활성화 되었는가?
	public boolean isEnabled() {

		return true;
	}
}