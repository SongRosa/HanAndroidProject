package com.example.service;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hanandroidproject.R;



public class Main_NoticeView extends LinearLayout {
	
	private TextView main_n_number, main_n_subject, main_n_regdate;
	

	public Main_NoticeView(Context context, Main_NoticeTextItem item) {
		super(context);
		
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.main_notice_item, this, true);
		
		main_n_number = (TextView)findViewById(R.id.main_n_number);
		main_n_number.setText(item.getStrArray(0));
		main_n_subject = (TextView)findViewById(R.id.main_n_subject);
		main_n_subject.setText(item.getStrArray(1));
		main_n_regdate = (TextView)findViewById(R.id.main_n_regdate);
		main_n_regdate.setText(item.getStrArray(2));
	}
		
		public void setText(int index, String data){
			if(index==0){
				main_n_number.setText(data);
			}else if(index==1){
				main_n_subject.setText(data);
			}else if(index==2){
				main_n_regdate.setText(data);
			}else{
				throw new IllegalArgumentException();
			}
		
		
	}
	
	

}
