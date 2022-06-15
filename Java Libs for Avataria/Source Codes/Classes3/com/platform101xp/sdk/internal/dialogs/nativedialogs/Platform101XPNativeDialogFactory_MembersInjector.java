package com.platform101xp.sdk.internal.dialogs.nativedialogs;

import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory_MembersInjector;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPNativeDialogFactory_MembersInjector implements MembersInjector<Platform101XPNativeDialogFactory> {
    private final Provider<Platform101XPAuthorizeDialogs> authorizeDialogsProvider;
    private final Provider<Platform101XPEulaDialog> eulaDialogProvider;
    private final Provider<Platform101XPInviteDialog> inviteDialogProvider;
    private final Provider<Platform101XPLogsDialog> logsDialogProvider;
    private final Provider<Platform101XPProfileDialogs> profileDialogsProvider;
    private final Provider<Platform101XPProgressDialog> progressDialogsProvider;
    private final Provider<Platform101XPWarningDialogs> warningDialogsProvider;

    public Platform101XPNativeDialogFactory_MembersInjector(Provider<Platform101XPWarningDialogs> provider, Provider<Platform101XPProgressDialog> provider2, Provider<Platform101XPInviteDialog> provider3, Provider<Platform101XPEulaDialog> provider4, Provider<Platform101XPLogsDialog> provider5, Provider<Platform101XPAuthorizeDialogs> provider6, Provider<Platform101XPProfileDialogs> provider7) {
        this.warningDialogsProvider = provider;
        this.progressDialogsProvider = provider2;
        this.inviteDialogProvider = provider3;
        this.eulaDialogProvider = provider4;
        this.logsDialogProvider = provider5;
        this.authorizeDialogsProvider = provider6;
        this.profileDialogsProvider = provider7;
    }

    public static MembersInjector<Platform101XPNativeDialogFactory> create(Provider<Platform101XPWarningDialogs> provider, Provider<Platform101XPProgressDialog> provider2, Provider<Platform101XPInviteDialog> provider3, Provider<Platform101XPEulaDialog> provider4, Provider<Platform101XPLogsDialog> provider5, Provider<Platform101XPAuthorizeDialogs> provider6, Provider<Platform101XPProfileDialogs> provider7) {
        return new Platform101XPNativeDialogFactory_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public void injectMembers(Platform101XPNativeDialogFactory platform101XPNativeDialogFactory) {
        Platform101XPDialogFactory_MembersInjector.injectWarningDialogs(platform101XPNativeDialogFactory, (Platform101XPWarningDialogs) this.warningDialogsProvider.get());
        Platform101XPDialogFactory_MembersInjector.injectProgressDialogs(platform101XPNativeDialogFactory, (Platform101XPProgressDialog) this.progressDialogsProvider.get());
        Platform101XPDialogFactory_MembersInjector.injectInviteDialog(platform101XPNativeDialogFactory, (Platform101XPInviteDialog) this.inviteDialogProvider.get());
        Platform101XPDialogFactory_MembersInjector.injectEulaDialog(platform101XPNativeDialogFactory, (Platform101XPEulaDialog) this.eulaDialogProvider.get());
        Platform101XPDialogFactory_MembersInjector.injectLogsDialog(platform101XPNativeDialogFactory, (Platform101XPLogsDialog) this.logsDialogProvider.get());
        injectAuthorizeDialogs(platform101XPNativeDialogFactory, (Platform101XPAuthorizeDialogs) this.authorizeDialogsProvider.get());
        injectProfileDialogs(platform101XPNativeDialogFactory, (Platform101XPProfileDialogs) this.profileDialogsProvider.get());
    }

    public static void injectAuthorizeDialogs(Platform101XPNativeDialogFactory platform101XPNativeDialogFactory, Platform101XPAuthorizeDialogs platform101XPAuthorizeDialogs) {
        platform101XPNativeDialogFactory.authorizeDialogs = platform101XPAuthorizeDialogs;
    }

    public static void injectProfileDialogs(Platform101XPNativeDialogFactory platform101XPNativeDialogFactory, Platform101XPProfileDialogs platform101XPProfileDialogs) {
        platform101XPNativeDialogFactory.profileDialogs = platform101XPProfileDialogs;
    }
}
