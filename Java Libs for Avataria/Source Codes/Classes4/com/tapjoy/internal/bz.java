package com.tapjoy.internal;

import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.client.utils.URLEncodedUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class bz implements by {
    private final String a;
    private final URL b;

    public bz(String str, URL url) {
        this.a = str;
        this.b = url;
    }

    @Override // com.tapjoy.internal.by
    public final <Result> Result a(bv<Result> bvVar) {
        URL url = new URL(this.b, bvVar.c());
        String b = bvVar.b();
        if ("GET".equals(b) || "DELETE".equals(b)) {
            Map e = bvVar.e();
            if (!e.isEmpty()) {
                url = new URL(url, url.getPath() + "?" + fl.a(e));
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) fk.a(url);
        httpURLConnection.setRequestMethod(b);
        httpURLConnection.setRequestProperty("User-Agent", this.a);
        for (Map.Entry entry : bvVar.a().entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), entry.getValue().toString());
        }
        if (!"GET".equals(b) && !"DELETE".equals(b)) {
            if (HttpPost.METHOD_NAME.equals(b) || "PUT".equals(b)) {
                String d = bvVar.d();
                if (d == null) {
                    fl.a(httpURLConnection, URLEncodedUtils.CONTENT_TYPE, fl.a(bvVar.e()), jo.c);
                } else if ("application/json".equals(d)) {
                    fl.a(httpURLConnection, "application/json; charset=utf-8", bc.a((Object) bvVar.e()), jo.c);
                } else {
                    throw new IllegalArgumentException("Unknown content type: ".concat(String.valueOf(d)));
                }
            } else {
                throw new IllegalArgumentException("Unknown method: ".concat(String.valueOf(b)));
            }
        }
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != 200 && responseCode != 201 && responseCode != 409) {
            throw new IOException("Unexpected status code: " + httpURLConnection.getResponseCode());
        }
        InputStream inputStream = httpURLConnection.getInputStream();
        URI uri = null;
        try {
            try {
                uri = httpURLConnection.getURL().toURI();
            } catch (URISyntaxException unused) {
            }
            return (Result) bvVar.a(uri, inputStream);
        } finally {
            inputStream.close();
        }
    }
}
