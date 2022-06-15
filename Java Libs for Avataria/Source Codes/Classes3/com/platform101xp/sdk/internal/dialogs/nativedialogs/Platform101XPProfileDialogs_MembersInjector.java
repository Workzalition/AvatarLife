package com.platform101xp.sdk.internal.dialogs.nativedialogs;

import android.app.Activity;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogCreator;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPProfileDialogs_MembersInjector implements MembersInjector<Platform101XPProfileDialogs> {
    private final Provider<Activity> p0Provider;
    private final Provider<Platform101XPDialogCreator> p0Provider2;
    private final Provider<Platform101XPEulaDialog> p0Provider3;
    private final Provider<Platform101XPAnalytics> p0Provider4;

    public Platform101XPProfileDialogs_MembersInjector(Provider<Activity> provider, Provider<Platform101XPDialogCreator> provider2, Provider<Platform101XPEulaDialog> provider3, Provider<Platform101XPAnalytics> provider4) {
        this.p0Provider = provider;
        this.p0Provider2 = provider2;
        this.p0Provider3 = provider3;
        this.p0Provider4 = provider4;
    }

    public static MembersInjector<Platform101XPProfileDialogs> create(Provider<Activity> provider, Provider<Platform101XPDialogCreator> provider2, Provider<Platform101XPEulaDialog> provider3, Provider<Platform101XPAnalytics> provider4) {
        return new Platform101XPProfileDialogs_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(Platform101XPProfileDialogs platform101XPProfileDialogs) {
        injectSetCurrentActivity(platform101XPProfileDialogs, (Activity) this.p0Provider.get());
        injectSetDialogCreator(platform101XPProfileDialogs, (Platform101XPDialogCreator) this.p0Provider2.get());
        injectSetEulaDialog(platform101XPProfileDialogs, (Platform101XPEulaDialog) this.p0Provider3.get());
        injectSetAnalytics(platform101XPProfileDialogs, (Platform101XPAnalytics) this.p0Provider4.get());
    }

    public static void injectSetCurrentActivity(Platform101XPProfileDialogs platform101XPProfileDialogs, Activity activity) {
        platform101XPProfileDialogs.setCurrentActivity(activity);
    }

    public static void injectSetDialogCreator(Platform101XPProfileDialogs platform101XPProfileDialogs, Platform101XPDialogCreator platform101XPDialogCreator) {
        platform101XPProfileDialogs.setDialogCreator(platform101XPDialogCreator);
    }

    public static void injectSetEulaDialog(Platform101XPProfileDialogs platform101XPProfileDialogs, Platform101XPEulaDialog platform101XPEulaDialog) {
        platform101XPProfileDialogs.setEulaDialog(platform101XPEulaDialog);
    }

    public static void injectSetAnalytics(Platform101XPProfileDialogs platform101XPProfileDialogs, Platform101XPAnalytics platform101XPAnalytics) {
        platform101XPProfileDialogs.setAnalytics(platform101XPAnalytics);
    }
}
