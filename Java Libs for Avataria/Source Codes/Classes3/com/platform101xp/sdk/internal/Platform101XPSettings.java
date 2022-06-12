package com.platform101xp.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.platform101xp.sdk.Platform101XP;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPSettings {
    private static Platform101XPSettings instance;
    private Context appContext = Platform101XP.getApplicationContext();

    public static Platform101XPSettings getInstance() {
        if (instance == null) {
            instance = new Platform101XPSettings();
        }
        return instance;
    }

    public static String loadString(String str) {
        return getInstance().getString(str);
    }

    public static void saveString(String str, String str2) {
        getInstance().setString(str, str2);
    }

    public static long loadLong(String str, long j) {
        return getInstance().getLong(str, j).longValue();
    }

    public static void saveLong(String str, long j) {
        getInstance().setLong(str, j);
    }

    public static boolean isKeyExist(String str) {
        return getInstance().isContainsKey(str);
    }

    public static boolean loadBoolean(String str, boolean z) {
        return getInstance().getBoolean(str, z);
    }

    public static void saveBoolean(String str, boolean z) {
        getInstance().setBoolean(str, z);
    }

    public static int loadInt(String str, int i) {
        return getInstance().getInt(str, i);
    }

    public static void saveInt(String str, int i) {
        getInstance().setInt(str, i);
    }

    public static void removeValue(String str) {
        getInstance().deleteValue(str);
    }

    public String getString(String str) {
        Context context = this.appContext;
        if (context == null) {
            return null;
        }
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, null);
    }

    public void setString(String str, String str2) {
        Context context = this.appContext;
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public Long getLong(String str, long j) {
        Context context = this.appContext;
        if (context == null) {
            return Long.valueOf(j);
        }
        return Long.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getLong(str, j));
    }

    public void setLong(String str, long j) {
        Context context = this.appContext;
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public boolean isContainsKey(String str) {
        Context context = this.appContext;
        if (context == null) {
            return false;
        }
        return PreferenceManager.getDefaultSharedPreferences(context).contains(str);
    }

    public boolean getBoolean(String str, boolean z) {
        Context context = this.appContext;
        return context == null ? z : PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }

    public void setBoolean(String str, boolean z) {
        Context context = this.appContext;
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public int getInt(String str, int i) {
        Context context = this.appContext;
        return context == null ? i : PreferenceManager.getDefaultSharedPreferences(context).getInt(str, i);
    }

    public void setInt(String str, int i) {
        Context context = this.appContext;
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public void deleteValue(String str) {
        Context context = this.appContext;
        if (context == null) {
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (!defaultSharedPreferences.contains(str)) {
            return;
        }
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        edit.remove(str);
        edit.apply();
    }
}
