package com.platform101xp.sdk.internal.firebase.database.tables;

import com.google.firebase.database.DataSnapshot;
import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: Platform101XPTableUserTokenData.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "dataSnapshot", "Lcom/google/firebase/database/DataSnapshot;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPTableUserTokenData$readToken$1 extends Lambda implements Function1<DataSnapshot, Unit> {
    final /* synthetic */ Platform101XPFirebaseDbManager.DataChangeListener $listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Platform101XPTableUserTokenData$readToken$1(Platform101XPFirebaseDbManager.DataChangeListener dataChangeListener) {
        super(1);
        this.$listener = dataChangeListener;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DataSnapshot) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DataSnapshot dataSnapshot) {
        Unit unit;
        if (dataSnapshot == null) {
            unit = null;
        } else {
            this.$listener.doAfterGetProviderToken((String) dataSnapshot.getValue(String.class));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.$listener.doAfterGetProviderToken(null);
        }
    }
}
