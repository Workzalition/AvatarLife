package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJConnectListener;
import java.util.Hashtable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class eu extends et {
    private final gd c = new gd() { // from class: com.tapjoy.internal.eu.1
        @Override // com.tapjoy.internal.gd
        public final boolean a(Context context, String str, Hashtable<String, ?> hashtable, TJConnectListener tJConnectListener) {
            return eu.super.a(context, str, hashtable, tJConnectListener);
        }
    };

    @Override // com.tapjoy.internal.et, com.tapjoy.internal.es
    public final boolean a(Context context, String str, Hashtable<String, ?> hashtable, TJConnectListener tJConnectListener) {
        return this.c.b(context, str, hashtable, tJConnectListener);
    }
}
