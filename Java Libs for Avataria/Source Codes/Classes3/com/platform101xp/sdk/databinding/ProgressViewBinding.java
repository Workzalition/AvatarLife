package com.platform101xp.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.platform101xp.sdk.R;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class ProgressViewBinding implements ViewBinding {
    public final TextView progressViewLoadingText;
    public final ProgressBar progressViewProgressBar;
    private final LinearLayout rootView;

    private ProgressViewBinding(LinearLayout linearLayout, TextView textView, ProgressBar progressBar) {
        this.rootView = linearLayout;
        this.progressViewLoadingText = textView;
        this.progressViewProgressBar = progressBar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ProgressViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ProgressViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.progress_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ProgressViewBinding bind(View view) {
        int i = R.id.progress_view_loading_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.progress_view_progress_bar;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
            if (progressBar != null) {
                return new ProgressViewBinding((LinearLayout) view, textView, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
