package com.platform101xp.sdk.internal.configs;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPFirebaseConfig.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u001a\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/platform101xp/sdk/internal/configs/Platform101XPFirebaseConfig;", "", "()V", "remoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "getBoolean", "", "key", "", "defValue", "getDouble", "", "getInt", "", "getLong", "", "getString", "getStringOrNull", "getValue", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfigValue;", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseConfig {
    private final FirebaseRemoteConfig remoteConfig;

    @Inject
    public Platform101XPFirebaseConfig() {
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseRemoteConfig, "getInstance()");
        this.remoteConfig = firebaseRemoteConfig;
        FirebaseRemoteConfigSettings build = new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(0L).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder().setMinimumFetc…ervalInSeconds(0).build()");
        firebaseRemoteConfig.setConfigSettingsAsync(build);
        firebaseRemoteConfig.fetchAndActivate();
    }

    public final boolean getBoolean(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        FirebaseRemoteConfigValue value = getValue(str);
        return value == null ? z : value.asBoolean();
    }

    public final int getInt(String str, int i) {
        String asString;
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            FirebaseRemoteConfigValue value = getValue(str);
            if (value != null && (asString = value.asString()) != null) {
                return Integer.parseInt(asString);
            }
            return i;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public final String getString(String str, String str2) {
        String asString;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "defValue");
        FirebaseRemoteConfigValue value = getValue(str);
        return (value == null || (asString = value.asString()) == null) ? str2 : asString;
    }

    public final String getStringOrNull(String str, String str2) {
        String asString;
        Intrinsics.checkNotNullParameter(str, "key");
        FirebaseRemoteConfigValue value = getValue(str);
        return (value == null || (asString = value.asString()) == null) ? str2 : asString;
    }

    public final long getLong(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        FirebaseRemoteConfigValue value = getValue(str);
        return value == null ? j : value.asLong();
    }

    public final double getDouble(String str, double d) {
        Intrinsics.checkNotNullParameter(str, "key");
        FirebaseRemoteConfigValue value = getValue(str);
        return value == null ? d : value.asDouble();
    }

    private final FirebaseRemoteConfigValue getValue(String str) {
        boolean z = this.remoteConfig.getInfo().getLastFetchStatus() == -1 && this.remoteConfig.getAll().containsKey(str);
        if (z) {
            return this.remoteConfig.getValue(str);
        }
        if (z) {
            throw new NoWhenBranchMatchedException();
        }
        return null;
    }
}
