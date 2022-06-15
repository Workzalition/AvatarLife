package com.platform101xp.sdk.internal.billing.web_store;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import com.platform101xp.sdk.Platform101XPVersion;
import com.platform101xp.sdk.internal.Platform101XPUtils;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsFirebase;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.logcathelper.AppFilesHelper;
import com.platform101xp.sdk.internal.token.Platform101XPTokenManager;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Platform101XPWebStore.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002J\u001e\u0010\u0016\u001a\u00020\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0019H\u0002J\u001c\u0010\u001a\u001a\u00020\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/platform101xp/sdk/internal/billing/web_store/Platform101XPWebStore;", "", "activity", "Landroid/app/Activity;", "configManager", "Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;", "utils", "Lcom/platform101xp/sdk/internal/Platform101XPUtils;", "tokenManager", "Lcom/platform101xp/sdk/internal/token/Platform101XPTokenManager;", "(Landroid/app/Activity;Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;Lcom/platform101xp/sdk/internal/Platform101XPUtils;Lcom/platform101xp/sdk/internal/token/Platform101XPTokenManager;)V", "sngLocaleList", "", "", "webProperties", "", "getBaseUrlString", "getLocalTimeZone", "getLocale", "getModel", "getProjectName", "getPropertiesString", "prepareWebProperties", "", "properties", "", TJAdUnitConstants.String.BEACON_SHOW_PATH, "Companion", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPWebStore {
    public static final Companion Companion = new Companion(null);
    private static final String project_name = "web_store_project_name";
    private final Activity activity;
    private final Platform101XPConfigManager configManager;
    private final Platform101XPTokenManager tokenManager;
    private final Platform101XPUtils utils;
    private final List<String> sngLocaleList = CollectionsKt.listOf(new String[]{"be", "ru", "uk"});
    private final Map<String, String> webProperties = new LinkedHashMap();

    public Platform101XPWebStore(Activity activity, Platform101XPConfigManager platform101XPConfigManager, Platform101XPUtils platform101XPUtils, Platform101XPTokenManager platform101XPTokenManager) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(platform101XPConfigManager, "configManager");
        Intrinsics.checkNotNullParameter(platform101XPUtils, "utils");
        Intrinsics.checkNotNullParameter(platform101XPTokenManager, "tokenManager");
        this.activity = activity;
        this.configManager = platform101XPConfigManager;
        this.utils = platform101XPUtils;
        this.tokenManager = platform101XPTokenManager;
    }

    /* compiled from: Platform101XPWebStore.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/platform101xp/sdk/internal/billing/web_store/Platform101XPWebStore$Companion;", "", "()V", "project_name", "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void show(Map<String, String> map) {
        prepareWebProperties(map);
        String str = getBaseUrlString() + '?' + getPropertiesString();
        Log.d("101XP SDK", Intrinsics.stringPlus("Web store url: ", str));
        this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void prepareWebProperties(Map<String, String> map) {
        this.webProperties.put("os_name", Build.VERSION.CODENAME);
        this.webProperties.put(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, String.valueOf(Build.VERSION.SDK_INT));
        this.webProperties.put(TapjoyConstants.TJC_DEVICE_NAME, Settings.System.getString(this.activity.getContentResolver(), TapjoyConstants.TJC_DEVICE_NAME));
        this.webProperties.put("device_model", getModel());
        this.webProperties.put("sdk_version", Platform101XPVersion.VERSION);
        this.webProperties.put("local_timezone", getLocalTimeZone());
        this.webProperties.put("game_id", String.valueOf(this.tokenManager.getCurrentUserGameId()));
        this.webProperties.put(Platform101XPAnalyticsFirebase.PROPERTY_MOBILE_ID, String.valueOf(this.tokenManager.getMobileId()));
        this.webProperties.put(Platform101XPTokenManager.KEY_ACCESS_TOKEN, this.tokenManager.getAccessTokenValue());
        this.webProperties.put("is_guest", String.valueOf(this.tokenManager.isGuestCurrentToken()));
        if (map == null) {
            return;
        }
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!this.webProperties.containsKey(entry.getKey())) {
                this.webProperties.put(entry.getKey(), entry.getValue());
            }
        }
    }

    private final String getBaseUrlString() {
        return "https://market.101xp.com/" + getLocale() + "/mobile/" + getProjectName();
    }

    private final String getProjectName() {
        return this.configManager.getString(project_name, "");
    }

    private final String getLocale() {
        return this.sngLocaleList.contains(new Locale(Platform101XPUtils.getLocale()).getLanguage()) ? "ru" : "en";
    }

    private final String getLocalTimeZone() {
        String id = TimeZone.getDefault().getID();
        Intrinsics.checkNotNullExpressionValue(id, "getDefault().id");
        return id;
    }

    private final String getModel() {
        String str = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str, "MODEL");
        return StringsKt.replace$default(str, " ", AppFilesHelper.SPACE, false, 4, (Object) null);
    }

    private final String getPropertiesString() {
        Iterator<T> it = this.webProperties.entrySet().iterator();
        String str = "";
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            str = str + '&' + ((String) entry.getKey()) + '=' + entry.getValue();
        }
        return StringsKt.replaceFirst$default(str, "&", "", false, 4, (Object) null);
    }
}
