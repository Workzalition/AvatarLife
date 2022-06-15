package com.platform101xp.sdk.internal.dialogs.nativedialogs;

import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogCreator;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPLogsDialog_MembersInjector implements MembersInjector<Platform101XPLogsDialog> {
    private final Provider<Platform101XPDialogCreator> p0Provider;

    public Platform101XPLogsDialog_MembersInjector(Provider<Platform101XPDialogCreator> provider) {
        this.p0Provider = provider;
    }

    public static MembersInjector<Platform101XPLogsDialog> create(Provider<Platform101XPDialogCreator> provider) {
        return new Platform101XPLogsDialog_MembersInjector(provider);
    }

    public void injectMembers(Platform101XPLogsDialog platform101XPLogsDialog) {
        injectSetDialogCreator(platform101XPLogsDialog, (Platform101XPDialogCreator) this.p0Provider.get());
    }

    public static void injectSetDialogCreator(Platform101XPLogsDialog platform101XPLogsDialog, Platform101XPDialogCreator platform101XPDialogCreator) {
        platform101XPLogsDialog.setDialogCreator(platform101XPDialogCreator);
    }
}
