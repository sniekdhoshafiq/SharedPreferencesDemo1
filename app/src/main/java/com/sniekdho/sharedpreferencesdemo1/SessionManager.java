package com.sniekdho.sharedpreferencesdemo1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SessionManager
{
    private Context context;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private final String PREF_FILE_NAME = "SharedPreferenceDemo1";
    private final int PRIVATE_MODE = 0;

    private final String KEY_IF_REGISTERED = "key_session_if_registered";

    private final String KEY_NAME = "key_session_name";
    private final String KEY_EMAIL = "key_session_email";
    private final String KEY_GENDER = "key_session_gender";

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public boolean checkSession()
    {
        return sharedPreferences.contains(KEY_IF_REGISTERED);
    }

    public void createSession(String name, String email, String gender)
    {
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_GENDER, gender);
        editor.putBoolean(KEY_IF_REGISTERED, true);
        editor.commit();
    }

    public String getSessionDetails(String key)
    {
        return sharedPreferences.getString(key, null);
    }

    public void logoutSession()
    {
        editor.clear();
        editor.commit();

        Intent intent = new Intent(context, Login.class);
        context.startActivity(intent);
    }

    /*
    public void clearSelectedData()
    {
        editor.remove(KEY_NAME);
        editor.commit();
    }
    */
}
