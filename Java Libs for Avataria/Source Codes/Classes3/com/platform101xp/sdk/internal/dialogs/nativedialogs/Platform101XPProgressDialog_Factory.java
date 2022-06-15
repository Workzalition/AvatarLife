package com.platform101xp.sdk.internal.dialogs.nativedialogs;

import android.app.Activity;
import android.app.Dialog;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPProgressDialog_Factory implements Factory<Platform101XPProgressDialog> {
    private final Provider<Activity> currentActivityProvider;
    private final Provider<Dialog[]> dialogsProvider;

    public Platform101XPProgressDialog_Factory(Provider<Activity> provider, Provider<Dialog[]> provider2) {
        this.currentActivityProvider = provider;
        this.dialogsProvider = provider2;
    }

    public Platform101XPProgressDialog get() {
        return newInstance((Activity) this.currentActivityProvider.get(), (Dialog[]) this.dialogsProvider.get());
    }

    public static Platform101XPProgressDialog_Factory create(Provider<Activity> provider, Provider<Dialog[]> provider2) {
        return new Platform101XPProgressDialog_Factory(provider, provider2);
    }

    public static Platform101XPProgressDialog newInstance(Activity activity, Dialog[] dialogArr) {
        return new Platform101XPProgressDialog(activity, dialogArr);
    }
}
