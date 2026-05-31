package com.techno.gallery;

final class ImageGallery$MyThumbCheckCallback implements com.techno.gallery.ImageLoader.ThumbCheckCallback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    boolean mDidSetProgress;
    private long mLastUpdateTime;
    private final java.lang.String mProgressTextFormatString;
    private final android.widget.TextView mProgressTextView;
    private final android.os.PowerManager.WakeLock mWakeLock;
    final /* synthetic */ com.techno.gallery.ImageGallery this$0;

    static {
        r0 = com.techno.gallery.ImageGallery.class;
        r0 = r0.desiredAssertionStatus();
        if (r0 != 0) goto L_0x000c;
    L_0x0008:
        r0 = 1;
    L_0x0009:
        $assertionsDisabled = r0;
        return;
    L_0x000c:
        r0 = 0;
        goto L_0x0009;
    }

    private ImageGallery$MyThumbCheckCallback(com.techno.gallery.ImageGallery r5) {
        r4 = this;
        r4.this$0 = r5;
        r4.<init>();
        r2 = 0;
        r4.mDidSetProgress = r2;
        r1 = r5.getResources();
        r2 = 2131427346; // 0x7f0b0012 float:1.8476306E38 double:1.0530650283E-314;
        r2 = r5.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r4.mProgressTextView = r2;
        r2 = 2131296418; // 0x7f0900a2 float:1.8210752E38 double:1.053000341E-314;
        r2 = r1.getString(r2);
        r4.mProgressTextFormatString = r2;
        r2 = "power";
        r0 = r5.getSystemService(r2);
        r0 = (android.os.PowerManager) r0;
        r2 = 10;
        r3 = "ImageGallery.checkThumbnails";
        r2 = r0.newWakeLock(r2, r3);
        r4.mWakeLock = r2;
        r2 = r4.mWakeLock;
        r2.acquire();
        return;
    }

    /* synthetic */ ImageGallery$MyThumbCheckCallback(com.techno.gallery.ImageGallery r1, com.techno.gallery.ImageGallery.1 r2) {
        r0 = this;
        r0.<init>(r1);
        return;
    }

    static /* synthetic */ java.lang.String access$1500(com.techno.gallery.ImageGallery$MyThumbCheckCallback r1) {
        r0 = r1.mProgressTextFormatString;
        return r0;
    }

    static /* synthetic */ android.widget.TextView access$1600(com.techno.gallery.ImageGallery$MyThumbCheckCallback r1) {
        r0 = r1.mProgressTextView;
        return r0;
    }

    public boolean checking(int r8, int r9) {
        r7 = this;
        r6 = 1;
        r2 = r7.this$0;
        r2 = com.techno.gallery.ImageGallery.access$1300(r2);
        if (r2 != 0) goto L_0x000b;
    L_0x0009:
        r2 = r6;
    L_0x000a:
        return r2;
    L_0x000b:
        r2 = r7.mDidSetProgress;
        if (r2 != 0) goto L_0x001f;
    L_0x000f:
        r2 = r7.this$0;
        r2 = com.techno.gallery.ImageGallery.access$1400(r2);
        r3 = new com.techno.gallery.ImageGallery$MyThumbCheckCallback$1;
        r3.<init>(r7);
        r2.post(r3);
        r7.mDidSetProgress = r6;
    L_0x001f:
        r2 = r7.this$0;
        r2 = com.techno.gallery.ImageGallery.access$500(r2);
        r2.postInvalidate();
        r0 = java.lang.System.currentTimeMillis();
        r2 = r7.mLastUpdateTime;
        r2 = r0 - r2;
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x0046;
    L_0x0036:
        r2 = r7.this$0;
        r2 = com.techno.gallery.ImageGallery.access$1400(r2);
        r3 = new com.techno.gallery.ImageGallery$MyThumbCheckCallback$2;
        r3.<init>(r7, r9, r8);
        r2.post(r3);
        r7.mLastUpdateTime = r0;
    L_0x0046:
        r2 = r7.this$0;
        r2 = com.techno.gallery.ImageGallery.access$1700(r2);
        if (r2 != 0) goto L_0x0050;
    L_0x004e:
        r2 = r6;
        goto L_0x000a;
    L_0x0050:
        r2 = 0;
        goto L_0x000a;
    }

    public void done() {
        r2 = this;
        r0 = $assertionsDisabled;
        if (r0 != 0) goto L_0x0012;
    L_0x0004:
        r0 = r2.mWakeLock;
        r0 = r0.isHeld();
        if (r0 != 0) goto L_0x0012;
    L_0x000c:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0012:
        r0 = r2.mWakeLock;
        r0.release();
        r0 = r2.this$0;
        r0 = com.techno.gallery.ImageGallery.access$1400(r0);
        r1 = new com.techno.gallery.ImageGallery$MyThumbCheckCallback$3;
        r1.<init>(r2);
        r0.post(r1);
        return;
    }
}