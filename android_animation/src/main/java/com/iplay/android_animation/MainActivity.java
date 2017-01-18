package com.iplay.android_animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	private ImageView main_image;
	private Button view;
	private Button layout;
	private Button frame;
	private Button property;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		main_image = (ImageView) findViewById(R.id.main_image);

		view=(Button) findViewById(R.id.view);
		layout=(Button) findViewById(R.id.layout);
		frame=(Button) findViewById(R.id.frame);
		property=(Button) findViewById(R.id.property);

		view.setOnClickListener(this);
		layout.setOnClickListener(this);
		frame.setOnClickListener(this);
		property.setOnClickListener(this);

	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		Animation loadAnimation;
		switch (view.getId()) {
			case R.id.view:
			{
				Intent intent=new Intent(MainActivity.this,ViewAnimationActivity.class);
				startActivity(intent);
				break;
			}

			case R.id.property:
			{
				Intent intent=new Intent(MainActivity.this,PropertyAnimationActivity.class);
				startActivity(intent);
				break;
			}


			case R.id.layout:
			{
				Intent intent=new Intent(this,ListActivity.class);
				startActivity(intent);
				break;
			}

			case R.id.frame:
			{
				main_image.setImageResource(R.drawable.anim_list);
				break;

			}

		}
	}

}
