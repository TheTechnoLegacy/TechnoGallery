package com.techno.gallery;

public class RotateBitmap {
    public static final java.lang.String TAG = "RotateBitmap";
    private android.graphics.Bitmap mBitmap;
    private int mRotation;

    public RotateBitmap(android.graphics.Bitmap r2) {
        r1 = this;
        r1.<init>();
        r1.mBitmap = r2;
        r0 = 0;
        r1.mRotation = r0;
        return;
    }

    public RotateBitmap(android.graphics.Bitmap r2, int r3) {
        r1 = this;
        r1.<init>();
        r1.mBitmap = r2;
        r0 = r3 % 360;
        r1.mRotation = r0;
        return;
    }

    public android.graphics.Bitmap getBitmap() {
        r1 = this;
        r0 = r1.mBitmap;
        return r0;
    }

    public int getHeight() {
        r1 = this;
        r0 = r1.isOrientationChanged();
        if (r0 == 0) goto L_0x000d;
    L_0x0006:
        r0 = r1.mBitmap;
        r0 = r0.getWidth();
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = r1.mBitmap;
        r0 = r0.getHeight();
        goto L_0x000c;
    }

    public android.graphics.Matrix getRotateMatrix() {
        r5 = this;
        r2 = new android.graphics.Matrix;
        r2.<init>();
        r3 = r5.mRotation;
        if (r3 == 0) goto L_0x0037;
    L_0x0009:
        r3 = r5.mBitmap;
        r3 = r3.getWidth();
        r0 = r3 / 2;
        r3 = r5.mBitmap;
        r3 = r3.getHeight();
        r1 = r3 / 2;
        r3 = -r0;
        r3 = (float) r3;
        r4 = -r1;
        r4 = (float) r4;
        r2.preTranslate(r3, r4);
        r3 = r5.mRotation;
        r3 = (float) r3;
        r2.postRotate(r3);
        r3 = r5.getWidth();
        r3 = r3 / 2;
        r3 = (float) r3;
        r4 = r5.getHeight();
        r4 = r4 / 2;
        r4 = (float) r4;
        r2.postTranslate(r3, r4);
    L_0x0037:
        return r2;
    }

    public int getRotation() {
        r1 = this;
        r0 = r1.mRotation;
        return r0;
    }

    public int getWidth() {
        r1 = this;
        r0 = r1.isOrientationChanged();
        if (r0 == 0) goto L_0x000d;
    L_0x0006:
        r0 = r1.mBitmap;
        r0 = r0.getHeight();
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = r1.mBitmap;
        r0 = r0.getWidth();
        goto L_0x000c;
    }

    public boolean isOrientationChanged() {
        r1 = this;
        r0 = r1.mRotation;
        r0 = r0 / 90;
        r0 = r0 % 2;
        if (r0 == 0) goto L_0x000a;
    L_0x0008:
        r0 = 1;
    L_0x0009:
        return r0;
    L_0x000a:
        r0 = 0;
        goto L_0x0009;
    }

    public void recycle() {
        r1 = this;
        r0 = r1.mBitmap;
        if (r0 == 0) goto L_0x000c;
    L_0x0004:
        r0 = r1.mBitmap;
        r0.recycle();
        r0 = 0;
        r1.mBitmap = r0;
    L_0x000c:
        return;
    }

    public void setBitmap(android.graphics.Bitmap r1) {
        r0 = this;
        r0.mBitmap = r1;
        return;
    }

    public void setRotation(int r1) {
        r0 = this;
        r0.mRotation = r1;
        return;
    }
}