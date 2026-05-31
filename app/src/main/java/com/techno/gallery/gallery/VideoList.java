package com.techno.gallery.gallery;

public class VideoList extends com.techno.gallery.gallery.BaseImageList {
    public static final android.os.Parcelable.Creator<com.techno.gallery.gallery.VideoList> CREATOR = null;
    private static final int INDEX_DATA_PATH = 1;
    private static final int INDEX_DATE_TAKEN = 2;
    private static final int INDEX_DISPLAY_NAME = 4;
    private static final int INDEX_ID = 0;
    private static final int INDEX_MIME_TYPE = 6;
    private static final int INDEX_MIMI_THUMB_MAGIC = 5;
    private static final int INDEX_TITLE = 3;
    private static final java.lang.String TAG = "BaseImageList";
    private static final java.lang.String[] VIDEO_PROJECTION = null;

    static {
        r0 = 7;
        r0 = new java.lang.String[r0];
        r1 = 0;
        r2 = "_id";
        r0[r1] = r2;
        r1 = 1;
        r2 = "_data";
        r0[r1] = r2;
        r1 = 2;
        r2 = "datetaken";
        r0[r1] = r2;
        r1 = 3;
        r2 = "title";
        r0[r1] = r2;
        r1 = 4;
        r2 = "_display_name";
        r0[r1] = r2;
        r1 = 5;
        r2 = "mini_thumb_magic";
        r0[r1] = r2;
        r1 = 6;
        r2 = "mime_type";
        r0[r1] = r2;
        VIDEO_PROJECTION = r0;
        r0 = new com.techno.gallery.gallery.VideoList$1;
        r0.<init>();
        CREATOR = r0;
        return;
    }

    public VideoList(android.net.Uri r1, int r2, java.lang.String r3) {
        r0 = this;
        r0.<init>(r1, r2, r3);
        return;
    }

    protected VideoList(android.os.Parcel r1) {
        r0 = this;
        r0.<init>(r1);
        return;
    }

    private java.lang.String sortOrder() {
        r3 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "datetaken";
        r0 = r0.append(r1);
        r1 = r3.mSort;
        r2 = 1;
        if (r1 != r2) goto L_0x001b;
    L_0x0010:
        r1 = " ASC ";
    L_0x0012:
        r0 = r0.append(r1);
        r0 = r0.toString();
        return r0;
    L_0x001b:
        r1 = " DESC";
        goto L_0x0012;
    }

    protected android.database.Cursor createCursor() {
        r7 = this;
        r0 = r7.mContentResolver;
        r1 = r7.mBaseUri;
        r2 = VIDEO_PROJECTION;
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
        r5 = r8.sortOrder();
        r6 = android.provider.MediaStore.Images.Media.query(r0, r1, r2, r3, r4, r5);
        r7 = new java.util.HashMap;	 Catch:{ all -> 0x004a }
        r7.<init>();	 Catch:{ all -> 0x004a }
    L_0x0036:
        r0 = r6.moveToNext();	 Catch:{ all -> 0x004a }
        if (r0 == 0) goto L_0x004f;
    L_0x003c:
        r0 = 1;
        r0 = r6.getString(r0);	 Catch:{ all -> 0x004a }
        r2 = 0;
        r2 = r6.getString(r2);	 Catch:{ all -> 0x004a }
        r7.put(r0, r2);	 Catch:{ all -> 0x004a }
        goto L_0x0036;
    L_0x004a:
        r0 = move-exception;
        r6.close();
        throw r0;
    L_0x004f:
        r6.close();
        return r7;
    }

    protected long getImageId(android.database.Cursor r3) {
        r2 = this;
        r0 = 0;
        r0 = r3.getLong(r0);
        return r0;
    }

    protected com.techno.gallery.gallery.BaseImage loadImageFromCursor(android.database.Cursor r19) {
        r18 = this;
        r3 = 0;
        r0 = r19;
        r1 = r3;
        r6 = r0.getLong(r1);
        r3 = 1;
        r0 = r19;
        r1 = r3;
        r10 = r0.getString(r1);
        r3 = 2;
        r0 = r19;
        r1 = r3;
        r14 = r0.getLong(r1);
        r3 = 3;
        r0 = r19;
        r1 = r3;
        r16 = r0.getString(r1);
        r3 = 4;
        r0 = r19;
        r1 = r3;
        r17 = r0.getString(r1);
        r3 = 5;
        r0 = r19;
        r1 = r3;
        r11 = r0.getLong(r1);
        r3 = 6;
        r0 = r19;
        r1 = r3;
        r13 = r0.getString(r1);
        r3 = new com.techno.gallery.gallery.VideoObject;
        r0 = r18;
        r0 = r0.mContentResolver;
        r5 = r0;
        r8 = r19.getPosition();
        r0 = r18;
        r1 = r6;
        r9 = r0.contentUri(r1);
        r4 = r18;
        r3.<init>(r4, r5, r6, r8, r9, r10, r11, r13, r14, r16, r17);
        return r3;
    }

    protected java.lang.String whereClause() {
        r2 = this;
        r0 = r2.mBucketId;
        if (r0 == 0) goto L_0x0020;
    L_0x0004:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "bucket_id = '";
        r0 = r0.append(r1);
        r1 = r2.mBucketId;
        r0 = r0.append(r1);
        r1 = "'";
        r0 = r0.append(r1);
        r0 = r0.toString();
    L_0x001f:
        return r0;
    L_0x0020:
        r0 = 0;
        goto L_0x001f;
    }

    protected java.lang.String[] whereClauseArgs() {
        r1 = this;
        r0 = 0;
        return r0;
    }
}