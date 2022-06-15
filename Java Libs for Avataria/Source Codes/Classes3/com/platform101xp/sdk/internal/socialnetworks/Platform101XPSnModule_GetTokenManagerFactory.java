package com.platform101xp.sdk.internal.socialnetworks;

import com.platform101xp.sdk.internal.token.Platform101XPTokenManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPSnModule_GetTokenManagerFactory implements Factory<Platform101XPTokenManager> {
    private final Platform101XPSnModule module;

    public Platform101XPSnModule_GetTokenManagerFactory(Platform101XPSnModule platform101XPSnModule) {
        this.module = platform101XPSnModule;
    }

    public Platform101XPTokenManager get() {
        return getTokenManager(this.module);
    }

    public static Platform101XPSnModule_GetTokenManagerFactory create(Platform101XPSnModule platform101XPSnModule) {
        return new Platform101XPSnModule_GetTokenManagerFactory(platform101XPSnModule);
    }

    public static Platform101XPTokenManager getTokenManager(Platform101XPSnModule platform101XPSnModule) {
        return (Platform101XPTokenManager) Preconditions.checkNotNullFromProvides(platform101XPSnModule.getTokenManager());
    }
}
