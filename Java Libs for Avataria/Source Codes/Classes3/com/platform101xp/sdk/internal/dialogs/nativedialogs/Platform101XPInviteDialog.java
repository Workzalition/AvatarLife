package com.platform101xp.sdk.internal.dialogs.nativedialogs;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import com.platform101xp.sdk.Platform101XPSNType;
import com.platform101xp.sdk.R;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogCreator;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogType;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSNManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPInviteDialog.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u00020\u0003@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPInviteDialog;", "", "dialogCreator", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;", "(Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;)V", "closeButton", "Landroid/widget/ImageButton;", "getDialogCreator", "()Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;", "setDialogCreator", "fbButton", "inviteDialog", "Landroid/app/Dialog;", "inviteDialogView", "Landroid/view/View;", "vkButton", "createInviteDialog", "snManager", "Lcom/platform101xp/sdk/internal/socialnetworks/Platform101XPSNManager;", "cancelAction", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogs$OnUserCancelAction;", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPInviteDialog {
    private ImageButton closeButton;
    private Platform101XPDialogCreator dialogCreator;
    private ImageButton fbButton;
    private Dialog inviteDialog;
    private View inviteDialogView;
    private ImageButton vkButton;

    @Inject
    public Platform101XPInviteDialog(Platform101XPDialogCreator platform101XPDialogCreator) {
        Intrinsics.checkNotNullParameter(platform101XPDialogCreator, "dialogCreator");
        this.dialogCreator = platform101XPDialogCreator;
        LayoutInflater layoutInflater = platform101XPDialogCreator.getLayoutInflater();
        this.inviteDialogView = layoutInflater != null ? layoutInflater.inflate(R.layout.dialog_invite, (ViewGroup) null) : null;
        Activity currentActivity = this.dialogCreator.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPInviteDialog$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                Platform101XPInviteDialog.m105_init_$lambda3(Platform101XPInviteDialog.this);
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

    /* renamed from: _init_$lambda-3 */
    public static final void m105_init_$lambda3(Platform101XPInviteDialog platform101XPInviteDialog) {
        Intrinsics.checkNotNullParameter(platform101XPInviteDialog, "this$0");
        View view = platform101XPInviteDialog.inviteDialogView;
        ImageButton imageButton = null;
        platform101XPInviteDialog.vkButton = view == null ? null : (ImageButton) view.findViewById(R.id.invite_vk_button);
        View view2 = platform101XPInviteDialog.inviteDialogView;
        platform101XPInviteDialog.fbButton = view2 == null ? null : (ImageButton) view2.findViewById(R.id.invite_facebook_button);
        View view3 = platform101XPInviteDialog.inviteDialogView;
        if (view3 != null) {
            imageButton = (ImageButton) view3.findViewById(R.id.invite_close_button);
        }
        platform101XPInviteDialog.closeButton = imageButton;
        platform101XPInviteDialog.inviteDialog = platform101XPInviteDialog.dialogCreator.createDialog(platform101XPInviteDialog.inviteDialogView, true, Platform101XPDialogType.DIALOG_INVITE);
    }

    public final Dialog createInviteDialog(final Platform101XPSNManager platform101XPSNManager, final Platform101XPDialogs.OnUserCancelAction onUserCancelAction) {
        Intrinsics.checkNotNullParameter(platform101XPSNManager, "snManager");
        Intrinsics.checkNotNullParameter(onUserCancelAction, "cancelAction");
        Dialog dialog = this.inviteDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteDialog");
            dialog = null;
        }
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
        }
        Platform101XPDialogCreator platform101XPDialogCreator = this.dialogCreator;
        Dialog dialog2 = this.inviteDialog;
        if (dialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteDialog");
            dialog2 = null;
        }
        platform101XPDialogCreator.setOnBackKeyListener(dialog2, onUserCancelAction);
        ImageButton imageButton = this.closeButton;
        if (imageButton != null) {
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPInviteDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Platform101XPInviteDialog.m106createInviteDialog$lambda4(Platform101XPInviteDialog.this, onUserCancelAction, view);
                }
            });
        }
        ImageButton imageButton2 = this.vkButton;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPInviteDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Platform101XPInviteDialog.m107createInviteDialog$lambda5(Platform101XPSNManager.this, view);
                }
            });
        }
        ImageButton imageButton3 = this.fbButton;
        if (imageButton3 != null) {
            imageButton3.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPInviteDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Platform101XPInviteDialog.m108createInviteDialog$lambda6(Platform101XPSNManager.this, view);
                }
            });
        }
        Dialog dialog3 = this.inviteDialog;
        if (dialog3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteDialog");
            return null;
        }
        return dialog3;
    }

    /* renamed from: createInviteDialog$lambda-4 */
    public static final void m106createInviteDialog$lambda4(Platform101XPInviteDialog platform101XPInviteDialog, Platform101XPDialogs.OnUserCancelAction onUserCancelAction, View view) {
        Intrinsics.checkNotNullParameter(platform101XPInviteDialog, "this$0");
        Intrinsics.checkNotNullParameter(onUserCancelAction, "$cancelAction");
        Dialog dialog = platform101XPInviteDialog.inviteDialog;
        Dialog dialog2 = null;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteDialog");
            dialog = null;
        }
        if (dialog.isShowing()) {
            Dialog dialog3 = platform101XPInviteDialog.inviteDialog;
            if (dialog3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteDialog");
            } else {
                dialog2 = dialog3;
            }
            dialog2.dismiss();
            onUserCancelAction.onCancelClick();
        }
    }

    /* renamed from: createInviteDialog$lambda-5 */
    public static final void m107createInviteDialog$lambda5(Platform101XPSNManager platform101XPSNManager, View view) {
        Intrinsics.checkNotNullParameter(platform101XPSNManager, "$snManager");
        platform101XPSNManager.getSocialFunction(Platform101XPSNType.VK).sendApplicationInvite();
    }

    /* renamed from: createInviteDialog$lambda-6 */
    public static final void m108createInviteDialog$lambda6(Platform101XPSNManager platform101XPSNManager, View view) {
        Intrinsics.checkNotNullParameter(platform101XPSNManager, "$snManager");
        platform101XPSNManager.getSocialFunction(Platform101XPSNType.FACEBOOK).sendApplicationInvite();
    }
}
