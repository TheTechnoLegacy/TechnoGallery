package com.techno.gallery;

/* compiled from: GalleryPicker */
class Item {
    public static final int TYPE_ALL_IMAGES = 0;
    public static final int TYPE_ALL_VIDEOS = 1;
    public static final int TYPE_CAMERA_IMAGES = 2;
    public static final int TYPE_CAMERA_MEDIAS = 4;
    public static final int TYPE_CAMERA_VIDEOS = 3;
    public static final int TYPE_NONE = -1;
    public static final int TYPE_NORMAL_FOLDERS = 5;
    public final java.lang.String mBucketId;
    public final int mCount;
    public final android.net.Uri mFirstImageUri;
    public final com.techno.gallery.gallery.IImageList mImageList;
    public final java.lang.String mName;
    public android.graphics.Bitmap mThumbBitmap;
    public final int mType;

    public Item(int r2, java.lang.String r3, java.lang.String r4, com.techno.gallery.gallery.IImageList r5) {
        r1 = this;
        r1.<init>();
        r1.mType = r2;
        r1.mBucketId = r3;
        r1.mName = r4;
        r1.mImageList = r5;
        r0 = r5.getCount();
        r1.mCount = r0;
        r0 = r1.mCount;
        if (r0 <= 0) goto L_0x0021;
    L_0x0015:
        r0 = 0;
        r0 = r5.getImageAt(r0);
        r0 = r0.fullSizeImageUri();
        r1.mFirstImageUri = r0;
    L_0x0020:
        return;
    L_0x0021:
        r0 = 0;
        r1.mFirstImageUri = r0;
        goto L_0x0020;
    }

    public static int convertItemTypeToIncludedMediaType(int r1) {
        switch(r1) {
            case 0: goto L_0x0005;
            case 1: goto L_0x0007;
            case 2: goto L_0x0005;
            case 3: goto L_0x0007;
            default: goto L_0x0003;
        };
    L_0x0003:
        r0 = 5;
    L_0x0004:
        return r0;
    L_0x0005:
        r0 = 1;
        goto L_0x0004;
    L_0x0007:
        r0 = 4;
        goto L_0x0004;
    }

    public int getIncludeMediaTypes() {
        r1 = this;
        r0 = r1.mType;
        r0 = convertItemTypeToIncludedMediaType(r0);
        return r0;
    }

    public int getOverlay() {
        r1 = this;
        r0 = r1.mType;
        switch(r0) {
            case 0: goto L_0x0009;
            case 1: goto L_0x000d;
            case 2: goto L_0x0009;
            case 3: goto L_0x000d;
            case 4: goto L_0x000d;
            default: goto L_0x0005;
        };
    L_0x0005:
        r0 = 2130837560; // 0x7f020038 float:1.7280078E38 double:1.0527736353E-314;
    L_0x0008:
        return r0;
    L_0x0009:
        r0 = 2130837559; // 0x7f020037 float:1.7280075E38 double:1.052773635E-314;
        goto L_0x0008;
    L_0x000d:
        r0 = 2130837561; // 0x7f020039 float:1.728008E38 double:1.052773636E-314;
        goto L_0x0008;
    }

    public void launch(android.app.Activity r6) {
        r5 = this;
        r1 = android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        r2 = r5.needsBucketId();
        if (r2 == 0) goto L_0x0018;
    L_0x0008:
        r2 = r1.buildUpon();
        r3 = "bucketId";
        r4 = r5.mBucketId;
        r2 = r2.appendQueryParameter(r3, r4);
        r1 = r2.build();
    L_0x0018:
        r0 = new android.content.Intent;
        r2 = "android.intent.action.VIEW";
        r0.<init>(r2, r1);
        r2 = "windowTitle";
        r3 = r5.mName;
        r0.putExtra(r2, r3);
        r2 = "mediaTypes";
        r3 = r5.getIncludeMediaTypes();
        r0.putExtra(r2, r3);
        r6.startActivity(r0);
        return;
    }

    public boolean needsBucketId() {
        r2 = this;
        r0 = r2.mType;
        r1 = 2;
        if (r0 < r1) goto L_0x0007;
    L_0x0005:
        r0 = 1;
    L_0x0006:
        return r0;
    L_0x0007:
        r0 = 0;
        goto L_0x0006;
    }

    public void setThumbBitmap(android.graphics.Bitmap r1) {
        r0 = this;
        r0.mThumbBitmap = r1;
        return;
    }
}