package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState){	
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);
		
		//��ȡ��һ���������������
		/*
		Intent intent = getIntent();
		String data = intent.getStringExtra("extra_data");
		Log.d("SecondActivity", data);
		*/
	    
		//���ڴ򿪲��Ž���İ�ť����
		Button CallPhone = (Button)findViewById(R.id.call_phone);
		CallPhone.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){		//����ϵͳ���������ҳ
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:10086"));
				startActivity(intent);
			}
		});	
		
		Button back = (Button)findViewById(R.id.back);
		back.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){		
				Intent intent = new Intent();
				intent.putExtra("data_return", "Hello FirstActivity!");
				setResult(RESULT_OK, intent);
				finish();
			}
		});
		
	}
}
