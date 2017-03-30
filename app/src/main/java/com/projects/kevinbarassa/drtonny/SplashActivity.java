package com.projects.kevinbarassa.drtonny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


/**
 * Created by Kevin Barassa on 30/3/2017.
 */
public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);


        Thread timer = new Thread(){
            public void run(){
                try{

                    sleep(3000);

                }catch (InterruptedException e){
                      e.printStackTrace();
                }finally{
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
            }

        };
        timer.start();



    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
