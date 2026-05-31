package com.techno.gallery;

public class BitmapManager {
    private static final java.lang.String TAG = "BitmapManager";
    private static com.techno.gallery.BitmapManager sManager;
    private final java.util.WeakHashMap<java.lang.Thread, com.techno.gallery.BitmapManager.ThreadStatus> mThreadStatus;

    static {
        r0 = 0;
        sManager = r0;
        return;
    }

    private BitmapManager() {
        r1 = this;
        r1.<init>();
        r0 = new java.util.WeakHashMap;
        r0.<init>();
        r1.mThreadStatus = r0;
        return;
    }

    private synchronized com.techno.gallery.BitmapManager.ThreadStatus getOrCreateThreadStatus(java.lang.Thread r3) {
        r2 = this;
        monitor-enter(r2);
        r1 = r2.mThreadStatus;	 Catch:{ all -> 0x0018 }
        r0 = r1.get(r3);	 Catch:{ all -> 0x0018 }
        r0 = (com.techno.gallery.BitmapManager.ThreadStatus) r0;	 Catch:{ all -> 0x0018 }
        if (r0 != 0) goto L_0x0016;
    L_0x000b:
        r0 = new com.techno.gallery.BitmapManager$ThreadStatus;	 Catch:{ all -> 0x0018 }
        r1 = 0;
        r0.<init>(r1);	 Catch:{ all -> 0x0018 }
        r1 = r2.mThreadStatus;	 Catch:{ all -> 0x0018 }
        r1.put(r3, r0);	 Catch:{ all -> 0x0018 }
    L_0x0016:
        monitor-exit(r2);
        return r0;
    L_0x0018:
        r1 = move-exception;
        monitor-exit(r2);
        throw r1;
    }

    public static synchronized com.techno.gallery.BitmapManager instance() {
        r0 = com.techno.gallery.BitmapManager.class;
        monitor-enter(r0);
        r1 = sManager;	 Catch:{ all -> 0x0012 }
        if (r1 != 0) goto L_0x000e;
    L_0x0007:
        r1 = new com.techno.gallery.BitmapManager;	 Catch:{ all -> 0x0012 }
        r1.<init>();	 Catch:{ all -> 0x0012 }
        sManager = r1;	 Catch:{ all -> 0x0012 }
    L_0x000e:
        r1 = sManager;	 Catch:{ all -> 0x0012 }
        monitor-exit(r0);
        return r1;
    L_0x0012:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
    }

    private synchronized void setDecodingOptions(java.lang.Thread r2, android.graphics.BitmapFactory.Options r3) {
        r1 = this;
        monitor-enter(r1);
        r0 = r1.getOrCreateThreadStatus(r2);	 Catch:{ all -> 0x0009 }
        r0.mOptions = r3;	 Catch:{ all -> 0x0009 }
        monitor-exit(r1);
        return;
    L_0x0009:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    }

    public synchronized void allowThreadDecoding(com.techno.gallery.BitmapManager.ThreadSet r4) {
        r3 = this;
        monitor-enter(r3);
        r0 = r4.iterator();	 Catch:{ all -> 0x0015 }
    L_0x0005:
        r2 = r0.hasNext();	 Catch:{ all -> 0x0015 }
        if (r2 == 0) goto L_0x0018;
    L_0x000b:
        r1 = r0.next();	 Catch:{ all -> 0x0015 }
        r1 = (java.lang.Thread) r1;	 Catch:{ all -> 0x0015 }
        r3.allowThreadDecoding(r1);	 Catch:{ all -> 0x0015 }
        goto L_0x0005;
    L_0x0015:
        r2 = move-exception;
        monitor-exit(r3);
        throw r2;
    L_0x0018:
        monitor-exit(r3);
        return;
    }

    public synchronized void allowThreadDecoding(java.lang.Thread r3) {
        r2 = this;
        monitor-enter(r2);
        r0 = r2.getOrCreateThreadStatus(r3);	 Catch:{ all -> 0x000b }
        r1 = com.techno.gallery.BitmapManager.State.ALLOW;	 Catch:{ all -> 0x000b }
        r0.mState = r1;	 Catch:{ all -> 0x000b }
        monitor-exit(r2);
        return;
    L_0x000b:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    }

    public synchronized boolean canThreadDecoding(java.lang.Thread r6) {
        r5 = this;
        r4 = 1;
        monitor-enter(r5);
        r2 = r5.mThreadStatus;	 Catch:{ all -> 0x001b }
        r1 = r2.get(r6);	 Catch:{ all -> 0x001b }
        r1 = (com.techno.gallery.BitmapManager.ThreadStatus) r1;	 Catch:{ all -> 0x001b }
        if (r1 != 0) goto L_0x000f;
    L_0x000c:
        r2 = r4;
    L_0x000d:
        monitor-exit(r5);
        return r2;
    L_0x000f:
        r2 = r1.mState;
        r3 = com.techno.gallery.BitmapManager.State.CANCEL;
        if (r2 == r3) goto L_0x0018;
    L_0x0015:
        r0 = r4;
    L_0x0016:
        r2 = r0;
        goto L_0x000d;
    L_0x0018:
        r2 = 0;
        r0 = r2;
        goto L_0x0016;
    L_0x001b:
        r2 = move-exception;
        monitor-exit(r5);
        throw r2;
    }

    public synchronized void cancelThreadDecoding(com.techno.gallery.BitmapManager.ThreadSet r4) {
        r3 = this;
        monitor-enter(r3);
        r0 = r4.iterator();	 Catch:{ all -> 0x0015 }
    L_0x0005:
        r2 = r0.hasNext();	 Catch:{ all -> 0x0015 }
        if (r2 == 0) goto L_0x0018;
    L_0x000b:
        r1 = r0.next();	 Catch:{ all -> 0x0015 }
        r1 = (java.lang.Thread) r1;	 Catch:{ all -> 0x0015 }
        r3.cancelThreadDecoding(r1);	 Catch:{ all -> 0x0015 }
        goto L_0x0005;
    L_0x0015:
        r2 = move-exception;
        monitor-exit(r3);
        throw r2;
    L_0x0018:
        monitor-exit(r3);
        return;
    }

    public synchronized void cancelThreadDecoding(java.lang.Thread r3) {
        r2 = this;
        monitor-enter(r2);
        r0 = r2.getOrCreateThreadStatus(r3);	 Catch:{ all -> 0x0017 }
        r1 = com.techno.gallery.BitmapManager.State.CANCEL;	 Catch:{ all -> 0x0017 }
        r0.mState = r1;	 Catch:{ all -> 0x0017 }
        r1 = r0.mOptions;	 Catch:{ all -> 0x0017 }
        if (r1 == 0) goto L_0x0012;
    L_0x000d:
        r1 = r0.mOptions;	 Catch:{ all -> 0x0017 }
        r1.requestCancelDecode();	 Catch:{ all -> 0x0017 }
    L_0x0012:
        r2.notifyAll();	 Catch:{ all -> 0x0017 }
        monitor-exit(r2);
        return;
    L_0x0017:
        r1 = move-exception;
        monitor-exit(r2);
        throw r1;
    }

    public android.graphics.Bitmap decodeFileDescriptor(java.io.FileDescriptor r7, android.graphics.BitmapFactory.Options r8) {
        r6 = this;
        r5 = 0;
        r2 = r8.mCancel;
        if (r2 == 0) goto L_0x0007;
    L_0x0005:
        r2 = r5;
    L_0x0006:
        return r2;
    L_0x0007:
        r1 = java.lang.Thread.currentThread();
        r2 = r6.canThreadDecoding(r1);
        if (r2 != 0) goto L_0x0031;
    L_0x0011:
        r2 = "BitmapManager";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Thread ";
        r3 = r3.append(r4);
        r3 = r3.append(r1);
        r4 = " is not allowed to decode.";
        r3 = r3.append(r4);
        r3 = r3.toString();
        android.util.Log.d(r2, r3);
        r2 = r5;
        goto L_0x0006;
    L_0x0031:
        r6.setDecodingOptions(r1, r8);
        r0 = android.graphics.BitmapFactory.decodeFileDescriptor(r7, r5, r8);
        r6.removeDecodingOptions(r1);
        r2 = r0;
        goto L_0x0006;
    }

    synchronized void removeDecodingOptions(java.lang.Thread r3) {
        r2 = this;
        monitor-enter(r2);
        r1 = r2.mThreadStatus;	 Catch:{ all -> 0x000e }
        r0 = r1.get(r3);	 Catch:{ all -> 0x000e }
        r0 = (com.techno.gallery.BitmapManager.ThreadStatus) r0;	 Catch:{ all -> 0x000e }
        r1 = 0;
        r0.mOptions = r1;	 Catch:{ all -> 0x000e }
        monitor-exit(r2);
        return;
    L_0x000e:
        r1 = move-exception;
        monitor-exit(r2);
        throw r1;
    }
}