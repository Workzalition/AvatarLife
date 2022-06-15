package com.platform101xp.sdk.internal.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPUserRewardEntity.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/platform101xp/sdk/internal/entities/Platform101XPUserRewardEntity;", "", "senderUserId", "", "event", "(Ljava/lang/String;Ljava/lang/String;)V", "isUsersRewarded", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getEvent", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", "()Z", "setUsersRewarded", "(Z)V", "getSenderUserId", "setSenderUserId", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPUserRewardEntity {
    private String event;
    private boolean isUsersRewarded;
    private String senderUserId;

    public final String getEvent() {
        return this.event;
    }

    public final void setEvent(String str) {
        this.event = str;
    }

    public final String getSenderUserId() {
        return this.senderUserId;
    }

    public final void setSenderUserId(String str) {
        this.senderUserId = str;
    }

    public final boolean isUsersRewarded() {
        return this.isUsersRewarded;
    }

    public final void setUsersRewarded(boolean z) {
        this.isUsersRewarded = z;
    }

    public Platform101XPUserRewardEntity(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "senderUserId");
        Intrinsics.checkNotNullParameter(str2, "event");
        this.senderUserId = str;
        this.event = str2;
        this.isUsersRewarded = false;
    }

    public Platform101XPUserRewardEntity(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "senderUserId");
        Intrinsics.checkNotNullParameter(str2, "event");
        this.senderUserId = str;
        this.event = str2;
        this.isUsersRewarded = z;
    }
}
