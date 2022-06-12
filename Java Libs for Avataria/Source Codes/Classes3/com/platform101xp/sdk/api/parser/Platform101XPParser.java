package com.platform101xp.sdk.api.parser;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.platform101xp.sdk.api.model.Platform101XPModel;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPParser {
    private final Class<? extends Platform101XPModel> modelClass;

    public Platform101XPParser(Class<? extends Platform101XPModel> cls) {
        this.modelClass = cls;
    }

    public Platform101XPModel createModel(JSONObject jSONObject) throws Exception {
        Platform101XPModel newInstance = this.modelClass.newInstance();
        newInstance.parse(jSONObject);
        return newInstance;
    }

    public boolean isError(JSONObject jSONObject) throws JSONException {
        return jSONObject != null && jSONObject.has(IronSourceConstants.EVENTS_STATUS) && jSONObject.getString(IronSourceConstants.EVENTS_STATUS).equals("error");
    }

    public Class<? extends Platform101XPModel> getModelClass() {
        return this.modelClass;
    }
}
