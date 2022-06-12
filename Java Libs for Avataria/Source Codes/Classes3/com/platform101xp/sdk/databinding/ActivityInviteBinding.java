package com.platform101xp.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.platform101xp.sdk.R;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class ActivityInviteBinding implements ViewBinding {
    public final ImageButton buttonClose;
    public final Button buttonTitle;
    public final TextView friendsCount;
    public final ListView inviteListView;
    public final LinearLayout inviteTitleBar;
    private final LinearLayout rootView;

    private ActivityInviteBinding(LinearLayout linearLayout, ImageButton imageButton, Button button, TextView textView, ListView listView, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.buttonClose = imageButton;
        this.buttonTitle = button;
        this.friendsCount = textView;
        this.inviteListView = listView;
        this.inviteTitleBar = linearLayout2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityInviteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityInviteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_invite, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityInviteBinding bind(View view) {
        int i = R.id.button_close;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = R.id.button_title;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = R.id.friends_count;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.inviteListView;
                    ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
                    if (listView != null) {
                        i = R.id.invite_title_bar;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            return new ActivityInviteBinding((LinearLayout) view, imageButton, button, textView, listView, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
