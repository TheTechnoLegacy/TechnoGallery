package com.techno.gallery;

class ImageGallery$9 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.ImageGallery this$0;

    ImageGallery$9(com.techno.gallery.ImageGallery r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    public void run() {
        r7 = this;
        r4 = new java.util.ArrayList;
        r4.<init>();
        r5 = r7.this$0;
        r5 = com.techno.gallery.ImageGallery.access$2200(r5);
        r1 = r5.iterator();
    L_0x000f:
        r5 = r1.hasNext();
        if (r5 == 0) goto L_0x0023;
    L_0x0015:
        r2 = r1.next();
        r2 = (com.techno.gallery.gallery.IImage) r2;
        r5 = r2.fullSizeImageUri();
        r4.add(r5);
        goto L_0x000f;
    L_0x0023:
        r5 = r7.this$0;
        com.techno.gallery.ImageGallery.access$200(r5);
        r3 = new android.content.Intent;
        r5 = r7.this$0;
        r6 = com.techno.gallery.DeleteImage.class;
        r3.<init>(r5, r6);
        r5 = "delete-uris";
        r3.putExtra(r5, r4);
        r5 = r7.this$0;	 Catch:{ ActivityNotFoundException -> 0x003c }
        r5.startActivity(r3);	 Catch:{ ActivityNotFoundException -> 0x003c }
    L_0x003b:
        return;
    L_0x003c:
        r5 = move-exception;
        r0 = r5;
        r5 = "ImageGallery";
        r6 = "Delete images fail";
        android.util.Log.e(r5, r6, r0);
        goto L_0x003b;
    }
}