package com.techno.gallery;

class MenuHelper$1$1 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.MenuHelper.1 this$0;

    MenuHelper$1$1(com.techno.gallery.MenuHelper.1 r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    public void run() {
        r3 = this;
        r0 = r3.this$0;
        r0 = r0.val$activity;
        r1 = 2131296388; // 0x7f090084 float:1.8210691E38 double:1.0530003264E-314;
        r2 = 0;
        r0 = android.widget.Toast.makeText(r0, r1, r2);
        r0.show();
        return;
    }
}