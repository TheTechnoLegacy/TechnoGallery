package com.techno.gallery;

/* compiled from: GridViewSpecial */
class ImageBlockManager$ImageBlock$1$1 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.ImageBlockManager.ImageBlock.1 this$2;
    final /* synthetic */ android.graphics.Bitmap val$b;

    ImageBlockManager$ImageBlock$1$1(com.techno.gallery.ImageBlockManager.ImageBlock.1 r1, android.graphics.Bitmap r2) {
        r0 = this;
        r0.this$2 = r1;
        r0.val$b = r2;
        r0.<init>();
        return;
    }

    public void run() {
        r4 = this;
        r0 = r4.this$2;
        r0 = r0.this$1;
        r1 = r4.this$2;
        r1 = r1.val$image;
        r2 = r4.val$b;
        r3 = r4.this$2;
        r3 = r3.val$colFinal;
        com.techno.gallery.ImageBlockManager.ImageBlock.access$800(r0, r1, r2, r3);
        return;
    }
}