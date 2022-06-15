package com.platform101xp.sdk.internal.support;

import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPSupportManager_MembersInjector implements MembersInjector<Platform101XPSupportManager> {
    private final Provider<Platform101XPHelpdesk> supportHelpdeskProvider;
    private final Provider<Platform101XPZendesk> supportZendeskProvider;

    public Platform101XPSupportManager_MembersInjector(Provider<Platform101XPHelpdesk> provider, Provider<Platform101XPZendesk> provider2) {
        this.supportHelpdeskProvider = provider;
        this.supportZendeskProvider = provider2;
    }

    public static MembersInjector<Platform101XPSupportManager> create(Provider<Platform101XPHelpdesk> provider, Provider<Platform101XPZendesk> provider2) {
        return new Platform101XPSupportManager_MembersInjector(provider, provider2);
    }

    public void injectMembers(Platform101XPSupportManager platform101XPSupportManager) {
        injectSupportHelpdesk(platform101XPSupportManager, (Platform101XPHelpdesk) this.supportHelpdeskProvider.get());
        injectSupportZendesk(platform101XPSupportManager, (Platform101XPZendesk) this.supportZendeskProvider.get());
    }

    public static void injectSupportHelpdesk(Platform101XPSupportManager platform101XPSupportManager, Platform101XPHelpdesk platform101XPHelpdesk) {
        platform101XPSupportManager.supportHelpdesk = platform101XPHelpdesk;
    }

    public static void injectSupportZendesk(Platform101XPSupportManager platform101XPSupportManager, Platform101XPZendesk platform101XPZendesk) {
        platform101XPSupportManager.supportZendesk = platform101XPZendesk;
    }
}
