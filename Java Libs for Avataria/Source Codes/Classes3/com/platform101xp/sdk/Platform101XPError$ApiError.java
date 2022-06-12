package com.platform101xp.sdk;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPError$ApiError {
    public int code;
    public String message;
    final /* synthetic */ Platform101XPError this$0;

    public Platform101XPError$ApiError(Platform101XPError platform101XPError, int i, String str) {
        this.this$0 = platform101XPError;
        this.code = i;
        this.message = str;
    }

    public String toString() {
        return this.code + ": " + this.message;
    }
}
