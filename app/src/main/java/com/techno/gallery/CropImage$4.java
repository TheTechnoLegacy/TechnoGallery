package com.techno.gallery;

class CropImage$4 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.CropImage this$0;
    final /* synthetic */ android.graphics.Bitmap val$b;

    CropImage$4(com.techno.gallery.CropImage r1, android.graphics.Bitmap r2) {
        r0 = this;
        r0.this$0 = r1;
        r0.val$b = r2;
        r0.<init>();
        return;
    }

    public void run() {
        r2 = this;
        r0 = r2.this$0;
        r1 = r2.val$b;
        com.techno.gallery.CropImage.access$500(r0, r1);
        return;
    }
}