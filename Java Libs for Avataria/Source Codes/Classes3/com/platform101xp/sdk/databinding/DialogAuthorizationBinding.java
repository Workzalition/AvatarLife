package com.platform101xp.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.platform101xp.sdk.R;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class DialogAuthorizationBinding implements ViewBinding {
    public final Button authButton101xp;
    public final ImageButton authButtonFb;
    public final Button authButtonFbBig;
    public final ImageButton authButtonGg;
    public final ImageButton authButtonOd;
    public final ImageButton authButtonVk;
    public final LinearLayout authButtonsLayout;
    public final TextView authLabel1;
    public final TextView authText;
    public final Button buttonAsGuest;
    public final Button buttonCancel;
    private final LinearLayout rootView;

    private DialogAuthorizationBinding(LinearLayout linearLayout, Button button, ImageButton imageButton, Button button2, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, LinearLayout linearLayout2, TextView textView, TextView textView2, Button button3, Button button4) {
        this.rootView = linearLayout;
        this.authButton101xp = button;
        this.authButtonFb = imageButton;
        this.authButtonFbBig = button2;
        this.authButtonGg = imageButton2;
        this.authButtonOd = imageButton3;
        this.authButtonVk = imageButton4;
        this.authButtonsLayout = linearLayout2;
        this.authLabel1 = textView;
        this.authText = textView2;
        this.buttonAsGuest = button3;
        this.buttonCancel = button4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogAuthorizationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogAuthorizationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_authorization, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogAuthorizationBinding bind(View view) {
        int i = R.id.auth_button_101xp;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.auth_button_fb;
            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
            if (imageButton != null) {
                i = R.id.auth_button_fb_big;
                Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                if (button2 != null) {
                    i = R.id.auth_button_gg;
                    ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, i);
                    if (imageButton2 != null) {
                        i = R.id.auth_button_od;
                        ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, i);
                        if (imageButton3 != null) {
                            i = R.id.auth_button_vk;
                            ImageButton imageButton4 = (ImageButton) ViewBindings.findChildViewById(view, i);
                            if (imageButton4 != null) {
                                i = R.id.auth_buttons_layout;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R.id.auth_label1;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = R.id.auth_text;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.button_as_guest;
                                            Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                                            if (button3 != null) {
                                                i = R.id.button_cancel;
                                                Button button4 = (Button) ViewBindings.findChildViewById(view, i);
                                                if (button4 != null) {
                                                    return new DialogAuthorizationBinding((LinearLayout) view, button, imageButton, button2, imageButton2, imageButton3, imageButton4, linearLayout, textView, textView2, button3, button4);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
