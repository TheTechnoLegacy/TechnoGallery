package com.techno.gallery;

class ViewImage$11$1 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.ViewImage.11 this$1;
    final /* synthetic */ com.techno.gallery.RotateBitmap val$bitmap;

    ViewImage$11$1(com.techno.gallery.ViewImage.11 r1, com.techno.gallery.RotateBitmap r2) {
        r0 = this;
        r0.this$1 = r1;
        r0.val$bitmap = r2;
        r0.<init>();
        return;
    }

    public void run() {
        r11 = this;
        r8 = 1;
        r10 = 0;
        r6 = r11.this$1;
        r6 = r6.this$0;
        r6 = com.techno.gallery.ViewImage.access$1200(r6);
        if (r6 != r8) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r6 = r11.this$1;
        r6 = r6.this$0;
        r6 = com.techno.gallery.ViewImage.access$1300(r6);
        r7 = r11.this$1;
        r7 = r7.this$0;
        r7 = com.techno.gallery.ViewImage.access$1400(r7);
        r5 = r6[r7];
        r6 = r11.this$1;
        r6 = r6.this$0;
        r6 = com.techno.gallery.ViewImage.access$1404(r6);
        r7 = r11.this$1;
        r7 = r7.this$0;
        r7 = com.techno.gallery.ViewImage.access$1300(r7);
        r7 = r7.length;
        if (r6 != r7) goto L_0x0039;
    L_0x0032:
        r6 = r11.this$1;
        r6 = r6.this$0;
        com.techno.gallery.ViewImage.access$1402(r6, r10);
    L_0x0039:
        r6 = r11.this$1;
        r6 = r6.this$0;
        r6 = com.techno.gallery.ViewImage.access$1300(r6);
        r7 = r11.this$1;
        r7 = r7.this$0;
        r7 = com.techno.gallery.ViewImage.access$1400(r7);
        r4 = r6[r7];
        r4.setVisibility(r10);
        r6 = r11.val$bitmap;
        r4.setImageRotateBitmapResetBase(r6, r8);
        r4.bringToFront();
        r2 = 0;
        r6 = r11.this$1;
        r6 = r6.this$0;
        r6 = com.techno.gallery.ViewImage.access$1500(r6);
        r7 = -1;
        if (r6 != r7) goto L_0x00f9;
    L_0x0062:
        r6 = r11.this$1;
        r6 = r6.this$0;
        r6 = com.techno.gallery.ViewImage.access$1700(r6);
        r7 = r11.this$1;
        r7 = r7.this$0;
        r7 = com.techno.gallery.ViewImage.access$1600(r7);
        r7 = r7.length;
        r3 = r6.nextInt(r7);
        r2 = r3;
    L_0x0078:
        r6 = r11.this$1;
        r6 = r6.this$0;
        r6 = com.techno.gallery.ViewImage.access$1600(r6);
        r0 = r6[r2];
        r4.startAnimation(r0);
        r4.setVisibility(r10);
        r6 = r11.this$1;
        r6 = r6.this$0;
        r6 = com.techno.gallery.ViewImage.access$1800(r6);
        r1 = r6[r2];
        r6 = 4;
        r5.setVisibility(r6);
        r5.startAnimation(r1);
        r6 = r11.this$1;
        r6 = r6.this$0;
        r7 = r11.this$1;
        r7 = r7.val$requestedPos;
        r6.mCurrentPosition = r7;
        r6 = r11.this$1;
        r6 = r6.this$0;
        r6 = r6.mCurrentPosition;
        r7 = r11.this$1;
        r7 = r7.this$0;
        r7 = com.techno.gallery.ViewImage.access$600(r7);
        if (r6 != r7) goto L_0x00d4;
    L_0x00b3:
        r6 = r11.this$1;
        r6 = r6.val$firstCall;
        if (r6 != 0) goto L_0x00d4;
    L_0x00b9:
        r6 = r11.this$1;
        r6 = r6.this$0;
        r6 = com.techno.gallery.ViewImage.access$1900(r6);
        if (r6 == 0) goto L_0x0103;
    L_0x00c3:
        r6 = r11.this$1;
        r6 = r6.this$0;
        r6 = com.techno.gallery.ViewImage.access$2000(r6);
        if (r6 == 0) goto L_0x00d4;
    L_0x00cd:
        r6 = r11.this$1;
        r6 = r6.this$0;
        com.techno.gallery.ViewImage.access$2100(r6);
    L_0x00d4:
        r6 = r11.this$1;
        r6 = r6.this$0;
        r7 = r11.this$1;
        r7 = r7.this$0;
        r7 = r7.mCurrentPosition;
        r7 = r7 + 1;
        r8 = r11.this$1;
        r8 = r8.this$0;
        r8 = r8.mAllImages;
        r8 = r8.getCount();
        r7 = r7 % r8;
        r8 = r11.this$1;
        r8 = r8.this$0;
        r8 = com.techno.gallery.ViewImage.access$2200(r8);
        r8 = (long) r8;
        com.techno.gallery.ViewImage.access$700(r6, r7, r8, r10);
        goto L_0x000c;
    L_0x00f9:
        r6 = r11.this$1;
        r6 = r6.this$0;
        r2 = com.techno.gallery.ViewImage.access$1500(r6);
        goto L_0x0078;
    L_0x0103:
        r6 = r11.this$1;
        r6 = r6.this$0;
        r6.setMode(r8);
        goto L_0x000c;
    }
}