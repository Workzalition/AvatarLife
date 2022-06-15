package com.platform101xp.sdk.internal.firebase.database;

import android.util.Log;
import com.ironsource.mediationsdk.adunit.data.DataKeys;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.Platform101XPToken;
import com.platform101xp.sdk.internal.entities.Platform101XPLatestAccount;
import com.platform101xp.sdk.internal.entities.Platform101XPUserRewardEntity;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserIdTokens;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserLatestAccounts;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserReward;
import com.platform101xp.sdk.internal.firebase.database.tables.Platform101XPTableUserTokenData;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPFirebaseDbManager.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0003EFGB\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020,2\u0006\u0010)\u001a\u00020\u0004J\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.J\u0010\u00100\u001a\u00020,2\u0006\u00101\u001a\u000202H\u0002J\u0006\u00103\u001a\u00020,J\u000e\u00104\u001a\u00020,2\u0006\u00101\u001a\u000202J\u000e\u00105\u001a\u00020,2\u0006\u0010)\u001a\u00020*J\b\u00106\u001a\u00020,H\u0007J\u0018\u00107\u001a\u00020,2\b\u00108\u001a\u0004\u0018\u00010\u00042\u0006\u00109\u001a\u00020:J.\u0010;\u001a\u00020,2\u0006\u0010)\u001a\u00020*2\u0006\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u0004J\u000e\u0010@\u001a\u00020,2\u0006\u00108\u001a\u00020\u0004J\u001e\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006H"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDbManager;", "", "()V", "deviceId", "", "getDeviceId", "()Ljava/lang/String;", "setDeviceId", "(Ljava/lang/String;)V", "firebaseDb", "Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDatabase;", "getFirebaseDb", "()Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDatabase;", "setFirebaseDb", "(Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDatabase;)V", "userIdTokensTable", "Lcom/platform101xp/sdk/internal/firebase/database/tables/Platform101XPTableUserIdTokens;", "getUserIdTokensTable", "()Lcom/platform101xp/sdk/internal/firebase/database/tables/Platform101XPTableUserIdTokens;", "setUserIdTokensTable", "(Lcom/platform101xp/sdk/internal/firebase/database/tables/Platform101XPTableUserIdTokens;)V", "userLatestAccountsTable", "Lcom/platform101xp/sdk/internal/firebase/database/tables/Platform101XPTableUserLatestAccounts;", "getUserLatestAccountsTable", "()Lcom/platform101xp/sdk/internal/firebase/database/tables/Platform101XPTableUserLatestAccounts;", "setUserLatestAccountsTable", "(Lcom/platform101xp/sdk/internal/firebase/database/tables/Platform101XPTableUserLatestAccounts;)V", "usersRewardTable", "Lcom/platform101xp/sdk/internal/firebase/database/tables/Platform101XPTableUserReward;", "getUsersRewardTable", "()Lcom/platform101xp/sdk/internal/firebase/database/tables/Platform101XPTableUserReward;", "setUsersRewardTable", "(Lcom/platform101xp/sdk/internal/firebase/database/tables/Platform101XPTableUserReward;)V", "usersTokenDataTable", "Lcom/platform101xp/sdk/internal/firebase/database/tables/Platform101XPTableUserTokenData;", "getUsersTokenDataTable", "()Lcom/platform101xp/sdk/internal/firebase/database/tables/Platform101XPTableUserTokenData;", "setUsersTokenDataTable", "(Lcom/platform101xp/sdk/internal/firebase/database/tables/Platform101XPTableUserTokenData;)V", "checkContainsAccount", "", DataKeys.USER_ID, "", "checkRewardReferrer", "", "getLatestAccounts", "", "Lcom/platform101xp/sdk/internal/entities/Platform101XPLatestAccount;", "getUserTokenFromDB", "listener", "Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDbManager$DataChangeListener;", "readLatestAccounts", "readUserToken", "removeLatestAccount", "removeToken", "saveUserToken", "token", "dataResultListener", "Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDbManager$DataResultListener;", "writeLatestAccount", "gameId", IronSourceConstants.EVENTS_PROVIDER, "displayName", "tokenString", "writeUserFirebaseToken", "writeUserReward", "senderUserId", "recipientUserId", "event", "DataChangeListener", "DataResultListener", "InitDbResultListener", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDbManager {
    @Inject
    public String deviceId;
    @Inject
    public Platform101XPFirebaseDatabase firebaseDb;
    @Inject
    public Platform101XPTableUserIdTokens userIdTokensTable;
    @Inject
    public Platform101XPTableUserLatestAccounts userLatestAccountsTable;
    @Inject
    public Platform101XPTableUserReward usersRewardTable;
    @Inject
    public Platform101XPTableUserTokenData usersTokenDataTable;

    /* compiled from: Platform101XPFirebaseDbManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDbManager$DataChangeListener;", "", "doAfterGetProviderToken", "", "providerToken", "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public interface DataChangeListener {
        void doAfterGetProviderToken(String str);
    }

    /* compiled from: Platform101XPFirebaseDbManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDbManager$DataResultListener;", "", "onActionResult", "", "error", "Lcom/platform101xp/sdk/Platform101XPError;", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public interface DataResultListener {
        void onActionResult(Platform101XPError platform101XPError);
    }

    /* compiled from: Platform101XPFirebaseDbManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDbManager$InitDbResultListener;", "", "onInitResult", "", "error", "Lcom/platform101xp/sdk/Platform101XPError;", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public interface InitDbResultListener {
        void onInitResult(Platform101XPError platform101XPError);
    }

    public final Platform101XPFirebaseDatabase getFirebaseDb() {
        Platform101XPFirebaseDatabase platform101XPFirebaseDatabase = this.firebaseDb;
        if (platform101XPFirebaseDatabase != null) {
            return platform101XPFirebaseDatabase;
        }
        Intrinsics.throwUninitializedPropertyAccessException("firebaseDb");
        return null;
    }

    public final void setFirebaseDb(Platform101XPFirebaseDatabase platform101XPFirebaseDatabase) {
        Intrinsics.checkNotNullParameter(platform101XPFirebaseDatabase, "<set-?>");
        this.firebaseDb = platform101XPFirebaseDatabase;
    }

    public final Platform101XPTableUserIdTokens getUserIdTokensTable() {
        Platform101XPTableUserIdTokens platform101XPTableUserIdTokens = this.userIdTokensTable;
        if (platform101XPTableUserIdTokens != null) {
            return platform101XPTableUserIdTokens;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userIdTokensTable");
        return null;
    }

    public final void setUserIdTokensTable(Platform101XPTableUserIdTokens platform101XPTableUserIdTokens) {
        Intrinsics.checkNotNullParameter(platform101XPTableUserIdTokens, "<set-?>");
        this.userIdTokensTable = platform101XPTableUserIdTokens;
    }

    public final Platform101XPTableUserReward getUsersRewardTable() {
        Platform101XPTableUserReward platform101XPTableUserReward = this.usersRewardTable;
        if (platform101XPTableUserReward != null) {
            return platform101XPTableUserReward;
        }
        Intrinsics.throwUninitializedPropertyAccessException("usersRewardTable");
        return null;
    }

    public final void setUsersRewardTable(Platform101XPTableUserReward platform101XPTableUserReward) {
        Intrinsics.checkNotNullParameter(platform101XPTableUserReward, "<set-?>");
        this.usersRewardTable = platform101XPTableUserReward;
    }

    public final Platform101XPTableUserTokenData getUsersTokenDataTable() {
        Platform101XPTableUserTokenData platform101XPTableUserTokenData = this.usersTokenDataTable;
        if (platform101XPTableUserTokenData != null) {
            return platform101XPTableUserTokenData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("usersTokenDataTable");
        return null;
    }

    public final void setUsersTokenDataTable(Platform101XPTableUserTokenData platform101XPTableUserTokenData) {
        Intrinsics.checkNotNullParameter(platform101XPTableUserTokenData, "<set-?>");
        this.usersTokenDataTable = platform101XPTableUserTokenData;
    }

    public final Platform101XPTableUserLatestAccounts getUserLatestAccountsTable() {
        Platform101XPTableUserLatestAccounts platform101XPTableUserLatestAccounts = this.userLatestAccountsTable;
        if (platform101XPTableUserLatestAccounts != null) {
            return platform101XPTableUserLatestAccounts;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userLatestAccountsTable");
        return null;
    }

    public final void setUserLatestAccountsTable(Platform101XPTableUserLatestAccounts platform101XPTableUserLatestAccounts) {
        Intrinsics.checkNotNullParameter(platform101XPTableUserLatestAccounts, "<set-?>");
        this.userLatestAccountsTable = platform101XPTableUserLatestAccounts;
    }

    public final String getDeviceId() {
        String str = this.deviceId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deviceId");
        return null;
    }

    public final void setDeviceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceId = str;
    }

    public final void writeUserFirebaseToken(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        Platform101XPToken token = Platform101XP.getToken();
        if (token == null) {
            return;
        }
        String valueOf = String.valueOf(token.getUserId());
        getUserIdTokensTable().write(valueOf, str, getDeviceId());
        Log.d("101XP SDK", "Firebase database write data userId:" + valueOf + " push token: " + str);
    }

    public final void writeUserReward(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "senderUserId");
        Intrinsics.checkNotNullParameter(str2, "recipientUserId");
        Intrinsics.checkNotNullParameter(str3, "event");
        getUsersRewardTable().write(str2, new Platform101XPUserRewardEntity(str, str3));
    }

    public final void checkRewardReferrer(String str) {
        Intrinsics.checkNotNullParameter(str, DataKeys.USER_ID);
        getUsersRewardTable().checkRewardReferrer(str);
    }

    public final void saveUserToken(String str, DataResultListener dataResultListener) {
        Intrinsics.checkNotNullParameter(dataResultListener, "dataResultListener");
        if (str != null) {
            if ((str.length() > 0) && !Intrinsics.areEqual(str, "{}")) {
                getUsersTokenDataTable().write(getDeviceId(), str);
                dataResultListener.onActionResult(null);
                return;
            }
        }
        dataResultListener.onActionResult(new Platform101XPError(new Exception("Token can't save to Firebase DB. Saved token string not valid!")));
    }

    public final void readUserToken(DataChangeListener dataChangeListener) {
        Intrinsics.checkNotNullParameter(dataChangeListener, "listener");
        getUserTokenFromDB(dataChangeListener);
    }

    public final void writeLatestAccount(long j, long j2, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, IronSourceConstants.EVENTS_PROVIDER);
        Intrinsics.checkNotNullParameter(str2, "displayName");
        Intrinsics.checkNotNullParameter(str3, "tokenString");
        getUserLatestAccountsTable().write(getDeviceId(), j, j2, str, str2, str3);
    }

    public final void readLatestAccounts() {
        getUserLatestAccountsTable().read(getDeviceId());
    }

    public final void removeLatestAccount(long j) {
        getUserLatestAccountsTable().remove(getDeviceId(), j);
        removeToken();
    }

    public final List<Platform101XPLatestAccount> getLatestAccounts() {
        return getUserLatestAccountsTable().getLatestAccounts();
    }

    public final boolean checkContainsAccount(long j) {
        Iterator<Platform101XPLatestAccount> it = getUserLatestAccountsTable().getLatestAccounts().iterator();
        while (it.hasNext()) {
            if (it.next().getUserId() == j) {
                return true;
            }
        }
        return false;
    }

    private final void getUserTokenFromDB(DataChangeListener dataChangeListener) {
        getUsersTokenDataTable().readToken(getDeviceId(), dataChangeListener);
    }

    public final void removeToken() {
        getUsersTokenDataTable().removeToken(getDeviceId());
    }
}
