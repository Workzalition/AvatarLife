package com.platform101xp.sdk.internal.analytics;

import android.app.Activity;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TJAdUnitConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPAnalyticsFirebaseMethods.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalyticsFirebaseMethods;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "logEvent", "", "eventName", "", TJAdUnitConstants.String.BEACON_PARAMS, "Landroid/os/Bundle;", "setUserId", "userGameId", "setUserProperty", "propertyName", "propertyValue", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPAnalyticsFirebaseMethods {
    private final Activity activity;
    private FirebaseAnalytics firebaseAnalytics;

    public Platform101XPAnalyticsFirebaseMethods(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(activity);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(activity)");
        this.firebaseAnalytics = firebaseAnalytics;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "userGameId");
        this.firebaseAnalytics.setUserId(str);
    }

    public final void setUserProperty(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "propertyName");
        Intrinsics.checkNotNullParameter(str2, "propertyValue");
        this.firebaseAnalytics.setUserProperty(str, str2);
    }

    public final void logEvent(String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        this.firebaseAnalytics.logEvent(str, bundle);
    }
}
