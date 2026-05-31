package com.techno.gallery;

class ImageGallery$8 implements android.view.MenuItem.OnMenuItemClickListener {
    final /* synthetic */ com.techno.gallery.ImageGallery this$0;

    ImageGallery$8(com.techno.gallery.ImageGallery r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    public boolean onMenuItemClick(android.view.MenuItem r2) {
        r1 = this;
        r0 = r1.this$0;
        r0 = com.techno.gallery.ImageGallery.access$1100(r0);
        if (r0 == 0) goto L_0x000f;
    L_0x0008:
        r0 = r1.this$0;
        com.techno.gallery.ImageGallery.access$200(r0);
    L_0x000d:
        r0 = 1;
        return r0;
    L_0x000f:
        r0 = r1.this$0;
        com.techno.gallery.ImageGallery.access$1200(r0);
        goto L_0x000d;
    }
}