package com.techno.gallery;

class ImageGallery$CreateContextMenuListener$1 implements android.view.MenuItem.OnMenuItemClickListener {
    final /* synthetic */ com.techno.gallery.ImageGallery.CreateContextMenuListener this$1;

    ImageGallery$CreateContextMenuListener$1(com.techno.gallery.ImageGallery.CreateContextMenuListener r1) {
        r0 = this;
        r0.this$1 = r1;
        r0.<init>();
        return;
    }

    public boolean onMenuItemClick(android.view.MenuItem r3) {
        r2 = this;
        r0 = r2.this$1;
        r0 = r0.this$0;
        r0 = r0.canHandleEvent();
        if (r0 != 0) goto L_0x000c;
    L_0x000a:
        r0 = 0;
    L_0x000b:
        return r0;
    L_0x000c:
        r0 = r2.this$1;
        r0 = r0.this$0;
        r1 = r2.this$1;
        r1 = r1.this$0;
        r1 = com.techno.gallery.ImageGallery.access$500(r1);
        r1 = r1.getCurrentSelection();
        r0.onImageClicked(r1);
        r0 = 1;
        goto L_0x000b;
    }
}