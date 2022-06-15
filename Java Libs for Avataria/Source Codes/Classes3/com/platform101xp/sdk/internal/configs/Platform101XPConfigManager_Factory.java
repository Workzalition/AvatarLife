package com.platform101xp.sdk.internal.configs;

import android.content.Context;
import com.platform101xp.sdk.internal.Platform101XPMetaManager;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPConfigManager_Factory implements Factory<Platform101XPConfigManager> {
    private final Provider<Context> appContextProvider;
    private final Provider<Platform101XPConfigDownloader> configDownloaderProvider;
    private final Provider<Platform101XPConfigData> dataProvider;
    private final Provider<Platform101XPFirebaseConfig> firebaseConfigProvider;
    private final Provider<Platform101XPConfigResultListener> listenerProvider;
    private final Provider<Platform101XPMetaManager> metaManagerProvider;
    private final Provider<Platform101XPConfigMetaMatcher> metaMatcherProvider;
    private final Provider<Platform101XPConfigResultListener> p0Provider;
    private final Provider<Context> p0Provider2;
    private final Provider<Platform101XPMetaManager> p0Provider3;
    private final Provider<Platform101XPConfigMetaMatcher> p0Provider4;
    private final Provider<Platform101XPConfigData> p0Provider5;
    private final Provider<Platform101XPConfigDownloader> p0Provider6;
    private final Provider<Platform101XPFirebaseConfig> p0Provider7;

    public Platform101XPConfigManager_Factory(Provider<Platform101XPConfigResultListener> provider, Provider<Context> provider2, Provider<Platform101XPMetaManager> provider3, Provider<Platform101XPConfigMetaMatcher> provider4, Provider<Platform101XPConfigData> provider5, Provider<Platform101XPConfigDownloader> provider6, Provider<Platform101XPFirebaseConfig> provider7, Provider<Platform101XPConfigResultListener> provider8, Provider<Context> provider9, Provider<Platform101XPMetaManager> provider10, Provider<Platform101XPConfigMetaMatcher> provider11, Provider<Platform101XPConfigData> provider12, Provider<Platform101XPConfigDownloader> provider13, Provider<Platform101XPFirebaseConfig> provider14) {
        this.listenerProvider = provider;
        this.appContextProvider = provider2;
        this.metaManagerProvider = provider3;
        this.metaMatcherProvider = provider4;
        this.dataProvider = provider5;
        this.configDownloaderProvider = provider6;
        this.firebaseConfigProvider = provider7;
        this.p0Provider = provider8;
        this.p0Provider2 = provider9;
        this.p0Provider3 = provider10;
        this.p0Provider4 = provider11;
        this.p0Provider5 = provider12;
        this.p0Provider6 = provider13;
        this.p0Provider7 = provider14;
    }

    public Platform101XPConfigManager get() {
        Platform101XPConfigManager newInstance = newInstance((Platform101XPConfigResultListener) this.listenerProvider.get(), (Context) this.appContextProvider.get(), (Platform101XPMetaManager) this.metaManagerProvider.get(), (Platform101XPConfigMetaMatcher) this.metaMatcherProvider.get(), (Platform101XPConfigData) this.dataProvider.get(), (Platform101XPConfigDownloader) this.configDownloaderProvider.get(), (Platform101XPFirebaseConfig) this.firebaseConfigProvider.get());
        Platform101XPConfigManager_MembersInjector.injectSetListener(newInstance, (Platform101XPConfigResultListener) this.p0Provider.get());
        Platform101XPConfigManager_MembersInjector.injectSetAppContext(newInstance, (Context) this.p0Provider2.get());
        Platform101XPConfigManager_MembersInjector.injectSetMetaManager(newInstance, (Platform101XPMetaManager) this.p0Provider3.get());
        Platform101XPConfigManager_MembersInjector.injectSetMetaMatcher(newInstance, (Platform101XPConfigMetaMatcher) this.p0Provider4.get());
        Platform101XPConfigManager_MembersInjector.injectSetData(newInstance, (Platform101XPConfigData) this.p0Provider5.get());
        Platform101XPConfigManager_MembersInjector.injectSetConfigDownloader(newInstance, (Platform101XPConfigDownloader) this.p0Provider6.get());
        Platform101XPConfigManager_MembersInjector.injectSetFirebaseConfig(newInstance, (Platform101XPFirebaseConfig) this.p0Provider7.get());
        return newInstance;
    }

    public static Platform101XPConfigManager_Factory create(Provider<Platform101XPConfigResultListener> provider, Provider<Context> provider2, Provider<Platform101XPMetaManager> provider3, Provider<Platform101XPConfigMetaMatcher> provider4, Provider<Platform101XPConfigData> provider5, Provider<Platform101XPConfigDownloader> provider6, Provider<Platform101XPFirebaseConfig> provider7, Provider<Platform101XPConfigResultListener> provider8, Provider<Context> provider9, Provider<Platform101XPMetaManager> provider10, Provider<Platform101XPConfigMetaMatcher> provider11, Provider<Platform101XPConfigData> provider12, Provider<Platform101XPConfigDownloader> provider13, Provider<Platform101XPFirebaseConfig> provider14) {
        return new Platform101XPConfigManager_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14);
    }

    public static Platform101XPConfigManager newInstance(Platform101XPConfigResultListener platform101XPConfigResultListener, Context context, Platform101XPMetaManager platform101XPMetaManager, Platform101XPConfigMetaMatcher platform101XPConfigMetaMatcher, Platform101XPConfigData platform101XPConfigData, Platform101XPConfigDownloader platform101XPConfigDownloader, Platform101XPFirebaseConfig platform101XPFirebaseConfig) {
        return new Platform101XPConfigManager(platform101XPConfigResultListener, context, platform101XPMetaManager, platform101XPConfigMetaMatcher, platform101XPConfigData, platform101XPConfigDownloader, platform101XPFirebaseConfig);
    }
}
