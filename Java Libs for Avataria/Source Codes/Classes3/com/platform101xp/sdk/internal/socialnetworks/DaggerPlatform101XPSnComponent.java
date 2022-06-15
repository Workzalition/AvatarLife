package com.platform101xp.sdk.internal.socialnetworks;

import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class DaggerPlatform101XPSnComponent implements Platform101XPSnComponent {
    private final DaggerPlatform101XPSnComponent platform101XPSnComponent;
    private final Platform101XPSnModule platform101XPSnModule;

    private DaggerPlatform101XPSnComponent(Platform101XPSnModule platform101XPSnModule) {
        this.platform101XPSnComponent = this;
        this.platform101XPSnModule = platform101XPSnModule;
    }

    public static Builder builder() {
        return new Builder();
    }

    private Platform101XPPortal platform101XPPortal() {
        return injectPlatform101XPPortal(Platform101XPPortal_Factory.newInstance(Platform101XPSnModule_GetListenerFactory.getListener(this.platform101XPSnModule), Platform101XPSnModule_GetClientIdFactory.getClientId(this.platform101XPSnModule)));
    }

    private Platform101XPFacebook platform101XPFacebook() {
        return injectPlatform101XPFacebook(Platform101XPFacebook_Factory.newInstance(Platform101XPSnModule_GetListenerFactory.getListener(this.platform101XPSnModule), Platform101XPSnModule_GetConfigManagerFactory.getConfigManager(this.platform101XPSnModule)));
    }

    private Platform101XPVK platform101XPVK() {
        return new Platform101XPVK(Platform101XPSnModule_GetListenerFactory.getListener(this.platform101XPSnModule), Platform101XPSnModule_GetConfigManagerFactory.getConfigManager(this.platform101XPSnModule));
    }

    private Platform101XPOK platform101XPOK() {
        return new Platform101XPOK(Platform101XPSnModule_GetListenerFactory.getListener(this.platform101XPSnModule), Platform101XPSnModule_GetConfigManagerFactory.getConfigManager(this.platform101XPSnModule));
    }

    private Platform101XPGoogle platform101XPGoogle() {
        return injectPlatform101XPGoogle(Platform101XPGoogle_Factory.newInstance(Platform101XPSnModule_GetListenerFactory.getListener(this.platform101XPSnModule), Platform101XPSnModule_GetConfigManagerFactory.getConfigManager(this.platform101XPSnModule)));
    }

    @Override // com.platform101xp.sdk.internal.socialnetworks.Platform101XPSnComponent
    public Platform101XPSNManager getSnManager() {
        return injectPlatform101XPSNManager(Platform101XPSNManager_Factory.newInstance(Platform101XPSnModule_GetListenerFactory.getListener(this.platform101XPSnModule), Platform101XPSnModule_GetClientIdFactory.getClientId(this.platform101XPSnModule)));
    }

    private Platform101XPPortal injectPlatform101XPPortal(Platform101XPPortal platform101XPPortal) {
        Platform101XPPortal_MembersInjector.injectTokenManager(platform101XPPortal, Platform101XPSnModule_GetTokenManagerFactory.getTokenManager(this.platform101XPSnModule));
        return platform101XPPortal;
    }

    private Platform101XPFacebook injectPlatform101XPFacebook(Platform101XPFacebook platform101XPFacebook) {
        Platform101XPFacebook_MembersInjector.injectDialogsFactory(platform101XPFacebook, Platform101XPSnModule_GetDialogsFactoryFactory.getDialogsFactory(this.platform101XPSnModule));
        return platform101XPFacebook;
    }

    private Platform101XPGoogle injectPlatform101XPGoogle(Platform101XPGoogle platform101XPGoogle) {
        Platform101XPGoogle_MembersInjector.injectDialogsFactory(platform101XPGoogle, Platform101XPSnModule_GetDialogsFactoryFactory.getDialogsFactory(this.platform101XPSnModule));
        return platform101XPGoogle;
    }

    private Platform101XPSNManager injectPlatform101XPSNManager(Platform101XPSNManager platform101XPSNManager) {
        Platform101XPSNManager_MembersInjector.injectConfigManager(platform101XPSNManager, Platform101XPSnModule_GetConfigManagerFactory.getConfigManager(this.platform101XPSnModule));
        Platform101XPSNManager_MembersInjector.injectSnPortal(platform101XPSNManager, platform101XPPortal());
        Platform101XPSNManager_MembersInjector.injectSnFacebook(platform101XPSNManager, platform101XPFacebook());
        Platform101XPSNManager_MembersInjector.injectSnVk(platform101XPSNManager, platform101XPVK());
        Platform101XPSNManager_MembersInjector.injectSnOk(platform101XPSNManager, platform101XPOK());
        Platform101XPSNManager_MembersInjector.injectSnGoogle(platform101XPSNManager, platform101XPGoogle());
        return platform101XPSNManager;
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Builder {
        private Platform101XPSnModule platform101XPSnModule;

        private Builder() {
        }

        public Builder platform101XPSnModule(Platform101XPSnModule platform101XPSnModule) {
            this.platform101XPSnModule = (Platform101XPSnModule) Preconditions.checkNotNull(platform101XPSnModule);
            return this;
        }

        public Platform101XPSnComponent build() {
            Preconditions.checkBuilderRequirement(this.platform101XPSnModule, Platform101XPSnModule.class);
            return new DaggerPlatform101XPSnComponent(this.platform101XPSnModule);
        }
    }
}
