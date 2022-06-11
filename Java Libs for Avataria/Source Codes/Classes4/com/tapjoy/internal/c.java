package com.tapjoy.internal;

import android.app.Dialog;
import android.content.Context;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class c extends Dialog {
    private boolean a = false;

    public c(Context context) {
        super(context, 16973835);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawableResource(17170445);
    }

    @Override // android.app.Dialog
    public final void show() {
        this.a = false;
        super.show();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        this.a = true;
        super.cancel();
    }

    public final void a() {
        getWindow().setLayout(-1, -1);
    }
}
