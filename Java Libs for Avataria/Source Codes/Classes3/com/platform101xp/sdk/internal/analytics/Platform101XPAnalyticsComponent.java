package com.platform101xp.sdk.internal.analytics;

import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public interface Platform101XPAnalyticsComponent {
    void initialize();

    void setWidgetVersion(String str);

    void track(String str, Map map);
}
