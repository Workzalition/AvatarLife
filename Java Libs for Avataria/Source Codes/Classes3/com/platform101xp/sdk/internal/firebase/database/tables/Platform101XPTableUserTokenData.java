package com.platform101xp.sdk.internal.firebase.database.tables;

import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDatabase;
import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPTableUserTokenData.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bR\u001c\u0010\u0002\u001a\u00020\u0003@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/database/tables/Platform101XPTableUserTokenData;", "", "firebaseDb", "Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDatabase;", "(Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDatabase;)V", "getFirebaseDb", "()Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDatabase;", "setFirebaseDb", "readToken", "", "deviceId", "", "listener", "Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDbManager$DataChangeListener;", "removeToken", "write", "token", "Companion", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPTableUserTokenData {
    public static final Companion Companion = new Companion(null);
    public static final String TABLE_NAME = "users_data";
    private Platform101XPFirebaseDatabase firebaseDb;

    /* compiled from: Platform101XPTableUserTokenData.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/database/tables/Platform101XPTableUserTokenData$Companion;", "", "()V", "TABLE_NAME", "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Inject
    public Platform101XPTableUserTokenData(Platform101XPFirebaseDatabase platform101XPFirebaseDatabase) {
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

    public final void write(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "deviceId");
        Intrinsics.checkNotNullParameter(str2, "token");
        this.firebaseDb.writeData(TABLE_NAME, new String[]{str}, str2);
    }

    public final void readToken(String str, Platform101XPFirebaseDbManager.DataChangeListener dataChangeListener) {
        Intrinsics.checkNotNullParameter(str, "deviceId");
        Intrinsics.checkNotNullParameter(dataChangeListener, "listener");
        this.firebaseDb.readData(TABLE_NAME, new String[]{str}, (Function1) new Platform101XPTableUserTokenData$readToken$1(dataChangeListener));
    }

    public final void removeToken(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceId");
        this.firebaseDb.removeData(TABLE_NAME, new String[]{str});
    }
}
