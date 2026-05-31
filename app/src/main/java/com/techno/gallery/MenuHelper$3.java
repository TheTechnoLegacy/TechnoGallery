package com.techno.gallery;

class MenuHelper$3 implements com.techno.gallery.MenuHelper.MenuCallback {
    final /* synthetic */ int val$degree;

    MenuHelper$3(int r1) {
        r0 = this;
        r0.val$degree = r1;
        r0.<init>();
        return;
    }

    public void run(android.net.Uri r2, com.techno.gallery.gallery.IImage r3) {
        r1 = this;
        if (r3 == 0) goto L_0x0008;
    L_0x0002:
        r0 = r3.isReadonly();
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = r1.val$degree;
        r3.rotateImageBy(r0);
        goto L_0x0008;
    }
}