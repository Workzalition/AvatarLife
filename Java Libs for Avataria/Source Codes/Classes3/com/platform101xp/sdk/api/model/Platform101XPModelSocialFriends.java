package com.platform101xp.sdk.api.model;

import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsFirebase;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPModelSocialFriends implements Platform101XPModel {
    public Map<String, FriendInfo> friendInfoMap = new HashMap();

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public class FriendInfo {
        public int level;
        public long mobileId;

        public FriendInfo(int i, long j) {
            Platform101XPModelSocialFriends.this = r1;
            this.level = i;
            this.mobileId = j;
        }
    }

    @Override // com.platform101xp.sdk.api.model.Platform101XPModel
    public void parse(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("data");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            this.friendInfoMap.put(jSONObject2.getString(TapjoyAuctionFlags.AUCTION_ID), new FriendInfo(jSONObject2.getInt(FirebaseAnalytics.Param.LEVEL), jSONObject2.getLong(Platform101XPAnalyticsFirebase.PROPERTY_MOBILE_ID)));
        }
        Log.d("101XP SDK", "Platform101XPModelSocialFriends Map:" + this.friendInfoMap);
    }
}
