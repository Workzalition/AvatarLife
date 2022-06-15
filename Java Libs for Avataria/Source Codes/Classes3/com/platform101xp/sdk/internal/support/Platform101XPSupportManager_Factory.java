package com.platform101xp.sdk.internal.support;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPSupportManager_Factory implements Factory<Platform101XPSupportManager> {
    private final Provider<Platform101XPHelpdesk> supportHelpdeskProvider;
    private final Provider<Platform101XPZendesk> supportZendeskProvider;

    public Platform101XPSupportManager_Factory(Provider<Platform101XPHelpdesk> provider, Provider<Platform101XPZendesk> provider2) {
        this.supportHelpdeskProvider = provider;
        this.supportZendeskProvider = provider2;
    }

    public Platform101XPSupportManager get() {
        Platform101XPSupportManager newInstance = newInstance();
        Platform101XPSupportManager_MembersInjector.injectSupportHelpdesk(newInstance, (Platform101XPHelpdesk) this.supportHelpdeskProvider.get());
        Platform101XPSupportManager_MembersInjector.injectSupportZendesk(newInstance, (Platform101XPZendesk) this.supportZendeskProvider.get());
        return newInstance;
    }

    public static Platform101XPSupportManager_Factory create(Provider<Platform101XPHelpdesk> provider, Provider<Platform101XPZendesk> provider2) {
        return new Platform101XPSupportManager_Factory(provider, provider2);
    }

    public static Platform101XPSupportManager newInstance() {
        return new Platform101XPSupportManager();
    }
}
