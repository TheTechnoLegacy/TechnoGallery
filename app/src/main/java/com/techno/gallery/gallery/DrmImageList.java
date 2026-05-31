package com.techno.gallery.gallery;

public class DrmImageList extends com.techno.gallery.gallery.ImageList implements com.techno.gallery.gallery.IImageList {
    public static final android.os.Parcelable.Creator<com.techno.gallery.gallery.DrmImageList> CREATOR = null;
    private static final java.lang.String[] DRM_IMAGE_PROJECTION = null;
    private static final int INDEX_DATA_PATH = 1;
    private static final int INDEX_ID = 0;
    private static final int INDEX_MIME_TYPE = 2;

    static {
        r0 = 3;
        r0 = new java.lang.String[r0];
        r1 = 0;
        r2 = "_id";
        r0[r1] = r2;
        r1 = 1;
        r2 = "_data";
        r0[r1] = r2;
        r1 = 2;
        r2 = "mime_type";
        r0[r1] = r2;
        DRM_IMAGE_PROJECTION = r0;
        r0 = new com.techno.gallery.gallery.DrmImageList$1;
        r0.<init>();
        CREATOR = r0;
        return;
    }

    public DrmImageList(android.net.Uri r2, int r3, java.lang.String r4) {
        r1 = this;
        r0 = 0;
        r1.<init>(r2, r0, r3, r4);
        return;
    }

    protected DrmImageList(android.os.Parcel r1) {
        r0 = this;
        r0.<init>(r1);
        return;
    }

    public void checkThumbnail(int r1) {
        r0 = this;
        return;
    }

    protected android.database.Cursor createCursor() {
        r6 = this;
        r3 = 0;
        r0 = r6.mContentResolver;
        r1 = r6.mBaseUri;
        r2 = DRM_IMAGE_PROJECTION;
        r5 = r6.sortOrder();
        r4 = r3;
        r0 = r0.query(r1, r2, r3, r4, r5);
        return r0;
    }

    protected com.techno.gallery.gallery.BaseImage loadImageFromCursor(android.database.Cursor r20) {
        r19 = this;
        r3 = 0;
        r0 = r20;
        r1 = r3;
        r6 = r0.getLong(r1);
        r3 = 1;
        r0 = r20;
        r1 = r3;
        r10 = r0.getString(r1);
        r3 = 2;
        r0 = r20;
        r1 = r3;
        r13 = r0.getString(r1);
        r3 = new com.techno.gallery.gallery.DrmImageList$DrmImage;
        r0 = r19;
        r0 = r0.mContentResolver;
        r5 = r0;
        r8 = r20.getPosition();
        r0 = r19;
        r1 = r6;
        r9 = r0.contentUri(r1);
        r11 = 0;
        r14 = 0;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r16 = "DrmImage-";
        r0 = r4;
        r1 = r16;
        r4 = r0.append(r1);
        r4 = r4.append(r6);
        r16 = r4.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r17 = "DrmImage-";
        r0 = r4;
        r1 = r17;
        r4 = r0.append(r1);
        r4 = r4.append(r6);
        r17 = r4.toString();
        r18 = 0;
        r4 = r19;
        r3.<init>(r4, r5, r6, r8, r9, r10, r11, r13, r14, r16, r17, r18);
        return r3;
    }

    protected java.lang.String sortOrder() {
        r3 = this;
        r1 = r3.mSort;
        r2 = 1;
        if (r1 != r2) goto L_0x0028;
    L_0x0005:
        r1 = " ASC";
        r0 = r1;
    L_0x0008:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "title";
        r1 = r1.append(r2);
        r1 = r1.append(r0);
        r2 = ",";
        r1 = r1.append(r2);
        r2 = "_id";
        r1 = r1.append(r2);
        r1 = r1.toString();
        return r1;
    L_0x0028:
        r1 = " DESC";
        r0 = r1;
        goto L_0x0008;
    }
}