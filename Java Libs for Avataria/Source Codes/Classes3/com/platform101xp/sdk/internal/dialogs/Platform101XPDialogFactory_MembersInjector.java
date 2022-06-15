package com.platform101xp.sdk.internal.dialogs;

import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPEulaDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPInviteDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPLogsDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProgressDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDialogFactory_MembersInjector implements MembersInjector<Platform101XPDialogFactory> {
    private final Provider<Platform101XPEulaDialog> eulaDialogProvider;
    private final Provider<Platform101XPInviteDialog> inviteDialogProvider;
    private final Provider<Platform101XPLogsDialog> logsDialogProvider;
    private final Provider<Platform101XPProgressDialog> progressDialogsProvider;
    private final Provider<Platform101XPWarningDialogs> warningDialogsProvider;

    public Platform101XPDialogFactory_MembersInjector(Provider<Platform101XPWarningDialogs> provider, Provider<Platform101XPProgressDialog> provider2, Provider<Platform101XPInviteDialog> provider3, Provider<Platform101XPEulaDialog> provider4, Provider<Platform101XPLogsDialog> provider5) {
        this.warningDialogsProvider = provider;
        this.progressDialogsProvider = provider2;
        this.inviteDialogProvider = provider3;
        this.eulaDialogProvider = provider4;
        this.logsDialogProvider = provider5;
    }

    public static MembersInjector<Platform101XPDialogFactory> create(Provider<Platform101XPWarningDialogs> provider, Provider<Platform101XPProgressDialog> provider2, Provider<Platform101XPInviteDialog> provider3, Provider<Platform101XPEulaDialog> provider4, Provider<Platform101XPLogsDialog> provider5) {
        return new Platform101XPDialogFactory_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public void injectMembers(Platform101XPDialogFactory platform101XPDialogFactory) {
        injectWarningDialogs(platform101XPDialogFactory, (Platform101XPWarningDialogs) this.warningDialogsProvider.get());
        injectProgressDialogs(platform101XPDialogFactory, (Platform101XPProgressDialog) this.progressDialogsProvider.get());
        injectInviteDialog(platform101XPDialogFactory, (Platform101XPInviteDialog) this.inviteDialogProvider.get());
        injectEulaDialog(platform101XPDialogFactory, (Platform101XPEulaDialog) this.eulaDialogProvider.get());
        injectLogsDialog(platform101XPDialogFactory, (Platform101XPLogsDialog) this.logsDialogProvider.get());
    }

    public static void injectWarningDialogs(Platform101XPDialogFactory platform101XPDialogFactory, Platform101XPWarningDialogs platform101XPWarningDialogs) {
        platform101XPDialogFactory.warningDialogs = platform101XPWarningDialogs;
    }

    public static void injectProgressDialogs(Platform101XPDialogFactory platform101XPDialogFactory, Platform101XPProgressDialog platform101XPProgressDialog) {
        platform101XPDialogFactory.progressDialogs = platform101XPProgressDialog;
    }

    public static void injectInviteDialog(Platform101XPDialogFactory platform101XPDialogFactory, Platform101XPInviteDialog platform101XPInviteDialog) {
        platform101XPDialogFactory.inviteDialog = platform101XPInviteDialog;
    }

    public static void injectEulaDialog(Platform101XPDialogFactory platform101XPDialogFactory, Platform101XPEulaDialog platform101XPEulaDialog) {
        platform101XPDialogFactory.eulaDialog = platform101XPEulaDialog;
    }

    public static void injectLogsDialog(Platform101XPDialogFactory platform101XPDialogFactory, Platform101XPLogsDialog platform101XPLogsDialog) {
        platform101XPDialogFactory.logsDialog = platform101XPLogsDialog;
    }
}
