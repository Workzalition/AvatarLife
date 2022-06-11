package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class fo {
    public static <T> T a(T t, Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(t, Thread.currentThread(), Looper.myLooper()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static class a implements InvocationHandler {
        private final Object a;
        private final Thread b;
        private final Looper c;

        public a(Object obj, Thread thread, Looper looper) {
            this.a = obj;
            this.b = thread;
            this.c = looper;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, final Method method, final Object[] objArr) {
            if (this.b == Thread.currentThread()) {
                return method.invoke(this.a, objArr);
            }
            if (!method.getReturnType().equals(Void.TYPE)) {
                throw new UnsupportedOperationException("method not return void: " + method.getName());
            }
            Runnable runnable = new Runnable() { // from class: com.tapjoy.internal.fo.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        method.invoke(a.this.a, objArr);
                    } catch (IllegalAccessException e) {
                        throw jt.a(e);
                    } catch (IllegalArgumentException e2) {
                        throw jt.a(e2);
                    } catch (InvocationTargetException e3) {
                        throw jt.a(e3);
                    }
                }
            };
            if (this.c != null && new Handler(this.c).post(runnable)) {
                return null;
            }
            if (this.b == gt.b() && gt.a.a(runnable)) {
                return null;
            }
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null && new Handler(mainLooper).post(runnable)) {
                return null;
            }
            return method.invoke(this.a, objArr);
        }
    }
}
