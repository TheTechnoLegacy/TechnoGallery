package com.techno.gallery;

class ImageLoader$WorkItem {
    com.techno.gallery.gallery.IImage mImage;
    com.techno.gallery.ImageLoader.LoadedCallback mOnLoadedRunnable;
    int mTag;

    ImageLoader$WorkItem(com.techno.gallery.gallery.IImage r1, com.techno.gallery.ImageLoader.LoadedCallback r2, int r3) {
        r0 = this;
        r0.<init>();
        r0.mImage = r1;
        r0.mOnLoadedRunnable = r2;
        r0.mTag = r3;
        return;
    }
}