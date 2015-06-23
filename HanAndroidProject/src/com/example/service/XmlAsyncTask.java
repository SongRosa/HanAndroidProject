package com.example.service;

import java.net.URL;
import java.util.ArrayList;

import android.os.AsyncTask;

public class XmlAsyncTask extends AsyncTask<String, String, ArrayList<WeatherDTO>> {
	
	ArrayList<WeatherDTO> list;
	WeatherDTO data;
	String[] parkAddr ={
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1150064100", // 강서 한강공원 강서구 방화 3동
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1174058000", // 광나루 한강공원 강동구 암사2동
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1144074000", // 난지 한강공원 마포구 상암동
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1121582000", // 뚝섬 한강공원 광진구 자양1동
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1144070000", // 망원 한강공원 마포구 망원2동
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1165057000", // 반포 한강공원 서초구 반포 2동
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1156055000", // 양화 한강공원 영등포구 당산1동
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1156054000", // 여의도 한강공원 영등포구 여의동
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1117063000", // 이촌 한강공원 용산구 이촌1동
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1171067000", // 잠실 한강공원 송파수 잠실 2동
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1165054000" // 잠원 한강공원 서초구 잠원동
			};

	@Override
	protected ArrayList<WeatherDTO> doInBackground(String... params) {
		try {
			XmlParser3 xmlp = new XmlParser3();
			
			for(int i=0;i<11;i++){
				URL parkUrl = new URL(parkAddr[i]);
				xmlp.xmlParser(parkUrl);
			}
			
			 list = xmlp.getList();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
