package com.platform101xp.sdk.internal.support;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.EditText;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.R;
import com.platform101xp.sdk.internal.Platform101XPAccount;
import com.platform101xp.sdk.internal.Platform101XPToast;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.zendesk.service.ErrorResponse;
import com.zendesk.service.ZendeskCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.inject.Inject;
import zendesk.configurations.Configuration;
import zendesk.core.AnonymousIdentity;
import zendesk.core.Zendesk;
import zendesk.support.CreateRequest;
import zendesk.support.CustomField;
import zendesk.support.Request;
import zendesk.support.RequestProvider;
import zendesk.support.Support;
import zendesk.support.guide.HelpCenterActivity;
import zendesk.support.guide.HelpCenterConfiguration;
import zendesk.support.request.RequestActivity;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPZendesk implements Platform101XPSupport {
    private long category;
    @Inject
    Platform101XPConfigManager configManager;
    @Inject
    Activity currentActivity;
    private String game;
    private final String LOG_TAG = "101XP SDK Zendesk ";
    private Boolean enabled = false;
    private Boolean initialized = false;
    private Long gameFieldId = 28044172L;
    private String email = "";
    private String username = "";
    private String userId = "";

    private void checkEnabled() {
        String str = this.game;
        this.enabled = Boolean.valueOf(str != null && !str.isEmpty());
    }

    @Override // com.platform101xp.sdk.internal.support.Platform101XPSupport
    public boolean isEnabled() {
        return this.enabled.booleanValue();
    }

    private void checkInitialized() {
        this.initialized = Boolean.valueOf(Zendesk.INSTANCE.isInitialized());
    }

    @Override // com.platform101xp.sdk.internal.support.Platform101XPSupport
    public boolean isInitialized() {
        return this.initialized.booleanValue();
    }

    @Override // com.platform101xp.sdk.internal.support.Platform101XPSupport
    public void initialize() {
        updateDataFromConfig();
        if (isEnabled()) {
            Zendesk.INSTANCE.init(this.currentActivity, "https://101xp.zendesk.com", this.configManager.getZendeskAppId(), this.configManager.getZendeskAuthClientId());
            Support.INSTANCE.init(Zendesk.INSTANCE);
            checkInitialized();
            return;
        }
        Log.d("101XP SDK Zendesk ", "Zendesk disabled");
    }

    private void showHelpCenter() {
        Zendesk.INSTANCE.setIdentity(new AnonymousIdentity.Builder().withEmailIdentifier(this.email).withNameIdentifier(this.username).build());
        Configuration config = RequestActivity.builder().withTicketForm(this.gameFieldId.longValue(), new ArrayList<CustomField>() { // from class: com.platform101xp.sdk.internal.support.Platform101XPZendesk.1
            {
                Platform101XPZendesk.this = this;
                add(new CustomField(this.gameFieldId, this.game));
            }
        }).config();
        HelpCenterConfiguration.Builder builder = HelpCenterActivity.builder();
        long j = this.category;
        if (j != 0) {
            builder.withArticlesForCategoryIds(new Long[]{Long.valueOf(j)});
        } else {
            builder.withCategoriesCollapsed(true);
        }
        builder.show(this.currentActivity, new Configuration[]{config});
    }

    @Override // com.platform101xp.sdk.internal.support.Platform101XPSupport
    public void showSupportForm() {
        if (isInitialized()) {
            String str = this.email;
            if (str == null || str.isEmpty() || !isEmailValid(this.email)) {
                Log.d("101XP SDK Zendesk ", "email is empty or invalid");
                setEmailDialog(this.email);
                return;
            }
            showHelpCenter();
            return;
        }
        Log.d("101XP SDK Zendesk ", "support form is not available, initialize = " + isInitialized());
    }

    public void setUserinfo(Platform101XPAccount platform101XPAccount) {
        this.username = platform101XPAccount.getUserName();
        this.email = platform101XPAccount.getEmail();
        this.userId = String.valueOf(platform101XPAccount.getId());
    }

    private void setEmailDialog(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.currentActivity);
        final EditText editText = new EditText(this.currentActivity);
        editText.setInputType(32);
        builder.setTitle(R.string.enter_email);
        builder.setView(editText);
        builder.setPositiveButton(R.string.done, new DialogInterface.OnClickListener() { // from class: com.platform101xp.sdk.internal.support.Platform101XPZendesk.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Platform101XPZendesk.this.email = editText.getText().toString();
                Platform101XPZendesk.this.showSupportForm();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.platform101xp.sdk.internal.support.Platform101XPZendesk.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }

    private boolean isEmailValid(String str) {
        return Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(str).matches();
    }

    public void showFeedbackSent(String str) {
        new Platform101XPToast(this.currentActivity).showXpToast(str);
    }

    public void sendZendeskFeedback(String str, String str2, final Dialog dialog) {
        Zendesk.INSTANCE.setIdentity(new AnonymousIdentity.Builder().withNameIdentifier(str2).build());
        RequestProvider requestProvider = Support.INSTANCE.provider().requestProvider();
        CreateRequest createRequest = new CreateRequest();
        createRequest.setSubject("Feedback from user: " + str2);
        createRequest.setTags(Arrays.asList("feedback", "package: " + this.currentActivity.getPackageName()));
        createRequest.setTicketFormId(this.gameFieldId);
        createRequest.setDescription(str);
        dialog.hide();
        requestProvider.createRequest(createRequest, new ZendeskCallback<Request>() { // from class: com.platform101xp.sdk.internal.support.Platform101XPZendesk.4
            public void onSuccess(Request request) {
                Platform101XPZendesk.this.showFeedbackSent(Platform101XP.getCurrentActivity().getResources().getString(R.string.feedback_sent_hint));
                dialog.dismiss();
            }

            public void onError(ErrorResponse errorResponse) {
                Log.d("101XP SDK", "Feedback not sent, error: " + errorResponse.getReason());
                Platform101XPZendesk.this.showFeedbackSent(Platform101XP.getCurrentActivity().getResources().getString(R.string.feedback_not_sent, errorResponse.getReason()));
                dialog.show();
            }
        });
    }

    @Override // com.platform101xp.sdk.internal.support.Platform101XPSupport
    public void updateDataFromConfig() {
        this.game = this.configManager.getString(Platform101XPConfigKeyHolder.zendeskGameId, "");
        this.category = Long.valueOf(this.configManager.getString(Platform101XPConfigKeyHolder.zendeskCategoryId, "0")).longValue();
        checkEnabled();
    }
}
