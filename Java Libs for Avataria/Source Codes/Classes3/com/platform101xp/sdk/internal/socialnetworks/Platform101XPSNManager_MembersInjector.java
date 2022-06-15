package com.platform101xp.sdk.internal.socialnetworks;

import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPSNManager_MembersInjector implements MembersInjector<Platform101XPSNManager> {
    private final Provider<Platform101XPConfigManager> configManagerProvider;
    private final Provider<Platform101XPFacebook> snFacebookProvider;
    private final Provider<Platform101XPGoogle> snGoogleProvider;
    private final Provider<Platform101XPOK> snOkProvider;
    private final Provider<Platform101XPPortal> snPortalProvider;
    private final Provider<Platform101XPVK> snVkProvider;

    public Platform101XPSNManager_MembersInjector(Provider<Platform101XPConfigManager> provider, Provider<Platform101XPPortal> provider2, Provider<Platform101XPFacebook> provider3, Provider<Platform101XPVK> provider4, Provider<Platform101XPOK> provider5, Provider<Platform101XPGoogle> provider6) {
        this.configManagerProvider = provider;
        this.snPortalProvider = provider2;
        this.snFacebookProvider = provider3;
        this.snVkProvider = provider4;
        this.snOkProvider = provider5;
        this.snGoogleProvider = provider6;
    }

    public static MembersInjector<Platform101XPSNManager> create(Provider<Platform101XPConfigManager> provider, Provider<Platform101XPPortal> provider2, Provider<Platform101XPFacebook> provider3, Provider<Platform101XPVK> provider4, Provider<Platform101XPOK> provider5, Provider<Platform101XPGoogle> provider6) {
        return new Platform101XPSNManager_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public void injectMembers(Platform101XPSNManager platform101XPSNManager) {
        injectConfigManager(platform101XPSNManager, (Platform101XPConfigManager) this.configManagerProvider.get());
        injectSnPortal(platform101XPSNManager, (Platform101XPPortal) this.snPortalProvider.get());
        injectSnFacebook(platform101XPSNManager, (Platform101XPFacebook) this.snFacebookProvider.get());
        injectSnVk(platform101XPSNManager, (Platform101XPVK) this.snVkProvider.get());
        injectSnOk(platform101XPSNManager, (Platform101XPOK) this.snOkProvider.get());
        injectSnGoogle(platform101XPSNManager, (Platform101XPGoogle) this.snGoogleProvider.get());
    }

    public static void injectConfigManager(Platform101XPSNManager platform101XPSNManager, Platform101XPConfigManager platform101XPConfigManager) {
        platform101XPSNManager.configManager = platform101XPConfigManager;
    }

    public static void injectSnPortal(Platform101XPSNManager platform101XPSNManager, Platform101XPPortal platform101XPPortal) {
        platform101XPSNManager.snPortal = platform101XPPortal;
    }

    public static void injectSnFacebook(Platform101XPSNManager platform101XPSNManager, Platform101XPFacebook platform101XPFacebook) {
        platform101XPSNManager.snFacebook = platform101XPFacebook;
    }

    public static void injectSnVk(Platform101XPSNManager platform101XPSNManager, Platform101XPVK platform101XPVK) {
        platform101XPSNManager.snVk = platform101XPVK;
    }

    public static void injectSnOk(Platform101XPSNManager platform101XPSNManager, Platform101XPOK platform101XPOK) {
        platform101XPSNManager.snOk = platform101XPOK;
    }

    public static void injectSnGoogle(Platform101XPSNManager platform101XPSNManager, Platform101XPGoogle platform101XPGoogle) {
        platform101XPSNManager.snGoogle = platform101XPGoogle;
    }
}
