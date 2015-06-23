package com.example.service;



import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hanandroidproject.R;

public class ParkPage extends LinearLayout {
	
	TextView pName_tv;
	Context mContext;
	ImageView weather_iv;
	TextView temp_tv;
	TextView pop_tv;
	

	public ParkPage(Context context) {
		super(context);
		init(context);
		// TODO Auto-generated constructor stub
	}
	
	private void init(Context context){
		mContext = context;
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.weather_page, this, true);
		
		pName_tv = (TextView)findViewById(R.id.weather_page_pName_tv);
		weather_iv = (ImageView)findViewById(R.id.weather_page_weather_iv);
		temp_tv=(TextView)findViewById(R.id.weather_page_temp_tv);
		pop_tv =(TextView)findViewById(R.id.weather_page_pop_tv);
		
		
	}
	
	public void setImage(int weatherId){
		weather_iv.setImageResource(weatherId);
	}
	
	public void setPname(String name){
		pName_tv.setText(name);
	}
	public void setTemp(String temp){
		temp_tv.setText(temp);
	}
	public void setPop(String pop){
		pop_tv.setText(pop);
	}
	

	
}
