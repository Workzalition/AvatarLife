package com.tapjoy.internal;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
final class hn$1 implements ay<ew> {
    final /* synthetic */ hn a;

    hn$1(hn hnVar) {
        this.a = hnVar;
    }

    @Override // com.tapjoy.internal.ba
    public final /* bridge */ /* synthetic */ void a(OutputStream outputStream, Object obj) {
        ew ewVar = (ew) obj;
        ek<ew> ekVar = ew.c;
        ej.a(ewVar, "value == null");
        ej.a(outputStream, "stream == null");
        iu a = ix.a(ix.a(outputStream));
        ekVar.a(a, (iu) ewVar);
        a.a();
    }

    @Override // com.tapjoy.internal.az
    public final /* synthetic */ Object b(InputStream inputStream) {
        ek<ew> ekVar = ew.c;
        ej.a(inputStream, "stream == null");
        return ekVar.a(ix.a(ix.a(inputStream)));
    }
}
