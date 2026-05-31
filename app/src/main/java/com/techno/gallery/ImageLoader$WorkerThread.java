package com.techno.gallery;

class ImageLoader$WorkerThread implements java.lang.Runnable {
    private static final long IDLE_TIME = 1000000000;
    private long mLastWorkTime;
    final /* synthetic */ com.techno.gallery.ImageLoader this$0;

    private ImageLoader$WorkerThread(com.techno.gallery.ImageLoader r3) {
        r2 = this;
        r2.this$0 = r3;
        r2.<init>();
        r0 = java.lang.System.nanoTime();
        r2.mLastWorkTime = r0;
        return;
    }

    /* synthetic */ ImageLoader$WorkerThread(com.techno.gallery.ImageLoader r1, com.techno.gallery.ImageLoader.1 r2) {
        r0 = this;
        r0.<init>(r1);
        return;
    }

    public void run() {
        r13 = this;
    L_0x0000:
        r4 = 0;
        r5 = r13.this$0;
        r6 = com.techno.gallery.ImageLoader.access$000(r5);
        monitor-enter(r6);
        r5 = r13.this$0;	 Catch:{ all -> 0x0051 }
        r5 = com.techno.gallery.ImageLoader.access$100(r5);	 Catch:{ all -> 0x0051 }
        if (r5 == 0) goto L_0x0012;
    L_0x0010:
        monitor-exit(r6);	 Catch:{ all -> 0x0051 }
        return;
    L_0x0012:
        r5 = r13.this$0;	 Catch:{ all -> 0x0051 }
        r5 = com.techno.gallery.ImageLoader.access$000(r5);	 Catch:{ all -> 0x0051 }
        r5 = r5.isEmpty();	 Catch:{ all -> 0x0051 }
        if (r5 != 0) goto L_0x003a;
    L_0x001e:
        r5 = r13.this$0;	 Catch:{ all -> 0x0051 }
        r5 = com.techno.gallery.ImageLoader.access$000(r5);	 Catch:{ all -> 0x0051 }
        r7 = 0;
        r5 = r5.remove(r7);	 Catch:{ all -> 0x0051 }
        r0 = r5;
        r0 = (com.techno.gallery.ImageLoader.WorkItem) r0;	 Catch:{ all -> 0x0051 }
        r4 = r0;
    L_0x002d:
        monitor-exit(r6);	 Catch:{ all -> 0x0051 }
        if (r4 != 0) goto L_0x0075;
    L_0x0030:
        r5 = r13.this$0;
        r5 = com.techno.gallery.ImageLoader.access$200(r5);
        r5.checkNextThumbnail();
        goto L_0x0000;
    L_0x003a:
        r5 = r13.this$0;
        r5 = com.techno.gallery.ImageLoader.access$200(r5);
        r5 = r5.hasMoreThumbnailsToCheck();
        if (r5 != 0) goto L_0x0054;
    L_0x0046:
        r5 = r13.this$0;	 Catch:{ InterruptedException -> 0x008e }
        r5 = com.techno.gallery.ImageLoader.access$000(r5);	 Catch:{ InterruptedException -> 0x008e }
        r5.wait();	 Catch:{ InterruptedException -> 0x008e }
    L_0x004f:
        monitor-exit(r6);
        goto L_0x0000;
    L_0x0051:
        r5 = move-exception;
        monitor-exit(r6);
        throw r5;
    L_0x0054:
        r7 = 1000000000; // 0x3b9aca00 float:0.0047237873 double:4.94065646E-315;
        r9 = java.lang.System.nanoTime();
        r11 = r13.mLastWorkTime;
        r9 = r9 - r11;
        r2 = r7 - r9;
        r7 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r2 = r2 / r7;
        r7 = 0;
        r5 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1));
        if (r5 <= 0) goto L_0x002d;
    L_0x006a:
        r5 = r13.this$0;	 Catch:{ InterruptedException -> 0x008c }
        r5 = com.techno.gallery.ImageLoader.access$000(r5);	 Catch:{ InterruptedException -> 0x008c }
        r5.wait(r2);	 Catch:{ InterruptedException -> 0x008c }
    L_0x0073:
        monitor-exit(r6);
        goto L_0x0000;
    L_0x0075:
        r5 = r4.mImage;
        r1 = r5.miniThumbBitmap();
        r5 = r4.mOnLoadedRunnable;
        if (r5 == 0) goto L_0x0084;
    L_0x007f:
        r5 = r4.mOnLoadedRunnable;
        r5.run(r1);
    L_0x0084:
        r5 = java.lang.System.nanoTime();
        r13.mLastWorkTime = r5;
        goto L_0x0000;
    L_0x008c:
        r5 = move-exception;
        goto L_0x0073;
    L_0x008e:
        r5 = move-exception;
        goto L_0x004f;
    }
}