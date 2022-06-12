package com.platform101xp.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.platform101xp.sdk.R;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class DialogTheAppRatingFeedbackBinding implements ViewBinding {
    public final TextView ratingFeedbackAskText;
    public final RatingBar ratingFeedbackBar;
    public final Button ratingFeedbackChangeButton;
    public final EditText ratingFeedbackInput;
    public final ImageView ratingFeedbackMainBackground;
    public final Button ratingFeedbackNotNowButton;
    public final Button ratingFeedbackSendButton;
    private final FrameLayout rootView;

    private DialogTheAppRatingFeedbackBinding(FrameLayout frameLayout, TextView textView, RatingBar ratingBar, Button button, EditText editText, ImageView imageView, Button button2, Button button3) {
        this.rootView = frameLayout;
        this.ratingFeedbackAskText = textView;
        this.ratingFeedbackBar = ratingBar;
        this.ratingFeedbackChangeButton = button;
        this.ratingFeedbackInput = editText;
        this.ratingFeedbackMainBackground = imageView;
        this.ratingFeedbackNotNowButton = button2;
        this.ratingFeedbackSendButton = button3;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogTheAppRatingFeedbackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogTheAppRatingFeedbackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_the_app_rating_feedback, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogTheAppRatingFeedbackBinding bind(View view) {
        int i = R.id.rating_feedback_ask_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.rating_feedback_bar;
            RatingBar ratingBar = (RatingBar) ViewBindings.findChildViewById(view, i);
            if (ratingBar != null) {
                i = R.id.rating_feedback_change_button;
                Button button = (Button) ViewBindings.findChildViewById(view, i);
                if (button != null) {
                    i = R.id.rating_feedback_input;
                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText != null) {
                        i = R.id.rating_feedback_main_background;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.rating_feedback_not_now_button;
                            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                            if (button2 != null) {
                                i = R.id.rating_feedback_send_button;
                                Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                                if (button3 != null) {
                                    return new DialogTheAppRatingFeedbackBinding((FrameLayout) view, textView, ratingBar, button, editText, imageView, button2, button3);
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
