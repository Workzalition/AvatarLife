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
public final class DialogLogsBinding implements ViewBinding {
    public final Button acceptLogsBtn;
    public final Button cancelLogsBtn;
    public final TextView eulaLicenseText;
    private final LinearLayout rootView;

    private DialogLogsBinding(LinearLayout linearLayout, Button button, Button button2, TextView textView) {
        this.rootView = linearLayout;
        this.acceptLogsBtn = button;
        this.cancelLogsBtn = button2;
        this.eulaLicenseText = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogLogsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogLogsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_logs, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogLogsBinding bind(View view) {
        int i = R.id.accept_logs_btn;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.cancel_logs__btn;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.eula_license_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new DialogLogsBinding((LinearLayout) view, button, button2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
