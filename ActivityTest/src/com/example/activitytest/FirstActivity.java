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
				finish();//销毁活动
			}
		});
		
		Button StartSecondActivity = (Button)findViewById(R.id.start_second_activity);
		StartSecondActivity.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				//Toast.makeText(FirstActivity.this, "You clicked Button1", Toast.LENGTH_SHORT).show();
				//显示Intent,明确指出目标活动，并向下一个活动传输数据
				/*
				String data = "Hello SecondActivity!";
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				intent.putExtra("extra_data", data);
				startActivity(intent);
				*/
				
				//隐式Intent，指定action和category等信息，由系统分析并启动合适的活动
				/*
				Intent intent = new Intent("com.example.activitytest.ACTION_START");
				intent.addCategory("com.example.activitytest.MY_CATEGORY");			
				startActivity(intent);
				*/
				
				//接收下一个活动返回的数据时的启动操作
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				startActivityForResult(intent, 1);
				
				
			}
		});
		
		
		Button OpenExplorer = (Button)findViewById(R.id.open_explorer);
		OpenExplorer.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){		//调用系统浏览器打开网页
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
	
	//处理返回的数据
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
