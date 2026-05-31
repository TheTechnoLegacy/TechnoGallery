package com.techno.gallery;

class BitmapManager$ThreadStatus {
    public android.graphics.BitmapFactory.Options mOptions;
    public com.techno.gallery.BitmapManager.State mState;

    private BitmapManager$ThreadStatus() {
        r1 = this;
        r1.<init>();
        r0 = com.techno.gallery.BitmapManager.State.ALLOW;
        r1.mState = r0;
        return;
    }

    /* synthetic */ BitmapManager$ThreadStatus(com.techno.gallery.BitmapManager.1 r1) {
        r0 = this;
        r0.<init>();
        return;
    }

    public java.lang.String toString() {
        r3 = this;
        r1 = r3.mState;
        r2 = com.techno.gallery.BitmapManager.State.CANCEL;
        if (r1 != r2) goto L_0x0028;
    L_0x0006:
        r0 = "Cancel";
    L_0x0008:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "thread state = ";
        r1 = r1.append(r2);
        r1 = r1.append(r0);
        r2 = ", options = ";
        r1 = r1.append(r2);
        r2 = r3.mOptions;
        r1 = r1.append(r2);
        r0 = r1.toString();
        return r0;
    L_0x0028:
        r1 = r3.mState;
        r2 = com.techno.gallery.BitmapManager.State.ALLOW;
        if (r1 != r2) goto L_0x0031;
    L_0x002e:
        r0 = "Allow";
        goto L_0x0008;
    L_0x0031:
        r0 = "?";
        goto L_0x0008;
    }
}