package com.platform101xp.sdk.internal.socialnetworks;

import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSocialNetwork;
import com.platform101xp.sdk.internal.token.Platform101XPTokenManager;
import dagger.Module;
import dagger.Provides;

@Module
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPSnModule {
    private String clientId;
    private Platform101XPConfigManager configManager;
    private Platform101XPDialogFactory dialogsFactory;
    private Platform101XPSocialNetwork.SocialNetworkListener listener;
    private Platform101XPTokenManager tokenManager;

    public Platform101XPSnModule(Platform101XPSocialNetwork.SocialNetworkListener socialNetworkListener, String str, Platform101XPDialogFactory platform101XPDialogFactory, Platform101XPConfigManager platform101XPConfigManager, Platform101XPTokenManager platform101XPTokenManager) {
        this.listener = socialNetworkListener;
        this.clientId = str;
        this.dialogsFactory = platform101XPDialogFactory;
        this.configManager = platform101XPConfigManager;
        this.tokenManager = platform101XPTokenManager;
    }

    @Provides
    public Platform101XPSocialNetwork.SocialNetworkListener getListener() {
        return this.listener;
    }

    @Provides
    public String getClientId() {
        return this.clientId;
    }

    @Provides
    public Platform101XPDialogFactory getDialogsFactory() {
        return this.dialogsFactory;
    }

    @Provides
    public Platform101XPConfigManager getConfigManager() {
        return this.configManager;
    }

    @Provides
    public Platform101XPTokenManager getTokenManager() {
        return this.tokenManager;
    }
}
