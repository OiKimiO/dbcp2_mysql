package com.eh.homeDao;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class manageSms {
	
	public void transSms(HttpServletRequest reqeust) throws Exception {
	    String api_key    = "NCSSTN4BP8WGD11Z";					// coolsms에서 인증받은 api
	    String api_secret = "C8CCFGOQJ3LFFPSR5RLPUELMPQNSFO6E"; // coolsms에서 인증받은 secretkey
	    Message coolsms   = new Message(api_key, api_secret);
	    String smsContent = (String) reqeust.getParameter("SmsContent");   // 문자내용	    
	    String receiver   = (String) reqeust.getParameter("Receiver");     // 수신자 	    	    
	    
	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", receiver);            
	    params.put("from", "01077364332"); 		   
	    params.put("type", "LMS");		   
	    params.put("text", smsContent);
	    params.put("app_version", "test app 1.2"); // application name and version

	    try {
	    	//send() 는 메시지를 보내는 함수  
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }
	  }
}
