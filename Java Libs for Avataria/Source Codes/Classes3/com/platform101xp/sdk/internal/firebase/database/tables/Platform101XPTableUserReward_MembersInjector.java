package com.platform101xp.sdk.internal.firebase.database.tables;

import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDatabase;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPTableUserReward_MembersInjector implements MembersInjector<Platform101XPTableUserReward> {
    private final Provider<Platform101XPFirebaseDatabase> p0Provider;

    public Platform101XPTableUserReward_MembersInjector(Provider<Platform101XPFirebaseDatabase> provider) {
        this.p0Provider = provider;
    }

    public static MembersInjector<Platform101XPTableUserReward> create(Provider<Platform101XPFirebaseDatabase> provider) {
        return new Platform101XPTableUserReward_MembersInjector(provider);
    }

    public void injectMembers(Platform101XPTableUserReward platform101XPTableUserReward) {
        injectSetFirebaseDb(platform101XPTableUserReward, (Platform101XPFirebaseDatabase) this.p0Provider.get());
    }

    public static void injectSetFirebaseDb(Platform101XPTableUserReward platform101XPTableUserReward, Platform101XPFirebaseDatabase platform101XPFirebaseDatabase) {
        platform101XPTableUserReward.setFirebaseDb(platform101XPFirebaseDatabase);
    }
}
