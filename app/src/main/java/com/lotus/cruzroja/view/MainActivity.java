package com.lotus.cruzroja.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lotus.cruzroja.R;
import com.lotus.cruzroja.view.ContainerActivity;

public class MainActivity extends AppCompatActivity {
    private Handler handler;
    private boolean ready;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler=new Handler();
        handler.postDelayed(myRunnable,3000);
    }

    private  Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            startOtherActivity();
        }
    };

    private void startOtherActivity(){
        startActivity(new Intent(this,ContainerActivity.class));//instancia de la clase, MainActivity
        finish();
    }
}
