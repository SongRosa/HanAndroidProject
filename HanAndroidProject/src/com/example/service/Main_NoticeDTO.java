package com.example.service;


public class Main_NoticeDTO {
	
	String n_number;
	String n_subject;
	String n_regdate;
	
	public Main_NoticeDTO(){}
	public Main_NoticeDTO(String num, String sub, String date ){
		n_number = num;
		n_subject = sub;
		n_regdate = date ;
	}
	
	public String getN_number() {
		return n_number;
	}
	public void setN_number(String n_number) {
		this.n_number = n_number;
	}
	public String getN_subject() {
		return n_subject;
	}
	public void setN_subject(String n_subject) {
		this.n_subject = n_subject;
	}
	public String getN_regdate() {
		return n_regdate;
	}
	public void setN_regdate(String n_regdate) {
		this.n_regdate = n_regdate;
	}
	@Override
	public String toString() {
		String str = "�ѹ�::"+n_number+" ����:: "+n_subject+"��¥::"+n_regdate;
		return str;
	}
	
	

}
