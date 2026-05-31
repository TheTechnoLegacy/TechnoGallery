package com.techno.gallery;

class MovieViewControl$3 implements android.content.DialogInterface.OnClickListener {
    final /* synthetic */ com.techno.gallery.MovieViewControl this$0;
    final /* synthetic */ java.lang.Integer val$bookmark;

    MovieViewControl$3(com.techno.gallery.MovieViewControl r1, java.lang.Integer r2) {
        r0 = this;
        r0.this$0 = r1;
        r0.val$bookmark = r2;
        r0.<init>();
        return;
    }

    public void onClick(android.content.DialogInterface r3, int r4) {
        r2 = this;
        r0 = r2.this$0;
        r0 = com.techno.gallery.MovieViewControl.access$000(r0);
        r1 = r2.val$bookmark;
        r1 = r1.intValue();
        r0.seekTo(r1);
        r0 = r2.this$0;
        r0 = com.techno.gallery.MovieViewControl.access$000(r0);
        r0.start();
        return;
    }
}