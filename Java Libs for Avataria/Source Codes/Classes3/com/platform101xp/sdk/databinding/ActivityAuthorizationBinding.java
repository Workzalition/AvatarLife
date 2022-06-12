package com.platform101xp.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.platform101xp.sdk.R;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class ActivityAuthorizationBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final WebView webview;

    private ActivityAuthorizationBinding(RelativeLayout relativeLayout, WebView webView) {
        this.rootView = relativeLayout;
        this.webview = webView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAuthorizationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityAuthorizationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_authorization, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityAuthorizationBinding bind(View view) {
        int i = R.id.webview;
        WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
        if (webView != null) {
            return new ActivityAuthorizationBinding((RelativeLayout) view, webView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
