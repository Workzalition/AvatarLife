package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPLinks.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/dynamiclinks/Platform101XPLinks;", "", "link", "", "dynamicLinkDomain", "androidLink", "iOsLink", "iOsId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAndroidLink", "()Ljava/lang/String;", "getDynamicLinkDomain", "getIOsId", "getIOsLink", "getLink", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPLinks {
    private final String androidLink;
    private final String dynamicLinkDomain;
    private final String iOsId;
    private final String iOsLink;
    private final String link;

    public static /* synthetic */ Platform101XPLinks copy$default(Platform101XPLinks platform101XPLinks, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = platform101XPLinks.link;
        }
        if ((i & 2) != 0) {
            str2 = platform101XPLinks.dynamicLinkDomain;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = platform101XPLinks.androidLink;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = platform101XPLinks.iOsLink;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = platform101XPLinks.iOsId;
        }
        return platform101XPLinks.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.link;
    }

    public final String component2() {
        return this.dynamicLinkDomain;
    }

    public final String component3() {
        return this.androidLink;
    }

    public final String component4() {
        return this.iOsLink;
    }

    public final String component5() {
        return this.iOsId;
    }

    public final Platform101XPLinks copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "link");
        Intrinsics.checkNotNullParameter(str2, "dynamicLinkDomain");
        Intrinsics.checkNotNullParameter(str3, "androidLink");
        Intrinsics.checkNotNullParameter(str4, "iOsLink");
        return new Platform101XPLinks(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Platform101XPLinks)) {
            return false;
        }
        Platform101XPLinks platform101XPLinks = (Platform101XPLinks) obj;
        return Intrinsics.areEqual(this.link, platform101XPLinks.link) && Intrinsics.areEqual(this.dynamicLinkDomain, platform101XPLinks.dynamicLinkDomain) && Intrinsics.areEqual(this.androidLink, platform101XPLinks.androidLink) && Intrinsics.areEqual(this.iOsLink, platform101XPLinks.iOsLink) && Intrinsics.areEqual(this.iOsId, platform101XPLinks.iOsId);
    }

    public int hashCode() {
        int hashCode = ((((((this.link.hashCode() * 31) + this.dynamicLinkDomain.hashCode()) * 31) + this.androidLink.hashCode()) * 31) + this.iOsLink.hashCode()) * 31;
        String str = this.iOsId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Platform101XPLinks(link=" + this.link + ", dynamicLinkDomain=" + this.dynamicLinkDomain + ", androidLink=" + this.androidLink + ", iOsLink=" + this.iOsLink + ", iOsId=" + ((Object) this.iOsId) + ')';
    }

    public Platform101XPLinks(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "link");
        Intrinsics.checkNotNullParameter(str2, "dynamicLinkDomain");
        Intrinsics.checkNotNullParameter(str3, "androidLink");
        Intrinsics.checkNotNullParameter(str4, "iOsLink");
        this.link = str;
        this.dynamicLinkDomain = str2;
        this.androidLink = str3;
        this.iOsLink = str4;
        this.iOsId = str5;
    }

    public final String getAndroidLink() {
        return this.androidLink;
    }

    public final String getDynamicLinkDomain() {
        return this.dynamicLinkDomain;
    }

    public final String getIOsId() {
        return this.iOsId;
    }

    public final String getIOsLink() {
        return this.iOsLink;
    }

    public final String getLink() {
        return this.link;
    }
}
