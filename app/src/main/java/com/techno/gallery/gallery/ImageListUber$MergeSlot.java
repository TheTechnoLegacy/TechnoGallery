package com.techno.gallery.gallery;

class ImageListUber$MergeSlot {
    long mDateTaken;
    com.techno.gallery.gallery.IImage mImage;
    private final com.techno.gallery.gallery.IImageList mList;
    int mListIndex;
    private int mOffset;

    public ImageListUber$MergeSlot(com.techno.gallery.gallery.IImageList r2, int r3) {
        r1 = this;
        r1.<init>();
        r0 = -1;
        r1.mOffset = r0;
        r1.mList = r2;
        r1.mListIndex = r3;
        return;
    }

    public boolean next() {
        r3 = this;
        r2 = 1;
        r0 = r3.mOffset;
        r1 = r3.mList;
        r1 = r1.getCount();
        r1 = r1 - r2;
        if (r0 < r1) goto L_0x000e;
    L_0x000c:
        r0 = 0;
    L_0x000d:
        return r0;
    L_0x000e:
        r0 = r3.mList;
        r1 = r3.mOffset;
        r1 = r1 + 1;
        r3.mOffset = r1;
        r0 = r0.getImageAt(r1);
        r3.mImage = r0;
        r0 = r3.mImage;
        r0 = r0.getDateTaken();
        r3.mDateTaken = r0;
        r0 = r2;
        goto L_0x000d;
    }
}