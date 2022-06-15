package com.platform101xp.sdk.internal.support;

import android.app.Activity;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPZendesk_MembersInjector implements MembersInjector<Platform101XPZendesk> {
    private final Provider<Platform101XPConfigManager> configManagerProvider;
    private final Provider<Activity> currentActivityProvider;

    public Platform101XPZendesk_MembersInjector(Provider<Activity> provider, Provider<Platform101XPConfigManager> provider2) {
        this.currentActivityProvider = provider;
        this.configManagerProvider = provider2;
    }

    public static MembersInjector<Platform101XPZendesk> create(Provider<Activity> provider, Provider<Platform101XPConfigManager> provider2) {
        return new Platform101XPZendesk_MembersInjector(provider, provider2);
    }

    public void injectMembers(Platform101XPZendesk platform101XPZendesk) {
        injectCurrentActivity(platform101XPZendesk, (Activity) this.currentActivityProvider.get());
        injectConfigManager(platform101XPZendesk, (Platform101XPConfigManager) this.configManagerProvider.get());
    }

    public static void injectCurrentActivity(Platform101XPZendesk platform101XPZendesk, Activity activity) {
        platform101XPZendesk.currentActivity = activity;
    }

    public static void injectConfigManager(Platform101XPZendesk platform101XPZendesk, Platform101XPConfigManager platform101XPConfigManager) {
        platform101XPZendesk.configManager = platform101XPConfigManager;
    }
}
