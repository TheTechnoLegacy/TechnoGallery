package com.techno.gallery;

public class Util {
    private static final java.lang.String MAPS_CLASS_NAME = "com.google.android.maps.MapsActivity";
    private static final java.lang.String MAPS_PACKAGE_NAME = "com.google.android.apps.maps";
    private static final java.lang.String TAG = "db.Util";
    private static android.view.View.OnClickListener sNullOnClickListener;

    private Util() {
        r0 = this;
        r0.<init>();
        return;
    }

    public static void Assert(boolean r1) {
        if (r1 != 0) goto L_0x0008;
    L_0x0002:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0008:
        return;
    }

    public static void closeSilently(android.os.ParcelFileDescriptor r1) {
        if (r1 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r1.close();	 Catch:{ Throwable -> 0x0007 }
        goto L_0x0002;
    L_0x0007:
        r0 = move-exception;
        goto L_0x0002;
    }

    public static void closeSilently(java.io.Closeable r1) {
        if (r1 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r1.close();	 Catch:{ Throwable -> 0x0007 }
        goto L_0x0002;
    L_0x0007:
        r0 = move-exception;
        goto L_0x0002;
    }

    private static int computeInitialSampleSize(android.graphics.BitmapFactory.Options r12, int r13, int r14) {
        r11 = 1;
        r10 = -1;
        r6 = r12.outWidth;
        r4 = (double) r6;
        r6 = r12.outHeight;
        r0 = (double) r6;
        if (r14 != r10) goto L_0x0014;
    L_0x000a:
        r2 = r11;
    L_0x000b:
        if (r13 != r10) goto L_0x0023;
    L_0x000d:
        r6 = 128; // 0x80 float:1.8E-43 double:6.3E-322;
        r3 = r6;
    L_0x0010:
        if (r3 >= r2) goto L_0x0038;
    L_0x0012:
        r6 = r2;
    L_0x0013:
        return r6;
    L_0x0014:
        r6 = r4 * r0;
        r8 = (double) r14;
        r6 = r6 / r8;
        r6 = java.lang.Math.sqrt(r6);
        r6 = java.lang.Math.ceil(r6);
        r6 = (int) r6;
        r2 = r6;
        goto L_0x000b;
    L_0x0023:
        r6 = (double) r13;
        r6 = r4 / r6;
        r6 = java.lang.Math.floor(r6);
        r8 = (double) r13;
        r8 = r0 / r8;
        r8 = java.lang.Math.floor(r8);
        r6 = java.lang.Math.min(r6, r8);
        r6 = (int) r6;
        r3 = r6;
        goto L_0x0010;
    L_0x0038:
        if (r14 != r10) goto L_0x003e;
    L_0x003a:
        if (r13 != r10) goto L_0x003e;
    L_0x003c:
        r6 = r11;
        goto L_0x0013;
    L_0x003e:
        if (r13 != r10) goto L_0x0042;
    L_0x0040:
        r6 = r2;
        goto L_0x0013;
    L_0x0042:
        r6 = r3;
        goto L_0x0013;
    }

    public static int computeSampleSize(android.graphics.BitmapFactory.Options r3, int r4, int r5) {
        r0 = computeInitialSampleSize(r3, r4, r5);
        r2 = 8;
        if (r0 > r2) goto L_0x000e;
    L_0x0008:
        r1 = 1;
    L_0x0009:
        if (r1 >= r0) goto L_0x0014;
    L_0x000b:
        r1 = r1 << 1;
        goto L_0x0009;
    L_0x000e:
        r2 = r0 + 7;
        r2 = r2 / 8;
        r1 = r2 * 8;
    L_0x0014:
        return r1;
    }

    public static android.graphics.BitmapFactory.Options createNativeAllocOptions() {
        r0 = new android.graphics.BitmapFactory$Options;
        r0.<init>();
        return r0;
    }

    public static android.content.Intent createSetAsIntent(com.techno.gallery.gallery.IImage r4) {
        r1 = r4.fullSizeImageUri();
        r0 = new android.content.Intent;
        r2 = "android.intent.action.ATTACH_DATA";
        r0.<init>(r2);
        r2 = r4.getMimeType();
        r0.setDataAndType(r1, r2);
        r2 = "mimeType";
        r3 = r4.getMimeType();
        r0.putExtra(r2, r3);
        return r0;
    }

    public static android.graphics.Bitmap createVideoThumbnail(java.lang.String r4) {
        r0 = 0;
        r1 = new android.media.MediaMetadataRetriever;
        r1.<init>();
        r2 = 2;
        r1.setDataSource(r4);	 Catch:{ IllegalArgumentException -> 0x0012, RuntimeException -> 0x0019, all -> 0x0020 }
        r0 = r1.getFrameAtTime();	 Catch:{ IllegalArgumentException -> 0x0012, RuntimeException -> 0x0019, all -> 0x0020 }
        r1.release();	 Catch:{ RuntimeException -> 0x0025 }
    L_0x0011:
        return r0;
    L_0x0012:
        r2 = move-exception;
        r1.release();	 Catch:{ RuntimeException -> 0x0017 }
        goto L_0x0011;
    L_0x0017:
        r2 = move-exception;
        goto L_0x0011;
    L_0x0019:
        r2 = move-exception;
        r1.release();	 Catch:{ RuntimeException -> 0x001e }
        goto L_0x0011;
    L_0x001e:
        r2 = move-exception;
        goto L_0x0011;
    L_0x0020:
        r2 = move-exception;
        r1.release();	 Catch:{ RuntimeException -> 0x0027 }
    L_0x0024:
        throw r2;
    L_0x0025:
        r2 = move-exception;
        goto L_0x0011;
    L_0x0027:
        r3 = move-exception;
        goto L_0x0024;
    }

    public static boolean equals(java.lang.String r1, java.lang.String r2) {
        if (r1 == r2) goto L_0x0008;
    L_0x0002:
        r0 = r1.equals(r2);
        if (r0 == 0) goto L_0x000a;
    L_0x0008:
        r0 = 1;
    L_0x0009:
        return r0;
    L_0x000a:
        r0 = 0;
        goto L_0x0009;
    }

    public static android.graphics.Bitmap extractMiniThumb(android.graphics.Bitmap r1, int r2, int r3) {
        r0 = 1;
        r0 = extractMiniThumb(r1, r2, r3, r0);
        return r0;
    }

    public static android.graphics.Bitmap extractMiniThumb(android.graphics.Bitmap r5, int r6, int r7, boolean r8) {
        if (r5 != 0) goto L_0x0004;
    L_0x0002:
        r3 = 0;
    L_0x0003:
        return r3;
    L_0x0004:
        r3 = r5.getWidth();
        r4 = r5.getHeight();
        if (r3 >= r4) goto L_0x002c;
    L_0x000e:
        r3 = (float) r6;
        r4 = r5.getWidth();
        r4 = (float) r4;
        r2 = r3 / r4;
    L_0x0016:
        r0 = new android.graphics.Matrix;
        r0.<init>();
        r0.setScale(r2, r2);
        r3 = 0;
        r1 = transform(r0, r5, r6, r7, r3);
        if (r8 == 0) goto L_0x002a;
    L_0x0025:
        if (r1 == r5) goto L_0x002a;
    L_0x0027:
        r5.recycle();
    L_0x002a:
        r3 = r1;
        goto L_0x0003;
    L_0x002c:
        r3 = (float) r7;
        r4 = r5.getHeight();
        r4 = (float) r4;
        r2 = r3 / r4;
        goto L_0x0016;
    }

    public static synchronized android.view.View.OnClickListener getNullOnClickListener() {
        r0 = com.techno.gallery.Util.class;
        monitor-enter(r0);
        r1 = sNullOnClickListener;	 Catch:{ all -> 0x0012 }
        if (r1 != 0) goto L_0x000e;
    L_0x0007:
        r1 = new com.techno.gallery.Util$1;	 Catch:{ all -> 0x0012 }
        r1.<init>();	 Catch:{ all -> 0x0012 }
        sNullOnClickListener = r1;	 Catch:{ all -> 0x0012 }
    L_0x000e:
        r1 = sNullOnClickListener;	 Catch:{ all -> 0x0012 }
        monitor-exit(r0);
        return r1;
    L_0x0012:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
    }

    public static <T> int indexOf(T[] r2, T r3) {
        r0 = 0;
    L_0x0001:
        r1 = r2.length;
        if (r0 >= r1) goto L_0x0011;
    L_0x0004:
        r1 = r2[r0];
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x000e;
    L_0x000c:
        r1 = r0;
    L_0x000d:
        return r1;
    L_0x000e:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x0011:
        r1 = -1;
        goto L_0x000d;
    }

    public static android.graphics.Bitmap makeBitmap(int r1, int r2, android.net.Uri r3, android.content.ContentResolver r4) {
        r0 = 0;
        r0 = makeBitmap(r1, r2, r3, r4, r0);
        return r0;
    }

    public static android.graphics.Bitmap makeBitmap(int r7, int r8, android.net.Uri r9, android.content.ContentResolver r10, android.os.ParcelFileDescriptor r11, android.graphics.BitmapFactory.Options r12) {
        r5 = -1;
        r6 = 0;
        r0 = 0;
        if (r11 != 0) goto L_0x0009;
    L_0x0005:
        r11 = makeInputStream(r9, r10);	 Catch:{ OutOfMemoryError -> 0x0057 }
    L_0x0009:
        if (r11 != 0) goto L_0x0010;
    L_0x000b:
        closeSilently(r11);
        r4 = r6;
    L_0x000f:
        return r4;
    L_0x0010:
        if (r12 != 0) goto L_0x0018;
    L_0x0012:
        r3 = new android.graphics.BitmapFactory$Options;
        r3.<init>();
        r12 = r3;
    L_0x0018:
        r2 = r11.getFileDescriptor();
        r4 = 1;
        r12.inSampleSize = r4;
        r4 = 1;
        r12.inJustDecodeBounds = r4;
        r4 = com.techno.gallery.BitmapManager.instance();
        r4.decodeFileDescriptor(r2, r12);
        r4 = r12.mCancel;
        if (r4 != 0) goto L_0x0035;
    L_0x002d:
        r4 = r12.outWidth;
        if (r4 == r5) goto L_0x0035;
    L_0x0031:
        r4 = r12.outHeight;
        if (r4 != r5) goto L_0x003a;
    L_0x0035:
        closeSilently(r11);
        r4 = r6;
        goto L_0x000f;
    L_0x003a:
        r4 = computeSampleSize(r12, r7, r8);
        r12.inSampleSize = r4;
        r4 = 0;
        r12.inJustDecodeBounds = r4;
        r4 = 0;
        r12.inDither = r4;
        r4 = android.graphics.Bitmap.Config.ARGB_8888;
        r12.inPreferredConfig = r4;
        r4 = com.techno.gallery.BitmapManager.instance();
        r0 = r4.decodeFileDescriptor(r2, r12);
        closeSilently(r11);
        r4 = r0;
        goto L_0x000f;
    L_0x0057:
        r4 = move-exception;
        r1 = r4;
        r4 = "db.Util";
        r5 = "Got oom exception ";
        android.util.Log.e(r4, r5, r1);	 Catch:{ all -> 0x0065 }
        closeSilently(r11);
        r4 = r6;
        goto L_0x000f;
    L_0x0065:
        r4 = move-exception;
        closeSilently(r11);
        throw r4;
    }

    public static android.graphics.Bitmap makeBitmap(int r7, int r8, android.net.Uri r9, android.content.ContentResolver r10, boolean r11) {
        r4 = 0;
        r0 = "r";
        r4 = r10.openFileDescriptor(r9, r0);	 Catch:{ IOException -> 0x001a, all -> 0x0021 }
        r5 = 0;
        if (r11 == 0) goto L_0x000e;
    L_0x000a:
        r5 = createNativeAllocOptions();	 Catch:{ IOException -> 0x001a, all -> 0x0021 }
    L_0x000e:
        r0 = r7;
        r1 = r8;
        r2 = r9;
        r3 = r10;
        r0 = makeBitmap(r0, r1, r2, r3, r4, r5);	 Catch:{ IOException -> 0x001a, all -> 0x0021 }
        closeSilently(r4);
    L_0x0019:
        return r0;
    L_0x001a:
        r0 = move-exception;
        r6 = r0;
        r0 = 0;
        closeSilently(r4);
        goto L_0x0019;
    L_0x0021:
        r0 = move-exception;
        closeSilently(r4);
        throw r0;
    }

    public static android.graphics.Bitmap makeBitmap(int r6, int r7, android.os.ParcelFileDescriptor r8, boolean r9) {
        r2 = 0;
        r5 = 0;
        if (r9 == 0) goto L_0x0008;
    L_0x0004:
        r5 = createNativeAllocOptions();
    L_0x0008:
        r0 = r6;
        r1 = r7;
        r3 = r2;
        r4 = r8;
        r0 = makeBitmap(r0, r1, r2, r3, r4, r5);
        return r0;
    }

    private static android.os.ParcelFileDescriptor makeInputStream(android.net.Uri r2, android.content.ContentResolver r3) {
        r1 = "r";
        r1 = r3.openFileDescriptor(r2, r1);	 Catch:{ IOException -> 0x0007 }
    L_0x0006:
        return r1;
    L_0x0007:
        r1 = move-exception;
        r0 = r1;
        r1 = 0;
        goto L_0x0006;
    }

    public static byte[] miniThumbData(android.graphics.Bitmap r8) {
        r7 = 0;
        r4 = 96;
        if (r8 != 0) goto L_0x0007;
    L_0x0005:
        r4 = r7;
    L_0x0006:
        return r4;
    L_0x0007:
        r3 = extractMiniThumb(r8, r4, r4);
        r2 = new java.io.ByteArrayOutputStream;
        r2.<init>();
        r4 = android.graphics.Bitmap.CompressFormat.JPEG;
        r5 = 75;
        r3.compress(r4, r5, r2);
        r3.recycle();
        r2.close();	 Catch:{ IOException -> 0x0023 }
        r0 = r2.toByteArray();	 Catch:{ IOException -> 0x0023 }
        r4 = r0;
        goto L_0x0006;
    L_0x0023:
        r4 = move-exception;
        r1 = r4;
        r4 = "db.Util";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "got exception ex ";
        r5 = r5.append(r6);
        r5 = r5.append(r1);
        r5 = r5.toString();
        android.util.Log.e(r4, r5);
        r4 = r7;
        goto L_0x0006;
    }

    public static void openMaps(android.content.Context r12, float r13, float r14) {
        r10 = 2;
        r9 = 1;
        r8 = 0;
        r11 = "android.intent.action.VIEW";
        r4 = "http://maps.google.com/maps?f=q&q=(%s,%s)";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ ActivityNotFoundException -> 0x0038 }
        r6 = 0;
        r7 = java.lang.Float.valueOf(r13);	 Catch:{ ActivityNotFoundException -> 0x0038 }
        r5[r6] = r7;	 Catch:{ ActivityNotFoundException -> 0x0038 }
        r6 = 1;
        r7 = java.lang.Float.valueOf(r14);	 Catch:{ ActivityNotFoundException -> 0x0038 }
        r5[r6] = r7;	 Catch:{ ActivityNotFoundException -> 0x0038 }
        r3 = java.lang.String.format(r4, r5);	 Catch:{ ActivityNotFoundException -> 0x0038 }
        r0 = new android.content.ComponentName;	 Catch:{ ActivityNotFoundException -> 0x0038 }
        r4 = "com.google.android.apps.maps";
        r5 = "com.google.android.maps.MapsActivity";
        r0.<init>(r4, r5);	 Catch:{ ActivityNotFoundException -> 0x0038 }
        r4 = new android.content.Intent;	 Catch:{ ActivityNotFoundException -> 0x0038 }
        r5 = "android.intent.action.VIEW";
        r6 = android.net.Uri.parse(r3);	 Catch:{ ActivityNotFoundException -> 0x0038 }
        r4.<init>(r5, r6);	 Catch:{ ActivityNotFoundException -> 0x0038 }
        r2 = r4.setComponent(r0);	 Catch:{ ActivityNotFoundException -> 0x0038 }
        r12.startActivity(r2);	 Catch:{ ActivityNotFoundException -> 0x0038 }
    L_0x0037:
        return;
    L_0x0038:
        r4 = move-exception;
        r1 = r4;
        r4 = "db.Util";
        r5 = "GMM activity not found!";
        android.util.Log.e(r4, r5, r1);
        r4 = "geo:%s,%s";
        r5 = new java.lang.Object[r10];
        r6 = java.lang.Float.valueOf(r13);
        r5[r8] = r6;
        r6 = java.lang.Float.valueOf(r14);
        r5[r9] = r6;
        r3 = java.lang.String.format(r4, r5);
        r2 = new android.content.Intent;
        r4 = "android.intent.action.VIEW";
        r4 = android.net.Uri.parse(r3);
        r2.<init>(r11, r4);
        r12.startActivity(r2);
        goto L_0x0037;
    }

    public static android.graphics.Bitmap rotate(android.graphics.Bitmap r8, int r9) {
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r9 == 0) goto L_0x0031;
    L_0x0004:
        if (r8 == 0) goto L_0x0031;
    L_0x0006:
        r5 = new android.graphics.Matrix;
        r5.<init>();
        r0 = (float) r9;
        r1 = r8.getWidth();
        r1 = (float) r1;
        r1 = r1 / r3;
        r2 = r8.getHeight();
        r2 = (float) r2;
        r2 = r2 / r3;
        r5.setRotate(r0, r1, r2);
        r1 = 0;
        r2 = 0;
        r3 = r8.getWidth();	 Catch:{ OutOfMemoryError -> 0x0032 }
        r4 = r8.getHeight();	 Catch:{ OutOfMemoryError -> 0x0032 }
        r6 = 1;
        r0 = r8;
        r7 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6);	 Catch:{ OutOfMemoryError -> 0x0032 }
        if (r8 == r7) goto L_0x0031;
    L_0x002d:
        r8.recycle();	 Catch:{ OutOfMemoryError -> 0x0032 }
        r8 = r7;
    L_0x0031:
        return r8;
    L_0x0032:
        r0 = move-exception;
        goto L_0x0031;
    }

    public static void startBackgroundJob(com.techno.gallery.MonitoredActivity r3, java.lang.String r4, java.lang.String r5, java.lang.Runnable r6, android.os.Handler r7) {
        r1 = 1;
        r2 = 0;
        r0 = android.app.ProgressDialog.show(r3, r4, r5, r1, r2);
        r1 = new java.lang.Thread;
        r2 = new com.techno.gallery.Util$BackgroundJob;
        r2.<init>(r3, r6, r0, r7);
        r1.<init>(r2);
        r1.start();
        return;
    }

    public static android.graphics.Bitmap transform(android.graphics.Matrix r7, android.graphics.Bitmap r8, int r9, int r10, boolean r11) {
        r0 = r8.getWidth();
        r0 = r0 - r9;
        r1 = r8.getHeight();
        r1 = r1 - r10;
        if (r11 != 0) goto L_0x005c;
    L_0x000c:
        if (r0 < 0) goto L_0x0010;
    L_0x000e:
        if (r1 >= 0) goto L_0x005c;
    L_0x0010:
        r7 = android.graphics.Bitmap.Config.ARGB_8888;
        r7 = android.graphics.Bitmap.createBitmap(r9, r10, r7);
        r11 = new android.graphics.Canvas;
        r11.<init>(r7);
        r2 = 0;
        r0 = r0 / 2;
        r0 = java.lang.Math.max(r2, r0);
        r2 = 0;
        r1 = r1 / 2;
        r1 = java.lang.Math.max(r2, r1);
        r3 = new android.graphics.Rect;
        r2 = r8.getWidth();
        r2 = java.lang.Math.min(r9, r2);
        r2 = r2 + r0;
        r4 = r8.getHeight();
        r4 = java.lang.Math.min(r10, r4);
        r4 = r4 + r1;
        r3.<init>(r0, r1, r2, r4);
        r0 = r3.width();
        r0 = r9 - r0;
        r1 = r0 / 2;
        r0 = r3.height();
        r0 = r10 - r0;
        r2 = r0 / 2;
        r0 = new android.graphics.Rect;
        r9 = r9 - r1;
        r10 = r10 - r2;
        r0.<init>(r1, r2, r9, r10);
        r9 = 0;
        r11.drawBitmap(r8, r3, r0, r9);
    L_0x005b:
        return r7;
    L_0x005c:
        r11 = r8.getWidth();
        r1 = (float) r11;
        r11 = r8.getHeight();
        r0 = (float) r11;
        r11 = r1 / r0;
        r2 = (float) r9;
        r3 = (float) r10;
        r2 = r2 / r3;
        r11 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1));
        if (r11 <= 0) goto L_0x00b9;
    L_0x006f:
        r11 = (float) r10;
        r11 = r11 / r0;
        r0 = 1063675494; // 0x3f666666 float:0.9 double:5.2552552E-315;
        r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1));
        if (r0 < 0) goto L_0x007e;
    L_0x0078:
        r0 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x00b7;
    L_0x007e:
        r7.setScale(r11, r11);
    L_0x0081:
        if (r7 == 0) goto L_0x00ce;
    L_0x0083:
        r1 = 0;
        r2 = 0;
        r3 = r8.getWidth();
        r4 = r8.getHeight();
        r6 = 1;
        r0 = r8;
        r5 = r7;
        r7 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6);
    L_0x0094:
        r11 = 0;
        r0 = r7.getWidth();
        r0 = r0 - r9;
        r11 = java.lang.Math.max(r11, r0);
        r0 = 0;
        r1 = r7.getHeight();
        r1 = r1 - r10;
        r0 = java.lang.Math.max(r0, r1);
        r11 = r11 / 2;
        r0 = r0 / 2;
        r9 = android.graphics.Bitmap.createBitmap(r7, r11, r0, r9, r10);
        if (r7 == r8) goto L_0x00b5;
    L_0x00b2:
        r7.recycle();
    L_0x00b5:
        r7 = r9;
        goto L_0x005b;
    L_0x00b7:
        r7 = 0;
        goto L_0x0081;
    L_0x00b9:
        r11 = (float) r9;
        r11 = r11 / r1;
        r0 = 1063675494; // 0x3f666666 float:0.9 double:5.2552552E-315;
        r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1));
        if (r0 < 0) goto L_0x00c8;
    L_0x00c2:
        r0 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x00cc;
    L_0x00c8:
        r7.setScale(r11, r11);
        goto L_0x0081;
    L_0x00cc:
        r7 = 0;
        goto L_0x0081;
    L_0x00ce:
        r7 = r8;
        goto L_0x0094;
    }
}