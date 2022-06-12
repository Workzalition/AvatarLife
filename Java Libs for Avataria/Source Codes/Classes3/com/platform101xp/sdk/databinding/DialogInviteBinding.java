package com.platform101xp.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.platform101xp.sdk.R;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class DialogInviteBinding implements ViewBinding {
    public final ImageButton inviteCloseButton;
    public final ImageButton inviteFacebookButton;
    public final TextView inviteTitle;
    public final ImageButton inviteVkButton;
    private final LinearLayout rootView;

    private DialogInviteBinding(LinearLayout linearLayout, ImageButton imageButton, ImageButton imageButton2, TextView textView, ImageButton imageButton3) {
        this.rootView = linearLayout;
        this.inviteCloseButton = imageButton;
        this.inviteFacebookButton = imageButton2;
        this.inviteTitle = textView;
        this.inviteVkButton = imageButton3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogInviteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogInviteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_invite, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogInviteBinding bind(View view) {
        int i = R.id.invite_close_button;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = R.id.invite_facebook_button;
            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, i);
            if (imageButton2 != null) {
                i = R.id.invite_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.invite_vk_button;
                    ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, i);
                    if (imageButton3 != null) {
                        return new DialogInviteBinding((LinearLayout) view, imageButton, imageButton2, textView, imageButton3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
