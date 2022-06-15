package com.platform101xp.sdk.internal.configs;

import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigDownloader;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: Platform101XPConfigManager.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/platform101xp/sdk/internal/configs/Platform101XPConfigManager$downloadConfig$1", "Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigDownloader$DownloadResultListener;", "onConfigDownloadResult", "", "jsonConfig", "Lorg/json/JSONObject;", "error", "Lcom/platform101xp/sdk/Platform101XPError;", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPConfigManager$downloadConfig$1 implements Platform101XPConfigDownloader.DownloadResultListener {
    final /* synthetic */ Platform101XPConfigManager this$0;

    Platform101XPConfigManager$downloadConfig$1(Platform101XPConfigManager platform101XPConfigManager) {
        this.this$0 = platform101XPConfigManager;
    }

    @Override // com.platform101xp.sdk.internal.configs.Platform101XPConfigDownloader.DownloadResultListener
    public void onConfigDownloadResult(JSONObject jSONObject, Platform101XPError platform101XPError) {
        if (jSONObject != null) {
            this.this$0.getData().updateConfig(jSONObject);
            this.this$0.getListener().netConfigResult(null);
        } else if (platform101XPError == null) {
        } else {
            this.this$0.getListener().netConfigResult(platform101XPError);
        }
    }
}
