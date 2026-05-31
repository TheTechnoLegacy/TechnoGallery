package com.techno.gallery;

class CropImage$5$1 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.CropImage.5 this$1;

    CropImage$5$1(com.techno.gallery.CropImage.5 r1) {
        r0 = this;
        r0.this$1 = r1;
        r0.<init>();
        return;
    }

    public void run() {
        r6 = this;
        r5 = 0;
        r4 = 1;
        r2 = r6.this$1;
        r2 = r2.this$0;
        r3 = r6.this$1;
        r3 = r3.mNumFaces;
        if (r3 <= r4) goto L_0x002a;
    L_0x000c:
        r3 = r4;
    L_0x000d:
        r2.mWaitingToPick = r3;
        r2 = r6.this$1;
        r2 = r2.mNumFaces;
        if (r2 <= 0) goto L_0x002c;
    L_0x0015:
        r0 = 0;
    L_0x0016:
        r2 = r6.this$1;
        r2 = r2.mNumFaces;
        if (r0 >= r2) goto L_0x0031;
    L_0x001c:
        r2 = r6.this$1;
        r3 = r6.this$1;
        r3 = r3.mFaces;
        r3 = r3[r0];
        com.techno.gallery.CropImage.5.access$1000(r2, r3);
        r0 = r0 + 1;
        goto L_0x0016;
    L_0x002a:
        r3 = r5;
        goto L_0x000d;
    L_0x002c:
        r2 = r6.this$1;
        com.techno.gallery.CropImage.5.access$1100(r2);
    L_0x0031:
        r2 = r6.this$1;
        r2 = r2.this$0;
        r2 = com.techno.gallery.CropImage.access$300(r2);
        r2.invalidate();
        r2 = r6.this$1;
        r2 = r2.this$0;
        r2 = com.techno.gallery.CropImage.access$300(r2);
        r2 = r2.mHighlightViews;
        r2 = r2.size();
        if (r2 != r4) goto L_0x006b;
    L_0x004c:
        r2 = r6.this$1;
        r3 = r2.this$0;
        r2 = r6.this$1;
        r2 = r2.this$0;
        r2 = com.techno.gallery.CropImage.access$300(r2);
        r2 = r2.mHighlightViews;
        r2 = r2.get(r5);
        r2 = (com.techno.gallery.HighlightView) r2;
        r3.mCrop = r2;
        r2 = r6.this$1;
        r2 = r2.this$0;
        r2 = r2.mCrop;
        r2.setFocus(r4);
    L_0x006b:
        r2 = r6.this$1;
        r2 = r2.mNumFaces;
        if (r2 <= r4) goto L_0x007f;
    L_0x0071:
        r2 = r6.this$1;
        r2 = r2.this$0;
        r3 = 2131296413; // 0x7f09009d float:1.8210742E38 double:1.053000339E-314;
        r1 = android.widget.Toast.makeText(r2, r3, r5);
        r1.show();
    L_0x007f:
        return;
    }
}