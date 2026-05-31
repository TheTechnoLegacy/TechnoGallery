package com.techno.gallery;

class ReviewImage$4 implements android.widget.ZoomButtonsController.OnZoomListener {
    final /* synthetic */ com.techno.gallery.ReviewImage this$0;
    final /* synthetic */ android.view.View.OnTouchListener val$otListener;
    final /* synthetic */ android.view.View val$rootView;

    ReviewImage$4(com.techno.gallery.ReviewImage r1, android.view.View r2, android.view.View.OnTouchListener r3) {
        r0 = this;
        r0.this$0 = r1;
        r0.val$rootView = r2;
        r0.val$otListener = r3;
        r0.<init>();
        return;
    }

    public void onVisibilityChanged(boolean r3) {
        r2 = this;
        if (r3 == 0) goto L_0x0008;
    L_0x0002:
        r0 = r2.this$0;
        com.techno.gallery.ReviewImage.access$400(r0);
    L_0x0007:
        return;
    L_0x0008:
        r0 = r2.val$rootView;
        r1 = r2.val$otListener;
        r0.setOnTouchListener(r1);
        goto L_0x0007;
    }

    public void onZoom(boolean r3) {
        r2 = this;
        if (r3 == 0) goto L_0x001b;
    L_0x0002:
        r0 = r2.this$0;
        r0 = com.techno.gallery.ReviewImage.access$500(r0);
        r0.zoomIn();
    L_0x000b:
        r0 = r2.this$0;
        r0 = com.techno.gallery.ReviewImage.access$600(r0);
        r1 = 1;
        r0.setVisible(r1);
        r0 = r2.this$0;
        com.techno.gallery.ReviewImage.access$400(r0);
        return;
    L_0x001b:
        r0 = r2.this$0;
        r0 = com.techno.gallery.ReviewImage.access$500(r0);
        r0.zoomOut();
        goto L_0x000b;
    }
}