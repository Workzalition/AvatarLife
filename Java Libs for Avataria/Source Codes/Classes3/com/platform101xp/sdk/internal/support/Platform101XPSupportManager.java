package com.platform101xp.sdk.internal.support;

import android.app.Dialog;
import com.platform101xp.sdk.internal.Platform101XPAccount;
import javax.inject.Inject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPSupportManager {
    @Inject
    Platform101XPHelpdesk supportHelpdesk;
    @Inject
    Platform101XPZendesk supportZendesk;

    public void initialize() {
        this.supportHelpdesk.initialize();
        this.supportZendesk.initialize();
    }

    public Platform101XPSupport getCurrentSupport() {
        return this.supportHelpdesk.isEnabled() ? this.supportHelpdesk : this.supportZendesk;
    }

    public void sendZendeskFeedback(String str, String str2, Dialog dialog) {
        if (!this.supportZendesk.isInitialized() || !this.supportZendesk.isEnabled()) {
            return;
        }
        this.supportZendesk.sendZendeskFeedback(str, str2, dialog);
    }

    public void updateDataFromConfig() {
        this.supportHelpdesk.updateDataFromConfig();
        this.supportZendesk.updateDataFromConfig();
    }

    public void setUserInfo(Platform101XPAccount platform101XPAccount) {
        this.supportZendesk.setUserinfo(platform101XPAccount);
    }
}
