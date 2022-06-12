package com.platform101xp.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.platform101xp.sdk.R;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class DialogTheAppRatingBinding implements ViewBinding {
    public final LinearLayout ratingContentLayout;
    public final Button ratingLaterButton;
    public final ImageView ratingLeftCustomImage;
    public final ImageView ratingMainBackground;
    public final TextView ratingQuestionText;
    public final TextView ratingRequestText;
    public final RatingBar ratingStarsBar;
    private final FrameLayout rootView;

    private DialogTheAppRatingBinding(FrameLayout frameLayout, LinearLayout linearLayout, Button button, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, RatingBar ratingBar) {
        this.rootView = frameLayout;
        this.ratingContentLayout = linearLayout;
        this.ratingLaterButton = button;
        this.ratingLeftCustomImage = imageView;
        this.ratingMainBackground = imageView2;
        this.ratingQuestionText = textView;
        this.ratingRequestText = textView2;
        this.ratingStarsBar = ratingBar;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogTheAppRatingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogTheAppRatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_the_app_rating, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogTheAppRatingBinding bind(View view) {
        int i = R.id.rating_content_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.rating_later_button;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = R.id.rating_left_custom_image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.rating_main_background;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.rating_question_text;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.rating_request_text;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.rating_stars_bar;
                                RatingBar ratingBar = (RatingBar) ViewBindings.findChildViewById(view, i);
                                if (ratingBar != null) {
                                    return new DialogTheAppRatingBinding((FrameLayout) view, linearLayout, button, imageView, imageView2, textView, textView2, ratingBar);
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
