package com.platform101xp.sdk.internal.dialogs.webdialogs;

import android.app.Activity;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogCreator;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPWebDialogsConstructor_MembersInjector implements MembersInjector<Platform101XPWebDialogsConstructor> {
    private final Provider<Activity> p0Provider;
    private final Provider<Platform101XPDialogCreator> p0Provider2;
    private final Provider<Platform101XPConfigManager> p0Provider3;
    private final Provider<Platform101XPSettings> p0Provider4;
    private final Provider<Platform101XPAnalytics> p0Provider5;
    private final Provider<Platform101XPWebDialogParameters> p0Provider6;

    public Platform101XPWebDialogsConstructor_MembersInjector(Provider<Activity> provider, Provider<Platform101XPDialogCreator> provider2, Provider<Platform101XPConfigManager> provider3, Provider<Platform101XPSettings> provider4, Provider<Platform101XPAnalytics> provider5, Provider<Platform101XPWebDialogParameters> provider6) {
        this.p0Provider = provider;
        this.p0Provider2 = provider2;
        this.p0Provider3 = provider3;
        this.p0Provider4 = provider4;
        this.p0Provider5 = provider5;
        this.p0Provider6 = provider6;
    }

    public static MembersInjector<Platform101XPWebDialogsConstructor> create(Provider<Activity> provider, Provider<Platform101XPDialogCreator> provider2, Provider<Platform101XPConfigManager> provider3, Provider<Platform101XPSettings> provider4, Provider<Platform101XPAnalytics> provider5, Provider<Platform101XPWebDialogParameters> provider6) {
        return new Platform101XPWebDialogsConstructor_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public void injectMembers(Platform101XPWebDialogsConstructor platform101XPWebDialogsConstructor) {
        injectSetCurrentActivity(platform101XPWebDialogsConstructor, (Activity) this.p0Provider.get());
        injectSetDialogCreator(platform101XPWebDialogsConstructor, (Platform101XPDialogCreator) this.p0Provider2.get());
        injectSetConfigManager(platform101XPWebDialogsConstructor, (Platform101XPConfigManager) this.p0Provider3.get());
        injectSetSettings(platform101XPWebDialogsConstructor, (Platform101XPSettings) this.p0Provider4.get());
        injectSetAnalytics(platform101XPWebDialogsConstructor, (Platform101XPAnalytics) this.p0Provider5.get());
        injectSetParameters(platform101XPWebDialogsConstructor, (Platform101XPWebDialogParameters) this.p0Provider6.get());
    }

    public static void injectSetCurrentActivity(Platform101XPWebDialogsConstructor platform101XPWebDialogsConstructor, Activity activity) {
        platform101XPWebDialogsConstructor.setCurrentActivity(activity);
    }

    public static void injectSetDialogCreator(Platform101XPWebDialogsConstructor platform101XPWebDialogsConstructor, Platform101XPDialogCreator platform101XPDialogCreator) {
        platform101XPWebDialogsConstructor.setDialogCreator(platform101XPDialogCreator);
    }

    public static void injectSetConfigManager(Platform101XPWebDialogsConstructor platform101XPWebDialogsConstructor, Platform101XPConfigManager platform101XPConfigManager) {
        platform101XPWebDialogsConstructor.setConfigManager(platform101XPConfigManager);
    }

    public static void injectSetSettings(Platform101XPWebDialogsConstructor platform101XPWebDialogsConstructor, Platform101XPSettings platform101XPSettings) {
        platform101XPWebDialogsConstructor.setSettings(platform101XPSettings);
    }

    public static void injectSetAnalytics(Platform101XPWebDialogsConstructor platform101XPWebDialogsConstructor, Platform101XPAnalytics platform101XPAnalytics) {
        platform101XPWebDialogsConstructor.setAnalytics(platform101XPAnalytics);
    }

    public static void injectSetParameters(Platform101XPWebDialogsConstructor platform101XPWebDialogsConstructor, Platform101XPWebDialogParameters platform101XPWebDialogParameters) {
        platform101XPWebDialogsConstructor.setParameters(platform101XPWebDialogParameters);
    }
}
