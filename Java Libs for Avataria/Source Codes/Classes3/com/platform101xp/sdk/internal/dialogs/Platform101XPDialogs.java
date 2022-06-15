package com.platform101xp.sdk.internal.dialogs;

import com.tapjoy.TapjoyAuctionFlags;
import kotlin.Metadata;

/* compiled from: Platform101XPDialogs.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\nH&¨\u0006\r"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogs;", "", "dismissCurrentDialog", "", TapjoyAuctionFlags.AUCTION_TYPE, "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogType;", "dismissDialogs", "getFactory", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogFactory;", "isDialogShowing", "", "isWebDialogs", "OnUserCancelAction", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public interface Platform101XPDialogs {

    /* compiled from: Platform101XPDialogs.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogs$OnUserCancelAction;", "", "onCancelClick", "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public interface OnUserCancelAction {
        void onCancelClick();
    }

    void dismissCurrentDialog(Platform101XPDialogType platform101XPDialogType);

    void dismissDialogs();

    Platform101XPDialogFactory getFactory();

    boolean isDialogShowing(Platform101XPDialogType platform101XPDialogType);

    boolean isWebDialogs();
}
