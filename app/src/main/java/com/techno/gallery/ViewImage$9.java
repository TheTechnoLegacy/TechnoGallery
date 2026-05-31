package com.techno.gallery;

class ViewImage$9 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.ViewImage this$0;

    ViewImage$9(com.techno.gallery.ViewImage r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    public void run() {
        r3 = this;
        r2 = 1;
        r0 = r3.this$0;
        r0 = r0.mAllImages;
        r1 = r3.this$0;
        r1 = r1.mCurrentPosition;
        r0.removeImageAt(r1);
        r0 = r3.this$0;
        r0 = r0.mAllImages;
        r0 = r0.getCount();
        if (r0 != 0) goto L_0x001c;
    L_0x0016:
        r0 = r3.this$0;
        r0.finish();
    L_0x001b:
        return;
    L_0x001c:
        r0 = r3.this$0;
        r0 = r0.mCurrentPosition;
        r1 = r3.this$0;
        r1 = r1.mAllImages;
        r1 = r1.getCount();
        if (r0 != r1) goto L_0x0031;
    L_0x002a:
        r0 = r3.this$0;
        r1 = r0.mCurrentPosition;
        r1 = r1 - r2;
        r0.mCurrentPosition = r1;
    L_0x0031:
        r0 = r3.this$0;
        r0 = com.techno.gallery.ViewImage.access$500(r0);
        r0.clear();
        r0 = r3.this$0;
        r0 = com.techno.gallery.ViewImage.access$900(r0);
        r0.clear();
        r0 = r3.this$0;
        r1 = r3.this$0;
        r1 = r1.mCurrentPosition;
        r0.setImage(r1, r2);
        goto L_0x001b;
    }
}