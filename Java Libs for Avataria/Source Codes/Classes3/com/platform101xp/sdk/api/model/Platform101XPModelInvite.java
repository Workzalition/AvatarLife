package com.platform101xp.sdk.api.model;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public abstract class Platform101XPModelInvite {
    public String firstName;
    public boolean invited = false;
    public String lastName;
    public String picture;
    public String uId;

    abstract void parse(JSONObject jSONObject) throws JSONException;
}
