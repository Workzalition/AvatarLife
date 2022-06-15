package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import com.platform101xp.sdk.internal.token.Platform101XPTokenManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDynamicLinksModule_GetTokenManagerInstanceFactory implements Factory<Platform101XPTokenManager> {
    private final Platform101XPDynamicLinksModule module;

    public Platform101XPDynamicLinksModule_GetTokenManagerInstanceFactory(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        this.module = platform101XPDynamicLinksModule;
    }

    public Platform101XPTokenManager get() {
        return getTokenManagerInstance(this.module);
    }

    public static Platform101XPDynamicLinksModule_GetTokenManagerInstanceFactory create(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        return new Platform101XPDynamicLinksModule_GetTokenManagerInstanceFactory(platform101XPDynamicLinksModule);
    }

    public static Platform101XPTokenManager getTokenManagerInstance(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        return (Platform101XPTokenManager) Preconditions.checkNotNullFromProvides(platform101XPDynamicLinksModule.getTokenManagerInstance());
    }
}
