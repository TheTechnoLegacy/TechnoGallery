package com.techno.gallery;

class CropImage$3$1 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.CropImage.3 this$1;
    final /* synthetic */ android.graphics.Bitmap val$b;
    final /* synthetic */ java.util.concurrent.CountDownLatch val$latch;

    CropImage$3$1(com.techno.gallery.CropImage.3 r1, android.graphics.Bitmap r2, java.util.concurrent.CountDownLatch r3) {
        r0 = this;
        r0.this$1 = r1;
        r0.val$b = r2;
        r0.val$latch = r3;
        r0.<init>();
        return;
    }

    public void run() {
        r3 = this;
        r2 = 1;
        r0 = r3.val$b;
        r1 = r3.this$1;
        r1 = r1.this$0;
        r1 = com.techno.gallery.CropImage.access$200(r1);
        if (r0 == r1) goto L_0x0032;
    L_0x000d:
        r0 = r3.val$b;
        if (r0 == 0) goto L_0x0032;
    L_0x0011:
        r0 = r3.this$1;
        r0 = r0.this$0;
        r0 = com.techno.gallery.CropImage.access$300(r0);
        r1 = r3.val$b;
        r0.setImageBitmapResetBase(r1, r2);
        r0 = r3.this$1;
        r0 = r0.this$0;
        r0 = com.techno.gallery.CropImage.access$200(r0);
        r0.recycle();
        r0 = r3.this$1;
        r0 = r0.this$0;
        r1 = r3.val$b;
        com.techno.gallery.CropImage.access$202(r0, r1);
    L_0x0032:
        r0 = r3.this$1;
        r0 = r0.this$0;
        r0 = com.techno.gallery.CropImage.access$300(r0);
        r0 = r0.getScale();
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 != 0) goto L_0x004f;
    L_0x0044:
        r0 = r3.this$1;
        r0 = r0.this$0;
        r0 = com.techno.gallery.CropImage.access$300(r0);
        r0.center(r2, r2);
    L_0x004f:
        r0 = r3.val$latch;
        r0.countDown();
        return;
    }
}