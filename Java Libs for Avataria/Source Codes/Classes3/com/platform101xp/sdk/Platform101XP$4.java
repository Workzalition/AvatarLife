package com.platform101xp.sdk;

import com.platform101xp.sdk.internal.AnalyticsConversionDataListener;
import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$4 implements AnalyticsConversionDataListener {
    Platform101XP$4() {
    }

    @Override // com.platform101xp.sdk.internal.AnalyticsConversionDataListener
    public void onInstallConversionDataLoaded(Map map, boolean z) {
        Platform101XP.access$700(Platform101XP.access$000()).onGetAnalyticsConversionData(map);
    }
}
