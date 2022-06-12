package com.platform101xp.sdk.entities;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPSocialFriend.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/platform101xp/sdk/entities/Platform101XPSocialFriend;", "", "socialNetId", "", "name", "pictureUrl", "mobileId", "", FirebaseAnalytics.Param.LEVEL, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JI)V", "getLevel", "()I", "setLevel", "(I)V", "getMobileId", "()J", "setMobileId", "(J)V", "getName", "()Ljava/lang/String;", "getPictureUrl", "getSocialNetId", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPSocialFriend {
    private int level;
    private long mobileId;
    private final String name;
    private final String pictureUrl;
    private final String socialNetId;

    public Platform101XPSocialFriend(String str, String str2, String str3, long j, int i) {
        Intrinsics.checkNotNullParameter(str, "socialNetId");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "pictureUrl");
        this.socialNetId = str;
        this.name = str2;
        this.pictureUrl = str3;
        this.mobileId = j;
        this.level = i;
    }

    public /* synthetic */ Platform101XPSocialFriend(String str, String str2, String str3, long j, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i2 & 8) != 0 ? -1L : j, (i2 & 16) != 0 ? -1 : i);
    }

    public final int getLevel() {
        return this.level;
    }

    public final long getMobileId() {
        return this.mobileId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPictureUrl() {
        return this.pictureUrl;
    }

    public final String getSocialNetId() {
        return this.socialNetId;
    }

    public final void setLevel(int i) {
        this.level = i;
    }

    public final void setMobileId(long j) {
        this.mobileId = j;
    }
}
