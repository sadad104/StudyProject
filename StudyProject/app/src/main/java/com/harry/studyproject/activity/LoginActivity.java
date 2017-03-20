package com.harry.studyproject.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.harry.studyproject.R;
import com.harry.studyproject.base.BasePreferenceManager;

/**
 * Created by user on 2017-03-11.
 */

public class LoginActivity extends Activity {

    private EditText edtId, edtPwd;
    private CheckBox cbMemoryPwd;
    private BasePreferenceManager preferenceManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtId = (EditText) findViewById(R.id.edt_id);
        edtPwd = (EditText) findViewById(R.id.edt_password);
        cbMemoryPwd = (CheckBox) findViewById(R.id.cb_memory_pwd);

        preferenceManager = BasePreferenceManager.getInstance(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        checkinfoLogin();
    }

    public void checkinfoLogin() {
        boolean memory = preferenceManager.getBoolean("memory");
        if(memory) {
            edtId.setText(preferenceManager.getString("id"));
            edtPwd.setText(preferenceManager.getString("pwd"));
            cbMemoryPwd.setChecked(memory);
        }
    }

    public void setInfoLogin() {
        if(cbMemoryPwd.isChecked()) {
            preferenceManager.putString("id", edtId.getText().toString());
            preferenceManager.putString("pwd", edtPwd.getText().toString());
            preferenceManager.putBoolean("memory", cbMemoryPwd.isChecked());
        }
    }

    //로그인
    public void onLogin(View view) {

        String message = checkUserInfo();
        if (!message.equals("success")) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            return;
        }

        setInfoLogin();

        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
        finish();

    }

    //회원가입
    public void onCreateMember(View view) {
        Toast.makeText(this, "회원가입 페이지", Toast.LENGTH_SHORT).show();
    }

    //비밀번호 찾기 페이지
    public void onSearchPassword(View view) {
        Toast.makeText(this, "비밀번호 찾기 페이지", Toast.LENGTH_SHORT).show();
    }

    //로그인 정보 체크
    private String checkUserInfo() {

        String id = edtId.getText().toString();
        String pwd = edtPwd.getText().toString();

        if (id.equals("test")) {
            if (pwd.equals("000000")) {
                return "success";
            } else {
                return "비밀번호가 틀렸습니다. 다시 시도해주세요.";
            }
        } else {
            return "아이디가 틀렸습니다. 다시 시도해주세요.";
        }
    }
}
