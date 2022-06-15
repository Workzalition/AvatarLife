package com.platform101xp.sdk.internal.socialnetworks;

import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSocialNetwork;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPSnModule_GetListenerFactory implements Factory<Platform101XPSocialNetwork.SocialNetworkListener> {
    private final Platform101XPSnModule module;

    public Platform101XPSnModule_GetListenerFactory(Platform101XPSnModule platform101XPSnModule) {
        this.module = platform101XPSnModule;
    }

    public Platform101XPSocialNetwork.SocialNetworkListener get() {
        return getListener(this.module);
    }

    public static Platform101XPSnModule_GetListenerFactory create(Platform101XPSnModule platform101XPSnModule) {
        return new Platform101XPSnModule_GetListenerFactory(platform101XPSnModule);
    }

    public static Platform101XPSocialNetwork.SocialNetworkListener getListener(Platform101XPSnModule platform101XPSnModule) {
        return (Platform101XPSocialNetwork.SocialNetworkListener) Preconditions.checkNotNullFromProvides(platform101XPSnModule.getListener());
    }
}
