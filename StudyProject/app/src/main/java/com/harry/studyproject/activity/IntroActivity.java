package com.harry.studyproject.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.harry.studyproject.R;

/**
 * Created by user on 2017-03-11.
 */

public class IntroActivity extends Activity {

    private final int DELEAY = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    @Override
    protected void onResume() {
        super.onResume();
        onLoad();
    }

    //화면 3초간 딜레이
    private void onLoad() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goLogin();
            }
        }, DELEAY);
    }

    //로그인 페이지로
    private void goLogin() {
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
        finish();
    }
}
