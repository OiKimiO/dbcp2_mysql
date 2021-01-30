package com.eh.homcontroller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;

public class securityTest {

	@Setter(onMethod_ = @Autowired)
	private PasswordEncoder pwencoder;
	
	
	@Test
	public void testInserMember() {
	
		System.out.println(pwencoder.encode("member"));
	}
	
	
}