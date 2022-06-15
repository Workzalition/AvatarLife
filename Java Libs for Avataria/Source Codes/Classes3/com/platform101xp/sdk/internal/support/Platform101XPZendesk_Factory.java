package com.platform101xp.sdk.internal.support;

import android.app.Activity;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPZendesk_Factory implements Factory<Platform101XPZendesk> {
    private final Provider<Platform101XPConfigManager> configManagerProvider;
    private final Provider<Activity> currentActivityProvider;

    public Platform101XPZendesk_Factory(Provider<Activity> provider, Provider<Platform101XPConfigManager> provider2) {
        this.currentActivityProvider = provider;
        this.configManagerProvider = provider2;
    }

    public Platform101XPZendesk get() {
        Platform101XPZendesk newInstance = newInstance();
        Platform101XPZendesk_MembersInjector.injectCurrentActivity(newInstance, (Activity) this.currentActivityProvider.get());
        Platform101XPZendesk_MembersInjector.injectConfigManager(newInstance, (Platform101XPConfigManager) this.configManagerProvider.get());
        return newInstance;
    }

    public static Platform101XPZendesk_Factory create(Provider<Activity> provider, Provider<Platform101XPConfigManager> provider2) {
        return new Platform101XPZendesk_Factory(provider, provider2);
    }

    public static Platform101XPZendesk newInstance() {
        return new Platform101XPZendesk();
    }
}
