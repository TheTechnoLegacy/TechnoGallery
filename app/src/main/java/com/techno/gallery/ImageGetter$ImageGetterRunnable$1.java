package com.techno.gallery;

class ImageGetter$ImageGetterRunnable$1 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.ImageGetter.ImageGetterRunnable this$1;
    final /* synthetic */ com.techno.gallery.RotateBitmap val$bitmap;
    final /* synthetic */ boolean val$isThumb;
    final /* synthetic */ int val$offset;
    final /* synthetic */ int val$position;
    final /* synthetic */ int val$requestSerial;

    ImageGetter$ImageGetterRunnable$1(com.techno.gallery.ImageGetter.ImageGetterRunnable r1, int r2, int r3, int r4, com.techno.gallery.RotateBitmap r5, boolean r6) {
        r0 = this;
        r0.this$1 = r1;
        r0.val$requestSerial = r2;
        r0.val$position = r3;
        r0.val$offset = r4;
        r0.val$bitmap = r5;
        r0.val$isThumb = r6;
        r0.<init>();
        return;
    }

    public void run() {
        r5 = this;
        r0 = r5.val$requestSerial;
        r1 = r5.this$1;
        r1 = r1.this$0;
        r1 = com.techno.gallery.ImageGetter.access$000(r1);
        if (r0 != r1) goto L_0x0020;
    L_0x000c:
        r0 = r5.this$1;
        r0 = r0.this$0;
        r0 = com.techno.gallery.ImageGetter.access$100(r0);
        r1 = r5.val$position;
        r2 = r5.val$offset;
        r3 = r5.val$bitmap;
        r4 = r5.val$isThumb;
        r0.imageLoaded(r1, r2, r3, r4);
    L_0x001f:
        return;
    L_0x0020:
        r0 = r5.val$bitmap;
        if (r0 == 0) goto L_0x001f;
    L_0x0024:
        r0 = r5.val$bitmap;
        r0.recycle();
        goto L_0x001f;
    }
}