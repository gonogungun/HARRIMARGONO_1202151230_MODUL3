package com.example.android.harrimargono_1202151230_modul3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    //membuat variable TextView sebagai tv dan ImageView sebagai iv
    private TextView tv ;
    private ImageView iv ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv = (TextView) findViewById(R.id.tv) ;
        iv = (ImageView) findViewById(R.id.iv) ;
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.splashtransition);
        //memulai aktifitas animasi
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);
        //Variabel i intent untuk class MainActivity
        final Intent i = new Intent(this,LoginActivity.class);
        //Timer ( menahan splash screen selama beberapa detik)
        Thread timer =new Thread(){
            public void run () {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } // Menjalankan MainActivity setelah berhenti beberapa detik di splash screen
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}






