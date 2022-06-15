package com.platform101xp.sdk.internal.support;

import android.app.Activity;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import dagger.Module;
import dagger.Provides;

@Module
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPSupportModule {
    private Platform101XPConfigManager configManager;
    private Activity currentActivity;

    public Platform101XPSupportModule(Activity activity, Platform101XPConfigManager platform101XPConfigManager) {
        this.currentActivity = activity;
        this.configManager = platform101XPConfigManager;
    }

    @Provides
    public Activity getActivity() {
        return this.currentActivity;
    }

    @Provides
    public Platform101XPConfigManager getConfigManager() {
        return this.configManager;
    }
}
