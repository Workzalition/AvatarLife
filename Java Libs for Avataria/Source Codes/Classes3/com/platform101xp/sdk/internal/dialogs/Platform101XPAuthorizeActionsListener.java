package com.platform101xp.sdk.internal.dialogs;

import android.view.View;
import kotlin.Metadata;

/* compiled from: Platform101XPAuthorizeActionsListener.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/Platform101XPAuthorizeActionsListener;", "", "onAuthorizeClick", "", "v", "Landroid/view/View;", "onCancelClick", "onGuestClick", "onUserUpdate", "userData", "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public interface Platform101XPAuthorizeActionsListener {
    void onAuthorizeClick(View view);

    void onCancelClick();

    void onGuestClick();

    void onUserUpdate(String str);
}
