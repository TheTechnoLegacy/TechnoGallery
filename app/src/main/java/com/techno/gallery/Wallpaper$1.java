package com.techno.gallery;

class Wallpaper$1 extends android.os.Handler {
    final /* synthetic */ com.techno.gallery.Wallpaper this$0;

    Wallpaper$1(com.techno.gallery.Wallpaper r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    public void handleMessage(android.os.Message r7) {
        r6 = this;
        r1 = r7.what;
        switch(r1) {
            case 0: goto L_0x0006;
            case 1: goto L_0x001f;
            default: goto L_0x0005;
        };
    L_0x0005:
        return;
    L_0x0006:
        r1 = r6.this$0;
        r2 = 2131296274; // 0x7f090012 float:1.821046E38 double:1.05300027E-314;
        r0 = r1.getText(r2);
        r1 = r6.this$0;
        r2 = r6.this$0;
        r3 = "";
        r4 = 1;
        r5 = 0;
        r2 = android.app.ProgressDialog.show(r2, r3, r0, r4, r5);
        com.techno.gallery.Wallpaper.access$002(r1, r2);
        goto L_0x0005;
    L_0x001f:
        r1 = r6.this$0;
        com.techno.gallery.Wallpaper.access$100(r1);
        r1 = r6.this$0;
        r2 = -1;
        r1.setResult(r2);
        r1 = r6.this$0;
        r1.finish();
        goto L_0x0005;
    }
}