package com.techno.gallery;

class Util$BackgroundJob$1 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.Util.BackgroundJob this$0;

    Util$BackgroundJob$1(com.techno.gallery.Util.BackgroundJob r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    public void run() {
        r2 = this;
        r0 = r2.this$0;
        r0 = com.techno.gallery.Util.BackgroundJob.access$000(r0);
        r1 = r2.this$0;
        r0.removeLifeCycleListener(r1);
        r0 = r2.this$0;
        r0 = com.techno.gallery.Util.BackgroundJob.access$100(r0);
        r0 = r0.getWindow();
        if (r0 == 0) goto L_0x0020;
    L_0x0017:
        r0 = r2.this$0;
        r0 = com.techno.gallery.Util.BackgroundJob.access$100(r0);
        r0.dismiss();
    L_0x0020:
        return;
    }
}