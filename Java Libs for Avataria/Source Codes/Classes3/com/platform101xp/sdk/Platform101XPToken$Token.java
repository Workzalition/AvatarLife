package com.platform101xp.sdk;

import com.tapjoy.TapjoyAuctionFlags;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPToken.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/platform101xp/sdk/Platform101XPToken$Token;", "", TapjoyAuctionFlags.AUCTION_ID, "", "expires", "", "(Lcom/platform101xp/sdk/Platform101XPToken;Ljava/lang/String;J)V", "getExpires", "()J", "setExpires", "(J)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "isExpired", "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPToken$Token {
    private long expires;
    private String id;
    final /* synthetic */ Platform101XPToken this$0;

    public Platform101XPToken$Token(Platform101XPToken platform101XPToken, String str, long j) {
        Intrinsics.checkNotNullParameter(platform101XPToken, "this$0");
        Intrinsics.checkNotNullParameter(str, TapjoyAuctionFlags.AUCTION_ID);
        this.this$0 = platform101XPToken;
        this.id = str;
        this.expires = j;
    }

    public final long getExpires() {
        return this.expires;
    }

    public final String getId() {
        return this.id;
    }

    public final void setExpires(long j) {
        this.expires = j;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final boolean isExpired() {
        return (this.expires * ((long) 1000)) - ((long) 300000) < System.currentTimeMillis();
    }
}
