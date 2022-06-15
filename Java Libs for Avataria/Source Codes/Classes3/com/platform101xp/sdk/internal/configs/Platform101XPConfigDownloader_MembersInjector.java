package com.platform101xp.sdk.internal.configs;

import android.content.Context;
import com.platform101xp.sdk.internal.Platform101XPMetaManager;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPConfigDownloader_MembersInjector implements MembersInjector<Platform101XPConfigDownloader> {
    private final Provider<Context> p0Provider;
    private final Provider<Platform101XPMetaManager> p0Provider2;

    public Platform101XPConfigDownloader_MembersInjector(Provider<Context> provider, Provider<Platform101XPMetaManager> provider2) {
        this.p0Provider = provider;
        this.p0Provider2 = provider2;
    }

    public static MembersInjector<Platform101XPConfigDownloader> create(Provider<Context> provider, Provider<Platform101XPMetaManager> provider2) {
        return new Platform101XPConfigDownloader_MembersInjector(provider, provider2);
    }

    public void injectMembers(Platform101XPConfigDownloader platform101XPConfigDownloader) {
        injectSetAppContext(platform101XPConfigDownloader, (Context) this.p0Provider.get());
        injectSetMetaManager(platform101XPConfigDownloader, (Platform101XPMetaManager) this.p0Provider2.get());
    }

    public static void injectSetAppContext(Platform101XPConfigDownloader platform101XPConfigDownloader, Context context) {
        platform101XPConfigDownloader.setAppContext(context);
    }

    public static void injectSetMetaManager(Platform101XPConfigDownloader platform101XPConfigDownloader, Platform101XPMetaManager platform101XPMetaManager) {
        platform101XPConfigDownloader.setMetaManager(platform101XPMetaManager);
    }
}
