package com.techno.gallery;

class MenuHelper$5 implements com.techno.gallery.MenuHelper.MenuCallback {
    final /* synthetic */ android.app.Activity val$activity;

    MenuHelper$5(android.app.Activity r1) {
        r0 = this;
        r0.val$activity = r1;
        r0.<init>();
        return;
    }

    public void run(android.net.Uri r5, com.techno.gallery.gallery.IImage r6) {
        r4 = this;
        if (r5 == 0) goto L_0x0004;
    L_0x0002:
        if (r6 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = com.techno.gallery.Util.createSetAsIntent(r6);
        r1 = r4.val$activity;
        r2 = r4.val$activity;
        r3 = 2131296420; // 0x7f0900a4 float:1.8210756E38 double:1.053000342E-314;
        r2 = r2.getText(r3);
        r2 = android.content.Intent.createChooser(r0, r2);
        r1.startActivity(r2);
        goto L_0x0004;
    }
}