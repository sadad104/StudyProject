package com.harry.studyproject.base;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by user on 2017-03-20.
 */

public class BasePreferenceManager {

    private static final String SETTING_NAME = "base_setting";
    private static BasePreferenceManager mPrefManager;
    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;

//    private static final String LOGIN_ID = "login_id";
//    private static final String LOGIN_PWD = "login_pwd";

    public static BasePreferenceManager getInstance(Context context) {
        if (mPrefManager == null) {
            mPrefManager = new BasePreferenceManager(context.getApplicationContext());
        }
        return mPrefManager;
    }

    private BasePreferenceManager(Context context) {
        mPref = context.getSharedPreferences(SETTING_NAME, context.MODE_PRIVATE);
    }

    public void putString(String key, String val) {
        doEdit();
        mEditor.putString(key, val);
        doCommit();
    }

    public void putBoolean(String key, Boolean val) {
        doEdit();
        mEditor.putBoolean(key, val);
        doCommit();
    }

    public String getString(String key) {
        return mPref.getString(key, null);
    }

    public Boolean getBoolean(String key) {
        return mPref.getBoolean(key, false);
    }

    private void clear() {
        mEditor.clear();
    }

    private void doEdit() {
        if(mEditor == null) {
            mEditor = mPref.edit();
        }
    }

    private void doCommit() {
        if(mEditor != null) {
            mEditor.commit();
            mEditor = null;
        }
    }
}
