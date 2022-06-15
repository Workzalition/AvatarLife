package com.platform101xp.sdk.internal.firebase.database.tables;

import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDatabase;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPTableUserTokenData_MembersInjector implements MembersInjector<Platform101XPTableUserTokenData> {
    private final Provider<Platform101XPFirebaseDatabase> p0Provider;

    public Platform101XPTableUserTokenData_MembersInjector(Provider<Platform101XPFirebaseDatabase> provider) {
        this.p0Provider = provider;
    }

    public static MembersInjector<Platform101XPTableUserTokenData> create(Provider<Platform101XPFirebaseDatabase> provider) {
        return new Platform101XPTableUserTokenData_MembersInjector(provider);
    }

    public void injectMembers(Platform101XPTableUserTokenData platform101XPTableUserTokenData) {
        injectSetFirebaseDb(platform101XPTableUserTokenData, (Platform101XPFirebaseDatabase) this.p0Provider.get());
    }

    public static void injectSetFirebaseDb(Platform101XPTableUserTokenData platform101XPTableUserTokenData, Platform101XPFirebaseDatabase platform101XPFirebaseDatabase) {
        platform101XPTableUserTokenData.setFirebaseDb(platform101XPFirebaseDatabase);
    }
}
