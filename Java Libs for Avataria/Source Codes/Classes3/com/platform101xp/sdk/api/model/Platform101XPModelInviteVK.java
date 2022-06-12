package com.platform101xp.sdk.api.model;

import com.tapjoy.TapjoyAuctionFlags;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPModelInviteVK extends Platform101XPModelInvite {
    @Override // com.platform101xp.sdk.api.model.Platform101XPModelInvite
    public void parse(JSONObject jSONObject) throws JSONException {
        this.lastName = jSONObject.getString("last_name");
        this.firstName = jSONObject.getString("first_name");
        this.uId = jSONObject.getString(TapjoyAuctionFlags.AUCTION_ID);
        this.picture = jSONObject.getString("photo_50");
    }

    public String toString() {
        return "last_name = " + this.lastName + "; first_name = " + this.firstName + "; uId = " + this.uId + "; ";
    }
}
