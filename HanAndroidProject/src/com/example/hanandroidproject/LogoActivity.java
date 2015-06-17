package com.example.hanandroidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LogoActivity extends Activity{
	Handler handler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logo);
		
		handler = new Handler();
		handler.postDelayed(irun, 2000);
	}
	
	Runnable irun = new Runnable() {
		
		@Override
		public void run() {
			Intent it = new Intent(LogoActivity.this, MainActivity.class);
			it.putExtra("auto", 1);
			startActivity(it);
			finish();
		}
	};

}
