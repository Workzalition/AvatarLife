package com.platform101xp.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.platform101xp.sdk.R;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class DialogEulaBinding implements ViewBinding {
    public final Button eulaAcceptBtn;
    public final TextView eulaLicenseText;
    public final Button eulaReadBtn;
    private final LinearLayout rootView;

    private DialogEulaBinding(LinearLayout linearLayout, Button button, TextView textView, Button button2) {
        this.rootView = linearLayout;
        this.eulaAcceptBtn = button;
        this.eulaLicenseText = textView;
        this.eulaReadBtn = button2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogEulaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogEulaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_eula, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogEulaBinding bind(View view) {
        int i = R.id.eula_accept_btn;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.eula_license_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.eula_read_btn;
                Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                if (button2 != null) {
                    return new DialogEulaBinding((LinearLayout) view, button, textView, button2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
