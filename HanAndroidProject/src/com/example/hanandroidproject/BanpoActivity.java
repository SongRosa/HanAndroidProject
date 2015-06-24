package com.example.hanandroidproject;

import com.example.hanandroidproject.R;

import uk.co.senab.photoview.PhotoViewAttacher;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;

public class BanpoActivity extends Activity {
	ImageView m_imageView;
	PhotoViewAttacher mAttacher;
	
	public static final int REQUEST_CODE_ANOTHER =6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_banpo);
		
		m_imageView =(ImageView) findViewById(R.id.banpoView);
		mAttacher=new PhotoViewAttacher(m_imageView);
		mAttacher.setScaleType(ScaleType.FIT_XY);
	
	Button parkInfoButton=(Button)findViewById(R.id.parkInfoButton);
	Button boardButton=(Button)findViewById(R.id.boardButton);
		parkInfoButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),BanpoInfoActivity.class);
				startActivityForResult(intent, REQUEST_CODE_ANOTHER);
			}
		});

		boardButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						AnotherActivity.class);
				startActivityForResult(intent, REQUEST_CODE_ANOTHER);
			}
		});

	}
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	super.onActivityResult(requestCode, resultCode, data);
	
	if(requestCode==REQUEST_CODE_ANOTHER){
		Toast toast=Toast.makeText(getBaseContext(), "onActivityResult called with code : " +resultCode, Toast.LENGTH_LONG);
		toast.show();
		
		if(resultCode==Activity.RESULT_OK){
			String name=data.getExtras().getString("name");
			toast=Toast.makeText(getBaseContext(), "�ٸ� ��Ƽ��Ƽ���� ���޹��� �̸� : " + name, Toast.LENGTH_LONG);
			toast.show();
		}
	}
	
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.banpo, menu);
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
