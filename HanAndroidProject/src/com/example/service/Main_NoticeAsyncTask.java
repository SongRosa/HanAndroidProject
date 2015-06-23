package com.example.service;

import java.net.URL;
import java.util.ArrayList;

import android.os.AsyncTask;

public class Main_NoticeAsyncTask extends AsyncTask<String, String, ArrayList<Main_NoticeDTO>> {

	ArrayList<Main_NoticeDTO> list;
	
	
	@Override
	protected ArrayList<Main_NoticeDTO> doInBackground(String... params) {
		Main_NoticeParser parser = new Main_NoticeParser();
		try {
			URL url = new URL("http://192.168.0.40:8983/HanOracle/test/main_noticeSelect.jsp");
			parser.xmlParser(url);
			
			list = parser.getList();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}

}
