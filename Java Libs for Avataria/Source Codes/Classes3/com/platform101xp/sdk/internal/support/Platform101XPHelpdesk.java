package com.platform101xp.sdk.internal.support;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPVersion;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import javax.inject.Inject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPHelpdesk implements Platform101XPSupport {
    @Inject
    Platform101XPConfigManager configManager;
    @Inject
    Activity currentActivity;
    private boolean enabled;
    private boolean initialized;
    private String supportUrl;
    private String zendeskGameId;

    @Override // com.platform101xp.sdk.internal.support.Platform101XPSupport
    public void initialize() {
        this.zendeskGameId = this.configManager.getString(Platform101XPConfigKeyHolder.zendeskGameId, "");
        String string = this.configManager.getString(Platform101XPConfigKeyHolder.webSupportUrl, "");
        this.supportUrl = string;
        if (this.zendeskGameId == null || string == null) {
            return;
        }
        this.initialized = true;
        checkEnabled();
    }

    @Override // com.platform101xp.sdk.internal.support.Platform101XPSupport
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override // com.platform101xp.sdk.internal.support.Platform101XPSupport
    public boolean isInitialized() {
        return this.initialized;
    }

    @Override // com.platform101xp.sdk.internal.support.Platform101XPSupport
    public void showSupportForm() {
        checkEnabled();
        if (!isEnabled() || this.currentActivity == null || Platform101XP.getToken() == null) {
            return;
        }
        this.supportUrl += "?os_name=" + Build.VERSION.CODENAME + "&os_version=" + Build.VERSION.SDK_INT + "&game_id=" + this.zendeskGameId + "&device_name=" + Build.DEVICE + "&sdk_version=" + Platform101XPVersion.VERSION + "&project_id=" + this.configManager.getString(Platform101XPConfigKeyHolder.analyticsProjectId, "") + "&access_token=" + Platform101XP.getToken().getAccessToken().getId();
        this.currentActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.supportUrl)));
    }

    private void checkEnabled() {
        this.enabled = isInitialized() && !this.zendeskGameId.isEmpty() && !this.supportUrl.isEmpty();
    }

    @Override // com.platform101xp.sdk.internal.support.Platform101XPSupport
    public void updateDataFromConfig() {
        this.zendeskGameId = this.configManager.getString(Platform101XPConfigKeyHolder.zendeskGameId, "");
        this.supportUrl = this.configManager.getString(Platform101XPConfigKeyHolder.webSupportUrl, "");
        checkEnabled();
    }
}
