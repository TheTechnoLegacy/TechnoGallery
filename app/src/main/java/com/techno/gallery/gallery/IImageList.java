package com.techno.gallery.gallery;

public interface IImageList extends android.os.Parcelable {
    void checkThumbnail(int r1) throws java.io.IOException;

    void close();

    void deactivate();

    java.util.HashMap<java.lang.String, java.lang.String> getBucketIds();

    int getCount();

    com.techno.gallery.gallery.IImage getImageAt(int r1);

    com.techno.gallery.gallery.IImage getImageForUri(android.net.Uri r1);

    int getImageIndex(com.techno.gallery.gallery.IImage r1);

    boolean isEmpty();

    void open(android.content.ContentResolver r1);

    boolean removeImage(com.techno.gallery.gallery.IImage r1);

    boolean removeImageAt(int r1);
}