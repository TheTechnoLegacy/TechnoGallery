package com.techno.gallery;

public class BitmapManager$ThreadSet implements java.lang.Iterable<java.lang.Thread> {
    private final java.util.WeakHashMap<java.lang.Thread, java.lang.Object> mWeakCollection;

    public BitmapManager$ThreadSet() {
        r1 = this;
        r1.<init>();
        r0 = new java.util.WeakHashMap;
        r0.<init>();
        r1.mWeakCollection = r0;
        return;
    }

    public void add(java.lang.Thread r3) {
        r2 = this;
        r0 = r2.mWeakCollection;
        r1 = 0;
        r0.put(r3, r1);
        return;
    }

    public java.util.Iterator<java.lang.Thread> iterator() {
        r1 = this;
        r0 = r1.mWeakCollection;
        r0 = r0.keySet();
        r0 = r0.iterator();
        return r0;
    }

    public void remove(java.lang.Thread r2) {
        r1 = this;
        r0 = r1.mWeakCollection;
        r0.remove(r2);
        return;
    }
}