package com.platform101xp.sdk.internal.configs;

import android.content.Context;
import com.platform101xp.sdk.internal.Platform101XPMetaManager;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPConfigManager_MembersInjector implements MembersInjector<Platform101XPConfigManager> {
    private final Provider<Platform101XPConfigResultListener> p0Provider;
    private final Provider<Context> p0Provider2;
    private final Provider<Platform101XPMetaManager> p0Provider3;
    private final Provider<Platform101XPConfigMetaMatcher> p0Provider4;
    private final Provider<Platform101XPConfigData> p0Provider5;
    private final Provider<Platform101XPConfigDownloader> p0Provider6;
    private final Provider<Platform101XPFirebaseConfig> p0Provider7;

    public Platform101XPConfigManager_MembersInjector(Provider<Platform101XPConfigResultListener> provider, Provider<Context> provider2, Provider<Platform101XPMetaManager> provider3, Provider<Platform101XPConfigMetaMatcher> provider4, Provider<Platform101XPConfigData> provider5, Provider<Platform101XPConfigDownloader> provider6, Provider<Platform101XPFirebaseConfig> provider7) {
        this.p0Provider = provider;
        this.p0Provider2 = provider2;
        this.p0Provider3 = provider3;
        this.p0Provider4 = provider4;
        this.p0Provider5 = provider5;
        this.p0Provider6 = provider6;
        this.p0Provider7 = provider7;
    }

    public static MembersInjector<Platform101XPConfigManager> create(Provider<Platform101XPConfigResultListener> provider, Provider<Context> provider2, Provider<Platform101XPMetaManager> provider3, Provider<Platform101XPConfigMetaMatcher> provider4, Provider<Platform101XPConfigData> provider5, Provider<Platform101XPConfigDownloader> provider6, Provider<Platform101XPFirebaseConfig> provider7) {
        return new Platform101XPConfigManager_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public void injectMembers(Platform101XPConfigManager platform101XPConfigManager) {
        injectSetListener(platform101XPConfigManager, (Platform101XPConfigResultListener) this.p0Provider.get());
        injectSetAppContext(platform101XPConfigManager, (Context) this.p0Provider2.get());
        injectSetMetaManager(platform101XPConfigManager, (Platform101XPMetaManager) this.p0Provider3.get());
        injectSetMetaMatcher(platform101XPConfigManager, (Platform101XPConfigMetaMatcher) this.p0Provider4.get());
        injectSetData(platform101XPConfigManager, (Platform101XPConfigData) this.p0Provider5.get());
        injectSetConfigDownloader(platform101XPConfigManager, (Platform101XPConfigDownloader) this.p0Provider6.get());
        injectSetFirebaseConfig(platform101XPConfigManager, (Platform101XPFirebaseConfig) this.p0Provider7.get());
    }

    public static void injectSetListener(Platform101XPConfigManager platform101XPConfigManager, Platform101XPConfigResultListener platform101XPConfigResultListener) {
        platform101XPConfigManager.setListener(platform101XPConfigResultListener);
    }

    public static void injectSetAppContext(Platform101XPConfigManager platform101XPConfigManager, Context context) {
        platform101XPConfigManager.setAppContext(context);
    }

    public static void injectSetMetaManager(Platform101XPConfigManager platform101XPConfigManager, Platform101XPMetaManager platform101XPMetaManager) {
        platform101XPConfigManager.setMetaManager(platform101XPMetaManager);
    }

    public static void injectSetMetaMatcher(Platform101XPConfigManager platform101XPConfigManager, Platform101XPConfigMetaMatcher platform101XPConfigMetaMatcher) {
        platform101XPConfigManager.setMetaMatcher(platform101XPConfigMetaMatcher);
    }

    public static void injectSetData(Platform101XPConfigManager platform101XPConfigManager, Platform101XPConfigData platform101XPConfigData) {
        platform101XPConfigManager.setData(platform101XPConfigData);
    }

    public static void injectSetConfigDownloader(Platform101XPConfigManager platform101XPConfigManager, Platform101XPConfigDownloader platform101XPConfigDownloader) {
        platform101XPConfigManager.setConfigDownloader(platform101XPConfigDownloader);
    }

    public static void injectSetFirebaseConfig(Platform101XPConfigManager platform101XPConfigManager, Platform101XPFirebaseConfig platform101XPFirebaseConfig) {
        platform101XPConfigManager.setFirebaseConfig(platform101XPFirebaseConfig);
    }
}
