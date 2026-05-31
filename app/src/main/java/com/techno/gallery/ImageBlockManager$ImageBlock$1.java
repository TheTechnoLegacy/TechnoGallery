package com.techno.gallery;

/* compiled from: GridViewSpecial */
class ImageBlockManager$ImageBlock$1 implements com.techno.gallery.ImageLoader.LoadedCallback {
    final /* synthetic */ com.techno.gallery.ImageBlockManager.ImageBlock this$1;
    final /* synthetic */ int val$colFinal;
    final /* synthetic */ com.techno.gallery.gallery.IImage val$image;

    ImageBlockManager$ImageBlock$1(com.techno.gallery.ImageBlockManager.ImageBlock r1, com.techno.gallery.gallery.IImage r2, int r3) {
        r0 = this;
        r0.this$1 = r1;
        r0.val$image = r2;
        r0.val$colFinal = r3;
        r0.<init>();
        return;
    }

    public void run(android.graphics.Bitmap r3) {
        r2 = this;
        r0 = r2.this$1;
        r0 = r0.this$0;
        r0 = com.techno.gallery.ImageBlockManager.access$900(r0);
        r1 = new com.techno.gallery.ImageBlockManager$ImageBlock$1$1;
        r1.<init>(r2, r3);
        r0.post(r1);
        return;
    }
}