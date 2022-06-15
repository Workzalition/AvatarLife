package com.platform101xp.sdk.internal.socialnetworks;

import com.platform101xp.sdk.internal.token.Platform101XPTokenManager;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPPortal_MembersInjector implements MembersInjector<Platform101XPPortal> {
    private final Provider<Platform101XPTokenManager> tokenManagerProvider;

    public Platform101XPPortal_MembersInjector(Provider<Platform101XPTokenManager> provider) {
        this.tokenManagerProvider = provider;
    }

    public static MembersInjector<Platform101XPPortal> create(Provider<Platform101XPTokenManager> provider) {
        return new Platform101XPPortal_MembersInjector(provider);
    }

    public void injectMembers(Platform101XPPortal platform101XPPortal) {
        injectTokenManager(platform101XPPortal, (Platform101XPTokenManager) this.tokenManagerProvider.get());
    }

    public static void injectTokenManager(Platform101XPPortal platform101XPPortal, Platform101XPTokenManager platform101XPTokenManager) {
        platform101XPPortal.tokenManager = platform101XPTokenManager;
    }
}
