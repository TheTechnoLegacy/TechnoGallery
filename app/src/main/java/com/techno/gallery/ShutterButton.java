package com.techno.gallery;

public class ShutterButton extends android.widget.ImageView {
    private com.techno.gallery.ShutterButton.OnShutterButtonListener mListener;
    private boolean mOldPressed;

    public ShutterButton(android.content.Context r1) {
        r0 = this;
        r0.<init>(r1);
        return;
    }

    public ShutterButton(android.content.Context r1, android.util.AttributeSet r2) {
        r0 = this;
        r0.<init>(r1, r2);
        return;
    }

    public ShutterButton(android.content.Context r1, android.util.AttributeSet r2, int r3) {
        r0 = this;
        r0.<init>(r1, r2, r3);
        return;
    }

    static /* synthetic */ void access$000(com.techno.gallery.ShutterButton r0, boolean r1) {
        r0.callShutterButtonFocus(r1);
        return;
    }

    private void callShutterButtonFocus(boolean r2) {
        r1 = this;
        r0 = r1.mListener;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r1.mListener;
        r0.onShutterButtonFocus(r1, r2);
    L_0x0009:
        return;
    }

    protected void drawableStateChanged() {
        r2 = this;
        super.drawableStateChanged();
        r0 = r2.isPressed();
        r1 = r2.mOldPressed;
        if (r0 == r1) goto L_0x0017;
    L_0x000b:
        if (r0 != 0) goto L_0x0018;
    L_0x000d:
        r1 = new com.techno.gallery.ShutterButton$1;
        r1.<init>(r2, r0);
        r2.post(r1);
    L_0x0015:
        r2.mOldPressed = r0;
    L_0x0017:
        return;
    L_0x0018:
        r2.callShutterButtonFocus(r0);
        goto L_0x0015;
    }

    public boolean performClick() {
        r2 = this;
        r0 = super.performClick();
        r1 = r2.mListener;
        if (r1 == 0) goto L_0x000d;
    L_0x0008:
        r1 = r2.mListener;
        r1.onShutterButtonClick(r2);
    L_0x000d:
        return r0;
    }

    public void setOnShutterButtonListener(com.techno.gallery.ShutterButton.OnShutterButtonListener r1) {
        r0 = this;
        r0.mListener = r1;
        return;
    }
}