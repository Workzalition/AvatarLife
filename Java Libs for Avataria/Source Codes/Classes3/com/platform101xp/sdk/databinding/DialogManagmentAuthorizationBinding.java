package com.platform101xp.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.platform101xp.sdk.R;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class DialogManagmentAuthorizationBinding implements ViewBinding {
    public final LinearLayout androidReportLayout;
    public final TextView authLabel1;
    public final Button bindSnButton;
    public final LinearLayout bindSnLayout;
    public final TextView bindSnText;
    public final ImageButton buttonClose;
    public final Button buttonCollectLogs;
    public final Button buttonLogout;
    public final Button buttonReport;
    public final Button eulaTextButton;
    public final View manageDivisor;
    public final TextView p101xpIdLabel;
    public final TextView p101xpIdValue;
    private final LinearLayout rootView;
    public final TextView userGameIdLabel;
    public final TextView userGameIdValue;
    public final TextView usernameTextview;

    private DialogManagmentAuthorizationBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, Button button, LinearLayout linearLayout3, TextView textView2, ImageButton imageButton, Button button2, Button button3, Button button4, Button button5, View view, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = linearLayout;
        this.androidReportLayout = linearLayout2;
        this.authLabel1 = textView;
        this.bindSnButton = button;
        this.bindSnLayout = linearLayout3;
        this.bindSnText = textView2;
        this.buttonClose = imageButton;
        this.buttonCollectLogs = button2;
        this.buttonLogout = button3;
        this.buttonReport = button4;
        this.eulaTextButton = button5;
        this.manageDivisor = view;
        this.p101xpIdLabel = textView3;
        this.p101xpIdValue = textView4;
        this.userGameIdLabel = textView5;
        this.userGameIdValue = textView6;
        this.usernameTextview = textView7;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogManagmentAuthorizationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogManagmentAuthorizationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_managment_authorization, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogManagmentAuthorizationBinding bind(View view) {
        View findChildViewById;
        int i = R.id.android_report_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.auth_label1;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.bind_sn_button;
                Button button = (Button) ViewBindings.findChildViewById(view, i);
                if (button != null) {
                    i = R.id.bind_sn_layout;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.bind_sn_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.button_close;
                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
                            if (imageButton != null) {
                                i = R.id.button_collect_logs;
                                Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                                if (button2 != null) {
                                    i = R.id.button_logout;
                                    Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                                    if (button3 != null) {
                                        i = R.id.button_report;
                                        Button button4 = (Button) ViewBindings.findChildViewById(view, i);
                                        if (button4 != null) {
                                            i = R.id.eula_text_button;
                                            Button button5 = (Button) ViewBindings.findChildViewById(view, i);
                                            if (button5 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.manage_divisor))) != null) {
                                                i = R.id.p101xp_id_label;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.p101xp_id_value;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        i = R.id.user_game_id_label;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.user_game_id_value;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView6 != null) {
                                                                i = R.id.username_textview;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView7 != null) {
                                                                    return new DialogManagmentAuthorizationBinding((LinearLayout) view, linearLayout, textView, button, linearLayout2, textView2, imageButton, button2, button3, button4, button5, findChildViewById, textView3, textView4, textView5, textView6, textView7);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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
