package com.platform101xp.sdk.internal.dialogs.nativedialogs;

import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogCreator;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPInviteDialog_MembersInjector implements MembersInjector<Platform101XPInviteDialog> {
    private final Provider<Platform101XPDialogCreator> p0Provider;

    public Platform101XPInviteDialog_MembersInjector(Provider<Platform101XPDialogCreator> provider) {
        this.p0Provider = provider;
    }

    public static MembersInjector<Platform101XPInviteDialog> create(Provider<Platform101XPDialogCreator> provider) {
        return new Platform101XPInviteDialog_MembersInjector(provider);
    }

    public void injectMembers(Platform101XPInviteDialog platform101XPInviteDialog) {
        injectSetDialogCreator(platform101XPInviteDialog, (Platform101XPDialogCreator) this.p0Provider.get());
    }

    public static void injectSetDialogCreator(Platform101XPInviteDialog platform101XPInviteDialog, Platform101XPDialogCreator platform101XPDialogCreator) {
        platform101XPInviteDialog.setDialogCreator(platform101XPDialogCreator);
    }
}
