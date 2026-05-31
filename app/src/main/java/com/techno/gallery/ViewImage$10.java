package com.techno.gallery;

class ViewImage$10 implements com.techno.gallery.ImageGetterCallback {
    final /* synthetic */ com.techno.gallery.ViewImage this$0;

    ViewImage$10(com.techno.gallery.ViewImage r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    public void completed() {
        r0 = this;
        return;
    }

    public int fullImageSizeToUse(int r3, int r4) {
        r2 = this;
        r0 = 2048; // 0x800 float:2.87E-42 double:1.012E-320;
        r1 = 2048; // 0x800 float:2.87E-42 double:1.012E-320;
        return r1;
    }

    public void imageLoaded(int r4, int r5, com.techno.gallery.RotateBitmap r6, boolean r7) {
        r3 = this;
        r0 = r3.this$0;
        r0 = r0.mCurrentPosition;
        if (r4 == r0) goto L_0x000a;
    L_0x0006:
        r6.recycle();
    L_0x0009:
        return;
    L_0x000a:
        if (r7 == 0) goto L_0x001b;
    L_0x000c:
        r0 = r3.this$0;
        r0 = com.techno.gallery.ViewImage.access$900(r0);
        r1 = r4 + r5;
        r2 = r6.getBitmap();
        r0.put(r1, r2);
    L_0x001b:
        if (r5 != 0) goto L_0x0009;
    L_0x001d:
        r0 = r3.this$0;
        r0 = com.techno.gallery.ViewImage.access$500(r0);
        r0.setImageRotateBitmapResetBase(r6, r7);
        r0 = r3.this$0;
        com.techno.gallery.ViewImage.access$400(r0);
        goto L_0x0009;
    }

    public int[] loadOrder() {
        r1 = this;
        r0 = com.techno.gallery.ViewImage.access$1000();
        return r0;
    }

    public boolean wantsFullImage(int r2, int r3) {
        r1 = this;
        if (r3 != 0) goto L_0x0004;
    L_0x0002:
        r0 = 1;
    L_0x0003:
        return r0;
    L_0x0004:
        r0 = 0;
        goto L_0x0003;
    }

    public boolean wantsThumbnail(int r3, int r4) {
        r2 = this;
        r0 = r2.this$0;
        r0 = com.techno.gallery.ViewImage.access$900(r0);
        r1 = r3 + r4;
        r0 = r0.hasBitmap(r1);
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        r0 = 1;
    L_0x000f:
        return r0;
    L_0x0010:
        r0 = 0;
        goto L_0x000f;
    }
}