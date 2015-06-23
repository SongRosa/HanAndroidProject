package com.example.service;

import java.net.URL;
import java.util.ArrayList;

import android.os.AsyncTask;

public class XmlAsyncTask extends AsyncTask<String, String, ArrayList<WeatherDTO>> {
	
	ArrayList<WeatherDTO> list;
	WeatherDTO data;
	String[] parkAddr ={
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1150064100", // ���� �Ѱ����� ������ ��ȭ 3��
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1174058000", // ������ �Ѱ����� ������ �ϻ�2��
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1144074000", // ���� �Ѱ����� ������ ��ϵ�
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1121582000", // �Ҽ� �Ѱ����� ������ �ھ�1��
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1144070000", // ���� �Ѱ����� ������ ����2��
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1165057000", // ���� �Ѱ����� ���ʱ� ���� 2��
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1156055000", // ��ȭ �Ѱ����� �������� ���1��
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1156054000", // ���ǵ� �Ѱ����� �������� ���ǵ�
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1117063000", // ���� �Ѱ����� ��걸 ����1��
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1171067000", // ��� �Ѱ����� ���ļ� ��� 2��
			"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1165054000" // ��� �Ѱ����� ���ʱ� �����
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
