package com.platform101xp.sdk.internal.dialogs.nativedialogs;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.platform101xp.sdk.R;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogCreator;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogType;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs;
import com.platform101xp.sdk.internal.dialogs.Platform101XPLogsActionsListener;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPLogsDialog.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u00020\u0003@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPLogsDialog;", "", "dialogCreator", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;", "(Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;)V", "acceptButton", "Landroid/widget/Button;", "cancelButton", "getDialogCreator", "()Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;", "setDialogCreator", "logsDialog", "Landroid/app/Dialog;", "logsDialogView", "Landroid/view/View;", "createLogsDialog", "logsActionsListener", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPLogsActionsListener;", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPLogsDialog {
    private Button acceptButton;
    private Button cancelButton;
    private Platform101XPDialogCreator dialogCreator;
    private Dialog logsDialog;
    private final View logsDialogView;

    @Inject
    public Platform101XPLogsDialog(Platform101XPDialogCreator platform101XPDialogCreator) {
        Intrinsics.checkNotNullParameter(platform101XPDialogCreator, "dialogCreator");
        this.dialogCreator = platform101XPDialogCreator;
        LayoutInflater layoutInflater = platform101XPDialogCreator.getLayoutInflater();
        this.logsDialogView = layoutInflater != null ? layoutInflater.inflate(R.layout.dialog_logs, (ViewGroup) null) : null;
        Activity currentActivity = this.dialogCreator.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPLogsDialog$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                Platform101XPLogsDialog.m110_init_$lambda0(Platform101XPLogsDialog.this);
            }
        });
    }

    public final Platform101XPDialogCreator getDialogCreator() {
        return this.dialogCreator;
    }

    @Inject
    public final void setDialogCreator(Platform101XPDialogCreator platform101XPDialogCreator) {
        Intrinsics.checkNotNullParameter(platform101XPDialogCreator, "<set-?>");
        this.dialogCreator = platform101XPDialogCreator;
    }

    /* renamed from: _init_$lambda-0 */
    public static final void m110_init_$lambda0(Platform101XPLogsDialog platform101XPLogsDialog) {
        Intrinsics.checkNotNullParameter(platform101XPLogsDialog, "this$0");
        View view = platform101XPLogsDialog.logsDialogView;
        Button button = null;
        platform101XPLogsDialog.acceptButton = view == null ? null : (Button) view.findViewById(R.id.accept_logs_btn);
        View view2 = platform101XPLogsDialog.logsDialogView;
        if (view2 != null) {
            button = (Button) view2.findViewById(R.id.cancel_logs__btn);
        }
        platform101XPLogsDialog.cancelButton = button;
        platform101XPLogsDialog.logsDialog = platform101XPLogsDialog.dialogCreator.createDialog(platform101XPLogsDialog.logsDialogView, true, Platform101XPDialogType.DIALOG_LOGS);
    }

    public final Dialog createLogsDialog(final Platform101XPLogsActionsListener platform101XPLogsActionsListener) {
        Intrinsics.checkNotNullParameter(platform101XPLogsActionsListener, "logsActionsListener");
        Button button = this.acceptButton;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPLogsDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Platform101XPLogsDialog.m111createLogsDialog$lambda1(Platform101XPLogsDialog.this, platform101XPLogsActionsListener, view);
                }
            });
        }
        Button button2 = this.cancelButton;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPLogsDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Platform101XPLogsDialog.m112createLogsDialog$lambda2(Platform101XPLogsDialog.this, platform101XPLogsActionsListener, view);
                }
            });
        }
        Platform101XPDialogs.OnUserCancelAction onUserCancelAction = new Platform101XPDialogs.OnUserCancelAction() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPLogsDialog$createLogsDialog$cancelAction$1
            @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs.OnUserCancelAction
            public void onCancelClick() {
                Platform101XPLogsActionsListener.this.onCancelClick();
            }
        };
        Platform101XPDialogCreator platform101XPDialogCreator = this.dialogCreator;
        Dialog dialog = this.logsDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logsDialog");
            dialog = null;
        }
        platform101XPDialogCreator.setOnBackKeyListener(dialog, onUserCancelAction);
        Dialog dialog2 = this.logsDialog;
        if (dialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logsDialog");
            return null;
        }
        return dialog2;
    }

    /* renamed from: createLogsDialog$lambda-1 */
    public static final void m111createLogsDialog$lambda1(Platform101XPLogsDialog platform101XPLogsDialog, Platform101XPLogsActionsListener platform101XPLogsActionsListener, View view) {
        Intrinsics.checkNotNullParameter(platform101XPLogsDialog, "this$0");
        Intrinsics.checkNotNullParameter(platform101XPLogsActionsListener, "$logsActionsListener");
        Dialog dialog = platform101XPLogsDialog.logsDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logsDialog");
            dialog = null;
        }
        dialog.cancel();
        platform101XPLogsActionsListener.onAcceptClick();
    }

    /* renamed from: createLogsDialog$lambda-2 */
    public static final void m112createLogsDialog$lambda2(Platform101XPLogsDialog platform101XPLogsDialog, Platform101XPLogsActionsListener platform101XPLogsActionsListener, View view) {
        Intrinsics.checkNotNullParameter(platform101XPLogsDialog, "this$0");
        Intrinsics.checkNotNullParameter(platform101XPLogsActionsListener, "$logsActionsListener");
        Dialog dialog = platform101XPLogsDialog.logsDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logsDialog");
            dialog = null;
        }
        dialog.cancel();
        platform101XPLogsActionsListener.onCancelClick();
    }
}
