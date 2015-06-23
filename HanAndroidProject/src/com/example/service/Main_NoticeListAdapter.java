package com.example.service;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class Main_NoticeListAdapter extends BaseAdapter {
	
	private Context mContext;
	
	private List<Main_NoticeTextItem> items = new ArrayList<Main_NoticeTextItem>();
	
	public void addItem(Main_NoticeTextItem item){
		items.add(item);
	}
	public void setListItems(List<Main_NoticeTextItem> list){
		items=list;
	}
	
	
	
	public Main_NoticeListAdapter() {	}
	public Main_NoticeListAdapter(Context context) {
		mContext = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Main_NoticeView noticeView;
		if(convertView==null){
			noticeView = new Main_NoticeView(mContext, items.get(position));
		}else{
			noticeView = (Main_NoticeView)convertView;
		}
		
		noticeView.setText(0, items.get(position).getStrArray(0));
		noticeView.setText(1, items.get(position).getStrArray(1));
		noticeView.setText(2, items.get(position).getStrArray(2));
		
		return noticeView;
	}

}
