package com.platform101xp.sdk.internal;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.widget.ImageView;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.api.http.Platform101XPHttpRequest;
import com.platform101xp.sdk.api.model.Platform101XPModel;
import com.platform101xp.sdk.api.model.Platform101XPSkinColorsModel;
import com.platform101xp.sdk.internal.logcathelper.AppFilesHelper;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPSkinManager {
    private static final String styleFile = "style.json";
    private String appSkinName;
    private Map<String, String> colorStore;
    private Resources currentResources;
    private Map<String, BitmapDrawable> drawableStore;
    private String imageUrl;
    private Platform101XPError lastImageDownloadError;
    private SkinManagerLoadResultListener loadResultListener;
    private String styleUrl;
    private String url = "http://xp-scg-mobilsdk.akamaized.net/ui/%s/uirate_android/";

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public interface SkinManagerLoadResultListener {
        void onSkinLoadResult(Platform101XPError platform101XPError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDensityDpiForImage(int i) {
        if (i < 400 || i > 440) {
            if (i > 480 && i < 640) {
                return 640;
            }
            return i;
        }
        return 480;
    }

    public Platform101XPSkinManager(String str, SkinManagerLoadResultListener skinManagerLoadResultListener) {
        this.appSkinName = str;
        this.loadResultListener = skinManagerLoadResultListener;
        if (Platform101XP.getCurrentActivity() != null) {
            this.currentResources = Platform101XP.getCurrentActivity().getResources();
            this.drawableStore = new HashMap();
            return;
        }
        SkinManagerLoadResultListener skinManagerLoadResultListener2 = this.loadResultListener;
        if (skinManagerLoadResultListener2 == null) {
            return;
        }
        skinManagerLoadResultListener2.onSkinLoadResult(new Platform101XPError(new Exception("Current Activity is null!")));
    }

    private void loadSkin(String str, final String str2) {
        if (str == null) {
            Exception exc = new Exception("skinName is null!!! Please check what exist app_skin_name string in strings.xml");
            Platform101XP.sendCrashReport(exc);
            SkinManagerLoadResultListener skinManagerLoadResultListener = this.loadResultListener;
            if (skinManagerLoadResultListener == null) {
                return;
            }
            skinManagerLoadResultListener.onSkinLoadResult(new Platform101XPError(exc));
            return;
        }
        this.imageUrl = String.format(this.url + getDisplayDpiName(this.currentResources) + "/", str.toLowerCase());
        StringBuilder sb = new StringBuilder();
        sb.append(this.url);
        sb.append(styleFile);
        String format = String.format(sb.toString(), str.toLowerCase());
        this.styleUrl = format;
        loadSkinColors(format, new SkinManagerLoadResultListener() { // from class: com.platform101xp.sdk.internal.Platform101XPSkinManager.1
            @Override // com.platform101xp.sdk.internal.Platform101XPSkinManager.SkinManagerLoadResultListener
            public void onSkinLoadResult(Platform101XPError platform101XPError) {
                Log.d("101XP SDK", "Init colors error: " + platform101XPError);
                Platform101XPSkinManager.this.loadImages(str2);
                Log.d("101XP SDK", "imageUrl: " + Platform101XPSkinManager.this.imageUrl);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImages(String str) {
        String readSkinHolder;
        if (Platform101XP.getCurrentActivity() == null || (readSkinHolder = readSkinHolder(str)) == null || readSkinHolder.isEmpty()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(readSkinHolder);
            CountDownLatch countDownLatch = new CountDownLatch(jSONObject.length());
            waitForDownloading(countDownLatch, jSONObject.length());
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                loadBitmap(next, jSONObject.optString(next), countDownLatch);
            }
        } catch (JSONException e) {
            SkinManagerLoadResultListener skinManagerLoadResultListener = this.loadResultListener;
            if (skinManagerLoadResultListener != null) {
                skinManagerLoadResultListener.onSkinLoadResult(new Platform101XPError(e));
            }
            Platform101XP.sendCrashReport(e);
        }
    }

    private void loadBitmap(final String str, final String str2, final CountDownLatch countDownLatch) {
        if (Platform101XP.getCurrentActivity() == null) {
            return;
        }
        final ImageView imageView = new ImageView(Platform101XP.getCurrentActivity());
        try {
            Picasso build = new Picasso.Builder(imageView.getContext()).loggingEnabled(true).build();
            build.load(this.imageUrl + str2).into(imageView, new Callback() { // from class: com.platform101xp.sdk.internal.Platform101XPSkinManager.2
                @Override // com.squareup.picasso.Callback
                public void onSuccess() {
                    if (imageView.getDrawable() != null) {
                        if (Platform101XPSkinManager.this.currentResources != null) {
                            int i = Platform101XPSkinManager.this.currentResources.getDisplayMetrics().densityDpi;
                            ((BitmapDrawable) imageView.getDrawable()).setTargetDensity((int) ((Platform101XPSkinManager.this.currentResources.getDisplayMetrics().density / (Platform101XPSkinManager.this.getDensityDpiForImage(i) / 160)) * i));
                        }
                        Platform101XPSkinManager.this.drawableStore.put(str, (BitmapDrawable) imageView.getDrawable());
                        countDownLatch.countDown();
                    }
                }

                @Override // com.squareup.picasso.Callback
                public void onError(Exception exc) {
                    if (exc.getMessage().contains("HTTP 404")) {
                        Platform101XP.sendCrashReport(new Exception("Skin manager 404 error for: " + str2));
                    }
                    Platform101XPSkinManager.this.lastImageDownloadError = new Platform101XPError(exc);
                    countDownLatch.countDown();
                }
            });
        } catch (IllegalArgumentException | IllegalStateException e) {
            Platform101XP.sendCrashReport(e);
        }
    }

    private String getDisplayDpiName(Resources resources) {
        int i = resources.getDisplayMetrics().densityDpi;
        return (i < 400 || i > 440) ? ((resources.getDisplayMetrics().heightPixels == 1964 && resources.getDisplayMetrics().widthPixels == 1536) || i == 160) ? "mdpi" : i != 240 ? i != 320 ? i != 480 ? (i == 560 || i == 640) ? "xxxhdpi" : "" : "xxhdpi" : "xhdpi" : "hdpi" : "xxhdpi";
    }

    private String readSkinHolder(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Platform101XP.getCurrentActivity().getAssets().open(str)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuffer.append(readLine);
                    stringBuffer.append(AppFilesHelper.A_NEW_LINE);
                } else {
                    bufferedReader.close();
                    return stringBuffer.toString();
                }
            }
        } catch (IOException e) {
            Platform101XP.sendCrashReport(e);
            return null;
        }
    }

    private void waitForDownloading(final CountDownLatch countDownLatch, final int i) {
        new Thread(new Runnable() { // from class: com.platform101xp.sdk.internal.Platform101XPSkinManager.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    countDownLatch.await();
                    if (Platform101XPSkinManager.this.drawableStore.size() != i) {
                        Log.d("101XP SDK", "Not all skin images was loaded");
                    }
                    Platform101XPSkinManager.this.loadResultListener.onSkinLoadResult(Platform101XPSkinManager.this.lastImageDownloadError);
                } catch (InterruptedException e) {
                    Platform101XP.sendCrashReport(e);
                }
            }
        }).start();
    }

    public BitmapDrawable getDrawable(String str) {
        Map<String, BitmapDrawable> map = this.drawableStore;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public void loadSkin() {
        loadSkin(this.appSkinName, "skin_holder.json");
    }

    public void updateSkin(String str) {
        if (Platform101XP.getCurrentActivity().getPackageName().startsWith("com.platform101xp.sample") && !this.imageUrl.contains(str)) {
            Map<String, BitmapDrawable> map = this.drawableStore;
            if (map != null && !map.isEmpty()) {
                this.drawableStore.clear();
            }
            Map<String, String> map2 = this.colorStore;
            if (map2 != null && !map2.isEmpty()) {
                this.colorStore.clear();
            }
            loadSkin(str, "skin_holder.json");
        }
    }

    private void loadSkinColors(String str, final SkinManagerLoadResultListener skinManagerLoadResultListener) {
        if (str == null || str.isEmpty()) {
            skinManagerLoadResultListener.onSkinLoadResult(new Platform101XPError(new Exception("Style Url is incorrect!")));
        } else {
            new Platform101XPHttpRequest(str, null, Platform101XPHttpRequest.HttpMethod.GET, Platform101XPSkinColorsModel.class).execute(new Platform101XPHttpRequest.HttpRequestListener() { // from class: com.platform101xp.sdk.internal.Platform101XPSkinManager.4
                @Override // com.platform101xp.sdk.api.http.Platform101XPHttpRequest.HttpRequestListener
                public void onResult(Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
                    if (platform101XPError == null || Platform101XPSkinManager.this.loadResultListener == null) {
                        if (platform101XPModel != null) {
                            Platform101XPSkinManager.this.colorStore = ((Platform101XPSkinColorsModel) platform101XPModel).getStyleColors();
                            Log.d("101XP SDK", "AppReview Colors ResultMap: " + Platform101XPSkinManager.this.colorStore);
                        } else if (skinManagerLoadResultListener != null) {
                            platform101XPError = new Platform101XPError(new Exception("Unknown Error: Model is null and Platform101XPError is null!"));
                        }
                        platform101XPError = null;
                    }
                    skinManagerLoadResultListener.onSkinLoadResult(platform101XPError);
                }
            });
        }
    }

    public String getColorString(String str) {
        Map<String, String> map = this.colorStore;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.colorStore.get(str);
    }
}
