package com.platform101xp.sdk.internal;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.R;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.logcathelper.AppFilesHelper;
import com.platform101xp.sdk.internal.support.Platform101XPSupportManager;
import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPApplicationReview {
    public static final String BUTTON_CENTER_NEGATIVE_KEY = "p101xp_button_center_negative";
    public static final String BUTTON_CENTER_POSITIVE_KEY = "p101xp_button_center_positive";
    public static final String BUTTON_LEFT_NEGATIVE_KEY = "p101xp_button_left_negative";
    public static final String BUTTON_LEFT_POSITIVE_KEY = "p101xp_button_left_positive";
    public static final String BUTTON_RIGHT_NEGATIVE_KEY = "p101xp_button_right_negative";
    public static final String BUTTON_RIGHT_POSITIVE_KEY = "p101xp_button_right_positive";
    private static final String BUTTON_TEXT_COLOR_KEY = "button_text";
    public static final String DIALOG_BACKGROUND_KEY = "p101xp_dialog_window_bg";
    private static final String FEEDBACK_LINK_COLOR_KEY = "feedback_link";
    public static final String FIRST_SHOW_KEY = "com.platform101xp.sdk.first_show_key";
    private static final String HEADLINE_TEXT_COLOR_KEY = "text_headline";
    private static final int IMAGE_CENTER_TITLED = 1;
    private static final int IMAGE_LEFT = 0;
    private static final int IMAGE_RIGHT = 2;
    private static final String INPUT_BORDER_COLOR_KEY = "feedback_border";
    private static final String INPUT_COLOR_KEY = "feedback_input";
    private static final String INPUT_TEXT_COLOR_KEY = "feedback_text";
    public static final String LANDSCAPE_IMAGE_KEY = "p101xp_landscape_image";
    private static final float MIN_POSITIVE_RATING = 4.0f;
    public static final String RATING_STAR_ACTIVE_KEY = "p101xp_rating_star_active";
    public static final String RATING_STAR_NORMAL_KEY = "p101xp_rating_star_normal";
    public static final String RATING_STAR_PRESSED_KEY = "p101xp_rating_star_pressed";
    public static final String REVIEW_TIME_KEY = "com.platform101xp.sdk.review_time_key";
    private static final String STORE_VISITED_KEY = "com.platform101xp.sdk.store_visited_key";
    private static final String SUBLINE_TEXT_COLOR_KEY = "text_subline";
    private static final String USER_ANONYMOUS = "Anonymous";
    private Platform101XPConfigManager configManager;
    private View feedbackResultView;
    private View inputFeedbackView;
    private boolean isStoreVisited;
    private LayoutInflater layoutInflater;
    private View ratingView;
    private boolean reviewEnabled;
    private Platform101XPSkinManager skinManager;
    private Platform101XPSupportManager supportManager;
    private String userId;
    private String userName;
    private final String REVIEW_MARKET_URI = "market://details?id=";
    private final String REVIEW_GOOGLE_PLAY_URI = "https://play.google.com/store/apps/details?id=";
    private Dialog ratingDialog = null;
    private Dialog feedbackResultDialog = null;
    private Dialog inputFeedbackDialog = null;
    private Platform101XPApplicationReviewGooglePlay applicationReviewUtils = null;

    public Platform101XPApplicationReview(Platform101XPSupportManager platform101XPSupportManager, Platform101XPSkinManager platform101XPSkinManager, Platform101XPConfigManager platform101XPConfigManager, Platform101XPApplicationReviewGooglePlay platform101XPApplicationReviewGooglePlay) {
        initialize(platform101XPSupportManager, platform101XPSkinManager, platform101XPConfigManager, platform101XPApplicationReviewGooglePlay);
    }

    private void initialize(Platform101XPSupportManager platform101XPSupportManager, Platform101XPSkinManager platform101XPSkinManager, Platform101XPConfigManager platform101XPConfigManager, Platform101XPApplicationReviewGooglePlay platform101XPApplicationReviewGooglePlay) {
        this.isStoreVisited = Platform101XPSettings.loadBoolean(STORE_VISITED_KEY, false);
        this.configManager = platform101XPConfigManager;
        updateConfigData();
        this.userName = USER_ANONYMOUS;
        if (Platform101XP.getCurrentActivity() != null) {
            this.layoutInflater = LayoutInflater.from(Platform101XP.getCurrentActivity());
        }
        this.supportManager = platform101XPSupportManager;
        this.skinManager = platform101XPSkinManager;
        this.applicationReviewUtils = platform101XPApplicationReviewGooglePlay;
    }

    public void updateConfigData() {
        this.reviewEnabled = this.configManager.getBool(Platform101XPConfigKeyHolder.appReviewEnabled, false);
    }

    public Dialog getReviewDialog(String str) {
        this.userId = AppFilesHelper.SPACE + str;
        if (this.reviewEnabled) {
            return createRatingDialog(Platform101XP.getCurrentActivity().getPackageName());
        }
        return null;
    }

    private Dialog createRatingDialog(final String str) {
        if (this.layoutInflater == null) {
            return null;
        }
        View view = this.ratingView;
        if (view != null && view.getParent() != null) {
            this.ratingView = null;
        }
        final String string = Platform101XP.getCurrentActivity().getString(R.string.app_name);
        String string2 = Platform101XP.getCurrentActivity().getString(R.string.like_game, new Object[]{string});
        View inflate = this.layoutInflater.inflate(R.layout.dialog_the_app_rating, (ViewGroup) null);
        this.ratingView = inflate;
        this.ratingDialog = createDialog(inflate);
        setDialogBgImage(this.ratingView, R.id.rating_main_background, DIALOG_BACKGROUND_KEY);
        TextView textView = (TextView) this.ratingView.findViewById(R.id.rating_question_text);
        textView.setText(string2);
        setTextColor(textView, HEADLINE_TEXT_COLOR_KEY);
        setTextColor((TextView) this.ratingView.findViewById(R.id.rating_request_text), HEADLINE_TEXT_COLOR_KEY);
        if (Platform101XP.getCurrentActivity().getResources().getConfiguration().orientation == 2) {
            setDialogBgImage(this.ratingView, R.id.rating_left_custom_image, LANDSCAPE_IMAGE_KEY);
        }
        Button button = (Button) this.ratingView.findViewById(R.id.rating_later_button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.Platform101XPApplicationReview.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Platform101XPApplicationReview.this.ratingDialog.dismiss();
                Platform101XP.analyticsTrack("rate-window-later", (Map) null);
                Log.d("101XP SDK", "Close rating dialog.");
            }
        });
        setButtonTextColor(button, SUBLINE_TEXT_COLOR_KEY);
        RatingBar ratingBar = (RatingBar) this.ratingView.findViewById(R.id.rating_stars_bar);
        setRatingImages(ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: com.platform101xp.sdk.internal.Platform101XPApplicationReview.2
            @Override // android.widget.RatingBar.OnRatingBarChangeListener
            public void onRatingChanged(RatingBar ratingBar2, final float f, boolean z) {
                if (Platform101XP.getCurrentActivity() != null) {
                    Platform101XP.analyticsTrack("rate-window-star-" + f, (Map) null);
                    Platform101XPApplicationReview.this.createHandler().postDelayed(new Runnable() { // from class: com.platform101xp.sdk.internal.Platform101XPApplicationReview.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Platform101XPApplicationReview.this.ratingDialog != null && Platform101XPApplicationReview.this.ratingDialog.isShowing()) {
                                Platform101XPApplicationReview.this.ratingDialog.dismiss();
                            }
                            if (f < Platform101XPApplicationReview.MIN_POSITIVE_RATING) {
                                Platform101XPApplicationReview.this.createInputFeedbackDialog(string, f);
                                if (Platform101XPApplicationReview.this.inputFeedbackDialog == null) {
                                    return;
                                }
                                Platform101XPApplicationReview.this.inputFeedbackDialog.show();
                                return;
                            }
                            try {
                                try {
                                    Log.d("101XP SDK", "Send estimate Uri: market://details?id=" + str);
                                    Platform101XPApplicationReview.this.applicationReviewUtils.show();
                                } catch (ActivityNotFoundException unused) {
                                    Log.d("101XP SDK", "Send estimate Uri: https://play.google.com/store/apps/details?id=" + str);
                                    Activity currentActivity = Platform101XP.getCurrentActivity();
                                    currentActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str)));
                                }
                            } finally {
                                Platform101XPApplicationReview.this.storeWasVisited();
                            }
                        }
                    }, 500L);
                }
            }
        });
        return this.ratingDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Dialog createFeedbackResultDialog() {
        if (this.layoutInflater == null) {
            return null;
        }
        View view = this.feedbackResultView;
        if (view != null && view.getParent() != null) {
            this.feedbackResultView = null;
        }
        View inflate = this.layoutInflater.inflate(R.layout.dialog_the_app_rating_result, (ViewGroup) null);
        this.feedbackResultView = inflate;
        this.feedbackResultDialog = createDialog(inflate);
        setDialogBgImage(this.feedbackResultView, R.id.rating_result_main_background, DIALOG_BACKGROUND_KEY);
        Button button = (Button) this.feedbackResultView.findViewById(R.id.rating_result_ok_button);
        setButtonBgImages(button, true);
        setButtonTextColor(button, BUTTON_TEXT_COLOR_KEY);
        setTextColor((TextView) this.feedbackResultView.findViewById(R.id.rating_result_title), HEADLINE_TEXT_COLOR_KEY);
        setTextColor((TextView) this.feedbackResultView.findViewById(R.id.rating_result_text), HEADLINE_TEXT_COLOR_KEY);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.Platform101XPApplicationReview.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (Platform101XPApplicationReview.this.feedbackResultDialog == null || !Platform101XPApplicationReview.this.feedbackResultDialog.isShowing()) {
                    return;
                }
                Platform101XPApplicationReview.this.feedbackResultDialog.dismiss();
                Log.d("101XP SDK", "Close request feedback result dialog.");
            }
        });
        return this.feedbackResultDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Dialog createInputFeedbackDialog(String str, float f) {
        if (this.layoutInflater == null) {
            return null;
        }
        View view = this.inputFeedbackView;
        if (view != null && view.getParent() != null) {
            this.inputFeedbackView = null;
        }
        View inflate = this.layoutInflater.inflate(R.layout.dialog_the_app_rating_feedback, (ViewGroup) null);
        this.inputFeedbackView = inflate;
        this.inputFeedbackDialog = createDialog(inflate);
        setDialogBgImage(this.inputFeedbackView, R.id.rating_feedback_main_background, DIALOG_BACKGROUND_KEY);
        Button button = (Button) this.inputFeedbackView.findViewById(R.id.rating_feedback_change_button);
        final RatingBar ratingBar = (RatingBar) this.inputFeedbackView.findViewById(R.id.rating_feedback_bar);
        setRatingImages(ratingBar);
        ratingBar.setRating(f);
        ((TextView) this.inputFeedbackView.findViewById(R.id.rating_feedback_ask_text)).setText(Platform101XP.getCurrentActivity().getString(R.string.whats_wrong_please, new Object[]{str}));
        final EditText editText = (EditText) this.inputFeedbackView.findViewById(R.id.rating_feedback_input);
        editText.requestFocus();
        final Button button2 = (Button) this.inputFeedbackView.findViewById(R.id.rating_feedback_send_button);
        Button button3 = (Button) this.inputFeedbackView.findViewById(R.id.rating_feedback_not_now_button);
        setButtonBgImages(button2, true);
        setButtonBgImages(button3, false);
        setButtonTextColor(button3, BUTTON_TEXT_COLOR_KEY);
        setButtonTextColor(button, FEEDBACK_LINK_COLOR_KEY);
        setButtonTextColor(button2, BUTTON_TEXT_COLOR_KEY);
        setInputBackground(editText);
        setTextColor((TextView) this.inputFeedbackView.findViewById(R.id.rating_feedback_ask_text), HEADLINE_TEXT_COLOR_KEY);
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.Platform101XPApplicationReview.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (Platform101XPApplicationReview.this.inputFeedbackDialog == null || !Platform101XPApplicationReview.this.inputFeedbackDialog.isShowing()) {
                    return;
                }
                Platform101XPApplicationReview.this.inputFeedbackDialog.dismiss();
                Platform101XP.analyticsTrack("rate-window-skip", (Map) null);
                Log.d("101XP SDK", "Close input feedback dialog.");
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.Platform101XPApplicationReview.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Platform101XPApplicationReview.this.inputFeedbackDialog.dismiss();
                Dialog reviewDialog = Platform101XPApplicationReview.this.getReviewDialog(Platform101XPApplicationReview.this.userId.replace(AppFilesHelper.SPACE, ""));
                if (reviewDialog != null) {
                    reviewDialog.show();
                    Platform101XP.analyticsTrack("rate-window-open", (Map) null);
                    Platform101XPSettings.saveLong(Platform101XPApplicationReview.REVIEW_TIME_KEY, System.currentTimeMillis());
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.Platform101XPApplicationReview.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String obj = editText.getText().toString();
                if (Platform101XPApplicationReview.this.supportManager != null && obj != null && !obj.isEmpty()) {
                    Platform101XPApplicationReview.this.supportManager.sendZendeskFeedback(obj, Platform101XPApplicationReview.this.userName, Platform101XPApplicationReview.this.inputFeedbackDialog);
                    Platform101XPApplicationReview.this.inputFeedbackDialog.dismiss();
                    Platform101XP.analyticsTrack("rate-window-send-" + ratingBar.getRating(), (Map) null);
                    Platform101XPApplicationReview.this.createFeedbackResultDialog().show();
                    return;
                }
                Log.d("101XP SDK", "Feedback text is empty.");
            }
        });
        editText.addTextChangedListener(new TextWatcher() { // from class: com.platform101xp.sdk.internal.Platform101XPApplicationReview.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence.length() != 0) {
                    button2.setEnabled(true);
                } else {
                    button2.setEnabled(false);
                }
            }
        });
        return this.inputFeedbackDialog;
    }

    private Dialog createDialog(View view) {
        Dialog dialog = new Dialog(Platform101XP.getCurrentActivity());
        dialog.requestWindowFeature(1);
        dialog.setContentView(view);
        dialog.setCancelable(true);
        dialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void storeWasVisited() {
        this.isStoreVisited = true;
        Platform101XPSettings.saveBoolean(STORE_VISITED_KEY, true);
    }

    private void setDialogBgImage(View view, int i, String str) {
        if (this.skinManager == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(i);
        BitmapDrawable drawable = this.skinManager.getDrawable(str);
        if (imageView == null || drawable == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
        imageView.invalidate();
    }

    private void setRatingImages(RatingBar ratingBar) {
        Platform101XPSkinManager platform101XPSkinManager = this.skinManager;
        if (platform101XPSkinManager == null || ratingBar == null) {
            return;
        }
        BitmapDrawable drawable = platform101XPSkinManager.getDrawable(RATING_STAR_NORMAL_KEY);
        BitmapDrawable drawable2 = this.skinManager.getDrawable(RATING_STAR_ACTIVE_KEY);
        BitmapDrawable drawable3 = this.skinManager.getDrawable(RATING_STAR_PRESSED_KEY);
        if (drawable == null || drawable2 == null || drawable3 == null) {
            return;
        }
        addTintMode(ratingBar, drawable, 16908288);
        addTintMode(ratingBar, drawable3, 16908303);
        addTintMode(ratingBar, drawable2, 16908301);
        ratingBar.invalidate();
    }

    private void addTintMode(RatingBar ratingBar, BitmapDrawable bitmapDrawable, int i) {
        bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
        if (i == 16908288) {
            ((LayerDrawable) ratingBar.getProgressDrawable()).setDrawableByLayerId(i, bitmapDrawable);
            return;
        }
        ((LayerDrawable) ratingBar.getProgressDrawable()).setDrawableByLayerId(i, new ClipDrawable(bitmapDrawable, 3, 1));
    }

    private void setButtonBgImages(Button button, boolean z) {
        if (this.skinManager != null && isAllButtonsDrawableExist()) {
            if (z) {
                addButtonTintMode(button, this.skinManager.getDrawable(BUTTON_LEFT_POSITIVE_KEY), this.skinManager.getDrawable(BUTTON_CENTER_POSITIVE_KEY), this.skinManager.getDrawable(BUTTON_RIGHT_POSITIVE_KEY));
            } else {
                addButtonTintMode(button, this.skinManager.getDrawable(BUTTON_LEFT_NEGATIVE_KEY), this.skinManager.getDrawable(BUTTON_CENTER_NEGATIVE_KEY), this.skinManager.getDrawable(BUTTON_RIGHT_NEGATIVE_KEY));
            }
        }
    }

    private boolean isAllButtonsDrawableExist() {
        return isDrawableExist(BUTTON_LEFT_POSITIVE_KEY) && isDrawableExist(BUTTON_CENTER_POSITIVE_KEY) && isDrawableExist(BUTTON_RIGHT_POSITIVE_KEY) && isDrawableExist(BUTTON_LEFT_NEGATIVE_KEY) && isDrawableExist(BUTTON_CENTER_NEGATIVE_KEY) && isDrawableExist(BUTTON_RIGHT_NEGATIVE_KEY);
    }

    private boolean isDrawableExist(String str) {
        return this.skinManager.getDrawable(str) != null;
    }

    private void addButtonTintMode(Button button, BitmapDrawable bitmapDrawable, BitmapDrawable bitmapDrawable2, BitmapDrawable bitmapDrawable3) {
        if (button == null || bitmapDrawable == null || bitmapDrawable2 == null || bitmapDrawable3 == null) {
            return;
        }
        bitmapDrawable2.setGravity(17);
        bitmapDrawable.setGravity(3);
        bitmapDrawable3.setGravity(5);
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable2, bitmapDrawable3});
        layerDrawable.setLayerInset(1, 16, 0, 16, 0);
        button.setBackground(layerDrawable);
        button.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler createHandler() {
        return new Handler(Looper.getMainLooper());
    }

    private void setTextColor(TextView textView, String str) {
        String colorString;
        Platform101XPSkinManager platform101XPSkinManager = this.skinManager;
        if (platform101XPSkinManager == null || textView == null || (colorString = platform101XPSkinManager.getColorString(str)) == null || colorString.isEmpty()) {
            return;
        }
        textView.setTextColor(Color.parseColor(colorString));
    }

    private void setButtonTextColor(Button button, String str) {
        String colorString;
        Platform101XPSkinManager platform101XPSkinManager = this.skinManager;
        if (platform101XPSkinManager == null || button == null || (colorString = platform101XPSkinManager.getColorString(str)) == null || colorString.isEmpty()) {
            return;
        }
        button.setTextColor(Color.parseColor(colorString));
    }

    private void setInputBackground(EditText editText) {
        Platform101XPSkinManager platform101XPSkinManager = this.skinManager;
        if (platform101XPSkinManager == null || editText == null) {
            return;
        }
        String colorString = platform101XPSkinManager.getColorString(INPUT_COLOR_KEY);
        String colorString2 = this.skinManager.getColorString(INPUT_BORDER_COLOR_KEY);
        String colorString3 = this.skinManager.getColorString(INPUT_TEXT_COLOR_KEY);
        GradientDrawable gradientDrawable = (GradientDrawable) editText.getBackground().mutate();
        if (colorString != null) {
            gradientDrawable.setColor(Color.parseColor(colorString));
        }
        if (colorString2 != null) {
            gradientDrawable.setStroke(2, Color.parseColor(colorString2));
        }
        if (colorString3 == null) {
            return;
        }
        editText.setTextColor(Color.parseColor(colorString3));
    }
}
