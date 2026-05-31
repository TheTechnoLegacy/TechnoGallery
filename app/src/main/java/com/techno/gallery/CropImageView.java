package com.techno.gallery;

/* compiled from: CropImage */
class CropImageView extends com.techno.gallery.ImageViewTouchBase {
    java.util.ArrayList<com.techno.gallery.HighlightView> mHighlightViews;
    float mLastX;
    float mLastY;
    int mMotionEdge;
    com.techno.gallery.HighlightView mMotionHighlightView;

    public CropImageView(android.content.Context r2, android.util.AttributeSet r3) {
        r1 = this;
        r1.<init>(r2, r3);
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1.mHighlightViews = r0;
        r0 = 0;
        r1.mMotionHighlightView = r0;
        return;
    }

    private void centerBasedOnHighlightView(com.techno.gallery.HighlightView r14) {
        r13 = this;
        r1 = r14.mDrawRect;
        r9 = r1.width();
        r5 = (float) r9;
        r9 = r1.height();
        r2 = (float) r9;
        r9 = r13.getWidth();
        r4 = (float) r9;
        r9 = r13.getHeight();
        r3 = (float) r9;
        r9 = r4 / r5;
        r10 = 1058642330; // 0x3f19999a float:0.6 double:5.230388065E-315;
        r6 = r9 * r10;
        r9 = r3 / r2;
        r10 = 1058642330; // 0x3f19999a float:0.6 double:5.230388065E-315;
        r7 = r9 * r10;
        r8 = java.lang.Math.min(r6, r7);
        r9 = r13.getScale();
        r8 = r8 * r9;
        r9 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r8 = java.lang.Math.max(r9, r8);
        r9 = r13.getScale();
        r9 = r8 - r9;
        r9 = java.lang.Math.abs(r9);
        r9 = r9 / r8;
        r9 = (double) r9;
        r11 = 4591870180066957722; // 0x3fb999999999999a float:-1.5881868E-23 double:0.1;
        r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));
        if (r9 <= 0) goto L_0x006f;
    L_0x0048:
        r9 = 2;
        r0 = new float[r9];
        r9 = 0;
        r10 = r14.mCropRect;
        r10 = r10.centerX();
        r0[r9] = r10;
        r9 = 1;
        r10 = r14.mCropRect;
        r10 = r10.centerY();
        r0[r9] = r10;
        r9 = r13.getImageMatrix();
        r9.mapPoints(r0);
        r9 = 0;
        r9 = r0[r9];
        r10 = 1;
        r10 = r0[r10];
        r11 = 1133903872; // 0x43960000 float:300.0 double:5.60222949E-315;
        r13.zoomTo(r8, r9, r10, r11);
    L_0x006f:
        r13.ensureVisible(r14);
        return;
    }

    private void ensureVisible(com.techno.gallery.HighlightView r11) {
        r10 = this;
        r9 = 0;
        r6 = r11.mDrawRect;
        r7 = r10.mLeft;
        r8 = r6.left;
        r7 = r7 - r8;
        r1 = java.lang.Math.max(r9, r7);
        r7 = r10.mRight;
        r8 = r6.right;
        r7 = r7 - r8;
        r2 = java.lang.Math.min(r9, r7);
        r7 = r10.mTop;
        r8 = r6.top;
        r7 = r7 - r8;
        r4 = java.lang.Math.max(r9, r7);
        r7 = r10.mBottom;
        r8 = r6.bottom;
        r7 = r7 - r8;
        r5 = java.lang.Math.min(r9, r7);
        if (r1 == 0) goto L_0x0037;
    L_0x0029:
        r0 = r1;
    L_0x002a:
        if (r4 == 0) goto L_0x0039;
    L_0x002c:
        r3 = r4;
    L_0x002d:
        if (r0 != 0) goto L_0x0031;
    L_0x002f:
        if (r3 == 0) goto L_0x0036;
    L_0x0031:
        r7 = (float) r0;
        r8 = (float) r3;
        r10.panBy(r7, r8);
    L_0x0036:
        return;
    L_0x0037:
        r0 = r2;
        goto L_0x002a;
    L_0x0039:
        r3 = r5;
        goto L_0x002d;
    }

    private void recomputeFocus(android.view.MotionEvent r7) {
        r6 = this;
        r5 = 1;
        r2 = 0;
    L_0x0002:
        r3 = r6.mHighlightViews;
        r3 = r3.size();
        if (r2 >= r3) goto L_0x001c;
    L_0x000a:
        r3 = r6.mHighlightViews;
        r1 = r3.get(r2);
        r1 = (com.techno.gallery.HighlightView) r1;
        r3 = 0;
        r1.setFocus(r3);
        r1.invalidate();
        r2 = r2 + 1;
        goto L_0x0002;
    L_0x001c:
        r2 = 0;
    L_0x001d:
        r3 = r6.mHighlightViews;
        r3 = r3.size();
        if (r2 >= r3) goto L_0x0047;
    L_0x0025:
        r3 = r6.mHighlightViews;
        r1 = r3.get(r2);
        r1 = (com.techno.gallery.HighlightView) r1;
        r3 = r7.getX();
        r4 = r7.getY();
        r0 = r1.getHit(r3, r4);
        if (r0 == r5) goto L_0x004b;
    L_0x003b:
        r3 = r1.hasFocus();
        if (r3 != 0) goto L_0x0047;
    L_0x0041:
        r1.setFocus(r5);
        r1.invalidate();
    L_0x0047:
        r6.invalidate();
        return;
    L_0x004b:
        r2 = r2 + 1;
        goto L_0x001d;
    }

    public void add(com.techno.gallery.HighlightView r2) {
        r1 = this;
        r0 = r1.mHighlightViews;
        r0.add(r2);
        r1.invalidate();
        return;
    }

    protected void onDraw(android.graphics.Canvas r3) {
        r2 = this;
        super.onDraw(r3);
        r0 = 0;
    L_0x0004:
        r1 = r2.mHighlightViews;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x001a;
    L_0x000c:
        r1 = r2.mHighlightViews;
        r1 = r1.get(r0);
        r1 = (com.techno.gallery.HighlightView) r1;
        r1.draw(r3);
        r0 = r0 + 1;
        goto L_0x0004;
    L_0x001a:
        return;
    }

    protected void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        r4 = this;
        super.onLayout(r5, r6, r7, r8, r9);
        r2 = r4.mBitmapDisplayed;
        r2 = r2.getBitmap();
        if (r2 == 0) goto L_0x0031;
    L_0x000b:
        r2 = r4.mHighlightViews;
        r1 = r2.iterator();
    L_0x0011:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0031;
    L_0x0017:
        r0 = r1.next();
        r0 = (com.techno.gallery.HighlightView) r0;
        r2 = r0.mMatrix;
        r3 = r4.getImageMatrix();
        r2.set(r3);
        r0.invalidate();
        r2 = r0.mIsFocused;
        if (r2 == 0) goto L_0x0011;
    L_0x002d:
        r4.centerBasedOnHighlightView(r0);
        goto L_0x0011;
    L_0x0031:
        return;
    }

    public boolean onTouchEvent(android.view.MotionEvent r12) {
        r11 = this;
        r6 = 0;
        r10 = 1;
        r0 = r11.mContext;
        r0 = (com.techno.gallery.CropImage) r0;
        r5 = r0.mSaving;
        if (r5 == 0) goto L_0x000c;
    L_0x000a:
        r5 = r6;
    L_0x000b:
        return r5;
    L_0x000c:
        r5 = r12.getAction();
        switch(r5) {
            case 0: goto L_0x001c;
            case 1: goto L_0x0065;
            case 2: goto L_0x00c0;
            default: goto L_0x0013;
        };
    L_0x0013:
        r5 = r12.getAction();
        switch(r5) {
            case 1: goto L_0x00f5;
            case 2: goto L_0x00fa;
            default: goto L_0x001a;
        };
    L_0x001a:
        r5 = r10;
        goto L_0x000b;
    L_0x001c:
        r5 = r0.mWaitingToPick;
        if (r5 == 0) goto L_0x0024;
    L_0x0020:
        r11.recomputeFocus(r12);
        goto L_0x0013;
    L_0x0024:
        r3 = 0;
    L_0x0025:
        r5 = r11.mHighlightViews;
        r5 = r5.size();
        if (r3 >= r5) goto L_0x0013;
    L_0x002d:
        r5 = r11.mHighlightViews;
        r2 = r5.get(r3);
        r2 = (com.techno.gallery.HighlightView) r2;
        r5 = r12.getX();
        r6 = r12.getY();
        r1 = r2.getHit(r5, r6);
        if (r1 == r10) goto L_0x0062;
    L_0x0043:
        r11.mMotionEdge = r1;
        r11.mMotionHighlightView = r2;
        r5 = r12.getX();
        r11.mLastX = r5;
        r5 = r12.getY();
        r11.mLastY = r5;
        r5 = r11.mMotionHighlightView;
        r6 = 32;
        if (r1 != r6) goto L_0x005f;
    L_0x0059:
        r6 = com.techno.gallery.HighlightView.ModifyMode.Move;
    L_0x005b:
        r5.setMode(r6);
        goto L_0x0013;
    L_0x005f:
        r6 = com.techno.gallery.HighlightView.ModifyMode.Grow;
        goto L_0x005b;
    L_0x0062:
        r3 = r3 + 1;
        goto L_0x0025;
    L_0x0065:
        r5 = r0.mWaitingToPick;
        if (r5 == 0) goto L_0x00ab;
    L_0x0069:
        r3 = 0;
    L_0x006a:
        r5 = r11.mHighlightViews;
        r5 = r5.size();
        if (r3 >= r5) goto L_0x00bb;
    L_0x0072:
        r5 = r11.mHighlightViews;
        r2 = r5.get(r3);
        r2 = (com.techno.gallery.HighlightView) r2;
        r5 = r2.hasFocus();
        if (r5 == 0) goto L_0x00a8;
    L_0x0080:
        r0.mCrop = r2;
        r4 = 0;
    L_0x0083:
        r5 = r11.mHighlightViews;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x009c;
    L_0x008b:
        if (r4 != r3) goto L_0x0090;
    L_0x008d:
        r4 = r4 + 1;
        goto L_0x0083;
    L_0x0090:
        r5 = r11.mHighlightViews;
        r5 = r5.get(r4);
        r5 = (com.techno.gallery.HighlightView) r5;
        r5.setHidden(r10);
        goto L_0x008d;
    L_0x009c:
        r11.centerBasedOnHighlightView(r2);
        r11 = r11.mContext;
        r11 = (com.techno.gallery.CropImage) r11;
        r11.mWaitingToPick = r6;
        r5 = r10;
        goto L_0x000b;
    L_0x00a8:
        r3 = r3 + 1;
        goto L_0x006a;
    L_0x00ab:
        r5 = r11.mMotionHighlightView;
        if (r5 == 0) goto L_0x00bb;
    L_0x00af:
        r5 = r11.mMotionHighlightView;
        r11.centerBasedOnHighlightView(r5);
        r5 = r11.mMotionHighlightView;
        r6 = com.techno.gallery.HighlightView.ModifyMode.None;
        r5.setMode(r6);
    L_0x00bb:
        r5 = 0;
        r11.mMotionHighlightView = r5;
        goto L_0x0013;
    L_0x00c0:
        r5 = r0.mWaitingToPick;
        if (r5 == 0) goto L_0x00c9;
    L_0x00c4:
        r11.recomputeFocus(r12);
        goto L_0x0013;
    L_0x00c9:
        r5 = r11.mMotionHighlightView;
        if (r5 == 0) goto L_0x0013;
    L_0x00cd:
        r5 = r11.mMotionHighlightView;
        r6 = r11.mMotionEdge;
        r7 = r12.getX();
        r8 = r11.mLastX;
        r7 = r7 - r8;
        r8 = r12.getY();
        r9 = r11.mLastY;
        r8 = r8 - r9;
        r5.handleMotion(r6, r7, r8);
        r5 = r12.getX();
        r11.mLastX = r5;
        r5 = r12.getY();
        r11.mLastY = r5;
        r5 = r11.mMotionHighlightView;
        r11.ensureVisible(r5);
        goto L_0x0013;
    L_0x00f5:
        r11.center(r10, r10);
        goto L_0x001a;
    L_0x00fa:
        r5 = r11.getScale();
        r6 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 != 0) goto L_0x001a;
    L_0x0104:
        r11.center(r10, r10);
        goto L_0x001a;
    }

    protected void postTranslate(float r4, float r5) {
        r3 = this;
        super.postTranslate(r4, r5);
        r1 = 0;
    L_0x0004:
        r2 = r3.mHighlightViews;
        r2 = r2.size();
        if (r1 >= r2) goto L_0x001f;
    L_0x000c:
        r2 = r3.mHighlightViews;
        r0 = r2.get(r1);
        r0 = (com.techno.gallery.HighlightView) r0;
        r2 = r0.mMatrix;
        r2.postTranslate(r4, r5);
        r0.invalidate();
        r1 = r1 + 1;
        goto L_0x0004;
    L_0x001f:
        return;
    }

    protected void zoomIn() {
        r4 = this;
        super.zoomIn();
        r2 = r4.mHighlightViews;
        r1 = r2.iterator();
    L_0x0009:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0022;
    L_0x000f:
        r0 = r1.next();
        r0 = (com.techno.gallery.HighlightView) r0;
        r2 = r0.mMatrix;
        r3 = r4.getImageMatrix();
        r2.set(r3);
        r0.invalidate();
        goto L_0x0009;
    L_0x0022:
        return;
    }

    protected void zoomOut() {
        r4 = this;
        super.zoomOut();
        r2 = r4.mHighlightViews;
        r1 = r2.iterator();
    L_0x0009:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0022;
    L_0x000f:
        r0 = r1.next();
        r0 = (com.techno.gallery.HighlightView) r0;
        r2 = r0.mMatrix;
        r3 = r4.getImageMatrix();
        r2.set(r3);
        r0.invalidate();
        goto L_0x0009;
    L_0x0022:
        return;
    }

    protected void zoomTo(float r5, float r6, float r7) {
        r4 = this;
        super.zoomTo(r5, r6, r7);
        r2 = r4.mHighlightViews;
        r1 = r2.iterator();
    L_0x0009:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0022;
    L_0x000f:
        r0 = r1.next();
        r0 = (com.techno.gallery.HighlightView) r0;
        r2 = r0.mMatrix;
        r3 = r4.getImageMatrix();
        r2.set(r3);
        r0.invalidate();
        goto L_0x0009;
    L_0x0022:
        return;
    }
}