package com.techno.gallery;

class ImageGallery$6 extends android.content.BroadcastReceiver {
    final /* synthetic */ com.techno.gallery.ImageGallery this$0;

    ImageGallery$6(com.techno.gallery.ImageGallery r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    public void onReceive(android.content.Context r5, android.content.Intent r6) {
        r4 = this;
        r3 = 1;
        r2 = 0;
        r0 = r6.getAction();
        r1 = "android.intent.action.MEDIA_MOUNTED";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r1 = "android.intent.action.MEDIA_UNMOUNTED";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x001d;
    L_0x0017:
        r1 = r4.this$0;
        com.techno.gallery.ImageGallery.access$900(r1, r3, r2);
        goto L_0x000e;
    L_0x001d:
        r1 = "android.intent.action.MEDIA_SCANNER_STARTED";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x002b;
    L_0x0025:
        r1 = r4.this$0;
        com.techno.gallery.ImageGallery.access$900(r1, r2, r3);
        goto L_0x000e;
    L_0x002b:
        r1 = "android.intent.action.MEDIA_SCANNER_FINISHED";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0039;
    L_0x0033:
        r1 = r4.this$0;
        com.techno.gallery.ImageGallery.access$900(r1, r2, r2);
        goto L_0x000e;
    L_0x0039:
        r1 = "android.intent.action.MEDIA_EJECT";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x000e;
    L_0x0041:
        r1 = r4.this$0;
        com.techno.gallery.ImageGallery.access$900(r1, r3, r2);
        goto L_0x000e;
    }
}