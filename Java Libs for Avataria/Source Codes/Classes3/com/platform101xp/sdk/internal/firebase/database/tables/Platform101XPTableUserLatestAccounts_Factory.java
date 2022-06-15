package com.platform101xp.sdk.internal.firebase.database.tables;

import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDatabase;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPTableUserLatestAccounts_Factory implements Factory<Platform101XPTableUserLatestAccounts> {
    private final Provider<Platform101XPFirebaseDatabase> firebaseDbProvider;
    private final Provider<Platform101XPFirebaseDatabase> p0Provider;

    public Platform101XPTableUserLatestAccounts_Factory(Provider<Platform101XPFirebaseDatabase> provider, Provider<Platform101XPFirebaseDatabase> provider2) {
        this.firebaseDbProvider = provider;
        this.p0Provider = provider2;
    }

    public Platform101XPTableUserLatestAccounts get() {
        Platform101XPTableUserLatestAccounts newInstance = newInstance((Platform101XPFirebaseDatabase) this.firebaseDbProvider.get());
        Platform101XPTableUserLatestAccounts_MembersInjector.injectSetFirebaseDb(newInstance, (Platform101XPFirebaseDatabase) this.p0Provider.get());
        return newInstance;
    }

    public static Platform101XPTableUserLatestAccounts_Factory create(Provider<Platform101XPFirebaseDatabase> provider, Provider<Platform101XPFirebaseDatabase> provider2) {
        return new Platform101XPTableUserLatestAccounts_Factory(provider, provider2);
    }

    public static Platform101XPTableUserLatestAccounts newInstance(Platform101XPFirebaseDatabase platform101XPFirebaseDatabase) {
        return new Platform101XPTableUserLatestAccounts(platform101XPFirebaseDatabase);
    }
}
