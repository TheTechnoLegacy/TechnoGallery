package com.techno.gallery.gallery;

public class LruCache<K, V> {
    private final java.util.HashMap<K, V> mLruMap;
    private java.lang.ref.ReferenceQueue<V> mQueue;
    private final java.util.HashMap<K, com.techno.gallery.gallery.LruCache.Entry<K, V>> mWeakMap;

    public LruCache(int r7) {
        r6 = this;
        r6.<init>();
        r0 = new java.util.HashMap;
        r0.<init>();
        r6.mWeakMap = r0;
        r0 = new java.lang.ref.ReferenceQueue;
        r0.<init>();
        r6.mQueue = r0;
        r0 = new com.techno.gallery.gallery.LruCache$1;
        r2 = 16;
        r3 = 1061158912; // 0x3f400000 float:0.75 double:5.24282163E-315;
        r4 = 1;
        r1 = r6;
        r5 = r7;
        r0.<init>(r1, r2, r3, r4, r5);
        r6.mLruMap = r0;
        return;
    }

    private void cleanUpWeakMap() {
        r3 = this;
        r1 = r3.mQueue;
        r0 = r1.poll();
        r0 = (com.techno.gallery.gallery.LruCache.Entry) r0;
    L_0x0008:
        if (r0 == 0) goto L_0x001a;
    L_0x000a:
        r1 = r3.mWeakMap;
        r2 = r0.mKey;
        r1.remove(r2);
        r1 = r3.mQueue;
        r0 = r1.poll();
        r0 = (com.techno.gallery.gallery.LruCache.Entry) r0;
        goto L_0x0008;
    L_0x001a:
        return;
    }

    public synchronized void clear() {
        r1 = this;
        monitor-enter(r1);
        r0 = r1.mLruMap;	 Catch:{ all -> 0x0014 }
        r0.clear();	 Catch:{ all -> 0x0014 }
        r0 = r1.mWeakMap;	 Catch:{ all -> 0x0014 }
        r0.clear();	 Catch:{ all -> 0x0014 }
        r0 = new java.lang.ref.ReferenceQueue;	 Catch:{ all -> 0x0014 }
        r0.<init>();	 Catch:{ all -> 0x0014 }
        r1.mQueue = r0;	 Catch:{ all -> 0x0014 }
        monitor-exit(r1);
        return;
    L_0x0014:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    }

    public synchronized V get(K r4) {
        r3 = this;
        monitor-enter(r3);
        r3.cleanUpWeakMap();	 Catch:{ all -> 0x0020 }
        r2 = r3.mLruMap;	 Catch:{ all -> 0x0020 }
        r1 = r2.get(r4);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x000f;
    L_0x000c:
        r2 = r1;
    L_0x000d:
        monitor-exit(r3);
        return r2;
    L_0x000f:
        r2 = r3.mWeakMap;
        r0 = r2.get(r4);
        r0 = (com.techno.gallery.gallery.LruCache.Entry) r0;
        if (r0 != 0) goto L_0x001b;
    L_0x0019:
        r2 = 0;
        goto L_0x000d;
    L_0x001b:
        r2 = r0.get();
        goto L_0x000d;
    L_0x0020:
        r2 = move-exception;
        monitor-exit(r3);
        throw r2;
    }

    public synchronized V put(K r5, V r6) {
        r4 = this;
        monitor-enter(r4);
        r4.cleanUpWeakMap();	 Catch:{ all -> 0x0022 }
        r1 = r4.mLruMap;	 Catch:{ all -> 0x0022 }
        r1.put(r5, r6);	 Catch:{ all -> 0x0022 }
        r1 = r4.mWeakMap;	 Catch:{ all -> 0x0022 }
        r2 = new com.techno.gallery.gallery.LruCache$Entry;	 Catch:{ all -> 0x0022 }
        r3 = r4.mQueue;	 Catch:{ all -> 0x0022 }
        r2.<init>(r5, r6, r3);	 Catch:{ all -> 0x0022 }
        r0 = r1.put(r5, r2);	 Catch:{ all -> 0x0022 }
        r0 = (com.techno.gallery.gallery.LruCache.Entry) r0;	 Catch:{ all -> 0x0022 }
        if (r0 != 0) goto L_0x001d;
    L_0x001a:
        r1 = 0;
    L_0x001b:
        monitor-exit(r4);
        return r1;
    L_0x001d:
        r1 = r0.get();
        goto L_0x001b;
    L_0x0022:
        r1 = move-exception;
        monitor-exit(r4);
        throw r1;
    }
}