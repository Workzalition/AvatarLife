package com.platform101xp.sdk.internal.dialogs.webdialogs;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Platform101XPWebFragmentActivity.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014¨\u0006\u000e"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebFragmentActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPWebFragmentActivity extends FragmentActivity {
    public static final Companion Companion = new Companion(null);
    public static final String DIALOG_TAG = "com.platform101xp.sdk.internal.dialogs.web_dialogs.web_dialog";
    public static final String EXTRA_SCREEN_ROTATION_DISABLED = "com.platform101xp.sdk.extra_screen_rotation_disabled";
    private static DialogFragment currentDialog;

    /* compiled from: Platform101XPWebFragmentActivity.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebFragmentActivity$Companion;", "", "()V", "DIALOG_TAG", "", "EXTRA_SCREEN_ROTATION_DISABLED", "currentDialog", "Landroidx/fragment/app/DialogFragment;", "getCurrentDialog", "()Landroidx/fragment/app/DialogFragment;", "setCurrentDialog", "(Landroidx/fragment/app/DialogFragment;)V", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DialogFragment getCurrentDialog() {
            return Platform101XPWebFragmentActivity.currentDialog;
        }

        public final void setCurrentDialog(DialogFragment dialogFragment) {
            Platform101XPWebFragmentActivity.currentDialog = dialogFragment;
        }
    }

    protected void onCreate(Bundle bundle) {
        Platform101XPWebFragmentActivity.super.onCreate(bundle);
        if (getIntent().getBooleanExtra(EXTRA_SCREEN_ROTATION_DISABLED, false)) {
            setRequestedOrientation(0);
        }
        DialogFragment dialogFragment = currentDialog;
        if (dialogFragment != null && !dialogFragment.isVisible()) {
            dialogFragment.show(getSupportFragmentManager(), DIALOG_TAG);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        Platform101XPWebFragmentActivity.super.onActivityResult(i, i2, intent);
        DialogFragment dialogFragment = currentDialog;
        if (dialogFragment == null) {
            return;
        }
        dialogFragment.onActivityResult(i, i2, intent);
    }
}
