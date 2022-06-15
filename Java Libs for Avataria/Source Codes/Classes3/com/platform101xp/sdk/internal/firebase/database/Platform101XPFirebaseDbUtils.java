package com.platform101xp.sdk.internal.firebase.database;

import com.google.firebase.database.FirebaseDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPFirebaseDbUtils.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDbUtils;", "", "()V", "getDatabase", "Lcom/google/firebase/database/FirebaseDatabase;", "Companion", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDbUtils {
    public static final Companion Companion = new Companion(null);
    private static final FirebaseDatabase firebaseDatabase;

    /* compiled from: Platform101XPFirebaseDbUtils.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDbUtils$Companion;", "", "()V", "firebaseDatabase", "Lcom/google/firebase/database/FirebaseDatabase;", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        FirebaseDatabase firebaseDatabase2 = FirebaseDatabase.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseDatabase2, "getInstance()");
        firebaseDatabase = firebaseDatabase2;
        firebaseDatabase2.setPersistenceEnabled(true);
    }

    public final FirebaseDatabase getDatabase() {
        return firebaseDatabase;
    }
}
