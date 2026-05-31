package com.techno.gallery;

class ReviewImage$3 implements android.view.View.OnTouchListener {
    final /* synthetic */ com.techno.gallery.ReviewImage this$0;

    ReviewImage$3(com.techno.gallery.ReviewImage r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    public boolean onTouch(android.view.View r2, android.view.MotionEvent r3) {
        r1 = this;
        r0 = r1.this$0;
        com.techno.gallery.ReviewImage.access$200(r0);
        r0 = r3.getAction();
        if (r0 != 0) goto L_0x0010;
    L_0x000b:
        r0 = r1.this$0;
        com.techno.gallery.ReviewImage.access$100(r0);
    L_0x0010:
        r0 = 0;
        return r0;
    }
}