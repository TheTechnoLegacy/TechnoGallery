package com.techno.gallery;

class ImageGallery$CreateContextMenuListener$2 implements com.techno.gallery.MenuHelper.MenuInvoker {
    final /* synthetic */ com.techno.gallery.ImageGallery.CreateContextMenuListener this$1;

    ImageGallery$CreateContextMenuListener$2(com.techno.gallery.ImageGallery.CreateContextMenuListener r1) {
        r0 = this;
        r0.this$1 = r1;
        r0.<init>();
        return;
    }

    public void run(com.techno.gallery.MenuHelper.MenuCallback r3) {
        r2 = this;
        r0 = r2.this$1;
        r0 = r0.this$0;
        r0 = r0.canHandleEvent();
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r0 = r2.this$1;
        r0 = r0.this$0;
        r0 = com.techno.gallery.ImageGallery.access$2000(r0);
        r1 = r2.this$1;
        r1 = r1.this$0;
        r1 = com.techno.gallery.ImageGallery.access$400(r1);
        r3.run(r0, r1);
        r0 = r2.this$1;
        r0 = r0.this$0;
        r0 = com.techno.gallery.ImageGallery.access$500(r0);
        r1 = r2.this$1;
        r1 = r1.this$0;
        r1 = com.techno.gallery.ImageGallery.access$500(r1);
        r1 = r1.getCurrentSelection();
        r0.invalidateImage(r1);
        goto L_0x000a;
    }
}