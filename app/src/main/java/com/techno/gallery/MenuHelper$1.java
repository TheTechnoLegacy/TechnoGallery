package com.techno.gallery;

class MenuHelper$1 implements com.techno.gallery.MenuHelper.MenuCallback {
    final /* synthetic */ android.app.Activity val$activity;
    final /* synthetic */ android.os.Handler val$handler;

    MenuHelper$1(android.os.Handler r1, android.app.Activity r2) {
        r0 = this;
        r0.val$handler = r1;
        r0.val$activity = r2;
        r0.<init>();
        return;
    }

    public void run(android.net.Uri r5, com.techno.gallery.gallery.IImage r6) {
        r4 = this;
        if (r6 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r1 = com.techno.gallery.MenuHelper.access$200(r6);
        r0 = android.media.ExifInterface.getLatLng(r1);
        if (r0 != 0) goto L_0x0018;
    L_0x000d:
        r1 = r4.val$handler;
        r2 = new com.techno.gallery.MenuHelper$1$1;
        r2.<init>(r4);
        r1.post(r2);
        goto L_0x0002;
    L_0x0018:
        r1 = r4.val$activity;
        r2 = 0;
        r2 = r0[r2];
        r3 = 1;
        r3 = r0[r3];
        com.techno.gallery.Util.openMaps(r1, r2, r3);
        goto L_0x0002;
    }
}