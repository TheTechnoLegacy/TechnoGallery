package com.techno.gallery.gallery;

public class VideoObject extends com.techno.gallery.gallery.BaseImage implements com.techno.gallery.gallery.IImage {
    protected VideoObject(com.techno.gallery.gallery.BaseImageList r1, android.content.ContentResolver r2, long r3, int r5, android.net.Uri r6, java.lang.String r7, long r8, java.lang.String r10, long r11, java.lang.String r13, java.lang.String r14) {
        r0 = this;
        r0.<init>(r1, r2, r3, r5, r6, r7, r8, r10, r11, r13, r14);
        return;
    }

    protected android.graphics.Bitmap.CompressFormat compressionType() {
        r1 = this;
        r0 = android.graphics.Bitmap.CompressFormat.JPEG;
        return r0;
    }

    public boolean equals(java.lang.Object r3) {
        r2 = this;
        if (r3 == 0) goto L_0x0006;
    L_0x0002:
        r0 = r3 instanceof com.techno.gallery.gallery.VideoObject;
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        r0 = 0;
    L_0x0007:
        return r0;
    L_0x0008:
        r0 = r2.fullSizeImageUri();
        r3 = (com.techno.gallery.gallery.VideoObject) r3;
        r1 = r3.fullSizeImageUri();
        r0 = r0.equals(r1);
        goto L_0x0007;
    }

    public android.graphics.Bitmap fullSizeBitmap(int r2, int r3, boolean r4, boolean r5) {
        r1 = this;
        r0 = r1.mDataPath;
        r0 = com.techno.gallery.Util.createVideoThumbnail(r0);
        return r0;
    }

    public java.io.InputStream fullSizeImageData() {
        r4 = this;
        r2 = r4.mContentResolver;	 Catch:{ IOException -> 0x000c }
        r3 = r4.fullSizeImageUri();	 Catch:{ IOException -> 0x000c }
        r1 = r2.openInputStream(r3);	 Catch:{ IOException -> 0x000c }
        r2 = r1;
    L_0x000b:
        return r2;
    L_0x000c:
        r2 = move-exception;
        r0 = r2;
        r2 = 0;
        goto L_0x000b;
    }

    public long fullSizeImageId() {
        r2 = this;
        r0 = r2.mId;
        return r0;
    }

    public int getHeight() {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public int getWidth() {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public int hashCode() {
        r1 = this;
        r0 = r1.fullSizeImageUri();
        r0 = r0.toString();
        r0 = r0.hashCode();
        return r0;
    }

    public boolean isDrm() {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public boolean isReadonly() {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public boolean rotateImageBy(int r2) {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public android.graphics.Bitmap thumbBitmap(boolean r3) {
        r2 = this;
        r0 = 320; // 0x140 float:4.48E-43 double:1.58E-321;
        r1 = 196608; // 0x30000 float:2.75506E-40 double:9.71373E-319;
        r0 = r2.fullSizeBitmap(r0, r1);
        return r0;
    }

    public java.lang.String toString() {
        r3 = this;
        r0 = new java.lang.StringBuilder;
        r1 = "VideoObject";
        r0.<init>(r1);
        r1 = r3.mId;
        r0 = r0.append(r1);
        r0 = r0.toString();
        return r0;
    }
}