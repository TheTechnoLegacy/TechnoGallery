package com.techno.gallery;

class ViewImage$6 implements com.techno.gallery.MenuHelper.MenuInvoker {
    final /* synthetic */ com.techno.gallery.ViewImage this$0;

    ViewImage$6(com.techno.gallery.ViewImage r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    public void run(com.techno.gallery.MenuHelper.MenuCallback r6) {
        r5 = this;
        r2 = r5.this$0;
        r2 = com.techno.gallery.ViewImage.access$800(r2);
        if (r2 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r2 = r5.this$0;
        r3 = 1;
        r2.setMode(r3);
        r2 = r5.this$0;
        r2 = r2.mAllImages;
        r3 = r5.this$0;
        r3 = r3.mCurrentPosition;
        r0 = r2.getImageAt(r3);
        r1 = r0.fullSizeImageUri();
        r6.run(r1, r0);
        r2 = r5.this$0;
        r2 = com.techno.gallery.ViewImage.access$500(r2);
        r2.clear();
        r2 = r5.this$0;
        r3 = r5.this$0;
        r3 = r3.mCurrentPosition;
        r4 = 0;
        r2.setImage(r3, r4);
        goto L_0x0008;
    }
}