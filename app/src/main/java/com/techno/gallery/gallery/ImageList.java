package com.techno.gallery.gallery;

public class ImageList extends com.techno.gallery.gallery.BaseImageList implements com.techno.gallery.gallery.IImageList {
    private static final java.lang.String[] ACCEPTABLE_IMAGE_TYPES = null;
    public static final android.os.Parcelable.Creator<com.techno.gallery.gallery.ImageList> CREATOR = null;
    static final java.lang.String[] IMAGE_PROJECTION = null;
    private static final int INDEX_DATA_PATH = 1;
    private static final int INDEX_DATE_TAKEN = 2;
    private static final int INDEX_ID = 0;
    private static final int INDEX_MIME_TYPE = 6;
    private static final int INDEX_MINI_THUMB_MAGIC = 3;
    private static final int INDEX_ORIENTATION = 4;
    private static final int INDEX_TITLE = 5;
    private static final java.lang.String TAG = "ImageList";
    private static final java.lang.String WHERE_CLAUSE = "(mime_type in (?, ?, ?))";
    private static final java.lang.String WHERE_CLAUSE_WITH_BUCKET_ID = "(mime_type in (?, ?, ?)) AND bucket_id = ?";

    static {
        r5 = 3;
        r4 = 2;
        r3 = 1;
        r2 = 0;
        r0 = new java.lang.String[r5];
        r1 = "image/jpeg";
        r0[r2] = r1;
        r1 = "image/png";
        r0[r3] = r1;
        r1 = "image/gif";
        r0[r4] = r1;
        ACCEPTABLE_IMAGE_TYPES = r0;
        r0 = new com.techno.gallery.gallery.ImageList$1;
        r0.<init>();
        CREATOR = r0;
        r0 = 7;
        r0 = new java.lang.String[r0];
        r1 = "_id";
        r0[r2] = r1;
        r1 = "_data";
        r0[r3] = r1;
        r1 = "datetaken";
        r0[r4] = r1;
        r1 = "mini_thumb_magic";
        r0[r5] = r1;
        r1 = 4;
        r2 = "orientation";
        r0[r1] = r2;
        r1 = 5;
        r2 = "title";
        r0[r1] = r2;
        r1 = 6;
        r2 = "mime_type";
        r0[r1] = r2;
        IMAGE_PROJECTION = r0;
        return;
    }

    public ImageList(android.net.Uri r1, android.net.Uri r2, int r3, java.lang.String r4) {
        r0 = this;
        r0.<init>(r1, r3, r4);
        r0.mThumbUri = r2;
        return;
    }

    protected ImageList(android.os.Parcel r2) {
        r1 = this;
        r1.<init>(r2);
        r0 = 0;
        r0 = r2.readParcelable(r0);
        r0 = (android.net.Uri) r0;
        r1.mThumbUri = r0;
        return;
    }

    protected android.database.Cursor createCursor() {
        r7 = this;
        r0 = r7.mContentResolver;
        r1 = r7.mBaseUri;
        r2 = IMAGE_PROJECTION;
        r3 = r7.whereClause();
        r4 = r7.whereClauseArgs();
        r5 = r7.sortOrder();
        r6 = android.provider.MediaStore.Images.Media.query(r0, r1, r2, r3, r4, r5);
        return r6;
    }

    public java.util.HashMap<java.lang.String, java.lang.String> getBucketIds() {
        r8 = this;
        r5 = 1;
        r4 = 0;
        r0 = r8.mBaseUri;
        r0 = r0.buildUpon();
        r2 = "distinct";
        r3 = "true";
        r0 = r0.appendQueryParameter(r2, r3);
        r1 = r0.build();
        r0 = r8.mContentResolver;
        r2 = 2;
        r2 = new java.lang.String[r2];
        r3 = "bucket_display_name";
        r2[r4] = r3;
        r3 = "bucket_id";
        r2[r5] = r3;
        r3 = r8.whereClause();
        r4 = r8.whereClauseArgs();
        r5 = 0;
        r6 = android.provider.MediaStore.Images.Media.query(r0, r1, r2, r3, r4, r5);
        r7 = new java.util.HashMap;	 Catch:{ all -> 0x0047 }
        r7.<init>();	 Catch:{ all -> 0x0047 }
    L_0x0033:
        r0 = r6.moveToNext();	 Catch:{ all -> 0x0047 }
        if (r0 == 0) goto L_0x004c;
    L_0x0039:
        r0 = 1;
        r0 = r6.getString(r0);	 Catch:{ all -> 0x0047 }
        r2 = 0;
        r2 = r6.getString(r2);	 Catch:{ all -> 0x0047 }
        r7.put(r0, r2);	 Catch:{ all -> 0x0047 }
        goto L_0x0033;
    L_0x0047:
        r0 = move-exception;
        r6.close();
        throw r0;
    L_0x004c:
        r6.close();
        return r7;
    }

    protected long getImageId(android.database.Cursor r3) {
        r2 = this;
        r0 = 0;
        r0 = r3.getLong(r0);
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
        r14 = r0.getLong(r1);
        r3 = 3;
        r0 = r20;
        r1 = r3;
        r11 = r0.getLong(r1);
        r3 = 4;
        r0 = r20;
        r1 = r3;
        r18 = r0.getInt(r1);
        r3 = 5;
        r0 = r20;
        r1 = r3;
        r16 = r0.getString(r1);
        r3 = 6;
        r0 = r20;
        r1 = r3;
        r13 = r0.getString(r1);
        if (r16 == 0) goto L_0x0040;
    L_0x003a:
        r3 = r16.length();
        if (r3 != 0) goto L_0x0042;
    L_0x0040:
        r16 = r10;
    L_0x0042:
        r17 = r16;
        r3 = new com.techno.gallery.gallery.Image;
        r0 = r19;
        r0 = r0.mContentResolver;
        r5 = r0;
        r8 = r20.getPosition();
        r0 = r19;
        r1 = r6;
        r9 = r0.contentUri(r1);
        r4 = r19;
        r3.<init>(r4, r5, r6, r8, r9, r10, r11, r13, r14, r16, r17, r18);
        return r3;
    }

    protected java.lang.String sortOrder() {
        r3 = this;
        r1 = r3.mSort;
        r2 = 1;
        if (r1 != r2) goto L_0x002c;
    L_0x0005:
        r1 = " ASC";
        r0 = r1;
    L_0x0008:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "datetaken";
        r1 = r1.append(r2);
        r1 = r1.append(r0);
        r2 = ",";
        r1 = r1.append(r2);
        r2 = "_id";
        r1 = r1.append(r2);
        r1 = r1.append(r0);
        r1 = r1.toString();
        return r1;
    L_0x002c:
        r1 = " DESC";
        r0 = r1;
        goto L_0x0008;
    }

    protected java.lang.String whereClause() {
        r1 = this;
        r0 = r1.mBucketId;
        if (r0 != 0) goto L_0x0007;
    L_0x0004:
        r0 = "(mime_type in (?, ?, ?))";
    L_0x0006:
        return r0;
    L_0x0007:
        r0 = "(mime_type in (?, ?, ?)) AND bucket_id = ?";
        goto L_0x0006;
    }

    protected java.lang.String[] whereClauseArgs() {
        r4 = this;
        r3 = 0;
        r2 = r4.mBucketId;
        if (r2 == 0) goto L_0x0017;
    L_0x0005:
        r2 = ACCEPTABLE_IMAGE_TYPES;
        r0 = r2.length;
        r2 = r0 + 1;
        r1 = new java.lang.String[r2];
        r2 = ACCEPTABLE_IMAGE_TYPES;
        java.lang.System.arraycopy(r2, r3, r1, r3, r0);
        r2 = r4.mBucketId;
        r1[r0] = r2;
        r2 = r1;
    L_0x0016:
        return r2;
    L_0x0017:
        r2 = ACCEPTABLE_IMAGE_TYPES;
        goto L_0x0016;
    }

    public void writeToParcel(android.os.Parcel r2, int r3) {
        r1 = this;
        super.writeToParcel(r2, r3);
        r0 = r1.mThumbUri;
        r2.writeParcelable(r0, r3);
        return;
    }
}