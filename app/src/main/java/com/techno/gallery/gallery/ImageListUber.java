package com.techno.gallery.gallery;

public class ImageListUber implements com.techno.gallery.gallery.IImageList {
    public static final android.os.Parcelable.Creator<com.techno.gallery.gallery.ImageListUber> CREATOR = null;
    private static final java.lang.String TAG = "ImageListUber";
    private int mLastListIndex;
    private final java.util.PriorityQueue<com.techno.gallery.gallery.ImageListUber.MergeSlot> mQueue;
    private int[] mSkipCounts;
    private long[] mSkipList;
    private int mSkipListSize;
    private final com.techno.gallery.gallery.IImageList[] mSubList;

    static {
        r0 = new com.techno.gallery.gallery.ImageListUber$1;
        r0.<init>();
        CREATOR = r0;
        return;
    }

    protected ImageListUber(android.os.Parcel r7) {
        r6 = this;
        r5 = 0;
        r4 = 0;
        r6.<init>();
        r2 = com.techno.gallery.gallery.ImageListUber.class;
        r2 = r2.getClassLoader();
        r0 = r7.readParcelableArray(r2);
        r2 = r0.length;
        r2 = new com.techno.gallery.gallery.IImageList[r2];
        r6.mSubList = r2;
        r2 = r6.mSubList;
        r3 = r0.length;
        java.lang.System.arraycopy(r0, r4, r2, r4, r3);
        r1 = r7.readInt();
        r2 = r6.mSubList;
        r2 = r2.length;
        r2 = new int[r2];
        r6.mSkipCounts = r2;
        r2 = new java.util.PriorityQueue;
        r3 = 4;
        r4 = 1;
        if (r1 != r4) goto L_0x0036;
    L_0x002b:
        r4 = new com.techno.gallery.gallery.ImageListUber$AscendingComparator;
        r4.<init>(r5);
    L_0x0030:
        r2.<init>(r3, r4);
        r6.mQueue = r2;
        return;
    L_0x0036:
        r4 = new com.techno.gallery.gallery.ImageListUber$DescendingComparator;
        r4.<init>(r5);
        goto L_0x0030;
    }

    public ImageListUber(com.techno.gallery.gallery.IImageList[] r5, int r6) {
        r4 = this;
        r3 = 0;
        r4.<init>();
        r0 = r5.clone();
        r0 = (com.techno.gallery.gallery.IImageList[]) r0;
        r4.mSubList = r0;
        r0 = new java.util.PriorityQueue;
        r1 = 4;
        r2 = 1;
        if (r6 != r2) goto L_0x001d;
    L_0x0012:
        r2 = new com.techno.gallery.gallery.ImageListUber$AscendingComparator;
        r2.<init>(r3);
    L_0x0017:
        r0.<init>(r1, r2);
        r4.mQueue = r0;
        return;
    L_0x001d:
        r2 = new com.techno.gallery.gallery.ImageListUber$DescendingComparator;
        r2.<init>(r3);
        goto L_0x0017;
    }

    private void modifySkipCountForDeletedImage(int r11) {
        r10 = this;
        r3 = 0;
        r0 = 0;
        r1 = r10.mSkipListSize;
    L_0x0004:
        if (r0 >= r1) goto L_0x001f;
    L_0x0006:
        r7 = r10.mSkipList;
        r4 = r7[r0];
        r7 = -1;
        r7 = r7 & r4;
        r2 = (int) r7;
        r7 = 32;
        r7 = r4 >> r7;
        r6 = (int) r7;
        r7 = r3 + r2;
        if (r7 <= r11) goto L_0x0020;
    L_0x0017:
        r7 = r10.mSkipList;
        r8 = 1;
        r8 = r4 - r8;
        r7[r0] = r8;
    L_0x001f:
        return;
    L_0x0020:
        r3 = r3 + r2;
        r0 = r0 + 1;
        goto L_0x0004;
    }

    private com.techno.gallery.gallery.ImageListUber.MergeSlot nextMergeSlot() {
        r10 = this;
        r8 = 1;
        r5 = 0;
        r3 = r10.mQueue;
        r1 = r3.poll();
        r1 = (com.techno.gallery.gallery.ImageListUber.MergeSlot) r1;
        if (r1 != 0) goto L_0x000f;
    L_0x000d:
        r3 = 0;
    L_0x000e:
        return r3;
    L_0x000f:
        r3 = r1.mListIndex;
        r4 = r10.mLastListIndex;
        if (r3 != r4) goto L_0x0023;
    L_0x0015:
        r3 = r10.mSkipListSize;
        r4 = 1;
        r0 = r3 - r4;
        r3 = r10.mSkipList;
        r4 = r3[r0];
        r4 = r4 + r8;
        r3[r0] = r4;
    L_0x0021:
        r3 = r1;
        goto L_0x000e;
    L_0x0023:
        r3 = r1.mListIndex;
        r10.mLastListIndex = r3;
        r3 = r10.mSkipList;
        r3 = r3.length;
        r4 = r10.mSkipListSize;
        if (r3 != r4) goto L_0x003d;
    L_0x002e:
        r3 = r10.mSkipListSize;
        r3 = r3 * 2;
        r2 = new long[r3];
        r3 = r10.mSkipList;
        r4 = r10.mSkipListSize;
        java.lang.System.arraycopy(r3, r5, r2, r5, r4);
        r10.mSkipList = r2;
    L_0x003d:
        r3 = r10.mSkipList;
        r4 = r10.mSkipListSize;
        r5 = r4 + 1;
        r10.mSkipListSize = r5;
        r5 = r10.mLastListIndex;
        r5 = (long) r5;
        r7 = 32;
        r5 = r5 << r7;
        r5 = r5 | r8;
        r3[r4] = r5;
        goto L_0x0021;
    }

    private boolean removeImage(com.techno.gallery.gallery.IImage r3, int r4) {
        r2 = this;
        r0 = r3.getContainer();
        if (r0 == 0) goto L_0x0011;
    L_0x0006:
        r1 = r0.removeImage(r3);
        if (r1 == 0) goto L_0x0011;
    L_0x000c:
        r2.modifySkipCountForDeletedImage(r4);
        r1 = 1;
    L_0x0010:
        return r1;
    L_0x0011:
        r1 = 0;
        goto L_0x0010;
    }

    public void checkThumbnail(int r6) throws java.io.IOException {
        r5 = this;
        r0 = r5.mSubList;
        r3 = r0.length;
        r2 = 0;
    L_0x0004:
        if (r2 >= r3) goto L_0x0011;
    L_0x0006:
        r4 = r0[r2];
        r1 = r4.getCount();
        if (r1 <= r6) goto L_0x0012;
    L_0x000e:
        r4.checkThumbnail(r6);
    L_0x0011:
        return;
    L_0x0012:
        r6 = r6 - r1;
        r2 = r2 + 1;
        goto L_0x0004;
    }

    public void close() {
        r4 = this;
        r0 = 0;
        r3 = r4.mSubList;
        r2 = r3.length;
    L_0x0004:
        if (r0 >= r2) goto L_0x0016;
    L_0x0006:
        r3 = r4.mSubList;
        r1 = r3[r0];
        r3 = r1 instanceof com.techno.gallery.gallery.BaseImageList;
        if (r3 == 0) goto L_0x0013;
    L_0x000e:
        r1 = (com.techno.gallery.gallery.BaseImageList) r1;
        r1.close();
    L_0x0013:
        r0 = r0 + 1;
        goto L_0x0004;
    L_0x0016:
        return;
    }

    public void deactivate() {
        r4 = this;
        r0 = r4.mSubList;
        r2 = r0.length;
        r1 = 0;
    L_0x0004:
        if (r1 >= r2) goto L_0x000e;
    L_0x0006:
        r3 = r0[r1];
        r3.deactivate();
        r1 = r1 + 1;
        goto L_0x0004;
    L_0x000e:
        return;
    }

    public int describeContents() {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public java.util.HashMap<java.lang.String, java.lang.String> getBucketIds() {
        r6 = this;
        r1 = new java.util.HashMap;
        r1.<init>();
        r0 = r6.mSubList;
        r3 = r0.length;
        r2 = 0;
    L_0x0009:
        if (r2 >= r3) goto L_0x0017;
    L_0x000b:
        r4 = r0[r2];
        r5 = r4.getBucketIds();
        r1.putAll(r5);
        r2 = r2 + 1;
        goto L_0x0009;
    L_0x0017:
        return r1;
    }

    public int getCount() {
        r6 = this;
        r1 = 0;
        r0 = r6.mSubList;
        r3 = r0.length;
        r2 = 0;
    L_0x0005:
        if (r2 >= r3) goto L_0x0011;
    L_0x0007:
        r4 = r0[r2];
        r5 = r4.getCount();
        r1 = r1 + r5;
        r2 = r2 + 1;
        goto L_0x0005;
    L_0x0011:
        return r1;
    }

    public com.techno.gallery.gallery.IImage getImageAt(int r15) {
        r14 = this;
        if (r15 < 0) goto L_0x0008;
    L_0x0002:
        r11 = r14.getCount();
        if (r15 <= r11) goto L_0x002f;
    L_0x0008:
        r11 = new java.lang.IndexOutOfBoundsException;
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r13 = "index ";
        r12 = r12.append(r13);
        r12 = r12.append(r15);
        r13 = " out of range max is ";
        r12 = r12.append(r13);
        r13 = r14.getCount();
        r12 = r12.append(r13);
        r12 = r12.toString();
        r11.<init>(r12);
        throw r11;
    L_0x002f:
        r5 = r14.mSkipCounts;
        r11 = 0;
        java.util.Arrays.fill(r5, r11);
        r4 = 0;
        r0 = 0;
        r1 = r14.mSkipListSize;
    L_0x0039:
        if (r0 >= r1) goto L_0x0075;
    L_0x003b:
        r11 = r14.mSkipList;
        r8 = r11[r0];
        r11 = -1;
        r11 = r11 & r8;
        r2 = (int) r11;
        r11 = 32;
        r11 = r8 >> r11;
        r10 = (int) r11;
        r11 = r4 + r2;
        if (r11 <= r15) goto L_0x005d;
    L_0x004c:
        r11 = r14.mSkipCounts;
        r11 = r11[r10];
        r12 = r15 - r4;
        r7 = r11 + r12;
        r11 = r14.mSubList;
        r11 = r11[r10];
        r11 = r11.getImageAt(r7);
    L_0x005c:
        return r11;
    L_0x005d:
        r4 = r4 + r2;
        r11 = r14.mSkipCounts;
        r12 = r11[r10];
        r12 = r12 + r2;
        r11[r10] = r12;
        r0 = r0 + 1;
        goto L_0x0039;
    L_0x0068:
        r11 = r6.next();
        if (r11 == 0) goto L_0x0073;
    L_0x006e:
        r11 = r14.mQueue;
        r11.add(r6);
    L_0x0073:
        r4 = r4 + 1;
    L_0x0075:
        r6 = r14.nextMergeSlot();
        if (r6 != 0) goto L_0x007d;
    L_0x007b:
        r11 = 0;
        goto L_0x005c;
    L_0x007d:
        if (r4 != r15) goto L_0x0068;
    L_0x007f:
        r3 = r6.mImage;
        r11 = r6.next();
        if (r11 == 0) goto L_0x008c;
    L_0x0087:
        r11 = r14.mQueue;
        r11.add(r6);
    L_0x008c:
        r11 = r3;
        goto L_0x005c;
    }

    public com.techno.gallery.gallery.IImage getImageForUri(android.net.Uri r7) {
        r6 = this;
        r0 = r6.mSubList;
        r3 = r0.length;
        r1 = 0;
    L_0x0004:
        if (r1 >= r3) goto L_0x0013;
    L_0x0006:
        r4 = r0[r1];
        r2 = r4.getImageForUri(r7);
        if (r2 == 0) goto L_0x0010;
    L_0x000e:
        r5 = r2;
    L_0x000f:
        return r5;
    L_0x0010:
        r1 = r1 + 1;
        goto L_0x0004;
    L_0x0013:
        r5 = 0;
        goto L_0x000f;
    }

    public synchronized int getImageIndex(com.techno.gallery.gallery.IImage r15) {
        r14 = this;
        r13 = -1;
        monitor-enter(r14);
        r1 = r15.getContainer();	 Catch:{ all -> 0x0014 }
        r11 = r14.mSubList;	 Catch:{ all -> 0x0014 }
        r2 = com.techno.gallery.Util.indexOf(r11, r1);	 Catch:{ all -> 0x0014 }
        if (r2 != r13) goto L_0x0017;
    L_0x000e:
        r11 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x0014 }
        r11.<init>();	 Catch:{ all -> 0x0014 }
        throw r11;	 Catch:{ all -> 0x0014 }
    L_0x0014:
        r11 = move-exception;
        monitor-exit(r14);
        throw r11;
    L_0x0017:
        r3 = r1.getImageIndex(r15);
        r6 = 0;
        r0 = 0;
        r4 = r14.mSkipListSize;
    L_0x001f:
        if (r0 >= r4) goto L_0x0048;
    L_0x0021:
        r11 = r14.mSkipList;
        r8 = r11[r0];
        r11 = -1;
        r11 = r11 & r8;
        r5 = (int) r11;
        r11 = 32;
        r11 = r8 >> r11;
        r10 = (int) r11;
        if (r10 != r2) goto L_0x0037;
    L_0x0030:
        if (r3 >= r5) goto L_0x0036;
    L_0x0032:
        r11 = r6 + r3;
    L_0x0034:
        monitor-exit(r14);
        return r11;
    L_0x0036:
        r3 = r3 - r5;
    L_0x0037:
        r6 = r6 + r5;
        r0 = r0 + 1;
        goto L_0x001f;
    L_0x003b:
        r11 = r7.next();
        if (r11 == 0) goto L_0x0046;
    L_0x0041:
        r11 = r14.mQueue;
        r11.add(r7);
    L_0x0046:
        r6 = r6 + 1;
    L_0x0048:
        r7 = r14.nextMergeSlot();
        if (r7 != 0) goto L_0x0050;
    L_0x004e:
        r11 = r13;
        goto L_0x0034;
    L_0x0050:
        r11 = r7.mImage;
        if (r11 != r15) goto L_0x003b;
    L_0x0054:
        r11 = r7.next();
        if (r11 == 0) goto L_0x005f;
    L_0x005a:
        r11 = r14.mQueue;
        r11.add(r7);
    L_0x005f:
        r11 = r6;
        goto L_0x0034;
    }

    public boolean isEmpty() {
        r5 = this;
        r0 = r5.mSubList;
        r2 = r0.length;
        r1 = 0;
    L_0x0004:
        if (r1 >= r2) goto L_0x0013;
    L_0x0006:
        r3 = r0[r1];
        r4 = r3.isEmpty();
        if (r4 != 0) goto L_0x0010;
    L_0x000e:
        r4 = 0;
    L_0x000f:
        return r4;
    L_0x0010:
        r1 = r1 + 1;
        goto L_0x0004;
    L_0x0013:
        r4 = 1;
        goto L_0x000f;
    }

    public void open(android.content.ContentResolver r7) {
        r6 = this;
        r5 = 16;
        r5 = new long[r5];
        r6.mSkipList = r5;
        r5 = 0;
        r6.mSkipListSize = r5;
        r5 = r6.mSubList;
        r5 = r5.length;
        r5 = new int[r5];
        r6.mSkipCounts = r5;
        r5 = -1;
        r6.mLastListIndex = r5;
        r5 = r6.mQueue;
        r5.clear();
        r1 = 0;
        r5 = r6.mSubList;
        r3 = r5.length;
    L_0x001c:
        if (r1 >= r3) goto L_0x0040;
    L_0x001e:
        r5 = r6.mSubList;
        r2 = r5[r1];
        r5 = r2 instanceof com.techno.gallery.gallery.BaseImageList;
        if (r5 == 0) goto L_0x002d;
    L_0x0026:
        r0 = r2;
        r0 = (com.techno.gallery.gallery.BaseImageList) r0;
        r5 = r0;
        r5.open(r7);
    L_0x002d:
        r4 = new com.techno.gallery.gallery.ImageListUber$MergeSlot;
        r4.<init>(r2, r1);
        r5 = r4.next();
        if (r5 == 0) goto L_0x003d;
    L_0x0038:
        r5 = r6.mQueue;
        r5.add(r4);
    L_0x003d:
        r1 = r1 + 1;
        goto L_0x001c;
    L_0x0040:
        return;
    }

    public boolean removeImage(com.techno.gallery.gallery.IImage r2) {
        r1 = this;
        r0 = r1.getImageIndex(r2);
        r0 = r1.removeImage(r2, r0);
        return r0;
    }

    public boolean removeImageAt(int r3) {
        r2 = this;
        r0 = r2.getImageAt(r3);
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        r1 = 0;
    L_0x0007:
        return r1;
    L_0x0008:
        r1 = r2.removeImage(r0, r3);
        goto L_0x0007;
    }

    public void writeToParcel(android.os.Parcel r2, int r3) {
        r1 = this;
        r0 = r1.mSubList;
        r2.writeParcelableArray(r0, r3);
        r0 = r1.mQueue;
        r0 = r0.comparator();
        r0 = r0 instanceof com.techno.gallery.gallery.ImageListUber.AscendingComparator;
        if (r0 == 0) goto L_0x0014;
    L_0x000f:
        r0 = 1;
    L_0x0010:
        r2.writeInt(r0);
        return;
    L_0x0014:
        r0 = 2;
        goto L_0x0010;
    }
}