package com.platform101xp.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.platform101xp.sdk.R;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class DialogTheAppRatingResultBinding implements ViewBinding {
    public final ImageView ratingResultMainBackground;
    public final Button ratingResultOkButton;
    public final TextView ratingResultText;
    public final TextView ratingResultTitle;
    private final FrameLayout rootView;

    private DialogTheAppRatingResultBinding(FrameLayout frameLayout, ImageView imageView, Button button, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.ratingResultMainBackground = imageView;
        this.ratingResultOkButton = button;
        this.ratingResultText = textView;
        this.ratingResultTitle = textView2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogTheAppRatingResultBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogTheAppRatingResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_the_app_rating_result, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogTheAppRatingResultBinding bind(View view) {
        int i = R.id.rating_result_main_background;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.rating_result_ok_button;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = R.id.rating_result_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.rating_result_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new DialogTheAppRatingResultBinding((FrameLayout) view, imageView, button, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
