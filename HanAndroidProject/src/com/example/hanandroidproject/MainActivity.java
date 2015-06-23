package com.example.hanandroidproject;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.service.Main_NoticeAsyncTask;
import com.example.service.Main_NoticeDTO;
import com.example.service.Main_NoticeListAdapter;
import com.example.service.Main_NoticeTextItem;
import com.example.service.WeatherDTO;
import com.example.service.WeatherPagerAdapter;
import com.example.service.XmlAsyncTask;
import com.slidinglayer.SlidingLayer;
import com.slidinglayer.SlidingLayer.OnInteractListener;

public class MainActivity extends Activity {
	
	
	RelativeLayout main_layout;
	LinearLayout main_notice_layOut;
	ViewPager main_wheatherPager;
	TextView main_loginCheck_tv;
	Button main_closeMenu_Btn, main_signInOrMyPage_Btn, main_logout_Btn;
	ImageButton main_openMenu_Btn,  main_goParkNum1_iBtn, main_goParkNum2_iBtn,
			main_goParkNum3_iBtn, main_goParkNum4_iBtn, main_goParkNum5_iBtn,
			main_goParkNum6_iBtn, main_goParkNum7_iBtn, main_goParkNum8_iBtn,
			main_goParkNum9_iBtn, main_goParkNum10_iBtn, main_goParkNum11_iBtn,
			main_goBoard_iBtn;
	SlidingLayer main_slidingMenu;
	TableLayout main_tableLayout;
	ListView main_noticeList;
	Main_NoticeListAdapter noticeListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("onCreate",
				"_onCreate_onCreate_onCreate_onCreate_onCreate_onCreate_onCreate");

		XmlAsyncTask task = new XmlAsyncTask();

		ArrayList<WeatherDTO> list = null;
		try {
			list = task.execute().get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		main_tableLayout = (TableLayout)findViewById(R.id.main_tableLayout);
		main_notice_layOut = (LinearLayout)findViewById(R.id.main_notice_layOut);
		
		main_loginCheck_tv = (TextView)findViewById(R.id.main_loginCheck_tv);

		
		
		main_openMenu_Btn = (ImageButton) findViewById(R.id.main_openMenu_Btn);
		main_openMenu_Btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!main_slidingMenu.isOpened()) {
					main_slidingMenu.openLayer(true);
					
					
				} else if (main_slidingMenu.isOpened()) {
					main_slidingMenu.closeLayer(true);
					
				}

			}
		});
		
		main_closeMenu_Btn = (Button) findViewById(R.id.main_closeMenu_Btn);
		main_closeMenu_Btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (main_slidingMenu.isOpened()) {
					main_slidingMenu.closeLayer(true);
					
				}

			}
		});

		main_signInOrMyPage_Btn = (Button)findViewById(R.id.main_signInOrMyPage_Btn);
		main_logout_Btn = (Button)findViewById(R.id.main_logout_Btn);
		
		main_slidingMenu = (SlidingLayer) findViewById(R.id.main_slide_menu);
		main_slidingMenu.setOnInteractListener(new OnInteractListener() {
			
			@Override
			public void onOpened() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onOpen() {
				// TODO Auto-generated method stub
				Animation ani = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
				Animation ani2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_notice);
				main_tableLayout.startAnimation(ani);
				main_notice_layOut.startAnimation(ani2);
				main_tableLayout.setVisibility(View.INVISIBLE);
				
			}
			
			@Override
			public void onClosed() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onClose() {
				main_tableLayout.setVisibility(View.VISIBLE);
				Animation ani = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate2);
				Animation ani2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_notice2);
				main_notice_layOut.startAnimation(ani2);
				main_tableLayout.startAnimation(ani);
				
			}
		});

		main_wheatherPager = (ViewPager) findViewById(R.id.main_weatherPager);
		WeatherPagerAdapter adapter = new WeatherPagerAdapter(this, list);
		main_wheatherPager.setAdapter(adapter);

		setMainImageButton();
		
		checkLogin(false);
		
		setNoticeList();
		
		

	}
	
	private void setNoticeList(){
		
		main_noticeList = (ListView)findViewById(R.id.main_notice_List);
		
		noticeListAdapter = new Main_NoticeListAdapter(this);
		
		ArrayList<Main_NoticeDTO> main_nlist = new ArrayList<Main_NoticeDTO>();
		Main_NoticeAsyncTask main_n_task = new Main_NoticeAsyncTask();
		try {
			main_nlist = main_n_task.execute().get();
		} catch (Exception e) {
			// TODO: handle exception
		}
		for(int i= 0;i<main_nlist.size();i++){
			String n_number = main_nlist.get(i).getN_number();
			String n_subject=main_nlist.get(i).getN_subject();
			String n_regdate = main_nlist.get(i).getN_regdate();
			
			noticeListAdapter.addItem(new Main_NoticeTextItem(n_number, n_subject, n_regdate));
			System.out.println("어댑어댑");
		}
		
		
		main_noticeList.setAdapter(noticeListAdapter);
	}
	
	
	private void checkLogin(boolean b){
		if(b){
			main_loginCheck_tv.setText("나들이");
			main_signInOrMyPage_Btn.setText("마이페이지");
			main_logout_Btn.setText("로그아웃");
			
			
		}else{
			main_loginCheck_tv.setText("로그인 하세요");
			main_signInOrMyPage_Btn.setText("회원가입");
			main_logout_Btn.setText(" ");
		}
	}
	private void setMainImageButton() {

		main_goParkNum1_iBtn = (ImageButton) findViewById(R.id.main_goParkNum1_iBtn);
		main_goParkNum2_iBtn = (ImageButton) findViewById(R.id.main_goParkNum2_iBtn);
		main_goParkNum3_iBtn = (ImageButton) findViewById(R.id.main_goParkNum3_iBtn);
		main_goParkNum4_iBtn = (ImageButton) findViewById(R.id.main_goParkNum4_iBtn);
		main_goParkNum5_iBtn = (ImageButton) findViewById(R.id.main_goParkNum5_iBtn);
		main_goParkNum6_iBtn = (ImageButton) findViewById(R.id.main_goParkNum6_iBtn);
		main_goParkNum7_iBtn = (ImageButton) findViewById(R.id.main_goParkNum7_iBtn);
		main_goParkNum8_iBtn = (ImageButton) findViewById(R.id.main_goParkNum8_iBtn);
		main_goParkNum9_iBtn = (ImageButton) findViewById(R.id.main_goParkNum9_iBtn);
		main_goParkNum10_iBtn = (ImageButton) findViewById(R.id.main_goParkNum10_iBtn);
		main_goParkNum11_iBtn = (ImageButton) findViewById(R.id.main_goParkNum11_iBtn);
		main_goBoard_iBtn = (ImageButton) findViewById(R.id.main_goBoard_iBtn);

		main_goParkNum1_iBtn.setBackgroundResource(R.drawable.parkicon1_style);
		main_goParkNum2_iBtn.setBackgroundResource(R.drawable.parkicon2_style);
		main_goParkNum3_iBtn.setBackgroundResource(R.drawable.parkicon3_style);
		main_goParkNum4_iBtn.setBackgroundResource(R.drawable.parkicon4_style);
		main_goParkNum5_iBtn.setBackgroundResource(R.drawable.parkicon5_style);
		main_goParkNum6_iBtn.setBackgroundResource(R.drawable.parkicon6_style);
		main_goParkNum7_iBtn.setBackgroundResource(R.drawable.parkicon7_style);
		main_goParkNum8_iBtn.setBackgroundResource(R.drawable.parkicon8_style);
		main_goParkNum9_iBtn.setBackgroundResource(R.drawable.parkicon9_style);
		main_goParkNum10_iBtn.setBackgroundResource(R.drawable.parkicon10_style);
		main_goParkNum11_iBtn.setBackgroundResource(R.drawable.parkicon11_style);
		main_goBoard_iBtn.setBackgroundResource(R.drawable.board_style);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}