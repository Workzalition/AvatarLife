package com.platform101xp.sdk.internal.dialogs;

import android.app.Dialog;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPNativeDialogFactory;
import com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogFactory;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDialogsManager_Factory implements Factory<Platform101XPDialogsManager> {
    private final Provider<Platform101XPConfigManager> configManagerProvider;
    private final Provider<Platform101XPNativeDialogFactory> dialogNativeFactoryProvider;
    private final Provider<Platform101XPWebDialogFactory> dialogWebFactoryProvider;
    private final Provider<Dialog[]> dialogsProvider;

    public Platform101XPDialogsManager_Factory(Provider<Dialog[]> provider, Provider<Platform101XPConfigManager> provider2, Provider<Platform101XPNativeDialogFactory> provider3, Provider<Platform101XPWebDialogFactory> provider4) {
        this.dialogsProvider = provider;
        this.configManagerProvider = provider2;
        this.dialogNativeFactoryProvider = provider3;
        this.dialogWebFactoryProvider = provider4;
    }

    public Platform101XPDialogsManager get() {
        return newInstance((Dialog[]) this.dialogsProvider.get(), (Platform101XPConfigManager) this.configManagerProvider.get(), (Platform101XPNativeDialogFactory) this.dialogNativeFactoryProvider.get(), (Platform101XPWebDialogFactory) this.dialogWebFactoryProvider.get());
    }

    public static Platform101XPDialogsManager_Factory create(Provider<Dialog[]> provider, Provider<Platform101XPConfigManager> provider2, Provider<Platform101XPNativeDialogFactory> provider3, Provider<Platform101XPWebDialogFactory> provider4) {
        return new Platform101XPDialogsManager_Factory(provider, provider2, provider3, provider4);
    }

    public static Platform101XPDialogsManager newInstance(Dialog[] dialogArr, Platform101XPConfigManager platform101XPConfigManager, Platform101XPNativeDialogFactory platform101XPNativeDialogFactory, Platform101XPWebDialogFactory platform101XPWebDialogFactory) {
        return new Platform101XPDialogsManager(dialogArr, platform101XPConfigManager, platform101XPNativeDialogFactory, platform101XPWebDialogFactory);
    }
}
