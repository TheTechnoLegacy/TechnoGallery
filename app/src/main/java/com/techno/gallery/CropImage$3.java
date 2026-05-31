package com.techno.gallery;

class CropImage$3 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.CropImage this$0;

    CropImage$3(com.techno.gallery.CropImage r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    public void run() {
        r6 = this;
        r2 = new java.util.concurrent.CountDownLatch;
        r3 = 1;
        r2.<init>(r3);
        r3 = r6.this$0;
        r3 = com.techno.gallery.CropImage.access$100(r3);
        if (r3 == 0) goto L_0x0035;
    L_0x000e:
        r3 = r6.this$0;
        r3 = com.techno.gallery.CropImage.access$100(r3);
        r4 = -1;
        r5 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        r3 = r3.fullSizeBitmap(r4, r5);
        r0 = r3;
    L_0x001c:
        r3 = r6.this$0;
        r3 = com.techno.gallery.CropImage.access$400(r3);
        r4 = new com.techno.gallery.CropImage$3$1;
        r4.<init>(r6, r0, r2);
        r3.post(r4);
        r2.await();	 Catch:{ InterruptedException -> 0x003d }
        r3 = r6.this$0;
        r3 = r3.mRunFaceDetection;
        r3.run();
        return;
    L_0x0035:
        r3 = r6.this$0;
        r3 = com.techno.gallery.CropImage.access$200(r3);
        r0 = r3;
        goto L_0x001c;
    L_0x003d:
        r1 = move-exception;
        r3 = new java.lang.RuntimeException;
        r3.<init>(r1);
        throw r3;
    }
}