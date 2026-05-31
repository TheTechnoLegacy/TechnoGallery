package com.techno.gallery.gallery;

public class SingleImageList extends com.techno.gallery.gallery.BaseImageList {
    private static final java.lang.String TAG = "BaseImageList";
    private com.techno.gallery.gallery.IImage mSingleImage;

    public SingleImageList(android.net.Uri r3) {
        r2 = this;
        r0 = 1;
        r1 = 0;
        r2.<init>(r3, r0, r1);
        return;
    }

    protected android.database.Cursor createCursor() {
        r1 = this;
        r0 = new java.lang.UnsupportedOperationException;
        r0.<init>();
        throw r0;
    }

    public void deactivate() {
        r0 = this;
        return;
    }

    public java.util.HashMap<java.lang.String, java.lang.String> getBucketIds() {
        r1 = this;
        r0 = new java.lang.UnsupportedOperationException;
        r0.<init>();
        throw r0;
    }

    public int getCount() {
        r1 = this;
        r0 = 1;
        return r0;
    }

    public com.techno.gallery.gallery.IImage getImageAt(int r2) {
        r1 = this;
        if (r2 != 0) goto L_0x0005;
    L_0x0002:
        r0 = r1.mSingleImage;
    L_0x0004:
        return r0;
    L_0x0005:
        r0 = 0;
        goto L_0x0004;
    }

    public com.techno.gallery.gallery.IImage getImageForUri(android.net.Uri r2) {
        r1 = this;
        r0 = r1.mBaseUri;
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x000b;
    L_0x0008:
        r0 = r1.mSingleImage;
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = 0;
        goto L_0x000a;
    }

    protected long getImageId(android.database.Cursor r2) {
        r1 = this;
        r0 = new java.lang.UnsupportedOperationException;
        r0.<init>();
        throw r0;
    }

    public int getImageIndex(com.techno.gallery.gallery.IImage r2) {
        r1 = this;
        r0 = r1.mSingleImage;
        if (r2 != r0) goto L_0x0006;
    L_0x0004:
        r0 = 0;
    L_0x0005:
        return r0;
    L_0x0006:
        r0 = -1;
        goto L_0x0005;
    }

    public boolean isEmpty() {
        r1 = this;
        r0 = 0;
        return r0;
    }

    protected com.techno.gallery.gallery.BaseImage loadImageFromCursor(android.database.Cursor r2) {
        r1 = this;
        r0 = new java.lang.UnsupportedOperationException;
        r0.<init>();
        throw r0;
    }

    public void open(android.content.ContentResolver r3) {
        r2 = this;
        r2.mContentResolver = r3;
        r0 = new com.techno.gallery.gallery.UriImage;
        r1 = r2.mBaseUri;
        r0.<init>(r2, r3, r1);
        r2.mSingleImage = r0;
        return;
    }

    public boolean removeImage(com.techno.gallery.gallery.IImage r2) {
        r1 = this;
        r0 = 0;
        return r0;
    }
}