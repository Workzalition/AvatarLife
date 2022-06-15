package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import android.app.Activity;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsBuffer;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.token.Platform101XPTokenManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPDynamicLinksModule.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0016\u001a\u00020\fH\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u0019\u001a\u00020\u0005H\u0007J\b\u0010\u001a\u001a\u00020\u0003H\u0007J\b\u0010\u001b\u001a\u00020\tH\u0007J\b\u0010\u001c\u001a\u00020\tH\u0007J\b\u0010\u001d\u001a\u00020\u0007H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/dynamiclinks/Platform101XPDynamicLinksModule;", "", "activity", "Landroid/app/Activity;", "configManager", "Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;", "tokenManager", "Lcom/platform101xp/sdk/internal/token/Platform101XPTokenManager;", "clientId", "", "currentDeviceId", "currentAnalytics", "Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;", "(Landroid/app/Activity;Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;Lcom/platform101xp/sdk/internal/token/Platform101XPTokenManager;Ljava/lang/String;Ljava/lang/String;Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;)V", "getActivity", "()Landroid/app/Activity;", "getClientId", "()Ljava/lang/String;", "getConfigManager", "()Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;", "getCurrentAnalytics", "()Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;", "getAnalytics", "getBuffer", "Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalyticsBuffer;", "getConfig", "getCurrentActivity", "getCurrentClientId", "getDeviceId", "getTokenManagerInstance", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDynamicLinksModule {
    private final Activity activity;
    private final String clientId;
    private final Platform101XPConfigManager configManager;
    private final Platform101XPAnalytics currentAnalytics;
    private final String currentDeviceId;
    private final Platform101XPTokenManager tokenManager;

    public Platform101XPDynamicLinksModule(Activity activity, Platform101XPConfigManager platform101XPConfigManager, Platform101XPTokenManager platform101XPTokenManager, String str, String str2, Platform101XPAnalytics platform101XPAnalytics) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(platform101XPConfigManager, "configManager");
        Intrinsics.checkNotNullParameter(platform101XPTokenManager, "tokenManager");
        Intrinsics.checkNotNullParameter(str, "clientId");
        Intrinsics.checkNotNullParameter(str2, "currentDeviceId");
        Intrinsics.checkNotNullParameter(platform101XPAnalytics, "currentAnalytics");
        this.activity = activity;
        this.configManager = platform101XPConfigManager;
        this.tokenManager = platform101XPTokenManager;
        this.clientId = str;
        this.currentDeviceId = str2;
        this.currentAnalytics = platform101XPAnalytics;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final Platform101XPConfigManager getConfigManager() {
        return this.configManager;
    }

    public final Platform101XPAnalytics getCurrentAnalytics() {
        return this.currentAnalytics;
    }

    @Provides
    public final Activity getCurrentActivity() {
        return this.activity;
    }

    @Provides
    public final Platform101XPConfigManager getConfig() {
        return this.configManager;
    }

    @Provides
    public final Platform101XPTokenManager getTokenManagerInstance() {
        return this.tokenManager;
    }

    @Provides
    @Named("clientId")
    public final String getCurrentClientId() {
        return this.clientId;
    }

    @Provides
    @Named("deviceId")
    public final String getDeviceId() {
        return this.currentDeviceId;
    }

    @Provides
    public final Platform101XPAnalyticsBuffer getBuffer() {
        return new Platform101XPAnalyticsBuffer();
    }

    @Provides
    public final Platform101XPAnalytics getAnalytics() {
        return this.currentAnalytics;
    }
}
