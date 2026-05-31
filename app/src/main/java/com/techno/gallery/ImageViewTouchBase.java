package com.techno.gallery;

abstract class ImageViewTouchBase extends android.widget.ImageView {
    static final float SCALE_RATE = 1.25f;
    private static final java.lang.String TAG = "ImageViewTouchBase";
    protected android.graphics.Matrix mBaseMatrix;
    protected final com.techno.gallery.RotateBitmap mBitmapDisplayed;
    private final android.graphics.Matrix mDisplayMatrix;
    protected android.os.Handler mHandler;
    protected int mLastXTouchPos;
    protected int mLastYTouchPos;
    private final float[] mMatrixValues;
    float mMaxZoom;
    private java.lang.Runnable mOnLayoutRunnable;
    private com.techno.gallery.ImageViewTouchBase.Recycler mRecycler;
    protected android.graphics.Matrix mSuppMatrix;
    int mThisHeight;
    int mThisWidth;

    public ImageViewTouchBase(android.content.Context r4) {
        r3 = this;
        r2 = 0;
        r1 = -1;
        r3.<init>(r4);
        r0 = new android.graphics.Matrix;
        r0.<init>();
        r3.mBaseMatrix = r0;
        r0 = new android.graphics.Matrix;
        r0.<init>();
        r3.mSuppMatrix = r0;
        r0 = new android.graphics.Matrix;
        r0.<init>();
        r3.mDisplayMatrix = r0;
        r0 = 9;
        r0 = new float[r0];
        r3.mMatrixValues = r0;
        r0 = new com.techno.gallery.RotateBitmap;
        r0.<init>(r2);
        r3.mBitmapDisplayed = r0;
        r3.mThisWidth = r1;
        r3.mThisHeight = r1;
        r0 = new android.os.Handler;
        r0.<init>();
        r3.mHandler = r0;
        r3.mOnLayoutRunnable = r2;
        r3.init();
        return;
    }

    public ImageViewTouchBase(android.content.Context r4, android.util.AttributeSet r5) {
        r3 = this;
        r2 = 0;
        r1 = -1;
        r3.<init>(r4, r5);
        r0 = new android.graphics.Matrix;
        r0.<init>();
        r3.mBaseMatrix = r0;
        r0 = new android.graphics.Matrix;
        r0.<init>();
        r3.mSuppMatrix = r0;
        r0 = new android.graphics.Matrix;
        r0.<init>();
        r3.mDisplayMatrix = r0;
        r0 = 9;
        r0 = new float[r0];
        r3.mMatrixValues = r0;
        r0 = new com.techno.gallery.RotateBitmap;
        r0.<init>(r2);
        r3.mBitmapDisplayed = r0;
        r3.mThisWidth = r1;
        r3.mThisHeight = r1;
        r0 = new android.os.Handler;
        r0.<init>();
        r3.mHandler = r0;
        r3.mOnLayoutRunnable = r2;
        r3.init();
        return;
    }

    private void getProperBaseMatrix(com.techno.gallery.RotateBitmap r12, android.graphics.Matrix r13) {
        r11 = this;
        r10 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r8 = r11.getWidth();
        r5 = (float) r8;
        r8 = r11.getHeight();
        r4 = (float) r8;
        r8 = r12.getWidth();
        r6 = (float) r8;
        r8 = r12.getHeight();
        r0 = (float) r8;
        r2 = r12.getRotation();
        r13.reset();
        r8 = r5 / r6;
        r7 = java.lang.Math.min(r8, r10);
        r8 = r4 / r0;
        r1 = java.lang.Math.min(r8, r10);
        r3 = java.lang.Math.min(r7, r1);
        r8 = r12.getRotateMatrix();
        r13.postConcat(r8);
        r13.postScale(r3, r3);
        r8 = r6 * r3;
        r8 = r5 - r8;
        r8 = r8 / r10;
        r9 = r0 * r3;
        r9 = r4 - r9;
        r9 = r9 / r10;
        r13.postTranslate(r8, r9);
        return;
    }

    private void init() {
        r1 = this;
        r0 = android.widget.ImageView.ScaleType.MATRIX;
        r1.setScaleType(r0);
        return;
    }

    private void setImageBitmap(android.graphics.Bitmap r4, int r5) {
        r3 = this;
        super.setImageBitmap(r4);
        r0 = r3.getDrawable();
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r2 = 1;
        r0.setDither(r2);
    L_0x000d:
        r2 = r3.mBitmapDisplayed;
        r1 = r2.getBitmap();
        r2 = r3.mBitmapDisplayed;
        r2.setBitmap(r4);
        r2 = r3.mBitmapDisplayed;
        r2.setRotation(r5);
        if (r1 == 0) goto L_0x002a;
    L_0x001f:
        if (r1 == r4) goto L_0x002a;
    L_0x0021:
        r2 = r3.mRecycler;
        if (r2 == 0) goto L_0x002a;
    L_0x0025:
        r2 = r3.mRecycler;
        r2.recycle(r1);
    L_0x002a:
        return;
    }

    protected void center(boolean r13, boolean r14) {
        r12 = this;
        r11 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r10 = 0;
        r8 = r12.mBitmapDisplayed;
        r8 = r8.getBitmap();
        if (r8 != 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        r3 = r12.getImageViewMatrix();
        r4 = new android.graphics.RectF;
        r8 = r12.mBitmapDisplayed;
        r8 = r8.getBitmap();
        r8 = r8.getWidth();
        r8 = (float) r8;
        r9 = r12.mBitmapDisplayed;
        r9 = r9.getBitmap();
        r9 = r9.getHeight();
        r9 = (float) r9;
        r4.<init>(r10, r10, r8, r9);
        r3.mapRect(r4);
        r2 = r4.height();
        r7 = r4.width();
        r0 = 0;
        r1 = 0;
        if (r14 == 0) goto L_0x004a;
    L_0x003a:
        r5 = r12.getHeight();
        r8 = (float) r5;
        r8 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r8 >= 0) goto L_0x0067;
    L_0x0043:
        r8 = (float) r5;
        r8 = r8 - r2;
        r8 = r8 / r11;
        r9 = r4.top;
        r1 = r8 - r9;
    L_0x004a:
        if (r13 == 0) goto L_0x005c;
    L_0x004c:
        r6 = r12.getWidth();
        r8 = (float) r6;
        r8 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r8 >= 0) goto L_0x0082;
    L_0x0055:
        r8 = (float) r6;
        r8 = r8 - r7;
        r8 = r8 / r11;
        r9 = r4.left;
        r0 = r8 - r9;
    L_0x005c:
        r12.postTranslate(r0, r1);
        r8 = r12.getImageViewMatrix();
        r12.setImageMatrix(r8);
        goto L_0x000b;
    L_0x0067:
        r8 = r4.top;
        r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r8 <= 0) goto L_0x0071;
    L_0x006d:
        r8 = r4.top;
        r1 = -r8;
        goto L_0x004a;
    L_0x0071:
        r8 = r4.bottom;
        r9 = (float) r5;
        r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1));
        if (r8 >= 0) goto L_0x004a;
    L_0x0078:
        r8 = r12.getHeight();
        r8 = (float) r8;
        r9 = r4.bottom;
        r1 = r8 - r9;
        goto L_0x004a;
    L_0x0082:
        r8 = r4.left;
        r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r8 <= 0) goto L_0x008c;
    L_0x0088:
        r8 = r4.left;
        r0 = -r8;
        goto L_0x005c;
    L_0x008c:
        r8 = r4.right;
        r9 = (float) r6;
        r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1));
        if (r8 >= 0) goto L_0x005c;
    L_0x0093:
        r8 = (float) r6;
        r9 = r4.right;
        r0 = r8 - r9;
        goto L_0x005c;
    }

    public void clear() {
        r2 = this;
        r0 = 0;
        r1 = 1;
        r2.setImageBitmapResetBase(r0, r1);
        return;
    }

    protected android.graphics.Matrix getImageViewMatrix() {
        r2 = this;
        r0 = r2.mDisplayMatrix;
        r1 = r2.mBaseMatrix;
        r0.set(r1);
        r0 = r2.mDisplayMatrix;
        r1 = r2.mSuppMatrix;
        r0.postConcat(r1);
        r0 = r2.mDisplayMatrix;
        return r0;
    }

    protected float getScale() {
        r1 = this;
        r0 = r1.mSuppMatrix;
        r0 = r1.getScale(r0);
        return r0;
    }

    protected float getScale(android.graphics.Matrix r2) {
        r1 = this;
        r0 = 0;
        r0 = r1.getValue(r2, r0);
        return r0;
    }

    protected float getValue(android.graphics.Matrix r2, int r3) {
        r1 = this;
        r0 = r1.mMatrixValues;
        r2.getValues(r0);
        r0 = r1.mMatrixValues;
        r0 = r0[r3];
        return r0;
    }

    protected float maxZoom() {
        r5 = this;
        r3 = r5.mBitmapDisplayed;
        r3 = r3.getBitmap();
        if (r3 != 0) goto L_0x000b;
    L_0x0008:
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
    L_0x000a:
        return r3;
    L_0x000b:
        r3 = r5.mBitmapDisplayed;
        r3 = r3.getWidth();
        r3 = (float) r3;
        r4 = r5.mThisWidth;
        r4 = (float) r4;
        r1 = r3 / r4;
        r3 = r5.mBitmapDisplayed;
        r3 = r3.getHeight();
        r3 = (float) r3;
        r4 = r5.mThisHeight;
        r4 = (float) r4;
        r0 = r3 / r4;
        r3 = java.lang.Math.max(r1, r0);
        r4 = 1082130432; // 0x40800000 float:4.0 double:5.34643471E-315;
        r2 = r3 * r4;
        r3 = r2;
        goto L_0x000a;
    }

    public boolean onKeyDown(int r3, android.view.KeyEvent r4) {
        r2 = this;
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = 4;
        if (r3 != r0) goto L_0x0012;
    L_0x0005:
        r0 = r2.getScale();
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x0012;
    L_0x000d:
        r2.zoomTo(r1);
        r0 = 1;
    L_0x0011:
        return r0;
    L_0x0012:
        r0 = super.onKeyDown(r3, r4);
        goto L_0x0011;
    }

    protected void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        r3 = this;
        super.onLayout(r4, r5, r6, r7, r8);
        r1 = r7 - r5;
        r3.mThisWidth = r1;
        r1 = r8 - r6;
        r3.mThisHeight = r1;
        r0 = r3.mOnLayoutRunnable;
        if (r0 == 0) goto L_0x0015;
    L_0x000f:
        r1 = 0;
        r3.mOnLayoutRunnable = r1;
        r0.run();
    L_0x0015:
        r1 = r3.mBitmapDisplayed;
        r1 = r1.getBitmap();
        if (r1 == 0) goto L_0x002b;
    L_0x001d:
        r1 = r3.mBitmapDisplayed;
        r2 = r3.mBaseMatrix;
        r3.getProperBaseMatrix(r1, r2);
        r1 = r3.getImageViewMatrix();
        r3.setImageMatrix(r1);
    L_0x002b:
        return;
    }

    protected void panBy(float r2, float r3) {
        r1 = this;
        r1.postTranslate(r2, r3);
        r0 = r1.getImageViewMatrix();
        r1.setImageMatrix(r0);
        return;
    }

    protected void postTranslate(float r2, float r3) {
        r1 = this;
        r0 = r1.mSuppMatrix;
        r0.postTranslate(r2, r3);
        return;
    }

    public void setImageBitmap(android.graphics.Bitmap r2) {
        r1 = this;
        r0 = 0;
        r1.setImageBitmap(r2, r0);
        return;
    }

    public void setImageBitmapResetBase(android.graphics.Bitmap r2, boolean r3) {
        r1 = this;
        r0 = new com.techno.gallery.RotateBitmap;
        r0.<init>(r2);
        r1.setImageRotateBitmapResetBase(r0, r3);
        return;
    }

    public void setImageRotateBitmapResetBase(com.techno.gallery.RotateBitmap r4, boolean r5) {
        r3 = this;
        r0 = r3.getWidth();
        if (r0 > 0) goto L_0x000e;
    L_0x0006:
        r1 = new com.techno.gallery.ImageViewTouchBase$1;
        r1.<init>(r3, r4, r5);
        r3.mOnLayoutRunnable = r1;
    L_0x000d:
        return;
    L_0x000e:
        r1 = r4.getBitmap();
        if (r1 == 0) goto L_0x0039;
    L_0x0014:
        r1 = r3.mBaseMatrix;
        r3.getProperBaseMatrix(r4, r1);
        r1 = r4.getBitmap();
        r2 = r4.getRotation();
        r3.setImageBitmap(r1, r2);
    L_0x0024:
        if (r5 == 0) goto L_0x002b;
    L_0x0026:
        r1 = r3.mSuppMatrix;
        r1.reset();
    L_0x002b:
        r1 = r3.getImageViewMatrix();
        r3.setImageMatrix(r1);
        r1 = r3.maxZoom();
        r3.mMaxZoom = r1;
        goto L_0x000d;
    L_0x0039:
        r1 = r3.mBaseMatrix;
        r1.reset();
        r1 = 0;
        r3.setImageBitmap(r1);
        goto L_0x0024;
    }

    public void setRecycler(com.techno.gallery.ImageViewTouchBase.Recycler r1) {
        r0 = this;
        r0.mRecycler = r1;
        return;
    }

    protected void zoomIn() {
        r1 = this;
        r0 = 1067450368; // 0x3fa00000 float:1.25 double:5.273905555E-315;
        r1.zoomIn(r0);
        return;
    }

    protected void zoomIn(float r6) {
        r5 = this;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r5.getScale();
        r3 = r5.mMaxZoom;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 < 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r2 = r5.mBitmapDisplayed;
        r2 = r2.getBitmap();
        if (r2 == 0) goto L_0x000c;
    L_0x0015:
        r2 = r5.getWidth();
        r2 = (float) r2;
        r0 = r2 / r4;
        r2 = r5.getHeight();
        r2 = (float) r2;
        r1 = r2 / r4;
        r2 = r5.mSuppMatrix;
        r2.postScale(r6, r6, r0, r1);
        r2 = r5.getImageViewMatrix();
        r5.setImageMatrix(r2);
        goto L_0x000c;
    }

    protected void zoomOut() {
        r1 = this;
        r0 = 1067450368; // 0x3fa00000 float:1.25 double:5.273905555E-315;
        r1.zoomOut(r0);
        return;
    }

    protected void zoomOut(float r8) {
        r7 = this;
        r6 = 1;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = r7.mBitmapDisplayed;
        r3 = r3.getBitmap();
        if (r3 != 0) goto L_0x000e;
    L_0x000d:
        return;
    L_0x000e:
        r3 = r7.getWidth();
        r3 = (float) r3;
        r0 = r3 / r4;
        r3 = r7.getHeight();
        r3 = (float) r3;
        r1 = r3 / r4;
        r2 = new android.graphics.Matrix;
        r3 = r7.mSuppMatrix;
        r2.<init>(r3);
        r3 = r5 / r8;
        r4 = r5 / r8;
        r2.postScale(r3, r4, r0, r1);
        r3 = r7.getScale(r2);
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 >= 0) goto L_0x0042;
    L_0x0032:
        r3 = r7.mSuppMatrix;
        r3.setScale(r5, r5, r0, r1);
    L_0x0037:
        r3 = r7.getImageViewMatrix();
        r7.setImageMatrix(r3);
        r7.center(r6, r6);
        goto L_0x000d;
    L_0x0042:
        r3 = r7.mSuppMatrix;
        r4 = r5 / r8;
        r5 = r5 / r8;
        r3.postScale(r4, r5, r0, r1);
        goto L_0x0037;
    }

    protected void zoomTo(float r5) {
        r4 = this;
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r4.getWidth();
        r2 = (float) r2;
        r0 = r2 / r3;
        r2 = r4.getHeight();
        r2 = (float) r2;
        r1 = r2 / r3;
        r4.zoomTo(r5, r0, r1);
        return;
    }

    protected void zoomTo(float r5, float r6, float r7) {
        r4 = this;
        r3 = 1;
        r2 = r4.mMaxZoom;
        r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x0009;
    L_0x0007:
        r5 = r4.mMaxZoom;
    L_0x0009:
        r1 = r4.getScale();
        r0 = r5 / r1;
        r2 = r4.mSuppMatrix;
        r2.postScale(r0, r0, r6, r7);
        r2 = r4.getImageViewMatrix();
        r4.setImageMatrix(r2);
        r4.center(r3, r3);
        return;
    }

    protected void zoomTo(float r11, float r12, float r13, float r14) {
        r10 = this;
        r0 = r10.getScale();
        r0 = r11 - r0;
        r6 = r0 / r14;
        r5 = r10.getScale();
        r3 = java.lang.System.currentTimeMillis();
        r9 = r10.mHandler;
        r0 = new com.techno.gallery.ImageViewTouchBase$2;
        r1 = r10;
        r2 = r14;
        r7 = r12;
        r8 = r13;
        r0.<init>(r1, r2, r3, r5, r6, r7, r8);
        r9.post(r0);
        return;
    }
}