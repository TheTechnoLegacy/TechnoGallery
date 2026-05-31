package com.techno.gallery.gallery;

class LruCache$Entry<K, V> extends java.lang.ref.WeakReference<V> {
    K mKey;

    public LruCache$Entry(K r1, V r2, java.lang.ref.ReferenceQueue r3) {
        r0 = this;
        r0.<init>(r2, r3);
        r0.mKey = r1;
        return;
    }
}