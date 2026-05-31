package com.techno.gallery;

class MenuHelper$19 implements android.content.DialogInterface.OnClickListener {
    final /* synthetic */ java.lang.Runnable val$action;

    MenuHelper$19(java.lang.Runnable r1) {
        r0 = this;
        r0.val$action = r1;
        r0.<init>();
        return;
    }

    public void onClick(android.content.DialogInterface r2, int r3) {
        r1 = this;
        switch(r3) {
            case -1: goto L_0x0004;
            default: goto L_0x0003;
        };
    L_0x0003:
        return;
    L_0x0004:
        r0 = r1.val$action;
        if (r0 == 0) goto L_0x0003;
    L_0x0008:
        r0 = r1.val$action;
        r0.run();
        goto L_0x0003;
    }
}