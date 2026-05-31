package com.techno.gallery;

/* compiled from: ViewImage */
public class BitmapCache$Entry {
    android.graphics.Bitmap mBitmap;
    int mPos;

    public BitmapCache$Entry() {
        r0 = this;
        r0.<init>();
        r0.clear();
        return;
    }

    public void clear() {
        r1 = this;
        r0 = -1;
        r1.mPos = r0;
        r0 = 0;
        r1.mBitmap = r0;
        return;
    }
}