package com.techno.gallery;

class ImageManager$AddImageCancelable extends com.techno.gallery.gallery.BaseCancelable<java.lang.Void> {
    private final android.content.ContentResolver mCr;
    private final byte[] mJpegData;
    private final int mOrientation;
    private final android.graphics.Bitmap mSource;
    private final android.net.Uri mUri;

    public ImageManager$AddImageCancelable(android.net.Uri r3, android.content.ContentResolver r4, int r5, android.graphics.Bitmap r6, byte[] r7) {
        r2 = this;
        r2.<init>();
        if (r6 != 0) goto L_0x0007;
    L_0x0005:
        if (r7 == 0) goto L_0x0009;
    L_0x0007:
        if (r3 != 0) goto L_0x0011;
    L_0x0009:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "source cannot be null";
        r0.<init>(r1);
        throw r0;
    L_0x0011:
        r2.mUri = r3;
        r2.mCr = r4;
        r2.mOrientation = r5;
        r2.mSource = r6;
        r2.mJpegData = r7;
        return;
    }

    protected /* bridge */ /* synthetic */ java.lang.Object execute() throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        r1 = this;
        r0 = r1.execute();
        return r0;
    }

    protected java.lang.Object execute() {
        r24 = this;
        r22 = 0;
        r0 = r24;
        r0 = r0.mUri;	 Catch:{ all -> 0x00d1 }
        r7 = r0;
        r8 = android.content.ContentUris.parseId(r7);	 Catch:{ all -> 0x00d1 }
        r6 = new com.techno.gallery.gallery.ImageList;	 Catch:{ all -> 0x00d1 }
        r7 = com.techno.gallery.ImageManager.access$000();	 Catch:{ all -> 0x00d1 }
        r10 = com.techno.gallery.ImageManager.access$100();	 Catch:{ all -> 0x00d1 }
        r11 = 1;
        r12 = 0;
        r6.<init>(r7, r10, r11, r12);	 Catch:{ all -> 0x00d1 }
        r0 = r24;
        r0 = r0.mCr;	 Catch:{ all -> 0x00d1 }
        r7 = r0;
        r6.open(r7);	 Catch:{ all -> 0x00d1 }
        r5 = new com.techno.gallery.gallery.Image;	 Catch:{ all -> 0x00d1 }
        r0 = r24;
        r0 = r0.mCr;	 Catch:{ all -> 0x00d1 }
        r7 = r0;
        r10 = 0;
        r11 = r6.contentUri(r8);	 Catch:{ all -> 0x00d1 }
        r12 = 0;
        r13 = 0;
        r15 = 0;
        r16 = 0;
        r18 = 0;
        r19 = 0;
        r20 = 0;
        r5.<init>(r6, r7, r8, r10, r11, r12, r13, r15, r16, r18, r19, r20);	 Catch:{ all -> 0x00d1 }
        r7 = 3;
        r12 = new java.lang.String[r7];	 Catch:{ all -> 0x00d1 }
        r7 = 0;
        r8 = "_id";
        r12[r7] = r8;	 Catch:{ all -> 0x00d1 }
        r7 = 1;
        r8 = "mini_thumb_magic";
        r12[r7] = r8;	 Catch:{ all -> 0x00d1 }
        r7 = 2;
        r8 = "_data";
        r12[r7] = r8;	 Catch:{ all -> 0x00d1 }
        r0 = r24;
        r0 = r0.mCr;	 Catch:{ all -> 0x00d1 }
        r10 = r0;
        r0 = r24;
        r0 = r0.mUri;	 Catch:{ all -> 0x00d1 }
        r11 = r0;
        r13 = 0;
        r14 = 0;
        r15 = 0;
        r21 = r10.query(r11, r12, r13, r14, r15);	 Catch:{ all -> 0x00d1 }
        r7 = 0;
        r0 = r21;
        r1 = r7;
        r0.moveToPosition(r1);	 Catch:{ all -> 0x00cc }
        r7 = 2;
        r0 = r21;
        r1 = r7;
        r18 = r0.getString(r1);	 Catch:{ all -> 0x00cc }
        r21.close();
        r0 = r24;
        r0 = r0.mSource;
        r14 = r0;
        r0 = r24;
        r0 = r0.mJpegData;
        r15 = r0;
        r0 = r24;
        r0 = r0.mOrientation;
        r16 = r0;
        r17 = 1;
        r13 = r5;
        r7 = r13.saveImageContents(r14, r15, r16, r17, r18);
        r0 = r24;
        r1 = r7;
        r0.runSubTask(r1);
        r23 = new android.content.ContentValues;
        r23.<init>();
        r7 = "mini_thumb_magic";
        r8 = 0;
        r8 = java.lang.Integer.valueOf(r8);
        r0 = r23;
        r1 = r7;
        r2 = r8;
        r0.put(r1, r2);
        r0 = r24;
        r0 = r0.mCr;
        r7 = r0;
        r0 = r24;
        r0 = r0.mUri;
        r8 = r0;
        r9 = 0;
        r10 = 0;
        r0 = r7;
        r1 = r8;
        r2 = r23;
        r3 = r9;
        r4 = r10;
        r0.update(r1, r2, r3, r4);
        r22 = 1;
        r7 = 0;
        if (r22 != 0) goto L_0x00cb;
    L_0x00bc:
        r0 = r24;
        r0 = r0.mCr;	 Catch:{ Throwable -> 0x00e6 }
        r8 = r0;
        r0 = r24;
        r0 = r0.mUri;	 Catch:{ Throwable -> 0x00e6 }
        r9 = r0;
        r10 = 0;
        r11 = 0;
        r8.delete(r9, r10, r11);	 Catch:{ Throwable -> 0x00e6 }
    L_0x00cb:
        return r7;
    L_0x00cc:
        r7 = move-exception;
        r21.close();
        throw r7;
    L_0x00d1:
        r7 = move-exception;
        if (r22 != 0) goto L_0x00e3;
    L_0x00d4:
        r0 = r24;
        r0 = r0.mCr;	 Catch:{ Throwable -> 0x00e4 }
        r8 = r0;
        r0 = r24;
        r0 = r0.mUri;	 Catch:{ Throwable -> 0x00e4 }
        r9 = r0;
        r10 = 0;
        r11 = 0;
        r8.delete(r9, r10, r11);	 Catch:{ Throwable -> 0x00e4 }
    L_0x00e3:
        throw r7;
    L_0x00e4:
        r8 = move-exception;
        goto L_0x00e3;
    L_0x00e6:
        r8 = move-exception;
        goto L_0x00cb;
    }
}