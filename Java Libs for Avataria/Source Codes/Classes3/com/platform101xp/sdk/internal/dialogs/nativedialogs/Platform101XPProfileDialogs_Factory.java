package com.platform101xp.sdk.internal.dialogs.nativedialogs;

import android.app.Activity;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogCreator;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPProfileDialogs_Factory implements Factory<Platform101XPProfileDialogs> {
    private final Provider<Platform101XPAnalytics> analyticsProvider;
    private final Provider<Activity> currentActivityProvider;
    private final Provider<Platform101XPDialogCreator> dialogCreatorProvider;
    private final Provider<Platform101XPEulaDialog> eulaDialogProvider;
    private final Provider<Activity> p0Provider;
    private final Provider<Platform101XPDialogCreator> p0Provider2;
    private final Provider<Platform101XPEulaDialog> p0Provider3;
    private final Provider<Platform101XPAnalytics> p0Provider4;

    public Platform101XPProfileDialogs_Factory(Provider<Activity> provider, Provider<Platform101XPDialogCreator> provider2, Provider<Platform101XPEulaDialog> provider3, Provider<Platform101XPAnalytics> provider4, Provider<Activity> provider5, Provider<Platform101XPDialogCreator> provider6, Provider<Platform101XPEulaDialog> provider7, Provider<Platform101XPAnalytics> provider8) {
        this.currentActivityProvider = provider;
        this.dialogCreatorProvider = provider2;
        this.eulaDialogProvider = provider3;
        this.analyticsProvider = provider4;
        this.p0Provider = provider5;
        this.p0Provider2 = provider6;
        this.p0Provider3 = provider7;
        this.p0Provider4 = provider8;
    }

    public Platform101XPProfileDialogs get() {
        Platform101XPProfileDialogs newInstance = newInstance((Activity) this.currentActivityProvider.get(), (Platform101XPDialogCreator) this.dialogCreatorProvider.get(), (Platform101XPEulaDialog) this.eulaDialogProvider.get(), (Platform101XPAnalytics) this.analyticsProvider.get());
        Platform101XPProfileDialogs_MembersInjector.injectSetCurrentActivity(newInstance, (Activity) this.p0Provider.get());
        Platform101XPProfileDialogs_MembersInjector.injectSetDialogCreator(newInstance, (Platform101XPDialogCreator) this.p0Provider2.get());
        Platform101XPProfileDialogs_MembersInjector.injectSetEulaDialog(newInstance, (Platform101XPEulaDialog) this.p0Provider3.get());
        Platform101XPProfileDialogs_MembersInjector.injectSetAnalytics(newInstance, (Platform101XPAnalytics) this.p0Provider4.get());
        return newInstance;
    }

    public static Platform101XPProfileDialogs_Factory create(Provider<Activity> provider, Provider<Platform101XPDialogCreator> provider2, Provider<Platform101XPEulaDialog> provider3, Provider<Platform101XPAnalytics> provider4, Provider<Activity> provider5, Provider<Platform101XPDialogCreator> provider6, Provider<Platform101XPEulaDialog> provider7, Provider<Platform101XPAnalytics> provider8) {
        return new Platform101XPProfileDialogs_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static Platform101XPProfileDialogs newInstance(Activity activity, Platform101XPDialogCreator platform101XPDialogCreator, Platform101XPEulaDialog platform101XPEulaDialog, Platform101XPAnalytics platform101XPAnalytics) {
        return new Platform101XPProfileDialogs(activity, platform101XPDialogCreator, platform101XPEulaDialog, platform101XPAnalytics);
    }
}
