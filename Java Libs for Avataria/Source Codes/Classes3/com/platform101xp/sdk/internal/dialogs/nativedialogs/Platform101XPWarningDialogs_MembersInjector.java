package com.platform101xp.sdk.internal.dialogs.nativedialogs;

import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogCreator;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPWarningDialogs_MembersInjector implements MembersInjector<Platform101XPWarningDialogs> {
    private final Provider<Platform101XPDialogCreator> p0Provider;

    public Platform101XPWarningDialogs_MembersInjector(Provider<Platform101XPDialogCreator> provider) {
        this.p0Provider = provider;
    }

    public static MembersInjector<Platform101XPWarningDialogs> create(Provider<Platform101XPDialogCreator> provider) {
        return new Platform101XPWarningDialogs_MembersInjector(provider);
    }

    public void injectMembers(Platform101XPWarningDialogs platform101XPWarningDialogs) {
        injectSetDialogCreator(platform101XPWarningDialogs, (Platform101XPDialogCreator) this.p0Provider.get());
    }

    public static void injectSetDialogCreator(Platform101XPWarningDialogs platform101XPWarningDialogs, Platform101XPDialogCreator platform101XPDialogCreator) {
        platform101XPWarningDialogs.setDialogCreator(platform101XPDialogCreator);
    }
}
