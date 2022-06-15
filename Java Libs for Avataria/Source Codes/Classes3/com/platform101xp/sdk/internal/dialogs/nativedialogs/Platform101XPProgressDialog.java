package com.platform101xp.sdk.internal.dialogs.nativedialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup;
import com.platform101xp.sdk.R;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogType;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProgressDialog;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPProgressDialog.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\n\u0010\u000b\u001a\u00060\u000fR\u00020\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPProgressDialog;", "", "currentActivity", "Landroid/app/Activity;", "dialogs", "", "Landroid/app/Dialog;", "(Landroid/app/Activity;[Landroid/app/Dialog;)V", "[Landroid/app/Dialog;", "progressDialog", "Landroid/app/AlertDialog;", "getProgressDialog", "()Landroid/app/AlertDialog;", "setProgressDialog", "(Landroid/app/AlertDialog;)V", "Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPProgressDialog$ProgressDialogWrapper;", "ProgressDialogWrapper", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPProgressDialog {
    private final Activity currentActivity;
    private final Dialog[] dialogs;
    private AlertDialog progressDialog;

    @Inject
    public Platform101XPProgressDialog(Activity activity, Dialog[] dialogArr) {
        Intrinsics.checkNotNullParameter(activity, "currentActivity");
        Intrinsics.checkNotNullParameter(dialogArr, "dialogs");
        this.currentActivity = activity;
        this.dialogs = dialogArr;
        activity.runOnUiThread(new Runnable() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProgressDialog$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Platform101XPProgressDialog.m125_init_$lambda1(Platform101XPProgressDialog.this);
            }
        });
    }

    public final AlertDialog getProgressDialog() {
        return this.progressDialog;
    }

    public final void setProgressDialog(AlertDialog alertDialog) {
        this.progressDialog = alertDialog;
    }

    /* renamed from: _init_$lambda-1 */
    public static final void m125_init_$lambda1(Platform101XPProgressDialog platform101XPProgressDialog) {
        Intrinsics.checkNotNullParameter(platform101XPProgressDialog, "this$0");
        AlertDialog create = new AlertDialog.Builder(platform101XPProgressDialog.currentActivity).create();
        platform101XPProgressDialog.progressDialog = create;
        if (create != null) {
            create.setCancelable(false);
        }
        AlertDialog alertDialog = platform101XPProgressDialog.progressDialog;
        if (alertDialog != null) {
            alertDialog.setCanceledOnTouchOutside(false);
        }
        AlertDialog alertDialog2 = platform101XPProgressDialog.progressDialog;
        if (alertDialog2 != null) {
            alertDialog2.setView(platform101XPProgressDialog.currentActivity.getLayoutInflater().inflate(R.layout.progress_view, (ViewGroup) null));
        }
        AlertDialog alertDialog3 = platform101XPProgressDialog.progressDialog;
        if (alertDialog3 == null) {
            return;
        }
        platform101XPProgressDialog.dialogs[Platform101XPDialogType.DIALOG_PROGRESS.ordinal()] = alertDialog3;
    }

    /* renamed from: getProgressDialog */
    public final ProgressDialogWrapper m126getProgressDialog() {
        return new ProgressDialogWrapper(this, this.currentActivity);
    }

    /* compiled from: Platform101XPProgressDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPProgressDialog$ProgressDialogWrapper;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPProgressDialog;Landroid/content/Context;)V", TapjoyConstants.TJC_FULLSCREEN_AD_DISMISS_URL, "", TJAdUnitConstants.String.BEACON_SHOW_PATH, "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public final class ProgressDialogWrapper extends Dialog {
        final /* synthetic */ Platform101XPProgressDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProgressDialogWrapper(Platform101XPProgressDialog platform101XPProgressDialog, Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(platform101XPProgressDialog, "this$0");
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = platform101XPProgressDialog;
        }

        @Override // android.app.Dialog
        public void show() {
            Activity activity = this.this$0.currentActivity;
            final Platform101XPProgressDialog platform101XPProgressDialog = this.this$0;
            activity.runOnUiThread(new Runnable() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProgressDialog$ProgressDialogWrapper$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Platform101XPProgressDialog.ProgressDialogWrapper.m128show$lambda1(Platform101XPProgressDialog.this);
                }
            });
        }

        /* renamed from: show$lambda-1 */
        public static final void m128show$lambda1(Platform101XPProgressDialog platform101XPProgressDialog) {
            Intrinsics.checkNotNullParameter(platform101XPProgressDialog, "this$0");
            AlertDialog progressDialog = platform101XPProgressDialog.getProgressDialog();
            if (progressDialog != null && !progressDialog.isShowing()) {
                progressDialog.show();
            }
        }

        @Override // android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            Activity activity = this.this$0.currentActivity;
            final Platform101XPProgressDialog platform101XPProgressDialog = this.this$0;
            activity.runOnUiThread(new Runnable() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProgressDialog$ProgressDialogWrapper$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Platform101XPProgressDialog.ProgressDialogWrapper.m127dismiss$lambda3(Platform101XPProgressDialog.this);
                }
            });
        }

        /* renamed from: dismiss$lambda-3 */
        public static final void m127dismiss$lambda3(Platform101XPProgressDialog platform101XPProgressDialog) {
            Intrinsics.checkNotNullParameter(platform101XPProgressDialog, "this$0");
            AlertDialog progressDialog = platform101XPProgressDialog.getProgressDialog();
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    }
}
