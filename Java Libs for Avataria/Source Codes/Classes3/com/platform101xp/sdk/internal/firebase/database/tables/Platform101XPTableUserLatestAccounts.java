package com.platform101xp.sdk.internal.firebase.database.tables;

import com.ironsource.mediationsdk.adunit.data.DataKeys;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.platform101xp.sdk.internal.entities.Platform101XPLatestAccount;
import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDatabase;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPFacebook;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPGoogle;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPOK;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPTableUserLatestAccounts.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0013J\u0016\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0011J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\fH\u0002J6\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013J \u0010 \u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\nH\u0002R\u001c\u0010\u0002\u001a\u00020\u0003@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/database/tables/Platform101XPTableUserLatestAccounts;", "", "firebaseDb", "Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDatabase;", "(Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDatabase;)V", "getFirebaseDb", "()Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDatabase;", "setFirebaseDb", "userLastAccountsList", "", "Lcom/platform101xp/sdk/internal/entities/Platform101XPLatestAccount;", "accountIsNotEmpty", "", "currentIndex", "getLatestAccounts", "", "getTimeStamp", "", "getTypeFromProvider", "", IronSourceConstants.EVENTS_PROVIDER, "read", "", "deviceId", "remove", DataKeys.USER_ID, "removeAccount", "latestAccountId", "write", "gameId", "displayName", "token", "writeAccount", "latestAccount", "Companion", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPTableUserLatestAccounts {
    public static final Companion Companion = new Companion(null);
    public static final int FIRST_ACCOUNT_ID = 1;
    public static final int MAX_COUNT_ACCOUNT = 5;
    public static final String TABLE_NAME = "user_latest_accounts";
    private Platform101XPFirebaseDatabase firebaseDb;
    private final List<Platform101XPLatestAccount> userLastAccountsList = new ArrayList();

    /* compiled from: Platform101XPTableUserLatestAccounts.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/database/tables/Platform101XPTableUserLatestAccounts$Companion;", "", "()V", "FIRST_ACCOUNT_ID", "", "MAX_COUNT_ACCOUNT", "TABLE_NAME", "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Inject
    public Platform101XPTableUserLatestAccounts(Platform101XPFirebaseDatabase platform101XPFirebaseDatabase) {
        Intrinsics.checkNotNullParameter(platform101XPFirebaseDatabase, "firebaseDb");
        this.firebaseDb = platform101XPFirebaseDatabase;
    }

    public final Platform101XPFirebaseDatabase getFirebaseDb() {
        return this.firebaseDb;
    }

    @Inject
    public final void setFirebaseDb(Platform101XPFirebaseDatabase platform101XPFirebaseDatabase) {
        Intrinsics.checkNotNullParameter(platform101XPFirebaseDatabase, "<set-?>");
        this.firebaseDb = platform101XPFirebaseDatabase;
    }

    private final String getTypeFromProvider(String str) {
        switch (str.hashCode()) {
            case -1240244679:
                if (str.equals(Platform101XPGoogle.SN_PROVIDER)) {
                    return "googlePlay";
                }
                break;
            case -332124261:
                if (str.equals("Vkontakte")) {
                    return "vk";
                }
                break;
            case 561774310:
                if (str.equals(Platform101XPFacebook.SN_PROVIDER)) {
                    return "fb";
                }
                break;
            case 596358179:
                if (str.equals(Platform101XPOK.SN_PROVIDER)) {
                    return "ok";
                }
                break;
        }
        return "xp";
    }

    private final long getTimeStamp() {
        return System.currentTimeMillis();
    }

    private final int accountIsNotEmpty(int i) {
        Object obj;
        if (i != -1) {
            this.userLastAccountsList.remove(i);
        } else if (this.userLastAccountsList.size() >= 5) {
            Iterator<T> it = this.userLastAccountsList.iterator();
            Integer num = null;
            if (!it.hasNext()) {
                obj = null;
            } else {
                obj = it.next();
                if (it.hasNext()) {
                    long timestamp = ((Platform101XPLatestAccount) obj).getTimestamp();
                    do {
                        Object next = it.next();
                        long timestamp2 = ((Platform101XPLatestAccount) next).getTimestamp();
                        if (timestamp > timestamp2) {
                            obj = next;
                            timestamp = timestamp2;
                        }
                    } while (it.hasNext());
                }
            }
            Platform101XPLatestAccount platform101XPLatestAccount = (Platform101XPLatestAccount) obj;
            if (platform101XPLatestAccount != null) {
                num = Integer.valueOf(platform101XPLatestAccount.getId());
            }
            Intrinsics.checkNotNull(num);
            return num.intValue();
        } else {
            i = ((Platform101XPLatestAccount) CollectionsKt.last(this.userLastAccountsList)).getId();
            if (i > this.userLastAccountsList.size()) {
                i = this.userLastAccountsList.size();
            }
        }
        return i + 1;
    }

    public final void write(String str, long j, long j2, String str2, String str3, String str4) {
        int i;
        Intrinsics.checkNotNullParameter(str, "deviceId");
        Intrinsics.checkNotNullParameter(str2, IronSourceConstants.EVENTS_PROVIDER);
        Intrinsics.checkNotNullParameter(str3, "displayName");
        Intrinsics.checkNotNullParameter(str4, "token");
        if (this.userLastAccountsList.isEmpty()) {
            i = 1;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.userLastAccountsList) {
                if (((Platform101XPLatestAccount) obj).getUserId() == j) {
                    arrayList.add(obj);
                }
            }
            i = accountIsNotEmpty(CollectionsKt.getLastIndex(arrayList));
        }
        Platform101XPLatestAccount platform101XPLatestAccount = new Platform101XPLatestAccount(i, j, j2, str3, getTimeStamp(), getTypeFromProvider(str2), str4);
        this.userLastAccountsList.add(i - 1, platform101XPLatestAccount);
        writeAccount(str, i, platform101XPLatestAccount);
    }

    public final void remove(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "deviceId");
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        for (Platform101XPLatestAccount platform101XPLatestAccount : this.userLastAccountsList) {
            int i4 = i + 1;
            if (j == platform101XPLatestAccount.getUserId()) {
                i3 = platform101XPLatestAccount.getId();
                i2 = i;
            }
            i = i4;
        }
        if (i3 != -1) {
            this.userLastAccountsList.remove(i2);
            removeAccount(str, i3);
        }
    }

    public final void read(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceId");
        this.firebaseDb.readData(TABLE_NAME, new String[]{str}, (Function1) new Platform101XPTableUserLatestAccounts$read$1(this));
    }

    public final List<Platform101XPLatestAccount> getLatestAccounts() {
        return this.userLastAccountsList;
    }

    private final void writeAccount(String str, int i, Platform101XPLatestAccount platform101XPLatestAccount) {
        this.firebaseDb.writeData(TABLE_NAME, new String[]{str, String.valueOf(i)}, platform101XPLatestAccount);
    }

    private final void removeAccount(String str, int i) {
        this.firebaseDb.removeData(TABLE_NAME, new String[]{str, String.valueOf(i)});
    }
}
