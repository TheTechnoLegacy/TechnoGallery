package com.techno.gallery;

class ShutterButton$1 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.ShutterButton this$0;
    final /* synthetic */ boolean val$pressed;

    ShutterButton$1(com.techno.gallery.ShutterButton r1, boolean r2) {
        r0 = this;
        r0.this$0 = r1;
        r0.val$pressed = r2;
        r0.<init>();
        return;
    }

    public void run() {
        r2 = this;
        r0 = r2.this$0;
        r1 = r2.val$pressed;
        com.techno.gallery.ShutterButton.access$000(r0, r1);
        return;
    }
}