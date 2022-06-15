package com.platform101xp.sdk.internal.dialogs;

import com.ironsource.mediationsdk.adunit.data.DataKeys;
import kotlin.Metadata;

/* compiled from: Platform101XPProfileActionsListener.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0012\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/Platform101XPProfileActionsListener;", "", "onAuthorizeClick", "", "onCancelClick", "onCloseClick", "onDeleteLatestAccount", DataKeys.USER_ID, "", "onDismissDialog", "onLogoutClick", "onRestoreProduct", "onSendLogs", "onUserUpdate", "userData", "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public interface Platform101XPProfileActionsListener {
    void onAuthorizeClick();

    void onCancelClick();

    void onCloseClick();

    void onDeleteLatestAccount(long j);

    void onDismissDialog();

    void onLogoutClick(long j);

    void onRestoreProduct();

    void onSendLogs();

    void onUserUpdate(String str);

    /* compiled from: Platform101XPProfileActionsListener.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onLogoutClick$default(Platform101XPProfileActionsListener platform101XPProfileActionsListener, long j, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    j = -1;
                }
                platform101XPProfileActionsListener.onLogoutClick(j);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLogoutClick");
        }
    }
}
