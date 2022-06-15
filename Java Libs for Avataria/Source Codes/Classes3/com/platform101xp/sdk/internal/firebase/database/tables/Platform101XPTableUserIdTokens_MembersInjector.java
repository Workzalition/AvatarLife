package com.platform101xp.sdk.internal.firebase.database.tables;

import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDatabase;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPTableUserIdTokens_MembersInjector implements MembersInjector<Platform101XPTableUserIdTokens> {
    private final Provider<Platform101XPFirebaseDatabase> p0Provider;

    public Platform101XPTableUserIdTokens_MembersInjector(Provider<Platform101XPFirebaseDatabase> provider) {
        this.p0Provider = provider;
    }

    public static MembersInjector<Platform101XPTableUserIdTokens> create(Provider<Platform101XPFirebaseDatabase> provider) {
        return new Platform101XPTableUserIdTokens_MembersInjector(provider);
    }

    public void injectMembers(Platform101XPTableUserIdTokens platform101XPTableUserIdTokens) {
        injectSetFirebaseDb(platform101XPTableUserIdTokens, (Platform101XPFirebaseDatabase) this.p0Provider.get());
    }

    public static void injectSetFirebaseDb(Platform101XPTableUserIdTokens platform101XPTableUserIdTokens, Platform101XPFirebaseDatabase platform101XPFirebaseDatabase) {
        platform101XPTableUserIdTokens.setFirebaseDb(platform101XPFirebaseDatabase);
    }
}
