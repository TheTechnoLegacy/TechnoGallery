package com.techno.gallery.gallery;

public abstract class BaseImage implements com.techno.gallery.gallery.IImage {
    private static final java.lang.String TAG = "BaseImage";
    private static final int UNKNOWN_LENGTH = -1;
    private static final byte[] sMiniThumbData = null;
    protected com.techno.gallery.gallery.BaseImageList mContainer;
    protected android.content.ContentResolver mContentResolver;
    protected java.lang.String mDataPath;
    private final long mDateTaken;
    private final java.lang.String mDisplayName;
    private int mHeight;
    protected long mId;
    protected final int mIndex;
    protected java.lang.String mMimeType;
    protected long mMiniThumbMagic;
    private java.lang.String mTitle;
    protected android.net.Uri mUri;
    private int mWidth;

    static {
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0 = new byte[r0];
        sMiniThumbData = r0;
        return;
    }

    protected BaseImage(com.techno.gallery.gallery.BaseImageList r2, android.content.ContentResolver r3, long r4, int r6, android.net.Uri r7, java.lang.String r8, long r9, java.lang.String r11, long r12, java.lang.String r14, java.lang.String r15) {
        r1 = this;
        r0 = -1;
        r1.<init>();
        r1.mWidth = r0;
        r1.mHeight = r0;
        r1.mContainer = r2;
        r1.mContentResolver = r3;
        r1.mId = r4;
        r1.mIndex = r6;
        r1.mUri = r7;
        r1.mDataPath = r8;
        r1.mMiniThumbMagic = r9;
        r1.mMimeType = r11;
        r1.mDateTaken = r12;
        r1.mTitle = r14;
        r1.mDisplayName = r15;
        return;
    }

    private void setupDimension() {
        r6 = this;
        r1 = 0;
        r3 = r6.mContentResolver;	 Catch:{ FileNotFoundException -> 0x002a }
        r4 = r6.mUri;	 Catch:{ FileNotFoundException -> 0x002a }
        r5 = "r";
        r1 = r3.openFileDescriptor(r4, r5);	 Catch:{ FileNotFoundException -> 0x002a }
        r2 = new android.graphics.BitmapFactory$Options;	 Catch:{ FileNotFoundException -> 0x002a }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x002a }
        r3 = 1;
        r2.inJustDecodeBounds = r3;	 Catch:{ FileNotFoundException -> 0x002a }
        r3 = com.techno.gallery.BitmapManager.instance();	 Catch:{ FileNotFoundException -> 0x002a }
        r4 = r1.getFileDescriptor();	 Catch:{ FileNotFoundException -> 0x002a }
        r3.decodeFileDescriptor(r4, r2);	 Catch:{ FileNotFoundException -> 0x002a }
        r3 = r2.outWidth;	 Catch:{ FileNotFoundException -> 0x002a }
        r6.mWidth = r3;	 Catch:{ FileNotFoundException -> 0x002a }
        r3 = r2.outHeight;	 Catch:{ FileNotFoundException -> 0x002a }
        r6.mHeight = r3;	 Catch:{ FileNotFoundException -> 0x002a }
        com.techno.gallery.Util.closeSilently(r1);
    L_0x0029:
        return;
    L_0x002a:
        r3 = move-exception;
        r0 = r3;
        r3 = 0;
        r6.mWidth = r3;	 Catch:{ all -> 0x0036 }
        r3 = 0;
        r6.mHeight = r3;	 Catch:{ all -> 0x0036 }
        com.techno.gallery.Util.closeSilently(r1);
        goto L_0x0029;
    L_0x0036:
        r3 = move-exception;
        com.techno.gallery.Util.closeSilently(r1);
        throw r3;
    }

    protected com.techno.gallery.gallery.Cancelable<java.lang.Boolean> compressImageToFile(android.graphics.Bitmap r2, byte[] r3, android.net.Uri r4) {
        r1 = this;
        r0 = new com.techno.gallery.gallery.BaseImage$CompressImageToFile;
        r0.<init>(r1, r2, r3, r4);
        return r0;
    }

    protected abstract android.graphics.Bitmap.CompressFormat compressionType();

    public boolean equals(java.lang.Object r3) {
        r2 = this;
        if (r3 == 0) goto L_0x0006;
    L_0x0002:
        r0 = r3 instanceof com.techno.gallery.gallery.Image;
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        r0 = 0;
    L_0x0007:
        return r0;
    L_0x0008:
        r0 = r2.mUri;
        r3 = (com.techno.gallery.gallery.Image) r3;
        r1 = r3.mUri;
        r0 = r0.equals(r1);
        goto L_0x0007;
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
        r2 = r5.mContainer;
        r3 = r5.mId;
        r1 = r2.contentUri(r3);
        if (r1 != 0) goto L_0x000c;
    L_0x000a:
        r2 = 0;
    L_0x000b:
        return r2;
    L_0x000c:
        r2 = r5.mContentResolver;
        r0 = com.techno.gallery.Util.makeBitmap(r6, r7, r1, r2, r9);
        if (r0 == 0) goto L_0x001e;
    L_0x0014:
        if (r8 == 0) goto L_0x001e;
    L_0x0016:
        r2 = r5.getDegreesRotated();
        r0 = com.techno.gallery.Util.rotate(r0, r2);
    L_0x001e:
        r2 = r0;
        goto L_0x000b;
    }

    public java.io.InputStream fullSizeImageData() {
        r4 = this;
        r2 = r4.mContentResolver;	 Catch:{ IOException -> 0x000a }
        r3 = r4.mUri;	 Catch:{ IOException -> 0x000a }
        r1 = r2.openInputStream(r3);	 Catch:{ IOException -> 0x000a }
        r2 = r1;
    L_0x0009:
        return r2;
    L_0x000a:
        r2 = move-exception;
        r0 = r2;
        r2 = 0;
        goto L_0x0009;
    }

    public long fullSizeImageId() {
        r2 = this;
        r0 = r2.mId;
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
        r0 = r1.mDataPath;
        return r0;
    }

    public long getDateTaken() {
        r2 = this;
        r0 = r2.mDateTaken;
        return r0;
    }

    public int getDegreesRotated() {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public java.lang.String getDisplayName() {
        r1 = this;
        r0 = r1.mDisplayName;
        return r0;
    }

    public int getHeight() {
        r2 = this;
        r0 = r2.mHeight;
        r1 = -1;
        if (r0 != r1) goto L_0x0008;
    L_0x0005:
        r2.setupDimension();
    L_0x0008:
        r0 = r2.mHeight;
        return r0;
    }

    public java.lang.String getMimeType() {
        r1 = this;
        r0 = r1.mMimeType;
        return r0;
    }

    public java.lang.String getTitle() {
        r1 = this;
        r0 = r1.mTitle;
        return r0;
    }

    public int getWidth() {
        r2 = this;
        r0 = r2.mWidth;
        r1 = -1;
        if (r0 != r1) goto L_0x0008;
    L_0x0005:
        r2.setupDimension();
    L_0x0008:
        r0 = r2.mWidth;
        return r0;
    }

    public int hashCode() {
        r1 = this;
        r0 = r1.mUri;
        r0 = r0.hashCode();
        return r0;
    }

    public android.graphics.Bitmap miniThumbBitmap() {
        r15 = this;
        r13 = 0;
        r14 = "BaseImage";
        r1 = r15.mId;	 Catch:{ Throwable -> 0x005a }
        r10 = sMiniThumbData;	 Catch:{ Throwable -> 0x005a }
        monitor-enter(r10);	 Catch:{ Throwable -> 0x005a }
        r8 = 0;
        r3 = r15.mMiniThumbMagic;	 Catch:{ all -> 0x0057 }
        r11 = 0;
        r0 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1));
        if (r0 == 0) goto L_0x001b;
    L_0x0011:
        r0 = r15.mContainer;	 Catch:{ all -> 0x0057 }
        r3 = sMiniThumbData;	 Catch:{ all -> 0x0057 }
        r4 = r15.mMiniThumbMagic;	 Catch:{ all -> 0x0057 }
        r8 = r0.getMiniThumbFromFile(r1, r3, r4);	 Catch:{ all -> 0x0057 }
    L_0x001b:
        if (r8 != 0) goto L_0x002c;
    L_0x001d:
        r0 = 1;
        r7 = new byte[r0][];	 Catch:{ all -> 0x0057 }
        r0 = r15.getContainer();	 Catch:{ IOException -> 0x0065 }
        r0 = (com.techno.gallery.gallery.BaseImageList) r0;	 Catch:{ IOException -> 0x0065 }
        r0.checkThumbnail(r15, r7);	 Catch:{ IOException -> 0x0065 }
    L_0x0029:
        r0 = 0;
        r8 = r7[r0];
    L_0x002c:
        if (r8 != 0) goto L_0x002e;
    L_0x002e:
        if (r8 == 0) goto L_0x0054;
    L_0x0030:
        r0 = 0;
        r3 = r8.length;
        r6 = android.graphics.BitmapFactory.decodeByteArray(r8, r0, r3);
        if (r6 != 0) goto L_0x0051;
    L_0x0038:
        r0 = "BaseImage";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "couldn't decode byte array, length was ";
        r3 = r3.append(r4);
        r4 = r8.length;
        r3 = r3.append(r4);
        r3 = r3.toString();
        android.util.Log.v(r0, r3);
    L_0x0051:
        monitor-exit(r10);
        r0 = r6;
    L_0x0053:
        return r0;
    L_0x0054:
        monitor-exit(r10);
        r0 = r13;
        goto L_0x0053;
    L_0x0057:
        r0 = move-exception;
        monitor-exit(r10);
        throw r0;
    L_0x005a:
        r0 = move-exception;
        r9 = r0;
        r0 = "BaseImage";
        r0 = "miniThumbBitmap got exception";
        android.util.Log.e(r14, r0, r9);
        r0 = r13;
        goto L_0x0053;
    L_0x0065:
        r0 = move-exception;
        goto L_0x0029;
    }

    protected void onRemove() {
        r0 = this;
        return;
    }

    protected void saveMiniThumb(android.graphics.Bitmap r7) throws java.io.IOException {
        r6 = this;
        r0 = r6.mContainer;
        r2 = r6.fullSizeImageId();
        r4 = 0;
        r1 = r7;
        r0.saveMiniThumbToFile(r1, r2, r4);
        return;
    }

    public void setTitle(java.lang.String r5) {
        r4 = this;
        r3 = 0;
        r1 = r4.mTitle;
        r1 = r1.equals(r5);
        if (r1 == 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r4.mTitle = r5;
        r0 = new android.content.ContentValues;
        r0.<init>();
        r1 = "title";
        r0.put(r1, r5);
        r1 = r4.mContentResolver;
        r2 = r4.mUri;
        r1.update(r2, r0, r3, r3);
        goto L_0x0009;
    }

    public android.net.Uri thumbUri() {
        r3 = this;
        r0 = r3.mUri;
        r0 = r0.buildUpon();
        r1 = "thumb";
        r2 = "1";
        r0 = r0.appendQueryParameter(r1, r2);
        r0 = r0.build();
        return r0;
    }

    public java.lang.String toString() {
        r1 = this;
        r0 = r1.mUri;
        r0 = r0.toString();
        return r0;
    }
}