package com.example.service;

import java.io.BufferedInputStream;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class Main_NoticeParser {
Main_NoticeDTO entity;
	

	private ArrayList<Main_NoticeDTO> list = new ArrayList<Main_NoticeDTO>();
	
	public ArrayList<Main_NoticeDTO> getList() {
		return list;
	}

	public void setList(ArrayList<Main_NoticeDTO> list) {
		this.list = list;
	}
	public Main_NoticeDTO getEntity() {
		return entity;
	}

	public void setEntity(Main_NoticeDTO entity) {
		this.entity = entity;
	}
	
	public Main_NoticeParser(){}

	public Main_NoticeParser(URL url) throws Exception {}
	
	public void xmlParser(URL url) throws Exception {

		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		XmlPullParser xpp = factory.newPullParser();
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		xpp.setInput(bis, "utf-8");

		String tag = null;
		String n_number = null , n_subject = null, n_regdate = null;

		int eventType = xpp.getEventType();
		while (eventType != XmlPullParser.END_DOCUMENT) {
			if (eventType == XmlPullParser.START_TAG) {
				tag = xpp.getName();
			} else if (eventType == XmlPullParser.TEXT) {
				if (tag.equals("n_number") && !xpp.getText().contains("\n")) {

					n_number = xpp.getText();
				} else if (tag.equals("n_subject") && !xpp.getText().contains("\n")) {
					n_subject = xpp.getText();
				} else if (tag.equals("n_regdate") && !xpp.getText().contains("\n")) {
					n_regdate = xpp.getText();
				} 

			} else if (eventType == XmlPullParser.END_TAG) {
				tag = xpp.getName();

				if (tag.equals("main_notice")) {
					break;
				}

				if (tag.equals("data")) {
					entity = new Main_NoticeDTO();
					entity.setN_number(n_number);
					entity.setN_subject(n_subject);
					entity.setN_regdate(n_regdate);
					System.out.println("ÆÄ¼­ ::"+entity);
		
					list.add(entity);
				}
			}
			eventType = xpp.next();

		}
	}

}
