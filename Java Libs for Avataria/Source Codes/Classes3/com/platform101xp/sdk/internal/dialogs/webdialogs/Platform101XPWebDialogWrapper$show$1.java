package com.platform101xp.sdk.internal.dialogs.webdialogs;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Platform101XPWebDialogWrapper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
final class Platform101XPWebDialogWrapper$show$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Platform101XPWebDialogWrapper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Platform101XPWebDialogWrapper$show$1(Platform101XPWebDialogWrapper platform101XPWebDialogWrapper) {
        super(0);
        this.this$0 = platform101XPWebDialogWrapper;
    }

    public final Unit invoke() {
        return (Unit) this.this$0.getCancelAction().invoke();
    }
}
