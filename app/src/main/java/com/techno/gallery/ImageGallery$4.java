package com.techno.gallery;

class ImageGallery$4 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.ImageGallery this$0;

    ImageGallery$4(com.techno.gallery.ImageGallery r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    public void run() {
        r3 = this;
        r1 = r3.this$0;
        r1 = r1.canHandleEvent();
        if (r1 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r1 = r3.this$0;
        com.techno.gallery.ImageGallery.access$300(r1);
        r1 = r3.this$0;
        r0 = com.techno.gallery.ImageGallery.access$400(r1);
        r1 = r3.this$0;
        r1 = com.techno.gallery.ImageGallery.access$500(r1);
        r1.stop();
        if (r0 == 0) goto L_0x0028;
    L_0x001f:
        r1 = r3.this$0;
        r1 = com.techno.gallery.ImageGallery.access$600(r1);
        r1.removeImage(r0);
    L_0x0028:
        r1 = r3.this$0;
        r1 = com.techno.gallery.ImageGallery.access$500(r1);
        r2 = r3.this$0;
        r2 = com.techno.gallery.ImageGallery.access$600(r2);
        r1.setImageList(r2);
        r1 = r3.this$0;
        r1 = com.techno.gallery.ImageGallery.access$500(r1);
        r1.start();
        r1 = r3.this$0;
        com.techno.gallery.ImageGallery.access$700(r1);
        r1 = r3.this$0;
        r1 = com.techno.gallery.ImageGallery.access$800(r1);
        r2 = r3.this$0;
        r2 = com.techno.gallery.ImageGallery.access$600(r2);
        r2 = r2.isEmpty();
        if (r2 == 0) goto L_0x005c;
    L_0x0057:
        r2 = 0;
    L_0x0058:
        r1.setVisibility(r2);
        goto L_0x0008;
    L_0x005c:
        r2 = 8;
        goto L_0x0058;
    }
}