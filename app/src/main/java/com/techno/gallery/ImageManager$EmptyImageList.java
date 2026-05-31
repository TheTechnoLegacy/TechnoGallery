package com.techno.gallery;

class ImageManager$EmptyImageList implements com.techno.gallery.gallery.IImageList {
    public static final android.os.Parcelable.Creator<com.techno.gallery.ImageManager$EmptyImageList> CREATOR = null;

    static {
        r0 = new com.techno.gallery.ImageManager$EmptyImageList$1;
        r0.<init>();
        CREATOR = r0;
        return;
    }

    private ImageManager$EmptyImageList() {
        r0 = this;
        r0.<init>();
        return;
    }

    /* synthetic */ ImageManager$EmptyImageList(com.techno.gallery.ImageManager.1 r1) {
        r0 = this;
        r0.<init>();
        return;
    }

    public void checkThumbnail(int r1) {
        r0 = this;
        return;
    }

    public void close() {
        r0 = this;
        return;
    }

    public void deactivate() {
        r0 = this;
        return;
    }

    public int describeContents() {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public java.util.HashMap<java.lang.String, java.lang.String> getBucketIds() {
        r1 = this;
        r0 = new java.util.HashMap;
        r0.<init>();
        return r0;
    }

    public int getCount() {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public com.techno.gallery.gallery.IImage getImageAt(int r2) {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public com.techno.gallery.gallery.IImage getImageForUri(android.net.Uri r2) {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public int getImageIndex(com.techno.gallery.gallery.IImage r2) {
        r1 = this;
        r0 = new java.lang.UnsupportedOperationException;
        r0.<init>();
        throw r0;
    }

    public boolean isEmpty() {
        r1 = this;
        r0 = 1;
        return r0;
    }

    public void open(android.content.ContentResolver r1) {
        r0 = this;
        return;
    }

    public boolean removeImage(com.techno.gallery.gallery.IImage r2) {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public boolean removeImageAt(int r2) {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public void writeToParcel(android.os.Parcel r1, int r2) {
        r0 = this;
        return;
    }
}