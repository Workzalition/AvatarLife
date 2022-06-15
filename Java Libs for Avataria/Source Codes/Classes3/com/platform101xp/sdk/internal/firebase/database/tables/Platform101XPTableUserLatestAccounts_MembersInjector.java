package com.platform101xp.sdk.internal.firebase.database.tables;

import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDatabase;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPTableUserLatestAccounts_MembersInjector implements MembersInjector<Platform101XPTableUserLatestAccounts> {
    private final Provider<Platform101XPFirebaseDatabase> p0Provider;

    public Platform101XPTableUserLatestAccounts_MembersInjector(Provider<Platform101XPFirebaseDatabase> provider) {
        this.p0Provider = provider;
    }

    public static MembersInjector<Platform101XPTableUserLatestAccounts> create(Provider<Platform101XPFirebaseDatabase> provider) {
        return new Platform101XPTableUserLatestAccounts_MembersInjector(provider);
    }

    public void injectMembers(Platform101XPTableUserLatestAccounts platform101XPTableUserLatestAccounts) {
        injectSetFirebaseDb(platform101XPTableUserLatestAccounts, (Platform101XPFirebaseDatabase) this.p0Provider.get());
    }

    public static void injectSetFirebaseDb(Platform101XPTableUserLatestAccounts platform101XPTableUserLatestAccounts, Platform101XPFirebaseDatabase platform101XPFirebaseDatabase) {
        platform101XPTableUserLatestAccounts.setFirebaseDb(platform101XPFirebaseDatabase);
    }
}
