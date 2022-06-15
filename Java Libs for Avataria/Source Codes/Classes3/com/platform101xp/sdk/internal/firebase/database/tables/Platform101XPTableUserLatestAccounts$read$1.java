package com.platform101xp.sdk.internal.firebase.database.tables;

import com.google.firebase.database.DataSnapshot;
import com.platform101xp.sdk.internal.entities.Platform101XPLatestAccount;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: Platform101XPTableUserLatestAccounts.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "dataSnapshot", "Lcom/google/firebase/database/DataSnapshot;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPTableUserLatestAccounts$read$1 extends Lambda implements Function1<DataSnapshot, Unit> {
    final /* synthetic */ Platform101XPTableUserLatestAccounts this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Platform101XPTableUserLatestAccounts$read$1(Platform101XPTableUserLatestAccounts platform101XPTableUserLatestAccounts) {
        super(1);
        this.this$0 = platform101XPTableUserLatestAccounts;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DataSnapshot) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DataSnapshot dataSnapshot) {
        List list;
        if (dataSnapshot == null) {
            return;
        }
        Platform101XPTableUserLatestAccounts platform101XPTableUserLatestAccounts = this.this$0;
        for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
            Platform101XPLatestAccount platform101XPLatestAccount = (Platform101XPLatestAccount) dataSnapshot2.getValue(Platform101XPLatestAccount.class);
            if (platform101XPLatestAccount != null) {
                list = platform101XPTableUserLatestAccounts.userLastAccountsList;
                list.add(platform101XPLatestAccount);
            }
        }
    }
}
