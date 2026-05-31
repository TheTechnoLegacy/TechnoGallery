package com.techno.gallery.gallery;

class LruCache$1 extends java.util.LinkedHashMap<K, V> {
    final /* synthetic */ com.techno.gallery.gallery.LruCache this$0;
    final /* synthetic */ int val$capacity;

    LruCache$1(com.techno.gallery.gallery.LruCache r1, int r2, float r3, boolean r4, int r5) {
        r0 = this;
        r0.this$0 = r1;
        r0.val$capacity = r5;
        r0.<init>(r2, r3, r4);
        return;
    }

    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> r3) {
        r2 = this;
        r0 = r2.size();
        r1 = r2.val$capacity;
        if (r0 <= r1) goto L_0x000a;
    L_0x0008:
        r0 = 1;
    L_0x0009:
        return r0;
    L_0x000a:
        r0 = 0;
        goto L_0x0009;
    }
}