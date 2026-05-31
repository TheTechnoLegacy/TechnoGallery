package com.techno.gallery;

class PhotoAppWidgetProvider$PhotoDatabaseHelper extends android.database.sqlite.SQLiteOpenHelper {
    private static final java.lang.String DATABASE_NAME = "launcher.db";
    private static final int DATABASE_VERSION = 2;
    static final java.lang.String FIELD_APPWIDGET_ID = "appWidgetId";
    static final java.lang.String FIELD_PHOTO_BLOB = "photoBlob";
    static final int INDEX_PHOTO_BLOB = 0;
    static final java.lang.String[] PHOTOS_PROJECTION = null;
    static final java.lang.String TABLE_PHOTOS = "photos";

    static {
        r0 = 1;
        r0 = new java.lang.String[r0];
        r1 = 0;
        r2 = "photoBlob";
        r0[r1] = r2;
        PHOTOS_PROJECTION = r0;
        return;
    }

    PhotoAppWidgetProvider$PhotoDatabaseHelper(android.content.Context r4) {
        r3 = this;
        r0 = "launcher.db";
        r1 = 0;
        r2 = 2;
        r3.<init>(r4, r0, r1, r2);
        return;
    }

    public void deletePhoto(int r8) {
        r7 = this;
        r0 = r7.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0020 }
        r3 = "%s=%d";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ SQLiteException -> 0x0020 }
        r5 = 0;
        r6 = "appWidgetId";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0020 }
        r5 = 1;
        r6 = java.lang.Integer.valueOf(r8);	 Catch:{ SQLiteException -> 0x0020 }
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0020 }
        r2 = java.lang.String.format(r3, r4);	 Catch:{ SQLiteException -> 0x0020 }
        r3 = "photos";
        r4 = 0;
        r0.delete(r3, r2, r4);	 Catch:{ SQLiteException -> 0x0020 }
    L_0x001f:
        return;
    L_0x0020:
        r3 = move-exception;
        r1 = r3;
        r3 = "PhotoAppWidgetProvider";
        r4 = "Could not delete photo from database";
        android.util.Log.e(r3, r4, r1);
        goto L_0x001f;
    }

    public android.graphics.Bitmap getPhoto(int r14) {
        r13 = this;
        r1 = "PhotoAppWidgetProvider";
        r10 = 0;
        r9 = 0;
        r0 = r13.getReadableDatabase();	 Catch:{ SQLiteException -> 0x0063 }
        r1 = "%s=%d";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ SQLiteException -> 0x0063 }
        r4 = 0;
        r5 = "appWidgetId";
        r2[r4] = r5;	 Catch:{ SQLiteException -> 0x0063 }
        r4 = 1;
        r5 = java.lang.Integer.valueOf(r14);	 Catch:{ SQLiteException -> 0x0063 }
        r2[r4] = r5;	 Catch:{ SQLiteException -> 0x0063 }
        r3 = java.lang.String.format(r1, r2);	 Catch:{ SQLiteException -> 0x0063 }
        r1 = "photos";
        r2 = PHOTOS_PROJECTION;	 Catch:{ SQLiteException -> 0x0063 }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r10 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x0063 }
        if (r10 == 0) goto L_0x0048;
    L_0x002c:
        r1 = "PhotoAppWidgetProvider";
        r2 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0063 }
        r2.<init>();	 Catch:{ SQLiteException -> 0x0063 }
        r4 = "getPhoto query count=";
        r2 = r2.append(r4);	 Catch:{ SQLiteException -> 0x0063 }
        r4 = r10.getCount();	 Catch:{ SQLiteException -> 0x0063 }
        r2 = r2.append(r4);	 Catch:{ SQLiteException -> 0x0063 }
        r2 = r2.toString();	 Catch:{ SQLiteException -> 0x0063 }
        android.util.Log.d(r1, r2);	 Catch:{ SQLiteException -> 0x0063 }
    L_0x0048:
        if (r10 == 0) goto L_0x005d;
    L_0x004a:
        r1 = r10.moveToFirst();	 Catch:{ SQLiteException -> 0x0063 }
        if (r1 == 0) goto L_0x005d;
    L_0x0050:
        r1 = 0;
        r11 = r10.getBlob(r1);	 Catch:{ SQLiteException -> 0x0063 }
        if (r11 == 0) goto L_0x005d;
    L_0x0057:
        r1 = 0;
        r2 = r11.length;	 Catch:{ SQLiteException -> 0x0063 }
        r9 = android.graphics.BitmapFactory.decodeByteArray(r11, r1, r2);	 Catch:{ SQLiteException -> 0x0063 }
    L_0x005d:
        if (r10 == 0) goto L_0x0062;
    L_0x005f:
        r10.close();
    L_0x0062:
        return r9;
    L_0x0063:
        r1 = move-exception;
        r12 = r1;
        r1 = "PhotoAppWidgetProvider";
        r2 = "Could not load photo from database";
        android.util.Log.e(r1, r2, r12);	 Catch:{ all -> 0x0072 }
        if (r10 == 0) goto L_0x0062;
    L_0x006e:
        r10.close();
        goto L_0x0062;
    L_0x0072:
        r1 = move-exception;
        if (r10 == 0) goto L_0x0078;
    L_0x0075:
        r10.close();
    L_0x0078:
        throw r1;
    }

    public void onCreate(android.database.sqlite.SQLiteDatabase r2) {
        r1 = this;
        r0 = "CREATE TABLE photos (appWidgetId INTEGER PRIMARY KEY,photoBlob BLOB);";
        r2.execSQL(r0);
        return;
    }

    public void onUpgrade(android.database.sqlite.SQLiteDatabase r4, int r5, int r6) {
        r3 = this;
        r0 = r5;
        r1 = 2;
        if (r0 == r1) goto L_0x0013;
    L_0x0004:
        r1 = "PhotoAppWidgetProvider";
        r2 = "Destroying all old data.";
        android.util.Log.w(r1, r2);
        r1 = "DROP TABLE IF EXISTS photos";
        r4.execSQL(r1);
        r3.onCreate(r4);
    L_0x0013:
        return;
    }

    public boolean setPhoto(int r10, android.graphics.Bitmap r11) {
        r9 = this;
        r8 = "PhotoAppWidgetProvider";
        r4 = 0;
        r6 = r11.getWidth();	 Catch:{ SQLiteException -> 0x005b, IOException -> 0x0065 }
        r7 = r11.getHeight();	 Catch:{ SQLiteException -> 0x005b, IOException -> 0x0065 }
        r6 = r6 * r7;
        r3 = r6 * 4;
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ SQLiteException -> 0x005b, IOException -> 0x0065 }
        r2.<init>(r3);	 Catch:{ SQLiteException -> 0x005b, IOException -> 0x0065 }
        r6 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ SQLiteException -> 0x005b, IOException -> 0x0065 }
        r7 = 100;
        r11.compress(r6, r7, r2);	 Catch:{ SQLiteException -> 0x005b, IOException -> 0x0065 }
        r2.flush();	 Catch:{ SQLiteException -> 0x005b, IOException -> 0x0065 }
        r2.close();	 Catch:{ SQLiteException -> 0x005b, IOException -> 0x0065 }
        r5 = new android.content.ContentValues;	 Catch:{ SQLiteException -> 0x005b, IOException -> 0x0065 }
        r5.<init>();	 Catch:{ SQLiteException -> 0x005b, IOException -> 0x0065 }
        r6 = "appWidgetId";
        r7 = java.lang.Integer.valueOf(r10);	 Catch:{ SQLiteException -> 0x005b, IOException -> 0x0065 }
        r5.put(r6, r7);	 Catch:{ SQLiteException -> 0x005b, IOException -> 0x0065 }
        r6 = "photoBlob";
        r7 = r2.toByteArray();	 Catch:{ SQLiteException -> 0x005b, IOException -> 0x0065 }
        r5.put(r6, r7);	 Catch:{ SQLiteException -> 0x005b, IOException -> 0x0065 }
        r0 = r9.getWritableDatabase();	 Catch:{ SQLiteException -> 0x005b, IOException -> 0x0065 }
        r6 = "photos";
        r7 = 0;
        r0.insertOrThrow(r6, r7, r5);	 Catch:{ SQLiteException -> 0x005b, IOException -> 0x0065 }
        r4 = 1;
    L_0x0042:
        r6 = "PhotoAppWidgetProvider";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "setPhoto success=";
        r6 = r6.append(r7);
        r6 = r6.append(r4);
        r6 = r6.toString();
        android.util.Log.d(r8, r6);
        return r4;
    L_0x005b:
        r6 = move-exception;
        r1 = r6;
        r6 = "PhotoAppWidgetProvider";
        r6 = "Could not open database";
        android.util.Log.e(r8, r6, r1);
        goto L_0x0042;
    L_0x0065:
        r6 = move-exception;
        r1 = r6;
        r6 = "PhotoAppWidgetProvider";
        r6 = "Could not serialize photo";
        android.util.Log.e(r8, r6, r1);
        goto L_0x0042;
    }
}