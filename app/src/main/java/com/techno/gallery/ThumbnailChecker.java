package com.techno.gallery;

/* compiled from: ImageLoader */
class ThumbnailChecker {
    private static final java.lang.String TAG = "ThumbnailChecker";
    private com.techno.gallery.gallery.IImageList mImageListToCheck;
    private int mNextToCheck;
    private com.techno.gallery.ImageLoader.ThumbCheckCallback mThumbCheckCallback;
    private int mTotalToCheck;

    ThumbnailChecker() {
        r1 = this;
        r1.<init>();
        r0 = -1;
        r1.mNextToCheck = r0;
        return;
    }

    synchronized void checkNextThumbnail() {
        r4 = this;
        monitor-enter(r4);
        r1 = r4.mNextToCheck;	 Catch:{ all -> 0x0012 }
        r2 = -1;
        if (r1 != r2) goto L_0x0008;
    L_0x0006:
        monitor-exit(r4);
        return;
    L_0x0008:
        r1 = r4.mNextToCheck;
        r2 = r4.mTotalToCheck;
        if (r1 < r2) goto L_0x0015;
    L_0x000e:
        r4.stopCheckingThumbnails();
        goto L_0x0006;
    L_0x0012:
        r1 = move-exception;
        monitor-exit(r4);
        throw r1;
    L_0x0015:
        r1 = r4.mImageListToCheck;	 Catch:{ IOException -> 0x002c }
        r2 = r4.mNextToCheck;	 Catch:{ IOException -> 0x002c }
        r1.checkThumbnail(r2);	 Catch:{ IOException -> 0x002c }
        r1 = r4.mThumbCheckCallback;
        r2 = r4.mNextToCheck;
        r3 = r4.mTotalToCheck;
        r1 = r1.checking(r2, r3);
        if (r1 != 0) goto L_0x004e;
    L_0x0028:
        r4.stopCheckingThumbnails();
        goto L_0x0006;
    L_0x002c:
        r1 = move-exception;
        r0 = r1;
        r1 = "ThumbnailChecker";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Failed to check thumbnail... was the sd card removed? - ";
        r2 = r2.append(r3);
        r3 = r0.getMessage();
        r2 = r2.append(r3);
        r2 = r2.toString();
        android.util.Log.e(r1, r2);
        r4.stopCheckingThumbnails();
        goto L_0x0006;
    L_0x004e:
        r1 = r4.mNextToCheck;
        r1 = r1 + 1;
        r4.mNextToCheck = r1;
        goto L_0x0006;
    }

    synchronized boolean hasMoreThumbnailsToCheck() {
        r2 = this;
        monitor-enter(r2);
        r0 = r2.mNextToCheck;	 Catch:{ all -> 0x000b }
        r1 = -1;
        if (r0 == r1) goto L_0x0009;
    L_0x0006:
        r0 = 1;
    L_0x0007:
        monitor-exit(r2);
        return r0;
    L_0x0009:
        r0 = 0;
        goto L_0x0007;
    L_0x000b:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    }

    synchronized void startCheckingThumbnails(com.techno.gallery.gallery.IImageList r4, com.techno.gallery.ImageLoader.ThumbCheckCallback r5) {
        r3 = this;
        r2 = 1;
        r1 = 0;
        monitor-enter(r3);
        if (r4 == 0) goto L_0x002e;
    L_0x0005:
        r0 = r2;
    L_0x0006:
        com.techno.gallery.Util.Assert(r0);	 Catch:{ all -> 0x0032 }
        if (r5 == 0) goto L_0x0030;
    L_0x000b:
        r0 = r2;
    L_0x000c:
        com.techno.gallery.Util.Assert(r0);	 Catch:{ all -> 0x0032 }
        r3.mImageListToCheck = r4;	 Catch:{ all -> 0x0032 }
        r0 = r4.getCount();	 Catch:{ all -> 0x0032 }
        r3.mTotalToCheck = r0;	 Catch:{ all -> 0x0032 }
        r0 = 0;
        r3.mNextToCheck = r0;	 Catch:{ all -> 0x0032 }
        r3.mThumbCheckCallback = r5;	 Catch:{ all -> 0x0032 }
        r0 = com.techno.gallery.ImageManager.hasStorage();	 Catch:{ all -> 0x0032 }
        if (r0 != 0) goto L_0x002c;
    L_0x0022:
        r0 = "ThumbnailChecker";
        r1 = "bailing from the image checker -- no storage";
        android.util.Log.v(r0, r1);	 Catch:{ all -> 0x0032 }
        r3.stopCheckingThumbnails();	 Catch:{ all -> 0x0032 }
    L_0x002c:
        monitor-exit(r3);
        return;
    L_0x002e:
        r0 = r1;
        goto L_0x0006;
    L_0x0030:
        r0 = r1;
        goto L_0x000c;
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
    }

    synchronized void stopCheckingThumbnails() {
        r1 = this;
        monitor-enter(r1);
        r0 = r1.mThumbCheckCallback;	 Catch:{ all -> 0x0019 }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r1);
        return;
    L_0x0007:
        r0 = r1.mThumbCheckCallback;
        r0.done();
        r0 = 0;
        r1.mImageListToCheck = r0;
        r0 = 0;
        r1.mTotalToCheck = r0;
        r0 = -1;
        r1.mNextToCheck = r0;
        r0 = 0;
        r1.mThumbCheckCallback = r0;
        goto L_0x0005;
    L_0x0019:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    }
}