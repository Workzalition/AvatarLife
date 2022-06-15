package com.platform101xp.sdk.internal.services;

import com.platform101xp.sdk.Platform101XPMessage;
import com.platform101xp.sdk.internal.Platform101XPMessageHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPMessagingService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lcom/platform101xp/sdk/internal/services/Platform101XPMessagingService;", "", "()V", "getMessage", "", "messageBody", "", "messageSentTime", "", "messageId", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPMessagingService {
    public final void getMessage(String str, long j, String str2) {
        Intrinsics.checkNotNullParameter(str, "messageBody");
        Intrinsics.checkNotNullParameter(str2, "messageId");
        Platform101XPMessageHandler.getInstance().messageReceived(new Platform101XPMessage(str2, j, str));
    }
}
