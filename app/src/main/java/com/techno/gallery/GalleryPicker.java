package com.techno.gallery;

public class GalleryPicker extends android.app.Activity {
    private static final java.lang.String CAMERA_BUCKET = null;
    private static final com.techno.gallery.GalleryPicker.ImageListData[] IMAGE_LIST_DATA = null;
    private static final long LOW_STORAGE_THRESHOLD = 2097152;
    private static final java.lang.String TAG = "GalleryPicker";
    private static final int THUMB_SIZE = 142;
    volatile boolean mAbort;
    com.techno.gallery.GalleryPickerAdapter mAdapter;
    java.util.ArrayList<com.techno.gallery.gallery.IImageList> mAllLists;
    android.graphics.drawable.Drawable mCellOutline;
    android.database.ContentObserver mDbObserver;
    android.graphics.drawable.Drawable mFrameGalleryMask;
    android.widget.GridView mGridView;
    android.os.Handler mHandler;
    android.app.Dialog mMediaScanningDialog;
    private android.view.View mNoImagesView;
    android.content.BroadcastReceiver mReceiver;
    boolean mScanning;
    boolean mUnmounted;
    android.graphics.drawable.Drawable mVideoOverlay;
    java.lang.Thread mWorkerThread;

    static {
        r9 = 3;
        r8 = 2;
        r7 = 0;
        r6 = 4;
        r5 = 1;
        r0 = com.techno.gallery.ImageManager.CAMERA_IMAGE_BUCKET_ID;
        CAMERA_BUCKET = r0;
        r0 = 5;
        r0 = new com.techno.gallery.GalleryPicker.ImageListData[r0];
        r1 = new com.techno.gallery.GalleryPicker$ImageListData;
        r2 = com.techno.gallery.ImageManager.CAMERA_IMAGE_BUCKET_ID;
        r3 = 2131296262; // 0x7f090006 float:1.8210436E38 double:1.053000264E-314;
        r1.<init>(r8, r5, r2, r3);
        r0[r7] = r1;
        r1 = new com.techno.gallery.GalleryPicker$ImageListData;
        r2 = com.techno.gallery.ImageManager.CAMERA_IMAGE_BUCKET_ID;
        r3 = 2131296263; // 0x7f090007 float:1.8210438E38 double:1.0530002647E-314;
        r1.<init>(r9, r6, r2, r3);
        r0[r5] = r1;
        r1 = new com.techno.gallery.GalleryPicker$ImageListData;
        r2 = 5;
        r3 = com.techno.gallery.ImageManager.CAMERA_IMAGE_BUCKET_ID;
        r4 = 2131296264; // 0x7f090008 float:1.821044E38 double:1.053000265E-314;
        r1.<init>(r6, r2, r3, r4);
        r0[r8] = r1;
        r1 = new com.techno.gallery.GalleryPicker$ImageListData;
        r2 = 0;
        r3 = 2131296256; // 0x7f090000 float:1.8210424E38 double:1.053000261E-314;
        r1.<init>(r7, r5, r2, r3);
        r0[r9] = r1;
        r1 = new com.techno.gallery.GalleryPicker$ImageListData;
        r2 = 0;
        r3 = 2131296257; // 0x7f090001 float:1.8210426E38 double:1.0530002617E-314;
        r1.<init>(r5, r6, r2, r3);
        r0[r6] = r1;
        IMAGE_LIST_DATA = r0;
        return;
    }

    public GalleryPicker() {
        r1 = this;
        r1.<init>();
        r0 = new android.os.Handler;
        r0.<init>();
        r1.mHandler = r0;
        r0 = 0;
        r1.mAbort = r0;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1.mAllLists = r0;
        return;
    }

    private void abortWorker() {
        r3 = this;
        r1 = r3.mWorkerThread;
        if (r1 == 0) goto L_0x002b;
    L_0x0004:
        r1 = com.techno.gallery.BitmapManager.instance();
        r2 = r3.mWorkerThread;
        r1.cancelThreadDecoding(r2);
        r1 = 1;
        r3.mAbort = r1;
        r1 = r3.mWorkerThread;	 Catch:{ InterruptedException -> 0x002c }
        r1.join();	 Catch:{ InterruptedException -> 0x002c }
    L_0x0015:
        r1 = 0;
        r3.mWorkerThread = r1;
        r1 = r3.mHandler;
        r2 = 0;
        r1.removeMessages(r2);
        r1 = r3.mAdapter;
        r1.clear();
        r1 = r3.mAdapter;
        r1.updateDisplay();
        r3.clearImageLists();
    L_0x002b:
        return;
    L_0x002c:
        r1 = move-exception;
        r0 = r1;
        r1 = "GalleryPicker";
        r2 = "join interrupted";
        android.util.Log.e(r1, r2);
        goto L_0x0015;
    }

    static /* synthetic */ void access$000(com.techno.gallery.GalleryPicker r0, int r1) {
        r0.launchFolderGallery(r1);
        return;
    }

    static /* synthetic */ void access$100(com.techno.gallery.GalleryPicker r0, android.view.ContextMenu r1, android.view.ContextMenu.ContextMenuInfo r2) {
        r0.onCreateGalleryPickerContextMenu(r1, r2);
        return;
    }

    static /* synthetic */ void access$1000(com.techno.gallery.GalleryPicker r0, com.techno.gallery.Item r1, android.graphics.Bitmap r2) {
        r0.updateThumbBitmap(r1, r2);
        return;
    }

    static /* synthetic */ void access$1100(com.techno.gallery.GalleryPicker r0) {
        r0.checkLowStorageFinished();
        return;
    }

    static /* synthetic */ void access$200(com.techno.gallery.GalleryPicker r0, android.content.Intent r1) {
        r0.onReceiveMediaBroadcast(r1);
        return;
    }

    static /* synthetic */ void access$300(com.techno.gallery.GalleryPicker r0, boolean r1, boolean r2) {
        r0.rebake(r1, r2);
        return;
    }

    static /* synthetic */ boolean access$400(com.techno.gallery.GalleryPicker r1, android.view.ContextMenu.ContextMenuInfo r2) {
        r0 = r1.onSlideShowClicked(r2);
        return r0;
    }

    static /* synthetic */ boolean access$500(com.techno.gallery.GalleryPicker r1, android.view.ContextMenu.ContextMenuInfo r2) {
        r0 = r1.onViewClicked(r2);
        return r0;
    }

    static /* synthetic */ void access$600(com.techno.gallery.GalleryPicker r0) {
        r0.workerRun();
        return;
    }

    static /* synthetic */ void access$700(com.techno.gallery.GalleryPicker r0, boolean r1) {
        r0.checkScanningFinished(r1);
        return;
    }

    static /* synthetic */ void access$800(com.techno.gallery.GalleryPicker r0, com.techno.gallery.Item r1) {
        r0.updateItem(r1);
        return;
    }

    static /* synthetic */ void access$900(com.techno.gallery.GalleryPicker r0) {
        r0.checkBucketIdsFinished();
        return;
    }

    private void checkBucketIds(java.util.ArrayList<com.techno.gallery.Item> r13) {
        r12 = this;
        r11 = 5;
        r8 = r12.mScanning;
        if (r8 != 0) goto L_0x001c;
    L_0x0005:
        r8 = r12.mUnmounted;
        if (r8 != 0) goto L_0x001c;
    L_0x0009:
        r8 = r12.getContentResolver();
        r9 = com.techno.gallery.ImageManager.DataLocation.ALL;
        r10 = 2;
        r0 = com.techno.gallery.ImageManager.allImages(r8, r9, r11, r10);
    L_0x0014:
        r8 = r12.mAbort;
        if (r8 == 0) goto L_0x0021;
    L_0x0018:
        r0.deactivate();
    L_0x001b:
        return;
    L_0x001c:
        r0 = com.techno.gallery.ImageManager.emptyImageList();
        goto L_0x0014;
    L_0x0021:
        r3 = r0.getBucketIds();
        r0.deactivate();
        r8 = r12.mAbort;
        if (r8 != 0) goto L_0x001b;
    L_0x002c:
        r8 = r3.entrySet();
        r4 = r8.iterator();
    L_0x0034:
        r8 = r4.hasNext();
        if (r8 == 0) goto L_0x0076;
    L_0x003a:
        r1 = r4.next();
        r1 = (java.util.Map.Entry) r1;
        r6 = r1.getKey();
        r6 = (java.lang.String) r6;
        if (r6 == 0) goto L_0x0034;
    L_0x0048:
        r8 = CAMERA_BUCKET;
        r8 = r6.equals(r8);
        if (r8 != 0) goto L_0x0034;
    L_0x0050:
        r8 = r12.getContentResolver();
        r7 = r12.createImageList(r11, r6, r8);
        r8 = r12.mAbort;
        if (r8 != 0) goto L_0x001b;
    L_0x005c:
        r5 = new com.techno.gallery.Item;
        r8 = r1.getValue();
        r8 = (java.lang.String) r8;
        r5.<init>(r11, r6, r8, r7);
        r13.add(r5);
        r2 = r5;
        r8 = r12.mHandler;
        r9 = new com.techno.gallery.GalleryPicker$10;
        r9.<init>(r12, r2);
        r8.post(r9);
        goto L_0x0034;
    L_0x0076:
        r8 = r12.mHandler;
        r9 = new com.techno.gallery.GalleryPicker$11;
        r9.<init>(r12);
        r8.post(r9);
        goto L_0x001b;
    }

    private void checkBucketIdsFinished() {
        r3 = this;
        r1 = r3.mScanning;
        if (r1 != 0) goto L_0x0011;
    L_0x0004:
        r1 = r3.mAdapter;
        r1 = r1.mItems;
        r0 = r1.size();
        if (r0 != 0) goto L_0x0012;
    L_0x000e:
        r3.showNoImagesView();
    L_0x0011:
        return;
    L_0x0012:
        r1 = 1;
        if (r0 != r1) goto L_0x0011;
    L_0x0015:
        r1 = r3.mAdapter;
        r1 = r1.mItems;
        r2 = 0;
        r1 = r1.get(r2);
        r1 = (com.techno.gallery.Item) r1;
        r1.launch(r3);
        r3.finish();
        goto L_0x0011;
    }

    private void checkImageList(java.util.ArrayList<com.techno.gallery.Item> r12) {
        r11 = this;
        r10 = 3;
        r6 = IMAGE_LIST_DATA;
        r4 = r6.length;
        r5 = new com.techno.gallery.gallery.IImageList[r4];
        r2 = 0;
    L_0x0007:
        if (r2 >= r4) goto L_0x001f;
    L_0x0009:
        r6 = IMAGE_LIST_DATA;
        r0 = r6[r2];
        r6 = r0.mInclude;
        r7 = r0.mBucketId;
        r8 = r11.getContentResolver();
        r6 = r11.createImageList(r6, r7, r8);
        r5[r2] = r6;
        r6 = r11.mAbort;
        if (r6 == 0) goto L_0x0020;
    L_0x001f:
        return;
    L_0x0020:
        r3 = 0;
        r6 = r5[r2];
        r6 = r6.isEmpty();
        if (r6 == 0) goto L_0x002c;
    L_0x0029:
        r2 = r2 + 1;
        goto L_0x0007;
    L_0x002c:
        if (r2 < r10) goto L_0x003e;
    L_0x002e:
        r6 = r5[r2];
        r6 = r6.getCount();
        r7 = r2 - r10;
        r7 = r5[r7];
        r7 = r7.getCount();
        if (r6 == r7) goto L_0x0029;
    L_0x003e:
        r3 = new com.techno.gallery.Item;
        r6 = r0.mType;
        r7 = r0.mBucketId;
        r8 = r11.getResources();
        r9 = r0.mStringId;
        r8 = r8.getString(r9);
        r9 = r5[r2];
        r3.<init>(r6, r7, r8, r9);
        r12.add(r3);
        r1 = r3;
        r6 = r11.mHandler;
        r7 = new com.techno.gallery.GalleryPicker$9;
        r7.<init>(r11, r1);
        r6.post(r7);
        goto L_0x0029;
    }

    private void checkLowStorage() {
        r8 = this;
        r4 = com.techno.gallery.ImageManager.hasStorage();
        if (r4 == 0) goto L_0x0030;
    L_0x0006:
        r4 = android.os.Environment.getExternalStorageDirectory();
        r3 = r4.toString();
        r2 = new android.os.StatFs;
        r2.<init>(r3);
        r4 = r2.getAvailableBlocks();
        r4 = (long) r4;
        r6 = r2.getBlockSize();
        r6 = (long) r6;
        r0 = r4 * r6;
        r4 = 2097152; // 0x200000 float:2.938736E-39 double:1.036131E-317;
        r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r4 >= 0) goto L_0x0030;
    L_0x0026:
        r4 = r8.mHandler;
        r5 = new com.techno.gallery.GalleryPicker$13;
        r5.<init>(r8);
        r4.post(r5);
    L_0x0030:
        return;
    }

    private void checkLowStorageFinished() {
        r2 = this;
        r0 = 2131296272; // 0x7f090010 float:1.8210456E38 double:1.053000269E-314;
        r1 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r0 = android.widget.Toast.makeText(r2, r0, r1);
        r0.show();
        return;
    }

    private void checkScanning() {
        r4 = this;
        r0 = r4.getContentResolver();
        r1 = com.techno.gallery.ImageManager.isMediaScannerScanning(r0);
        r2 = r4.mHandler;
        r3 = new com.techno.gallery.GalleryPicker$8;
        r3.<init>(r4, r1);
        r2.post(r3);
        return;
    }

    private void checkScanningFinished(boolean r1) {
        r0 = this;
        r0.updateScanningDialog(r1);
        return;
    }

    private void checkThumbBitmap(java.util.ArrayList<com.techno.gallery.Item> r8) {
        r7 = this;
        r6 = 142; // 0x8e float:1.99E-43 double:7.0E-322;
        r2 = r8.iterator();
    L_0x0006:
        r4 = r2.hasNext();
        if (r4 == 0) goto L_0x0021;
    L_0x000c:
        r3 = r2.next();
        r3 = (com.techno.gallery.Item) r3;
        r4 = r3.mImageList;
        r0 = r7.makeMiniThumbBitmap(r6, r6, r4);
        r4 = r7.mAbort;
        if (r4 == 0) goto L_0x0022;
    L_0x001c:
        if (r0 == 0) goto L_0x0021;
    L_0x001e:
        r0.recycle();
    L_0x0021:
        return;
    L_0x0022:
        r1 = r3;
        r4 = r7.mHandler;
        r5 = new com.techno.gallery.GalleryPicker$12;
        r5.<init>(r7, r1, r0);
        r4.post(r5);
        goto L_0x0006;
    }

    private void clearImageLists() {
        r3 = this;
        r2 = r3.mAllLists;
        r0 = r2.iterator();
    L_0x0006:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x0016;
    L_0x000c:
        r1 = r0.next();
        r1 = (com.techno.gallery.gallery.IImageList) r1;
        r1.deactivate();
        goto L_0x0006;
    L_0x0016:
        r2 = r3.mAllLists;
        r2.clear();
        return;
    }

    private com.techno.gallery.gallery.IImageList createImageList(int r4, java.lang.String r5, android.content.ContentResolver r6) {
        r3 = this;
        r1 = com.techno.gallery.ImageManager.DataLocation.ALL;
        r2 = 2;
        r0 = com.techno.gallery.ImageManager.allImages(r6, r1, r4, r2, r5);
        r1 = r3.mAllLists;
        r1.add(r0);
        return r0;
    }

    private void hideNoImagesView() {
        r2 = this;
        r0 = r2.mNoImagesView;
        if (r0 == 0) goto L_0x000b;
    L_0x0004:
        r0 = r2.mNoImagesView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x000b:
        return;
    }

    private void launchFolderGallery(int r2) {
        r1 = this;
        r0 = r1.mAdapter;
        r0 = r0.mItems;
        r0 = r0.get(r2);
        r0 = (com.techno.gallery.Item) r0;
        r0.launch(r1);
        return;
    }

    private void loadDrawableIfNeeded() {
        r2 = this;
        r1 = r2.mFrameGalleryMask;
        if (r1 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r2.getResources();
        r1 = 2130837556; // 0x7f020034 float:1.728007E38 double:1.0527736333E-314;
        r1 = r0.getDrawable(r1);
        r2.mFrameGalleryMask = r1;
        r1 = 17301532; // 0x108001c float:2.4979333E-38 double:8.5480926E-317;
        r1 = r0.getDrawable(r1);
        r2.mCellOutline = r1;
        r1 = 2130837587; // 0x7f020053 float:1.7280132E38 double:1.0527736486E-314;
        r1 = r0.getDrawable(r1);
        r2.mVideoOverlay = r1;
        goto L_0x0004;
    }

    private android.graphics.Bitmap makeMiniThumbBitmap(int r35, int r36, com.techno.gallery.gallery.IImageList r37) {
        r34 = this;
        r19 = r37.getCount();
        r29 = 4;
        r11 = r35;
        r13 = r36;
        r15 = 0;
        r16 = 0;
        r6 = 4;
        r6 = r11 - r6;
        r11 = r6 / 2;
        r6 = 4;
        r6 = r13 - r6;
        r13 = r6 / 2;
        r28 = new android.graphics.Paint;
        r28.<init>();
        r6 = android.graphics.Bitmap.Config.ARGB_8888;
        r0 = r35;
        r1 = r36;
        r2 = r6;
        r18 = android.graphics.Bitmap.createBitmap(r0, r1, r2);
        r5 = new android.graphics.Canvas;
        r0 = r5;
        r1 = r18;
        r0.<init>(r1);
        r22 = new android.graphics.Matrix;
        r22.<init>();
        r6 = 0;
        r0 = r28;
        r1 = r6;
        r0.setColor(r1);
        r0 = r5;
        r1 = r28;
        r0.drawPaint(r1);
        r34.loadDrawableIfNeeded();
        r6 = -1;
        r0 = r28;
        r1 = r6;
        r0.setColor(r1);
        r0 = r34;
        r0 = r0.mFrameGalleryMask;
        r6 = r0;
        r7 = 0;
        r8 = 0;
        r0 = r6;
        r1 = r7;
        r2 = r8;
        r3 = r35;
        r4 = r36;
        r0.setBounds(r1, r2, r3, r4);
        r0 = r34;
        r0 = r0.mFrameGalleryMask;
        r6 = r0;
        r6.draw(r5);
        r10 = new android.graphics.Paint;
        r10.<init>();
        r6 = new android.graphics.PorterDuffXfermode;
        r7 = android.graphics.PorterDuff.Mode.SRC_IN;
        r6.<init>(r7);
        r10.setXfermode(r6);
        r6 = android.graphics.Paint.Style.FILL;
        r10.setStyle(r6);
        r6 = 0;
        r7 = 0;
        r0 = r35;
        r0 = (float) r0;
        r8 = r0;
        r0 = r36;
        r0 = (float) r0;
        r9 = r0;
        r5.drawRect(r6, r7, r8, r9, r10);
        r17 = 0;
    L_0x0087:
        r6 = 4;
        r0 = r17;
        r1 = r6;
        if (r0 >= r1) goto L_0x0180;
    L_0x008d:
        r0 = r34;
        r0 = r0.mAbort;
        r6 = r0;
        if (r6 == 0) goto L_0x0096;
    L_0x0094:
        r6 = 0;
    L_0x0095:
        return r6;
    L_0x0096:
        r30 = 0;
        r0 = r17;
        r1 = r19;
        if (r0 >= r1) goto L_0x017b;
    L_0x009e:
        r0 = r37;
        r1 = r17;
        r6 = r0.getImageAt(r1);
        r20 = r6;
    L_0x00a8:
        if (r20 == 0) goto L_0x00ae;
    L_0x00aa:
        r30 = r20.miniThumbBitmap();
    L_0x00ae:
        if (r30 == 0) goto L_0x0131;
    L_0x00b0:
        r6 = com.techno.gallery.ImageManager.isVideo(r20);
        if (r6 == 0) goto L_0x011a;
    L_0x00b6:
        r6 = r30.getConfig();
        r7 = 1;
        r0 = r30;
        r1 = r6;
        r2 = r7;
        r24 = r0.copy(r1, r2);
        r25 = new android.graphics.Canvas;
        r0 = r25;
        r1 = r24;
        r0.<init>(r1);
        r0 = r34;
        r0 = r0.mVideoOverlay;
        r6 = r0;
        r27 = r6.getIntrinsicWidth();
        r0 = r34;
        r0 = r0.mVideoOverlay;
        r6 = r0;
        r26 = r6.getIntrinsicHeight();
        r6 = r24.getWidth();
        r6 = r6 - r27;
        r21 = r6 / 2;
        r6 = r24.getHeight();
        r6 = r6 - r26;
        r33 = r6 / 2;
        r23 = new android.graphics.Rect;
        r6 = r21 + r27;
        r7 = r33 + r26;
        r0 = r23;
        r1 = r21;
        r2 = r33;
        r3 = r6;
        r4 = r7;
        r0.<init>(r1, r2, r3, r4);
        r0 = r34;
        r0 = r0.mVideoOverlay;
        r6 = r0;
        r0 = r6;
        r1 = r23;
        r0.setBounds(r1);
        r0 = r34;
        r0 = r0.mVideoOverlay;
        r6 = r0;
        r0 = r6;
        r1 = r25;
        r0.draw(r1);
        r30.recycle();
        r30 = r24;
    L_0x011a:
        r6 = 1;
        r0 = r22;
        r1 = r30;
        r2 = r11;
        r3 = r13;
        r4 = r6;
        r31 = com.techno.gallery.Util.transform(r0, r1, r2, r3, r4);
        r0 = r31;
        r1 = r30;
        if (r0 == r1) goto L_0x012f;
    L_0x012c:
        r30.recycle();
    L_0x012f:
        r30 = r31;
    L_0x0131:
        r6 = android.graphics.Bitmap.Config.ARGB_8888;
        r8 = android.graphics.Bitmap.createBitmap(r11, r13, r6);
        r32 = new android.graphics.Canvas;
        r0 = r32;
        r1 = r8;
        r0.<init>(r1);
        if (r30 == 0) goto L_0x0154;
    L_0x0141:
        r6 = new android.graphics.Matrix;
        r6.<init>();
        r7 = new android.graphics.Paint;
        r7.<init>();
        r0 = r32;
        r1 = r30;
        r2 = r6;
        r3 = r7;
        r0.drawBitmap(r1, r2, r3);
    L_0x0154:
        r0 = r34;
        r0 = r0.mCellOutline;
        r6 = r0;
        r7 = 0;
        r9 = 0;
        r6.setBounds(r7, r9, r11, r13);
        r0 = r34;
        r0 = r0.mCellOutline;
        r6 = r0;
        r0 = r6;
        r1 = r32;
        r0.draw(r1);
        r12 = 4;
        r14 = 4;
        r9 = r5;
        placeImage(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
        r8.recycle();
        if (r30 == 0) goto L_0x0177;
    L_0x0174:
        r30.recycle();
    L_0x0177:
        r17 = r17 + 1;
        goto L_0x0087;
    L_0x017b:
        r6 = 0;
        r20 = r6;
        goto L_0x00a8;
    L_0x0180:
        r6 = r18;
        goto L_0x0095;
    }

    private void onCreateGalleryPickerContextMenu(android.view.ContextMenu r6, android.view.ContextMenu.ContextMenuInfo r7) {
        r5 = this;
        r4 = 0;
        r0 = r7;
        r0 = (android.widget.AdapterView.AdapterContextMenuInfo) r0;
        r2 = r0;
        r1 = r2.position;
        r2 = r5.mAdapter;
        r2 = r2.baseTitleForPosition(r1);
        r6.setHeaderTitle(r2);
        r2 = r5.mAdapter;
        r2 = r2.getIncludeMediaTypes(r1);
        r2 = r2 & 1;
        if (r2 == 0) goto L_0x002b;
    L_0x001a:
        r2 = 207; // 0xcf float:2.9E-43 double:1.023E-321;
        r3 = 2131296284; // 0x7f09001c float:1.821048E38 double:1.053000275E-314;
        r2 = r6.add(r4, r2, r4, r3);
        r3 = new com.techno.gallery.GalleryPicker$5;
        r3.<init>(r5, r7);
        r2.setOnMenuItemClickListener(r3);
    L_0x002b:
        r2 = 208; // 0xd0 float:2.91E-43 double:1.03E-321;
        r3 = 2131296278; // 0x7f090016 float:1.8210468E38 double:1.053000272E-314;
        r2 = r6.add(r4, r2, r4, r3);
        r3 = new com.techno.gallery.GalleryPicker$6;
        r3.<init>(r5, r7);
        r2.setOnMenuItemClickListener(r3);
        return;
    }

    private void onReceiveMediaBroadcast(android.content.Intent r5) {
        r4 = this;
        r3 = 1;
        r2 = 0;
        r0 = r5.getAction();
        r1 = "android.intent.action.MEDIA_MOUNTED";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r1 = "android.intent.action.MEDIA_UNMOUNTED";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x001b;
    L_0x0017:
        r4.rebake(r3, r2);
        goto L_0x000e;
    L_0x001b:
        r1 = "android.intent.action.MEDIA_SCANNER_STARTED";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0027;
    L_0x0023:
        r4.rebake(r2, r3);
        goto L_0x000e;
    L_0x0027:
        r1 = "android.intent.action.MEDIA_SCANNER_FINISHED";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0033;
    L_0x002f:
        r4.rebake(r2, r2);
        goto L_0x000e;
    L_0x0033:
        r1 = "android.intent.action.MEDIA_EJECT";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x000e;
    L_0x003b:
        r4.rebake(r3, r2);
        goto L_0x000e;
    }

    private boolean onSlideShowClicked(android.view.ContextMenu.ContextMenuInfo r11) {
        r10 = this;
        r9 = 1;
        r0 = r11;
        r0 = (android.widget.AdapterView.AdapterContextMenuInfo) r0;
        r1 = r0;
        r4 = r1.position;
        if (r4 < 0) goto L_0x0013;
    L_0x0009:
        r6 = r10.mAdapter;
        r6 = r6.mItems;
        r6 = r6.size();
        if (r4 < r6) goto L_0x0015;
    L_0x0013:
        r6 = r9;
    L_0x0014:
        return r6;
    L_0x0015:
        r6 = r10.mAdapter;
        r6 = r6.mItems;
        r3 = r6.get(r4);
        r3 = (com.techno.gallery.Item) r3;
        r5 = r3.mFirstImageUri;
        if (r5 == 0) goto L_0x0037;
    L_0x0023:
        r6 = r3.mBucketId;
        if (r6 == 0) goto L_0x0037;
    L_0x0027:
        r6 = r5.buildUpon();
        r7 = "bucketId";
        r8 = r3.mBucketId;
        r6 = r6.appendQueryParameter(r7, r8);
        r5 = r6.build();
    L_0x0037:
        r2 = new android.content.Intent;
        r6 = "android.intent.action.VIEW";
        r2.<init>(r6, r5);
        r6 = "slideshow";
        r2.putExtra(r6, r9);
        r10.startActivity(r2);
        r6 = r9;
        goto L_0x0014;
    }

    private boolean onViewClicked(android.view.ContextMenu.ContextMenuInfo r4) {
        r3 = this;
        r0 = r4;
        r0 = (android.widget.AdapterView.AdapterContextMenuInfo) r0;
        r1 = r0;
        r2 = r1.position;
        r3.launchFolderGallery(r2);
        r2 = 1;
        return r2;
    }

    private static void placeImage(android.graphics.Bitmap r6, android.graphics.Canvas r7, android.graphics.Paint r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15) {
        r1 = r15 / 2;
        r4 = r1 * 2;
        r0 = r15 - r4;
        r4 = r9 + r10;
        r4 = r4 * r0;
        r2 = r4 - r13;
        r4 = r11 + r12;
        r4 = r4 * r1;
        r3 = r4 - r14;
        r4 = (float) r2;
        r5 = (float) r3;
        r7.drawBitmap(r6, r4, r5, r8);
        return;
    }

    private void rebake(boolean r2, boolean r3) {
        r1 = this;
        r0 = r1.mUnmounted;
        if (r2 != r0) goto L_0x0009;
    L_0x0004:
        r0 = r1.mScanning;
        if (r3 != r0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r1.abortWorker();
        r1.mUnmounted = r2;
        r1.mScanning = r3;
        r0 = r1.mScanning;
        r1.updateScanningDialog(r0);
        r0 = r1.mUnmounted;
        if (r0 == 0) goto L_0x001d;
    L_0x0019:
        r1.showNoImagesView();
        goto L_0x0008;
    L_0x001d:
        r1.hideNoImagesView();
        r1.startWorker();
        goto L_0x0008;
    }

    private void showNoImagesView() {
        r3 = this;
        r1 = r3.mNoImagesView;
        if (r1 != 0) goto L_0x0020;
    L_0x0004:
        r1 = 2131427390; // 0x7f0b003e float:1.8476395E38 double:1.05306505E-314;
        r0 = r3.findViewById(r1);
        r0 = (android.view.ViewGroup) r0;
        r1 = r3.getLayoutInflater();
        r2 = 2130903050; // 0x7f03000a float:1.7412907E38 double:1.0528059916E-314;
        r1.inflate(r2, r0);
        r1 = 2131427392; // 0x7f0b0040 float:1.8476399E38 double:1.053065051E-314;
        r1 = r3.findViewById(r1);
        r3.mNoImagesView = r1;
    L_0x0020:
        r1 = r3.mNoImagesView;
        r2 = 0;
        r1.setVisibility(r2);
        return;
    }

    private void startWorker() {
        r2 = this;
        r0 = 0;
        r2.mAbort = r0;
        r0 = new com.techno.gallery.GalleryPicker$7;
        r1 = "GalleryPicker Worker";
        r0.<init>(r2, r1);
        r2.mWorkerThread = r0;
        r0 = com.techno.gallery.BitmapManager.instance();
        r1 = r2.mWorkerThread;
        r0.allowThreadDecoding(r1);
        r0 = r2.mWorkerThread;
        r0.start();
        return;
    }

    private void unloadDrawable() {
        r1 = this;
        r0 = 0;
        r1.mFrameGalleryMask = r0;
        r1.mCellOutline = r0;
        r1.mVideoOverlay = r0;
        return;
    }

    private void updateItem(com.techno.gallery.Item r2) {
        r1 = this;
        r0 = r1.mAdapter;
        r0 = r0.getCount();
        if (r0 != 0) goto L_0x000b;
    L_0x0008:
        r1.hideNoImagesView();
    L_0x000b:
        r0 = r1.mAdapter;
        r0.addItem(r2);
        r0 = r1.mAdapter;
        r0.updateDisplay();
        return;
    }

    private void updateThumbBitmap(com.techno.gallery.Item r2, android.graphics.Bitmap r3) {
        r1 = this;
        r2.setThumbBitmap(r3);
        r0 = r1.mAdapter;
        r0.updateDisplay();
        return;
    }

    private void workerRun() {
        r2 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r2.checkScanning();
        r1 = r2.mAbort;
        if (r1 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r2.checkImageList(r0);
        r1 = r2.mAbort;
        if (r1 != 0) goto L_0x000c;
    L_0x0014:
        r2.checkBucketIds(r0);
        r1 = r2.mAbort;
        if (r1 != 0) goto L_0x000c;
    L_0x001b:
        r2.checkThumbBitmap(r0);
        r1 = r2.mAbort;
        if (r1 != 0) goto L_0x000c;
    L_0x0022:
        r2.checkLowStorage();
        goto L_0x000c;
    }

    public void onCreate(android.os.Bundle r3) {
        r2 = this;
        super.onCreate(r3);
        r0 = 2130903049; // 0x7f030009 float:1.7412905E38 double:1.052805991E-314;
        r2.setContentView(r0);
        r0 = 2131427391; // 0x7f0b003f float:1.8476397E38 double:1.0530650505E-314;
        r0 = r2.findViewById(r0);
        r0 = (android.widget.GridView) r0;
        r2.mGridView = r0;
        r0 = r2.mGridView;
        r1 = new com.techno.gallery.GalleryPicker$1;
        r1.<init>(r2);
        r0.setOnItemClickListener(r1);
        r0 = r2.mGridView;
        r1 = new com.techno.gallery.GalleryPicker$2;
        r1.<init>(r2);
        r0.setOnCreateContextMenuListener(r1);
        r0 = new com.techno.gallery.GalleryPicker$3;
        r0.<init>(r2);
        r2.mReceiver = r0;
        r0 = new com.techno.gallery.GalleryPicker$4;
        r1 = r2.mHandler;
        r0.<init>(r2, r1);
        r2.mDbObserver = r0;
        com.techno.gallery.ImageManager.ensureOSXCompatibleFolder();
        return;
    }

    public boolean onCreateOptionsMenu(android.view.Menu r4) {
        r3 = this;
        r2 = 0;
        super.onCreateOptionsMenu(r4);
        com.techno.gallery.MenuHelper.addCaptureMenuItems(r4, r3);
        r0 = 5;
        r1 = 2131296373; // 0x7f090075 float:1.821066E38 double:1.053000319E-314;
        r0 = r4.add(r2, r2, r0, r1);
        r1 = new com.techno.gallery.GalleryPicker$14;
        r1.<init>(r3);
        r0 = r0.setOnMenuItemClickListener(r1);
        r1 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r0 = r0.setAlphabeticShortcut(r1);
        r1 = 17301577; // 0x1080049 float:2.497946E-38 double:8.548115E-317;
        r0.setIcon(r1);
        r0 = 1;
        return r0;
    }

    public void onStart() {
        r6 = this;
        r5 = 0;
        super.onStart();
        r1 = new com.techno.gallery.GalleryPickerAdapter;
        r2 = r6.getLayoutInflater();
        r1.<init>(r2);
        r6.mAdapter = r1;
        r1 = r6.mGridView;
        r2 = r6.mAdapter;
        r1.setAdapter(r2);
        r0 = new android.content.IntentFilter;
        r0.<init>();
        r1 = "android.intent.action.MEDIA_MOUNTED";
        r0.addAction(r1);
        r1 = "android.intent.action.MEDIA_UNMOUNTED";
        r0.addAction(r1);
        r1 = "android.intent.action.MEDIA_SCANNER_STARTED";
        r0.addAction(r1);
        r1 = "android.intent.action.MEDIA_SCANNER_FINISHED";
        r0.addAction(r1);
        r1 = "android.intent.action.MEDIA_EJECT";
        r0.addAction(r1);
        r1 = "file";
        r0.addDataScheme(r1);
        r1 = r6.mReceiver;
        r6.registerReceiver(r1, r0);
        r1 = r6.getContentResolver();
        r2 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        r3 = 1;
        r4 = r6.mDbObserver;
        r1.registerContentObserver(r2, r3, r4);
        r6.mUnmounted = r5;
        r6.mScanning = r5;
        r6.startWorker();
        return;
    }

    public void onStop() {
        r3 = this;
        r2 = 0;
        super.onStop();
        r3.abortWorker();
        r0 = r3.mReceiver;
        r3.unregisterReceiver(r0);
        r0 = r3.getContentResolver();
        r1 = r3.mDbObserver;
        r0.unregisterContentObserver(r1);
        r3.mAdapter = r2;
        r0 = r3.mGridView;
        r0.setAdapter(r2);
        r3.unloadDrawable();
        return;
    }

    public void updateScanningDialog(boolean r6) {
        r5 = this;
        r4 = 0;
        r3 = 1;
        r1 = r5.mMediaScanningDialog;
        if (r1 == 0) goto L_0x0014;
    L_0x0006:
        r0 = r3;
    L_0x0007:
        if (r0 != r6) goto L_0x0017;
    L_0x0009:
        r1 = r5.mAdapter;
        r1 = r1.mItems;
        r1 = r1.size();
        if (r1 != 0) goto L_0x0017;
    L_0x0013:
        return;
    L_0x0014:
        r1 = 0;
        r0 = r1;
        goto L_0x0007;
    L_0x0017:
        if (r0 == 0) goto L_0x0021;
    L_0x0019:
        r1 = r5.mMediaScanningDialog;
        r1.cancel();
        r5.mMediaScanningDialog = r4;
        goto L_0x0013;
    L_0x0021:
        if (r6 == 0) goto L_0x0013;
    L_0x0023:
        r1 = r5.mAdapter;
        r1 = r1.mItems;
        r1 = r1.size();
        if (r1 != 0) goto L_0x0013;
    L_0x002d:
        r1 = r5.getResources();
        r2 = 2131296270; // 0x7f09000e float:1.8210452E38 double:1.053000268E-314;
        r1 = r1.getString(r2);
        r1 = android.app.ProgressDialog.show(r5, r4, r1, r3, r3);
        r5.mMediaScanningDialog = r1;
        goto L_0x0013;
    }
}