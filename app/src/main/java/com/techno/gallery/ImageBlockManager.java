package com.techno.gallery;

/* compiled from: GridViewSpecial */
class ImageBlockManager {
    private static final int CACHE_ROWS = 30;
    static final int REQUESTS_HIGH = 6;
    static final int REQUESTS_LOW = 3;
    private static final java.lang.String TAG = "ImageBlockManager";
    android.graphics.Paint mBackgroundPaint;
    private final int mBlockHeight;
    private final int mBlockWidth;
    private final java.util.HashMap<java.lang.Integer, com.techno.gallery.ImageBlockManager.ImageBlock> mCache;
    private final int mColumns;
    private final int mCount;
    private final com.techno.gallery.GridViewSpecial.DrawAdapter mDrawAdapter;
    private android.graphics.Bitmap mEmptyBitmap;
    private int mEndRow;
    private final android.os.Handler mHandler;
    private final com.techno.gallery.gallery.IImageList mImageList;
    private final com.techno.gallery.ImageLoader mLoader;
    private final android.graphics.Bitmap mOutline;
    int mPendingRequest;
    private final java.lang.Runnable mRedrawCallback;
    private final int mRows;
    private final com.techno.gallery.GridViewSpecial.LayoutSpec mSpec;
    private int mStartRow;

    ImageBlockManager(android.os.Handler r4, java.lang.Runnable r5, com.techno.gallery.gallery.IImageList r6, com.techno.gallery.ImageLoader r7, com.techno.gallery.GridViewSpecial.DrawAdapter r8, com.techno.gallery.GridViewSpecial.LayoutSpec r9, int r10, int r11, android.graphics.Bitmap r12) {
        r3 = this;
        r2 = 0;
        r3.<init>();
        r3.mStartRow = r2;
        r3.mEndRow = r2;
        r3.mHandler = r4;
        r3.mRedrawCallback = r5;
        r3.mImageList = r6;
        r3.mLoader = r7;
        r3.mDrawAdapter = r8;
        r3.mSpec = r9;
        r3.mColumns = r10;
        r3.mBlockWidth = r11;
        r3.mOutline = r12;
        r0 = r3.mSpec;
        r0 = r0.mCellSpacing;
        r1 = r3.mSpec;
        r1 = r1.mCellHeight;
        r0 = r0 + r1;
        r3.mBlockHeight = r0;
        r0 = r6.getCount();
        r3.mCount = r0;
        r0 = r3.mCount;
        r1 = r3.mColumns;
        r0 = r0 + r1;
        r1 = 1;
        r0 = r0 - r1;
        r1 = r3.mColumns;
        r0 = r0 / r1;
        r3.mRows = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        r3.mCache = r0;
        r3.mPendingRequest = r2;
        r3.initGraphics();
        return;
    }

    static /* synthetic */ int access$100(com.techno.gallery.ImageBlockManager r1) {
        r0 = r1.mBlockWidth;
        return r0;
    }

    static /* synthetic */ com.techno.gallery.ImageLoader access$1000(com.techno.gallery.ImageBlockManager r1) {
        r0 = r1.mLoader;
        return r0;
    }

    static /* synthetic */ com.techno.gallery.GridViewSpecial.LayoutSpec access$1100(com.techno.gallery.ImageBlockManager r1) {
        r0 = r1.mSpec;
        return r0;
    }

    static /* synthetic */ java.lang.Runnable access$1200(com.techno.gallery.ImageBlockManager r1) {
        r0 = r1.mRedrawCallback;
        return r0;
    }

    static /* synthetic */ void access$1300(com.techno.gallery.ImageBlockManager r0) {
        r0.continueLoading();
        return;
    }

    static /* synthetic */ com.techno.gallery.GridViewSpecial.DrawAdapter access$1400(com.techno.gallery.ImageBlockManager r1) {
        r0 = r1.mDrawAdapter;
        return r0;
    }

    static /* synthetic */ android.graphics.Bitmap access$1500(com.techno.gallery.ImageBlockManager r1) {
        r0 = r1.mOutline;
        return r0;
    }

    static /* synthetic */ android.graphics.Bitmap access$1600(com.techno.gallery.ImageBlockManager r1) {
        r0 = r1.mEmptyBitmap;
        return r0;
    }

    static /* synthetic */ int access$200(com.techno.gallery.ImageBlockManager r1) {
        r0 = r1.mBlockHeight;
        return r0;
    }

    static /* synthetic */ int access$300(com.techno.gallery.ImageBlockManager r1) {
        r0 = r1.mStartRow;
        return r0;
    }

    static /* synthetic */ int access$400(com.techno.gallery.ImageBlockManager r1) {
        r0 = r1.mEndRow;
        return r0;
    }

    static /* synthetic */ int access$500(com.techno.gallery.ImageBlockManager r1, int r2) {
        r0 = r1.numColumns(r2);
        return r0;
    }

    static /* synthetic */ int access$600(com.techno.gallery.ImageBlockManager r1) {
        r0 = r1.mColumns;
        return r0;
    }

    static /* synthetic */ com.techno.gallery.gallery.IImageList access$700(com.techno.gallery.ImageBlockManager r1) {
        r0 = r1.mImageList;
        return r0;
    }

    static /* synthetic */ android.os.Handler access$900(com.techno.gallery.ImageBlockManager r1) {
        r0 = r1.mHandler;
        return r0;
    }

    private void clearLoaderQueue() {
        r10 = this;
        r8 = r10.mLoader;
        r7 = r8.clearQueue();
        r0 = r7;
        r4 = r0.length;
        r3 = 0;
    L_0x0009:
        if (r3 >= r4) goto L_0x0030;
    L_0x000b:
        r5 = r0[r3];
        r8 = r10.mColumns;
        r6 = r5 / r8;
        r8 = r10.mColumns;
        r8 = r8 * r6;
        r2 = r5 - r8;
        r8 = r10.mCache;
        r9 = java.lang.Integer.valueOf(r6);
        r1 = r8.get(r9);
        r1 = (com.techno.gallery.ImageBlockManager.ImageBlock) r1;
        if (r1 == 0) goto L_0x002e;
    L_0x0024:
        r8 = 1;
    L_0x0025:
        com.techno.gallery.Util.Assert(r8);
        r1.cancelRequest(r2);
        r3 = r3 + 1;
        goto L_0x0009;
    L_0x002e:
        r8 = 0;
        goto L_0x0025;
    L_0x0030:
        return;
    }

    private void continueLoading() {
        r8 = this;
        r5 = r8.mPendingRequest;
        r6 = 3;
        if (r5 < r6) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r3 = r8.mStartRow;
    L_0x0008:
        r5 = r8.mEndRow;
        if (r3 >= r5) goto L_0x0015;
    L_0x000c:
        r5 = r8.scanOne(r3);
        if (r5 != 0) goto L_0x0005;
    L_0x0012:
        r3 = r3 + 1;
        goto L_0x0008;
    L_0x0015:
        r5 = 30;
        r6 = r8.mEndRow;
        r7 = r8.mStartRow;
        r6 = r6 - r7;
        r5 = r5 - r6;
        r4 = r5 / 2;
        r2 = 1;
    L_0x0020:
        if (r2 > r4) goto L_0x0005;
    L_0x0022:
        r5 = r8.mEndRow;
        r6 = 1;
        r5 = r5 - r6;
        r0 = r5 + r2;
        r5 = r8.mStartRow;
        r1 = r5 - r2;
        r5 = r8.mRows;
        if (r0 < r5) goto L_0x0032;
    L_0x0030:
        if (r1 < 0) goto L_0x0005;
    L_0x0032:
        r5 = r8.mRows;
        if (r0 >= r5) goto L_0x003c;
    L_0x0036:
        r5 = r8.scanOne(r0);
        if (r5 != 0) goto L_0x0005;
    L_0x003c:
        if (r1 < 0) goto L_0x0044;
    L_0x003e:
        r5 = r8.scanOne(r1);
        if (r5 != 0) goto L_0x0005;
    L_0x0044:
        r2 = r2 + 1;
        goto L_0x0020;
    }

    private void drawEmptyBlock(android.graphics.Canvas r11, int r12, int r13, int r14) {
        r10 = this;
        r1 = (float) r12;
        r2 = (float) r13;
        r0 = r10.mBlockWidth;
        r0 = r0 + r12;
        r3 = (float) r0;
        r0 = r10.mBlockHeight;
        r0 = r0 + r13;
        r4 = (float) r0;
        r5 = r10.mBackgroundPaint;
        r0 = r11;
        r0.drawRect(r1, r2, r3, r4, r5);
        r0 = r10.mSpec;
        r0 = r0.mLeftEdgePadding;
        r8 = r12 + r0;
        r0 = r10.mSpec;
        r0 = r0.mCellSpacing;
        r9 = r13 + r0;
        r6 = r10.numColumns(r14);
        r7 = 0;
    L_0x0021:
        if (r7 >= r6) goto L_0x0038;
    L_0x0023:
        r0 = r10.mEmptyBitmap;
        r1 = (float) r8;
        r2 = (float) r9;
        r3 = 0;
        r11.drawBitmap(r0, r1, r2, r3);
        r0 = r10.mSpec;
        r0 = r0.mCellWidth;
        r1 = r10.mSpec;
        r1 = r1.mCellSpacing;
        r0 = r0 + r1;
        r8 = r8 + r0;
        r7 = r7 + 1;
        goto L_0x0021;
    L_0x0038:
        return;
    }

    private com.techno.gallery.ImageBlockManager.ImageBlock getEmptyBlock() {
        r7 = this;
        r5 = r7.mCache;
        r5 = r5.size();
        r6 = 30;
        if (r5 >= r6) goto L_0x0010;
    L_0x000a:
        r5 = new com.techno.gallery.ImageBlockManager$ImageBlock;
        r5.<init>(r7);
    L_0x000f:
        return r5;
    L_0x0010:
        r0 = -1;
        r1 = -1;
        r5 = r7.mCache;
        r5 = r5.keySet();
        r3 = r5.iterator();
    L_0x001c:
        r5 = r3.hasNext();
        if (r5 == 0) goto L_0x0057;
    L_0x0022:
        r5 = r3.next();
        r5 = (java.lang.Integer) r5;
        r4 = r5.intValue();
        r5 = r7.mCache;
        r6 = java.lang.Integer.valueOf(r4);
        r5 = r5.get(r6);
        r5 = (com.techno.gallery.ImageBlockManager.ImageBlock) r5;
        r5 = r5.hasPendingRequests();
        if (r5 != 0) goto L_0x001c;
    L_0x003e:
        r2 = 0;
        r5 = r7.mEndRow;
        if (r4 < r5) goto L_0x004e;
    L_0x0043:
        r5 = r7.mEndRow;
        r5 = r4 - r5;
        r2 = r5 + 1;
    L_0x0049:
        if (r2 <= r0) goto L_0x001c;
    L_0x004b:
        r0 = r2;
        r1 = r4;
        goto L_0x001c;
    L_0x004e:
        r5 = r7.mStartRow;
        if (r4 >= r5) goto L_0x001c;
    L_0x0052:
        r5 = r7.mStartRow;
        r2 = r5 - r4;
        goto L_0x0049;
    L_0x0057:
        r5 = r7.mCache;
        r6 = java.lang.Integer.valueOf(r1);
        r7 = r5.remove(r6);
        r7 = (com.techno.gallery.ImageBlockManager.ImageBlock) r7;
        r5 = r7;
        goto L_0x000f;
    }

    private void initGraphics() {
        r6 = this;
        r5 = 0;
        r4 = 221; // 0xdd float:3.1E-43 double:1.09E-321;
        r1 = new android.graphics.Paint;
        r1.<init>();
        r6.mBackgroundPaint = r1;
        r1 = r6.mBackgroundPaint;
        r2 = android.graphics.Paint.Style.FILL;
        r1.setStyle(r2);
        r1 = r6.mBackgroundPaint;
        r2 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r1.setColor(r2);
        r1 = r6.mSpec;
        r1 = r1.mCellWidth;
        r2 = r6.mSpec;
        r2 = r2.mCellHeight;
        r3 = android.graphics.Bitmap.Config.RGB_565;
        r1 = android.graphics.Bitmap.createBitmap(r1, r2, r3);
        r6.mEmptyBitmap = r1;
        r0 = new android.graphics.Canvas;
        r1 = r6.mEmptyBitmap;
        r0.<init>(r1);
        r0.drawRGB(r4, r4, r4);
        r1 = r6.mOutline;
        r2 = 0;
        r0.drawBitmap(r1, r5, r5, r2);
        return;
    }

    private int numColumns(int r4) {
        r3 = this;
        r0 = r3.mColumns;
        r1 = r3.mCount;
        r2 = r3.mColumns;
        r2 = r2 * r4;
        r1 = r1 - r2;
        r0 = java.lang.Math.min(r0, r1);
        return r0;
    }

    private boolean scanOne(int r3) {
        r2 = this;
        r0 = r2.mPendingRequest;
        r1 = r2.tryToLoad(r3);
        r0 = r0 + r1;
        r2.mPendingRequest = r0;
        r0 = r2.mPendingRequest;
        r1 = 6;
        if (r0 < r1) goto L_0x0010;
    L_0x000e:
        r0 = 1;
    L_0x000f:
        return r0;
    L_0x0010:
        r0 = 0;
        goto L_0x000f;
    }

    private void startLoading() {
        r0 = this;
        r0.clearLoaderQueue();
        r0.continueLoading();
        return;
    }

    private int tryToLoad(int r4) {
        r3 = this;
        if (r4 < 0) goto L_0x0030;
    L_0x0002:
        r1 = r3.mRows;
        if (r4 >= r1) goto L_0x0030;
    L_0x0006:
        r1 = 1;
    L_0x0007:
        com.techno.gallery.Util.Assert(r1);
        r1 = r3.mCache;
        r2 = java.lang.Integer.valueOf(r4);
        r0 = r1.get(r2);
        r0 = (com.techno.gallery.ImageBlockManager.ImageBlock) r0;
        if (r0 != 0) goto L_0x002b;
    L_0x0018:
        r0 = r3.getEmptyBlock();
        r0.setRow(r4);
        r0.invalidate();
        r1 = r3.mCache;
        r2 = java.lang.Integer.valueOf(r4);
        r1.put(r2, r0);
    L_0x002b:
        r1 = r0.loadImages();
        return r1;
    L_0x0030:
        r1 = 0;
        goto L_0x0007;
    }

    public void doDraw(android.graphics.Canvas r8, int r9, int r10, int r11) {
        r7 = this;
        r6 = 0;
        r2 = r7.mBlockHeight;
        if (r11 >= 0) goto L_0x0012;
    L_0x0005:
        r4 = r11 - r2;
        r4 = r4 + 1;
        r4 = r4 / r2;
        r1 = r4;
    L_0x000b:
        r3 = r1 * r2;
        r4 = r11 + r10;
        if (r3 < r4) goto L_0x0016;
    L_0x0011:
        return;
    L_0x0012:
        r4 = r11 / r2;
        r1 = r4;
        goto L_0x000b;
    L_0x0016:
        r4 = r7.mCache;
        r5 = java.lang.Integer.valueOf(r1);
        r0 = r4.get(r5);
        r0 = (com.techno.gallery.ImageBlockManager.ImageBlock) r0;
        if (r0 == 0) goto L_0x002a;
    L_0x0024:
        r0.doDraw(r8, r6, r3);
    L_0x0027:
        r1 = r1 + 1;
        goto L_0x000b;
    L_0x002a:
        r7.drawEmptyBlock(r8, r6, r3, r1);
        goto L_0x0027;
    }

    public void invalidateImage(int r7) {
        r6 = this;
        r5 = 1;
        r3 = r6.mColumns;
        r2 = r7 / r3;
        r3 = r6.mColumns;
        r3 = r3 * r2;
        r1 = r7 - r3;
        r3 = r6.mCache;
        r4 = java.lang.Integer.valueOf(r2);
        r0 = r3.get(r4);
        r0 = (com.techno.gallery.ImageBlockManager.ImageBlock) r0;
        if (r0 != 0) goto L_0x0019;
    L_0x0018:
        return;
    L_0x0019:
        r3 = com.techno.gallery.ImageBlockManager.ImageBlock.access$000(r0);
        r4 = r5 << r1;
        r3 = r3 & r4;
        if (r3 == 0) goto L_0x0029;
    L_0x0022:
        r3 = r5 << r1;
        r3 = r3 ^ -1;
        com.techno.gallery.ImageBlockManager.ImageBlock.access$072(r0, r3);
    L_0x0029:
        r6.startLoading();
        goto L_0x0018;
    }

    public void recycle() {
        r3 = this;
        r2 = r3.mCache;
        r2 = r2.values();
        r1 = r2.iterator();
    L_0x000a:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x001a;
    L_0x0010:
        r0 = r1.next();
        r0 = (com.techno.gallery.ImageBlockManager.ImageBlock) r0;
        r0.recycle();
        goto L_0x000a;
    L_0x001a:
        r2 = r3.mCache;
        r2.clear();
        r2 = r3.mEmptyBitmap;
        r2.recycle();
        return;
    }

    public void setVisibleRows(int r2, int r3) {
        r1 = this;
        r0 = r1.mStartRow;
        if (r2 != r0) goto L_0x0008;
    L_0x0004:
        r0 = r1.mEndRow;
        if (r3 == r0) goto L_0x000f;
    L_0x0008:
        r1.mStartRow = r2;
        r1.mEndRow = r3;
        r1.startLoading();
    L_0x000f:
        return;
    }
}