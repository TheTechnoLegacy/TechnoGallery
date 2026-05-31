package com.techno.gallery;

class MenuHelper$8 implements com.techno.gallery.MenuHelper.MenuCallback {
    final /* synthetic */ android.app.Activity val$activity;
    final /* synthetic */ java.lang.Runnable val$onDelete;

    MenuHelper$8(android.app.Activity r1, java.lang.Runnable r2) {
        r0 = this;
        r0.val$activity = r1;
        r0.val$onDelete = r2;
        r0.<init>();
        return;
    }

    public void run(android.net.Uri r3, com.techno.gallery.gallery.IImage r4) {
        r2 = this;
        if (r4 == 0) goto L_0x0009;
    L_0x0002:
        r0 = r2.val$activity;
        r1 = r2.val$onDelete;
        com.techno.gallery.MenuHelper.deleteImage(r0, r1, r4);
    L_0x0009:
        return;
    }
}