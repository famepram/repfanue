package ekalaya.id.repfanue.data.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import ekalaya.id.repfanue.util.Const;

/**
 * Created by Femmy on 8/13/2017.
 */
@Singleton
public class SPManager {


    private SharedPreferences mSharedPreferences;

    @Inject
    public SPManager(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    public void put(String key, String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }

    public void put(String key, int value) {
        mSharedPreferences.edit().putInt(key, value).apply();
    }

    public void put(String key, float value) {
        mSharedPreferences.edit().putFloat(key, value).apply();
    }

    public void put(String key, boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).apply();
    }

    public String get(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    public Integer get(String key, int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }

    public Float get(String key, float defaultValue) {
        return mSharedPreferences.getFloat(key, defaultValue);
    }

    public Boolean get(String key, boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }

    public void deleteSavedData(String key) {
        mSharedPreferences.edit().remove(key).apply();
    }


}
