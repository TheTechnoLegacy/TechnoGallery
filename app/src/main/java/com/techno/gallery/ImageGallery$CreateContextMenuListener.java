package com.techno.gallery;

class ImageGallery$CreateContextMenuListener implements android.view.View.OnCreateContextMenuListener {
    final /* synthetic */ com.techno.gallery.ImageGallery this$0;

    private ImageGallery$CreateContextMenuListener(com.techno.gallery.ImageGallery r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    /* synthetic */ ImageGallery$CreateContextMenuListener(com.techno.gallery.ImageGallery r1, com.techno.gallery.ImageGallery.1 r2) {
        r0 = this;
        r0.<init>(r1);
        return;
    }

    public void onCreateContextMenu(android.view.ContextMenu r9, android.view.View r10, android.view.ContextMenu.ContextMenuInfo r11) {
        r8 = this;
        r1 = 0;
        r0 = r8.this$0;
        r0 = r0.canHandleEvent();
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r0 = r8.this$0;
        r0 = com.techno.gallery.ImageGallery.access$400(r0);
        if (r0 == 0) goto L_0x0009;
    L_0x0012:
        r0 = r8.this$0;
        r0 = com.techno.gallery.ImageGallery.access$400(r0);
        r6 = com.techno.gallery.ImageManager.isImage(r0);
        if (r6 == 0) goto L_0x002d;
    L_0x001e:
        r0 = 2131296278; // 0x7f090016 float:1.8210468E38 double:1.053000272E-314;
        r0 = r9.add(r1, r1, r1, r0);
        r1 = new com.techno.gallery.ImageGallery$CreateContextMenuListener$1;
        r1.<init>(r8);
        r0.setOnMenuItemClickListener(r1);
    L_0x002d:
        if (r6 == 0) goto L_0x006d;
    L_0x002f:
        r0 = 2131296411; // 0x7f09009b float:1.8210738E38 double:1.053000338E-314;
    L_0x0032:
        r9.setHeaderTitle(r0);
        r0 = r8.this$0;
        r0 = com.techno.gallery.ImageGallery.access$1800(r0);
        r0 = r0 & 5;
        if (r0 == 0) goto L_0x0009;
    L_0x003f:
        r1 = -1;
        r2 = r8.this$0;
        r0 = r8.this$0;
        r3 = com.techno.gallery.ImageGallery.access$1400(r0);
        r0 = r8.this$0;
        r4 = com.techno.gallery.ImageGallery.access$1900(r0);
        r5 = new com.techno.gallery.ImageGallery$CreateContextMenuListener$2;
        r5.<init>(r8);
        r0 = r9;
        r7 = com.techno.gallery.MenuHelper.addImageMenuItems(r0, r1, r2, r3, r4, r5);
        if (r7 == 0) goto L_0x0063;
    L_0x005a:
        r0 = r8.this$0;
        r0 = com.techno.gallery.ImageGallery.access$400(r0);
        r7.gettingReadyToOpen(r9, r0);
    L_0x0063:
        if (r6 == 0) goto L_0x0009;
    L_0x0065:
        r0 = r8.this$0;
        r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        com.techno.gallery.ImageGallery.access$2100(r0, r9, r1);
        goto L_0x0009;
    L_0x006d:
        r0 = 2131296412; // 0x7f09009c float:1.821074E38 double:1.0530003383E-314;
        goto L_0x0032;
    }
}