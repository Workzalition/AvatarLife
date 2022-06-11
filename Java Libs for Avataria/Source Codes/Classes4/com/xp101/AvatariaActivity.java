package com.xp101;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.chartboost.sdk.Chartboost;
import com.platform101xp.sdk.Platform101XP;
import org.cocos2dx.lib.Cocos2dxActivity;
import org.cocos2dx.lib.Cocos2dxHelper;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public class AvatariaActivity extends Cocos2dxActivity implements ComponentCallbacks2 {
    /* JADX INFO: Access modifiers changed from: private */
    public static native void didReceiveMemoryWarning();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onLayoutHeightUpdated(float f);

    @Override // org.cocos2dx.lib.Cocos2dxActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.setEnableVirtualButton(false);
        super.onCreate(bundle);
        try {
        } catch (Exception e) {
            Log.e("AVA", "onCreate EXCEPTION", e);
        }
        if (!isTaskRoot()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 2;
            getWindow().setAttributes(attributes);
        }
        Platform101XP.onCreate(this);
        initializeSDK();
        NotificationPublisher.createNotificationChannel(this);
        AdManager.getInstance().initialize(this);
        try {
            this.mFrameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.xp101.AvatariaActivity.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    int height;
                    if (AvatariaActivity.this.mFrameLayout != null && (height = AvatariaActivity.this.mFrameLayout.getRootView().getHeight()) > 0) {
                        Rect rect = new Rect();
                        AvatariaActivity.this.mFrameLayout.getWindowVisibleDisplayFrame(rect);
                        final float f = (height - (rect.bottom - rect.top)) / height;
                        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.AvatariaActivity.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AvatariaActivity.onLayoutHeightUpdated(f);
                            }
                        });
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // org.cocos2dx.lib.Cocos2dxActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            Platform101XP.onResume(this);
            AdManager.getInstance().onResume(this);
        } catch (Exception e) {
            Log.e("AVA", "SDK onResume EXCEPTION", e);
        }
    }

    @Override // org.cocos2dx.lib.Cocos2dxActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            Platform101XP.onDestroy(this);
        } catch (Exception e) {
            Log.e("AVA", "SDK onDestroy EXCEPTION", e);
        }
    }

    @Override // org.cocos2dx.lib.Cocos2dxActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        try {
            Platform101XP.onActivityResult(i, i2, intent);
        } catch (Exception e) {
            Log.e("AVA", "SDK onActivityResult EXCEPTION", e);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        try {
            Platform101XP.onSaveInstanceState(bundle);
        } catch (Exception e) {
            Log.e("AVA", "SDK onSaveInstanceState EXCEPTION", e);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        try {
            Platform101XP.onRestoreInstanceState(bundle);
        } catch (Exception e) {
            Log.e("AVA", "SDK onRestoreInstanceState EXCEPTION", e);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        try {
            Platform101XP.onStart(this);
        } catch (Exception e) {
            Log.e("AVA", "SDK onStart EXCEPTION", e);
        }
    }

    @Override // org.cocos2dx.lib.Cocos2dxActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            AdManager.getInstance().onPause(this);
        } catch (Exception e) {
            Log.e("AVA", "AdManager onPause EXCEPTION", e);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (Chartboost.onBackPressed()) {
            return;
        }
        super.onBackPressed();
        Platform101XP.backPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        Log.d("avataria", "onTrimMemory: " + i);
        if (i == 15 || i == 80) {
            try {
                Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.AvatariaActivity.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AvatariaActivity.didReceiveMemoryWarning();
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    public static void initializeSDK() {
        Activity currentActivity = Platform101XP.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.xp101.AvatariaActivity.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Activity currentActivity2 = Platform101XP.getCurrentActivity();
                    if (currentActivity2 == null) {
                        return;
                    }
                    Platform101XP.initialize(new XP101SDKListener(), currentActivity2.getString(R.string.sdk_client_id));
                } catch (Exception e) {
                    Log.e("AVA", "SDK INITIALIZE EXCEPTION", e);
                }
            }
        });
    }

    public static void requestRewardedAd() {
        Activity currentActivity = Platform101XP.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.xp101.AvatariaActivity.1RequestAdsRunner
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AdManager.getInstance().requestRewardedAd();
                } catch (Exception e) {
                    Log.e("AVA", "ADS - REQUEST REWARDED EXCEPTION", e);
                }
            }
        });
    }

    public static void showRewardedAd() {
        Activity currentActivity = Platform101XP.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.xp101.AvatariaActivity.1ShowAdsRunner
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AdManager.getInstance().showRewardedAd();
                } catch (Exception e) {
                    Log.e("AVA", "ADS - SHOW REWARDED EXCEPTION", e);
                }
            }
        });
    }

    public static void closeApp() {
        final Activity currentActivity = Platform101XP.getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.runOnUiThread(new Runnable() { // from class: com.xp101.AvatariaActivity.1CloseAppRunner
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent("android.intent.action.MAIN");
                        intent.addCategory("android.intent.category.HOME");
                        intent.setFlags(32768);
                        currentActivity.startActivity(intent);
                    } catch (Exception e) {
                        Log.e("AVA", "close App - exception", e);
                        System.exit(0);
                    }
                }
            });
        }
    }
}
