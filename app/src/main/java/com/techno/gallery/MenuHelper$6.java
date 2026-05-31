package com.techno.gallery;

class MenuHelper$6 implements com.techno.gallery.MenuHelper.MenuCallback {
    final /* synthetic */ android.app.Activity val$activity;

    MenuHelper$6(android.app.Activity r1) {
        r0 = this;
        r0.val$activity = r1;
        r0.<init>();
        return;
    }

    public void run(android.net.Uri r8, com.techno.gallery.gallery.IImage r9) {
        r7 = this;
        if (r9 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r1 = new android.content.Intent;
        r1.<init>();
        r4 = "android.intent.action.SEND";
        r1.setAction(r4);
        r3 = r9.getMimeType();
        r1.setType(r3);
        r4 = "android.intent.extra.STREAM";
        r1.putExtra(r4, r8);
        r2 = com.techno.gallery.ImageManager.isImage(r9);
        r4 = r7.val$activity;	 Catch:{ ActivityNotFoundException -> 0x0032 }
        r5 = r7.val$activity;	 Catch:{ ActivityNotFoundException -> 0x0032 }
        if (r2 == 0) goto L_0x0044;
    L_0x0023:
        r6 = 2131296419; // 0x7f0900a3 float:1.8210754E38 double:1.0530003417E-314;
    L_0x0026:
        r5 = r5.getText(r6);	 Catch:{ ActivityNotFoundException -> 0x0032 }
        r5 = android.content.Intent.createChooser(r1, r5);	 Catch:{ ActivityNotFoundException -> 0x0032 }
        r4.startActivity(r5);	 Catch:{ ActivityNotFoundException -> 0x0032 }
        goto L_0x0002;
    L_0x0032:
        r4 = move-exception;
        r0 = r4;
        r4 = r7.val$activity;
        if (r2 == 0) goto L_0x0048;
    L_0x0038:
        r5 = 2131296310; // 0x7f090036 float:1.8210533E38 double:1.053000288E-314;
    L_0x003b:
        r6 = 0;
        r4 = android.widget.Toast.makeText(r4, r5, r6);
        r4.show();
        goto L_0x0002;
    L_0x0044:
        r6 = 2131296421; // 0x7f0900a5 float:1.8210758E38 double:1.0530003427E-314;
        goto L_0x0026;
    L_0x0048:
        r5 = 2131296311; // 0x7f090037 float:1.8210535E38 double:1.0530002884E-314;
        goto L_0x003b;
    }
}