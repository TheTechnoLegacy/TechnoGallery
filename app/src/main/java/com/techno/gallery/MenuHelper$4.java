package com.techno.gallery;

class MenuHelper$4 implements com.techno.gallery.MenuHelper.MenuCallback {
    final /* synthetic */ android.app.Activity val$activity;

    MenuHelper$4(android.app.Activity r1) {
        r0 = this;
        r0.val$activity = r1;
        r0.<init>();
        return;
    }

    public void run(android.net.Uri r4, com.techno.gallery.gallery.IImage r5) {
        r3 = this;
        if (r4 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = r3.val$activity;
        r2 = com.techno.gallery.CropImage.class;
        r0.setClass(r1, r2);
        r0.setData(r4);
        r1 = r3.val$activity;
        r2 = 490; // 0x1ea float:6.87E-43 double:2.42E-321;
        r1.startActivityForResult(r0, r2);
        goto L_0x0002;
    }
}