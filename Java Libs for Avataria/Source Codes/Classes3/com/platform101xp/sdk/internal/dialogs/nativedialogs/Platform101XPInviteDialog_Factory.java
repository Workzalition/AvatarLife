package com.platform101xp.sdk.internal.dialogs.nativedialogs;

import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogCreator;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPInviteDialog_Factory implements Factory<Platform101XPInviteDialog> {
    private final Provider<Platform101XPDialogCreator> dialogCreatorProvider;
    private final Provider<Platform101XPDialogCreator> p0Provider;

    public Platform101XPInviteDialog_Factory(Provider<Platform101XPDialogCreator> provider, Provider<Platform101XPDialogCreator> provider2) {
        this.dialogCreatorProvider = provider;
        this.p0Provider = provider2;
    }

    public Platform101XPInviteDialog get() {
        Platform101XPInviteDialog newInstance = newInstance((Platform101XPDialogCreator) this.dialogCreatorProvider.get());
        Platform101XPInviteDialog_MembersInjector.injectSetDialogCreator(newInstance, (Platform101XPDialogCreator) this.p0Provider.get());
        return newInstance;
    }

    public static Platform101XPInviteDialog_Factory create(Provider<Platform101XPDialogCreator> provider, Provider<Platform101XPDialogCreator> provider2) {
        return new Platform101XPInviteDialog_Factory(provider, provider2);
    }

    public static Platform101XPInviteDialog newInstance(Platform101XPDialogCreator platform101XPDialogCreator) {
        return new Platform101XPInviteDialog(platform101XPDialogCreator);
    }
}
