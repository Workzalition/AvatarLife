package com.platform101xp.sdk.internal.observers;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public interface Platform101XPReferrerObservable {
    void addReferrerObserver(Platform101XPReferrerObserver platform101XPReferrerObserver);

    void deleteReferrerObserver(Platform101XPReferrerObserver platform101XPReferrerObserver);

    void notifyObservers();
}
