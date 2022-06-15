package com.platform101xp.sdk.internal.dialogs.nativedialogs;

import android.app.Activity;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogCreator;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPEulaDialog_MembersInjector implements MembersInjector<Platform101XPEulaDialog> {
    private final Provider<Activity> p0Provider;
    private final Provider<Platform101XPDialogCreator> p0Provider2;
    private final Provider<Platform101XPConfigManager> p0Provider3;
    private final Provider<Platform101XPSettings> p0Provider4;
    private final Provider<Platform101XPAnalytics> p0Provider5;

    public Platform101XPEulaDialog_MembersInjector(Provider<Activity> provider, Provider<Platform101XPDialogCreator> provider2, Provider<Platform101XPConfigManager> provider3, Provider<Platform101XPSettings> provider4, Provider<Platform101XPAnalytics> provider5) {
        this.p0Provider = provider;
        this.p0Provider2 = provider2;
        this.p0Provider3 = provider3;
        this.p0Provider4 = provider4;
        this.p0Provider5 = provider5;
    }

    public static MembersInjector<Platform101XPEulaDialog> create(Provider<Activity> provider, Provider<Platform101XPDialogCreator> provider2, Provider<Platform101XPConfigManager> provider3, Provider<Platform101XPSettings> provider4, Provider<Platform101XPAnalytics> provider5) {
        return new Platform101XPEulaDialog_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public void injectMembers(Platform101XPEulaDialog platform101XPEulaDialog) {
        injectSetCurrentActivity(platform101XPEulaDialog, (Activity) this.p0Provider.get());
        injectSetDialogCreator(platform101XPEulaDialog, (Platform101XPDialogCreator) this.p0Provider2.get());
        injectSetConfigManager(platform101XPEulaDialog, (Platform101XPConfigManager) this.p0Provider3.get());
        injectSetSettings(platform101XPEulaDialog, (Platform101XPSettings) this.p0Provider4.get());
        injectSetAnalytics(platform101XPEulaDialog, (Platform101XPAnalytics) this.p0Provider5.get());
    }

    public static void injectSetCurrentActivity(Platform101XPEulaDialog platform101XPEulaDialog, Activity activity) {
        platform101XPEulaDialog.setCurrentActivity(activity);
    }

    public static void injectSetDialogCreator(Platform101XPEulaDialog platform101XPEulaDialog, Platform101XPDialogCreator platform101XPDialogCreator) {
        platform101XPEulaDialog.setDialogCreator(platform101XPDialogCreator);
    }

    public static void injectSetConfigManager(Platform101XPEulaDialog platform101XPEulaDialog, Platform101XPConfigManager platform101XPConfigManager) {
        platform101XPEulaDialog.setConfigManager(platform101XPConfigManager);
    }

    public static void injectSetSettings(Platform101XPEulaDialog platform101XPEulaDialog, Platform101XPSettings platform101XPSettings) {
        platform101XPEulaDialog.setSettings(platform101XPSettings);
    }

    public static void injectSetAnalytics(Platform101XPEulaDialog platform101XPEulaDialog, Platform101XPAnalytics platform101XPAnalytics) {
        platform101XPEulaDialog.setAnalytics(platform101XPAnalytics);
    }
}
