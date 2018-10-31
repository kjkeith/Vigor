package com.example.vigor.vigor;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import static android.provider.Telephony.Mms.Part.FILENAME;

public class SessionController {
    private static String TAG = SessionController.class.getSimpleName();

    // File in which user info will be saved
    private static final String PREFERENCE_FILE = "VigorUserInfo";

    // SP File Keys
    private static final String LOGGEDIN_KEY = "isLoggedIn";
    private static final String USER_ID = "userID";
    private static final String USER_EMAIL = "eMail";
    private static final String USER_FIRST = "firstName";
    private static final String USER_LAST = "lastName";


    SharedPreferences sharedPref;
    Editor spEditor;
    Context context;

    public SessionController(Context context) {
        this.context = context;
        sharedPref = this.context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        spEditor = sharedPref.edit();
    }

    public void attemptLogin(boolean isLoggedIn, int uID, String email, String first_name,
                             String last_name) {
        spEditor.putBoolean(LOGGEDIN_KEY, isLoggedIn);

        if (isLoggedIn) {
            spEditor.putInt(USER_ID, uID);
            spEditor.putString(USER_EMAIL, email);
            spEditor.putString(USER_FIRST, first_name);
            spEditor.putString(USER_LAST, last_name);
        }
    }

    public boolean checkLogin() {
        return sharedPref.getBoolean(LOGGEDIN_KEY, false);
    }

    public int returnUserID() {
        return sharedPref.getInt(USER_ID, 0);
    }

    public String returnEmail() {
        return sharedPref.getString(USER_EMAIL, "");
    }

}