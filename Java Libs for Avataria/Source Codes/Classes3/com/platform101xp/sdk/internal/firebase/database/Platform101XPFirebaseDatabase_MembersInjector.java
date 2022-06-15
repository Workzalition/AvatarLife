package com.platform101xp.sdk.internal.firebase.database;

import android.app.Activity;
import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDatabase_MembersInjector implements MembersInjector<Platform101XPFirebaseDatabase> {
    private final Provider<Activity> p0Provider;
    private final Provider<Platform101XPFirebaseDbManager.InitDbResultListener> p0Provider2;

    public Platform101XPFirebaseDatabase_MembersInjector(Provider<Activity> provider, Provider<Platform101XPFirebaseDbManager.InitDbResultListener> provider2) {
        this.p0Provider = provider;
        this.p0Provider2 = provider2;
    }

    public static MembersInjector<Platform101XPFirebaseDatabase> create(Provider<Activity> provider, Provider<Platform101XPFirebaseDbManager.InitDbResultListener> provider2) {
        return new Platform101XPFirebaseDatabase_MembersInjector(provider, provider2);
    }

    public void injectMembers(Platform101XPFirebaseDatabase platform101XPFirebaseDatabase) {
        injectSetActivity(platform101XPFirebaseDatabase, (Activity) this.p0Provider.get());
        injectSetInitListener(platform101XPFirebaseDatabase, (Platform101XPFirebaseDbManager.InitDbResultListener) this.p0Provider2.get());
    }

    public static void injectSetActivity(Platform101XPFirebaseDatabase platform101XPFirebaseDatabase, Activity activity) {
        platform101XPFirebaseDatabase.setActivity(activity);
    }

    public static void injectSetInitListener(Platform101XPFirebaseDatabase platform101XPFirebaseDatabase, Platform101XPFirebaseDbManager.InitDbResultListener initDbResultListener) {
        platform101XPFirebaseDatabase.setInitListener(initDbResultListener);
    }
}
