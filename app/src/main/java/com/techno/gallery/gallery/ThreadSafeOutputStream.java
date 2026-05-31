package com.techno.gallery.gallery;

class ThreadSafeOutputStream extends java.io.OutputStream {
    boolean mClosed;
    private java.io.OutputStream mDelegateStream;

    public ThreadSafeOutputStream(java.io.OutputStream r1) {
        r0 = this;
        r0.<init>();
        r0.mDelegateStream = r1;
        return;
    }

    public synchronized void close() {
        r1 = this;
        monitor-enter(r1);
        r0 = 1;
        r1.mClosed = r0;	 Catch:{ IOException -> 0x000e, all -> 0x000b }
        r0 = r1.mDelegateStream;	 Catch:{ IOException -> 0x000e, all -> 0x000b }
        r0.close();	 Catch:{ IOException -> 0x000e, all -> 0x000b }
    L_0x0009:
        monitor-exit(r1);
        return;
    L_0x000b:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x000e:
        r0 = move-exception;
        goto L_0x0009;
    }

    public synchronized void flush() throws java.io.IOException {
        r1 = this;
        monitor-enter(r1);
        super.flush();	 Catch:{ all -> 0x0006 }
        monitor-exit(r1);
        return;
    L_0x0006:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    }

    public synchronized void write(int r2) throws java.io.IOException {
        r1 = this;
        monitor-enter(r1);
        r0 = r1.mClosed;	 Catch:{ all -> 0x000d }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r1);
        return;
    L_0x0007:
        r0 = r1.mDelegateStream;
        r0.write(r2);
        goto L_0x0005;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    }

    public void write(byte[] r3, int r4, int r5) throws java.io.IOException {
        r2 = this;
    L_0x0000:
        if (r5 <= 0) goto L_0x0008;
    L_0x0002:
        monitor-enter(r2);
        r1 = r2.mClosed;	 Catch:{ all -> 0x0018 }
        if (r1 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r2);	 Catch:{ all -> 0x0018 }
    L_0x0008:
        return;
    L_0x0009:
        r1 = 8192; // 0x2000 float:1.148E-41 double:4.0474E-320;
        r0 = java.lang.Math.min(r1, r5);	 Catch:{ all -> 0x0018 }
        r1 = r2.mDelegateStream;	 Catch:{ all -> 0x0018 }
        r1.write(r3, r4, r0);	 Catch:{ all -> 0x0018 }
        r4 = r4 + r0;
        r5 = r5 - r0;
        monitor-exit(r2);	 Catch:{ all -> 0x0018 }
        goto L_0x0000;
    L_0x0018:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0018 }
        throw r1;
    }
}