package com.platform101xp.sdk;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import com.platform101xp.sdk.internal.AuthorizationWebClient;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class AuthorizationActivity extends Activity {
    public static final String EXTRA_CLIENT_ID = "platform101xp_client_id";
    public static final String EXTRA_DEVICE_TOKEN_ENABLED = "platform101xp_device_toke_enabled";
    public static final String EXTRA_TOKEN = "platform101xp_token";

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_authorization);
        hideActionBar();
        loadPage();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }

    public void loadPage() {
        try {
            WebView webView = (WebView) findViewById(R.id.webview);
            webView.setHorizontalScrollBarEnabled(true);
            webView.setVerticalScrollBarEnabled(true);
            webView.setWebViewClient(new AuthorizationWebClient(this));
            webView.getSettings().setJavaScriptEnabled(true);
            StringBuilder sb = new StringBuilder();
            sb.append(AuthorizationWebClient.AUTHORIZATION_URL);
            sb.append("?device_id=");
            sb.append(Platform101XP.getDeviceId());
            sb.append("&client_id=");
            sb.append(getIntent().getStringExtra(EXTRA_CLIENT_ID));
            sb.append(getIntent().getBooleanExtra(EXTRA_DEVICE_TOKEN_ENABLED, false) ? "&grant_type=mobile_password" : "");
            String sb2 = sb.toString();
            Log.d("101XP SDK", "Authorize 101XP url: " + sb2);
            webView.loadUrl(sb2);
        } catch (Exception unused) {
            setResult(0);
            finish();
        }
    }

    private void hideActionBar() {
        try {
            if (Build.VERSION.SDK_INT < 11 || getActionBar() == null) {
                return;
            }
            getActionBar().hide();
        } catch (Exception unused) {
        }
    }
}
