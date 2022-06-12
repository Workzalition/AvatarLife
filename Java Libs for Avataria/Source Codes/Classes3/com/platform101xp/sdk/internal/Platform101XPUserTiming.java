package com.platform101xp.sdk.internal;

import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPUserTiming {
    private static final String KEY_SESSIONS = "user_sessions";
    private static final String KEY_USER_TIME = "user_time";
    private static final String LOG_TAG = "101XP UserTiming";
    private static ArrayList<TimeSession> sessionsList;
    private static long startTime;
    private static long userTime;
    boolean started;

    public Platform101XPUserTiming(long j) {
        userTime = j;
        this.started = false;
        if (sessionsList == null) {
            sessionsList = new ArrayList<>();
        }
    }

    public Platform101XPUserTiming(boolean z) {
        this(0L);
        if (z) {
            Load();
        }
    }

    public void Start() {
        if (!this.started) {
            this.started = true;
            startTime = System.currentTimeMillis();
        }
    }

    public void Stop() {
        if (this.started) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = userTime;
            long j2 = startTime;
            userTime = j + (currentTimeMillis - j2);
            this.started = false;
            if (j2 != currentTimeMillis) {
                sessionsList.add(new TimeSession(j2, currentTimeMillis));
            }
            Save();
        }
    }

    public void Save() {
        Platform101XPSettings.saveLong(KEY_USER_TIME, userTime);
        Platform101XPSettings.saveString(KEY_SESSIONS, serializeSessions(sessionsList));
    }

    public void Load() {
        userTime = Platform101XPSettings.loadLong(KEY_USER_TIME, 0L);
        sessionsList = deserializeSessions(Platform101XPSettings.loadString(KEY_SESSIONS));
    }

    public long GetTime() {
        if (this.started) {
            Stop();
            Start();
        }
        return userTime;
    }

    public long CalculateSessionSum(long j) {
        Iterator<TimeSession> it = sessionsList.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            TimeSession next = it.next();
            if (next.startTime > j) {
                j2 += next.Calculate();
            }
        }
        return j2;
    }

    public void ClearSession(long j) {
        Iterator<TimeSession> it = sessionsList.iterator();
        while (it.hasNext()) {
            if (it.next().stopTime < j) {
                it.remove();
            }
        }
    }

    public static String serializeSessions(ArrayList<TimeSession> arrayList) {
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < arrayList.size(); i++) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TJAdUnitConstants.String.VIDEO_START, arrayList.get(i).startTime);
                jSONObject2.put("stop", arrayList.get(i).stopTime);
                jSONObject.put(String.valueOf(i), jSONObject2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public ArrayList<TimeSession> deserializeSessions(String str) {
        ArrayList<TimeSession> arrayList = new ArrayList<>();
        if (str == null) {
            return arrayList;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (int i = 0; i < jSONObject.length(); i++) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(String.valueOf(i));
                if (jSONObject2 != null) {
                    arrayList.add(new TimeSession(jSONObject2.getLong(TJAdUnitConstants.String.VIDEO_START), jSONObject2.getLong("stop")));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public class TimeSession {
        private long startTime;
        private long stopTime;

        public TimeSession() {
            Platform101XPUserTiming.this = r7;
            new TimeSession(0L, 0L);
        }

        public TimeSession(long j, long j2) {
            Platform101XPUserTiming.this = r1;
            this.startTime = j;
            this.stopTime = j2;
        }

        public long Calculate() {
            return this.stopTime - this.startTime;
        }

        public String toString() {
            return "Session [startTime=" + this.startTime + ", stopTime=" + this.stopTime + "]";
        }
    }
}
