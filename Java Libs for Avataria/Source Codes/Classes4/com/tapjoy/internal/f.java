package com.tapjoy.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class f<E> extends ao<E> implements as<E>, Closeable {
    private SQLiteDatabase a;
    private final ay<E> b;
    private int c;

    public f(File file, ay<E> ayVar) {
        SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
        this.a = openOrCreateDatabase;
        this.b = ayVar;
        if (openOrCreateDatabase.getVersion() != 1) {
            this.a.beginTransaction();
            try {
                this.a.execSQL("CREATE TABLE IF NOT EXISTS List(value BLOB)");
                this.a.setVersion(1);
                this.a.setTransactionSuccessful();
            } finally {
                this.a.endTransaction();
            }
        }
        this.c = a();
    }

    protected final void finalize() {
        close();
        super.finalize();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
            this.a = null;
        }
    }

    private int a() {
        Cursor cursor = null;
        try {
            cursor = this.a.rawQuery("SELECT COUNT(1) FROM List", null);
            if (!cursor.moveToNext()) {
                return 0;
            }
            return cursor.getInt(0);
        } finally {
            a(cursor);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.c;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.a.delete("List", "1", null);
        this.c = 0;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.util.Queue
    public final boolean offer(E e) {
        jr.a(e);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                this.b.a(byteArrayOutputStream, e);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                kb.a(byteArrayOutputStream);
                ContentValues contentValues = new ContentValues();
                contentValues.put("value", byteArray);
                if (this.a.insert("List", null, contentValues) == -1) {
                    return false;
                }
                this.c++;
                return true;
            } catch (IOException e2) {
                throw new IllegalArgumentException(e2);
            }
        } catch (Throwable th) {
            kb.a(byteArrayOutputStream);
            throw th;
        }
    }

    @Override // java.util.Queue
    public final E poll() {
        if (this.c > 0) {
            E peek = peek();
            b(1);
            return peek;
        }
        return null;
    }

    @Override // java.util.Queue
    public final E peek() {
        if (this.c > 0) {
            return a(0);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String[], android.database.Cursor] */
    @Override // com.tapjoy.internal.as
    public final E a(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException();
        }
        Cursor cursor = 0;
        try {
            SQLiteDatabase sQLiteDatabase = this.a;
            cursor = sQLiteDatabase.rawQuery("SELECT value FROM List ORDER BY rowid LIMIT " + i + ",1", cursor);
            if (cursor.moveToNext()) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cursor.getBlob(0));
                try {
                    E b = this.b.b(byteArrayInputStream);
                    kb.a(byteArrayInputStream);
                    return b;
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
            throw new NoSuchElementException();
        } finally {
            a((Cursor) cursor);
        }
    }

    @Override // com.tapjoy.internal.as
    public final void b(int i) {
        int i2;
        Throwable th;
        if (i <= 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException();
        }
        if (i == i2) {
            clear();
            return;
        }
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.a;
            StringBuilder sb = new StringBuilder("SELECT rowid FROM List ORDER BY rowid LIMIT ");
            sb.append(i - 1);
            sb.append(",1");
            Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
            try {
                if (rawQuery.moveToNext()) {
                    long j = rawQuery.getLong(0);
                    rawQuery.close();
                    int delete = this.a.delete("List", "rowid <= ".concat(String.valueOf(j)), null);
                    this.c -= delete;
                    if (delete != i) {
                        throw new IllegalStateException("Try to delete " + i + ", but deleted " + delete);
                    }
                    a((Cursor) null);
                    return;
                }
                throw new IllegalStateException();
            } catch (Throwable th2) {
                th = th2;
                cursor = rawQuery;
                a(cursor);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static Cursor a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
            return null;
        }
        return null;
    }
}
