package com.platform101xp.sdk.internal.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogParameters;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPDialogModule.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010!\u001a\u00020\u0003H\u0007J\u0015\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0007¢\u0006\u0002\u0010\u001bJ\b\u0010#\u001a\u00020\u0005H\u0007J\b\u0010$\u001a\u00020%H\u0007J\b\u0010&\u001a\u00020\u0007H\u0007J\b\u0010'\u001a\u00020\tH\u0007J\b\u0010(\u001a\u00020)H\u0007J\b\u0010*\u001a\u00020\u000bH\u0007R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006+"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogModule;", "", "currentActivity", "Landroid/app/Activity;", "configManager", "Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;", "settings", "Lcom/platform101xp/sdk/internal/Platform101XPSettings;", "clientId", "", "analytics", "Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;", "(Landroid/app/Activity;Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;Lcom/platform101xp/sdk/internal/Platform101XPSettings;Ljava/lang/String;Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;)V", "getAnalytics", "()Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;", "getClientId", "()Ljava/lang/String;", "getConfigManager", "()Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;", "getCurrentActivity", "()Landroid/app/Activity;", "setCurrentActivity", "(Landroid/app/Activity;)V", "dialogs", "", "Landroid/app/Dialog;", "getDialogs", "()[Landroid/app/Dialog;", "setDialogs", "([Landroid/app/Dialog;)V", "[Landroid/app/Dialog;", "getSettings", "()Lcom/platform101xp/sdk/internal/Platform101XPSettings;", "getActivity", "getAllDialogs", "getConfig", "getContext", "Landroid/content/Context;", "getCurrentSettings", "getIdClient", "getParameters", "Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebDialogParameters;", "getPlatformAnalytics", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDialogModule {
    private final Platform101XPAnalytics analytics;
    private final String clientId;
    private final Platform101XPConfigManager configManager;
    private Activity currentActivity;
    private Dialog[] dialogs = new Dialog[Platform101XPDialogType.values().length];
    private final Platform101XPSettings settings;

    public Platform101XPDialogModule(Activity activity, Platform101XPConfigManager platform101XPConfigManager, Platform101XPSettings platform101XPSettings, String str, Platform101XPAnalytics platform101XPAnalytics) {
        Intrinsics.checkNotNullParameter(activity, "currentActivity");
        Intrinsics.checkNotNullParameter(platform101XPConfigManager, "configManager");
        Intrinsics.checkNotNullParameter(platform101XPSettings, "settings");
        Intrinsics.checkNotNullParameter(str, "clientId");
        Intrinsics.checkNotNullParameter(platform101XPAnalytics, "analytics");
        this.currentActivity = activity;
        this.configManager = platform101XPConfigManager;
        this.settings = platform101XPSettings;
        this.clientId = str;
        this.analytics = platform101XPAnalytics;
    }

    public final Platform101XPAnalytics getAnalytics() {
        return this.analytics;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final Platform101XPConfigManager getConfigManager() {
        return this.configManager;
    }

    public final Activity getCurrentActivity() {
        return this.currentActivity;
    }

    public final Platform101XPSettings getSettings() {
        return this.settings;
    }

    public final void setCurrentActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<set-?>");
        this.currentActivity = activity;
    }

    public final Dialog[] getDialogs() {
        return this.dialogs;
    }

    public final void setDialogs(Dialog[] dialogArr) {
        Intrinsics.checkNotNullParameter(dialogArr, "<set-?>");
        this.dialogs = dialogArr;
    }

    @Provides
    public final Activity getActivity() {
        return this.currentActivity;
    }

    @Provides
    public final Context getContext() {
        Context applicationContext = this.currentActivity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "currentActivity.applicationContext");
        return applicationContext;
    }

    @Provides
    public final Dialog[] getAllDialogs() {
        return this.dialogs;
    }

    @Provides
    public final Platform101XPConfigManager getConfig() {
        return this.configManager;
    }

    @Provides
    public final Platform101XPSettings getCurrentSettings() {
        return this.settings;
    }

    @Provides
    public final String getIdClient() {
        return this.clientId;
    }

    @Provides
    public final Platform101XPAnalytics getPlatformAnalytics() {
        return this.analytics;
    }

    @Provides
    public final Platform101XPWebDialogParameters getParameters() {
        return new Platform101XPWebDialogParameters(this.clientId, this.configManager);
    }
}
