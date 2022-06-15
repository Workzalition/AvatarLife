package com.platform101xp.sdk.internal.analytics;

import android.os.Bundle;
import com.platform101xp.sdk.internal.logcathelper.AppFilesHelper;
import com.tapjoy.TapjoyConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Platform101XPAnalyticsFirebase.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u0012\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00052\u0018\u0010\u0015\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalyticsFirebase;", "Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalyticsComponent;", "analyticsFirebaseMethods", "Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalyticsFirebaseMethods;", "deviceId", "", "appsflyerId", "(Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalyticsFirebaseMethods;Ljava/lang/String;Ljava/lang/String;)V", "widgetVersion", "initialize", "", "setProperty", "propertyName", "propertyValue", "setUserGameIdProperty", "userGameId", "accountId", "setWidgetVersion", "version", "track", "event", "eventValues", "", "", "Companion", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPAnalyticsFirebase implements Platform101XPAnalyticsComponent {
    public static final Companion Companion = new Companion(null);
    public static final String PROPERTY_APPFLYER_ID = "appsflyer_id";
    public static final String PROPERTY_DEVICE_ID = "device_id";
    public static final String PROPERTY_MOBILE_ID = "mobile_id";
    public static final String PROPERTY_USER_ID = "user_id";
    public static final String WIDGET_VERSION = "widget_version";
    private final Platform101XPAnalyticsFirebaseMethods analyticsFirebaseMethods;
    private final String appsflyerId;
    private final String deviceId;
    private String widgetVersion;

    /* compiled from: Platform101XPAnalyticsFirebase.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalyticsFirebase$Companion;", "", "()V", "PROPERTY_APPFLYER_ID", "", "PROPERTY_DEVICE_ID", "PROPERTY_MOBILE_ID", "PROPERTY_USER_ID", "WIDGET_VERSION", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Platform101XPAnalyticsFirebase(Platform101XPAnalyticsFirebaseMethods platform101XPAnalyticsFirebaseMethods, String str, String str2) {
        Intrinsics.checkNotNullParameter(platform101XPAnalyticsFirebaseMethods, "analyticsFirebaseMethods");
        Intrinsics.checkNotNullParameter(str, "deviceId");
        Intrinsics.checkNotNullParameter(str2, "appsflyerId");
        this.analyticsFirebaseMethods = platform101XPAnalyticsFirebaseMethods;
        this.deviceId = str;
        this.appsflyerId = str2;
    }

    @Override // com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsComponent
    public void initialize() {
        setProperty(PROPERTY_DEVICE_ID, this.deviceId);
        setProperty(PROPERTY_APPFLYER_ID, this.appsflyerId);
    }

    public final void setUserGameIdProperty(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "userGameId");
        Intrinsics.checkNotNullParameter(str2, "accountId");
        setProperty(PROPERTY_MOBILE_ID, str);
        setProperty(PROPERTY_USER_ID, str2);
        this.analyticsFirebaseMethods.setUserId(str);
    }

    private final void setProperty(String str, String str2) {
        this.analyticsFirebaseMethods.setUserProperty(str, str2);
    }

    @Override // com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsComponent
    public void track(String str, Map<Object, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "event");
        String replace$default = StringsKt.replace$default(str, "-", AppFilesHelper.SPACE, false, 4, (Object) null);
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        Bundle bundle = null;
        if (!StringsKt.startsWith$default(lowerCase, TapjoyConstants.TJC_SDK_PLACEMENT, false, 2, (Object) null)) {
            replace$default = Intrinsics.stringPlus("sdk_", replace$default);
        }
        if (map != null) {
            bundle = new Bundle();
            for (Map.Entry<Object, ? extends Object> entry : map.entrySet()) {
                bundle.putString(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            }
            bundle.putString(WIDGET_VERSION, this.widgetVersion);
        }
        this.analyticsFirebaseMethods.logEvent(replace$default, bundle);
    }

    @Override // com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsComponent
    public void setWidgetVersion(String str) {
        this.widgetVersion = str;
    }
}
