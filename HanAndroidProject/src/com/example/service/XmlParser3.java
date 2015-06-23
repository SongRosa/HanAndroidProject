package com.example.service;

import java.io.BufferedInputStream;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class XmlParser3 {
	
WeatherDTO entity;
	

	private ArrayList<WeatherDTO> list = new ArrayList<WeatherDTO>();
	
	public ArrayList<WeatherDTO> getList() {
		return list;
	}

	public void setList(ArrayList<WeatherDTO> list) {
		this.list = list;
	}
	public WeatherDTO getEntity() {
		return entity;
	}

	public void setEntity(WeatherDTO entity) {
		this.entity = entity;
	}
	
	public XmlParser3(){}

	public XmlParser3(URL url) throws Exception {}
	
	public void xmlParser(URL url) throws Exception {

		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		XmlPullParser xpp = factory.newPullParser();
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		xpp.setInput(bis, "utf-8");

		String tag = null;
		String day = null, temp = null, sky = null, pty = null, pop = null;

		int eventType = xpp.getEventType();
		while (eventType != XmlPullParser.END_DOCUMENT) {
			if (eventType == XmlPullParser.START_TAG) {
				tag = xpp.getName();
			} else if (eventType == XmlPullParser.TEXT) {
				if (tag.equals("day") && !xpp.getText().contains("\n")) {

					day = xpp.getText();
				} else if (tag.equals("temp") && !xpp.getText().contains("\n")) {
					temp = xpp.getText();
				} else if (tag.equals("sky") && !xpp.getText().contains("\n")) {
					sky = xpp.getText();
				} else if (tag.equals("pty") && !xpp.getText().contains("\n")) {
					pty = xpp.getText();
				} else if (tag.equals("pop") && !xpp.getText().contains("\n")) {
					pop = xpp.getText();
				}

			} else if (eventType == XmlPullParser.END_TAG) {
				tag = xpp.getName();

				if (tag.equals("data")) {
					break;
				}

				if (tag.equals("s06")) {
					entity = new WeatherDTO();
					entity.setDay(day);
					entity.setTemp(temp);
					entity.setSky(sky);
					entity.setPty(pty);
					entity.setPop(pop);
		
					list.add(entity);
				}
			}
			eventType = xpp.next();

		}
	}

}
