package com.techno.gallery;

class ImageGetter$ImageGetterRunnable$2 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.ImageGetter.ImageGetterRunnable this$1;
    final /* synthetic */ int val$requestSerial;

    ImageGetter$ImageGetterRunnable$2(com.techno.gallery.ImageGetter.ImageGetterRunnable r1, int r2) {
        r0 = this;
        r0.this$1 = r1;
        r0.val$requestSerial = r2;
        r0.<init>();
        return;
    }

    public void run() {
        r2 = this;
        r0 = r2.val$requestSerial;
        r1 = r2.this$1;
        r1 = r1.this$0;
        r1 = com.techno.gallery.ImageGetter.access$000(r1);
        if (r0 != r1) goto L_0x0017;
    L_0x000c:
        r0 = r2.this$1;
        r0 = r0.this$0;
        r0 = com.techno.gallery.ImageGetter.access$100(r0);
        r0.completed();
    L_0x0017:
        return;
    }
}