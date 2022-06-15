package com.platform101xp.sdk.internal.configs;

import dagger.internal.Factory;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseConfig_Factory implements Factory<Platform101XPFirebaseConfig> {
    public Platform101XPFirebaseConfig get() {
        return newInstance();
    }

    public static Platform101XPFirebaseConfig_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Platform101XPFirebaseConfig newInstance() {
        return new Platform101XPFirebaseConfig();
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    private static final class InstanceHolder {
        private static final Platform101XPFirebaseConfig_Factory INSTANCE = new Platform101XPFirebaseConfig_Factory();

        private InstanceHolder() {
        }
    }
}
