package com.techno.gallery;

class ImageViewTouchBase$2 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.ImageViewTouchBase this$0;
    final /* synthetic */ float val$centerX;
    final /* synthetic */ float val$centerY;
    final /* synthetic */ float val$durationMs;
    final /* synthetic */ float val$incrementPerMs;
    final /* synthetic */ float val$oldScale;
    final /* synthetic */ long val$startTime;

    ImageViewTouchBase$2(com.techno.gallery.ImageViewTouchBase r1, float r2, long r3, float r5, float r6, float r7, float r8) {
        r0 = this;
        r0.this$0 = r1;
        r0.val$durationMs = r2;
        r0.val$startTime = r3;
        r0.val$oldScale = r5;
        r0.val$incrementPerMs = r6;
        r0.val$centerX = r7;
        r0.val$centerY = r8;
        r0.<init>();
        return;
    }

    public void run() {
        r7 = this;
        r1 = java.lang.System.currentTimeMillis();
        r4 = r7.val$durationMs;
        r5 = r7.val$startTime;
        r5 = r1 - r5;
        r5 = (float) r5;
        r0 = java.lang.Math.min(r4, r5);
        r4 = r7.val$oldScale;
        r5 = r7.val$incrementPerMs;
        r5 = r5 * r0;
        r3 = r4 + r5;
        r4 = r7.this$0;
        r5 = r7.val$centerX;
        r6 = r7.val$centerY;
        r4.zoomTo(r3, r5, r6);
        r4 = r7.val$durationMs;
        r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r4 >= 0) goto L_0x002c;
    L_0x0025:
        r4 = r7.this$0;
        r4 = r4.mHandler;
        r4.post(r7);
    L_0x002c:
        return;
    }
}