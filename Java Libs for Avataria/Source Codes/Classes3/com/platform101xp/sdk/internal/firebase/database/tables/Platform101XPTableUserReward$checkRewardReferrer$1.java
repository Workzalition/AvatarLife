package com.platform101xp.sdk.internal.firebase.database.tables;

import android.util.Log;
import com.google.firebase.database.DataSnapshot;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.internal.entities.Platform101XPUserRewardEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Platform101XPTableUserReward.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "dataSnapshot", "Lcom/google/firebase/database/DataSnapshot;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPTableUserReward$checkRewardReferrer$1 extends Lambda implements Function1<DataSnapshot, Unit> {
    final /* synthetic */ String $userId;
    final /* synthetic */ Platform101XPTableUserReward this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Platform101XPTableUserReward$checkRewardReferrer$1(String str, Platform101XPTableUserReward platform101XPTableUserReward) {
        super(1);
        this.$userId = str;
        this.this$0 = platform101XPTableUserReward;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DataSnapshot) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DataSnapshot dataSnapshot) {
        if (dataSnapshot == null) {
            return;
        }
        String str = this.$userId;
        Platform101XPTableUserReward platform101XPTableUserReward = this.this$0;
        for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
            String key = dataSnapshot2.getKey();
            Object value = dataSnapshot2.getValue(Platform101XPUserRewardEntity.class);
            Intrinsics.checkNotNull(value);
            Intrinsics.checkNotNullExpressionValue(value, "ds.getValue(Platform101X…wardEntity::class.java)!!");
            Platform101XPUserRewardEntity platform101XPUserRewardEntity = (Platform101XPUserRewardEntity) value;
            if (Intrinsics.areEqual(str, platform101XPUserRewardEntity.getSenderUserId()) && !platform101XPUserRewardEntity.isUsersRewarded()) {
                Platform101XP.callLinkReferrerReward(platform101XPUserRewardEntity.getEvent());
                if (key != null) {
                    platform101XPTableUserReward.updateRewardUser(key);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ReferrerId");
            sb.append((Object) platform101XPUserRewardEntity.getSenderUserId());
            sb.append(" UserId: Is need reward: ");
            sb.append(!platform101XPUserRewardEntity.isUsersRewarded());
            Log.d("101XP SDK", sb.toString());
        }
    }
}
