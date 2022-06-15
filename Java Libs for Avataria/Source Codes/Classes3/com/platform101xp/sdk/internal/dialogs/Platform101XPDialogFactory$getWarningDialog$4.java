package com.platform101xp.sdk.internal.dialogs;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Platform101XPDialogFactory.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDialogFactory$getWarningDialog$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Platform101XPWarningActionsListener $warningActionsListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Platform101XPDialogFactory$getWarningDialog$4(Platform101XPWarningActionsListener platform101XPWarningActionsListener) {
        super(0);
        this.$warningActionsListener = platform101XPWarningActionsListener;
    }

    public final void invoke() {
        Platform101XPWarningActionsListener platform101XPWarningActionsListener = this.$warningActionsListener;
        if (platform101XPWarningActionsListener == null) {
            return;
        }
        platform101XPWarningActionsListener.onExitClick();
    }
}
