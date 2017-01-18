package com.iplay.android_animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class ViewAnimationActivity extends Activity implements View.OnClickListener {

    private ImageView image;
    private Button scale;
    private Button rotate;
    private Button translate;
    private Button mix;
    private Button alpha;
    private Button continue_btn;
    private Button continue_btn2;
    private Button flash;
    private Button move;
    private Button change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);

        image = (ImageView) findViewById(R.id.image);
        scale = (Button) findViewById(R.id.scale);
        rotate = (Button) findViewById(R.id.rotate);
        translate = (Button) findViewById(R.id.translate);
        alpha = (Button) findViewById(R.id.alpha);
        continue_btn = (Button) findViewById(R.id.continue_btn);
        continue_btn2 = (Button) findViewById(R.id.continue_btn2);
        flash = (Button) findViewById(R.id.flash);
        move = (Button) findViewById(R.id.move);
        change=(Button) findViewById(R.id.change);

        scale.setOnClickListener(this);
        rotate.setOnClickListener(this);
        translate.setOnClickListener(this);
        alpha.setOnClickListener(this);
        continue_btn.setOnClickListener(this);
        continue_btn2.setOnClickListener(this);
        flash.setOnClickListener(this);
        move.setOnClickListener(this);
        change.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        // TODO Auto-generated method stub
        Animation loadAnimation;
        switch (view.getId()) {
            case R.id.scale: {
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
                image.startAnimation(loadAnimation);
                break;
            }

            case R.id.rotate: {
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
                image.startAnimation(loadAnimation);
                break;
            }

            case R.id.translate: {

                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
                image.startAnimation(loadAnimation);
                break;
            }

            case R.id.continue_btn: {
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
                image.startAnimation(loadAnimation);
                final Animation loadAnimation2 = AnimationUtils.loadAnimation(this,R.anim.rotate);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onAnimationRepeat(Animation arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onAnimationEnd(Animation arg0) {
                        // TODO Auto-generated method stub
                        image.startAnimation(loadAnimation2);
                    }
                });
                break;
            }

            case R.id.continue_btn2: {
                loadAnimation = AnimationUtils.loadAnimation(this,
                        R.anim.continue_anim);
                image.startAnimation(loadAnimation);
                break;
            }

            case R.id.alpha: {
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
                image.startAnimation(loadAnimation);
                break;
            }

            case R.id.move: {
                TranslateAnimation translate = new TranslateAnimation(-50, 50,
                        0, 0);
                translate.setDuration(1000);
                translate.setRepeatCount(Animation.INFINITE);
                translate.setRepeatMode(Animation.REVERSE);
                image.startAnimation(translate);

                break;
            }

            case R.id.flash: {

                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(100);
                alphaAnimation.setRepeatCount(10);
                //倒序重复REVERSE  正序重复RESTART
                alphaAnimation.setRepeatMode(Animation.REVERSE);
                image.startAnimation(alphaAnimation);

                break;
            }

            case R.id.change:
            {
                Intent intent=new Intent(this,MainActivity2.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_in,R.anim.zoom_out);
                break;
            }


        }
    }

}
