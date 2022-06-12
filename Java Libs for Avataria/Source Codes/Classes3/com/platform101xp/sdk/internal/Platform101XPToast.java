package com.platform101xp.sdk.internal;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.platform101xp.sdk.R;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPToast {
    private Activity activity;
    private LayoutInflater layoutInflater;
    private TextView toastText;
    private View toastView;
    private Toast xpToast;

    public Platform101XPToast(Activity activity) {
        this.activity = activity;
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        this.layoutInflater = layoutInflater;
        View inflate = layoutInflater.inflate(R.layout.toast_101xp_layout, (ViewGroup) null);
        this.toastView = inflate;
        this.toastText = (TextView) inflate.findViewById(R.id.toast_101xp_message);
    }

    public void showXpToast(String str) {
        this.xpToast = new Toast(this.activity);
        this.toastText.setText(str);
        this.xpToast.setView(this.toastView);
        this.xpToast.setDuration(0);
        this.xpToast.setGravity(49, 0, 0);
        this.xpToast.show();
    }
}
