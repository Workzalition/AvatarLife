package com.platform101xp.sdk.internal.configs;

import android.content.Context;
import com.platform101xp.sdk.internal.Platform101XPMetaManager;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPConfigModule.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0007H\u0007J\b\u0010\u0010\u001a\u00020\u0005H\u0007J\b\u0010\u0011\u001a\u00020\u0003H\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0007R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigModule;", "", "resultListener", "Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigResultListener;", "settings", "Lcom/platform101xp/sdk/internal/Platform101XPSettings;", "context", "Landroid/content/Context;", "(Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigResultListener;Lcom/platform101xp/sdk/internal/Platform101XPSettings;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getResultListener", "()Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigResultListener;", "getSettings", "()Lcom/platform101xp/sdk/internal/Platform101XPSettings;", "getAppContext", "getCurrentSettings", "getListener", "getMetaManager", "Lcom/platform101xp/sdk/internal/Platform101XPMetaManager;", "getMetaMatcher", "Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigMetaMatcher;", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPConfigModule {
    private final Context context;
    private final Platform101XPConfigResultListener resultListener;
    private final Platform101XPSettings settings;

    public Platform101XPConfigModule(Platform101XPConfigResultListener platform101XPConfigResultListener, Platform101XPSettings platform101XPSettings, Context context) {
        Intrinsics.checkNotNullParameter(platform101XPConfigResultListener, "resultListener");
        Intrinsics.checkNotNullParameter(platform101XPSettings, "settings");
        Intrinsics.checkNotNullParameter(context, "context");
        this.resultListener = platform101XPConfigResultListener;
        this.settings = platform101XPSettings;
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Platform101XPConfigResultListener getResultListener() {
        return this.resultListener;
    }

    public final Platform101XPSettings getSettings() {
        return this.settings;
    }

    @Provides
    public final Platform101XPConfigResultListener getListener() {
        return this.resultListener;
    }

    @Provides
    public final Platform101XPSettings getCurrentSettings() {
        return this.settings;
    }

    @Provides
    public final Platform101XPMetaManager getMetaManager() {
        return new Platform101XPMetaManager(this.context);
    }

    @Provides
    public final Platform101XPConfigMetaMatcher getMetaMatcher() {
        return new Platform101XPConfigMetaMatcher(this.context);
    }

    @Provides
    public final Context getAppContext() {
        return this.context;
    }
}
