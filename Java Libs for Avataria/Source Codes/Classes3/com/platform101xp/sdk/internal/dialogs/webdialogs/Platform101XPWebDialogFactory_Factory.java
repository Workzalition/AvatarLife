package com.platform101xp.sdk.internal.dialogs.webdialogs;

import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory_MembersInjector;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPEulaDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPInviteDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPLogsDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProgressDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPWebDialogFactory_Factory implements Factory<Platform101XPWebDialogFactory> {
    private final Provider<Platform101XPEulaDialog> eulaDialogProvider;
    private final Provider<Platform101XPInviteDialog> inviteDialogProvider;
    private final Provider<Platform101XPLogsDialog> logsDialogProvider;
    private final Provider<Platform101XPProgressDialog> progressDialogsProvider;
    private final Provider<Platform101XPWarningDialogs> warningDialogsProvider;
    private final Provider<Platform101XPWebDialogsConstructor> webDialogsConstructorProvider;

    public Platform101XPWebDialogFactory_Factory(Provider<Platform101XPWarningDialogs> provider, Provider<Platform101XPProgressDialog> provider2, Provider<Platform101XPInviteDialog> provider3, Provider<Platform101XPEulaDialog> provider4, Provider<Platform101XPLogsDialog> provider5, Provider<Platform101XPWebDialogsConstructor> provider6) {
        this.warningDialogsProvider = provider;
        this.progressDialogsProvider = provider2;
        this.inviteDialogProvider = provider3;
        this.eulaDialogProvider = provider4;
        this.logsDialogProvider = provider5;
        this.webDialogsConstructorProvider = provider6;
    }

    public Platform101XPWebDialogFactory get() {
        Platform101XPWebDialogFactory newInstance = newInstance();
        Platform101XPDialogFactory_MembersInjector.injectWarningDialogs(newInstance, (Platform101XPWarningDialogs) this.warningDialogsProvider.get());
        Platform101XPDialogFactory_MembersInjector.injectProgressDialogs(newInstance, (Platform101XPProgressDialog) this.progressDialogsProvider.get());
        Platform101XPDialogFactory_MembersInjector.injectInviteDialog(newInstance, (Platform101XPInviteDialog) this.inviteDialogProvider.get());
        Platform101XPDialogFactory_MembersInjector.injectEulaDialog(newInstance, (Platform101XPEulaDialog) this.eulaDialogProvider.get());
        Platform101XPDialogFactory_MembersInjector.injectLogsDialog(newInstance, (Platform101XPLogsDialog) this.logsDialogProvider.get());
        Platform101XPWebDialogFactory_MembersInjector.injectWebDialogsConstructor(newInstance, (Platform101XPWebDialogsConstructor) this.webDialogsConstructorProvider.get());
        return newInstance;
    }

    public static Platform101XPWebDialogFactory_Factory create(Provider<Platform101XPWarningDialogs> provider, Provider<Platform101XPProgressDialog> provider2, Provider<Platform101XPInviteDialog> provider3, Provider<Platform101XPEulaDialog> provider4, Provider<Platform101XPLogsDialog> provider5, Provider<Platform101XPWebDialogsConstructor> provider6) {
        return new Platform101XPWebDialogFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static Platform101XPWebDialogFactory newInstance() {
        return new Platform101XPWebDialogFactory();
    }
}
