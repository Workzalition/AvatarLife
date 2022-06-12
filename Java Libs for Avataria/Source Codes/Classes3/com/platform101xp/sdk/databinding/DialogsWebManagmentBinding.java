package com.platform101xp.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.platform101xp.sdk.R;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class DialogsWebManagmentBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final ImageButton webCloseButtonLandscape;
    public final ImageButton webCloseButtonPortrait;
    public final WebView webDialogs;

    private DialogsWebManagmentBinding(RelativeLayout relativeLayout, ImageButton imageButton, ImageButton imageButton2, WebView webView) {
        this.rootView = relativeLayout;
        this.webCloseButtonLandscape = imageButton;
        this.webCloseButtonPortrait = imageButton2;
        this.webDialogs = webView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogsWebManagmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogsWebManagmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogs_web_managment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogsWebManagmentBinding bind(View view) {
        int i = R.id.web_close_button_landscape;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = R.id.web_close_button_portrait;
            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, i);
            if (imageButton2 != null) {
                i = R.id.web_dialogs;
                WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
                if (webView != null) {
                    return new DialogsWebManagmentBinding((RelativeLayout) view, imageButton, imageButton2, webView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
