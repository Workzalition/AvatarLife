package com.platform101xp.sdk.api.model;

import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyAuctionFlags;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPModelInviteFB extends Platform101XPModelInvite {
    @Override // com.platform101xp.sdk.api.model.Platform101XPModelInvite
    public void parse(JSONObject jSONObject) throws JSONException {
        this.lastName = jSONObject.getString("name");
        this.firstName = "";
        this.picture = jSONObject.getJSONObject("picture").getJSONObject("data").getString(TJAdUnitConstants.String.URL);
        this.uId = jSONObject.getString(TapjoyAuctionFlags.AUCTION_ID);
    }

    public String toString() {
        return "last_name = " + this.lastName + "; first_name = " + this.firstName + "; uId = " + this.uId + "; ";
    }
}
