package com.platform101xp.sdk.internal.configs;

import android.content.Context;
import com.platform101xp.sdk.internal.Platform101XPMetaManager;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPConfigDownloader_Factory implements Factory<Platform101XPConfigDownloader> {
    private final Provider<Context> appContextProvider;
    private final Provider<Platform101XPMetaManager> metaManagerProvider;
    private final Provider<Context> p0Provider;
    private final Provider<Platform101XPMetaManager> p0Provider2;

    public Platform101XPConfigDownloader_Factory(Provider<Context> provider, Provider<Platform101XPMetaManager> provider2, Provider<Context> provider3, Provider<Platform101XPMetaManager> provider4) {
        this.appContextProvider = provider;
        this.metaManagerProvider = provider2;
        this.p0Provider = provider3;
        this.p0Provider2 = provider4;
    }

    public Platform101XPConfigDownloader get() {
        Platform101XPConfigDownloader newInstance = newInstance((Context) this.appContextProvider.get(), (Platform101XPMetaManager) this.metaManagerProvider.get());
        Platform101XPConfigDownloader_MembersInjector.injectSetAppContext(newInstance, (Context) this.p0Provider.get());
        Platform101XPConfigDownloader_MembersInjector.injectSetMetaManager(newInstance, (Platform101XPMetaManager) this.p0Provider2.get());
        return newInstance;
    }

    public static Platform101XPConfigDownloader_Factory create(Provider<Context> provider, Provider<Platform101XPMetaManager> provider2, Provider<Context> provider3, Provider<Platform101XPMetaManager> provider4) {
        return new Platform101XPConfigDownloader_Factory(provider, provider2, provider3, provider4);
    }

    public static Platform101XPConfigDownloader newInstance(Context context, Platform101XPMetaManager platform101XPMetaManager) {
        return new Platform101XPConfigDownloader(context, platform101XPMetaManager);
    }
}
