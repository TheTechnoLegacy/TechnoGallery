package com.techno.gallery;

class MovieViewControl$2 implements android.content.DialogInterface.OnCancelListener {
    final /* synthetic */ com.techno.gallery.MovieViewControl this$0;

    MovieViewControl$2(com.techno.gallery.MovieViewControl r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    public void onCancel(android.content.DialogInterface r2) {
        r1 = this;
        r0 = r1.this$0;
        r0.onCompletion();
        return;
    }
}