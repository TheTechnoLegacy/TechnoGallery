package com.techno.gallery;

class GalleryPicker$9 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.GalleryPicker this$0;
    final /* synthetic */ com.techno.gallery.Item val$finalItem;

    GalleryPicker$9(com.techno.gallery.GalleryPicker r1, com.techno.gallery.Item r2) {
        r0 = this;
        r0.this$0 = r1;
        r0.val$finalItem = r2;
        r0.<init>();
        return;
    }

    public void run() {
        r2 = this;
        r0 = r2.this$0;
        r1 = r2.val$finalItem;
        com.techno.gallery.GalleryPicker.access$800(r0, r1);
        return;
    }
}