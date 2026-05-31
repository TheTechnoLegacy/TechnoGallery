package com.techno.gallery;

class ImageGetter$ImageGetterRunnable implements java.lang.Runnable {
    final /* synthetic */ com.techno.gallery.ImageGetter this$0;

    private ImageGetter$ImageGetterRunnable(com.techno.gallery.ImageGetter r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    /* synthetic */ ImageGetter$ImageGetterRunnable(com.techno.gallery.ImageGetter r1, com.techno.gallery.ImageGetter.1 r2) {
        r0 = this;
        r0.<init>(r1);
        return;
    }

    private java.lang.Runnable callback(int r8, int r9, boolean r10, com.techno.gallery.RotateBitmap r11, int r12) {
        r7 = this;
        r0 = new com.techno.gallery.ImageGetter$ImageGetterRunnable$1;
        r1 = r7;
        r2 = r12;
        r3 = r8;
        r4 = r9;
        r5 = r11;
        r6 = r10;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        return r0;
    }

    private java.lang.Runnable completedCallback(int r2) {
        r1 = this;
        r0 = new com.techno.gallery.ImageGetter$ImageGetterRunnable$2;
        r0.<init>(r1, r2);
        return r0;
    }

    private void executeRequest() {
        r14 = this;
        r0 = r14.this$0;
        r0 = com.techno.gallery.ImageGetter.access$600(r0);
        r10 = r0.getCount();
        r0 = r14.this$0;
        r0 = com.techno.gallery.ImageGetter.access$100(r0);
        r12 = r0.loadOrder();
        r8 = 0;
    L_0x0015:
        r0 = r12.length;
        if (r8 >= r0) goto L_0x0090;
    L_0x0018:
        r0 = r14.this$0;
        r0 = com.techno.gallery.ImageGetter.access$200(r0);
        if (r0 == 0) goto L_0x0021;
    L_0x0020:
        return;
    L_0x0021:
        r2 = r12[r8];
        r0 = r14.this$0;
        r0 = com.techno.gallery.ImageGetter.access$400(r0);
        r11 = r0 + r2;
        if (r11 < 0) goto L_0x0041;
    L_0x002d:
        if (r11 >= r10) goto L_0x0041;
    L_0x002f:
        r0 = r14.this$0;
        r0 = com.techno.gallery.ImageGetter.access$100(r0);
        r1 = r14.this$0;
        r1 = com.techno.gallery.ImageGetter.access$400(r1);
        r0 = r0.wantsThumbnail(r1, r2);
        if (r0 != 0) goto L_0x0044;
    L_0x0041:
        r8 = r8 + 1;
        goto L_0x0015;
    L_0x0044:
        r0 = r14.this$0;
        r0 = com.techno.gallery.ImageGetter.access$600(r0);
        r9 = r0.getImageAt(r11);
        if (r9 == 0) goto L_0x0041;
    L_0x0050:
        r0 = r14.this$0;
        r0 = com.techno.gallery.ImageGetter.access$200(r0);
        if (r0 != 0) goto L_0x0020;
    L_0x0058:
        r0 = 0;
        r6 = r9.thumbBitmap(r0);
        if (r6 == 0) goto L_0x0041;
    L_0x005f:
        r0 = r14.this$0;
        r0 = com.techno.gallery.ImageGetter.access$200(r0);
        if (r0 == 0) goto L_0x006b;
    L_0x0067:
        r6.recycle();
        goto L_0x0020;
    L_0x006b:
        r0 = r14.this$0;
        r1 = com.techno.gallery.ImageGetter.access$400(r0);
        r3 = 1;
        r4 = new com.techno.gallery.RotateBitmap;
        r0 = r9.getDegreesRotated();
        r4.<init>(r6, r0);
        r0 = r14.this$0;
        r5 = com.techno.gallery.ImageGetter.access$000(r0);
        r0 = r14;
        r7 = r0.callback(r1, r2, r3, r4, r5);
        r0 = r14.this$0;
        r0 = com.techno.gallery.ImageGetter.access$700(r0);
        r0.postGetterCallback(r7);
        goto L_0x0041;
    L_0x0090:
        r8 = 0;
    L_0x0091:
        r0 = r12.length;
        if (r8 >= r0) goto L_0x0123;
    L_0x0094:
        r0 = r14.this$0;
        r0 = com.techno.gallery.ImageGetter.access$200(r0);
        if (r0 != 0) goto L_0x0020;
    L_0x009c:
        r2 = r12[r8];
        r0 = r14.this$0;
        r0 = com.techno.gallery.ImageGetter.access$400(r0);
        r11 = r0 + r2;
        if (r11 < 0) goto L_0x00bc;
    L_0x00a8:
        if (r11 >= r10) goto L_0x00bc;
    L_0x00aa:
        r0 = r14.this$0;
        r0 = com.techno.gallery.ImageGetter.access$100(r0);
        r1 = r14.this$0;
        r1 = com.techno.gallery.ImageGetter.access$400(r1);
        r0 = r0.wantsFullImage(r1, r2);
        if (r0 != 0) goto L_0x00bf;
    L_0x00bc:
        r8 = r8 + 1;
        goto L_0x0091;
    L_0x00bf:
        r0 = r14.this$0;
        r0 = com.techno.gallery.ImageGetter.access$600(r0);
        r9 = r0.getImageAt(r11);
        if (r9 == 0) goto L_0x00bc;
    L_0x00cb:
        r0 = r9 instanceof com.techno.gallery.gallery.VideoObject;
        if (r0 != 0) goto L_0x00bc;
    L_0x00cf:
        r0 = r14.this$0;
        r0 = com.techno.gallery.ImageGetter.access$200(r0);
        if (r0 != 0) goto L_0x0020;
    L_0x00d7:
        r0 = r14.this$0;
        r0 = com.techno.gallery.ImageGetter.access$100(r0);
        r1 = r14.this$0;
        r1 = com.techno.gallery.ImageGetter.access$400(r1);
        r13 = r0.fullImageSizeToUse(r1, r2);
        r0 = 3145728; // 0x300000 float:4.408104E-39 double:1.554196E-317;
        r1 = 0;
        r3 = 1;
        r6 = r9.fullSizeBitmap(r13, r0, r1, r3);
        if (r6 == 0) goto L_0x00bc;
    L_0x00f1:
        r0 = r14.this$0;
        r0 = com.techno.gallery.ImageGetter.access$200(r0);
        if (r0 == 0) goto L_0x00fe;
    L_0x00f9:
        r6.recycle();
        goto L_0x0020;
    L_0x00fe:
        r4 = new com.techno.gallery.RotateBitmap;
        r0 = r9.getDegreesRotated();
        r4.<init>(r6, r0);
        r0 = r14.this$0;
        r1 = com.techno.gallery.ImageGetter.access$400(r0);
        r3 = 0;
        r0 = r14.this$0;
        r5 = com.techno.gallery.ImageGetter.access$000(r0);
        r0 = r14;
        r7 = r0.callback(r1, r2, r3, r4, r5);
        r0 = r14.this$0;
        r0 = com.techno.gallery.ImageGetter.access$700(r0);
        r0.postGetterCallback(r7);
        goto L_0x00bc;
    L_0x0123:
        r0 = r14.this$0;
        r0 = com.techno.gallery.ImageGetter.access$700(r0);
        r1 = r14.this$0;
        r1 = com.techno.gallery.ImageGetter.access$000(r1);
        r1 = r14.completedCallback(r1);
        r0.postGetterCallback(r1);
        goto L_0x0020;
    }

    public void run() {
        r4 = this;
        r3 = -1;
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
    L_0x0006:
        r0 = r4.this$0;
        monitor-enter(r0);
    L_0x0009:
        r1 = r4.this$0;	 Catch:{ all -> 0x0042 }
        r1 = com.techno.gallery.ImageGetter.access$200(r1);	 Catch:{ all -> 0x0042 }
        if (r1 != 0) goto L_0x0021;
    L_0x0011:
        r1 = r4.this$0;	 Catch:{ all -> 0x0042 }
        r1 = com.techno.gallery.ImageGetter.access$300(r1);	 Catch:{ all -> 0x0042 }
        if (r1 != 0) goto L_0x0021;
    L_0x0019:
        r1 = r4.this$0;	 Catch:{ all -> 0x0042 }
        r1 = com.techno.gallery.ImageGetter.access$400(r1);	 Catch:{ all -> 0x0042 }
        if (r1 != r3) goto L_0x0045;
    L_0x0021:
        r1 = r4.this$0;	 Catch:{ all -> 0x0042 }
        r1 = com.techno.gallery.ImageGetter.access$300(r1);	 Catch:{ all -> 0x0042 }
        if (r1 == 0) goto L_0x002b;
    L_0x0029:
        monitor-exit(r0);	 Catch:{ all -> 0x0042 }
        return;
    L_0x002b:
        r1 = r4.this$0;	 Catch:{ all -> 0x0042 }
        r2 = 1;
        com.techno.gallery.ImageGetter.access$502(r1, r2);	 Catch:{ all -> 0x0042 }
        r1 = r4.this$0;	 Catch:{ all -> 0x0042 }
        r1.notify();	 Catch:{ all -> 0x0042 }
        r1 = r4.this$0;	 Catch:{ InterruptedException -> 0x0057 }
        r1.wait();	 Catch:{ InterruptedException -> 0x0057 }
    L_0x003b:
        r1 = r4.this$0;
        r2 = 0;
        com.techno.gallery.ImageGetter.access$502(r1, r2);
        goto L_0x0009;
    L_0x0042:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
    L_0x0045:
        monitor-exit(r0);
        r4.executeRequest();
        r0 = r4.this$0;
        monitor-enter(r0);
        r1 = r4.this$0;	 Catch:{ all -> 0x0054 }
        r2 = -1;
        com.techno.gallery.ImageGetter.access$402(r1, r2);	 Catch:{ all -> 0x0054 }
        monitor-exit(r0);	 Catch:{ all -> 0x0054 }
        goto L_0x0006;
    L_0x0054:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0054 }
        throw r1;
    L_0x0057:
        r1 = move-exception;
        goto L_0x003b;
    }
}