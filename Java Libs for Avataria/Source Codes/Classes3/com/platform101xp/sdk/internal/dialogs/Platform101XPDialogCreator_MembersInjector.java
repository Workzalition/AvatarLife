package com.platform101xp.sdk.internal.dialogs;

import android.app.Activity;
import android.app.Dialog;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDialogCreator_MembersInjector implements MembersInjector<Platform101XPDialogCreator> {
    private final Provider<Activity> p0Provider;
    private final Provider<Dialog[]> p0Provider2;

    public Platform101XPDialogCreator_MembersInjector(Provider<Activity> provider, Provider<Dialog[]> provider2) {
        this.p0Provider = provider;
        this.p0Provider2 = provider2;
    }

    public static MembersInjector<Platform101XPDialogCreator> create(Provider<Activity> provider, Provider<Dialog[]> provider2) {
        return new Platform101XPDialogCreator_MembersInjector(provider, provider2);
    }

    public void injectMembers(Platform101XPDialogCreator platform101XPDialogCreator) {
        injectSetCurrentActivity(platform101XPDialogCreator, (Activity) this.p0Provider.get());
        injectSetDialogs(platform101XPDialogCreator, (Dialog[]) this.p0Provider2.get());
    }

    public static void injectSetCurrentActivity(Platform101XPDialogCreator platform101XPDialogCreator, Activity activity) {
        platform101XPDialogCreator.setCurrentActivity(activity);
    }

    public static void injectSetDialogs(Platform101XPDialogCreator platform101XPDialogCreator, Dialog[] dialogArr) {
        platform101XPDialogCreator.setDialogs(dialogArr);
    }
}
