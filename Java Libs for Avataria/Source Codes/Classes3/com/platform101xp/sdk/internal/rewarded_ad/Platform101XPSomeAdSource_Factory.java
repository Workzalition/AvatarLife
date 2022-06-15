package com.platform101xp.sdk.internal.rewarded_ad;

import dagger.internal.Factory;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPSomeAdSource_Factory implements Factory<Platform101XPSomeAdSource> {
    public Platform101XPSomeAdSource get() {
        return newInstance();
    }

    public static Platform101XPSomeAdSource_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Platform101XPSomeAdSource newInstance() {
        return new Platform101XPSomeAdSource();
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    private static final class InstanceHolder {
        private static final Platform101XPSomeAdSource_Factory INSTANCE = new Platform101XPSomeAdSource_Factory();

        private InstanceHolder() {
        }
    }
}
