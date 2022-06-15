package com.platform101xp.sdk.internal.firebase.database;

import android.app.Activity;
import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPFirebaseDbModule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0007J\b\u0010\u0010\u001a\u00020\u0005H\u0007J\b\u0010\u0011\u001a\u00020\u0007H\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDbModule;", "", "currentActivity", "Landroid/app/Activity;", "currentDeviceId", "", "initListener", "Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDbManager$InitDbResultListener;", "(Landroid/app/Activity;Ljava/lang/String;Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDbManager$InitDbResultListener;)V", "getCurrentActivity", "()Landroid/app/Activity;", "getCurrentDeviceId", "()Ljava/lang/String;", "getInitListener", "()Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDbManager$InitDbResultListener;", "getActivity", "getDeviceId", "getFirebaseDbInitListener", "getFirebaseDbUtils", "Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDbUtils;", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDbModule {
    private final Activity currentActivity;
    private final String currentDeviceId;
    private final Platform101XPFirebaseDbManager.InitDbResultListener initListener;

    public Platform101XPFirebaseDbModule(Activity activity, String str, Platform101XPFirebaseDbManager.InitDbResultListener initDbResultListener) {
        Intrinsics.checkNotNullParameter(activity, "currentActivity");
        Intrinsics.checkNotNullParameter(str, "currentDeviceId");
        Intrinsics.checkNotNullParameter(initDbResultListener, "initListener");
        this.currentActivity = activity;
        this.currentDeviceId = str;
        this.initListener = initDbResultListener;
    }

    public final Activity getCurrentActivity() {
        return this.currentActivity;
    }

    public final String getCurrentDeviceId() {
        return this.currentDeviceId;
    }

    public final Platform101XPFirebaseDbManager.InitDbResultListener getInitListener() {
        return this.initListener;
    }

    @Provides
    public final Activity getActivity() {
        return this.currentActivity;
    }

    @Provides
    public final String getDeviceId() {
        return this.currentDeviceId;
    }

    @Provides
    public final Platform101XPFirebaseDbManager.InitDbResultListener getFirebaseDbInitListener() {
        return this.initListener;
    }

    @Provides
    public final Platform101XPFirebaseDbUtils getFirebaseDbUtils() {
        return new Platform101XPFirebaseDbUtils();
    }
}
