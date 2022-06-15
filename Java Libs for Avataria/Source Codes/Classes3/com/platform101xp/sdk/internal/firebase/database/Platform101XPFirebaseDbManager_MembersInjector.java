package com.platform101xp.sdk.internal.firebase.database;

import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserIdTokens;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserLatestAccounts;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserReward;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserTokenData;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDbManager_MembersInjector implements MembersInjector<Platform101XPFirebaseDbManager> {
    private final Provider<String> deviceIdProvider;
    private final Provider<Platform101XPFirebaseDatabase> firebaseDbProvider;
    private final Provider<Platform101XPTableUserIdTokens> userIdTokensTableProvider;
    private final Provider<Platform101XPTableUserLatestAccounts> userLatestAccountsTableProvider;
    private final Provider<Platform101XPTableUserReward> usersRewardTableProvider;
    private final Provider<Platform101XPTableUserTokenData> usersTokenDataTableProvider;

    public Platform101XPFirebaseDbManager_MembersInjector(Provider<Platform101XPFirebaseDatabase> provider, Provider<Platform101XPTableUserIdTokens> provider2, Provider<Platform101XPTableUserReward> provider3, Provider<Platform101XPTableUserTokenData> provider4, Provider<Platform101XPTableUserLatestAccounts> provider5, Provider<String> provider6) {
        this.firebaseDbProvider = provider;
        this.userIdTokensTableProvider = provider2;
        this.usersRewardTableProvider = provider3;
        this.usersTokenDataTableProvider = provider4;
        this.userLatestAccountsTableProvider = provider5;
        this.deviceIdProvider = provider6;
    }

    public static MembersInjector<Platform101XPFirebaseDbManager> create(Provider<Platform101XPFirebaseDatabase> provider, Provider<Platform101XPTableUserIdTokens> provider2, Provider<Platform101XPTableUserReward> provider3, Provider<Platform101XPTableUserTokenData> provider4, Provider<Platform101XPTableUserLatestAccounts> provider5, Provider<String> provider6) {
        return new Platform101XPFirebaseDbManager_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public void injectMembers(Platform101XPFirebaseDbManager platform101XPFirebaseDbManager) {
        injectFirebaseDb(platform101XPFirebaseDbManager, (Platform101XPFirebaseDatabase) this.firebaseDbProvider.get());
        injectUserIdTokensTable(platform101XPFirebaseDbManager, (Platform101XPTableUserIdTokens) this.userIdTokensTableProvider.get());
        injectUsersRewardTable(platform101XPFirebaseDbManager, (Platform101XPTableUserReward) this.usersRewardTableProvider.get());
        injectUsersTokenDataTable(platform101XPFirebaseDbManager, (Platform101XPTableUserTokenData) this.usersTokenDataTableProvider.get());
        injectUserLatestAccountsTable(platform101XPFirebaseDbManager, (Platform101XPTableUserLatestAccounts) this.userLatestAccountsTableProvider.get());
        injectDeviceId(platform101XPFirebaseDbManager, (String) this.deviceIdProvider.get());
    }

    public static void injectFirebaseDb(Platform101XPFirebaseDbManager platform101XPFirebaseDbManager, Platform101XPFirebaseDatabase platform101XPFirebaseDatabase) {
        platform101XPFirebaseDbManager.firebaseDb = platform101XPFirebaseDatabase;
    }

    public static void injectUserIdTokensTable(Platform101XPFirebaseDbManager platform101XPFirebaseDbManager, Platform101XPTableUserIdTokens platform101XPTableUserIdTokens) {
        platform101XPFirebaseDbManager.userIdTokensTable = platform101XPTableUserIdTokens;
    }

    public static void injectUsersRewardTable(Platform101XPFirebaseDbManager platform101XPFirebaseDbManager, Platform101XPTableUserReward platform101XPTableUserReward) {
        platform101XPFirebaseDbManager.usersRewardTable = platform101XPTableUserReward;
    }

    public static void injectUsersTokenDataTable(Platform101XPFirebaseDbManager platform101XPFirebaseDbManager, Platform101XPTableUserTokenData platform101XPTableUserTokenData) {
        platform101XPFirebaseDbManager.usersTokenDataTable = platform101XPTableUserTokenData;
    }

    public static void injectUserLatestAccountsTable(Platform101XPFirebaseDbManager platform101XPFirebaseDbManager, Platform101XPTableUserLatestAccounts platform101XPTableUserLatestAccounts) {
        platform101XPFirebaseDbManager.userLatestAccountsTable = platform101XPTableUserLatestAccounts;
    }

    public static void injectDeviceId(Platform101XPFirebaseDbManager platform101XPFirebaseDbManager, String str) {
        platform101XPFirebaseDbManager.deviceId = str;
    }
}
