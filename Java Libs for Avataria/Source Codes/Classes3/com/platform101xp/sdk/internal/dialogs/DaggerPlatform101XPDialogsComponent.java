package com.platform101xp.sdk.internal.dialogs;

import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPAuthorizeDialogs;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPAuthorizeDialogs_Factory;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPAuthorizeDialogs_MembersInjector;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPEulaDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPEulaDialog_Factory;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPEulaDialog_MembersInjector;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPInviteDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPInviteDialog_Factory;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPInviteDialog_MembersInjector;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPLogsDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPLogsDialog_Factory;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPLogsDialog_MembersInjector;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPNativeDialogFactory;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPNativeDialogFactory_Factory;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPNativeDialogFactory_MembersInjector;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProfileDialogs;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProfileDialogs_Factory;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProfileDialogs_MembersInjector;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProgressDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs_Factory;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs_MembersInjector;
import com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogFactory;
import com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogFactory_Factory;
import com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogFactory_MembersInjector;
import com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogsConstructor;
import com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogsConstructor_Factory;
import com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogsConstructor_MembersInjector;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class DaggerPlatform101XPDialogsComponent implements Platform101XPDialogsComponent {
    private final Platform101XPDialogModule platform101XPDialogModule;
    private final DaggerPlatform101XPDialogsComponent platform101XPDialogsComponent;

    private DaggerPlatform101XPDialogsComponent(Platform101XPDialogModule platform101XPDialogModule) {
        this.platform101XPDialogsComponent = this;
        this.platform101XPDialogModule = platform101XPDialogModule;
    }

    public static Builder builder() {
        return new Builder();
    }

    private Platform101XPDialogCreator platform101XPDialogCreator() {
        return injectPlatform101XPDialogCreator(Platform101XPDialogCreator_Factory.newInstance(Platform101XPDialogModule_GetActivityFactory.getActivity(this.platform101XPDialogModule), Platform101XPDialogModule_GetAllDialogsFactory.getAllDialogs(this.platform101XPDialogModule)));
    }

    private Platform101XPWarningDialogs platform101XPWarningDialogs() {
        return injectPlatform101XPWarningDialogs(Platform101XPWarningDialogs_Factory.newInstance(platform101XPDialogCreator()));
    }

    private Platform101XPProgressDialog platform101XPProgressDialog() {
        return new Platform101XPProgressDialog(Platform101XPDialogModule_GetActivityFactory.getActivity(this.platform101XPDialogModule), Platform101XPDialogModule_GetAllDialogsFactory.getAllDialogs(this.platform101XPDialogModule));
    }

    private Platform101XPInviteDialog platform101XPInviteDialog() {
        return injectPlatform101XPInviteDialog(Platform101XPInviteDialog_Factory.newInstance(platform101XPDialogCreator()));
    }

    private Platform101XPEulaDialog platform101XPEulaDialog() {
        return injectPlatform101XPEulaDialog(Platform101XPEulaDialog_Factory.newInstance(Platform101XPDialogModule_GetActivityFactory.getActivity(this.platform101XPDialogModule), platform101XPDialogCreator(), Platform101XPDialogModule_GetConfigFactory.getConfig(this.platform101XPDialogModule), Platform101XPDialogModule_GetCurrentSettingsFactory.getCurrentSettings(this.platform101XPDialogModule), Platform101XPDialogModule_GetPlatformAnalyticsFactory.getPlatformAnalytics(this.platform101XPDialogModule)));
    }

    private Platform101XPLogsDialog platform101XPLogsDialog() {
        return injectPlatform101XPLogsDialog(Platform101XPLogsDialog_Factory.newInstance(platform101XPDialogCreator()));
    }

    private Platform101XPAuthorizeDialogs platform101XPAuthorizeDialogs() {
        return injectPlatform101XPAuthorizeDialogs(Platform101XPAuthorizeDialogs_Factory.newInstance(platform101XPDialogCreator()));
    }

    private Platform101XPProfileDialogs platform101XPProfileDialogs() {
        return injectPlatform101XPProfileDialogs(Platform101XPProfileDialogs_Factory.newInstance(Platform101XPDialogModule_GetActivityFactory.getActivity(this.platform101XPDialogModule), platform101XPDialogCreator(), platform101XPEulaDialog(), Platform101XPDialogModule_GetPlatformAnalyticsFactory.getPlatformAnalytics(this.platform101XPDialogModule)));
    }

    private Platform101XPNativeDialogFactory platform101XPNativeDialogFactory() {
        return injectPlatform101XPNativeDialogFactory(Platform101XPNativeDialogFactory_Factory.newInstance());
    }

    private Platform101XPWebDialogsConstructor platform101XPWebDialogsConstructor() {
        return injectPlatform101XPWebDialogsConstructor(Platform101XPWebDialogsConstructor_Factory.newInstance(Platform101XPDialogModule_GetActivityFactory.getActivity(this.platform101XPDialogModule), platform101XPDialogCreator(), Platform101XPDialogModule_GetConfigFactory.getConfig(this.platform101XPDialogModule), Platform101XPDialogModule_GetIdClientFactory.getIdClient(this.platform101XPDialogModule), Platform101XPDialogModule_GetCurrentSettingsFactory.getCurrentSettings(this.platform101XPDialogModule), Platform101XPDialogModule_GetPlatformAnalyticsFactory.getPlatformAnalytics(this.platform101XPDialogModule), Platform101XPDialogModule_GetParametersFactory.getParameters(this.platform101XPDialogModule)));
    }

    private Platform101XPWebDialogFactory platform101XPWebDialogFactory() {
        return injectPlatform101XPWebDialogFactory(Platform101XPWebDialogFactory_Factory.newInstance());
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogsComponent
    public Platform101XPDialogsManager getDialogManager() {
        return new Platform101XPDialogsManager(Platform101XPDialogModule_GetAllDialogsFactory.getAllDialogs(this.platform101XPDialogModule), Platform101XPDialogModule_GetConfigFactory.getConfig(this.platform101XPDialogModule), platform101XPNativeDialogFactory(), platform101XPWebDialogFactory());
    }

    private Platform101XPDialogCreator injectPlatform101XPDialogCreator(Platform101XPDialogCreator platform101XPDialogCreator) {
        Platform101XPDialogCreator_MembersInjector.injectSetCurrentActivity(platform101XPDialogCreator, Platform101XPDialogModule_GetActivityFactory.getActivity(this.platform101XPDialogModule));
        Platform101XPDialogCreator_MembersInjector.injectSetDialogs(platform101XPDialogCreator, Platform101XPDialogModule_GetAllDialogsFactory.getAllDialogs(this.platform101XPDialogModule));
        return platform101XPDialogCreator;
    }

    private Platform101XPWarningDialogs injectPlatform101XPWarningDialogs(Platform101XPWarningDialogs platform101XPWarningDialogs) {
        Platform101XPWarningDialogs_MembersInjector.injectSetDialogCreator(platform101XPWarningDialogs, platform101XPDialogCreator());
        return platform101XPWarningDialogs;
    }

    private Platform101XPInviteDialog injectPlatform101XPInviteDialog(Platform101XPInviteDialog platform101XPInviteDialog) {
        Platform101XPInviteDialog_MembersInjector.injectSetDialogCreator(platform101XPInviteDialog, platform101XPDialogCreator());
        return platform101XPInviteDialog;
    }

    private Platform101XPEulaDialog injectPlatform101XPEulaDialog(Platform101XPEulaDialog platform101XPEulaDialog) {
        Platform101XPEulaDialog_MembersInjector.injectSetCurrentActivity(platform101XPEulaDialog, Platform101XPDialogModule_GetActivityFactory.getActivity(this.platform101XPDialogModule));
        Platform101XPEulaDialog_MembersInjector.injectSetDialogCreator(platform101XPEulaDialog, platform101XPDialogCreator());
        Platform101XPEulaDialog_MembersInjector.injectSetConfigManager(platform101XPEulaDialog, Platform101XPDialogModule_GetConfigFactory.getConfig(this.platform101XPDialogModule));
        Platform101XPEulaDialog_MembersInjector.injectSetSettings(platform101XPEulaDialog, Platform101XPDialogModule_GetCurrentSettingsFactory.getCurrentSettings(this.platform101XPDialogModule));
        Platform101XPEulaDialog_MembersInjector.injectSetAnalytics(platform101XPEulaDialog, Platform101XPDialogModule_GetPlatformAnalyticsFactory.getPlatformAnalytics(this.platform101XPDialogModule));
        return platform101XPEulaDialog;
    }

    private Platform101XPLogsDialog injectPlatform101XPLogsDialog(Platform101XPLogsDialog platform101XPLogsDialog) {
        Platform101XPLogsDialog_MembersInjector.injectSetDialogCreator(platform101XPLogsDialog, platform101XPDialogCreator());
        return platform101XPLogsDialog;
    }

    private Platform101XPAuthorizeDialogs injectPlatform101XPAuthorizeDialogs(Platform101XPAuthorizeDialogs platform101XPAuthorizeDialogs) {
        Platform101XPAuthorizeDialogs_MembersInjector.injectSetDialogCreator(platform101XPAuthorizeDialogs, platform101XPDialogCreator());
        return platform101XPAuthorizeDialogs;
    }

    private Platform101XPProfileDialogs injectPlatform101XPProfileDialogs(Platform101XPProfileDialogs platform101XPProfileDialogs) {
        Platform101XPProfileDialogs_MembersInjector.injectSetCurrentActivity(platform101XPProfileDialogs, Platform101XPDialogModule_GetActivityFactory.getActivity(this.platform101XPDialogModule));
        Platform101XPProfileDialogs_MembersInjector.injectSetDialogCreator(platform101XPProfileDialogs, platform101XPDialogCreator());
        Platform101XPProfileDialogs_MembersInjector.injectSetEulaDialog(platform101XPProfileDialogs, platform101XPEulaDialog());
        Platform101XPProfileDialogs_MembersInjector.injectSetAnalytics(platform101XPProfileDialogs, Platform101XPDialogModule_GetPlatformAnalyticsFactory.getPlatformAnalytics(this.platform101XPDialogModule));
        return platform101XPProfileDialogs;
    }

    private Platform101XPNativeDialogFactory injectPlatform101XPNativeDialogFactory(Platform101XPNativeDialogFactory platform101XPNativeDialogFactory) {
        Platform101XPDialogFactory_MembersInjector.injectWarningDialogs(platform101XPNativeDialogFactory, platform101XPWarningDialogs());
        Platform101XPDialogFactory_MembersInjector.injectProgressDialogs(platform101XPNativeDialogFactory, platform101XPProgressDialog());
        Platform101XPDialogFactory_MembersInjector.injectInviteDialog(platform101XPNativeDialogFactory, platform101XPInviteDialog());
        Platform101XPDialogFactory_MembersInjector.injectEulaDialog(platform101XPNativeDialogFactory, platform101XPEulaDialog());
        Platform101XPDialogFactory_MembersInjector.injectLogsDialog(platform101XPNativeDialogFactory, platform101XPLogsDialog());
        Platform101XPNativeDialogFactory_MembersInjector.injectAuthorizeDialogs(platform101XPNativeDialogFactory, platform101XPAuthorizeDialogs());
        Platform101XPNativeDialogFactory_MembersInjector.injectProfileDialogs(platform101XPNativeDialogFactory, platform101XPProfileDialogs());
        return platform101XPNativeDialogFactory;
    }

    private Platform101XPWebDialogsConstructor injectPlatform101XPWebDialogsConstructor(Platform101XPWebDialogsConstructor platform101XPWebDialogsConstructor) {
        Platform101XPWebDialogsConstructor_MembersInjector.injectSetCurrentActivity(platform101XPWebDialogsConstructor, Platform101XPDialogModule_GetActivityFactory.getActivity(this.platform101XPDialogModule));
        Platform101XPWebDialogsConstructor_MembersInjector.injectSetDialogCreator(platform101XPWebDialogsConstructor, platform101XPDialogCreator());
        Platform101XPWebDialogsConstructor_MembersInjector.injectSetConfigManager(platform101XPWebDialogsConstructor, Platform101XPDialogModule_GetConfigFactory.getConfig(this.platform101XPDialogModule));
        Platform101XPWebDialogsConstructor_MembersInjector.injectSetSettings(platform101XPWebDialogsConstructor, Platform101XPDialogModule_GetCurrentSettingsFactory.getCurrentSettings(this.platform101XPDialogModule));
        Platform101XPWebDialogsConstructor_MembersInjector.injectSetAnalytics(platform101XPWebDialogsConstructor, Platform101XPDialogModule_GetPlatformAnalyticsFactory.getPlatformAnalytics(this.platform101XPDialogModule));
        Platform101XPWebDialogsConstructor_MembersInjector.injectSetParameters(platform101XPWebDialogsConstructor, Platform101XPDialogModule_GetParametersFactory.getParameters(this.platform101XPDialogModule));
        return platform101XPWebDialogsConstructor;
    }

    private Platform101XPWebDialogFactory injectPlatform101XPWebDialogFactory(Platform101XPWebDialogFactory platform101XPWebDialogFactory) {
        Platform101XPDialogFactory_MembersInjector.injectWarningDialogs(platform101XPWebDialogFactory, platform101XPWarningDialogs());
        Platform101XPDialogFactory_MembersInjector.injectProgressDialogs(platform101XPWebDialogFactory, platform101XPProgressDialog());
        Platform101XPDialogFactory_MembersInjector.injectInviteDialog(platform101XPWebDialogFactory, platform101XPInviteDialog());
        Platform101XPDialogFactory_MembersInjector.injectEulaDialog(platform101XPWebDialogFactory, platform101XPEulaDialog());
        Platform101XPDialogFactory_MembersInjector.injectLogsDialog(platform101XPWebDialogFactory, platform101XPLogsDialog());
        Platform101XPWebDialogFactory_MembersInjector.injectWebDialogsConstructor(platform101XPWebDialogFactory, platform101XPWebDialogsConstructor());
        return platform101XPWebDialogFactory;
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Builder {
        private Platform101XPDialogModule platform101XPDialogModule;

        private Builder() {
        }

        public Builder platform101XPDialogModule(Platform101XPDialogModule platform101XPDialogModule) {
            this.platform101XPDialogModule = (Platform101XPDialogModule) Preconditions.checkNotNull(platform101XPDialogModule);
            return this;
        }

        public Platform101XPDialogsComponent build() {
            Preconditions.checkBuilderRequirement(this.platform101XPDialogModule, Platform101XPDialogModule.class);
            return new DaggerPlatform101XPDialogsComponent(this.platform101XPDialogModule);
        }
    }
}
