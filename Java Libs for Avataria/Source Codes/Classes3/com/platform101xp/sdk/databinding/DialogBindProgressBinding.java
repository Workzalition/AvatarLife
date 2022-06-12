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
public final class DialogBindProgressBinding implements ViewBinding {
    public final TextView attentionLabel;
    public final TextView attentionText;
    public final Button bindButton101xp;
    public final Button buttonCancel;
    public final Button buttonExit;
    public final LinearLayout firstDivisor;
    private final LinearLayout rootView;

    private DialogBindProgressBinding(LinearLayout linearLayout, TextView textView, TextView textView2, Button button, Button button2, Button button3, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.attentionLabel = textView;
        this.attentionText = textView2;
        this.bindButton101xp = button;
        this.buttonCancel = button2;
        this.buttonExit = button3;
        this.firstDivisor = linearLayout2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogBindProgressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogBindProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_bind_progress, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogBindProgressBinding bind(View view) {
        int i = R.id.attention_label;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.attention_text;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.bind_button_101xp;
                Button button = (Button) ViewBindings.findChildViewById(view, i);
                if (button != null) {
                    i = R.id.button_cancel;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                    if (button2 != null) {
                        i = R.id.button_exit;
                        Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                        if (button3 != null) {
                            i = R.id.first_divisor;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                return new DialogBindProgressBinding((LinearLayout) view, textView, textView2, button, button2, button3, linearLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
