package com.platform101xp.sdk.internal.configs;

import android.util.Log;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: Platform101XPConfigData.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bJ\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u00020\u0003@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigData;", "", "settings", "Lcom/platform101xp/sdk/internal/Platform101XPSettings;", "(Lcom/platform101xp/sdk/internal/Platform101XPSettings;)V", "jsonConfig", "Lorg/json/JSONObject;", "getSettings", "()Lcom/platform101xp/sdk/internal/Platform101XPSettings;", "setSettings", "getBooleanValue", "", "key", "", "defValue", "getDoubleValue", "", "getIntValue", "", "getLongValue", "", "getStringValue", "initializeLocalConfig", "", "devMode", "testBilling", "updateConfig", "currentConfig", "Companion", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPConfigData {
    public static final Companion Companion = new Companion(null);
    public static final String DEV_MODE_KEY = "com.platform101xp.sdk.dev_mode_key";
    public static final String LOCAL_CONFIG_KEY = "com.platform101xp.sdk.local_config";
    public static final String TEST_BILLING_KEY = "com.platform101xp.sdk.test_billing_key";
    private JSONObject jsonConfig;
    private Platform101XPSettings settings;

    /* compiled from: Platform101XPConfigData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigData$Companion;", "", "()V", "DEV_MODE_KEY", "", "LOCAL_CONFIG_KEY", "TEST_BILLING_KEY", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Inject
    public Platform101XPConfigData(Platform101XPSettings platform101XPSettings) {
        Intrinsics.checkNotNullParameter(platform101XPSettings, "settings");
        this.settings = platform101XPSettings;
        String string = this.settings.getString(LOCAL_CONFIG_KEY);
        this.jsonConfig = new JSONObject(string == null ? "{}" : string);
    }

    public final Platform101XPSettings getSettings() {
        return this.settings;
    }

    @Inject
    public final void setSettings(Platform101XPSettings platform101XPSettings) {
        Intrinsics.checkNotNullParameter(platform101XPSettings, "<set-?>");
        this.settings = platform101XPSettings;
    }

    public final void initializeLocalConfig(boolean z, boolean z2) {
        this.settings.setBoolean(DEV_MODE_KEY, z);
        this.settings.setBoolean(TEST_BILLING_KEY, z2);
        Log.d("101XP SDK", Intrinsics.stringPlus("Local Config string: ", this.jsonConfig));
    }

    public final void updateConfig(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "currentConfig");
        this.jsonConfig = jSONObject;
        this.settings.setString(LOCAL_CONFIG_KEY, String.valueOf(jSONObject));
        if (jSONObject.has("dev_mode")) {
            this.settings.setBoolean(DEV_MODE_KEY, jSONObject.getBoolean("dev_mode"));
        }
        if (jSONObject.has("billing_test")) {
            this.settings.setBoolean(TEST_BILLING_KEY, jSONObject.getBoolean("billing_test"));
        }
    }

    public final String getStringValue(String str, String str2) {
        JSONObject jSONObject;
        String optString;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "defValue");
        JSONObject jSONObject2 = this.jsonConfig;
        boolean z = false;
        if (jSONObject2 != null && jSONObject2.has(str)) {
            z = true;
        }
        return (!z || (jSONObject = this.jsonConfig) == null || (optString = jSONObject.optString(str)) == null) ? str2 : optString;
    }

    public final boolean getBooleanValue(String str, boolean z) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(str, "key");
        JSONObject jSONObject2 = this.jsonConfig;
        boolean z2 = false;
        if (jSONObject2 != null && jSONObject2.has(str)) {
            z2 = true;
        }
        return (z2 && (jSONObject = this.jsonConfig) != null) ? jSONObject.optBoolean(str) : z;
    }

    public final int getIntValue(String str, int i) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(str, "key");
        JSONObject jSONObject2 = this.jsonConfig;
        boolean z = false;
        if (jSONObject2 != null && jSONObject2.has(str)) {
            z = true;
        }
        return (z && (jSONObject = this.jsonConfig) != null) ? jSONObject.optInt(str) : i;
    }

    public final long getLongValue(String str, long j) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(str, "key");
        JSONObject jSONObject2 = this.jsonConfig;
        boolean z = false;
        if (jSONObject2 != null && jSONObject2.has(str)) {
            z = true;
        }
        return (z && (jSONObject = this.jsonConfig) != null) ? jSONObject.optLong(str) : j;
    }

    public final double getDoubleValue(String str, double d) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(str, "key");
        JSONObject jSONObject2 = this.jsonConfig;
        boolean z = false;
        if (jSONObject2 != null && jSONObject2.has(str)) {
            z = true;
        }
        return (z && (jSONObject = this.jsonConfig) != null) ? jSONObject.optDouble(str) : d;
    }
}
