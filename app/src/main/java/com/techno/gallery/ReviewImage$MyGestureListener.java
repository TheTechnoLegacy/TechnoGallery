package com.techno.gallery;

class ReviewImage$MyGestureListener extends android.view.GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ com.techno.gallery.ReviewImage this$0;

    private ReviewImage$MyGestureListener(com.techno.gallery.ReviewImage r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    /* synthetic */ ReviewImage$MyGestureListener(com.techno.gallery.ReviewImage r1, com.techno.gallery.ReviewImage.1 r2) {
        r0 = this;
        r0.<init>(r1);
        return;
    }

    public boolean onScroll(android.view.MotionEvent r4, android.view.MotionEvent r5, float r6, float r7) {
        r3 = this;
        r1 = r3.this$0;
        r0 = com.techno.gallery.ReviewImage.access$500(r1);
        r1 = r0.getScale();
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r1 <= 0) goto L_0x0015;
    L_0x0010:
        r1 = -r6;
        r2 = -r7;
        r0.postTranslateCenter(r1, r2);
    L_0x0015:
        r1 = 1;
        return r1;
    }

    public boolean onSingleTapUp(android.view.MotionEvent r2) {
        r1 = this;
        r0 = 1;
        return r0;
    }
}