package com.eh.home.vo;

public class homeVo {
	private String idtest_table;
	private String test_name;
	private String receiver;            
	private String Caller; 		   
	private String smsType;		   
	private String smsContent;

	public homeVo(String idtest_table, String test_name, String receiver, String caller, String smsType,
			String smsContent) {		
		this.idtest_table = idtest_table;
		this.test_name = test_name;
		this.receiver = receiver;
		this.Caller = caller;
		this.smsType = smsType;
		this.smsContent = smsContent;
	}

	public homeVo() {

	}

	public String getidtest_table() {
		return idtest_table;
	}

	public void setidtest_table(String idtest_table) {
		this.idtest_table = idtest_table;
	}

	public String getTest_name() {
		return test_name;
	}

	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getCaller() {
		return Caller;
	}

	public void setCaller(String caller) {
		Caller = caller;
	}

	public String getSmsType() {
		return smsType;
	}

	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}

	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}
	
	
	
}
