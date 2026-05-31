package com.techno.gallery.gallery;

public interface IImage {
    public static final int MINI_THUMB_MAX_NUM_PIXELS = 16384;
    public static final int MINI_THUMB_TARGET_SIZE = 96;
    public static final boolean NO_NATIVE = false;
    public static final boolean NO_ROTATE = false;
    public static final boolean ROTATE_AS_NEEDED = true;
    public static final int THUMBNAIL_MAX_NUM_PIXELS = 196608;
    public static final int THUMBNAIL_TARGET_SIZE = 320;
    public static final int UNCONSTRAINED = -1;
    public static final boolean USE_NATIVE = true;

    android.graphics.Bitmap fullSizeBitmap(int r1, int r2);

    android.graphics.Bitmap fullSizeBitmap(int r1, int r2, boolean r3);

    android.graphics.Bitmap fullSizeBitmap(int r1, int r2, boolean r3, boolean r4);

    java.io.InputStream fullSizeImageData();

    long fullSizeImageId();

    android.net.Uri fullSizeImageUri();

    com.techno.gallery.gallery.IImageList getContainer();

    java.lang.String getDataPath();

    long getDateTaken();

    int getDegreesRotated();

    java.lang.String getDisplayName();

    int getHeight();

    java.lang.String getMimeType();

    java.lang.String getTitle();

    int getWidth();

    boolean isDrm();

    boolean isReadonly();

    android.graphics.Bitmap miniThumbBitmap();

    boolean rotateImageBy(int r1);

    void setTitle(java.lang.String r1);

    android.graphics.Bitmap thumbBitmap(boolean r1);

    android.net.Uri thumbUri();
}