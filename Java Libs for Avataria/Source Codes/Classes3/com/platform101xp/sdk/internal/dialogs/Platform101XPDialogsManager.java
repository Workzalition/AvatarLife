package com.platform101xp.sdk.internal.dialogs;

import android.app.Dialog;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPNativeDialogFactory;
import com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogFactory;
import com.tapjoy.TapjoyAuctionFlags;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPDialogsManager.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogsManager;", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogs;", "dialogs", "", "Landroid/app/Dialog;", "configManager", "Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;", "dialogNativeFactory", "Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPNativeDialogFactory;", "dialogWebFactory", "Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebDialogFactory;", "([Landroid/app/Dialog;Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPNativeDialogFactory;Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebDialogFactory;)V", "[Landroid/app/Dialog;", "dismissCurrentDialog", "", TapjoyAuctionFlags.AUCTION_TYPE, "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogType;", "dismissDialogs", "getFactory", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogFactory;", "isDialogShowing", "", "isWebDialogs", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDialogsManager implements Platform101XPDialogs {
    private final Platform101XPConfigManager configManager;
    private final Platform101XPNativeDialogFactory dialogNativeFactory;
    private final Platform101XPWebDialogFactory dialogWebFactory;
    private final Dialog[] dialogs;

    @Inject
    public Platform101XPDialogsManager(Dialog[] dialogArr, Platform101XPConfigManager platform101XPConfigManager, Platform101XPNativeDialogFactory platform101XPNativeDialogFactory, Platform101XPWebDialogFactory platform101XPWebDialogFactory) {
        Intrinsics.checkNotNullParameter(dialogArr, "dialogs");
        Intrinsics.checkNotNullParameter(platform101XPConfigManager, "configManager");
        Intrinsics.checkNotNullParameter(platform101XPNativeDialogFactory, "dialogNativeFactory");
        Intrinsics.checkNotNullParameter(platform101XPWebDialogFactory, "dialogWebFactory");
        this.dialogs = dialogArr;
        this.configManager = platform101XPConfigManager;
        this.dialogNativeFactory = platform101XPNativeDialogFactory;
        this.dialogWebFactory = platform101XPWebDialogFactory;
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs
    public Platform101XPDialogFactory getFactory() {
        if (isWebDialogs()) {
            return this.dialogWebFactory;
        }
        return this.dialogNativeFactory;
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs
    public void dismissDialogs() {
        Dialog[] dialogArr = this.dialogs;
        int length = dialogArr.length;
        int i = 0;
        while (i < length) {
            Dialog dialog = dialogArr[i];
            i++;
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs
    public void dismissCurrentDialog(Platform101XPDialogType platform101XPDialogType) {
        Intrinsics.checkNotNullParameter(platform101XPDialogType, TapjoyAuctionFlags.AUCTION_TYPE);
        this.dialogs[platform101XPDialogType.ordinal()].dismiss();
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs
    public boolean isDialogShowing(Platform101XPDialogType platform101XPDialogType) {
        Intrinsics.checkNotNullParameter(platform101XPDialogType, TapjoyAuctionFlags.AUCTION_TYPE);
        Dialog[] dialogArr = this.dialogs;
        if (!(!(dialogArr.length == 0)) || dialogArr[platform101XPDialogType.ordinal()] == null) {
            return false;
        }
        return this.dialogs[platform101XPDialogType.ordinal()].isShowing();
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs
    public boolean isWebDialogs() {
        return this.configManager.getBool(Platform101XPConfigKeyHolder.webUiEnabled, false);
    }
}
