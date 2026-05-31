package com.techno.gallery;

class MovieView$1 extends com.techno.gallery.MovieViewControl {
    final /* synthetic */ com.techno.gallery.MovieView this$0;

    MovieView$1(com.techno.gallery.MovieView r1, android.view.View r2, android.content.Context r3, android.net.Uri r4) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>(r2, r3, r4);
        return;
    }

    public void onCompletion() {
        r1 = this;
        r0 = r1.this$0;
        r0 = com.techno.gallery.MovieView.access$000(r0);
        if (r0 == 0) goto L_0x000d;
    L_0x0008:
        r0 = r1.this$0;
        r0.finish();
    L_0x000d:
        return;
    }
}