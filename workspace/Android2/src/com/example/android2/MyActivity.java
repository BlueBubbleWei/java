package com.example.android2;

import android.app.Activity;
import android.media.tv.TvContentRating;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

public class MyActivity extends Activity {
	private TextView tv ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_main);
		tv =  (TextView)tv.findViewById(R.id.text_id) ;
		
	}
}
