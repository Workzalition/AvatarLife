package com.platform101xp.sdk.internal.dialogs.webdialogs;

import android.app.Activity;
import android.app.Dialog;
import android.webkit.JavascriptInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPWebDialogsConstructor.kt */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0007J\b\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0005"}, d2 = {"com/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebDialogsConstructor$getGuestAuthorizeWarning$jsInterface$1", "", "getAgreeConnect", "", "getDisagreeConnect", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPWebDialogsConstructor$getGuestAuthorizeWarning$jsInterface$1 {
    final /* synthetic */ Function0<Unit> $bindAction;
    final /* synthetic */ Function0<Unit> $cancelAction;
    final /* synthetic */ Platform101XPWebDialogsConstructor this$0;

    public Platform101XPWebDialogsConstructor$getGuestAuthorizeWarning$jsInterface$1(Platform101XPWebDialogsConstructor platform101XPWebDialogsConstructor, Function0<Unit> function0, Function0<Unit> function02) {
        this.this$0 = platform101XPWebDialogsConstructor;
        this.$bindAction = function0;
        this.$cancelAction = function02;
    }

    @JavascriptInterface
    public final void getAgreeConnect() {
        Dialog dialog;
        dialog = this.this$0.currentWebDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentWebDialog");
            dialog = null;
        }
        dialog.dismiss();
        Activity currentActivity = this.this$0.getCurrentActivity();
        final Function0<Unit> function0 = this.$bindAction;
        currentActivity.runOnUiThread(new Runnable() { // from class: com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogsConstructor$getGuestAuthorizeWarning$jsInterface$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Platform101XPWebDialogsConstructor$getGuestAuthorizeWarning$jsInterface$1.m149getAgreeConnect$lambda0(function0);
            }
        });
    }

    /* renamed from: getAgreeConnect$lambda-0 */
    public static final void m149getAgreeConnect$lambda0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$bindAction");
        function0.invoke();
    }

    @JavascriptInterface
    public final void getDisagreeConnect() {
        Dialog dialog;
        dialog = this.this$0.currentWebDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentWebDialog");
            dialog = null;
        }
        dialog.dismiss();
        Activity currentActivity = this.this$0.getCurrentActivity();
        final Function0<Unit> function0 = this.$cancelAction;
        currentActivity.runOnUiThread(new Runnable() { // from class: com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogsConstructor$getGuestAuthorizeWarning$jsInterface$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Platform101XPWebDialogsConstructor$getGuestAuthorizeWarning$jsInterface$1.m150getDisagreeConnect$lambda1(function0);
            }
        });
    }

    /* renamed from: getDisagreeConnect$lambda-1 */
    public static final void m150getDisagreeConnect$lambda1(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$cancelAction");
        function0.invoke();
    }
}
