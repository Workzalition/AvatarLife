package com.platform101xp.sdk.internal.socialnetworks;

import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPGoogle_MembersInjector implements MembersInjector<Platform101XPGoogle> {
    private final Provider<Platform101XPDialogFactory> dialogsFactoryProvider;

    public Platform101XPGoogle_MembersInjector(Provider<Platform101XPDialogFactory> provider) {
        this.dialogsFactoryProvider = provider;
    }

    public static MembersInjector<Platform101XPGoogle> create(Provider<Platform101XPDialogFactory> provider) {
        return new Platform101XPGoogle_MembersInjector(provider);
    }

    public void injectMembers(Platform101XPGoogle platform101XPGoogle) {
        injectDialogsFactory(platform101XPGoogle, (Platform101XPDialogFactory) this.dialogsFactoryProvider.get());
    }

    public static void injectDialogsFactory(Platform101XPGoogle platform101XPGoogle, Platform101XPDialogFactory platform101XPDialogFactory) {
        platform101XPGoogle.dialogsFactory = platform101XPDialogFactory;
    }
}
