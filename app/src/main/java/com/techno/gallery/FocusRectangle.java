package com.techno.gallery;

/* compiled from: Camera */
class FocusRectangle extends android.view.View {
    private static final java.lang.String TAG = "FocusRectangle";

    public FocusRectangle(android.content.Context r1, android.util.AttributeSet r2) {
        r0 = this;
        r0.<init>(r1, r2);
        return;
    }

    private void setDrawable(int r2) {
        r1 = this;
        r0 = r1.getResources();
        r0 = r0.getDrawable(r2);
        r1.setBackgroundDrawable(r0);
        return;
    }

    public void clear() {
        r1 = this;
        r0 = 0;
        r1.setBackgroundDrawable(r0);
        return;
    }

    public void showFail() {
        r1 = this;
        r0 = 2130837551; // 0x7f02002f float:1.728006E38 double:1.052773631E-314;
        r1.setDrawable(r0);
        return;
    }

    public void showStart() {
        r1 = this;
        r0 = 2130837553; // 0x7f020031 float:1.7280063E38 double:1.052773632E-314;
        r1.setDrawable(r0);
        return;
    }

    public void showSuccess() {
        r1 = this;
        r0 = 2130837552; // 0x7f020030 float:1.7280061E38 double:1.0527736313E-314;
        r1.setDrawable(r0);
        return;
    }
}