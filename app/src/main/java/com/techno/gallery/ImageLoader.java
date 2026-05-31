package com.techno.gallery;

public class ImageLoader {
    private static final java.lang.String TAG = "ImageLoader";
    private java.lang.Thread mDecodeThread;
    private boolean mDone;
    private final java.util.ArrayList<com.techno.gallery.ImageLoader.WorkItem> mQueue;
    private com.techno.gallery.ThumbnailChecker mThumbnailChecker;

    public ImageLoader(android.os.Handler r2) {
        r1 = this;
        r1.<init>();
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1.mQueue = r0;
        r0 = new com.techno.gallery.ThumbnailChecker;
        r0.<init>();
        r1.mThumbnailChecker = r0;
        r1.start();
        return;
    }

    static /* synthetic */ java.util.ArrayList access$000(com.techno.gallery.ImageLoader r1) {
        r0 = r1.mQueue;
        return r0;
    }

    static /* synthetic */ boolean access$100(com.techno.gallery.ImageLoader r1) {
        r0 = r1.mDone;
        return r0;
    }

    static /* synthetic */ com.techno.gallery.ThumbnailChecker access$200(com.techno.gallery.ImageLoader r1) {
        r0 = r1.mThumbnailChecker;
        return r0;
    }

    private int findItem(com.techno.gallery.gallery.IImage r3) {
        r2 = this;
        r0 = 0;
    L_0x0001:
        r1 = r2.mQueue;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x001a;
    L_0x0009:
        r1 = r2.mQueue;
        r1 = r1.get(r0);
        r1 = (com.techno.gallery.ImageLoader.WorkItem) r1;
        r1 = r1.mImage;
        if (r1 != r3) goto L_0x0017;
    L_0x0015:
        r1 = r0;
    L_0x0016:
        return r1;
    L_0x0017:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x001a:
        r1 = -1;
        goto L_0x0016;
    }

    private void start() {
        r3 = this;
        r1 = r3.mDecodeThread;
        if (r1 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r1 = 0;
        r3.mDone = r1;
        r0 = new java.lang.Thread;
        r1 = new com.techno.gallery.ImageLoader$WorkerThread;
        r2 = 0;
        r1.<init>(r3, r2);
        r0.<init>(r1);
        r1 = "image-loader";
        r0.setName(r1);
        r3.mDecodeThread = r0;
        r0.start();
        goto L_0x0004;
    }

    public boolean cancel(com.techno.gallery.gallery.IImage r4) {
        r3 = this;
        r1 = r3.mQueue;
        monitor-enter(r1);
        r0 = r3.findItem(r4);	 Catch:{ all -> 0x0016 }
        if (r0 < 0) goto L_0x0012;
    L_0x0009:
        r2 = r3.mQueue;	 Catch:{ all -> 0x0016 }
        r2.remove(r0);	 Catch:{ all -> 0x0016 }
        r2 = 1;
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        r1 = r2;
    L_0x0011:
        return r1;
    L_0x0012:
        r2 = 0;
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        r1 = r2;
        goto L_0x0011;
    L_0x0016:
        r2 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        throw r2;
    }

    public int[] clearQueue() {
        r5 = this;
        r4 = r5.mQueue;
        monitor-enter(r4);
        r3 = r5.mQueue;	 Catch:{ all -> 0x0024 }
        r1 = r3.size();	 Catch:{ all -> 0x0024 }
        r2 = new int[r1];	 Catch:{ all -> 0x0024 }
        r0 = 0;
    L_0x000c:
        if (r0 >= r1) goto L_0x001d;
    L_0x000e:
        r3 = r5.mQueue;	 Catch:{ all -> 0x0024 }
        r3 = r3.get(r0);	 Catch:{ all -> 0x0024 }
        r3 = (com.techno.gallery.ImageLoader.WorkItem) r3;	 Catch:{ all -> 0x0024 }
        r3 = r3.mTag;	 Catch:{ all -> 0x0024 }
        r2[r0] = r3;	 Catch:{ all -> 0x0024 }
        r0 = r0 + 1;
        goto L_0x000c;
    L_0x001d:
        r3 = r5.mQueue;	 Catch:{ all -> 0x0024 }
        r3.clear();	 Catch:{ all -> 0x0024 }
        monitor-exit(r4);	 Catch:{ all -> 0x0024 }
        return r2;
    L_0x0024:
        r3 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0024 }
        throw r3;
    }

    public void getBitmap(com.techno.gallery.gallery.IImage r4, com.techno.gallery.ImageLoader.LoadedCallback r5, int r6) {
        r3 = this;
        r1 = r3.mDecodeThread;
        if (r1 != 0) goto L_0x0007;
    L_0x0004:
        r3.start();
    L_0x0007:
        r1 = r3.mQueue;
        monitor-enter(r1);
        r0 = new com.techno.gallery.ImageLoader$WorkItem;	 Catch:{ all -> 0x001b }
        r0.<init>(r4, r5, r6);	 Catch:{ all -> 0x001b }
        r2 = r3.mQueue;	 Catch:{ all -> 0x001b }
        r2.add(r0);	 Catch:{ all -> 0x001b }
        r2 = r3.mQueue;	 Catch:{ all -> 0x001b }
        r2.notifyAll();	 Catch:{ all -> 0x001b }
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        return;
    L_0x001b:
        r2 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        throw r2;
    }

    public void startCheckingThumbnails(com.techno.gallery.gallery.IImageList r3, com.techno.gallery.ImageLoader.ThumbCheckCallback r4) {
        r2 = this;
        r0 = r2.mThumbnailChecker;
        r0.startCheckingThumbnails(r3, r4);
        r0 = r2.mQueue;
        monitor-enter(r0);
        r1 = r2.mQueue;	 Catch:{ all -> 0x000f }
        r1.notifyAll();	 Catch:{ all -> 0x000f }
        monitor-exit(r0);	 Catch:{ all -> 0x000f }
        return;
    L_0x000f:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x000f }
        throw r1;
    }

    public void stop() {
        r3 = this;
        r1 = r3.mQueue;
        monitor-enter(r1);
        r2 = 1;
        r3.mDone = r2;	 Catch:{ all -> 0x0023 }
        r2 = r3.mQueue;	 Catch:{ all -> 0x0023 }
        r2.notifyAll();	 Catch:{ all -> 0x0023 }
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        r1 = r3.mDecodeThread;
        if (r1 == 0) goto L_0x001f;
    L_0x0010:
        r0 = r3.mDecodeThread;	 Catch:{ InterruptedException -> 0x0026 }
        r1 = com.techno.gallery.BitmapManager.instance();	 Catch:{ InterruptedException -> 0x0026 }
        r1.cancelThreadDecoding(r0);	 Catch:{ InterruptedException -> 0x0026 }
        r0.join();	 Catch:{ InterruptedException -> 0x0026 }
        r1 = 0;
        r3.mDecodeThread = r1;	 Catch:{ InterruptedException -> 0x0026 }
    L_0x001f:
        r3.stopCheckingThumbnails();
        return;
    L_0x0023:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
    L_0x0026:
        r1 = move-exception;
        goto L_0x001f;
    }

    public void stopCheckingThumbnails() {
        r1 = this;
        r0 = r1.mThumbnailChecker;
        r0.stopCheckingThumbnails();
        return;
    }
}