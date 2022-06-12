package com.platform101xp.sdk.api.model;

import android.util.Log;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPModelAccount implements Platform101XPModel {
    private static final String PROPERTY_KEY_BEELINE = "beeline_network";
    public long balance;
    public String displayName;
    public String email;
    public long id;
    public String photoUrl;
    public Map<String, Object> properties;

    @Override // com.platform101xp.sdk.api.model.Platform101XPModel
    public void parse(JSONObject jSONObject) throws JSONException {
        if (this.properties == null) {
            this.properties = new HashMap();
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("account");
        this.id = jSONObject2.getLong(TapjoyAuctionFlags.AUCTION_ID);
        this.balance = jSONObject2.optLong("balance", 0L);
        this.displayName = jSONObject2.getString("display_name");
        this.photoUrl = jSONObject2.getString("photo");
        this.email = jSONObject2.optString("email", null);
        Map<String, Object> map = this.properties;
        boolean z = false;
        if (jSONObject2.optInt(PROPERTY_KEY_BEELINE, 0) == 1) {
            z = true;
        }
        map.put(PROPERTY_KEY_BEELINE, Boolean.valueOf(z));
        Log.d("Platform101XP Account", toString());
    }

    public String toString() {
        return "id = " + this.id + "; balance = " + this.balance + "; displayName = " + this.displayName + "; email = " + this.email + "; photoUrl = " + this.photoUrl + "; properties = " + this.properties;
    }
}
