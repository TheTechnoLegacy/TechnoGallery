package com.techno.gallery.gallery;

public abstract class BaseImageList implements com.techno.gallery.gallery.IImageList {
    private static final int CACHE_CAPACITY = 512;
    private static final java.lang.String TAG = "BaseImageList";
    private static final java.lang.String[] THUMB_PROJECTION = null;
    private static final java.util.regex.Pattern sPathWithId = null;
    private static final java.util.Random sRandom = null;
    protected android.net.Uri mBaseUri;
    protected java.lang.String mBucketId;
    private final com.techno.gallery.gallery.LruCache<java.lang.Integer, com.techno.gallery.gallery.BaseImage> mCache;
    protected android.content.ContentResolver mContentResolver;
    protected android.database.Cursor mCursor;
    protected boolean mCursorDeactivated;
    protected com.techno.gallery.gallery.MiniThumbFile mMiniThumbFile;
    protected int mSort;
    protected android.net.Uri mThumbUri;

    static {
        r0 = 1;
        r0 = new java.lang.String[r0];
        r1 = 0;
        r2 = "_id";
        r0[r1] = r2;
        THUMB_PROJECTION = r0;
        r0 = new java.util.Random;
        r1 = java.lang.System.currentTimeMillis();
        r0.<init>(r1);
        sRandom = r0;
        r0 = "(.*)/\\d+";
        r0 = java.util.regex.Pattern.compile(r0);
        sPathWithId = r0;
        return;
    }

    public BaseImageList(android.net.Uri r3, int r4, java.lang.String r5) {
        r2 = this;
        r2.<init>();
        r0 = new com.techno.gallery.gallery.LruCache;
        r1 = 512; // 0x200 float:7.17E-43 double:2.53E-321;
        r0.<init>(r1);
        r2.mCache = r0;
        r0 = 0;
        r2.mCursorDeactivated = r0;
        r2.mSort = r4;
        r2.mBaseUri = r3;
        r2.mBucketId = r5;
        r0 = new com.techno.gallery.gallery.MiniThumbFile;
        r0.<init>(r3);
        r2.mMiniThumbFile = r0;
        return;
    }

    protected BaseImageList(android.os.Parcel r3) {
        r2 = this;
        r2.<init>();
        r0 = new com.techno.gallery.gallery.LruCache;
        r1 = 512; // 0x200 float:7.17E-43 double:2.53E-321;
        r0.<init>(r1);
        r2.mCache = r0;
        r0 = 0;
        r2.mCursorDeactivated = r0;
        r0 = r3.readInt();
        r2.mSort = r0;
        r0 = 0;
        r0 = r3.readParcelable(r0);
        r0 = (android.net.Uri) r0;
        r2.mBaseUri = r0;
        r0 = r3.readString();
        r2.mBucketId = r0;
        r0 = new com.techno.gallery.gallery.MiniThumbFile;
        r1 = r2.mBaseUri;
        r0.<init>(r1);
        r2.mMiniThumbFile = r0;
        return;
    }

    private android.graphics.Bitmap createThumbnailFromEXIF(java.lang.String r9, long r10) {
        r8 = this;
        r3 = 320; // 0x140 float:4.48E-43 double:1.58E-321;
        r2 = 0;
        r7 = 0;
        if (r9 != 0) goto L_0x0008;
    L_0x0006:
        r0 = r2;
        goto L_0x0014;
    L_0x0008:
        r0 = new android.media.ExifInterface;
        r0.<init>(r9);
        r1 = r0.getThumbnail();
        if (r1 != 0) goto L_0x0015;
    L_0x0013:
        r0 = r2;
    L_0x0014:
        return r0;
    L_0x0015:
        r6 = new android.graphics.BitmapFactory$Options;
        r6.<init>();
        r0 = 1;
        r6.inJustDecodeBounds = r0;
        r0 = r1.length;
        android.graphics.BitmapFactory.decodeByteArray(r1, r7, r0, r6);
        r4 = r6.outWidth;
        r5 = r6.outHeight;
        if (r4 >= r3) goto L_0x0046;
    L_0x0027:
        if (r5 >= r3) goto L_0x0046;
    L_0x0029:
        r0 = r8;
        r2 = r10;
        r0.storeThumbnail(r1, r2, r4, r5);
        r0 = 96;
        r2 = 16384; // 0x4000 float:2.2959E-41 double:8.095E-320;
        r0 = com.techno.gallery.Util.computeSampleSize(r6, r0, r2);
        r6.inSampleSize = r0;
        r6.inDither = r7;
        r0 = android.graphics.Bitmap.Config.ARGB_8888;
        r6.inPreferredConfig = r0;
        r6.inJustDecodeBounds = r7;
        r0 = r1.length;
        r0 = android.graphics.BitmapFactory.decodeByteArray(r1, r7, r0, r6);
        goto L_0x0014;
    L_0x0046:
        r0 = r2;
        goto L_0x0014;
    }

    private android.graphics.Bitmap createThumbnailFromUri(android.net.Uri r5, long r6) {
        r4 = this;
        r1 = 320; // 0x140 float:4.48E-43 double:1.58E-321;
        r2 = 196608; // 0x30000 float:2.75506E-40 double:9.71373E-319;
        r3 = r4.mContentResolver;
        r0 = com.techno.gallery.Util.makeBitmap(r1, r2, r5, r3);
        if (r0 == 0) goto L_0x0010;
    L_0x000c:
        r4.storeThumbnail(r0, r6);
    L_0x000f:
        return r0;
    L_0x0010:
        r1 = 96;
        r2 = 16384; // 0x4000 float:2.2959E-41 double:8.095E-320;
        r3 = r4.mContentResolver;
        r0 = com.techno.gallery.Util.makeBitmap(r1, r2, r5, r3);
        goto L_0x000f;
    }

    private android.database.Cursor getCursor() {
        r2 = this;
        r0 = r2.mCursor;
        monitor-enter(r0);
        r1 = r2.mCursorDeactivated;	 Catch:{ all -> 0x0013 }
        if (r1 == 0) goto L_0x000f;
    L_0x0007:
        r1 = r2.mCursor;	 Catch:{ all -> 0x0013 }
        r1.requery();	 Catch:{ all -> 0x0013 }
        r1 = 0;
        r2.mCursorDeactivated = r1;	 Catch:{ all -> 0x0013 }
    L_0x000f:
        r1 = r2.mCursor;	 Catch:{ all -> 0x0013 }
        monitor-exit(r0);	 Catch:{ all -> 0x0013 }
        return r1;
    L_0x0013:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0013 }
        throw r1;
    }

    private static java.lang.String getPathWithoutId(android.net.Uri r3) {
        r1 = r3.getPath();
        r2 = sPathWithId;
        r0 = r2.matcher(r1);
        r2 = r0.matches();
        if (r2 == 0) goto L_0x0016;
    L_0x0010:
        r2 = 1;
        r2 = r0.group(r2);
    L_0x0015:
        return r2;
    L_0x0016:
        r2 = r1;
        goto L_0x0015;
    }

    private android.net.Uri getThumbnailUri(long r10, int r12, int r13) {
        r9 = this;
        r0 = r9.mThumbUri;
        if (r0 != 0) goto L_0x0006;
    L_0x0004:
        r0 = 0;
    L_0x0005:
        return r0;
    L_0x0006:
        r0 = r9.mContentResolver;
        r1 = r9.mThumbUri;
        r2 = THUMB_PROJECTION;
        r3 = "image_id=?";
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = java.lang.String.valueOf(r10);
        r4[r5] = r6;
        r5 = 0;
        r6 = r0.query(r1, r2, r3, r4, r5);
        r0 = r6.moveToNext();	 Catch:{ all -> 0x0069 }
        if (r0 == 0) goto L_0x0032;
    L_0x0023:
        r0 = r9.mThumbUri;	 Catch:{ all -> 0x0069 }
        r1 = 0;
        r1 = r6.getLong(r1);	 Catch:{ all -> 0x0069 }
        r0 = android.content.ContentUris.withAppendedId(r0, r1);	 Catch:{ all -> 0x0069 }
        r6.close();
        goto L_0x0005;
    L_0x0032:
        r6.close();
        r8 = new android.content.ContentValues;
        r0 = 4;
        r8.<init>(r0);
        r0 = "kind";
        r1 = 1;
        r1 = java.lang.Integer.valueOf(r1);
        r8.put(r0, r1);
        r0 = "image_id";
        r1 = java.lang.Long.valueOf(r10);
        r8.put(r0, r1);
        r0 = "height";
        r1 = java.lang.Integer.valueOf(r13);
        r8.put(r0, r1);
        r0 = "width";
        r1 = java.lang.Integer.valueOf(r12);
        r8.put(r0, r1);
        r0 = r9.mContentResolver;	 Catch:{ Exception -> 0x006e }
        r1 = r9.mThumbUri;	 Catch:{ Exception -> 0x006e }
        r0 = r0.insert(r1, r8);	 Catch:{ Exception -> 0x006e }
        goto L_0x0005;
    L_0x0069:
        r0 = move-exception;
        r6.close();
        throw r0;
    L_0x006e:
        r0 = move-exception;
        r7 = r0;
        r0 = 0;
        goto L_0x0005;
    }

    private boolean isChildImageUri(android.net.Uri r4) {
        r3 = this;
        r0 = r3.mBaseUri;
        r1 = r0.getScheme();
        r2 = r4.getScheme();
        r1 = com.techno.gallery.Util.equals(r1, r2);
        if (r1 == 0) goto L_0x003c;
    L_0x0010:
        r1 = r0.getHost();
        r2 = r4.getHost();
        r1 = com.techno.gallery.Util.equals(r1, r2);
        if (r1 == 0) goto L_0x003c;
    L_0x001e:
        r1 = r0.getAuthority();
        r2 = r4.getAuthority();
        r1 = com.techno.gallery.Util.equals(r1, r2);
        if (r1 == 0) goto L_0x003c;
    L_0x002c:
        r1 = r0.getPath();
        r2 = getPathWithoutId(r4);
        r1 = com.techno.gallery.Util.equals(r1, r2);
        if (r1 == 0) goto L_0x003c;
    L_0x003a:
        r1 = 1;
    L_0x003b:
        return r1;
    L_0x003c:
        r1 = 0;
        goto L_0x003b;
    }

    public void checkThumbnail(int r3) throws java.io.IOException {
        r2 = this;
        r0 = r2.getImageAt(r3);
        r0 = (com.techno.gallery.gallery.BaseImage) r0;
        r1 = 0;
        r1 = (byte[][]) r1;
        r2.checkThumbnail(r0, r1);
        return;
    }

    public void checkThumbnail(com.techno.gallery.gallery.BaseImage r21, byte[][] r22) throws java.io.IOException {
        r20 = this;
        r0 = r21;
        r0 = r0.mMiniThumbMagic;
        r9 = r0;
        r7 = r21.fullSizeImageId();
        r18 = 0;
        r5 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1));
        if (r5 == 0) goto L_0x001d;
    L_0x000f:
        r0 = r20;
        r0 = r0.mMiniThumbFile;
        r5 = r0;
        r13 = r5.getMagic(r7);
        r5 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1));
        if (r5 != 0) goto L_0x001d;
    L_0x001c:
        return;
    L_0x001d:
        r11 = 0;
        r15 = r21.getDataPath();
        if (r15 == 0) goto L_0x0038;
    L_0x0024:
        r16 = com.techno.gallery.ImageManager.isVideo(r21);
        if (r16 == 0) goto L_0x0080;
    L_0x002a:
        r11 = com.techno.gallery.Util.createVideoThumbnail(r15);
    L_0x002e:
        r12 = r21.getDegreesRotated();
        if (r12 == 0) goto L_0x0038;
    L_0x0034:
        r11 = com.techno.gallery.Util.rotate(r11, r12);
    L_0x0038:
        r5 = sRandom;
        r9 = r5.nextLong();
        r18 = 0;
        r5 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1));
        if (r5 == 0) goto L_0x0038;
    L_0x0044:
        if (r11 == 0) goto L_0x0054;
    L_0x0046:
        r6 = com.techno.gallery.Util.miniThumbData(r11);
        if (r22 == 0) goto L_0x004f;
    L_0x004c:
        r5 = 0;
        r22[r5] = r6;
    L_0x004f:
        r5 = r20;
        r5.saveMiniThumbToFile(r6, r7, r9);
    L_0x0054:
        r17 = new android.content.ContentValues;
        r17.<init>();
        r5 = "mini_thumb_magic";
        r6 = java.lang.Long.valueOf(r9);
        r0 = r17;
        r1 = r5;
        r2 = r6;
        r0.put(r1, r2);
        r0 = r20;
        r0 = r0.mContentResolver;
        r5 = r0;
        r6 = r21.fullSizeImageUri();
        r7 = 0;
        r8 = 0;
        r0 = r5;
        r1 = r6;
        r2 = r17;
        r3 = r7;
        r4 = r8;
        r0.update(r1, r2, r3, r4);
        r0 = r9;
        r2 = r21;
        r2.mMiniThumbMagic = r0;
        goto L_0x001c;
    L_0x0080:
        r0 = r20;
        r1 = r15;
        r2 = r7;
        r11 = r0.createThumbnailFromEXIF(r1, r2);
        if (r11 != 0) goto L_0x002e;
    L_0x008a:
        r0 = r20;
        r0 = r0.mBaseUri;
        r5 = r0;
        r5 = android.content.ContentUris.withAppendedId(r5, r7);
        r0 = r20;
        r1 = r5;
        r2 = r7;
        r11 = r0.createThumbnailFromUri(r1, r2);
        goto L_0x002e;
    }

    public void close() {
        r2 = this;
        r1 = 0;
        r2.mContentResolver = r1;
        r0 = r2.mCursor;
        if (r0 == 0) goto L_0x000e;
    L_0x0007:
        r0 = r2.mCursor;
        r0.close();
        r2.mCursor = r1;
    L_0x000e:
        return;
    }

    public android.net.Uri contentUri(long r6) {
        r5 = this;
        r3 = r5.mBaseUri;	 Catch:{ NumberFormatException -> 0x0014 }
        r1 = android.content.ContentUris.parseId(r3);	 Catch:{ NumberFormatException -> 0x0014 }
        r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1));
        if (r3 == 0) goto L_0x0011;
    L_0x000a:
        r3 = "BaseImageList";
        r4 = "id mismatch";
        android.util.Log.e(r3, r4);	 Catch:{ NumberFormatException -> 0x0014 }
    L_0x0011:
        r3 = r5.mBaseUri;	 Catch:{ NumberFormatException -> 0x0014 }
    L_0x0013:
        return r3;
    L_0x0014:
        r3 = move-exception;
        r0 = r3;
        r3 = r5.mBaseUri;
        r3 = android.content.ContentUris.withAppendedId(r3, r6);
        goto L_0x0013;
    }

    protected abstract android.database.Cursor createCursor();

    public void deactivate() {
        r3 = this;
        r3.invalidateCursor();	 Catch:{ IllegalStateException -> 0x0009 }
    L_0x0003:
        r1 = r3.mMiniThumbFile;
        r1.deactivate();
        return;
    L_0x0009:
        r0 = move-exception;
        r1 = "BaseImageList";
        r2 = "Caught exception while deactivating cursor.";
        android.util.Log.e(r1, r2, r0);
        goto L_0x0003;
    }

    public int describeContents() {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public int getCount() {
        r2 = this;
        r0 = r2.getCursor();
        monitor-enter(r0);
        r1 = r0.getCount();	 Catch:{ all -> 0x000b }
        monitor-exit(r0);	 Catch:{ all -> 0x000b }
        return r1;
    L_0x000b:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x000b }
        throw r1;
    }

    public com.techno.gallery.gallery.IImage getImageAt(int r5) {
        r4 = this;
        r2 = r4.mCache;
        r3 = java.lang.Integer.valueOf(r5);
        r1 = r2.get(r3);
        r1 = (com.techno.gallery.gallery.BaseImage) r1;
        if (r1 != 0) goto L_0x0028;
    L_0x000e:
        r0 = r4.getCursor();
        monitor-enter(r0);
        r2 = r0.moveToPosition(r5);	 Catch:{ all -> 0x002c }
        if (r2 == 0) goto L_0x0029;
    L_0x0019:
        r2 = r4.loadImageFromCursor(r0);	 Catch:{ all -> 0x002c }
        r1 = r2;
    L_0x001e:
        r2 = r4.mCache;	 Catch:{ all -> 0x002c }
        r3 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x002c }
        r2.put(r3, r1);	 Catch:{ all -> 0x002c }
        monitor-exit(r0);	 Catch:{ all -> 0x002c }
    L_0x0028:
        return r1;
    L_0x0029:
        r2 = 0;
        r1 = r2;
        goto L_0x001e;
    L_0x002c:
        r2 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x002c }
        throw r2;
    }

    public com.techno.gallery.gallery.IImage getImageForUri(android.net.Uri r11) {
        r10 = this;
        r9 = 0;
        r6 = r10.isChildImageUri(r11);
        if (r6 != 0) goto L_0x0009;
    L_0x0007:
        r6 = r9;
    L_0x0008:
        return r6;
    L_0x0009:
        r4 = android.content.ContentUris.parseId(r11);	 Catch:{ NumberFormatException -> 0x0043 }
        r0 = r10.getCursor();
        monitor-enter(r0);
        r6 = -1;
        r0.moveToPosition(r6);	 Catch:{ all -> 0x0064 }
        r2 = 0;
    L_0x0017:
        r6 = r0.moveToNext();	 Catch:{ all -> 0x0064 }
        if (r6 == 0) goto L_0x0061;
    L_0x001d:
        r6 = r10.getImageId(r0);	 Catch:{ all -> 0x0064 }
        r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r6 != 0) goto L_0x005e;
    L_0x0025:
        r6 = r10.mCache;	 Catch:{ all -> 0x0064 }
        r7 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0064 }
        r3 = r6.get(r7);	 Catch:{ all -> 0x0064 }
        r3 = (com.techno.gallery.gallery.BaseImage) r3;	 Catch:{ all -> 0x0064 }
        if (r3 != 0) goto L_0x0040;
    L_0x0033:
        r3 = r10.loadImageFromCursor(r0);	 Catch:{ all -> 0x0064 }
        r6 = r10.mCache;	 Catch:{ all -> 0x0064 }
        r7 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0064 }
        r6.put(r7, r3);	 Catch:{ all -> 0x0064 }
    L_0x0040:
        monitor-exit(r0);	 Catch:{ all -> 0x0064 }
        r6 = r3;
        goto L_0x0008;
    L_0x0043:
        r1 = move-exception;
        r6 = "BaseImageList";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "fail to get id in: ";
        r7 = r7.append(r8);
        r7 = r7.append(r11);
        r7 = r7.toString();
        android.util.Log.i(r6, r7, r1);
        r6 = r9;
        goto L_0x0008;
    L_0x005e:
        r2 = r2 + 1;
        goto L_0x0017;
    L_0x0061:
        monitor-exit(r0);
        r6 = r9;
        goto L_0x0008;
    L_0x0064:
        r6 = move-exception;
        monitor-exit(r0);
        throw r6;
    }

    protected abstract long getImageId(android.database.Cursor r1);

    public int getImageIndex(com.techno.gallery.gallery.IImage r2) {
        r1 = this;
        r2 = (com.techno.gallery.gallery.BaseImage) r2;
        r0 = r2.mIndex;
        return r0;
    }

    byte[] getMiniThumbFromFile(long r7, byte[] r9, long r10) {
        r6 = this;
        r0 = r6.mMiniThumbFile;
        r1 = r7;
        r3 = r9;
        r4 = r10;
        r0 = r0.getMiniThumbFromFile(r1, r3, r4);
        return r0;
    }

    protected void invalidateCache() {
        r1 = this;
        r0 = r1.mCache;
        r0.clear();
        return;
    }

    protected void invalidateCursor() {
        r1 = this;
        r0 = r1.mCursor;
        r0.deactivate();
        r0 = 1;
        r1.mCursorDeactivated = r0;
        return;
    }

    public boolean isEmpty() {
        r1 = this;
        r0 = r1.getCount();
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        r0 = 1;
    L_0x0007:
        return r0;
    L_0x0008:
        r0 = 0;
        goto L_0x0007;
    }

    protected abstract com.techno.gallery.gallery.BaseImage loadImageFromCursor(android.database.Cursor r1);

    public void open(android.content.ContentResolver r4) {
        r3 = this;
        r3.mContentResolver = r4;
        r1 = r3.createCursor();
        r3.mCursor = r1;
        r1 = r3.mCursor;
        if (r1 != 0) goto L_0x0027;
    L_0x000c:
        r0 = 0;
    L_0x000d:
        r1 = 10;
        if (r0 >= r1) goto L_0x0027;
    L_0x0011:
        r1 = "BaseImageList";
        r2 = "createCursor failed, retry...";
        android.util.Log.w(r1, r2);
        r1 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        java.lang.Thread.sleep(r1);	 Catch:{ InterruptedException -> 0x0030 }
    L_0x001d:
        r1 = r3.createCursor();
        r3.mCursor = r1;
        r1 = r3.mCursor;
        if (r1 == 0) goto L_0x002d;
    L_0x0027:
        r1 = r3.mCache;
        r1.clear();
        return;
    L_0x002d:
        r0 = r0 + 1;
        goto L_0x000d;
    L_0x0030:
        r1 = move-exception;
        goto L_0x001d;
    }

    public boolean removeImage(com.techno.gallery.gallery.IImage r4) {
        r3 = this;
        r2 = 0;
        r0 = r3.mContentResolver;
        r1 = r4.fullSizeImageUri();
        r0 = r0.delete(r1, r2, r2);
        if (r0 <= 0) goto L_0x001a;
    L_0x000d:
        r4 = (com.techno.gallery.gallery.BaseImage) r4;
        r4.onRemove();
        r3.invalidateCursor();
        r3.invalidateCache();
        r0 = 1;
    L_0x0019:
        return r0;
    L_0x001a:
        r0 = 0;
        goto L_0x0019;
    }

    public boolean removeImageAt(int r2) {
        r1 = this;
        r0 = r1.getImageAt(r2);
        r0 = r1.removeImage(r0);
        return r0;
    }

    void saveMiniThumbToFile(android.graphics.Bitmap r7, long r8, long r10) throws java.io.IOException {
        r6 = this;
        r0 = r6.mMiniThumbFile;
        r1 = r7;
        r2 = r8;
        r4 = r10;
        r0.saveMiniThumbToFile(r1, r2, r4);
        return;
    }

    void saveMiniThumbToFile(byte[] r7, long r8, long r10) throws java.io.IOException {
        r6 = this;
        r0 = r6.mMiniThumbFile;
        r1 = r7;
        r2 = r8;
        r4 = r10;
        r0.saveMiniThumbToFile(r1, r2, r4);
        return;
    }

    protected android.graphics.Bitmap storeThumbnail(android.graphics.Bitmap r6, long r7) {
        r5 = this;
        if (r6 != 0) goto L_0x0004;
    L_0x0002:
        r3 = 0;
    L_0x0003:
        return r3;
    L_0x0004:
        r3 = r6.getWidth();	 Catch:{ Exception -> 0x0026 }
        r4 = r6.getHeight();	 Catch:{ Exception -> 0x0026 }
        r2 = r5.getThumbnailUri(r7, r3, r4);	 Catch:{ Exception -> 0x0026 }
        if (r2 != 0) goto L_0x0014;
    L_0x0012:
        r3 = r6;
        goto L_0x0003;
    L_0x0014:
        r3 = r5.mContentResolver;	 Catch:{ Exception -> 0x0026 }
        r1 = r3.openOutputStream(r2);	 Catch:{ Exception -> 0x0026 }
        r3 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ Exception -> 0x0026 }
        r4 = 60;
        r6.compress(r3, r4, r1);	 Catch:{ Exception -> 0x0026 }
        r1.close();	 Catch:{ Exception -> 0x0026 }
        r3 = r6;
        goto L_0x0003;
    L_0x0026:
        r3 = move-exception;
        r0 = r3;
        r3 = "BaseImageList";
        r4 = "Unable to store thumbnail";
        android.util.Log.e(r3, r4, r0);
        r3 = r6;
        goto L_0x0003;
    }

    protected boolean storeThumbnail(byte[] r6, long r7, int r9, int r10) {
        r5 = this;
        r4 = 0;
        if (r6 != 0) goto L_0x0005;
    L_0x0003:
        r3 = r4;
    L_0x0004:
        return r3;
    L_0x0005:
        r2 = r5.getThumbnailUri(r7, r9, r10);
        if (r2 != 0) goto L_0x000d;
    L_0x000b:
        r3 = r4;
        goto L_0x0004;
    L_0x000d:
        r3 = r5.mContentResolver;	 Catch:{ FileNotFoundException -> 0x001b, IOException -> 0x001f }
        r1 = r3.openOutputStream(r2);	 Catch:{ FileNotFoundException -> 0x001b, IOException -> 0x001f }
        r1.write(r6);	 Catch:{ FileNotFoundException -> 0x001b, IOException -> 0x001f }
        r1.close();	 Catch:{ FileNotFoundException -> 0x001b, IOException -> 0x001f }
        r3 = 1;
        goto L_0x0004;
    L_0x001b:
        r3 = move-exception;
        r0 = r3;
        r3 = r4;
        goto L_0x0004;
    L_0x001f:
        r3 = move-exception;
        r0 = r3;
        r3 = r4;
        goto L_0x0004;
    }

    public void writeToParcel(android.os.Parcel r2, int r3) {
        r1 = this;
        r0 = r1.mSort;
        r2.writeInt(r0);
        r0 = r1.mBaseUri;
        r2.writeParcelable(r0, r3);
        r0 = r1.mBucketId;
        r2.writeString(r0);
        return;
    }
}