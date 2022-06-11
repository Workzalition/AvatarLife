package com.tapjoy.internal;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
class gh$1 extends ThreadLocal<Map<String, gh$a>> {
    gh$1() {
    }

    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ Map<String, gh$a> initialValue() {
        return new HashMap();
    }
}
