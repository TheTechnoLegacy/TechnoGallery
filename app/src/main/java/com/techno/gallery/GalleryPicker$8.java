package com.techno.gallery;

class GalleryPicker$8 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.GalleryPicker this$0;
    final /* synthetic */ boolean val$scanning;

    GalleryPicker$8(com.techno.gallery.GalleryPicker r1, boolean r2) {
        r0 = this;
        r0.this$0 = r1;
        r0.val$scanning = r2;
        r0.<init>();
        return;
    }

    public void run() {
        r2 = this;
        r0 = r2.this$0;
        r1 = r2.val$scanning;
        com.techno.gallery.GalleryPicker.access$700(r0, r1);
        return;
    }
}