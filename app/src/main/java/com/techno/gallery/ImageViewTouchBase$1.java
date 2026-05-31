package com.techno.gallery;

class ImageViewTouchBase$1 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.ImageViewTouchBase this$0;
    final /* synthetic */ com.techno.gallery.RotateBitmap val$bitmap;
    final /* synthetic */ boolean val$resetSupp;

    ImageViewTouchBase$1(com.techno.gallery.ImageViewTouchBase r1, com.techno.gallery.RotateBitmap r2, boolean r3) {
        r0 = this;
        r0.this$0 = r1;
        r0.val$bitmap = r2;
        r0.val$resetSupp = r3;
        r0.<init>();
        return;
    }

    public void run() {
        r3 = this;
        r0 = r3.this$0;
        r1 = r3.val$bitmap;
        r2 = r3.val$resetSupp;
        r0.setImageRotateBitmapResetBase(r1, r2);
        return;
    }
}