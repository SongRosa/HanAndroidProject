package com.example.service;

public class Main_NoticeTextItem {
	
	private String[] strArray;
	
	public Main_NoticeTextItem(){}
	public Main_NoticeTextItem(String[] strObj){
		strArray = strObj;
	}
	public Main_NoticeTextItem(String str01, String str02, String str03){
		strArray = new String[3];
		strArray[0] = str01;
		strArray[1] = str02;
		strArray[2] = str03;
	}
	public String[] getStrArray() {
		return strArray;
	}
	public String getStrArray(int index) {
		if(strArray==null||index>=strArray.length){
		return null;
		}
		return strArray[index];
	}
	public void setStrArray(String[] strArray) {
		this.strArray = strArray;
	}
	
	

}
