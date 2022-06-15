package com.platform101xp.sdk.internal.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.R;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPDialogCreator.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J \u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"J\u0016\u0010#\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"R\u001c\u0010\u0002\u001a\u00020\u0003@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005@\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;", "", "currentActivity", "Landroid/app/Activity;", "dialogs", "", "Landroid/app/Dialog;", "(Landroid/app/Activity;[Landroid/app/Dialog;)V", "getCurrentActivity", "()Landroid/app/Activity;", "setCurrentActivity", "(Landroid/app/Activity;)V", "getDialogs", "()[Landroid/app/Dialog;", "setDialogs", "([Landroid/app/Dialog;)V", "[Landroid/app/Dialog;", "layoutInflater", "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "setLayoutInflater", "(Landroid/view/LayoutInflater;)V", "createDialog", "dialogView", "Landroid/view/View;", "cancelable", "", "dialogType", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogType;", "setOnBackKeyListener", "", "dialog", "cancelAction", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogs$OnUserCancelAction;", "switchOff", "Landroid/view/View$OnClickListener;", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPDialogCreator {
    private Activity currentActivity;
    private Dialog[] dialogs;
    private LayoutInflater layoutInflater;

    @Inject
    public Platform101XPDialogCreator(Activity activity, Dialog[] dialogArr) {
        Intrinsics.checkNotNullParameter(activity, "currentActivity");
        Intrinsics.checkNotNullParameter(dialogArr, "dialogs");
        this.currentActivity = activity;
        this.dialogs = dialogArr;
        this.layoutInflater = LayoutInflater.from(activity);
    }

    public final Activity getCurrentActivity() {
        return this.currentActivity;
    }

    public final Dialog[] getDialogs() {
        return this.dialogs;
    }

    @Inject
    public final void setCurrentActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<set-?>");
        this.currentActivity = activity;
    }

    @Inject
    public final void setDialogs(Dialog[] dialogArr) {
        Intrinsics.checkNotNullParameter(dialogArr, "<set-?>");
        this.dialogs = dialogArr;
    }

    public final LayoutInflater getLayoutInflater() {
        return this.layoutInflater;
    }

    public final void setLayoutInflater(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public final Dialog createDialog(View view, boolean z, Platform101XPDialogType platform101XPDialogType) {
        Intrinsics.checkNotNullParameter(platform101XPDialogType, "dialogType");
        Dialog dialog = new Dialog(this.currentActivity);
        dialog.requestWindowFeature(1);
        if (view != null) {
            if (view.getParent() != null) {
                ViewParent parent = view.getParent();
                Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(view);
            }
            dialog.setContentView(view);
        }
        dialog.setCancelable(z);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
        if (attributes != null) {
            attributes.windowAnimations = R.style.DialogStyle;
        }
        dialog.setCanceledOnTouchOutside(false);
        this.dialogs[platform101XPDialogType.ordinal()] = dialog;
        return dialog;
    }

    public final View.OnClickListener switchOff(final Platform101XPDialogType platform101XPDialogType, final Platform101XPDialogs.OnUserCancelAction onUserCancelAction) {
        Intrinsics.checkNotNullParameter(platform101XPDialogType, "dialogType");
        Intrinsics.checkNotNullParameter(onUserCancelAction, "cancelAction");
        return new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.Platform101XPDialogCreator$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Platform101XPDialogCreator.m88switchOff$lambda2(Platform101XPDialogCreator.this, platform101XPDialogType, onUserCancelAction, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: switchOff$lambda-2  reason: not valid java name */
    public static final void m88switchOff$lambda2(Platform101XPDialogCreator platform101XPDialogCreator, Platform101XPDialogType platform101XPDialogType, Platform101XPDialogs.OnUserCancelAction onUserCancelAction, View view) {
        Intrinsics.checkNotNullParameter(platform101XPDialogCreator, "this$0");
        Intrinsics.checkNotNullParameter(platform101XPDialogType, "$dialogType");
        Intrinsics.checkNotNullParameter(onUserCancelAction, "$cancelAction");
        platform101XPDialogCreator.dialogs[platform101XPDialogType.ordinal()].cancel();
        if (platform101XPDialogType == Platform101XPDialogType.DIALOG_AUTHORIZE && Platform101XP.isGuest() && Platform101XP.isLoggedIn()) {
            Dialog[] dialogArr = platform101XPDialogCreator.dialogs;
            int i = 0;
            int length = dialogArr.length;
            while (i < length) {
                Dialog dialog = dialogArr[i];
                i++;
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
            Platform101XP.showProfile();
            return;
        }
        onUserCancelAction.onCancelClick();
    }

    public final void setOnBackKeyListener(Dialog dialog, final Platform101XPDialogs.OnUserCancelAction onUserCancelAction) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(onUserCancelAction, "cancelAction");
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.platform101xp.sdk.internal.dialogs.Platform101XPDialogCreator$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean m87setOnBackKeyListener$lambda3;
                m87setOnBackKeyListener$lambda3 = Platform101XPDialogCreator.m87setOnBackKeyListener$lambda3(Platform101XPDialogs.OnUserCancelAction.this, dialogInterface, i, keyEvent);
                return m87setOnBackKeyListener$lambda3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setOnBackKeyListener$lambda-3  reason: not valid java name */
    public static final boolean m87setOnBackKeyListener$lambda3(Platform101XPDialogs.OnUserCancelAction onUserCancelAction, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(onUserCancelAction, "$cancelAction");
        if (i == 4) {
            onUserCancelAction.onCancelClick();
            dialogInterface.cancel();
            return false;
        }
        return false;
    }
}
