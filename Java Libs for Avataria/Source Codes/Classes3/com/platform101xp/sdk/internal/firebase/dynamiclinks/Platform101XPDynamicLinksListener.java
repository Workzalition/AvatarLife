package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import android.net.Uri;
import com.platform101xp.sdk.Platform101XPError;
import kotlin.Metadata;

/* compiled from: Platform101XPDynamicLinksListener.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/dynamiclinks/Platform101XPDynamicLinksListener;", "", "onLinkReceiveResult", "", "dynamicLink", "Landroid/net/Uri;", "error", "Lcom/platform101xp/sdk/Platform101XPError;", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public interface Platform101XPDynamicLinksListener {
    void onLinkReceiveResult(Uri uri, Platform101XPError platform101XPError);
}
