package com.example.savemoney.SharedPref;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Admin on 13/02/2018.
 */
public class SharedPref
{
    private  static SharedPref dataUser;
    private SharedPreferences sharedPreferences;

    public static SharedPref getInstance(Context context)
    {
        if (dataUser == null)
        {
            dataUser = new SharedPref(context);
        }
        return dataUser;
    }

    private SharedPref(Context context)
    {
        sharedPreferences = context.getSharedPreferences("dataUser", Context.MODE_PRIVATE);
    }

    public void saveData(String key, String value)
    {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor .putString(key, value);
        prefsEditor.commit();
    }

    public String getData(String key)
    {
        if (sharedPreferences!= null)
        {
            return sharedPreferences.getString(key, "");
        }
        return "";
    }

    public void clearData()
    {
        dataUser.saveData("user_status","");

    }
}

