package com.techno.gallery;

/* compiled from: ImageGetter */
class GetterHandler extends android.os.Handler {
    private static final int IMAGE_GETTER_CALLBACK = 1;

    GetterHandler() {
        r0 = this;
        r0.<init>();
        return;
    }

    public void handleMessage(android.os.Message r2) {
        r1 = this;
        r0 = r2.what;
        switch(r0) {
            case 1: goto L_0x0006;
            default: goto L_0x0005;
        };
    L_0x0005:
        return;
    L_0x0006:
        r1 = r2.obj;
        r1 = (java.lang.Runnable) r1;
        r1.run();
        goto L_0x0005;
    }

    public void postDelayedGetterCallback(java.lang.Runnable r3, long r4) {
        r2 = this;
        if (r3 != 0) goto L_0x0008;
    L_0x0002:
        r1 = new java.lang.NullPointerException;
        r1.<init>();
        throw r1;
    L_0x0008:
        r0 = android.os.Message.obtain();
        r1 = 1;
        r0.what = r1;
        r0.obj = r3;
        r2.sendMessageDelayed(r0, r4);
        return;
    }

    public void postGetterCallback(java.lang.Runnable r3) {
        r2 = this;
        r0 = 0;
        r2.postDelayedGetterCallback(r3, r0);
        return;
    }

    public void removeAllGetterCallbacks() {
        r1 = this;
        r0 = 1;
        r1.removeMessages(r0);
        return;
    }
}