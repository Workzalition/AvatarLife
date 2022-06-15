package com.platform101xp.sdk.internal.token;

import com.chartboost.sdk.Model.j$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Platform101XPTokenIds.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/platform101xp/sdk/internal/token/Platform101XPTokenIds;", "", "accountId", "", "mobileId", "userGameId", "(JJJ)V", "getAccountId", "()J", "setAccountId", "(J)V", "getMobileId", "setMobileId", "getUserGameId", "setUserGameId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPTokenIds {
    private long accountId;
    private long mobileId;
    private long userGameId;

    public Platform101XPTokenIds() {
        this(0L, 0L, 0L, 7, null);
    }

    public static /* synthetic */ Platform101XPTokenIds copy$default(Platform101XPTokenIds platform101XPTokenIds, long j, long j2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = platform101XPTokenIds.accountId;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = platform101XPTokenIds.mobileId;
        }
        long j5 = j2;
        if ((i & 4) != 0) {
            j3 = platform101XPTokenIds.userGameId;
        }
        return platform101XPTokenIds.copy(j4, j5, j3);
    }

    public final long component1() {
        return this.accountId;
    }

    public final long component2() {
        return this.mobileId;
    }

    public final long component3() {
        return this.userGameId;
    }

    public final Platform101XPTokenIds copy(long j, long j2, long j3) {
        return new Platform101XPTokenIds(j, j2, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Platform101XPTokenIds)) {
            return false;
        }
        Platform101XPTokenIds platform101XPTokenIds = (Platform101XPTokenIds) obj;
        return this.accountId == platform101XPTokenIds.accountId && this.mobileId == platform101XPTokenIds.mobileId && this.userGameId == platform101XPTokenIds.userGameId;
    }

    public int hashCode() {
        return (((j$.ExternalSyntheticBackport0.m(this.accountId) * 31) + j$.ExternalSyntheticBackport0.m(this.mobileId)) * 31) + j$.ExternalSyntheticBackport0.m(this.userGameId);
    }

    public String toString() {
        return "Platform101XPTokenIds(accountId=" + this.accountId + ", mobileId=" + this.mobileId + ", userGameId=" + this.userGameId + ')';
    }

    public Platform101XPTokenIds(long j, long j2, long j3) {
        this.accountId = j;
        this.mobileId = j2;
        this.userGameId = j3;
    }

    public /* synthetic */ Platform101XPTokenIds(long j, long j2, long j3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, (i & 4) != 0 ? 0L : j3);
    }

    public final long getAccountId() {
        return this.accountId;
    }

    public final long getMobileId() {
        return this.mobileId;
    }

    public final long getUserGameId() {
        return this.userGameId;
    }

    public final void setAccountId(long j) {
        this.accountId = j;
    }

    public final void setMobileId(long j) {
        this.mobileId = j;
    }

    public final void setUserGameId(long j) {
        this.userGameId = j;
    }
}
