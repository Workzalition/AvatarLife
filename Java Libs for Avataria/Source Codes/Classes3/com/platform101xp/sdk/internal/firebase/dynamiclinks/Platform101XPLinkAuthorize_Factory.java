package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import com.platform101xp.sdk.internal.token.Platform101XPTokenManager;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPLinkAuthorize_Factory implements Factory<Platform101XPLinkAuthorize> {
    private final Provider<Platform101XPAnalytics> analyticsProvider;
    private final Provider<String> clientIdProvider;
    private final Provider<String> deviceIdProvider;
    private final Provider<Platform101XPTokenManager> tokenManagerProvider;

    public Platform101XPLinkAuthorize_Factory(Provider<Platform101XPTokenManager> provider, Provider<String> provider2, Provider<String> provider3, Provider<Platform101XPAnalytics> provider4) {
        this.tokenManagerProvider = provider;
        this.clientIdProvider = provider2;
        this.deviceIdProvider = provider3;
        this.analyticsProvider = provider4;
    }

    public Platform101XPLinkAuthorize get() {
        Platform101XPLinkAuthorize newInstance = newInstance();
        Platform101XPLinkAuthorize_MembersInjector.injectTokenManager(newInstance, (Platform101XPTokenManager) this.tokenManagerProvider.get());
        Platform101XPLinkAuthorize_MembersInjector.injectClientId(newInstance, (String) this.clientIdProvider.get());
        Platform101XPLinkAuthorize_MembersInjector.injectDeviceId(newInstance, (String) this.deviceIdProvider.get());
        Platform101XPLinkAuthorize_MembersInjector.injectAnalytics(newInstance, (Platform101XPAnalytics) this.analyticsProvider.get());
        return newInstance;
    }

    public static Platform101XPLinkAuthorize_Factory create(Provider<Platform101XPTokenManager> provider, Provider<String> provider2, Provider<String> provider3, Provider<Platform101XPAnalytics> provider4) {
        return new Platform101XPLinkAuthorize_Factory(provider, provider2, provider3, provider4);
    }

    public static Platform101XPLinkAuthorize newInstance() {
        return new Platform101XPLinkAuthorize();
    }
}
