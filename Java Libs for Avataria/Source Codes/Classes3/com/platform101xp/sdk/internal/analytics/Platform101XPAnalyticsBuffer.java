package com.platform101xp.sdk.internal.analytics;

import android.util.Pair;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPAnalyticsBuffer {
    private static final String SAVE_EVENTS_KEY = "save_events";
    private ArrayList<Pair<String, Map>> eventList = new ArrayList<>();
    private Gson gson = new Gson();
    private Type type = new TypeToken<ArrayList<Pair<String, Map>>>() { // from class: com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsBuffer.1
    }.getType();

    public ArrayList<Pair<String, Map>> values() {
        this.eventList = (ArrayList) this.gson.fromJson(Platform101XPSettings.loadString(SAVE_EVENTS_KEY), this.type);
        Platform101XPSettings.removeValue(SAVE_EVENTS_KEY);
        return this.eventList;
    }

    public void save(String str, Map map) {
        String loadString = Platform101XPSettings.loadString(SAVE_EVENTS_KEY);
        if (loadString != null) {
            this.eventList = (ArrayList) this.gson.fromJson(loadString, this.type);
        }
        this.eventList.add(new Pair<>(str, map));
        Platform101XPSettings.saveString(SAVE_EVENTS_KEY, this.gson.toJson(this.eventList));
    }
}
