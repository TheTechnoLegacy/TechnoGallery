package com.techno.gallery.gallery;

class UriImage implements com.techno.gallery.gallery.IImage {
    private static final java.lang.String TAG = "UriImage";
    private final com.techno.gallery.gallery.BaseImageList mContainer;
    private final android.content.ContentResolver mContentResolver;
    private final android.net.Uri mUri;

    UriImage(com.techno.gallery.gallery.BaseImageList r1, android.content.ContentResolver r2, android.net.Uri r3) {
        r0 = this;
        r0.<init>();
        r0.mContainer = r1;
        r0.mContentResolver = r2;
        r0.mUri = r3;
        return;
    }

    private java.io.InputStream getInputStream() {
        r4 = this;
        r2 = r4.mUri;	 Catch:{ FileNotFoundException -> 0x0029 }
        r2 = r2.getScheme();	 Catch:{ FileNotFoundException -> 0x0029 }
        r3 = "file";
        r2 = r2.equals(r3);	 Catch:{ FileNotFoundException -> 0x0029 }
        if (r2 == 0) goto L_0x0020;
    L_0x000e:
        r2 = r4.mUri;	 Catch:{ FileNotFoundException -> 0x0029 }
        r1 = r2.getPath();	 Catch:{ FileNotFoundException -> 0x0029 }
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0029 }
        r3 = r4.mUri;	 Catch:{ FileNotFoundException -> 0x0029 }
        r3 = r3.getPath();	 Catch:{ FileNotFoundException -> 0x0029 }
        r2.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0029 }
    L_0x001f:
        return r2;
    L_0x0020:
        r2 = r4.mContentResolver;	 Catch:{ FileNotFoundException -> 0x0029 }
        r3 = r4.mUri;	 Catch:{ FileNotFoundException -> 0x0029 }
        r2 = r2.openInputStream(r3);	 Catch:{ FileNotFoundException -> 0x0029 }
        goto L_0x001f;
    L_0x0029:
        r2 = move-exception;
        r0 = r2;
        r2 = 0;
        goto L_0x001f;
    }

    private android.os.ParcelFileDescriptor getPFD() {
        r5 = this;
        r2 = r5.mUri;	 Catch:{ FileNotFoundException -> 0x002b }
        r2 = r2.getScheme();	 Catch:{ FileNotFoundException -> 0x002b }
        r3 = "file";
        r2 = r2.equals(r3);	 Catch:{ FileNotFoundException -> 0x002b }
        if (r2 == 0) goto L_0x0020;
    L_0x000e:
        r2 = r5.mUri;	 Catch:{ FileNotFoundException -> 0x002b }
        r1 = r2.getPath();	 Catch:{ FileNotFoundException -> 0x002b }
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x002b }
        r2.<init>(r1);	 Catch:{ FileNotFoundException -> 0x002b }
        r3 = 268435456; // 0x10000000 float:2.524355E-29 double:1.32624737E-315;
        r2 = android.os.ParcelFileDescriptor.open(r2, r3);	 Catch:{ FileNotFoundException -> 0x002b }
    L_0x001f:
        return r2;
    L_0x0020:
        r2 = r5.mContentResolver;	 Catch:{ FileNotFoundException -> 0x002b }
        r3 = r5.mUri;	 Catch:{ FileNotFoundException -> 0x002b }
        r4 = "r";
        r2 = r2.openFileDescriptor(r3, r4);	 Catch:{ FileNotFoundException -> 0x002b }
        goto L_0x001f;
    L_0x002b:
        r2 = move-exception;
        r0 = r2;
        r2 = 0;
        goto L_0x001f;
    }

    private android.graphics.BitmapFactory.Options snifBitmapOptions() {
        r4 = this;
        r0 = r4.getPFD();
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        r2 = 0;
    L_0x0007:
        return r2;
    L_0x0008:
        r1 = new android.graphics.BitmapFactory$Options;	 Catch:{ all -> 0x0020 }
        r1.<init>();	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r1.inJustDecodeBounds = r2;	 Catch:{ all -> 0x0020 }
        r2 = com.techno.gallery.BitmapManager.instance();	 Catch:{ all -> 0x0020 }
        r3 = r0.getFileDescriptor();	 Catch:{ all -> 0x0020 }
        r2.decodeFileDescriptor(r3, r1);	 Catch:{ all -> 0x0020 }
        com.techno.gallery.Util.closeSilently(r0);
        r2 = r1;
        goto L_0x0007;
    L_0x0020:
        r2 = move-exception;
        com.techno.gallery.Util.closeSilently(r0);
        throw r2;
    }

    public android.graphics.Bitmap fullSizeBitmap(int r3, int r4) {
        r2 = this;
        r0 = 1;
        r1 = 0;
        r0 = r2.fullSizeBitmap(r3, r4, r0, r1);
        return r0;
    }

    public android.graphics.Bitmap fullSizeBitmap(int r2, int r3, boolean r4) {
        r1 = this;
        r0 = 0;
        r0 = r1.fullSizeBitmap(r2, r3, r4, r0);
        return r0;
    }

    public android.graphics.Bitmap fullSizeBitmap(int r6, int r7, boolean r8, boolean r9) {
        r5 = this;
        r2 = r5.getPFD();	 Catch:{ Exception -> 0x000a }
        r0 = com.techno.gallery.Util.makeBitmap(r6, r7, r2, r9);	 Catch:{ Exception -> 0x000a }
        r3 = r0;
    L_0x0009:
        return r3;
    L_0x000a:
        r3 = move-exception;
        r1 = r3;
        r3 = "UriImage";
        r4 = "got exception decoding bitmap ";
        android.util.Log.e(r3, r4, r1);
        r3 = 0;
        goto L_0x0009;
    }

    public java.io.InputStream fullSizeImageData() {
        r1 = this;
        r0 = r1.getInputStream();
        return r0;
    }

    public long fullSizeImageId() {
        r2 = this;
        r0 = 0;
        return r0;
    }

    public android.net.Uri fullSizeImageUri() {
        r1 = this;
        r0 = r1.mUri;
        return r0;
    }

    public com.techno.gallery.gallery.IImageList getContainer() {
        r1 = this;
        r0 = r1.mContainer;
        return r0;
    }

    public java.lang.String getDataPath() {
        r1 = this;
        r0 = r1.mUri;
        r0 = r0.getPath();
        return r0;
    }

    public long getDateTaken() {
        r2 = this;
        r0 = 0;
        return r0;
    }

    public int getDegreesRotated() {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public java.lang.String getDisplayName() {
        r1 = this;
        r0 = r1.getTitle();
        return r0;
    }

    public int getHeight() {
        r2 = this;
        r0 = r2.snifBitmapOptions();
        if (r0 == 0) goto L_0x0009;
    L_0x0006:
        r1 = r0.outHeight;
    L_0x0008:
        return r1;
    L_0x0009:
        r1 = 0;
        goto L_0x0008;
    }

    public java.lang.String getMimeType() {
        r2 = this;
        r0 = r2.snifBitmapOptions();
        if (r0 == 0) goto L_0x000d;
    L_0x0006:
        r1 = r0.outMimeType;
        if (r1 == 0) goto L_0x000d;
    L_0x000a:
        r1 = r0.outMimeType;
    L_0x000c:
        return r1;
    L_0x000d:
        r1 = "";
        goto L_0x000c;
    }

    public java.lang.String getTitle() {
        r1 = this;
        r0 = r1.mUri;
        r0 = r0.toString();
        return r0;
    }

    public int getWidth() {
        r2 = this;
        r0 = r2.snifBitmapOptions();
        if (r0 == 0) goto L_0x0009;
    L_0x0006:
        r1 = r0.outWidth;
    L_0x0008:
        return r1;
    L_0x0009:
        r1 = 0;
        goto L_0x0008;
    }

    public boolean isDrm() {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public boolean isReadonly() {
        r1 = this;
        r0 = 1;
        return r0;
    }

    public android.graphics.Bitmap miniThumbBitmap() {
        r1 = this;
        r0 = 1;
        r0 = r1.thumbBitmap(r0);
        return r0;
    }

    public boolean rotateImageBy(int r2) {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public void setTitle(java.lang.String r2) {
        r1 = this;
        r0 = new java.lang.UnsupportedOperationException;
        r0.<init>();
        throw r0;
    }

    public android.graphics.Bitmap thumbBitmap(boolean r3) {
        r2 = this;
        r0 = 320; // 0x140 float:4.48E-43 double:1.58E-321;
        r1 = 196608; // 0x30000 float:2.75506E-40 double:9.71373E-319;
        r0 = r2.fullSizeBitmap(r0, r1, r3);
        return r0;
    }

    public android.net.Uri thumbUri() {
        r1 = this;
        r0 = new java.lang.UnsupportedOperationException;
        r0.<init>();
        throw r0;
    }
}