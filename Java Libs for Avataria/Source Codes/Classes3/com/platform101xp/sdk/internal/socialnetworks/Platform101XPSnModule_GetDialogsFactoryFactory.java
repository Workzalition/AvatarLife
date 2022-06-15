package com.platform101xp.sdk.internal.socialnetworks;

import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPSnModule_GetDialogsFactoryFactory implements Factory<Platform101XPDialogFactory> {
    private final Platform101XPSnModule module;

    public Platform101XPSnModule_GetDialogsFactoryFactory(Platform101XPSnModule platform101XPSnModule) {
        this.module = platform101XPSnModule;
    }

    public Platform101XPDialogFactory get() {
        return getDialogsFactory(this.module);
    }

    public static Platform101XPSnModule_GetDialogsFactoryFactory create(Platform101XPSnModule platform101XPSnModule) {
        return new Platform101XPSnModule_GetDialogsFactoryFactory(platform101XPSnModule);
    }

    public static Platform101XPDialogFactory getDialogsFactory(Platform101XPSnModule platform101XPSnModule) {
        return (Platform101XPDialogFactory) Preconditions.checkNotNullFromProvides(platform101XPSnModule.getDialogsFactory());
    }
}
