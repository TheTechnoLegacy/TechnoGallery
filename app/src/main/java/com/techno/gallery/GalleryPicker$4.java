package com.techno.gallery;

class GalleryPicker$4 extends android.database.ContentObserver {
    final /* synthetic */ com.techno.gallery.GalleryPicker this$0;

    GalleryPicker$4(com.techno.gallery.GalleryPicker r1, android.os.Handler r2) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>(r2);
        return;
    }

    public void onChange(boolean r4) {
        r3 = this;
        r0 = r3.this$0;
        r1 = 0;
        r2 = r3.this$0;
        r2 = r2.getContentResolver();
        r2 = com.techno.gallery.ImageManager.isMediaScannerScanning(r2);
        com.techno.gallery.GalleryPicker.access$300(r0, r1, r2);
        return;
    }
}