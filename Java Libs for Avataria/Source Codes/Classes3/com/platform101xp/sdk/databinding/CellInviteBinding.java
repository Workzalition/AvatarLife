package com.platform101xp.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.platform101xp.sdk.R;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class CellInviteBinding implements ViewBinding {
    public final ImageButton inviteButton;
    public final LinearLayout inviteListCell;
    public final TextView inviteListName;
    private final LinearLayout rootView;
    public final ImageView userImage;

    private CellInviteBinding(LinearLayout linearLayout, ImageButton imageButton, LinearLayout linearLayout2, TextView textView, ImageView imageView) {
        this.rootView = linearLayout;
        this.inviteButton = imageButton;
        this.inviteListCell = linearLayout2;
        this.inviteListName = textView;
        this.userImage = imageView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CellInviteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CellInviteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.cell_invite, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CellInviteBinding bind(View view) {
        int i = R.id.inviteButton;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R.id.inviteListName;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.userImage;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    return new CellInviteBinding(linearLayout, imageButton, linearLayout, textView, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
