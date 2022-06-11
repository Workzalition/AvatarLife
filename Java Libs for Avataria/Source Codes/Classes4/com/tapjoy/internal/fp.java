package com.tapjoy.internal;

import android.util.Base64;
import com.tapjoy.TapjoyUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import java.util.zip.CRC32;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class fp {
    public final a a;
    public final String b;
    public final String c;
    public final String d;
    private final String e;
    private final int f;

    public fp(String str) {
        int length = str.length();
        if (!str.matches("[A-Za-z0-9\\-_]*") || length < 60 || (length & 3) != 0) {
            throw new IllegalArgumentException("The given API key was malformed.");
        }
        try {
            byte[] decode = Base64.decode(str, 8);
            int length2 = decode.length;
            ByteBuffer wrap = ByteBuffer.wrap(decode);
            wrap.order(ByteOrder.BIG_ENDIAN);
            int length3 = decode.length - 4;
            int i = wrap.getInt(length3);
            CRC32 crc32 = new CRC32();
            crc32.update(decode, 0, length3);
            if (i != ((int) crc32.getValue())) {
                throw new IllegalArgumentException("The given API key was invalid.");
            }
            this.e = str;
            this.b = new UUID(wrap.getLong(0), wrap.getLong(8)).toString();
            byte b = wrap.get(16);
            this.f = b;
            a a = a.a(wrap.get(17));
            this.a = a;
            this.c = str.substring(24, 44);
            if (b == 1) {
                this.d = null;
            } else if (b != 2 || a != a.a) {
                throw new IllegalArgumentException("The given API key was not supported.");
            } else {
                if (length2 < 57) {
                    throw new IllegalArgumentException("The given API key was invalid.");
                }
                byte[] bArr = new byte[12];
                System.arraycopy(decode, 33, bArr, 0, 12);
                this.d = TapjoyUtil.convertToHex(bArr);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("The given API key was malformed.", e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof fp) {
            return this.e.equals(((fp) obj).e);
        }
        return false;
    }

    public final String toString() {
        return this.e;
    }

    public static String a(String str) {
        if (str.regionMatches(13, "-8000-8000-", 0, 11)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.substring(0, 8));
            stringBuffer.append(str.substring(24, 30));
            stringBuffer.append(str.substring(9, 13));
            stringBuffer.append(str.substring(30));
            return stringBuffer.toString();
        }
        throw new IllegalArgumentException("The given UUID did not come from 5Rocks.");
    }
}
