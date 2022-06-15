package com.platform101xp.sdk.internal.dialogs.webdialogs;

import android.app.Activity;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogCreator;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPWebDialogsConstructor_Factory implements Factory<Platform101XPWebDialogsConstructor> {
    private final Provider<Platform101XPAnalytics> analyticsProvider;
    private final Provider<String> clientIdProvider;
    private final Provider<Platform101XPConfigManager> configManagerProvider;
    private final Provider<Activity> currentActivityProvider;
    private final Provider<Platform101XPDialogCreator> dialogCreatorProvider;
    private final Provider<Activity> p0Provider;
    private final Provider<Platform101XPDialogCreator> p0Provider2;
    private final Provider<Platform101XPConfigManager> p0Provider3;
    private final Provider<Platform101XPSettings> p0Provider4;
    private final Provider<Platform101XPAnalytics> p0Provider5;
    private final Provider<Platform101XPWebDialogParameters> p0Provider6;
    private final Provider<Platform101XPWebDialogParameters> parametersProvider;
    private final Provider<Platform101XPSettings> settingsProvider;

    public Platform101XPWebDialogsConstructor_Factory(Provider<Activity> provider, Provider<Platform101XPDialogCreator> provider2, Provider<Platform101XPConfigManager> provider3, Provider<String> provider4, Provider<Platform101XPSettings> provider5, Provider<Platform101XPAnalytics> provider6, Provider<Platform101XPWebDialogParameters> provider7, Provider<Activity> provider8, Provider<Platform101XPDialogCreator> provider9, Provider<Platform101XPConfigManager> provider10, Provider<Platform101XPSettings> provider11, Provider<Platform101XPAnalytics> provider12, Provider<Platform101XPWebDialogParameters> provider13) {
        this.currentActivityProvider = provider;
        this.dialogCreatorProvider = provider2;
        this.configManagerProvider = provider3;
        this.clientIdProvider = provider4;
        this.settingsProvider = provider5;
        this.analyticsProvider = provider6;
        this.parametersProvider = provider7;
        this.p0Provider = provider8;
        this.p0Provider2 = provider9;
        this.p0Provider3 = provider10;
        this.p0Provider4 = provider11;
        this.p0Provider5 = provider12;
        this.p0Provider6 = provider13;
    }

    public Platform101XPWebDialogsConstructor get() {
        Platform101XPWebDialogsConstructor newInstance = newInstance((Activity) this.currentActivityProvider.get(), (Platform101XPDialogCreator) this.dialogCreatorProvider.get(), (Platform101XPConfigManager) this.configManagerProvider.get(), (String) this.clientIdProvider.get(), (Platform101XPSettings) this.settingsProvider.get(), (Platform101XPAnalytics) this.analyticsProvider.get(), (Platform101XPWebDialogParameters) this.parametersProvider.get());
        Platform101XPWebDialogsConstructor_MembersInjector.injectSetCurrentActivity(newInstance, (Activity) this.p0Provider.get());
        Platform101XPWebDialogsConstructor_MembersInjector.injectSetDialogCreator(newInstance, (Platform101XPDialogCreator) this.p0Provider2.get());
        Platform101XPWebDialogsConstructor_MembersInjector.injectSetConfigManager(newInstance, (Platform101XPConfigManager) this.p0Provider3.get());
        Platform101XPWebDialogsConstructor_MembersInjector.injectSetSettings(newInstance, (Platform101XPSettings) this.p0Provider4.get());
        Platform101XPWebDialogsConstructor_MembersInjector.injectSetAnalytics(newInstance, (Platform101XPAnalytics) this.p0Provider5.get());
        Platform101XPWebDialogsConstructor_MembersInjector.injectSetParameters(newInstance, (Platform101XPWebDialogParameters) this.p0Provider6.get());
        return newInstance;
    }

    public static Platform101XPWebDialogsConstructor_Factory create(Provider<Activity> provider, Provider<Platform101XPDialogCreator> provider2, Provider<Platform101XPConfigManager> provider3, Provider<String> provider4, Provider<Platform101XPSettings> provider5, Provider<Platform101XPAnalytics> provider6, Provider<Platform101XPWebDialogParameters> provider7, Provider<Activity> provider8, Provider<Platform101XPDialogCreator> provider9, Provider<Platform101XPConfigManager> provider10, Provider<Platform101XPSettings> provider11, Provider<Platform101XPAnalytics> provider12, Provider<Platform101XPWebDialogParameters> provider13) {
        return new Platform101XPWebDialogsConstructor_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static Platform101XPWebDialogsConstructor newInstance(Activity activity, Platform101XPDialogCreator platform101XPDialogCreator, Platform101XPConfigManager platform101XPConfigManager, String str, Platform101XPSettings platform101XPSettings, Platform101XPAnalytics platform101XPAnalytics, Platform101XPWebDialogParameters platform101XPWebDialogParameters) {
        return new Platform101XPWebDialogsConstructor(activity, platform101XPDialogCreator, platform101XPConfigManager, str, platform101XPSettings, platform101XPAnalytics, platform101XPWebDialogParameters);
    }
}
