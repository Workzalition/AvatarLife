package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import com.platform101xp.sdk.internal.token.Platform101XPTokenManager;
import dagger.MembersInjector;
import javax.inject.Named;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPLinkAuthorize_MembersInjector implements MembersInjector<Platform101XPLinkAuthorize> {
    private final Provider<Platform101XPAnalytics> analyticsProvider;
    private final Provider<String> clientIdProvider;
    private final Provider<String> deviceIdProvider;
    private final Provider<Platform101XPTokenManager> tokenManagerProvider;

    public Platform101XPLinkAuthorize_MembersInjector(Provider<Platform101XPTokenManager> provider, Provider<String> provider2, Provider<String> provider3, Provider<Platform101XPAnalytics> provider4) {
        this.tokenManagerProvider = provider;
        this.clientIdProvider = provider2;
        this.deviceIdProvider = provider3;
        this.analyticsProvider = provider4;
    }

    public static MembersInjector<Platform101XPLinkAuthorize> create(Provider<Platform101XPTokenManager> provider, Provider<String> provider2, Provider<String> provider3, Provider<Platform101XPAnalytics> provider4) {
        return new Platform101XPLinkAuthorize_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(Platform101XPLinkAuthorize platform101XPLinkAuthorize) {
        injectTokenManager(platform101XPLinkAuthorize, (Platform101XPTokenManager) this.tokenManagerProvider.get());
        injectClientId(platform101XPLinkAuthorize, (String) this.clientIdProvider.get());
        injectDeviceId(platform101XPLinkAuthorize, (String) this.deviceIdProvider.get());
        injectAnalytics(platform101XPLinkAuthorize, (Platform101XPAnalytics) this.analyticsProvider.get());
    }

    public static void injectTokenManager(Platform101XPLinkAuthorize platform101XPLinkAuthorize, Platform101XPTokenManager platform101XPTokenManager) {
        platform101XPLinkAuthorize.tokenManager = platform101XPTokenManager;
    }

    @Named("clientId")
    public static void injectClientId(Platform101XPLinkAuthorize platform101XPLinkAuthorize, String str) {
        platform101XPLinkAuthorize.clientId = str;
    }

    @Named("deviceId")
    public static void injectDeviceId(Platform101XPLinkAuthorize platform101XPLinkAuthorize, String str) {
        platform101XPLinkAuthorize.deviceId = str;
    }

    public static void injectAnalytics(Platform101XPLinkAuthorize platform101XPLinkAuthorize, Platform101XPAnalytics platform101XPAnalytics) {
        platform101XPLinkAuthorize.analytics = platform101XPAnalytics;
    }
}
