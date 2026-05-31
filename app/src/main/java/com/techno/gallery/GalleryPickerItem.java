package com.techno.gallery;

class GalleryPickerItem extends android.widget.ImageView {
    private android.graphics.drawable.Drawable mFrame;
    private android.graphics.Rect mFrameBounds;
    private android.graphics.drawable.Drawable mOverlay;

    public GalleryPickerItem(android.content.Context r2) {
        r1 = this;
        r0 = 0;
        r1.<init>(r2, r0);
        return;
    }

    public GalleryPickerItem(android.content.Context r2, android.util.AttributeSet r3) {
        r1 = this;
        r0 = 0;
        r1.<init>(r2, r3, r0);
        return;
    }

    public GalleryPickerItem(android.content.Context r3, android.util.AttributeSet r4, int r5) {
        r2 = this;
        r2.<init>(r3, r4, r5);
        r0 = new android.graphics.Rect;
        r0.<init>();
        r2.mFrameBounds = r0;
        r0 = r2.getResources();
        r1 = 2130837554; // 0x7f020032 float:1.7280065E38 double:1.0527736323E-314;
        r0 = r0.getDrawable(r1);
        r2.mFrame = r0;
        r0 = r2.mFrame;
        r0.setCallback(r2);
        return;
    }

    protected void drawableStateChanged() {
        r2 = this;
        super.drawableStateChanged();
        r1 = r2.mFrame;
        if (r1 == 0) goto L_0x0010;
    L_0x0007:
        r0 = r2.getDrawableState();
        r1 = r2.mFrame;
        r1.setState(r0);
    L_0x0010:
        return;
    }

    protected void onDraw(android.graphics.Canvas r7) {
        r6 = this;
        r4 = 0;
        super.onDraw(r7);
        r0 = r6.mFrameBounds;
        r3 = r0.isEmpty();
        if (r3 == 0) goto L_0x0035;
    L_0x000c:
        r2 = r6.getWidth();
        r1 = r6.getHeight();
        r0.set(r4, r4, r2, r1);
        r3 = r6.mFrame;
        r3.setBounds(r0);
        r3 = r6.mOverlay;
        if (r3 == 0) goto L_0x0035;
    L_0x0020:
        r3 = r6.mOverlay;
        r4 = r6.mOverlay;
        r4 = r4.getIntrinsicWidth();
        r4 = r2 - r4;
        r5 = r6.mOverlay;
        r5 = r5.getIntrinsicHeight();
        r5 = r1 - r5;
        r3.setBounds(r4, r5, r2, r1);
    L_0x0035:
        r3 = r6.mFrame;
        r3.draw(r7);
        r3 = r6.mOverlay;
        if (r3 == 0) goto L_0x0043;
    L_0x003e:
        r3 = r6.mOverlay;
        r3.draw(r7);
    L_0x0043:
        return;
    }

    protected void onSizeChanged(int r2, int r3, int r4, int r5) {
        r1 = this;
        super.onSizeChanged(r2, r3, r4, r5);
        r0 = r1.mFrameBounds;
        r0.setEmpty();
        return;
    }

    public void setOverlay(int r2) {
        r1 = this;
        if (r2 < 0) goto L_0x0012;
    L_0x0002:
        r0 = r1.getResources();
        r0 = r0.getDrawable(r2);
        r1.mOverlay = r0;
        r0 = r1.mFrameBounds;
        r0.setEmpty();
    L_0x0011:
        return;
    L_0x0012:
        r0 = 0;
        r1.mOverlay = r0;
        goto L_0x0011;
    }

    protected boolean verifyDrawable(android.graphics.drawable.Drawable r2) {
        r1 = this;
        r0 = super.verifyDrawable(r2);
        if (r0 != 0) goto L_0x000e;
    L_0x0006:
        r0 = r1.mFrame;
        if (r2 == r0) goto L_0x000e;
    L_0x000a:
        r0 = r1.mOverlay;
        if (r2 != r0) goto L_0x0010;
    L_0x000e:
        r0 = 1;
    L_0x000f:
        return r0;
    L_0x0010:
        r0 = 0;
        goto L_0x000f;
    }
}