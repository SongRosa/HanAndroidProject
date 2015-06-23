package com.example.service;

import java.util.ArrayList;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.hanandroidproject.R;

public class WeatherPagerAdapter extends PagerAdapter {

	ArrayList<WeatherDTO> list;

	String[] pNames = { "강서", "광나루", "난지", "뚝섬", "망원", "반포", "양화", "여의도", "이촌",
			"잠실", "잠원" };
	int[] weatherIds = new int[11];
	String[] temps = new String[11];
	String[] pops = new String[11];
	Context mContext;

	public WeatherPagerAdapter() {
	}

	public WeatherPagerAdapter(Context context, ArrayList<WeatherDTO> list) {
		mContext = context;
		this.list = list;

		weatherIds = setWeatherId(list);
		for (int i = 0; i < 11; i++) {
			temps[i] = list.get(i).getTemp();
			temps[i] += "℃ ";
		}
		for (int i = 0; i < 11; i++) {
			pops[i] = list.get(i).getPop();
			pops[i] += "% ";
		}

	}

	@Override
	public int getCount() {

		return list.size();
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {

		ParkPage pager = new ParkPage(mContext);

		pager.setPname(pNames[position]);
		pager.setImage(weatherIds[position]);
		pager.setTemp(temps[position]);
		pager.setPop(pops[position]);

		container.addView(pager, 0);

		return pager;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0.equals(arg1);
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		notifyDataSetChanged();
		container.removeView((View) object);

	}

	@Override
	public void finishUpdate(ViewGroup container) {
		// TODO Auto-generated method stub
		super.finishUpdate(container);
	}

	@Override
	public void restoreState(Parcelable state, ClassLoader loader) {
		// TODO Auto-generated method stub
		super.restoreState(state, loader);
	}

	@Override
	public Parcelable saveState() {
		// TODO Auto-generated method stub
		return super.saveState();
	}

	@Override
	public void startUpdate(ViewGroup container) {
		// TODO Auto-generated method stub
		super.startUpdate(container);
	}

	private int[] setWeatherId(ArrayList<WeatherDTO> list) {
		int[] iArray = new int[11];
		int i;
		int sky;
		int pty;
		for (int j = 0; j < 11; j++) {
			sky = Integer.parseInt(list.get(j).getSky());
			pty = Integer.parseInt(list.get(j).getPty());

			if (pty == 0) {
				if (sky == 1) {
					i = R.drawable.fine;
				} else if (sky == 2) {
					i = R.drawable.few_cloudy2;
				} else if (sky == 3) {
					i = R.drawable.cloudy;
				} else {
					i = R.drawable.dark_couldy;
				}
			} else {
				if (pty == 1) {
					i = R.drawable.rain;
				} else {
					i = R.drawable.snow;
				}

			}
			iArray[j] = i;
		}
		return iArray;
	}

}
