package com.techno.gallery;

class GridViewSpecial$1 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.GridViewSpecial this$0;

    GridViewSpecial$1(com.techno.gallery.GridViewSpecial r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    public void run() {
        r1 = this;
        r0 = r1.this$0;
        r0.invalidate();
        return;
    }
}