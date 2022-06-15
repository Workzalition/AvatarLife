package com.platform101xp.sdk.internal.dialogs.webdialogs;

import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory_MembersInjector;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPEulaDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPInviteDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPLogsDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProgressDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPWebDialogFactory_MembersInjector implements MembersInjector<Platform101XPWebDialogFactory> {
    private final Provider<Platform101XPEulaDialog> eulaDialogProvider;
    private final Provider<Platform101XPInviteDialog> inviteDialogProvider;
    private final Provider<Platform101XPLogsDialog> logsDialogProvider;
    private final Provider<Platform101XPProgressDialog> progressDialogsProvider;
    private final Provider<Platform101XPWarningDialogs> warningDialogsProvider;
    private final Provider<Platform101XPWebDialogsConstructor> webDialogsConstructorProvider;

    public Platform101XPWebDialogFactory_MembersInjector(Provider<Platform101XPWarningDialogs> provider, Provider<Platform101XPProgressDialog> provider2, Provider<Platform101XPInviteDialog> provider3, Provider<Platform101XPEulaDialog> provider4, Provider<Platform101XPLogsDialog> provider5, Provider<Platform101XPWebDialogsConstructor> provider6) {
        this.warningDialogsProvider = provider;
        this.progressDialogsProvider = provider2;
        this.inviteDialogProvider = provider3;
        this.eulaDialogProvider = provider4;
        this.logsDialogProvider = provider5;
        this.webDialogsConstructorProvider = provider6;
    }

    public static MembersInjector<Platform101XPWebDialogFactory> create(Provider<Platform101XPWarningDialogs> provider, Provider<Platform101XPProgressDialog> provider2, Provider<Platform101XPInviteDialog> provider3, Provider<Platform101XPEulaDialog> provider4, Provider<Platform101XPLogsDialog> provider5, Provider<Platform101XPWebDialogsConstructor> provider6) {
        return new Platform101XPWebDialogFactory_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public void injectMembers(Platform101XPWebDialogFactory platform101XPWebDialogFactory) {
        Platform101XPDialogFactory_MembersInjector.injectWarningDialogs(platform101XPWebDialogFactory, (Platform101XPWarningDialogs) this.warningDialogsProvider.get());
        Platform101XPDialogFactory_MembersInjector.injectProgressDialogs(platform101XPWebDialogFactory, (Platform101XPProgressDialog) this.progressDialogsProvider.get());
        Platform101XPDialogFactory_MembersInjector.injectInviteDialog(platform101XPWebDialogFactory, (Platform101XPInviteDialog) this.inviteDialogProvider.get());
        Platform101XPDialogFactory_MembersInjector.injectEulaDialog(platform101XPWebDialogFactory, (Platform101XPEulaDialog) this.eulaDialogProvider.get());
        Platform101XPDialogFactory_MembersInjector.injectLogsDialog(platform101XPWebDialogFactory, (Platform101XPLogsDialog) this.logsDialogProvider.get());
        injectWebDialogsConstructor(platform101XPWebDialogFactory, (Platform101XPWebDialogsConstructor) this.webDialogsConstructorProvider.get());
    }

    public static void injectWebDialogsConstructor(Platform101XPWebDialogFactory platform101XPWebDialogFactory, Platform101XPWebDialogsConstructor platform101XPWebDialogsConstructor) {
        platform101XPWebDialogFactory.webDialogsConstructor = platform101XPWebDialogsConstructor;
    }
}
