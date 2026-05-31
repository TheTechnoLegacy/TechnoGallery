package com.techno.gallery;

class HighlightView {
    public static final int GROW_BOTTOM_EDGE = 16;
    public static final int GROW_LEFT_EDGE = 2;
    public static final int GROW_NONE = 1;
    public static final int GROW_RIGHT_EDGE = 4;
    public static final int GROW_TOP_EDGE = 8;
    public static final int MOVE = 32;
    private static final java.lang.String TAG = "HighlightView";
    private boolean mCircle;
    android.view.View mContext;
    android.graphics.RectF mCropRect;
    android.graphics.Rect mDrawRect;
    private final android.graphics.Paint mFocusPaint;
    boolean mHidden;
    private android.graphics.RectF mImageRect;
    private float mInitialAspectRatio;
    boolean mIsFocused;
    private boolean mMaintainAspectRatio;
    android.graphics.Matrix mMatrix;
    private com.techno.gallery.HighlightView.ModifyMode mMode;
    private final android.graphics.Paint mNoFocusPaint;
    private final android.graphics.Paint mOutlinePaint;
    private android.graphics.drawable.Drawable mResizeDrawableDiagonal;
    private android.graphics.drawable.Drawable mResizeDrawableHeight;
    private android.graphics.drawable.Drawable mResizeDrawableWidth;

    public HighlightView(android.view.View r3) {
        r2 = this;
        r1 = 0;
        r2.<init>();
        r0 = com.techno.gallery.HighlightView.ModifyMode.None;
        r2.mMode = r0;
        r2.mMaintainAspectRatio = r1;
        r2.mCircle = r1;
        r0 = new android.graphics.Paint;
        r0.<init>();
        r2.mFocusPaint = r0;
        r0 = new android.graphics.Paint;
        r0.<init>();
        r2.mNoFocusPaint = r0;
        r0 = new android.graphics.Paint;
        r0.<init>();
        r2.mOutlinePaint = r0;
        r2.mContext = r3;
        return;
    }

    private android.graphics.Rect computeLayout() {
        r6 = this;
        r0 = new android.graphics.RectF;
        r1 = r6.mCropRect;
        r1 = r1.left;
        r2 = r6.mCropRect;
        r2 = r2.top;
        r3 = r6.mCropRect;
        r3 = r3.right;
        r4 = r6.mCropRect;
        r4 = r4.bottom;
        r0.<init>(r1, r2, r3, r4);
        r1 = r6.mMatrix;
        r1.mapRect(r0);
        r1 = new android.graphics.Rect;
        r2 = r0.left;
        r2 = java.lang.Math.round(r2);
        r3 = r0.top;
        r3 = java.lang.Math.round(r3);
        r4 = r0.right;
        r4 = java.lang.Math.round(r4);
        r5 = r0.bottom;
        r5 = java.lang.Math.round(r5);
        r1.<init>(r2, r3, r4, r5);
        return r1;
    }

    private void init() {
        r2 = this;
        r1 = r2.mContext;
        r0 = r1.getResources();
        r1 = 2130837549; // 0x7f02002d float:1.7280055E38 double:1.05277363E-314;
        r1 = r0.getDrawable(r1);
        r2.mResizeDrawableWidth = r1;
        r1 = 2130837548; // 0x7f02002c float:1.7280053E38 double:1.0527736293E-314;
        r1 = r0.getDrawable(r1);
        r2.mResizeDrawableHeight = r1;
        r1 = 2130837608; // 0x7f020068 float:1.7280175E38 double:1.052773659E-314;
        r1 = r0.getDrawable(r1);
        r2.mResizeDrawableDiagonal = r1;
        return;
    }

    protected void draw(android.graphics.Canvas r29) {
        r28 = this;
        r0 = r28;
        r0 = r0.mHidden;
        r22 = r0;
        if (r22 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r29.save();
        r11 = new android.graphics.Path;
        r11.<init>();
        r22 = r28.hasFocus();
        if (r22 != 0) goto L_0x0038;
    L_0x0017:
        r0 = r28;
        r0 = r0.mOutlinePaint;
        r22 = r0;
        r23 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r22.setColor(r23);
        r0 = r28;
        r0 = r0.mDrawRect;
        r22 = r0;
        r0 = r28;
        r0 = r0.mOutlinePaint;
        r23 = r0;
        r0 = r29;
        r1 = r22;
        r2 = r23;
        r0.drawRect(r1, r2);
        goto L_0x0008;
    L_0x0038:
        r14 = new android.graphics.Rect;
        r14.<init>();
        r0 = r28;
        r0 = r0.mContext;
        r22 = r0;
        r0 = r22;
        r1 = r14;
        r0.getDrawingRect(r1);
        r0 = r28;
        r0 = r0.mCircle;
        r22 = r0;
        if (r22 == 0) goto L_0x01b2;
    L_0x0051:
        r0 = r28;
        r0 = r0.mDrawRect;
        r22 = r0;
        r22 = r22.width();
        r0 = r22;
        r0 = (float) r0;
        r15 = r0;
        r0 = r28;
        r0 = r0.mDrawRect;
        r22 = r0;
        r22 = r22.height();
        r0 = r22;
        r0 = (float) r0;
        r7 = r0;
        r0 = r28;
        r0 = r0.mDrawRect;
        r22 = r0;
        r0 = r22;
        r0 = r0.left;
        r22 = r0;
        r0 = r22;
        r0 = (float) r0;
        r22 = r0;
        r23 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r23 = r15 / r23;
        r22 = r22 + r23;
        r0 = r28;
        r0 = r0.mDrawRect;
        r23 = r0;
        r0 = r23;
        r0 = r0.top;
        r23 = r0;
        r0 = r23;
        r0 = (float) r0;
        r23 = r0;
        r24 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r24 = r7 / r24;
        r23 = r23 + r24;
        r24 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r24 = r15 / r24;
        r25 = android.graphics.Path.Direction.CW;
        r0 = r11;
        r1 = r22;
        r2 = r23;
        r3 = r24;
        r4 = r25;
        r0.addCircle(r1, r2, r3, r4);
        r0 = r28;
        r0 = r0.mOutlinePaint;
        r22 = r0;
        r23 = -1112874; // 0xffffffffffef04d6 float:NaN double:NaN;
        r22.setColor(r23);
    L_0x00b9:
        r22 = android.graphics.Region.Op.DIFFERENCE;
        r0 = r29;
        r1 = r11;
        r2 = r22;
        r0.clipPath(r1, r2);
        r22 = r28.hasFocus();
        if (r22 == 0) goto L_0x01d4;
    L_0x00c9:
        r0 = r28;
        r0 = r0.mFocusPaint;
        r22 = r0;
    L_0x00cf:
        r0 = r29;
        r1 = r14;
        r2 = r22;
        r0.drawRect(r1, r2);
        r29.restore();
        r0 = r28;
        r0 = r0.mOutlinePaint;
        r22 = r0;
        r0 = r29;
        r1 = r11;
        r2 = r22;
        r0.drawPath(r1, r2);
        r0 = r28;
        r0 = r0.mMode;
        r22 = r0;
        r23 = com.techno.gallery.HighlightView.ModifyMode.Grow;
        r0 = r22;
        r1 = r23;
        if (r0 != r1) goto L_0x0008;
    L_0x00f6:
        r0 = r28;
        r0 = r0.mCircle;
        r22 = r0;
        if (r22 == 0) goto L_0x01dc;
    L_0x00fe:
        r0 = r28;
        r0 = r0.mResizeDrawableDiagonal;
        r22 = r0;
        r15 = r22.getIntrinsicWidth();
        r0 = r28;
        r0 = r0.mResizeDrawableDiagonal;
        r22 = r0;
        r7 = r22.getIntrinsicHeight();
        r22 = 4605249457297304856; // 0x3fe921fb54442d18 float:3.3702806E12 double:0.7853981633974483;
        r22 = java.lang.Math.cos(r22);
        r0 = r28;
        r0 = r0.mDrawRect;
        r24 = r0;
        r24 = r24.width();
        r0 = r24;
        r0 = (double) r0;
        r24 = r0;
        r26 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r24 = r24 / r26;
        r22 = r22 * r24;
        r22 = java.lang.Math.round(r22);
        r0 = r22;
        r0 = (int) r0;
        r6 = r0;
        r0 = r28;
        r0 = r0.mDrawRect;
        r22 = r0;
        r0 = r22;
        r0 = r0.left;
        r22 = r0;
        r0 = r28;
        r0 = r0.mDrawRect;
        r23 = r0;
        r23 = r23.width();
        r23 = r23 / 2;
        r22 = r22 + r23;
        r22 = r22 + r6;
        r23 = r15 / 2;
        r18 = r22 - r23;
        r0 = r28;
        r0 = r0.mDrawRect;
        r22 = r0;
        r0 = r22;
        r0 = r0.top;
        r22 = r0;
        r0 = r28;
        r0 = r0.mDrawRect;
        r23 = r0;
        r23 = r23.height();
        r23 = r23 / 2;
        r22 = r22 + r23;
        r22 = r22 - r6;
        r23 = r7 / 2;
        r20 = r22 - r23;
        r0 = r28;
        r0 = r0.mResizeDrawableDiagonal;
        r22 = r0;
        r0 = r28;
        r0 = r0.mResizeDrawableDiagonal;
        r23 = r0;
        r23 = r23.getIntrinsicWidth();
        r23 = r23 + r18;
        r0 = r28;
        r0 = r0.mResizeDrawableDiagonal;
        r24 = r0;
        r24 = r24.getIntrinsicHeight();
        r24 = r24 + r20;
        r0 = r22;
        r1 = r18;
        r2 = r20;
        r3 = r23;
        r4 = r24;
        r0.setBounds(r1, r2, r3, r4);
        r0 = r28;
        r0 = r0.mResizeDrawableDiagonal;
        r22 = r0;
        r0 = r22;
        r1 = r29;
        r0.draw(r1);
        goto L_0x0008;
    L_0x01b2:
        r22 = new android.graphics.RectF;
        r0 = r28;
        r0 = r0.mDrawRect;
        r23 = r0;
        r22.<init>(r23);
        r23 = android.graphics.Path.Direction.CW;
        r0 = r11;
        r1 = r22;
        r2 = r23;
        r0.addRect(r1, r2);
        r0 = r28;
        r0 = r0.mOutlinePaint;
        r22 = r0;
        r23 = -30208; // 0xffffffffffff8a00 float:NaN double:NaN;
        r22.setColor(r23);
        goto L_0x00b9;
    L_0x01d4:
        r0 = r28;
        r0 = r0.mNoFocusPaint;
        r22 = r0;
        goto L_0x00cf;
    L_0x01dc:
        r0 = r28;
        r0 = r0.mDrawRect;
        r22 = r0;
        r0 = r22;
        r0 = r0.left;
        r22 = r0;
        r10 = r22 + 1;
        r0 = r28;
        r0 = r0.mDrawRect;
        r22 = r0;
        r0 = r22;
        r0 = r0.right;
        r22 = r0;
        r12 = r22 + 1;
        r0 = r28;
        r0 = r0.mDrawRect;
        r22 = r0;
        r0 = r22;
        r0 = r0.top;
        r22 = r0;
        r13 = r22 + 4;
        r0 = r28;
        r0 = r0.mDrawRect;
        r22 = r0;
        r0 = r22;
        r0 = r0.bottom;
        r22 = r0;
        r5 = r22 + 3;
        r0 = r28;
        r0 = r0.mResizeDrawableWidth;
        r22 = r0;
        r22 = r22.getIntrinsicWidth();
        r17 = r22 / 2;
        r0 = r28;
        r0 = r0.mResizeDrawableWidth;
        r22 = r0;
        r22 = r22.getIntrinsicHeight();
        r16 = r22 / 2;
        r0 = r28;
        r0 = r0.mResizeDrawableHeight;
        r22 = r0;
        r22 = r22.getIntrinsicHeight();
        r8 = r22 / 2;
        r0 = r28;
        r0 = r0.mResizeDrawableHeight;
        r22 = r0;
        r22 = r22.getIntrinsicWidth();
        r9 = r22 / 2;
        r0 = r28;
        r0 = r0.mDrawRect;
        r22 = r0;
        r0 = r22;
        r0 = r0.left;
        r22 = r0;
        r0 = r28;
        r0 = r0.mDrawRect;
        r23 = r0;
        r0 = r23;
        r0 = r0.right;
        r23 = r0;
        r0 = r28;
        r0 = r0.mDrawRect;
        r24 = r0;
        r0 = r24;
        r0 = r0.left;
        r24 = r0;
        r23 = r23 - r24;
        r23 = r23 / 2;
        r19 = r22 + r23;
        r0 = r28;
        r0 = r0.mDrawRect;
        r22 = r0;
        r0 = r22;
        r0 = r0.top;
        r22 = r0;
        r0 = r28;
        r0 = r0.mDrawRect;
        r23 = r0;
        r0 = r23;
        r0 = r0.bottom;
        r23 = r0;
        r0 = r28;
        r0 = r0.mDrawRect;
        r24 = r0;
        r0 = r24;
        r0 = r0.top;
        r24 = r0;
        r23 = r23 - r24;
        r23 = r23 / 2;
        r21 = r22 + r23;
        r0 = r28;
        r0 = r0.mResizeDrawableWidth;
        r22 = r0;
        r23 = r10 - r17;
        r24 = r21 - r16;
        r25 = r10 + r17;
        r26 = r21 + r16;
        r22.setBounds(r23, r24, r25, r26);
        r0 = r28;
        r0 = r0.mResizeDrawableWidth;
        r22 = r0;
        r0 = r22;
        r1 = r29;
        r0.draw(r1);
        r0 = r28;
        r0 = r0.mResizeDrawableWidth;
        r22 = r0;
        r23 = r12 - r17;
        r24 = r21 - r16;
        r25 = r12 + r17;
        r26 = r21 + r16;
        r22.setBounds(r23, r24, r25, r26);
        r0 = r28;
        r0 = r0.mResizeDrawableWidth;
        r22 = r0;
        r0 = r22;
        r1 = r29;
        r0.draw(r1);
        r0 = r28;
        r0 = r0.mResizeDrawableHeight;
        r22 = r0;
        r23 = r19 - r9;
        r24 = r13 - r8;
        r25 = r19 + r9;
        r26 = r13 + r8;
        r22.setBounds(r23, r24, r25, r26);
        r0 = r28;
        r0 = r0.mResizeDrawableHeight;
        r22 = r0;
        r0 = r22;
        r1 = r29;
        r0.draw(r1);
        r0 = r28;
        r0 = r0.mResizeDrawableHeight;
        r22 = r0;
        r23 = r19 - r9;
        r24 = r5 - r8;
        r25 = r19 + r9;
        r26 = r5 + r8;
        r22.setBounds(r23, r24, r25, r26);
        r0 = r28;
        r0 = r0.mResizeDrawableHeight;
        r22 = r0;
        r0 = r22;
        r1 = r29;
        r0.draw(r1);
        goto L_0x0008;
    }

    public android.graphics.Rect getCropRect() {
        r5 = this;
        r0 = new android.graphics.Rect;
        r1 = r5.mCropRect;
        r1 = r1.left;
        r1 = (int) r1;
        r2 = r5.mCropRect;
        r2 = r2.top;
        r2 = (int) r2;
        r3 = r5.mCropRect;
        r3 = r3.right;
        r3 = (int) r3;
        r4 = r5.mCropRect;
        r4 = r4.bottom;
        r4 = (int) r4;
        r0.<init>(r1, r2, r3, r4);
        return r0;
    }

    public int getHit(float r13, float r14) {
        r12 = this;
        r6 = r12.computeLayout();
        r5 = 1101004800; // 0x41a00000 float:20.0 double:5.439686476E-315;
        r8 = 1;
        r10 = r12.mCircle;
        if (r10 == 0) goto L_0x0060;
    L_0x000b:
        r10 = r6.centerX();
        r10 = (float) r10;
        r1 = r13 - r10;
        r10 = r6.centerY();
        r10 = (float) r10;
        r2 = r14 - r10;
        r10 = r1 * r1;
        r11 = r2 * r2;
        r10 = r10 + r11;
        r10 = (double) r10;
        r10 = java.lang.Math.sqrt(r10);
        r3 = (int) r10;
        r10 = r12.mDrawRect;
        r10 = r10.width();
        r7 = r10 / 2;
        r0 = r3 - r7;
        r10 = java.lang.Math.abs(r0);
        r10 = (float) r10;
        r11 = 1101004800; // 0x41a00000 float:20.0 double:5.439686476E-315;
        r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1));
        if (r10 > 0) goto L_0x0059;
    L_0x0039:
        r10 = java.lang.Math.abs(r2);
        r11 = java.lang.Math.abs(r1);
        r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1));
        if (r10 <= 0) goto L_0x0050;
    L_0x0045:
        r10 = 0;
        r10 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r10 >= 0) goto L_0x004d;
    L_0x004a:
        r8 = 8;
    L_0x004c:
        return r8;
    L_0x004d:
        r8 = 16;
        goto L_0x004c;
    L_0x0050:
        r10 = 0;
        r10 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1));
        if (r10 >= 0) goto L_0x0057;
    L_0x0055:
        r8 = 2;
        goto L_0x004c;
    L_0x0057:
        r8 = 4;
        goto L_0x004c;
    L_0x0059:
        if (r3 >= r7) goto L_0x005e;
    L_0x005b:
        r8 = 32;
        goto L_0x004c;
    L_0x005e:
        r8 = 1;
        goto L_0x004c;
    L_0x0060:
        r10 = r6.top;
        r10 = (float) r10;
        r11 = 1101004800; // 0x41a00000 float:20.0 double:5.439686476E-315;
        r10 = r10 - r11;
        r10 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1));
        if (r10 < 0) goto L_0x00e3;
    L_0x006a:
        r10 = r6.bottom;
        r10 = (float) r10;
        r11 = 1101004800; // 0x41a00000 float:20.0 double:5.439686476E-315;
        r10 = r10 + r11;
        r10 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1));
        if (r10 >= 0) goto L_0x00e3;
    L_0x0074:
        r10 = 1;
        r9 = r10;
    L_0x0076:
        r10 = r6.left;
        r10 = (float) r10;
        r11 = 1101004800; // 0x41a00000 float:20.0 double:5.439686476E-315;
        r10 = r10 - r11;
        r10 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1));
        if (r10 < 0) goto L_0x00e6;
    L_0x0080:
        r10 = r6.right;
        r10 = (float) r10;
        r11 = 1101004800; // 0x41a00000 float:20.0 double:5.439686476E-315;
        r10 = r10 + r11;
        r10 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1));
        if (r10 >= 0) goto L_0x00e6;
    L_0x008a:
        r10 = 1;
        r4 = r10;
    L_0x008c:
        r10 = r6.left;
        r10 = (float) r10;
        r10 = r10 - r13;
        r10 = java.lang.Math.abs(r10);
        r11 = 1101004800; // 0x41a00000 float:20.0 double:5.439686476E-315;
        r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1));
        if (r10 >= 0) goto L_0x009e;
    L_0x009a:
        if (r9 == 0) goto L_0x009e;
    L_0x009c:
        r8 = r8 | 2;
    L_0x009e:
        r10 = r6.right;
        r10 = (float) r10;
        r10 = r10 - r13;
        r10 = java.lang.Math.abs(r10);
        r11 = 1101004800; // 0x41a00000 float:20.0 double:5.439686476E-315;
        r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1));
        if (r10 >= 0) goto L_0x00b0;
    L_0x00ac:
        if (r9 == 0) goto L_0x00b0;
    L_0x00ae:
        r8 = r8 | 4;
    L_0x00b0:
        r10 = r6.top;
        r10 = (float) r10;
        r10 = r10 - r14;
        r10 = java.lang.Math.abs(r10);
        r11 = 1101004800; // 0x41a00000 float:20.0 double:5.439686476E-315;
        r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1));
        if (r10 >= 0) goto L_0x00c2;
    L_0x00be:
        if (r4 == 0) goto L_0x00c2;
    L_0x00c0:
        r8 = r8 | 8;
    L_0x00c2:
        r10 = r6.bottom;
        r10 = (float) r10;
        r10 = r10 - r14;
        r10 = java.lang.Math.abs(r10);
        r11 = 1101004800; // 0x41a00000 float:20.0 double:5.439686476E-315;
        r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1));
        if (r10 >= 0) goto L_0x00d4;
    L_0x00d0:
        if (r4 == 0) goto L_0x00d4;
    L_0x00d2:
        r8 = r8 | 16;
    L_0x00d4:
        r10 = 1;
        if (r8 != r10) goto L_0x004c;
    L_0x00d7:
        r10 = (int) r13;
        r11 = (int) r14;
        r10 = r6.contains(r10, r11);
        if (r10 == 0) goto L_0x004c;
    L_0x00df:
        r8 = 32;
        goto L_0x004c;
    L_0x00e3:
        r10 = 0;
        r9 = r10;
        goto L_0x0076;
    L_0x00e6:
        r10 = 0;
        r4 = r10;
        goto L_0x008c;
    }

    void growBy(float r10, float r11) {
        r9 = this;
        r8 = 1103626240; // 0x41c80000 float:25.0 double:5.45263811E-315;
        r7 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = 0;
        r4 = r9.mMaintainAspectRatio;
        if (r4 == 0) goto L_0x0011;
    L_0x0009:
        r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x00dd;
    L_0x000d:
        r4 = r9.mInitialAspectRatio;
        r11 = r10 / r4;
    L_0x0011:
        r2 = new android.graphics.RectF;
        r4 = r9.mCropRect;
        r2.<init>(r4);
        r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x0043;
    L_0x001c:
        r4 = r2.width();
        r5 = r7 * r10;
        r4 = r4 + r5;
        r5 = r9.mImageRect;
        r5 = r5.width();
        r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r4 <= 0) goto L_0x0043;
    L_0x002d:
        r4 = r9.mImageRect;
        r4 = r4.width();
        r5 = r2.width();
        r4 = r4 - r5;
        r0 = r4 / r7;
        r10 = r0;
        r4 = r9.mMaintainAspectRatio;
        if (r4 == 0) goto L_0x0043;
    L_0x003f:
        r4 = r9.mInitialAspectRatio;
        r11 = r10 / r4;
    L_0x0043:
        r4 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x006e;
    L_0x0047:
        r4 = r2.height();
        r5 = r7 * r11;
        r4 = r4 + r5;
        r5 = r9.mImageRect;
        r5 = r5.height();
        r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r4 <= 0) goto L_0x006e;
    L_0x0058:
        r4 = r9.mImageRect;
        r4 = r4.height();
        r5 = r2.height();
        r4 = r4 - r5;
        r0 = r4 / r7;
        r11 = r0;
        r4 = r9.mMaintainAspectRatio;
        if (r4 == 0) goto L_0x006e;
    L_0x006a:
        r4 = r9.mInitialAspectRatio;
        r10 = r11 * r4;
    L_0x006e:
        r4 = -r10;
        r5 = -r11;
        r2.inset(r4, r5);
        r3 = 1103626240; // 0x41c80000 float:25.0 double:5.45263811E-315;
        r4 = r2.width();
        r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r4 >= 0) goto L_0x0088;
    L_0x007d:
        r4 = r2.width();
        r4 = r8 - r4;
        r4 = -r4;
        r4 = r4 / r7;
        r2.inset(r4, r6);
    L_0x0088:
        r4 = r9.mMaintainAspectRatio;
        if (r4 == 0) goto L_0x00e7;
    L_0x008c:
        r4 = r9.mInitialAspectRatio;
        r4 = r8 / r4;
        r1 = r4;
    L_0x0091:
        r4 = r2.height();
        r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1));
        if (r4 >= 0) goto L_0x00a4;
    L_0x0099:
        r4 = r2.height();
        r4 = r1 - r4;
        r4 = -r4;
        r4 = r4 / r7;
        r2.inset(r6, r4);
    L_0x00a4:
        r4 = r2.left;
        r5 = r9.mImageRect;
        r5 = r5.left;
        r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r4 >= 0) goto L_0x00e9;
    L_0x00ae:
        r4 = r9.mImageRect;
        r4 = r4.left;
        r5 = r2.left;
        r4 = r4 - r5;
        r2.offset(r4, r6);
    L_0x00b8:
        r4 = r2.top;
        r5 = r9.mImageRect;
        r5 = r5.top;
        r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r4 >= 0) goto L_0x00ff;
    L_0x00c2:
        r4 = r9.mImageRect;
        r4 = r4.top;
        r5 = r2.top;
        r4 = r4 - r5;
        r2.offset(r6, r4);
    L_0x00cc:
        r4 = r9.mCropRect;
        r4.set(r2);
        r4 = r9.computeLayout();
        r9.mDrawRect = r4;
        r4 = r9.mContext;
        r4.invalidate();
        return;
    L_0x00dd:
        r4 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x0011;
    L_0x00e1:
        r4 = r9.mInitialAspectRatio;
        r10 = r11 * r4;
        goto L_0x0011;
    L_0x00e7:
        r1 = r8;
        goto L_0x0091;
    L_0x00e9:
        r4 = r2.right;
        r5 = r9.mImageRect;
        r5 = r5.right;
        r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r4 <= 0) goto L_0x00b8;
    L_0x00f3:
        r4 = r2.right;
        r5 = r9.mImageRect;
        r5 = r5.right;
        r4 = r4 - r5;
        r4 = -r4;
        r2.offset(r4, r6);
        goto L_0x00b8;
    L_0x00ff:
        r4 = r2.bottom;
        r5 = r9.mImageRect;
        r5 = r5.bottom;
        r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r4 <= 0) goto L_0x00cc;
    L_0x0109:
        r4 = r2.bottom;
        r5 = r9.mImageRect;
        r5 = r5.bottom;
        r4 = r4 - r5;
        r4 = -r4;
        r2.offset(r6, r4);
        goto L_0x00cc;
    }

    void handleMotion(int r8, float r9, float r10) {
        r7 = this;
        r6 = -1;
        r5 = 1;
        r0 = r7.computeLayout();
        if (r8 != r5) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r3 = 32;
        if (r8 != r3) goto L_0x002b;
    L_0x000d:
        r3 = r7.mCropRect;
        r3 = r3.width();
        r4 = r0.width();
        r4 = (float) r4;
        r3 = r3 / r4;
        r3 = r3 * r9;
        r4 = r7.mCropRect;
        r4 = r4.height();
        r5 = r0.height();
        r5 = (float) r5;
        r4 = r4 / r5;
        r4 = r4 * r10;
        r7.moveBy(r3, r4);
        goto L_0x0008;
    L_0x002b:
        r3 = r8 & 6;
        if (r3 != 0) goto L_0x0030;
    L_0x002f:
        r9 = 0;
    L_0x0030:
        r3 = r8 & 24;
        if (r3 != 0) goto L_0x0035;
    L_0x0034:
        r10 = 0;
    L_0x0035:
        r3 = r7.mCropRect;
        r3 = r3.width();
        r4 = r0.width();
        r4 = (float) r4;
        r3 = r3 / r4;
        r1 = r9 * r3;
        r3 = r7.mCropRect;
        r3 = r3.height();
        r4 = r0.height();
        r4 = (float) r4;
        r3 = r3 / r4;
        r2 = r10 * r3;
        r3 = r8 & 2;
        if (r3 == 0) goto L_0x0063;
    L_0x0055:
        r3 = r6;
    L_0x0056:
        r3 = (float) r3;
        r3 = r3 * r1;
        r4 = r8 & 8;
        if (r4 == 0) goto L_0x0065;
    L_0x005c:
        r4 = r6;
    L_0x005d:
        r4 = (float) r4;
        r4 = r4 * r2;
        r7.growBy(r3, r4);
        goto L_0x0008;
    L_0x0063:
        r3 = r5;
        goto L_0x0056;
    L_0x0065:
        r4 = r5;
        goto L_0x005d;
    }

    public boolean hasFocus() {
        r1 = this;
        r0 = r1.mIsFocused;
        return r0;
    }

    public void invalidate() {
        r1 = this;
        r0 = r1.computeLayout();
        r1.mDrawRect = r0;
        return;
    }

    void moveBy(float r8, float r9) {
        r7 = this;
        r6 = -10;
        r5 = 0;
        r0 = new android.graphics.Rect;
        r1 = r7.mDrawRect;
        r0.<init>(r1);
        r1 = r7.mCropRect;
        r1.offset(r8, r9);
        r1 = r7.mCropRect;
        r2 = r7.mImageRect;
        r2 = r2.left;
        r3 = r7.mCropRect;
        r3 = r3.left;
        r2 = r2 - r3;
        r2 = java.lang.Math.max(r5, r2);
        r3 = r7.mImageRect;
        r3 = r3.top;
        r4 = r7.mCropRect;
        r4 = r4.top;
        r3 = r3 - r4;
        r3 = java.lang.Math.max(r5, r3);
        r1.offset(r2, r3);
        r1 = r7.mCropRect;
        r2 = r7.mImageRect;
        r2 = r2.right;
        r3 = r7.mCropRect;
        r3 = r3.right;
        r2 = r2 - r3;
        r2 = java.lang.Math.min(r5, r2);
        r3 = r7.mImageRect;
        r3 = r3.bottom;
        r4 = r7.mCropRect;
        r4 = r4.bottom;
        r3 = r3 - r4;
        r3 = java.lang.Math.min(r5, r3);
        r1.offset(r2, r3);
        r1 = r7.computeLayout();
        r7.mDrawRect = r1;
        r1 = r7.mDrawRect;
        r0.union(r1);
        r0.inset(r6, r6);
        r1 = r7.mContext;
        r1.invalidate(r0);
        return;
    }

    public void setFocus(boolean r1) {
        r0 = this;
        r0.mIsFocused = r1;
        return;
    }

    public void setHidden(boolean r1) {
        r0 = this;
        r0.mHidden = r1;
        return;
    }

    public void setMode(com.techno.gallery.HighlightView.ModifyMode r2) {
        r1 = this;
        r0 = r1.mMode;
        if (r2 == r0) goto L_0x000b;
    L_0x0004:
        r1.mMode = r2;
        r0 = r1.mContext;
        r0.invalidate();
    L_0x000b:
        return;
    }

    public void setup(android.graphics.Matrix r5, android.graphics.Rect r6, android.graphics.RectF r7, boolean r8, boolean r9) {
        r4 = this;
        r3 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        r2 = 50;
        if (r8 == 0) goto L_0x0007;
    L_0x0006:
        r9 = 1;
    L_0x0007:
        r0 = new android.graphics.Matrix;
        r0.<init>(r5);
        r4.mMatrix = r0;
        r4.mCropRect = r7;
        r0 = new android.graphics.RectF;
        r0.<init>(r6);
        r4.mImageRect = r0;
        r4.mMaintainAspectRatio = r9;
        r4.mCircle = r8;
        r0 = r4.mCropRect;
        r0 = r0.width();
        r1 = r4.mCropRect;
        r1 = r1.height();
        r0 = r0 / r1;
        r4.mInitialAspectRatio = r0;
        r0 = r4.computeLayout();
        r4.mDrawRect = r0;
        r0 = r4.mFocusPaint;
        r0.setARGB(r3, r2, r2, r2);
        r0 = r4.mNoFocusPaint;
        r0.setARGB(r3, r2, r2, r2);
        r0 = r4.mOutlinePaint;
        r1 = 1077936128; // 0x40400000 float:3.0 double:5.325712093E-315;
        r0.setStrokeWidth(r1);
        r0 = r4.mOutlinePaint;
        r1 = android.graphics.Paint.Style.STROKE;
        r0.setStyle(r1);
        r0 = r4.mOutlinePaint;
        r1 = 1;
        r0.setAntiAlias(r1);
        r0 = com.techno.gallery.HighlightView.ModifyMode.None;
        r4.mMode = r0;
        r4.init();
        return;
    }
}