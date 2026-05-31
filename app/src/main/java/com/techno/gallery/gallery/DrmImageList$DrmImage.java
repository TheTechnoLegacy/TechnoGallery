package com.techno.gallery.gallery;

class DrmImageList$DrmImage extends com.techno.gallery.gallery.Image {
    protected DrmImageList$DrmImage(com.techno.gallery.gallery.BaseImageList r1, android.content.ContentResolver r2, long r3, int r5, android.net.Uri r6, java.lang.String r7, long r8, java.lang.String r10, long r11, java.lang.String r13, java.lang.String r14, int r15) {
        r0 = this;
        r0.<init>(r1, r2, r3, r5, r6, r7, r8, r10, r11, r13, r14, r15);
        return;
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

    public boolean isDrm() {
        r1 = this;
        r0 = 1;
        return r0;
    }

    public boolean isReadonly() {
        r1 = this;
        r0 = 1;
        return r0;
    }

    public android.graphics.Bitmap miniThumbBitmap() {
        r2 = this;
        r0 = 96;
        r1 = 16384; // 0x4000 float:2.2959E-41 double:8.095E-320;
        r0 = r2.fullSizeBitmap(r0, r1);
        return r0;
    }

    public android.graphics.Bitmap thumbBitmap(boolean r3) {
        r2 = this;
        r0 = 320; // 0x140 float:4.48E-43 double:1.58E-321;
        r1 = 196608; // 0x30000 float:2.75506E-40 double:9.71373E-319;
        r0 = r2.fullSizeBitmap(r0, r1);
        return r0;
    }
}