package com.techno.gallery;

public class ImageManager {
    public static final java.lang.String CAMERA_IMAGE_BUCKET_ID = null;
    public static final java.lang.String CAMERA_IMAGE_BUCKET_NAME = null;
    public static final android.graphics.Bitmap DEFAULT_THUMBNAIL = null;
    public static final int INCLUDE_DRM_IMAGES = 2;
    public static final int INCLUDE_IMAGES = 1;
    public static final int INCLUDE_VIDEOS = 4;
    public static final android.graphics.Bitmap NO_IMAGE_BITMAP = null;
    public static final int SORT_ASCENDING = 1;
    public static final int SORT_DESCENDING = 2;
    private static final android.net.Uri STORAGE_URI = null;
    private static final java.lang.String TAG = "ImageManager";
    private static final android.net.Uri THUMB_URI = null;
    private static final android.net.Uri VIDEO_STORAGE_URI = null;

    static {
        r2 = 32;
        r1 = 1;
        r0 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        STORAGE_URI = r0;
        r0 = android.provider.MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI;
        THUMB_URI = r0;
        r0 = "content://media/external/video/media";
        r0 = android.net.Uri.parse(r0);
        VIDEO_STORAGE_URI = r0;
        r0 = android.graphics.Bitmap.Config.RGB_565;
        r0 = android.graphics.Bitmap.createBitmap(r2, r2, r0);
        DEFAULT_THUMBNAIL = r0;
        r0 = android.graphics.Bitmap.Config.RGB_565;
        r0 = android.graphics.Bitmap.createBitmap(r1, r1, r0);
        NO_IMAGE_BITMAP = r0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = android.os.Environment.getExternalStorageDirectory();
        r1 = r1.toString();
        r0 = r0.append(r1);
        r1 = "/DCIM/Camera";
        r0 = r0.append(r1);
        r0 = r0.toString();
        CAMERA_IMAGE_BUCKET_NAME = r0;
        r0 = CAMERA_IMAGE_BUCKET_NAME;
        r0 = getBucketId(r0);
        CAMERA_IMAGE_BUCKET_ID = r0;
        return;
    }

    public ImageManager() {
        r0 = this;
        r0.<init>();
        return;
    }

    static /* synthetic */ android.net.Uri access$000() {
        r0 = STORAGE_URI;
        return r0;
    }

    static /* synthetic */ android.net.Uri access$100() {
        r0 = THUMB_URI;
        return r0;
    }

    public static android.net.Uri addImage(android.content.ContentResolver r5, java.lang.String r6, long r7, android.location.Location r9, int r10, java.lang.String r11, java.lang.String r12) {
        r1 = new android.content.ContentValues;
        r2 = 7;
        r1.<init>(r2);
        r2 = "title";
        r1.put(r2, r6);
        r2 = "_display_name";
        r1.put(r2, r12);
        r2 = "datetaken";
        r3 = java.lang.Long.valueOf(r7);
        r1.put(r2, r3);
        r2 = "mime_type";
        r3 = "image/jpeg";
        r1.put(r2, r3);
        r2 = "orientation";
        r3 = java.lang.Integer.valueOf(r10);
        r1.put(r2, r3);
        if (r9 == 0) goto L_0x0045;
    L_0x002b:
        r2 = "latitude";
        r3 = r9.getLatitude();
        r3 = java.lang.Double.valueOf(r3);
        r1.put(r2, r3);
        r2 = "longitude";
        r3 = r9.getLongitude();
        r3 = java.lang.Double.valueOf(r3);
        r1.put(r2, r3);
    L_0x0045:
        if (r11 == 0) goto L_0x0065;
    L_0x0047:
        if (r12 == 0) goto L_0x0065;
    L_0x0049:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r11);
        r3 = "/";
        r2 = r2.append(r3);
        r2 = r2.append(r12);
        r0 = r2.toString();
        r2 = "_data";
        r1.put(r2, r0);
    L_0x0065:
        r2 = STORAGE_URI;
        r2 = r5.insert(r2, r1);
        return r2;
    }

    public static com.techno.gallery.gallery.IImageList allImages(android.content.ContentResolver r1, com.techno.gallery.ImageManager.DataLocation r2, int r3, int r4) {
        r0 = 0;
        r0 = allImages(r1, r2, r3, r4, r0);
        return r0;
    }

    public static com.techno.gallery.gallery.IImageList allImages(android.content.ContentResolver r10, com.techno.gallery.ImageManager.DataLocation r11, int r12, int r13, java.lang.String r14) {
        r9 = 0;
        if (r10 != 0) goto L_0x0005;
    L_0x0003:
        r6 = 0;
    L_0x0004:
        return r6;
    L_0x0005:
        r0 = hasStorage(r9);
        r2 = new java.util.ArrayList;
        r2.<init>();
        if (r0 == 0) goto L_0x0032;
    L_0x0010:
        r6 = com.techno.gallery.ImageManager.DataLocation.INTERNAL;
        if (r11 == r6) goto L_0x0032;
    L_0x0014:
        r6 = r12 & 1;
        if (r6 == 0) goto L_0x0024;
    L_0x0018:
        r6 = new com.techno.gallery.gallery.ImageList;
        r7 = STORAGE_URI;
        r8 = THUMB_URI;
        r6.<init>(r7, r8, r13, r14);
        r2.add(r6);
    L_0x0024:
        r6 = r12 & 4;
        if (r6 == 0) goto L_0x0032;
    L_0x0028:
        r6 = new com.techno.gallery.gallery.VideoList;
        r7 = VIDEO_STORAGE_URI;
        r6.<init>(r7, r13, r14);
        r2.add(r6);
    L_0x0032:
        r6 = com.techno.gallery.ImageManager.DataLocation.INTERNAL;
        if (r11 == r6) goto L_0x003a;
    L_0x0036:
        r6 = com.techno.gallery.ImageManager.DataLocation.ALL;
        if (r11 != r6) goto L_0x0058;
    L_0x003a:
        r6 = r12 & 1;
        if (r6 == 0) goto L_0x004a;
    L_0x003e:
        r6 = new com.techno.gallery.gallery.ImageList;
        r7 = android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        r8 = android.provider.MediaStore.Images.Thumbnails.INTERNAL_CONTENT_URI;
        r6.<init>(r7, r8, r13, r14);
        r2.add(r6);
    L_0x004a:
        r6 = r12 & 2;
        if (r6 == 0) goto L_0x0058;
    L_0x004e:
        r6 = new com.techno.gallery.gallery.DrmImageList;
        r7 = android.provider.DrmStore.Images.CONTENT_URI;
        r6.<init>(r7, r13, r14);
        r2.add(r6);
    L_0x0058:
        r1 = r2.iterator();
    L_0x005c:
        r6 = r1.hasNext();
        if (r6 == 0) goto L_0x0078;
    L_0x0062:
        r4 = r1.next();
        r4 = (com.techno.gallery.gallery.BaseImageList) r4;
        r4.open(r10);
        r6 = r4.isEmpty();
        if (r6 == 0) goto L_0x0074;
    L_0x0071:
        r1.remove();
    L_0x0074:
        r4.close();
        goto L_0x005c;
    L_0x0078:
        r6 = r2.size();
        r7 = 1;
        if (r6 != r7) goto L_0x008b;
    L_0x007f:
        r3 = r2.get(r9);
        r3 = (com.techno.gallery.gallery.BaseImageList) r3;
        r3.open(r10);
        r6 = r3;
        goto L_0x0004;
    L_0x008b:
        r5 = new com.techno.gallery.gallery.ImageListUber;
        r6 = r2.size();
        r6 = new com.techno.gallery.gallery.IImageList[r6];
        r6 = r2.toArray(r6);
        r6 = (com.techno.gallery.gallery.IImageList[]) r6;
        r5.<init>(r6, r13);
        r5.open(r10);
        r6 = r5;
        goto L_0x0004;
    }

    private static boolean checkFsWritable() {
        r6 = 0;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = android.os.Environment.getExternalStorageDirectory();
        r5 = r5.toString();
        r4 = r4.append(r5);
        r5 = "/DCIM";
        r4 = r4.append(r5);
        r1 = r4.toString();
        r0 = new java.io.File;
        r0.<init>(r1);
        r4 = r0.isDirectory();
        if (r4 != 0) goto L_0x002f;
    L_0x0027:
        r4 = r0.mkdirs();
        if (r4 != 0) goto L_0x002f;
    L_0x002d:
        r4 = r6;
    L_0x002e:
        return r4;
    L_0x002f:
        r3 = new java.io.File;
        r4 = ".probe";
        r3.<init>(r1, r4);
        r4 = r3.exists();	 Catch:{ IOException -> 0x004c }
        if (r4 == 0) goto L_0x003f;
    L_0x003c:
        r3.delete();	 Catch:{ IOException -> 0x004c }
    L_0x003f:
        r4 = r3.createNewFile();	 Catch:{ IOException -> 0x004c }
        if (r4 != 0) goto L_0x0047;
    L_0x0045:
        r4 = r6;
        goto L_0x002e;
    L_0x0047:
        r3.delete();	 Catch:{ IOException -> 0x004c }
        r4 = 1;
        goto L_0x002e;
    L_0x004c:
        r4 = move-exception;
        r2 = r4;
        r4 = r6;
        goto L_0x002e;
    }

    public static com.techno.gallery.gallery.IImageList emptyImageList() {
        r0 = new com.techno.gallery.ImageManager$EmptyImageList;
        r1 = 0;
        r0.<init>(r1);
        return r0;
    }

    public static void ensureOSXCompatibleFolder() {
        r0 = new java.io.File;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = android.os.Environment.getExternalStorageDirectory();
        r2 = r2.toString();
        r1 = r1.append(r2);
        r2 = "/DCIM/100ANDRO";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        r1 = r0.exists();
        if (r1 != 0) goto L_0x004e;
    L_0x0026:
        r1 = r0.mkdir();
        if (r1 != 0) goto L_0x004e;
    L_0x002c:
        r1 = "ImageManager";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "create NNNAAAAA file: ";
        r2 = r2.append(r3);
        r3 = r0.getPath();
        r2 = r2.append(r3);
        r3 = " failed";
        r2 = r2.append(r3);
        r2 = r2.toString();
        android.util.Log.e(r1, r2);
    L_0x004e:
        return;
    }

    public static java.lang.String getBucketId(java.lang.String r1) {
        r0 = r1.toLowerCase();
        r0 = r0.hashCode();
        r0 = java.lang.String.valueOf(r0);
        return r0;
    }

    public static java.lang.String getLastImageThumbPath() {
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = android.os.Environment.getExternalStorageDirectory();
        r1 = r1.toString();
        r0 = r0.append(r1);
        r1 = "/DCIM/.thumbnails/image_last_thumb";
        r0 = r0.append(r1);
        r0 = r0.toString();
        return r0;
    }

    public static java.lang.String getLastVideoThumbPath() {
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = android.os.Environment.getExternalStorageDirectory();
        r1 = r1.toString();
        r0 = r0.append(r1);
        r1 = "/DCIM/.thumbnails/video_last_thumb";
        r0 = r0.append(r1);
        r0 = r0.toString();
        return r0;
    }

    public static boolean hasStorage() {
        r0 = 1;
        r0 = hasStorage(r0);
        return r0;
    }

    public static boolean hasStorage(boolean r4) {
        r3 = 1;
        r0 = android.os.Environment.getExternalStorageState();
        r2 = "mounted";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0017;
    L_0x000d:
        if (r4 == 0) goto L_0x0015;
    L_0x000f:
        r1 = checkFsWritable();
        r2 = r1;
    L_0x0014:
        return r2;
    L_0x0015:
        r2 = r3;
        goto L_0x0014;
    L_0x0017:
        if (r4 != 0) goto L_0x0023;
    L_0x0019:
        r2 = "mounted_ro";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0023;
    L_0x0021:
        r2 = r3;
        goto L_0x0014;
    L_0x0023:
        r2 = 0;
        goto L_0x0014;
    }

    public static boolean isImage(com.techno.gallery.gallery.IImage r1) {
        r0 = r1.getMimeType();
        r0 = isImageMimeType(r0);
        return r0;
    }

    public static boolean isImageMimeType(java.lang.String r1) {
        r0 = "image/";
        r0 = r1.startsWith(r0);
        return r0;
    }

    public static boolean isMediaScannerScanning(android.content.ContentResolver r10) {
        r9 = 1;
        r8 = 0;
        r3 = 0;
        r7 = 0;
        r1 = android.provider.MediaStore.getMediaScannerUri();
        r2 = new java.lang.String[r9];
        r0 = "volume";
        r2[r8] = r0;
        r0 = r10;
        r4 = r3;
        r5 = r3;
        r6 = query(r0, r1, r2, r3, r4, r5);
        if (r6 == 0) goto L_0x002d;
    L_0x0017:
        r0 = r6.getCount();
        if (r0 != r9) goto L_0x002a;
    L_0x001d:
        r6.moveToFirst();
        r0 = "external";
        r1 = r6.getString(r8);
        r7 = r0.equals(r1);
    L_0x002a:
        r6.close();
    L_0x002d:
        return r7;
    }

    static boolean isSingleImageMode(java.lang.String r1) {
        r0 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        r0 = r0.toString();
        r0 = r1.startsWith(r0);
        if (r0 != 0) goto L_0x001a;
    L_0x000c:
        r0 = android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        r0 = r0.toString();
        r0 = r1.startsWith(r0);
        if (r0 != 0) goto L_0x001a;
    L_0x0018:
        r0 = 1;
    L_0x0019:
        return r0;
    L_0x001a:
        r0 = 0;
        goto L_0x0019;
    }

    public static boolean isVideo(com.techno.gallery.gallery.IImage r1) {
        r0 = r1 instanceof com.techno.gallery.gallery.VideoObject;
        return r0;
    }

    public static boolean isVideoMimeType(java.lang.String r1) {
        r0 = "video/";
        r0 = r1.startsWith(r0);
        return r0;
    }

    public static com.techno.gallery.gallery.IImageList makeImageList(android.net.Uri r6, android.content.ContentResolver r7, int r8) {
        if (r6 == 0) goto L_0x0017;
    L_0x0002:
        r4 = r6.toString();
        r3 = r4;
    L_0x0007:
        r4 = "content://drm";
        r4 = r3.startsWith(r4);
        if (r4 == 0) goto L_0x001b;
    L_0x000f:
        r4 = com.techno.gallery.ImageManager.DataLocation.ALL;
        r5 = 2;
        r2 = allImages(r7, r4, r5, r8);
    L_0x0016:
        return r2;
    L_0x0017:
        r4 = "";
        r3 = r4;
        goto L_0x0007;
    L_0x001b:
        r4 = "content://media/external/video";
        r4 = r3.startsWith(r4);
        if (r4 == 0) goto L_0x002b;
    L_0x0023:
        r4 = com.techno.gallery.ImageManager.DataLocation.EXTERNAL;
        r5 = 4;
        r2 = allImages(r7, r4, r5, r8);
        goto L_0x0016;
    L_0x002b:
        r4 = isSingleImageMode(r3);
        if (r4 == 0) goto L_0x003e;
    L_0x0031:
        r2 = new com.techno.gallery.gallery.SingleImageList;
        r2.<init>(r6);
        r0 = r2;
        r0 = (com.techno.gallery.gallery.SingleImageList) r0;
        r4 = r0;
        r4.open(r7);
        goto L_0x0016;
    L_0x003e:
        r4 = "bucketId";
        r1 = r6.getQueryParameter(r4);
        r4 = com.techno.gallery.ImageManager.DataLocation.ALL;
        r5 = 1;
        r2 = allImages(r7, r4, r5, r8, r1);
        goto L_0x0016;
    }

    private static android.database.Cursor query(android.content.ContentResolver r2, android.net.Uri r3, java.lang.String[] r4, java.lang.String r5, java.lang.String[] r6, java.lang.String r7) {
        r1 = 0;
        if (r2 != 0) goto L_0x0004;
    L_0x0003:
        return r1;
    L_0x0004:
        r1 = r2.query(r3, r4, r5, r6, r7);	 Catch:{ UnsupportedOperationException -> 0x0009 }
        goto L_0x0003;
    L_0x0009:
        r0 = move-exception;
        goto L_0x0003;
    }

    public static int roundOrientation(int r3) {
        r0 = r3;
        r2 = -1;
        if (r0 != r2) goto L_0x0005;
    L_0x0004:
        r0 = 0;
    L_0x0005:
        r0 = r0 % 360;
        r2 = 45;
        if (r0 >= r2) goto L_0x000d;
    L_0x000b:
        r1 = 0;
    L_0x000c:
        return r1;
    L_0x000d:
        r2 = 135; // 0x87 float:1.89E-43 double:6.67E-322;
        if (r0 >= r2) goto L_0x0014;
    L_0x0011:
        r1 = 90;
        goto L_0x000c;
    L_0x0014:
        r2 = 225; // 0xe1 float:3.15E-43 double:1.11E-321;
        if (r0 >= r2) goto L_0x001b;
    L_0x0018:
        r1 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;
        goto L_0x000c;
    L_0x001b:
        r2 = 315; // 0x13b float:4.41E-43 double:1.556E-321;
        if (r0 >= r2) goto L_0x0022;
    L_0x001f:
        r1 = 270; // 0x10e float:3.78E-43 double:1.334E-321;
        goto L_0x000c;
    L_0x0022:
        r1 = 0;
        goto L_0x000c;
    }

    public static void setImageSize(android.content.ContentResolver r4, android.net.Uri r5, long r6) {
        r3 = 0;
        r0 = new android.content.ContentValues;
        r0.<init>();
        r1 = "_size";
        r2 = java.lang.Long.valueOf(r6);
        r0.put(r1, r2);
        r4.update(r5, r0, r3, r3);
        return;
    }

    public static com.techno.gallery.gallery.Cancelable<java.lang.Void> storeImage(android.net.Uri r6, android.content.ContentResolver r7, int r8, android.graphics.Bitmap r9, byte[] r10) {
        r0 = new com.techno.gallery.ImageManager$AddImageCancelable;
        r1 = r6;
        r2 = r7;
        r3 = r8;
        r4 = r9;
        r5 = r10;
        r0.<init>(r1, r2, r3, r4, r5);
        return r0;
    }
}