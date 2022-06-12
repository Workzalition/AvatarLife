package com.platform101xp.sdk.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.util.Log;
import com.google.common.primitives.UnsignedBytes;
import com.platform101xp.sdk.Platform101XP;
import com.tapjoy.TapjoyConstants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPUtils {
    private static Platform101XPUtils instance;
    private Context appContext;
    private Platform101XPMetaManager metaManager;

    public Platform101XPUtils() {
        Context applicationContext = Platform101XP.getApplicationContext();
        this.appContext = applicationContext;
        this.metaManager = new Platform101XPMetaManager(applicationContext);
    }

    public static Platform101XPUtils getInstance() {
        if (instance == null) {
            instance = new Platform101XPUtils();
        }
        return instance;
    }

    public static String getLocale() {
        return Locale.getDefault().getLanguage();
    }

    private String signatureToString(byte[] bArr) {
        String str = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            for (int i = 0; i < digest.length; i++) {
                str = str + Integer.toString(digest[i] & UnsignedBytes.MAX_VALUE, 16);
            }
            return str.toUpperCase();
        } catch (NoSuchAlgorithmException unused) {
            return str;
        }
    }

    public String getFingerprint() {
        try {
            return signatureToString(this.appContext.getPackageManager().getPackageInfo(this.appContext.getPackageName(), 64).signatures[0].toByteArray());
        } catch (Exception unused) {
            return "";
        }
    }

    public String getDeviceId() {
        String upperCase = Settings.Secure.getString(this.appContext.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID).toUpperCase();
        Log.d("device_id:", upperCase);
        return upperCase;
    }

    public int dpiToPixel(int i) {
        return (int) ((i * this.appContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo;
        return (Platform101XP.getCurrentActivity() == null || (activeNetworkInfo = ((ConnectivityManager) Platform101XP.getCurrentActivity().getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }
}
