package com.techno.gallery;

class MenuHelper$UpdateLocationCallback implements com.techno.gallery.ReverseGeocoderTask.Callback {
    java.lang.ref.WeakReference<android.view.View> mView;

    public MenuHelper$UpdateLocationCallback(java.lang.ref.WeakReference<android.view.View> r1) {
        r0 = this;
        r0.<init>();
        r0.mView = r1;
        return;
    }

    public void onComplete(java.lang.String r3) {
        r2 = this;
        r1 = r2.mView;
        r0 = r1.get();
        r0 = (android.view.View) r0;
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r1 = "";
        if (r3 == r1) goto L_0x0016;
    L_0x000f:
        r1 = 2131427376; // 0x7f0b0030 float:1.8476366E38 double:1.053065043E-314;
        com.techno.gallery.MenuHelper.access$000(r0, r3, r1);
        goto L_0x000a;
    L_0x0016:
        r1 = 2131427375; // 0x7f0b002f float:1.8476364E38 double:1.0530650426E-314;
        com.techno.gallery.MenuHelper.access$100(r0, r1);
        goto L_0x000a;
    }
}