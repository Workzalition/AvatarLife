package com.platform101xp.sdk.internal.firebase.database;

import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserIdTokens;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserLatestAccounts;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserReward;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserTokenData;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDbManager_Factory implements Factory<Platform101XPFirebaseDbManager> {
    private final Provider<String> deviceIdProvider;
    private final Provider<Platform101XPFirebaseDatabase> firebaseDbProvider;
    private final Provider<Platform101XPTableUserIdTokens> userIdTokensTableProvider;
    private final Provider<Platform101XPTableUserLatestAccounts> userLatestAccountsTableProvider;
    private final Provider<Platform101XPTableUserReward> usersRewardTableProvider;
    private final Provider<Platform101XPTableUserTokenData> usersTokenDataTableProvider;

    public Platform101XPFirebaseDbManager_Factory(Provider<Platform101XPFirebaseDatabase> provider, Provider<Platform101XPTableUserIdTokens> provider2, Provider<Platform101XPTableUserReward> provider3, Provider<Platform101XPTableUserTokenData> provider4, Provider<Platform101XPTableUserLatestAccounts> provider5, Provider<String> provider6) {
        this.firebaseDbProvider = provider;
        this.userIdTokensTableProvider = provider2;
        this.usersRewardTableProvider = provider3;
        this.usersTokenDataTableProvider = provider4;
        this.userLatestAccountsTableProvider = provider5;
        this.deviceIdProvider = provider6;
    }

    public Platform101XPFirebaseDbManager get() {
        Platform101XPFirebaseDbManager newInstance = newInstance();
        Platform101XPFirebaseDbManager_MembersInjector.injectFirebaseDb(newInstance, (Platform101XPFirebaseDatabase) this.firebaseDbProvider.get());
        Platform101XPFirebaseDbManager_MembersInjector.injectUserIdTokensTable(newInstance, (Platform101XPTableUserIdTokens) this.userIdTokensTableProvider.get());
        Platform101XPFirebaseDbManager_MembersInjector.injectUsersRewardTable(newInstance, (Platform101XPTableUserReward) this.usersRewardTableProvider.get());
        Platform101XPFirebaseDbManager_MembersInjector.injectUsersTokenDataTable(newInstance, (Platform101XPTableUserTokenData) this.usersTokenDataTableProvider.get());
        Platform101XPFirebaseDbManager_MembersInjector.injectUserLatestAccountsTable(newInstance, (Platform101XPTableUserLatestAccounts) this.userLatestAccountsTableProvider.get());
        Platform101XPFirebaseDbManager_MembersInjector.injectDeviceId(newInstance, (String) this.deviceIdProvider.get());
        return newInstance;
    }

    public static Platform101XPFirebaseDbManager_Factory create(Provider<Platform101XPFirebaseDatabase> provider, Provider<Platform101XPTableUserIdTokens> provider2, Provider<Platform101XPTableUserReward> provider3, Provider<Platform101XPTableUserTokenData> provider4, Provider<Platform101XPTableUserLatestAccounts> provider5, Provider<String> provider6) {
        return new Platform101XPFirebaseDbManager_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static Platform101XPFirebaseDbManager newInstance() {
        return new Platform101XPFirebaseDbManager();
    }
}
