package com.platform101xp.sdk.internal.support;

import android.app.Activity;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPHelpdesk_MembersInjector implements MembersInjector<Platform101XPHelpdesk> {
    private final Provider<Platform101XPConfigManager> configManagerProvider;
    private final Provider<Activity> currentActivityProvider;

    public Platform101XPHelpdesk_MembersInjector(Provider<Activity> provider, Provider<Platform101XPConfigManager> provider2) {
        this.currentActivityProvider = provider;
        this.configManagerProvider = provider2;
    }

    public static MembersInjector<Platform101XPHelpdesk> create(Provider<Activity> provider, Provider<Platform101XPConfigManager> provider2) {
        return new Platform101XPHelpdesk_MembersInjector(provider, provider2);
    }

    public void injectMembers(Platform101XPHelpdesk platform101XPHelpdesk) {
        injectCurrentActivity(platform101XPHelpdesk, (Activity) this.currentActivityProvider.get());
        injectConfigManager(platform101XPHelpdesk, (Platform101XPConfigManager) this.configManagerProvider.get());
    }

    public static void injectCurrentActivity(Platform101XPHelpdesk platform101XPHelpdesk, Activity activity) {
        platform101XPHelpdesk.currentActivity = activity;
    }

    public static void injectConfigManager(Platform101XPHelpdesk platform101XPHelpdesk, Platform101XPConfigManager platform101XPConfigManager) {
        platform101XPHelpdesk.configManager = platform101XPConfigManager;
    }
}
