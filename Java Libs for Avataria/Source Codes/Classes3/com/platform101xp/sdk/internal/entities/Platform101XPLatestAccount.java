package com.platform101xp.sdk.internal.entities;

import com.chartboost.sdk.Model.j$;
import com.ironsource.mediationsdk.adunit.data.DataKeys;
import com.tapjoy.TapjoyAuctionFlags;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPLatestAccount.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003JO\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\b\u0010-\u001a\u00020\bH\u0016R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016¨\u0006."}, d2 = {"Lcom/platform101xp/sdk/internal/entities/Platform101XPLatestAccount;", "", TapjoyAuctionFlags.AUCTION_ID, "", DataKeys.USER_ID, "", "gameId", "displayName", "", "timestamp", TapjoyAuctionFlags.AUCTION_TYPE, "deviceToken", "(IJJLjava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getDeviceToken", "()Ljava/lang/String;", "setDeviceToken", "(Ljava/lang/String;)V", "getDisplayName", "setDisplayName", "getGameId", "()J", "setGameId", "(J)V", "getId", "()I", "setId", "(I)V", "getTimestamp", "setTimestamp", "getType", "setType", "getUserId", "setUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPLatestAccount {
    private String deviceToken;
    private String displayName;
    private long gameId;
    private int id;
    private long timestamp;
    private String type;
    private long userId;

    public Platform101XPLatestAccount() {
        this(0, 0L, 0L, null, 0L, null, null, 127, null);
    }

    public final int component1() {
        return this.id;
    }

    public final long component2() {
        return this.userId;
    }

    public final long component3() {
        return this.gameId;
    }

    public final String component4() {
        return this.displayName;
    }

    public final long component5() {
        return this.timestamp;
    }

    public final String component6() {
        return this.type;
    }

    public final String component7() {
        return this.deviceToken;
    }

    public final Platform101XPLatestAccount copy(int i, long j, long j2, String str, long j3, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "displayName");
        Intrinsics.checkNotNullParameter(str2, TapjoyAuctionFlags.AUCTION_TYPE);
        Intrinsics.checkNotNullParameter(str3, "deviceToken");
        return new Platform101XPLatestAccount(i, j, j2, str, j3, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Platform101XPLatestAccount)) {
            return false;
        }
        Platform101XPLatestAccount platform101XPLatestAccount = (Platform101XPLatestAccount) obj;
        return this.id == platform101XPLatestAccount.id && this.userId == platform101XPLatestAccount.userId && this.gameId == platform101XPLatestAccount.gameId && Intrinsics.areEqual(this.displayName, platform101XPLatestAccount.displayName) && this.timestamp == platform101XPLatestAccount.timestamp && Intrinsics.areEqual(this.type, platform101XPLatestAccount.type) && Intrinsics.areEqual(this.deviceToken, platform101XPLatestAccount.deviceToken);
    }

    public int hashCode() {
        return (((((((((((this.id * 31) + j$.ExternalSyntheticBackport0.m(this.userId)) * 31) + j$.ExternalSyntheticBackport0.m(this.gameId)) * 31) + this.displayName.hashCode()) * 31) + j$.ExternalSyntheticBackport0.m(this.timestamp)) * 31) + this.type.hashCode()) * 31) + this.deviceToken.hashCode();
    }

    public Platform101XPLatestAccount(int i, long j, long j2, String str, long j3, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "displayName");
        Intrinsics.checkNotNullParameter(str2, TapjoyAuctionFlags.AUCTION_TYPE);
        Intrinsics.checkNotNullParameter(str3, "deviceToken");
        this.id = i;
        this.userId = j;
        this.gameId = j2;
        this.displayName = str;
        this.timestamp = j3;
        this.type = str2;
        this.deviceToken = str3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ Platform101XPLatestAccount(int r12, long r13, long r15, java.lang.String r17, long r18, java.lang.String r20, java.lang.String r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22 & 1
            if (r0 == 0) goto L6
            r0 = 0
            goto L7
        L6:
            r0 = r12
        L7:
            r1 = r22 & 2
            r2 = 0
            if (r1 == 0) goto Lf
            r4 = r2
            goto L10
        Lf:
            r4 = r13
        L10:
            r1 = r22 & 4
            if (r1 == 0) goto L16
            r6 = r2
            goto L17
        L16:
            r6 = r15
        L17:
            r1 = r22 & 8
            java.lang.String r8 = ""
            if (r1 == 0) goto L1f
            r1 = r8
            goto L21
        L1f:
            r1 = r17
        L21:
            r9 = r22 & 16
            if (r9 == 0) goto L26
            goto L28
        L26:
            r2 = r18
        L28:
            r9 = r22 & 32
            if (r9 == 0) goto L2e
            r9 = r8
            goto L30
        L2e:
            r9 = r20
        L30:
            r10 = r22 & 64
            if (r10 == 0) goto L35
            goto L37
        L35:
            r8 = r21
        L37:
            r12 = r11
            r13 = r0
            r14 = r4
            r16 = r6
            r18 = r1
            r19 = r2
            r21 = r9
            r22 = r8
            r12.<init>(r13, r14, r16, r18, r19, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.platform101xp.sdk.internal.entities.Platform101XPLatestAccount.<init>(int, long, long, java.lang.String, long, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getDeviceToken() {
        return this.deviceToken;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final long getGameId() {
        return this.gameId;
    }

    public final int getId() {
        return this.id;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getType() {
        return this.type;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final void setDeviceToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceToken = str;
    }

    public final void setDisplayName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.displayName = str;
    }

    public final void setGameId(long j) {
        this.gameId = j;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final void setUserId(long j) {
        this.userId = j;
    }

    public String toString() {
        return "{id:'" + this.id + "', user_id:'" + this.userId + "', game_id:'" + this.gameId + "', display_name: '" + this.displayName + "', timestamp: " + this.timestamp + ", type: '" + this.type + "', device_token: '" + this.deviceToken + "'}";
    }
}
