package com.techno.gallery;

/* compiled from: ViewImage */
class BitmapCache implements com.techno.gallery.ImageViewTouchBase.Recycler {
    private final com.techno.gallery.BitmapCache.Entry[] mCache;

    public BitmapCache(int r4) {
        r3 = this;
        r3.<init>();
        r1 = new com.techno.gallery.BitmapCache.Entry[r4];
        r3.mCache = r1;
        r0 = 0;
    L_0x0008:
        r1 = r3.mCache;
        r1 = r1.length;
        if (r0 >= r1) goto L_0x0019;
    L_0x000d:
        r1 = r3.mCache;
        r2 = new com.techno.gallery.BitmapCache$Entry;
        r2.<init>();
        r1[r0] = r2;
        r0 = r0 + 1;
        goto L_0x0008;
    L_0x0019:
        return;
    }

    private com.techno.gallery.BitmapCache.Entry findEntry(int r6) {
        r5 = this;
        r0 = r5.mCache;
        r3 = r0.length;
        r2 = 0;
    L_0x0004:
        if (r2 >= r3) goto L_0x0011;
    L_0x0006:
        r1 = r0[r2];
        r4 = r1.mPos;
        if (r6 != r4) goto L_0x000e;
    L_0x000c:
        r4 = r1;
    L_0x000d:
        return r4;
    L_0x000e:
        r2 = r2 + 1;
        goto L_0x0004;
    L_0x0011:
        r4 = 0;
        goto L_0x000d;
    }

    public synchronized void clear() {
        r5 = this;
        monitor-enter(r5);
        r0 = r5.mCache;	 Catch:{ all -> 0x001a }
        r3 = r0.length;	 Catch:{ all -> 0x001a }
        r2 = 0;
    L_0x0005:
        if (r2 >= r3) goto L_0x0018;
    L_0x0007:
        r1 = r0[r2];	 Catch:{ all -> 0x001a }
        r4 = r1.mBitmap;	 Catch:{ all -> 0x001a }
        if (r4 == 0) goto L_0x0012;
    L_0x000d:
        r4 = r1.mBitmap;	 Catch:{ all -> 0x001a }
        r4.recycle();	 Catch:{ all -> 0x001a }
    L_0x0012:
        r1.clear();	 Catch:{ all -> 0x001a }
        r2 = r2 + 1;
        goto L_0x0005;
    L_0x0018:
        monitor-exit(r5);
        return;
    L_0x001a:
        r4 = move-exception;
        monitor-exit(r5);
        throw r4;
    }

    public synchronized android.graphics.Bitmap getBitmap(int r3) {
        r2 = this;
        monitor-enter(r2);
        r0 = r2.findEntry(r3);	 Catch:{ all -> 0x000d }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r1 = r0.mBitmap;	 Catch:{ all -> 0x000d }
    L_0x0009:
        monitor-exit(r2);
        return r1;
    L_0x000b:
        r1 = 0;
        goto L_0x0009;
    L_0x000d:
        r1 = move-exception;
        monitor-exit(r2);
        throw r1;
    }

    public synchronized boolean hasBitmap(int r3) {
        r2 = this;
        monitor-enter(r2);
        r0 = r2.findEntry(r3);	 Catch:{ all -> 0x000c }
        if (r0 == 0) goto L_0x000a;
    L_0x0007:
        r1 = 1;
    L_0x0008:
        monitor-exit(r2);
        return r1;
    L_0x000a:
        r1 = 0;
        goto L_0x0008;
    L_0x000c:
        r1 = move-exception;
        monitor-exit(r2);
        throw r1;
    }

    public synchronized void put(int r10, android.graphics.Bitmap r11) {
        r9 = this;
        monitor-enter(r9);
        r7 = r9.findEntry(r10);	 Catch:{ all -> 0x0027 }
        if (r7 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r9);
        return;
    L_0x0009:
        r1 = 0;
        r6 = -1;
        r0 = r9.mCache;
        r5 = r0.length;
        r4 = 0;
    L_0x000f:
        if (r4 >= r5) goto L_0x0019;
    L_0x0011:
        r3 = r0[r4];
        r7 = r3.mPos;
        r8 = -1;
        if (r7 != r8) goto L_0x002a;
    L_0x0018:
        r1 = r3;
    L_0x0019:
        r7 = r1.mBitmap;
        if (r7 == 0) goto L_0x0022;
    L_0x001d:
        r7 = r1.mBitmap;
        r7.recycle();
    L_0x0022:
        r1.mPos = r10;
        r1.mBitmap = r11;
        goto L_0x0007;
    L_0x0027:
        r7 = move-exception;
        monitor-exit(r9);
        throw r7;
    L_0x002a:
        r7 = r3.mPos;
        r7 = r10 - r7;
        r2 = java.lang.Math.abs(r7);
        if (r2 <= r6) goto L_0x0036;
    L_0x0034:
        r6 = r2;
        r1 = r3;
    L_0x0036:
        r4 = r4 + 1;
        goto L_0x000f;
    }

    public synchronized void recycle(android.graphics.Bitmap r7) {
        r6 = this;
        monitor-enter(r6);
        r0 = r6.mCache;	 Catch:{ all -> 0x001b }
        r3 = r0.length;	 Catch:{ all -> 0x001b }
        r2 = 0;
    L_0x0005:
        if (r2 >= r3) goto L_0x0017;
    L_0x0007:
        r1 = r0[r2];	 Catch:{ all -> 0x001b }
        r4 = r1.mPos;	 Catch:{ all -> 0x001b }
        r5 = -1;
        if (r4 == r5) goto L_0x0014;
    L_0x000e:
        r4 = r1.mBitmap;	 Catch:{ all -> 0x001b }
        if (r4 != r7) goto L_0x0014;
    L_0x0012:
        monitor-exit(r6);
        return;
    L_0x0014:
        r2 = r2 + 1;
        goto L_0x0005;
    L_0x0017:
        r7.recycle();
        goto L_0x0012;
    L_0x001b:
        r4 = move-exception;
        monitor-exit(r6);
        throw r4;
    }
}