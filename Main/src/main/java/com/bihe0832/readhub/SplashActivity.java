package com.bihe0832.readhub;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;

import com.bihe0832.readhub.main.MainActivity;


/**
 * @author code@bihe0832.com
 */
public class SplashActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.com_bihe0832_activity_splash);
        startApp(getIntent());
    }

    private void startApp(final Intent intent) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                intent.setClass(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        }, 2000);
    }
}


