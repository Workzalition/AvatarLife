package com.platform101xp.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.platform101xp.sdk.R;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Toast101xpLayoutBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView toast101xpMessage;
    public final RelativeLayout toastGreetingLayout;
    public final ImageView userGreetingLogo;

    private Toast101xpLayoutBinding(RelativeLayout relativeLayout, TextView textView, RelativeLayout relativeLayout2, ImageView imageView) {
        this.rootView = relativeLayout;
        this.toast101xpMessage = textView;
        this.toastGreetingLayout = relativeLayout2;
        this.userGreetingLogo = imageView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Toast101xpLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static Toast101xpLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.toast_101xp_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static Toast101xpLayoutBinding bind(View view) {
        int i = R.id.toast_101xp_message;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            int i2 = R.id.user_greeting_logo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i2);
            if (imageView != null) {
                return new Toast101xpLayoutBinding(relativeLayout, textView, relativeLayout, imageView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
