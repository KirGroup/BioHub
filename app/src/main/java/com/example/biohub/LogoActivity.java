package com.example.biohub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class LogoActivity extends Activity {

    private Animation logoAnim;


    private ImageView logoImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        init();
        startMainActivity();
    }

    private void init() {
        logoAnim = AnimationUtils.loadAnimation(this, R.anim.logo_anim);
//        buttonLogoAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_anim);

        logoImage = findViewById(R.id.id_image);
//        bAnim = findViewById(R.id.id_button);

        logoImage.startAnimation(logoAnim);
//        bAnim.startAnimation(buttonLogoAnim);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    public void startMainActivity() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                    Intent intent = new Intent(LogoActivity.this, MainActivity.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }



}