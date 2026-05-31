package com.techno.gallery;

class MenuHelper$2$2 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.MenuHelper.2 this$0;
    final /* synthetic */ android.app.AlertDialog.Builder val$builder;
    final /* synthetic */ android.view.View val$d;

    MenuHelper$2$2(com.techno.gallery.MenuHelper.2 r1, android.app.AlertDialog.Builder r2, android.view.View r3) {
        r0 = this;
        r0.this$0 = r1;
        r0.val$builder = r2;
        r0.val$d = r3;
        r0.<init>();
        return;
    }

    public void run() {
        r2 = this;
        r0 = r2.val$builder;
        r1 = 17301659; // 0x108009b float:2.497969E-38 double:8.5481553E-317;
        r0 = r0.setIcon(r1);
        r1 = 2131296389; // 0x7f090085 float:1.8210693E38 double:1.053000327E-314;
        r0 = r0.setTitle(r1);
        r1 = r2.val$d;
        r0 = r0.setView(r1);
        r0.show();
        return;
    }
}