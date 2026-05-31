package com.techno.gallery;

class ViewImage$11 implements com.techno.gallery.ImageGetterCallback {
    final /* synthetic */ com.techno.gallery.ViewImage this$0;
    final /* synthetic */ boolean val$firstCall;
    final /* synthetic */ int val$requestedPos;
    final /* synthetic */ long val$targetDisplayTime;

    ViewImage$11(com.techno.gallery.ViewImage r1, long r2, int r4, boolean r5) {
        r0 = this;
        r0.this$0 = r1;
        r0.val$targetDisplayTime = r2;
        r0.val$requestedPos = r4;
        r0.val$firstCall = r5;
        r0.<init>();
        return;
    }

    public void completed() {
        r0 = this;
        return;
    }

    public int fullImageSizeToUse(int r2, int r3) {
        r1 = this;
        r0 = 480; // 0x1e0 float:6.73E-43 double:2.37E-321;
        return r0;
    }

    public void imageLoaded(int r9, int r10, com.techno.gallery.RotateBitmap r11, boolean r12) {
        r8 = this;
        r2 = 0;
        r4 = r8.val$targetDisplayTime;
        r6 = java.lang.System.currentTimeMillis();
        r4 = r4 - r6;
        r0 = java.lang.Math.max(r2, r4);
        r2 = r8.this$0;
        r2 = r2.mHandler;
        r3 = new com.techno.gallery.ViewImage$11$1;
        r3.<init>(r8, r11);
        r2.postDelayedGetterCallback(r3, r0);
        return;
    }

    public int[] loadOrder() {
        r1 = this;
        r0 = com.techno.gallery.ViewImage.access$1100();
        return r0;
    }

    public boolean wantsFullImage(int r2, int r3) {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public boolean wantsThumbnail(int r2, int r3) {
        r1 = this;
        r0 = 1;
        return r0;
    }
}