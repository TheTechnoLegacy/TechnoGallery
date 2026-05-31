package com.techno.gallery;

class ImageGallery$MyThumbCheckCallback$2 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.ImageGallery.MyThumbCheckCallback this$1;
    final /* synthetic */ int val$count;
    final /* synthetic */ int val$maxCount;

    ImageGallery$MyThumbCheckCallback$2(com.techno.gallery.ImageGallery.MyThumbCheckCallback r1, int r2, int r3) {
        r0 = this;
        r0.this$1 = r1;
        r0.val$maxCount = r2;
        r0.val$count = r3;
        r0.<init>();
        return;
    }

    public void run() {
        r6 = this;
        r1 = r6.this$1;
        r1 = com.techno.gallery.ImageGallery.MyThumbCheckCallback.access$1500(r1);
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r6.val$maxCount;
        r5 = r6.val$count;
        r4 = r4 - r5;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0 = java.lang.String.format(r1, r2);
        r1 = r6.this$1;
        r1 = com.techno.gallery.ImageGallery.MyThumbCheckCallback.access$1600(r1);
        r1.setText(r0);
        return;
    }
}