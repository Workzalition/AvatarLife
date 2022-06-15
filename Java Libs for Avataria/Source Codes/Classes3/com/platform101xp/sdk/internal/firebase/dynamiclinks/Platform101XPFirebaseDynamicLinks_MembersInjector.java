package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import android.app.Activity;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDynamicLinks_MembersInjector implements MembersInjector<Platform101XPFirebaseDynamicLinks> {
    private final Provider<Activity> p0Provider;

    public Platform101XPFirebaseDynamicLinks_MembersInjector(Provider<Activity> provider) {
        this.p0Provider = provider;
    }

    public static MembersInjector<Platform101XPFirebaseDynamicLinks> create(Provider<Activity> provider) {
        return new Platform101XPFirebaseDynamicLinks_MembersInjector(provider);
    }

    public void injectMembers(Platform101XPFirebaseDynamicLinks platform101XPFirebaseDynamicLinks) {
        injectSetActivity(platform101XPFirebaseDynamicLinks, (Activity) this.p0Provider.get());
    }

    public static void injectSetActivity(Platform101XPFirebaseDynamicLinks platform101XPFirebaseDynamicLinks, Activity activity) {
        platform101XPFirebaseDynamicLinks.setActivity(activity);
    }
}
