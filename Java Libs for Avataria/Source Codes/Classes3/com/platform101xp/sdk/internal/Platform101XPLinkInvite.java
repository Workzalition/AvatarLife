package com.platform101xp.sdk.internal;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import androidx.core.app.ShareCompat;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.R;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.firebase.dynamiclinks.Platform101XPFirebaseDynamicLinks;
import com.platform101xp.sdk.internal.firebase.dynamiclinks.Platform101XPFirebaseDynamicLinksManager;
import com.platform101xp.sdk.internal.firebase.dynamiclinks.Platform101XPLinks;
import javax.inject.Inject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPLinkInvite {
    public static final String EVENT_KEY = "com.platform101xp.invite_link_event_key";
    public static final String REFERRER_ID_KEY = "com.platform101xp.invite_link_referrer_id_key";
    private String androidLink;
    @Inject
    Platform101XPConfigManager configManager;
    private String dynamicLinkDomain;
    @Inject
    Platform101XPFirebaseDynamicLinks dynamicLinks;
    private String iOsId;
    private String iOsLink;
    private Uri invitationUri;
    private String link;
    private Platform101XPLinks platform101XPLinks;
    private final String INVITE_PARAMETER_NAME = Platform101XPFirebaseDynamicLinksManager.INVITE_PARAMETER_NAME;
    private final String EVENT_PARAMETER_NAME = "event";

    public void initParameters() {
        this.dynamicLinkDomain = this.configManager.getString(Platform101XPConfigKeyHolder.dynamicLinkDomain, "");
        this.androidLink = Platform101XP.getCurrentActivity().getPackageName();
        this.iOsLink = this.configManager.getString(Platform101XPConfigKeyHolder.appStoreLink, "");
        this.iOsId = this.configManager.getString(Platform101XPConfigKeyHolder.appStoreId, "");
        Log.d("101XP SDK", "LinkInvite dynamicLink: " + this.dynamicLinkDomain + "\niOsLink: " + this.iOsLink + "\niOsId: " + this.iOsId);
    }

    public void saveDynamicLinkParameters(String str, String str2) {
        Platform101XPSettings.saveString(REFERRER_ID_KEY, str);
        Platform101XPSettings.saveString(EVENT_KEY, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInviteErrorToast() {
        Activity currentActivity = Platform101XP.getCurrentActivity();
        new Platform101XPToast(currentActivity).showXpToast(currentActivity.getString(R.string.invite_link_error_message));
    }

    public void sendInvite(final String str, String str2, Long l) {
        String string = this.configManager.getString(Platform101XPConfigKeyHolder.appLink, "");
        if (l.longValue() == 0 || this.dynamicLinkDomain.isEmpty() || this.iOsLink.isEmpty() || this.iOsId.isEmpty() || string.isEmpty()) {
            showInviteErrorToast();
            return;
        }
        this.link = string + "/?" + Platform101XPFirebaseDynamicLinksManager.INVITE_PARAMETER_NAME + "=" + l + "&event=" + str2;
        StringBuilder sb = new StringBuilder();
        sb.append("https://");
        sb.append(this.dynamicLinkDomain);
        String sb2 = sb.toString();
        this.dynamicLinkDomain = sb2;
        this.platform101XPLinks = new Platform101XPLinks(this.link, sb2, this.androidLink, this.iOsLink, this.iOsId);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Link for invite : ");
        sb3.append(this.link);
        Log.d("101XP SDK", sb3.toString());
        try {
            this.dynamicLinks.buildShortLink(this.platform101XPLinks, new OnSuccessListener<ShortDynamicLink>() { // from class: com.platform101xp.sdk.internal.Platform101XPLinkInvite.1
                public void onSuccess(ShortDynamicLink shortDynamicLink) {
                    Log.d("101XP SDK", "LinkInvite : " + shortDynamicLink.getPreviewLink());
                    Platform101XPLinkInvite.this.invitationUri = shortDynamicLink.getShortLink();
                    if (Platform101XPLinkInvite.this.invitationUri == null) {
                        Platform101XPLinkInvite.this.showInviteErrorToast();
                        return;
                    }
                    Platform101XPLinkInvite platform101XPLinkInvite = Platform101XPLinkInvite.this;
                    platform101XPLinkInvite.sendInviteLink(platform101XPLinkInvite.invitationUri, str);
                }
            });
        } catch (NoClassDefFoundError e) {
            Log.d("101XP SDK", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendInviteLink(Uri uri, String str) {
        Activity currentActivity = Platform101XP.getCurrentActivity();
        String uri2 = uri.toString();
        String charSequence = currentActivity.getApplicationInfo().loadLabel(currentActivity.getPackageManager()).toString();
        String format = String.format(Platform101XP.getCurrentActivity().getString(R.string.invite_link_subject), str, charSequence);
        String string = this.configManager.getString(Platform101XPConfigKeyHolder.inviteMessage, String.format(Platform101XP.getCurrentActivity().getString(R.string.invite_link_message), charSequence, uri2));
        if (!string.contains(uri2)) {
            string = string + uri2;
        }
        if (currentActivity != null) {
            currentActivity.startActivity(ShareCompat.IntentBuilder.from(currentActivity).setType("text/plain").setSubject(format).setText(string).setChooserTitle(String.format(Platform101XP.getCurrentActivity().getString(R.string.invite_link_title), charSequence)).createChooserIntent());
            Log.d("101XP SDK", "Invite sent!");
        }
    }
}
