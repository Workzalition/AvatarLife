package com.platform101xp.sdk.internal.firebase.database;

import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserIdTokens;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserIdTokens_Factory;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserIdTokens_MembersInjector;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserLatestAccounts;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserLatestAccounts_Factory;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserLatestAccounts_MembersInjector;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserReward;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserReward_Factory;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserReward_MembersInjector;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserTokenData;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserTokenData_Factory;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserTokenData_MembersInjector;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class DaggerPlatform101XPFirebaseDBComponent implements Platform101XPFirebaseDBComponent {
    private final DaggerPlatform101XPFirebaseDBComponent platform101XPFirebaseDBComponent;
    private final Platform101XPFirebaseDbModule platform101XPFirebaseDbModule;

    private DaggerPlatform101XPFirebaseDBComponent(Platform101XPFirebaseDbModule platform101XPFirebaseDbModule) {
        this.platform101XPFirebaseDBComponent = this;
        this.platform101XPFirebaseDbModule = platform101XPFirebaseDbModule;
    }

    public static Builder builder() {
        return new Builder();
    }

    private Platform101XPFirebaseDatabase platform101XPFirebaseDatabase() {
        return injectPlatform101XPFirebaseDatabase(Platform101XPFirebaseDatabase_Factory.newInstance(Platform101XPFirebaseDbModule_GetActivityFactory.getActivity(this.platform101XPFirebaseDbModule), Platform101XPFirebaseDbModule_GetFirebaseDbInitListenerFactory.getFirebaseDbInitListener(this.platform101XPFirebaseDbModule)));
    }

    private Platform101XPTableUserIdTokens platform101XPTableUserIdTokens() {
        return injectPlatform101XPTableUserIdTokens(Platform101XPTableUserIdTokens_Factory.newInstance(platform101XPFirebaseDatabase()));
    }

    private Platform101XPTableUserReward platform101XPTableUserReward() {
        return injectPlatform101XPTableUserReward(Platform101XPTableUserReward_Factory.newInstance(platform101XPFirebaseDatabase()));
    }

    private Platform101XPTableUserTokenData platform101XPTableUserTokenData() {
        return injectPlatform101XPTableUserTokenData(Platform101XPTableUserTokenData_Factory.newInstance(platform101XPFirebaseDatabase()));
    }

    private Platform101XPTableUserLatestAccounts platform101XPTableUserLatestAccounts() {
        return injectPlatform101XPTableUserLatestAccounts(Platform101XPTableUserLatestAccounts_Factory.newInstance(platform101XPFirebaseDatabase()));
    }

    @Override // com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDBComponent
    public Platform101XPFirebaseDbManager getFirebaseDbManager() {
        return injectPlatform101XPFirebaseDbManager(Platform101XPFirebaseDbManager_Factory.newInstance());
    }

    private Platform101XPFirebaseDatabase injectPlatform101XPFirebaseDatabase(Platform101XPFirebaseDatabase platform101XPFirebaseDatabase) {
        Platform101XPFirebaseDatabase_MembersInjector.injectSetActivity(platform101XPFirebaseDatabase, Platform101XPFirebaseDbModule_GetActivityFactory.getActivity(this.platform101XPFirebaseDbModule));
        Platform101XPFirebaseDatabase_MembersInjector.injectSetInitListener(platform101XPFirebaseDatabase, Platform101XPFirebaseDbModule_GetFirebaseDbInitListenerFactory.getFirebaseDbInitListener(this.platform101XPFirebaseDbModule));
        return platform101XPFirebaseDatabase;
    }

    private Platform101XPTableUserIdTokens injectPlatform101XPTableUserIdTokens(Platform101XPTableUserIdTokens platform101XPTableUserIdTokens) {
        Platform101XPTableUserIdTokens_MembersInjector.injectSetFirebaseDb(platform101XPTableUserIdTokens, platform101XPFirebaseDatabase());
        return platform101XPTableUserIdTokens;
    }

    private Platform101XPTableUserReward injectPlatform101XPTableUserReward(Platform101XPTableUserReward platform101XPTableUserReward) {
        Platform101XPTableUserReward_MembersInjector.injectSetFirebaseDb(platform101XPTableUserReward, platform101XPFirebaseDatabase());
        return platform101XPTableUserReward;
    }

    private Platform101XPTableUserTokenData injectPlatform101XPTableUserTokenData(Platform101XPTableUserTokenData platform101XPTableUserTokenData) {
        Platform101XPTableUserTokenData_MembersInjector.injectSetFirebaseDb(platform101XPTableUserTokenData, platform101XPFirebaseDatabase());
        return platform101XPTableUserTokenData;
    }

    private Platform101XPTableUserLatestAccounts injectPlatform101XPTableUserLatestAccounts(Platform101XPTableUserLatestAccounts platform101XPTableUserLatestAccounts) {
        Platform101XPTableUserLatestAccounts_MembersInjector.injectSetFirebaseDb(platform101XPTableUserLatestAccounts, platform101XPFirebaseDatabase());
        return platform101XPTableUserLatestAccounts;
    }

    private Platform101XPFirebaseDbManager injectPlatform101XPFirebaseDbManager(Platform101XPFirebaseDbManager platform101XPFirebaseDbManager) {
        Platform101XPFirebaseDbManager_MembersInjector.injectFirebaseDb(platform101XPFirebaseDbManager, platform101XPFirebaseDatabase());
        Platform101XPFirebaseDbManager_MembersInjector.injectUserIdTokensTable(platform101XPFirebaseDbManager, platform101XPTableUserIdTokens());
        Platform101XPFirebaseDbManager_MembersInjector.injectUsersRewardTable(platform101XPFirebaseDbManager, platform101XPTableUserReward());
        Platform101XPFirebaseDbManager_MembersInjector.injectUsersTokenDataTable(platform101XPFirebaseDbManager, platform101XPTableUserTokenData());
        Platform101XPFirebaseDbManager_MembersInjector.injectUserLatestAccountsTable(platform101XPFirebaseDbManager, platform101XPTableUserLatestAccounts());
        Platform101XPFirebaseDbManager_MembersInjector.injectDeviceId(platform101XPFirebaseDbManager, Platform101XPFirebaseDbModule_GetDeviceIdFactory.getDeviceId(this.platform101XPFirebaseDbModule));
        return platform101XPFirebaseDbManager;
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Builder {
        private Platform101XPFirebaseDbModule platform101XPFirebaseDbModule;

        private Builder() {
        }

        public Builder platform101XPFirebaseDbModule(Platform101XPFirebaseDbModule platform101XPFirebaseDbModule) {
            this.platform101XPFirebaseDbModule = (Platform101XPFirebaseDbModule) Preconditions.checkNotNull(platform101XPFirebaseDbModule);
            return this;
        }

        public Platform101XPFirebaseDBComponent build() {
            Preconditions.checkBuilderRequirement(this.platform101XPFirebaseDbModule, Platform101XPFirebaseDbModule.class);
            return new DaggerPlatform101XPFirebaseDBComponent(this.platform101XPFirebaseDbModule);
        }
    }
}
