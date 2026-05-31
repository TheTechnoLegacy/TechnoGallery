package com.techno.gallery.gallery;

public class Image extends com.techno.gallery.gallery.BaseImage implements com.techno.gallery.gallery.IImage {
    private static final java.lang.String TAG = "BaseImage";
    private static final java.lang.String[] THUMB_PROJECTION = null;
    private java.util.HashMap<java.lang.String, java.lang.String> mExifData;
    private int mRotation;

    static {
        r0 = 1;
        r0 = new java.lang.String[r0];
        r1 = 0;
        r2 = "_id";
        r0[r1] = r2;
        THUMB_PROJECTION = r0;
        return;
    }

    public Image(com.techno.gallery.gallery.BaseImageList r1, android.content.ContentResolver r2, long r3, int r5, android.net.Uri r6, java.lang.String r7, long r8, java.lang.String r10, long r11, java.lang.String r13, java.lang.String r14, int r15) {
        r0 = this;
        r0.<init>(r1, r2, r3, r5, r6, r7, r8, r10, r11, r13, r14);
        r0.mRotation = r15;
        return;
    }

    private android.graphics.Bitmap decodeCurrentImage(long r11) {
        r10 = this;
        r9 = "couldn't open thumbnail ";
        r8 = "BaseImage";
        r7 = "; ";
        r5 = r10.mContainer;
        r5 = r5.mThumbUri;
        r4 = android.content.ContentUris.withAppendedId(r5, r11);
        r0 = 0;
        r2 = new android.graphics.BitmapFactory$Options;	 Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x0058, NullPointerException -> 0x007d, OutOfMemoryError -> 0x00a2 }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x0058, NullPointerException -> 0x007d, OutOfMemoryError -> 0x00a2 }
        r5 = 0;
        r2.inDither = r5;	 Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x0058, NullPointerException -> 0x007d, OutOfMemoryError -> 0x00a2 }
        r5 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x0058, NullPointerException -> 0x007d, OutOfMemoryError -> 0x00a2 }
        r2.inPreferredConfig = r5;	 Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x0058, NullPointerException -> 0x007d, OutOfMemoryError -> 0x00a2 }
        r5 = r10.mContentResolver;	 Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x0058, NullPointerException -> 0x007d, OutOfMemoryError -> 0x00a2 }
        r6 = "r";
        r3 = r5.openFileDescriptor(r4, r6);	 Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x0058, NullPointerException -> 0x007d, OutOfMemoryError -> 0x00a2 }
        r5 = com.techno.gallery.BitmapManager.instance();	 Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x0058, NullPointerException -> 0x007d, OutOfMemoryError -> 0x00a2 }
        r6 = r3.getFileDescriptor();	 Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x0058, NullPointerException -> 0x007d, OutOfMemoryError -> 0x00a2 }
        r0 = r5.decodeFileDescriptor(r6, r2);	 Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x0058, NullPointerException -> 0x007d, OutOfMemoryError -> 0x00a2 }
        r3.close();	 Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x0058, NullPointerException -> 0x007d, OutOfMemoryError -> 0x00a2 }
    L_0x0032:
        return r0;
    L_0x0033:
        r5 = move-exception;
        r1 = r5;
        r5 = "BaseImage";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "couldn't open thumbnail ";
        r5 = r5.append(r9);
        r5 = r5.append(r4);
        r6 = "; ";
        r5 = r5.append(r7);
        r5 = r5.append(r1);
        r5 = r5.toString();
        android.util.Log.e(r8, r5);
        goto L_0x0032;
    L_0x0058:
        r5 = move-exception;
        r1 = r5;
        r5 = "BaseImage";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "couldn't open thumbnail ";
        r5 = r5.append(r9);
        r5 = r5.append(r4);
        r6 = "; ";
        r5 = r5.append(r7);
        r5 = r5.append(r1);
        r5 = r5.toString();
        android.util.Log.e(r8, r5);
        goto L_0x0032;
    L_0x007d:
        r5 = move-exception;
        r1 = r5;
        r5 = "BaseImage";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "couldn't open thumbnail ";
        r5 = r5.append(r9);
        r5 = r5.append(r4);
        r6 = "; ";
        r5 = r5.append(r7);
        r5 = r5.append(r1);
        r5 = r5.toString();
        android.util.Log.e(r8, r5);
        goto L_0x0032;
    L_0x00a2:
        r5 = move-exception;
        r1 = r5;
        r5 = "BaseImage";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "failed to allocate memory for thumbnail ";
        r5 = r5.append(r6);
        r5 = r5.append(r4);
        r6 = "; ";
        r5 = r5.append(r7);
        r5 = r5.append(r1);
        r5 = r5.toString();
        android.util.Log.e(r8, r5);
        goto L_0x0032;
    }

    private void loadExifData() {
        r1 = this;
        r0 = r1.mDataPath;
        r0 = android.media.ExifInterface.loadExifData(r0);
        r1.mExifData = r0;
        return;
    }

    private void saveExifData() {
        r2 = this;
        r0 = r2.mExifData;
        if (r0 == 0) goto L_0x000b;
    L_0x0004:
        r0 = r2.mDataPath;
        r1 = r2.mExifData;
        android.media.ExifInterface.saveExifData(r0, r1);
    L_0x000b:
        return;
    }

    private void setExifRotation(int r6) {
        r5 = this;
        r6 = r6 % 360;
        if (r6 >= 0) goto L_0x0006;
    L_0x0004:
        r6 = r6 + 360;
    L_0x0006:
        r1 = 1;
        switch(r6) {
            case 0: goto L_0x002f;
            case 90: goto L_0x0031;
            case 180: goto L_0x0033;
            case 270: goto L_0x0035;
            default: goto L_0x000a;
        };	 Catch:{ RuntimeException -> 0x0038 }
    L_0x000a:
        r2 = "Orientation";
        r3 = java.lang.Integer.toString(r1);	 Catch:{ RuntimeException -> 0x0038 }
        r5.replaceExifTag(r2, r3);	 Catch:{ RuntimeException -> 0x0038 }
        r2 = "UserComment";
        r3 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0038 }
        r3.<init>();	 Catch:{ RuntimeException -> 0x0038 }
        r4 = "saveRotatedImage comment orientation: ";
        r3 = r3.append(r4);	 Catch:{ RuntimeException -> 0x0038 }
        r3 = r3.append(r1);	 Catch:{ RuntimeException -> 0x0038 }
        r3 = r3.toString();	 Catch:{ RuntimeException -> 0x0038 }
        r5.replaceExifTag(r2, r3);	 Catch:{ RuntimeException -> 0x0038 }
        r5.saveExifData();	 Catch:{ RuntimeException -> 0x0038 }
    L_0x002e:
        return;
    L_0x002f:
        r1 = 1;
        goto L_0x000a;
    L_0x0031:
        r1 = 6;
        goto L_0x000a;
    L_0x0033:
        r1 = 3;
        goto L_0x000a;
    L_0x0035:
        r1 = 8;
        goto L_0x000a;
    L_0x0038:
        r2 = move-exception;
        r0 = r2;
        r2 = "BaseImage";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "unable to save exif data with new orientation ";
        r3 = r3.append(r4);
        r4 = r5.fullSizeImageUri();
        r3 = r3.append(r4);
        r3 = r3.toString();
        android.util.Log.e(r2, r3);
        goto L_0x002e;
    }

    protected android.graphics.Bitmap.CompressFormat compressionType() {
        r2 = this;
        r0 = r2.getMimeType();
        r1 = "image/png";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x000f;
    L_0x000c:
        r1 = android.graphics.Bitmap.CompressFormat.PNG;
    L_0x000e:
        return r1;
    L_0x000f:
        r1 = "image/gif";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x001a;
    L_0x0017:
        r1 = android.graphics.Bitmap.CompressFormat.PNG;
        goto L_0x000e;
    L_0x001a:
        r1 = android.graphics.Bitmap.CompressFormat.JPEG;
        goto L_0x000e;
    }

    public int getDegreesRotated() {
        r1 = this;
        r0 = r1.mRotation;
        return r0;
    }

    public boolean isDrm() {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public boolean isReadonly() {
        r2 = this;
        r0 = r2.getMimeType();
        r1 = "image/jpeg";
        r1 = r1.equals(r0);
        if (r1 != 0) goto L_0x0016;
    L_0x000c:
        r1 = "image/png";
        r1 = r1.equals(r0);
        if (r1 != 0) goto L_0x0016;
    L_0x0014:
        r1 = 1;
    L_0x0015:
        return r1;
    L_0x0016:
        r1 = 0;
        goto L_0x0015;
    }

    public void replaceExifTag(java.lang.String r2, java.lang.String r3) {
        r1 = this;
        r0 = r1.mExifData;
        if (r0 != 0) goto L_0x0007;
    L_0x0004:
        r1.loadExifData();
    L_0x0007:
        r0 = r1.mExifData;
        r0.put(r2, r3);
        return;
    }

    public boolean rotateImageBy(int r4) {
        r3 = this;
        r1 = r3.getDegreesRotated();
        r1 = r1 + r4;
        r0 = r1 % 360;
        r3.setExifRotation(r0);
        r3.setDegreesRotated(r0);
        r1 = 0;
        r3.mMiniThumbMagic = r1;
        r2 = r3.mContainer;	 Catch:{ IOException -> 0x001b }
        r1 = 0;
        r1 = (byte[][]) r1;	 Catch:{ IOException -> 0x001b }
        r2.checkThumbnail(r3, r1);	 Catch:{ IOException -> 0x001b }
    L_0x0019:
        r1 = 1;
        return r1;
    L_0x001b:
        r1 = move-exception;
        goto L_0x0019;
    }

    public com.techno.gallery.gallery.Cancelable<java.lang.Void> saveImageContents(android.graphics.Bitmap r7, byte[] r8, int r9, boolean r10, java.lang.String r11) {
        r6 = this;
        r0 = new com.techno.gallery.gallery.Image$SaveImageContentsCancelable;
        r1 = r6;
        r2 = r7;
        r3 = r8;
        r4 = r9;
        r5 = r11;
        r0.<init>(r1, r2, r3, r4, r5);
        return r0;
    }

    protected void setDegreesRotated(int r5) {
        r4 = this;
        r3 = 0;
        r1 = r4.mRotation;
        if (r1 != r5) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r4.mRotation = r5;
        r0 = new android.content.ContentValues;
        r0.<init>();
        r1 = "orientation";
        r2 = r4.mRotation;
        r2 = java.lang.Integer.valueOf(r2);
        r0.put(r1, r2);
        r1 = r4.mContentResolver;
        r2 = r4.mUri;
        r1.update(r2, r0, r3, r3);
        goto L_0x0005;
    }

    public android.graphics.Bitmap thumbBitmap(boolean r13) {
        r12 = this;
        r5 = 0;
        r11 = 0;
        r6 = 0;
        r0 = r12.mContainer;
        r0 = r0.mThumbUri;
        if (r0 == 0) goto L_0x0036;
    L_0x0009:
        r0 = r12.mContentResolver;
        r1 = r12.mContainer;
        r1 = r1.mThumbUri;
        r2 = THUMB_PROJECTION;
        r3 = "image_id=?";
        r4 = 1;
        r4 = new java.lang.String[r4];
        r9 = r12.fullSizeImageId();
        r9 = java.lang.String.valueOf(r9);
        r4[r11] = r9;
        r7 = r0.query(r1, r2, r3, r4, r5);
        r0 = r7.moveToFirst();	 Catch:{ RuntimeException -> 0x0056, all -> 0x005d }
        if (r0 == 0) goto L_0x0033;
    L_0x002a:
        r0 = 0;
        r0 = r7.getLong(r0);	 Catch:{ RuntimeException -> 0x0056, all -> 0x005d }
        r6 = r12.decodeCurrentImage(r0);	 Catch:{ RuntimeException -> 0x0056, all -> 0x005d }
    L_0x0033:
        r7.close();
    L_0x0036:
        if (r6 != 0) goto L_0x0048;
    L_0x0038:
        r0 = 320; // 0x140 float:4.48E-43 double:1.58E-321;
        r1 = 196608; // 0x30000 float:2.75506E-40 double:9.71373E-319;
        r6 = r12.fullSizeBitmap(r0, r1, r11, r11);
        r0 = r12.mContainer;
        r1 = r12.mId;
        r6 = r0.storeThumbnail(r6, r1);
    L_0x0048:
        if (r6 == 0) goto L_0x0054;
    L_0x004a:
        if (r13 == 0) goto L_0x0054;
    L_0x004c:
        r0 = r12.getDegreesRotated();
        r6 = com.techno.gallery.Util.rotate(r6, r0);
    L_0x0054:
        r0 = r6;
    L_0x0055:
        return r0;
    L_0x0056:
        r0 = move-exception;
        r8 = r0;
        r7.close();
        r0 = r5;
        goto L_0x0055;
    L_0x005d:
        r0 = move-exception;
        r7.close();
        throw r0;
    }
}