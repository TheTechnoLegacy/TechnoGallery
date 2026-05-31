package com.techno.gallery;

public class ActionMenuButton extends android.widget.TextView {
    private static final int CORNER_RADIUS = 8;
    private static final int PADDING_H = 5;
    private static final int PADDING_V = 1;
    private android.graphics.Paint mPaint;
    private final android.graphics.RectF mRect;

    public ActionMenuButton(android.content.Context r2) {
        r1 = this;
        r1.<init>(r2);
        r0 = new android.graphics.RectF;
        r0.<init>();
        r1.mRect = r0;
        r1.init();
        return;
    }

    public ActionMenuButton(android.content.Context r2, android.util.AttributeSet r3) {
        r1 = this;
        r1.<init>(r2, r3);
        r0 = new android.graphics.RectF;
        r0.<init>();
        r1.mRect = r0;
        r1.init();
        return;
    }

    public ActionMenuButton(android.content.Context r2, android.util.AttributeSet r3, int r4) {
        r1 = this;
        r1.<init>(r2, r3, r4);
        r0 = new android.graphics.RectF;
        r0.<init>();
        r1.mRect = r0;
        r1.init();
        return;
    }

    private void init() {
        r3 = this;
        r2 = 5;
        r1 = 1;
        r3.setFocusable(r1);
        r0 = 0;
        r3.setPadding(r2, r0, r2, r1);
        r0 = new android.graphics.Paint;
        r0.<init>(r1);
        r3.mPaint = r0;
        r0 = r3.mPaint;
        r1 = r3.getContext();
        r1 = r1.getResources();
        r2 = 2131165184; // 0x7f070000 float:1.7944578E38 double:1.052935503E-314;
        r1 = r1.getColor(r2);
        r0.setColor(r1);
        return;
    }

    public void draw(android.graphics.Canvas r12) {
        r11 = this;
        r10 = 1090519040; // 0x41000000 float:8.0 double:5.38787994E-315;
        r8 = 1084227584; // 0x40a00000 float:5.0 double:5.356796015E-315;
        r9 = 0;
        r0 = r11.getLayout();
        r2 = r11.mRect;
        r1 = r11.getCompoundPaddingLeft();
        r3 = r11.getExtendedPaddingTop();
        r4 = (float) r1;
        r5 = r0.getLineLeft(r9);
        r4 = r4 + r5;
        r4 = r4 - r8;
        r5 = r0.getLineTop(r9);
        r5 = r5 + r3;
        r6 = 1;
        r5 = r5 - r6;
        r5 = (float) r5;
        r6 = (float) r1;
        r7 = r0.getLineRight(r9);
        r6 = r6 + r7;
        r6 = r6 + r8;
        r7 = r11.mScrollX;
        r8 = r11.mRight;
        r7 = r7 + r8;
        r8 = r11.mLeft;
        r7 = r7 - r8;
        r7 = (float) r7;
        r6 = java.lang.Math.min(r6, r7);
        r7 = r0.getLineBottom(r9);
        r7 = r7 + r3;
        r7 = r7 + 1;
        r7 = (float) r7;
        r2.set(r4, r5, r6, r7);
        r4 = r11.mPaint;
        r12.drawRoundRect(r2, r10, r10, r4);
        super.draw(r12);
        return;
    }

    protected void drawableStateChanged() {
        r0 = this;
        r0.invalidate();
        super.drawableStateChanged();
        return;
    }
}