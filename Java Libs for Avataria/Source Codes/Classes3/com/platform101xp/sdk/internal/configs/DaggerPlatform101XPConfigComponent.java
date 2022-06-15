package com.platform101xp.sdk.internal.configs;

import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class DaggerPlatform101XPConfigComponent implements Platform101XPConfigComponent {
    private final DaggerPlatform101XPConfigComponent platform101XPConfigComponent;
    private final Platform101XPConfigModule platform101XPConfigModule;

    private DaggerPlatform101XPConfigComponent(Platform101XPConfigModule platform101XPConfigModule) {
        this.platform101XPConfigComponent = this;
        this.platform101XPConfigModule = platform101XPConfigModule;
    }

    public static Builder builder() {
        return new Builder();
    }

    private Platform101XPConfigData platform101XPConfigData() {
        return injectPlatform101XPConfigData(Platform101XPConfigData_Factory.newInstance(Platform101XPConfigModule_GetCurrentSettingsFactory.getCurrentSettings(this.platform101XPConfigModule)));
    }

    private Platform101XPConfigDownloader platform101XPConfigDownloader() {
        return injectPlatform101XPConfigDownloader(Platform101XPConfigDownloader_Factory.newInstance(Platform101XPConfigModule_GetAppContextFactory.getAppContext(this.platform101XPConfigModule), Platform101XPConfigModule_GetMetaManagerFactory.getMetaManager(this.platform101XPConfigModule)));
    }

    @Override // com.platform101xp.sdk.internal.configs.Platform101XPConfigComponent
    public Platform101XPConfigManager getConfigManager() {
        return injectPlatform101XPConfigManager(Platform101XPConfigManager_Factory.newInstance(Platform101XPConfigModule_GetListenerFactory.getListener(this.platform101XPConfigModule), Platform101XPConfigModule_GetAppContextFactory.getAppContext(this.platform101XPConfigModule), Platform101XPConfigModule_GetMetaManagerFactory.getMetaManager(this.platform101XPConfigModule), Platform101XPConfigModule_GetMetaMatcherFactory.getMetaMatcher(this.platform101XPConfigModule), platform101XPConfigData(), platform101XPConfigDownloader(), new Platform101XPFirebaseConfig()));
    }

    private Platform101XPConfigData injectPlatform101XPConfigData(Platform101XPConfigData platform101XPConfigData) {
        Platform101XPConfigData_MembersInjector.injectSetSettings(platform101XPConfigData, Platform101XPConfigModule_GetCurrentSettingsFactory.getCurrentSettings(this.platform101XPConfigModule));
        return platform101XPConfigData;
    }

    private Platform101XPConfigDownloader injectPlatform101XPConfigDownloader(Platform101XPConfigDownloader platform101XPConfigDownloader) {
        Platform101XPConfigDownloader_MembersInjector.injectSetAppContext(platform101XPConfigDownloader, Platform101XPConfigModule_GetAppContextFactory.getAppContext(this.platform101XPConfigModule));
        Platform101XPConfigDownloader_MembersInjector.injectSetMetaManager(platform101XPConfigDownloader, Platform101XPConfigModule_GetMetaManagerFactory.getMetaManager(this.platform101XPConfigModule));
        return platform101XPConfigDownloader;
    }

    private Platform101XPConfigManager injectPlatform101XPConfigManager(Platform101XPConfigManager platform101XPConfigManager) {
        Platform101XPConfigManager_MembersInjector.injectSetListener(platform101XPConfigManager, Platform101XPConfigModule_GetListenerFactory.getListener(this.platform101XPConfigModule));
        Platform101XPConfigManager_MembersInjector.injectSetAppContext(platform101XPConfigManager, Platform101XPConfigModule_GetAppContextFactory.getAppContext(this.platform101XPConfigModule));
        Platform101XPConfigManager_MembersInjector.injectSetMetaManager(platform101XPConfigManager, Platform101XPConfigModule_GetMetaManagerFactory.getMetaManager(this.platform101XPConfigModule));
        Platform101XPConfigManager_MembersInjector.injectSetMetaMatcher(platform101XPConfigManager, Platform101XPConfigModule_GetMetaMatcherFactory.getMetaMatcher(this.platform101XPConfigModule));
        Platform101XPConfigManager_MembersInjector.injectSetData(platform101XPConfigManager, platform101XPConfigData());
        Platform101XPConfigManager_MembersInjector.injectSetConfigDownloader(platform101XPConfigManager, platform101XPConfigDownloader());
        Platform101XPConfigManager_MembersInjector.injectSetFirebaseConfig(platform101XPConfigManager, new Platform101XPFirebaseConfig());
        return platform101XPConfigManager;
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Builder {
        private Platform101XPConfigModule platform101XPConfigModule;

        private Builder() {
        }

        public Builder platform101XPConfigModule(Platform101XPConfigModule platform101XPConfigModule) {
            this.platform101XPConfigModule = (Platform101XPConfigModule) Preconditions.checkNotNull(platform101XPConfigModule);
            return this;
        }

        public Platform101XPConfigComponent build() {
            Preconditions.checkBuilderRequirement(this.platform101XPConfigModule, Platform101XPConfigModule.class);
            return new DaggerPlatform101XPConfigComponent(this.platform101XPConfigModule);
        }
    }
}
