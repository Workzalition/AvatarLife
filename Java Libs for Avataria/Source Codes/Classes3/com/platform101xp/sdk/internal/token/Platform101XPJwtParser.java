package com.platform101xp.sdk.internal.token;

import com.auth0.android.jwt.JWT;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsFirebase;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPJwtParser.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\u0003H\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/platform101xp/sdk/internal/token/Platform101XPJwtParser;", "", "jwtString", "", "(Ljava/lang/String;)V", "jwt", "Lcom/auth0/android/jwt/JWT;", "getExtraParam", "parameterName", "getMobileId", "", "isGuest", "", "Builder", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPJwtParser {
    private JWT jwt;

    public /* synthetic */ Platform101XPJwtParser(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private Platform101XPJwtParser(String str) {
        this.jwt = new JWT(str);
    }

    public final boolean isGuest() {
        return Intrinsics.areEqual(this.jwt.getSubject(), "0");
    }

    public final long getMobileId() {
        Object extraParam = getExtraParam(Platform101XPAnalyticsFirebase.PROPERTY_MOBILE_ID);
        if (extraParam == null) {
            return 0L;
        }
        return (long) ((Double) extraParam).doubleValue();
    }

    private final Object getExtraParam(String str) {
        Map map = (Map) this.jwt.getClaim("extra_params").asObject(Map.class);
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    /* compiled from: Platform101XPJwtParser.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/platform101xp/sdk/internal/token/Platform101XPJwtParser$Builder;", "", "()V", "jwtString", "", "build", "Lcom/platform101xp/sdk/internal/token/Platform101XPJwtParser;", "setJwtString", "accessToken", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Builder {
        private String jwtString;

        public final Builder setJwtString(String str) {
            Intrinsics.checkNotNullParameter(str, "accessToken");
            Builder builder = this;
            builder.jwtString = str;
            return builder;
        }

        public final Platform101XPJwtParser build() {
            String str = this.jwtString;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jwtString");
                str = null;
            }
            return new Platform101XPJwtParser(str, null);
        }
    }
}
