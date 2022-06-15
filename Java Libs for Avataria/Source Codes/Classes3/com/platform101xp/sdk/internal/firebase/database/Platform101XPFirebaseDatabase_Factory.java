package com.platform101xp.sdk.internal.firebase.database;

import android.app.Activity;
import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDatabase_Factory implements Factory<Platform101XPFirebaseDatabase> {
    private final Provider<Activity> activityProvider;
    private final Provider<Platform101XPFirebaseDbManager.InitDbResultListener> initListenerProvider;
    private final Provider<Activity> p0Provider;
    private final Provider<Platform101XPFirebaseDbManager.InitDbResultListener> p0Provider2;

    public Platform101XPFirebaseDatabase_Factory(Provider<Activity> provider, Provider<Platform101XPFirebaseDbManager.InitDbResultListener> provider2, Provider<Activity> provider3, Provider<Platform101XPFirebaseDbManager.InitDbResultListener> provider4) {
        this.activityProvider = provider;
        this.initListenerProvider = provider2;
        this.p0Provider = provider3;
        this.p0Provider2 = provider4;
    }

    public Platform101XPFirebaseDatabase get() {
        Platform101XPFirebaseDatabase newInstance = newInstance((Activity) this.activityProvider.get(), (Platform101XPFirebaseDbManager.InitDbResultListener) this.initListenerProvider.get());
        Platform101XPFirebaseDatabase_MembersInjector.injectSetActivity(newInstance, (Activity) this.p0Provider.get());
        Platform101XPFirebaseDatabase_MembersInjector.injectSetInitListener(newInstance, (Platform101XPFirebaseDbManager.InitDbResultListener) this.p0Provider2.get());
        return newInstance;
    }

    public static Platform101XPFirebaseDatabase_Factory create(Provider<Activity> provider, Provider<Platform101XPFirebaseDbManager.InitDbResultListener> provider2, Provider<Activity> provider3, Provider<Platform101XPFirebaseDbManager.InitDbResultListener> provider4) {
        return new Platform101XPFirebaseDatabase_Factory(provider, provider2, provider3, provider4);
    }

    public static Platform101XPFirebaseDatabase newInstance(Activity activity, Platform101XPFirebaseDbManager.InitDbResultListener initDbResultListener) {
        return new Platform101XPFirebaseDatabase(activity, initDbResultListener);
    }
}
