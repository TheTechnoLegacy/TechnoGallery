package com.techno.gallery;

/* compiled from: ImageGetter */
interface ImageGetterCallback {
    void completed();

    int fullImageSizeToUse(int r1, int r2);

    void imageLoaded(int r1, int r2, com.techno.gallery.RotateBitmap r3, boolean r4);

    int[] loadOrder();

    boolean wantsFullImage(int r1, int r2);

    boolean wantsThumbnail(int r1, int r2);
}