package com.platform101xp.sdk.internal.dialogs;

import android.app.Activity;
import android.app.Dialog;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDialogCreator_Factory implements Factory<Platform101XPDialogCreator> {
    private final Provider<Activity> currentActivityProvider;
    private final Provider<Dialog[]> dialogsProvider;
    private final Provider<Activity> p0Provider;
    private final Provider<Dialog[]> p0Provider2;

    public Platform101XPDialogCreator_Factory(Provider<Activity> provider, Provider<Dialog[]> provider2, Provider<Activity> provider3, Provider<Dialog[]> provider4) {
        this.currentActivityProvider = provider;
        this.dialogsProvider = provider2;
        this.p0Provider = provider3;
        this.p0Provider2 = provider4;
    }

    public Platform101XPDialogCreator get() {
        Platform101XPDialogCreator newInstance = newInstance((Activity) this.currentActivityProvider.get(), (Dialog[]) this.dialogsProvider.get());
        Platform101XPDialogCreator_MembersInjector.injectSetCurrentActivity(newInstance, (Activity) this.p0Provider.get());
        Platform101XPDialogCreator_MembersInjector.injectSetDialogs(newInstance, (Dialog[]) this.p0Provider2.get());
        return newInstance;
    }

    public static Platform101XPDialogCreator_Factory create(Provider<Activity> provider, Provider<Dialog[]> provider2, Provider<Activity> provider3, Provider<Dialog[]> provider4) {
        return new Platform101XPDialogCreator_Factory(provider, provider2, provider3, provider4);
    }

    public static Platform101XPDialogCreator newInstance(Activity activity, Dialog[] dialogArr) {
        return new Platform101XPDialogCreator(activity, dialogArr);
    }
}
