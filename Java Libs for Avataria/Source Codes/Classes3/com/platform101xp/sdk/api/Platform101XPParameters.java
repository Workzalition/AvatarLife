package com.platform101xp.sdk.api;

import com.google.gson.annotations.Expose;
import java.util.Enumeration;
import java.util.Hashtable;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPParameters {
    private String arrayParameters;
    @Expose
    private Hashtable<String, String> parameters = new Hashtable<>();

    public Platform101XPParameters() {
    }

    public Platform101XPParameters(String str) {
        String[] split = str.split("&");
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            String[] split2 = str2.split("=");
            addParameter(split2[0], split2[1]);
        }
        if (stringBuffer.length() != 0) {
            this.arrayParameters = stringBuffer.toString();
        }
    }

    public void addParameter(String str, String str2) {
        this.parameters.put(str, str2);
    }

    public void addArrayParameter(String str, String[] strArr) {
        if (str == null || str.isEmpty() || strArr == null || strArr.length == 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : strArr) {
            stringBuffer.append(stringBuffer.length() == 0 ? "" : "&");
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append(str2);
        }
        this.arrayParameters = stringBuffer.toString();
    }

    public String getParameter(String str) {
        return this.parameters.get(str);
    }

    public boolean containsParameter(String str) {
        return this.parameters.containsKey(str);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (!this.parameters.isEmpty()) {
            Enumeration<String> keys = this.parameters.keys();
            while (keys.hasMoreElements()) {
                stringBuffer.append(stringBuffer.length() == 0 ? "" : "&");
                String nextElement = keys.nextElement();
                stringBuffer.append(nextElement);
                stringBuffer.append("=");
                stringBuffer.append(this.parameters.get(nextElement));
            }
        }
        String str = this.arrayParameters;
        if (str != null && !str.isEmpty()) {
            stringBuffer.append("&" + this.arrayParameters);
        }
        return stringBuffer.toString();
    }
}
