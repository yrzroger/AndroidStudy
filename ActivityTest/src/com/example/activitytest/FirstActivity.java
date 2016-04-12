package com.example.activitytest;//package name

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);	//call superclass'onCreate() method
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);
		
		Button exit = (Button)findViewById(R.id.exit);
		exit.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				finish();//���ٻ
			}
		});
		
		Button StartSecondActivity = (Button)findViewById(R.id.start_second_activity);
		StartSecondActivity.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				//Toast.makeText(FirstActivity.this, "You clicked Button1", Toast.LENGTH_SHORT).show();
				//��ʾIntent,��ȷָ��Ŀ����������һ�����������
				/*
				String data = "Hello SecondActivity!";
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				intent.putExtra("extra_data", data);
				startActivity(intent);
				*/
				
				//��ʽIntent��ָ��action��category����Ϣ����ϵͳ�������������ʵĻ
				/*
				Intent intent = new Intent("com.example.activitytest.ACTION_START");
				intent.addCategory("com.example.activitytest.MY_CATEGORY");			
				startActivity(intent);
				*/
				
				//������һ������ص�����ʱ����������
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				startActivityForResult(intent, 1);
				
				
			}
		});
		
		
		Button OpenExplorer = (Button)findViewById(R.id.open_explorer);
		OpenExplorer.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){		//����ϵͳ���������ҳ
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://www.baidu.com"));
				startActivity(intent);
			}
		});		
		
	}
	
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case R.id.add_item:
			Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
			break;
		case R.id.remove_item:
			Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
			break;
		default:
		}
		return true;
	}
	
	//�����ص�����
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		switch(requestCode) {
		case 1:
			if(resultCode == RESULT_OK){
				String returnedData = data.getStringExtra("data_return");
				Log.d("FirstActivity", returnedData);
			}
		}
	}
	

}
