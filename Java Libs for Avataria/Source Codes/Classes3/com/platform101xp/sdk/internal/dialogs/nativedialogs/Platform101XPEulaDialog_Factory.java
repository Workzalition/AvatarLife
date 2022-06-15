package com.platform101xp.sdk.internal.dialogs.nativedialogs;

import android.app.Activity;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogCreator;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPEulaDialog_Factory implements Factory<Platform101XPEulaDialog> {
    private final Provider<Platform101XPAnalytics> analyticsProvider;
    private final Provider<Platform101XPConfigManager> configManagerProvider;
    private final Provider<Activity> currentActivityProvider;
    private final Provider<Platform101XPDialogCreator> dialogCreatorProvider;
    private final Provider<Activity> p0Provider;
    private final Provider<Platform101XPDialogCreator> p0Provider2;
    private final Provider<Platform101XPConfigManager> p0Provider3;
    private final Provider<Platform101XPSettings> p0Provider4;
    private final Provider<Platform101XPAnalytics> p0Provider5;
    private final Provider<Platform101XPSettings> settingsProvider;

    public Platform101XPEulaDialog_Factory(Provider<Activity> provider, Provider<Platform101XPDialogCreator> provider2, Provider<Platform101XPConfigManager> provider3, Provider<Platform101XPSettings> provider4, Provider<Platform101XPAnalytics> provider5, Provider<Activity> provider6, Provider<Platform101XPDialogCreator> provider7, Provider<Platform101XPConfigManager> provider8, Provider<Platform101XPSettings> provider9, Provider<Platform101XPAnalytics> provider10) {
        this.currentActivityProvider = provider;
        this.dialogCreatorProvider = provider2;
        this.configManagerProvider = provider3;
        this.settingsProvider = provider4;
        this.analyticsProvider = provider5;
        this.p0Provider = provider6;
        this.p0Provider2 = provider7;
        this.p0Provider3 = provider8;
        this.p0Provider4 = provider9;
        this.p0Provider5 = provider10;
    }

    public Platform101XPEulaDialog get() {
        Platform101XPEulaDialog newInstance = newInstance((Activity) this.currentActivityProvider.get(), (Platform101XPDialogCreator) this.dialogCreatorProvider.get(), (Platform101XPConfigManager) this.configManagerProvider.get(), (Platform101XPSettings) this.settingsProvider.get(), (Platform101XPAnalytics) this.analyticsProvider.get());
        Platform101XPEulaDialog_MembersInjector.injectSetCurrentActivity(newInstance, (Activity) this.p0Provider.get());
        Platform101XPEulaDialog_MembersInjector.injectSetDialogCreator(newInstance, (Platform101XPDialogCreator) this.p0Provider2.get());
        Platform101XPEulaDialog_MembersInjector.injectSetConfigManager(newInstance, (Platform101XPConfigManager) this.p0Provider3.get());
        Platform101XPEulaDialog_MembersInjector.injectSetSettings(newInstance, (Platform101XPSettings) this.p0Provider4.get());
        Platform101XPEulaDialog_MembersInjector.injectSetAnalytics(newInstance, (Platform101XPAnalytics) this.p0Provider5.get());
        return newInstance;
    }

    public static Platform101XPEulaDialog_Factory create(Provider<Activity> provider, Provider<Platform101XPDialogCreator> provider2, Provider<Platform101XPConfigManager> provider3, Provider<Platform101XPSettings> provider4, Provider<Platform101XPAnalytics> provider5, Provider<Activity> provider6, Provider<Platform101XPDialogCreator> provider7, Provider<Platform101XPConfigManager> provider8, Provider<Platform101XPSettings> provider9, Provider<Platform101XPAnalytics> provider10) {
        return new Platform101XPEulaDialog_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static Platform101XPEulaDialog newInstance(Activity activity, Platform101XPDialogCreator platform101XPDialogCreator, Platform101XPConfigManager platform101XPConfigManager, Platform101XPSettings platform101XPSettings, Platform101XPAnalytics platform101XPAnalytics) {
        return new Platform101XPEulaDialog(activity, platform101XPDialogCreator, platform101XPConfigManager, platform101XPSettings, platform101XPAnalytics);
    }
}
