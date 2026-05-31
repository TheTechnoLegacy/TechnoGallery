package com.techno.gallery;

class MenuHelper$7 implements com.techno.gallery.MenuHelper.MenuCallback {
    final /* synthetic */ android.app.Activity val$activity;

    MenuHelper$7(android.app.Activity r1) {
        r0 = this;
        r0.val$activity = r1;
        r0.<init>();
        return;
    }

    public void run(android.net.Uri r4, com.techno.gallery.gallery.IImage r5) {
        r3 = this;
        if (r5 == 0) goto L_0x0012;
    L_0x0002:
        r0 = new android.content.Intent;
        r1 = "android.intent.action.VIEW";
        r2 = r5.fullSizeImageUri();
        r0.<init>(r1, r2);
        r1 = r3.val$activity;
        r1.startActivity(r0);
    L_0x0012:
        return;
    }
}