package com.techno.gallery;

class MovieViewControl$1 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.MovieViewControl this$0;

    MovieViewControl$1(com.techno.gallery.MovieViewControl r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    public void run() {
        r4 = this;
        r0 = r4.this$0;
        r0 = com.techno.gallery.MovieViewControl.access$000(r0);
        r0 = r0.isPlaying();
        if (r0 == 0) goto L_0x0018;
    L_0x000c:
        r0 = r4.this$0;
        r0 = com.techno.gallery.MovieViewControl.access$100(r0);
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0017:
        return;
    L_0x0018:
        r0 = r4.this$0;
        r0 = r0.mHandler;
        r1 = r4.this$0;
        r1 = r1.mPlayingChecker;
        r2 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r0.postDelayed(r1, r2);
        goto L_0x0017;
    }
}