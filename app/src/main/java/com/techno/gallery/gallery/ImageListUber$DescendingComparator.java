package com.techno.gallery.gallery;

class ImageListUber$DescendingComparator implements java.util.Comparator<com.techno.gallery.gallery.ImageListUber.MergeSlot> {
    private ImageListUber$DescendingComparator() {
        r0 = this;
        r0.<init>();
        return;
    }

    /* synthetic */ ImageListUber$DescendingComparator(com.techno.gallery.gallery.ImageListUber.1 r1) {
        r0 = this;
        r0.<init>();
        return;
    }

    public int compare(com.techno.gallery.gallery.ImageListUber.MergeSlot r5, com.techno.gallery.gallery.ImageListUber.MergeSlot r6) {
        r4 = this;
        r0 = r5.mDateTaken;
        r2 = r6.mDateTaken;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 == 0) goto L_0x0014;
    L_0x0008:
        r0 = r5.mDateTaken;
        r2 = r6.mDateTaken;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x0012;
    L_0x0010:
        r0 = 1;
    L_0x0011:
        return r0;
    L_0x0012:
        r0 = -1;
        goto L_0x0011;
    L_0x0014:
        r0 = r5.mListIndex;
        r1 = r6.mListIndex;
        r0 = r0 - r1;
        goto L_0x0011;
    }

    public /* bridge */ /* synthetic */ int compare(java.lang.Object r2, java.lang.Object r3) {
        r1 = this;
        r2 = (com.techno.gallery.gallery.ImageListUber.MergeSlot) r2;
        r3 = (com.techno.gallery.gallery.ImageListUber.MergeSlot) r3;
        r0 = r1.compare(r2, r3);
        return r0;
    }
}