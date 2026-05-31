package com.techno.gallery;

class ImageGetter {
    private static final java.lang.String TAG = "ImageGetter";
    private com.techno.gallery.ImageGetterCallback mCB;
    private volatile boolean mCancel;
    private int mCurrentPosition;
    private int mCurrentSerial;
    private boolean mDone;
    private java.lang.Thread mGetterThread;
    private com.techno.gallery.GetterHandler mHandler;
    private boolean mIdle;
    private com.techno.gallery.gallery.IImageList mImageList;

    public ImageGetter() {
        r3 = this;
        r1 = 0;
        r3.<init>();
        r0 = -1;
        r3.mCurrentPosition = r0;
        r0 = 1;
        r3.mCancel = r0;
        r3.mIdle = r1;
        r3.mDone = r1;
        r0 = new java.lang.Thread;
        r1 = new com.techno.gallery.ImageGetter$ImageGetterRunnable;
        r2 = 0;
        r1.<init>(r3, r2);
        r0.<init>(r1);
        r3.mGetterThread = r0;
        r0 = r3.mGetterThread;
        r1 = "ImageGettter";
        r0.setName(r1);
        r0 = r3.mGetterThread;
        r0.start();
        return;
    }

    static /* synthetic */ int access$000(com.techno.gallery.ImageGetter r1) {
        r0 = r1.mCurrentSerial;
        return r0;
    }

    static /* synthetic */ com.techno.gallery.ImageGetterCallback access$100(com.techno.gallery.ImageGetter r1) {
        r0 = r1.mCB;
        return r0;
    }

    static /* synthetic */ boolean access$200(com.techno.gallery.ImageGetter r1) {
        r0 = r1.mCancel;
        return r0;
    }

    static /* synthetic */ boolean access$300(com.techno.gallery.ImageGetter r1) {
        r0 = r1.mDone;
        return r0;
    }

    static /* synthetic */ int access$400(com.techno.gallery.ImageGetter r1) {
        r0 = r1.mCurrentPosition;
        return r0;
    }

    static /* synthetic */ int access$402(com.techno.gallery.ImageGetter r0, int r1) {
        r0.mCurrentPosition = r1;
        return r1;
    }

    static /* synthetic */ boolean access$502(com.techno.gallery.ImageGetter r0, boolean r1) {
        r0.mIdle = r1;
        return r1;
    }

    static /* synthetic */ com.techno.gallery.gallery.IImageList access$600(com.techno.gallery.ImageGetter r1) {
        r0 = r1.mImageList;
        return r0;
    }

    static /* synthetic */ com.techno.gallery.GetterHandler access$700(com.techno.gallery.ImageGetter r1) {
        r0 = r1.mHandler;
        return r0;
    }

    private synchronized void cancelCurrentAndWait() {
        r2 = this;
        monitor-enter(r2);
        r2.cancelCurrent();	 Catch:{ all -> 0x0011 }
    L_0x0004:
        r0 = r2.mIdle;	 Catch:{ all -> 0x0011 }
        r1 = 1;
        if (r0 == r1) goto L_0x000f;
    L_0x0009:
        r2.wait();	 Catch:{ InterruptedException -> 0x000d }
        goto L_0x0004;
    L_0x000d:
        r0 = move-exception;
        goto L_0x0004;
    L_0x000f:
        monitor-exit(r2);
        return;
    L_0x0011:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    }

    public synchronized void cancelCurrent() {
        r2 = this;
        r1 = 1;
        monitor-enter(r2);
        r0 = r2.mGetterThread;	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x0018;
    L_0x0006:
        r0 = r1;
    L_0x0007:
        com.techno.gallery.Util.Assert(r0);	 Catch:{ all -> 0x001a }
        r0 = 1;
        r2.mCancel = r0;	 Catch:{ all -> 0x001a }
        r0 = com.techno.gallery.BitmapManager.instance();	 Catch:{ all -> 0x001a }
        r1 = r2.mGetterThread;	 Catch:{ all -> 0x001a }
        r0.cancelThreadDecoding(r1);	 Catch:{ all -> 0x001a }
        monitor-exit(r2);
        return;
    L_0x0018:
        r0 = 0;
        goto L_0x0007;
    L_0x001a:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    }

    public synchronized void setPosition(int r3, com.techno.gallery.ImageGetterCallback r4, com.techno.gallery.gallery.IImageList r5, com.techno.gallery.GetterHandler r6) {
        r2 = this;
        monitor-enter(r2);
        r2.cancelCurrentAndWait();	 Catch:{ all -> 0x0023 }
        r2.mCurrentPosition = r3;	 Catch:{ all -> 0x0023 }
        r2.mCB = r4;	 Catch:{ all -> 0x0023 }
        r2.mImageList = r5;	 Catch:{ all -> 0x0023 }
        r2.mHandler = r6;	 Catch:{ all -> 0x0023 }
        r0 = r2.mCurrentSerial;	 Catch:{ all -> 0x0023 }
        r0 = r0 + 1;
        r2.mCurrentSerial = r0;	 Catch:{ all -> 0x0023 }
        r0 = 0;
        r2.mCancel = r0;	 Catch:{ all -> 0x0023 }
        r0 = com.techno.gallery.BitmapManager.instance();	 Catch:{ all -> 0x0023 }
        r1 = r2.mGetterThread;	 Catch:{ all -> 0x0023 }
        r0.allowThreadDecoding(r1);	 Catch:{ all -> 0x0023 }
        r2.notify();	 Catch:{ all -> 0x0023 }
        monitor-exit(r2);
        return;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    }

    public void stop() {
        r1 = this;
        monitor-enter(r1);
        r1.cancelCurrentAndWait();	 Catch:{ all -> 0x0014 }
        r0 = 1;
        r1.mDone = r0;	 Catch:{ all -> 0x0014 }
        r1.notify();	 Catch:{ all -> 0x0014 }
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        r0 = r1.mGetterThread;	 Catch:{ InterruptedException -> 0x0017 }
        r0.join();	 Catch:{ InterruptedException -> 0x0017 }
    L_0x0010:
        r0 = 0;
        r1.mGetterThread = r0;
        return;
    L_0x0014:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x0017:
        r0 = move-exception;
        goto L_0x0010;
    }
}