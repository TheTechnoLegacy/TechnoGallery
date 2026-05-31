package com.techno.gallery;

class GalleryPicker$12 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.GalleryPicker this$0;
    final /* synthetic */ android.graphics.Bitmap val$b;
    final /* synthetic */ com.techno.gallery.Item val$finalItem;

    GalleryPicker$12(com.techno.gallery.GalleryPicker r1, com.techno.gallery.Item r2, android.graphics.Bitmap r3) {
        r0 = this;
        r0.this$0 = r1;
        r0.val$finalItem = r2;
        r0.val$b = r3;
        r0.<init>();
        return;
    }

    public void run() {
        r3 = this;
        r0 = r3.this$0;
        r1 = r3.val$finalItem;
        r2 = r3.val$b;
        com.techno.gallery.GalleryPicker.access$1000(r0, r1, r2);
        return;
    }
}