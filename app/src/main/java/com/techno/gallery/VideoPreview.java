package com.techno.gallery;

class VideoPreview extends android.view.SurfaceView {
    public static final float DONT_CARE = 0.0f;
    private static final java.lang.String TAG = "VideoPreview";
    private float mAspectRatio;
    private int mHorizontalTileSize;
    private int mVerticalTileSize;

    public VideoPreview(android.content.Context r2) {
        r1 = this;
        r0 = 1;
        r1.<init>(r2);
        r1.mHorizontalTileSize = r0;
        r1.mVerticalTileSize = r0;
        return;
    }

    public VideoPreview(android.content.Context r2, android.util.AttributeSet r3) {
        r1 = this;
        r0 = 1;
        r1.<init>(r2, r3);
        r1.mHorizontalTileSize = r0;
        r1.mVerticalTileSize = r0;
        return;
    }

    public VideoPreview(android.content.Context r2, android.util.AttributeSet r3, int r4) {
        r1 = this;
        r0 = 1;
        r1.<init>(r2, r3, r4);
        r1.mHorizontalTileSize = r0;
        r1.mVerticalTileSize = r0;
        return;
    }

    private int roundUpToTile(int r3, int r4, int r5) {
        r2 = this;
        r0 = r3 + r4;
        r1 = 1;
        r0 = r0 - r1;
        r0 = r0 / r4;
        r0 = r0 * r4;
        r0 = java.lang.Math.min(r0, r5);
        return r0;
    }

    protected void onMeasure(int r9, int r10) {
        r8 = this;
        r5 = r8.mAspectRatio;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 == 0) goto L_0x006e;
    L_0x0007:
        r4 = android.view.View.MeasureSpec.getSize(r9);
        r2 = android.view.View.MeasureSpec.getSize(r10);
        r3 = r4;
        r1 = r2;
        if (r3 <= 0) goto L_0x006e;
    L_0x0013:
        if (r1 <= 0) goto L_0x006e;
    L_0x0015:
        r5 = (float) r3;
        r6 = (float) r1;
        r0 = r5 / r6;
        r5 = r8.mAspectRatio;
        r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        if (r5 >= 0) goto L_0x0062;
    L_0x001f:
        r5 = (float) r3;
        r6 = r8.mAspectRatio;
        r5 = r5 / r6;
        r1 = (int) r5;
    L_0x0024:
        r5 = r8.mHorizontalTileSize;
        r3 = r8.roundUpToTile(r3, r5, r4);
        r5 = r8.mVerticalTileSize;
        r1 = r8.roundUpToTile(r1, r5, r2);
        r5 = "VideoPreview";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "ar ";
        r6 = r6.append(r7);
        r7 = r8.mAspectRatio;
        r6 = r6.append(r7);
        r7 = " setting size: ";
        r6 = r6.append(r7);
        r6 = r6.append(r3);
        r7 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        r6 = r6.append(r7);
        r6 = r6.append(r1);
        r6 = r6.toString();
        android.util.Log.i(r5, r6);
        r8.setMeasuredDimension(r3, r1);
    L_0x0061:
        return;
    L_0x0062:
        r5 = r8.mAspectRatio;
        r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        if (r5 <= 0) goto L_0x0024;
    L_0x0068:
        r5 = (float) r1;
        r6 = r8.mAspectRatio;
        r5 = r5 * r6;
        r3 = (int) r5;
        goto L_0x0024;
    L_0x006e:
        super.onMeasure(r9, r10);
        goto L_0x0061;
    }

    public void setAspectRatio(float r2) {
        r1 = this;
        r0 = r1.mAspectRatio;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 == 0) goto L_0x000e;
    L_0x0006:
        r1.mAspectRatio = r2;
        r1.requestLayout();
        r1.invalidate();
    L_0x000e:
        return;
    }

    public void setAspectRatio(int r3, int r4) {
        r2 = this;
        r0 = (float) r3;
        r1 = (float) r4;
        r0 = r0 / r1;
        r2.setAspectRatio(r0);
        return;
    }
}