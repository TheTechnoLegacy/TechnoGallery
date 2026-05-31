package com.techno.gallery;

/* compiled from: GridViewSpecial */
class ImageBlockManager$ImageBlock {
    private android.graphics.Bitmap mBitmap;
    private final android.graphics.Canvas mCanvas;
    private int mCompletedMask;
    private int mRequestedMask;
    private int mRow;
    final /* synthetic */ com.techno.gallery.ImageBlockManager this$0;

    public ImageBlockManager$ImageBlock(com.techno.gallery.ImageBlockManager r4) {
        r3 = this;
        r3.this$0 = r4;
        r3.<init>();
        r0 = com.techno.gallery.ImageBlockManager.access$100(r4);
        r1 = com.techno.gallery.ImageBlockManager.access$200(r4);
        r2 = android.graphics.Bitmap.Config.RGB_565;
        r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2);
        r3.mBitmap = r0;
        r0 = new android.graphics.Canvas;
        r1 = r3.mBitmap;
        r0.<init>(r1);
        r3.mCanvas = r0;
        r0 = -1;
        r3.mRow = r0;
        return;
    }

    static /* synthetic */ int access$000(com.techno.gallery.ImageBlockManager$ImageBlock r1) {
        r0 = r1.mCompletedMask;
        return r0;
    }

    static /* synthetic */ int access$072(com.techno.gallery.ImageBlockManager$ImageBlock r1, int r2) {
        r0 = r1.mCompletedMask;
        r0 = r0 & r2;
        r1.mCompletedMask = r0;
        return r0;
    }

    static /* synthetic */ void access$800(com.techno.gallery.ImageBlockManager$ImageBlock r0, com.techno.gallery.gallery.IImage r1, android.graphics.Bitmap r2, int r3) {
        r0.loadImageDone(r1, r2, r3);
        return;
    }

    private void cancelAllRequests() {
        r6 = this;
        r5 = 1;
        r0 = 0;
    L_0x0002:
        r3 = r6.this$0;
        r3 = com.techno.gallery.ImageBlockManager.access$600(r3);
        if (r0 >= r3) goto L_0x0043;
    L_0x000a:
        r1 = r5 << r0;
        r3 = r6.mRequestedMask;
        r3 = r3 & r1;
        if (r3 == 0) goto L_0x0040;
    L_0x0011:
        r3 = r6.mRow;
        r4 = r6.this$0;
        r4 = com.techno.gallery.ImageBlockManager.access$600(r4);
        r3 = r3 * r4;
        r2 = r3 + r0;
        r3 = r6.this$0;
        r3 = com.techno.gallery.ImageBlockManager.access$1000(r3);
        r4 = r6.this$0;
        r4 = com.techno.gallery.ImageBlockManager.access$700(r4);
        r4 = r4.getImageAt(r2);
        r3 = r3.cancel(r4);
        if (r3 == 0) goto L_0x0040;
    L_0x0032:
        r3 = r6.mRequestedMask;
        r4 = r1 ^ -1;
        r3 = r3 & r4;
        r6.mRequestedMask = r3;
        r3 = r6.this$0;
        r4 = r3.mPendingRequest;
        r4 = r4 - r5;
        r3.mPendingRequest = r4;
    L_0x0040:
        r0 = r0 + 1;
        goto L_0x0002;
    L_0x0043:
        return;
    }

    private void drawBitmap(com.techno.gallery.gallery.IImage r9, android.graphics.Bitmap r10, int r11, int r12) {
        r8 = this;
        r0 = r8.this$0;
        r0 = com.techno.gallery.ImageBlockManager.access$1400(r0);
        r1 = r8.mCanvas;
        r2 = r8.this$0;
        r2 = com.techno.gallery.ImageBlockManager.access$1100(r2);
        r6 = r2.mCellWidth;
        r2 = r8.this$0;
        r2 = com.techno.gallery.ImageBlockManager.access$1100(r2);
        r7 = r2.mCellHeight;
        r2 = r9;
        r3 = r10;
        r4 = r11;
        r5 = r12;
        r0.drawImage(r1, r2, r3, r4, r5, r6, r7);
        r0 = r8.mCanvas;
        r1 = r8.this$0;
        r1 = com.techno.gallery.ImageBlockManager.access$1500(r1);
        r2 = (float) r11;
        r3 = (float) r12;
        r4 = 0;
        r0.drawBitmap(r1, r2, r3, r4);
        return;
    }

    private boolean isVisible() {
        r2 = this;
        r0 = r2.mRow;
        r1 = r2.this$0;
        r1 = com.techno.gallery.ImageBlockManager.access$300(r1);
        if (r0 < r1) goto L_0x0016;
    L_0x000a:
        r0 = r2.mRow;
        r1 = r2.this$0;
        r1 = com.techno.gallery.ImageBlockManager.access$400(r1);
        if (r0 >= r1) goto L_0x0016;
    L_0x0014:
        r0 = 1;
    L_0x0015:
        return r0;
    L_0x0016:
        r0 = 0;
        goto L_0x0015;
    }

    private void loadImageDone(com.techno.gallery.gallery.IImage r9, android.graphics.Bitmap r10, int r11) {
        r8 = this;
        r6 = 0;
        r7 = 1;
        r5 = r8.mBitmap;
        if (r5 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r5 = r8.this$0;
        r5 = com.techno.gallery.ImageBlockManager.access$1100(r5);
        r2 = r5.mCellSpacing;
        r5 = r8.this$0;
        r5 = com.techno.gallery.ImageBlockManager.access$1100(r5);
        r0 = r5.mLeftEdgePadding;
        r4 = r2;
        r5 = r8.this$0;
        r5 = com.techno.gallery.ImageBlockManager.access$1100(r5);
        r5 = r5.mCellWidth;
        r5 = r5 + r2;
        r5 = r5 * r11;
        r3 = r0 + r5;
        r8.drawBitmap(r9, r10, r3, r4);
        if (r10 == 0) goto L_0x002c;
    L_0x0029:
        r10.recycle();
    L_0x002c:
        r1 = r7 << r11;
        r5 = r8.mCompletedMask;
        r5 = r5 & r1;
        if (r5 != 0) goto L_0x0068;
    L_0x0033:
        r5 = r7;
    L_0x0034:
        com.techno.gallery.Util.Assert(r5);
        r5 = r8.mRequestedMask;
        r5 = r5 & r1;
        if (r5 == 0) goto L_0x006a;
    L_0x003c:
        r5 = r7;
    L_0x003d:
        com.techno.gallery.Util.Assert(r5);
        r5 = r8.mRequestedMask;
        r6 = r1 ^ -1;
        r5 = r5 & r6;
        r8.mRequestedMask = r5;
        r5 = r8.mCompletedMask;
        r5 = r5 | r1;
        r8.mCompletedMask = r5;
        r5 = r8.this$0;
        r6 = r5.mPendingRequest;
        r6 = r6 - r7;
        r5.mPendingRequest = r6;
        r5 = r8.isVisible();
        if (r5 == 0) goto L_0x0062;
    L_0x0059:
        r5 = r8.this$0;
        r5 = com.techno.gallery.ImageBlockManager.access$1200(r5);
        r5.run();
    L_0x0062:
        r5 = r8.this$0;
        com.techno.gallery.ImageBlockManager.access$1300(r5);
        goto L_0x0006;
    L_0x0068:
        r5 = r6;
        goto L_0x0034;
    L_0x006a:
        r5 = r6;
        goto L_0x003d;
    }

    public void cancelRequest(int r5) {
        r4 = this;
        r3 = 1;
        r0 = r3 << r5;
        r1 = r4.mRequestedMask;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x001b;
    L_0x0008:
        r1 = r3;
    L_0x0009:
        com.techno.gallery.Util.Assert(r1);
        r1 = r4.mRequestedMask;
        r2 = r0 ^ -1;
        r1 = r1 & r2;
        r4.mRequestedMask = r1;
        r1 = r4.this$0;
        r2 = r1.mPendingRequest;
        r2 = r2 - r3;
        r1.mPendingRequest = r2;
        return;
    L_0x001b:
        r1 = 0;
        goto L_0x0009;
    }

    public void doDraw(android.graphics.Canvas r20, int r21, int r22) {
        r19 = this;
        r0 = r19;
        r0 = r0.this$0;
        r5 = r0;
        r0 = r19;
        r0 = r0.mRow;
        r6 = r0;
        r11 = com.techno.gallery.ImageBlockManager.access$500(r5, r6);
        r0 = r19;
        r0 = r0.this$0;
        r5 = r0;
        r5 = com.techno.gallery.ImageBlockManager.access$600(r5);
        if (r11 != r5) goto L_0x0098;
    L_0x0019:
        r0 = r19;
        r0 = r0.mBitmap;
        r5 = r0;
        r0 = r21;
        r0 = (float) r0;
        r6 = r0;
        r0 = r22;
        r0 = (float) r0;
        r7 = r0;
        r8 = 0;
        r0 = r20;
        r1 = r5;
        r2 = r6;
        r3 = r7;
        r4 = r8;
        r0.drawBitmap(r1, r2, r3, r4);
    L_0x0030:
        r5 = 1;
        r5 = r5 << r11;
        r6 = 1;
        r5 = r5 - r6;
        r0 = r19;
        r0 = r0.mCompletedMask;
        r6 = r0;
        r6 = r6 ^ -1;
        r14 = r5 & r6;
        if (r14 == 0) goto L_0x011d;
    L_0x003f:
        r0 = r19;
        r0 = r0.this$0;
        r5 = r0;
        r5 = com.techno.gallery.ImageBlockManager.access$1100(r5);
        r5 = r5.mLeftEdgePadding;
        r17 = r21 + r5;
        r0 = r19;
        r0 = r0.this$0;
        r5 = r0;
        r5 = com.techno.gallery.ImageBlockManager.access$1100(r5);
        r5 = r5.mCellSpacing;
        r18 = r22 + r5;
        r13 = 0;
    L_0x005a:
        if (r13 >= r11) goto L_0x011d;
    L_0x005c:
        r5 = 1;
        r5 = r5 << r13;
        r5 = r5 & r14;
        if (r5 == 0) goto L_0x007c;
    L_0x0061:
        r0 = r19;
        r0 = r0.this$0;
        r5 = r0;
        r5 = com.techno.gallery.ImageBlockManager.access$1600(r5);
        r0 = r17;
        r0 = (float) r0;
        r6 = r0;
        r0 = r18;
        r0 = (float) r0;
        r7 = r0;
        r8 = 0;
        r0 = r20;
        r1 = r5;
        r2 = r6;
        r3 = r7;
        r4 = r8;
        r0.drawBitmap(r1, r2, r3, r4);
    L_0x007c:
        r0 = r19;
        r0 = r0.this$0;
        r5 = r0;
        r5 = com.techno.gallery.ImageBlockManager.access$1100(r5);
        r5 = r5.mCellWidth;
        r0 = r19;
        r0 = r0.this$0;
        r6 = r0;
        r6 = com.techno.gallery.ImageBlockManager.access$1100(r6);
        r6 = r6.mCellSpacing;
        r5 = r5 + r6;
        r17 = r17 + r5;
        r13 = r13 + 1;
        goto L_0x005a;
    L_0x0098:
        r0 = r21;
        r0 = (float) r0;
        r6 = r0;
        r0 = r22;
        r0 = (float) r0;
        r7 = r0;
        r0 = r19;
        r0 = r0.this$0;
        r5 = r0;
        r5 = com.techno.gallery.ImageBlockManager.access$100(r5);
        r5 = r5 + r21;
        r8 = (float) r5;
        r0 = r19;
        r0 = r0.this$0;
        r5 = r0;
        r5 = com.techno.gallery.ImageBlockManager.access$200(r5);
        r5 = r5 + r22;
        r9 = (float) r5;
        r0 = r19;
        r0 = r0.this$0;
        r5 = r0;
        r10 = r5.mBackgroundPaint;
        r5 = r20;
        r5.drawRect(r6, r7, r8, r9, r10);
        r0 = r19;
        r0 = r0.this$0;
        r5 = r0;
        r5 = com.techno.gallery.ImageBlockManager.access$1100(r5);
        r5 = r5.mLeftEdgePadding;
        r0 = r19;
        r0 = r0.this$0;
        r6 = r0;
        r6 = com.techno.gallery.ImageBlockManager.access$1100(r6);
        r6 = r6.mCellWidth;
        r0 = r19;
        r0 = r0.this$0;
        r7 = r0;
        r7 = com.techno.gallery.ImageBlockManager.access$1100(r7);
        r7 = r7.mCellSpacing;
        r6 = r6 + r7;
        r6 = r6 * r11;
        r16 = r5 + r6;
        r15 = new android.graphics.Rect;
        r5 = 0;
        r6 = 0;
        r0 = r19;
        r0 = r0.this$0;
        r7 = r0;
        r7 = com.techno.gallery.ImageBlockManager.access$200(r7);
        r0 = r15;
        r1 = r5;
        r2 = r6;
        r3 = r16;
        r4 = r7;
        r0.<init>(r1, r2, r3, r4);
        r12 = new android.graphics.Rect;
        r12.<init>(r15);
        r0 = r12;
        r1 = r21;
        r2 = r22;
        r0.offset(r1, r2);
        r0 = r19;
        r0 = r0.mBitmap;
        r5 = r0;
        r6 = 0;
        r0 = r20;
        r1 = r5;
        r2 = r15;
        r3 = r12;
        r4 = r6;
        r0.drawBitmap(r1, r2, r3, r4);
        goto L_0x0030;
    L_0x011d:
        return;
    }

    public boolean hasPendingRequests() {
        r1 = this;
        r0 = r1.mRequestedMask;
        if (r0 == 0) goto L_0x0006;
    L_0x0004:
        r0 = 1;
    L_0x0005:
        return r0;
    L_0x0006:
        r0 = 0;
        goto L_0x0005;
    }

    public void invalidate() {
        r1 = this;
        r0 = 0;
        r1.mCompletedMask = r0;
        return;
    }

    public int loadImages() {
        r14 = this;
        r13 = 0;
        r12 = 1;
        r9 = r14.mRow;
        r10 = -1;
        if (r9 == r10) goto L_0x0023;
    L_0x0007:
        r9 = r12;
    L_0x0008:
        com.techno.gallery.Util.Assert(r9);
        r9 = r14.this$0;
        r10 = r14.mRow;
        r4 = com.techno.gallery.ImageBlockManager.access$500(r9, r10);
        r9 = r12 << r4;
        r9 = r9 - r12;
        r10 = r14.mCompletedMask;
        r11 = r14.mRequestedMask;
        r10 = r10 | r11;
        r10 = r10 ^ -1;
        r6 = r9 & r10;
        if (r6 != 0) goto L_0x0025;
    L_0x0021:
        r9 = r13;
    L_0x0022:
        return r9;
    L_0x0023:
        r9 = r13;
        goto L_0x0008;
    L_0x0025:
        r8 = 0;
        r9 = r14.mRow;
        r10 = r14.this$0;
        r10 = com.techno.gallery.ImageBlockManager.access$600(r10);
        r0 = r9 * r10;
        r2 = 0;
    L_0x0031:
        if (r2 >= r4) goto L_0x0062;
    L_0x0033:
        r9 = r12 << r2;
        r9 = r9 & r6;
        if (r9 != 0) goto L_0x003b;
    L_0x0038:
        r2 = r2 + 1;
        goto L_0x0031;
    L_0x003b:
        r7 = r0 + r2;
        r9 = r14.this$0;
        r9 = com.techno.gallery.ImageBlockManager.access$700(r9);
        r5 = r9.getImageAt(r7);
        if (r5 == 0) goto L_0x0038;
    L_0x0049:
        r3 = r2;
        r1 = new com.techno.gallery.ImageBlockManager$ImageBlock$1;
        r1.<init>(r14, r5, r3);
        r9 = r14.this$0;
        r9 = com.techno.gallery.ImageBlockManager.access$1000(r9);
        r9.getBitmap(r5, r1, r7);
        r9 = r14.mRequestedMask;
        r10 = r12 << r2;
        r9 = r9 | r10;
        r14.mRequestedMask = r9;
        r8 = r8 + 1;
        goto L_0x0038;
    L_0x0062:
        r9 = r8;
        goto L_0x0022;
    }

    public void recycle() {
        r1 = this;
        r1.cancelAllRequests();
        r0 = r1.mBitmap;
        r0.recycle();
        r0 = 0;
        r1.mBitmap = r0;
        return;
    }

    public void setRow(int r1) {
        r0 = this;
        r0.mRow = r1;
        return;
    }
}