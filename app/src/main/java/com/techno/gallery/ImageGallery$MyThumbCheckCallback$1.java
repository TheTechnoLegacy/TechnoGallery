package com.techno.gallery;

class ImageGallery$MyThumbCheckCallback$1 implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.ImageGallery.MyThumbCheckCallback this$1;

    ImageGallery$MyThumbCheckCallback$1(com.techno.gallery.ImageGallery.MyThumbCheckCallback r1) {
        r0 = this;
        r0.this$1 = r1;
        r0.<init>();
        return;
    }

    public void run() {
        r3 = this;
        r2 = 0;
        r0 = r3.this$1;
        r0 = r0.this$0;
        r1 = 2131427346; // 0x7f0b0012 float:1.8476306E38 double:1.0530650283E-314;
        r0 = r0.findViewById(r1);
        r0.setVisibility(r2);
        r0 = r3.this$1;
        r0 = r0.this$0;
        r1 = 16908301; // 0x102000d float:2.3877265E-38 double:8.3538107E-317;
        r0 = r0.findViewById(r1);
        r0.setVisibility(r2);
        return;
    }
}