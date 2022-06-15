package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import android.app.Activity;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDynamicLinks_Factory implements Factory<Platform101XPFirebaseDynamicLinks> {
    private final Provider<Activity> activityProvider;
    private final Provider<Activity> p0Provider;

    public Platform101XPFirebaseDynamicLinks_Factory(Provider<Activity> provider, Provider<Activity> provider2) {
        this.activityProvider = provider;
        this.p0Provider = provider2;
    }

    public Platform101XPFirebaseDynamicLinks get() {
        Platform101XPFirebaseDynamicLinks newInstance = newInstance((Activity) this.activityProvider.get());
        Platform101XPFirebaseDynamicLinks_MembersInjector.injectSetActivity(newInstance, (Activity) this.p0Provider.get());
        return newInstance;
    }

    public static Platform101XPFirebaseDynamicLinks_Factory create(Provider<Activity> provider, Provider<Activity> provider2) {
        return new Platform101XPFirebaseDynamicLinks_Factory(provider, provider2);
    }

    public static Platform101XPFirebaseDynamicLinks newInstance(Activity activity) {
        return new Platform101XPFirebaseDynamicLinks(activity);
    }
}
