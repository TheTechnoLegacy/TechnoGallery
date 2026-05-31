package com.techno.gallery;

class MenuHelper$18 implements com.techno.gallery.MenuHelper.MenuItemsResult {
    final /* synthetic */ java.util.ArrayList val$requiresImageItems;
    final /* synthetic */ java.util.ArrayList val$requiresNoDrmAccessItems;
    final /* synthetic */ java.util.ArrayList val$requiresVideoItems;
    final /* synthetic */ java.util.ArrayList val$requiresWriteAccessItems;

    MenuHelper$18(java.util.ArrayList r1, java.util.ArrayList r2, java.util.ArrayList r3, java.util.ArrayList r4) {
        r0 = this;
        r0.val$requiresWriteAccessItems = r1;
        r0.val$requiresNoDrmAccessItems = r2;
        r0.val$requiresImageItems = r3;
        r0.val$requiresVideoItems = r4;
        r0.<init>();
        return;
    }

    public void aboutToCall(android.view.MenuItem r1, com.techno.gallery.gallery.IImage r2) {
        r0 = this;
        return;
    }

    public void gettingReadyToOpen(android.view.Menu r9, com.techno.gallery.gallery.IImage r10) {
        r8 = this;
        r7 = 1;
        r6 = 0;
        if (r10 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r0 = new java.util.ArrayList;
        r0.<init>();
        r5 = r10.isReadonly();
        if (r5 == 0) goto L_0x0056;
    L_0x0015:
        r4 = r0;
    L_0x0016:
        r5 = r8.val$requiresWriteAccessItems;
        r4.addAll(r5);
        r5 = r10.isDrm();
        if (r5 == 0) goto L_0x0058;
    L_0x0021:
        r4 = r0;
    L_0x0022:
        r5 = r8.val$requiresNoDrmAccessItems;
        r4.addAll(r5);
        r5 = com.techno.gallery.ImageManager.isImage(r10);
        if (r5 == 0) goto L_0x005a;
    L_0x002d:
        r4 = r1;
    L_0x002e:
        r5 = r8.val$requiresImageItems;
        r4.addAll(r5);
        r5 = com.techno.gallery.ImageManager.isVideo(r10);
        if (r5 == 0) goto L_0x005c;
    L_0x0039:
        r4 = r1;
    L_0x003a:
        r5 = r8.val$requiresVideoItems;
        r4.addAll(r5);
        r2 = r1.iterator();
    L_0x0043:
        r5 = r2.hasNext();
        if (r5 == 0) goto L_0x005e;
    L_0x0049:
        r3 = r2.next();
        r3 = (android.view.MenuItem) r3;
        r3.setVisible(r7);
        r3.setEnabled(r7);
        goto L_0x0043;
    L_0x0056:
        r4 = r1;
        goto L_0x0016;
    L_0x0058:
        r4 = r1;
        goto L_0x0022;
    L_0x005a:
        r4 = r0;
        goto L_0x002e;
    L_0x005c:
        r4 = r0;
        goto L_0x003a;
    L_0x005e:
        r2 = r0.iterator();
    L_0x0062:
        r5 = r2.hasNext();
        if (r5 == 0) goto L_0x0004;
    L_0x0068:
        r3 = r2.next();
        r3 = (android.view.MenuItem) r3;
        r3.setVisible(r6);
        r3.setEnabled(r6);
        goto L_0x0062;
    }
}