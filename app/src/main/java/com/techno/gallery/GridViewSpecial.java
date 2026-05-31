package com.techno.gallery;

class GridViewSpecial extends android.view.View {
    private static final int CLICKING_FLAG = 2;
    public static final int INDEX_NONE = -1;
    private static final float MAX_FLING_VELOCITY = 2500.0f;
    public static final int OUTLINE_EMPTY = 0;
    public static final int OUTLINE_PRESSED = 1;
    public static final int OUTLINE_SELECTED = 2;
    private static final java.lang.String TAG = "GridViewSpecial";
    private static final int TAPPING_FLAG = 1;
    private com.techno.gallery.gallery.IImageList mAllImages;
    private int mBlockHeight;
    private final com.techno.gallery.GridViewSpecial.LayoutSpec[] mCellSizeChoices;
    private int mColumns;
    private int mCount;
    private int mCurrentPressState;
    private int mCurrentSelection;
    private com.techno.gallery.GridViewSpecial.DrawAdapter mDrawAdapter;
    private android.view.GestureDetector mGestureDetector;
    private final android.os.Handler mHandler;
    private com.techno.gallery.ImageBlockManager mImageBlockManager;
    private boolean mLayoutComplete;
    private com.techno.gallery.GridViewSpecial.Listener mListener;
    private com.techno.gallery.ImageLoader mLoader;
    private final java.lang.Runnable mLongPressCallback;
    private int mMaxScrollY;
    public android.graphics.Bitmap[] mOutline;
    private final java.lang.Runnable mRedrawCallback;
    private int mRows;
    private boolean mRunning;
    private android.widget.Scroller mScroller;
    private int mSizeChoice;
    private com.techno.gallery.GridViewSpecial.LayoutSpec mSpec;

    public GridViewSpecial(android.content.Context r9, android.util.AttributeSet r10) {
        r8 = this;
        r2 = 67;
        r7 = 8;
        r6 = 1;
        r5 = 0;
        r4 = 0;
        r8.<init>(r9, r10);
        r0 = 2;
        r0 = new com.techno.gallery.GridViewSpecial.LayoutSpec[r0];
        r1 = new com.techno.gallery.GridViewSpecial$LayoutSpec;
        r1.<init>(r2, r2, r7, r4);
        r0[r4] = r1;
        r1 = new com.techno.gallery.GridViewSpecial$LayoutSpec;
        r2 = 92;
        r3 = 92;
        r1.<init>(r2, r3, r7, r4);
        r0[r6] = r1;
        r8.mCellSizeChoices = r0;
        r0 = new android.os.Handler;
        r0.<init>();
        r8.mHandler = r0;
        r8.mListener = r5;
        r8.mDrawAdapter = r5;
        r0 = com.techno.gallery.ImageManager.emptyImageList();
        r8.mAllImages = r0;
        r8.mSizeChoice = r6;
        r8.mLayoutComplete = r4;
        r0 = -1;
        r8.mCurrentSelection = r0;
        r8.mCurrentPressState = r4;
        r8.mRunning = r4;
        r8.mScroller = r5;
        r0 = new com.techno.gallery.GridViewSpecial$1;
        r0.<init>(r8);
        r8.mRedrawCallback = r0;
        r0 = 3;
        r0 = new android.graphics.Bitmap[r0];
        r8.mOutline = r0;
        r0 = new com.techno.gallery.GridViewSpecial$2;
        r0.<init>(r8);
        r8.mLongPressCallback = r0;
        r8.init(r9);
        return;
    }

    static /* synthetic */ boolean access$100(com.techno.gallery.GridViewSpecial r1) {
        r0 = r1.canHandleEvent();
        return r0;
    }

    static /* synthetic */ android.widget.Scroller access$200(com.techno.gallery.GridViewSpecial r1) {
        r0 = r1.mScroller;
        return r0;
    }

    static /* synthetic */ android.widget.Scroller access$202(com.techno.gallery.GridViewSpecial r0, android.widget.Scroller r1) {
        r0.mScroller = r1;
        return r1;
    }

    static /* synthetic */ int access$300(com.techno.gallery.GridViewSpecial r1) {
        r0 = r1.mCount;
        return r0;
    }

    static /* synthetic */ int access$400(com.techno.gallery.GridViewSpecial r1) {
        r0 = r1.mScrollY;
        return r0;
    }

    static /* synthetic */ int access$500(com.techno.gallery.GridViewSpecial r1) {
        r0 = r1.mMaxScrollY;
        return r0;
    }

    static /* synthetic */ com.techno.gallery.GridViewSpecial.Listener access$600(com.techno.gallery.GridViewSpecial r1) {
        r0 = r1.mListener;
        return r0;
    }

    static /* synthetic */ int access$772(com.techno.gallery.GridViewSpecial r1, int r2) {
        r0 = r1.mCurrentPressState;
        r0 = r0 & r2;
        r1.mCurrentPressState = r0;
        return r0;
    }

    private boolean canHandleEvent() {
        r1 = this;
        r0 = r1.mRunning;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r1.mLayoutComplete;
        if (r0 == 0) goto L_0x000a;
    L_0x0008:
        r0 = 1;
    L_0x0009:
        return r0;
    L_0x000a:
        r0 = 0;
        goto L_0x0009;
    }

    private void ensureVisible(int r11) {
        r10 = this;
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r3 = 0;
        r7 = r10.getRectForPosition(r11);
        r8 = r10.getScrollY();
        r0 = r10.getHeight();
        r6 = r8 + r0;
        r0 = r7.bottom;
        if (r0 <= r6) goto L_0x0037;
    L_0x0015:
        r0 = new android.widget.Scroller;
        r1 = r10.getContext();
        r0.<init>(r1);
        r10.mScroller = r0;
        r0 = r10.mScroller;
        r1 = r10.mScrollX;
        r2 = r10.mScrollY;
        r4 = r7.bottom;
        r9 = r10.getHeight();
        r4 = r4 - r9;
        r9 = r10.mScrollY;
        r4 = r4 - r9;
        r0.startScroll(r1, r2, r3, r4, r5);
        r10.computeScroll();
    L_0x0036:
        return;
    L_0x0037:
        r0 = r7.top;
        if (r0 >= r8) goto L_0x0036;
    L_0x003b:
        r0 = new android.widget.Scroller;
        r1 = r10.getContext();
        r0.<init>(r1);
        r10.mScroller = r0;
        r0 = r10.mScroller;
        r1 = r10.mScrollX;
        r2 = r10.mScrollY;
        r4 = r7.top;
        r9 = r10.mScrollY;
        r4 = r4 - r9;
        r0.startScroll(r1, r2, r3, r4, r5);
        r10.computeScroll();
        goto L_0x0036;
    }

    private void generateOutlineBitmap() {
        r8 = this;
        r7 = 0;
        r5 = r8.mSpec;
        r4 = r5.mCellWidth;
        r5 = r8.mSpec;
        r2 = r5.mCellHeight;
        r3 = 0;
    L_0x000a:
        r5 = r8.mOutline;
        r5 = r5.length;
        if (r3 >= r5) goto L_0x001c;
    L_0x000f:
        r5 = r8.mOutline;
        r6 = android.graphics.Bitmap.Config.ARGB_8888;
        r6 = android.graphics.Bitmap.createBitmap(r4, r2, r6);
        r5[r3] = r6;
        r3 = r3 + 1;
        goto L_0x000a;
    L_0x001c:
        r5 = r8.getResources();
        r6 = 17301532; // 0x108001c float:2.4979333E-38 double:8.5480926E-317;
        r1 = r5.getDrawable(r6);
        r1.setBounds(r7, r7, r4, r2);
        r0 = new android.graphics.Canvas;
        r0.<init>();
        r5 = r8.mOutline;
        r5 = r5[r7];
        r0.setBitmap(r5);
        r5 = EMPTY_STATE_SET;
        r1.setState(r5);
        r1.draw(r0);
        r5 = r8.mOutline;
        r6 = 1;
        r5 = r5[r6];
        r0.setBitmap(r5);
        r5 = PRESSED_ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
        r1.setState(r5);
        r1.draw(r0);
        r5 = r8.mOutline;
        r6 = 2;
        r5 = r5[r6];
        r0.setBitmap(r5);
        r5 = ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
        r1.setState(r5);
        r1.draw(r0);
        return;
    }

    private void init(android.content.Context r5) {
        r4 = this;
        r3 = 1;
        r4.setVerticalScrollBarEnabled(r3);
        r0 = android.R.styleable.View;
        r0 = r5.obtainStyledAttributes(r0);
        r4.initializeScrollbars(r0);
        r0 = new android.view.GestureDetector;
        r1 = new com.techno.gallery.GridViewSpecial$MyGestureDetector;
        r2 = 0;
        r1.<init>(r4, r2);
        r0.<init>(r5, r1);
        r4.mGestureDetector = r0;
        r4.setFocusableInTouchMode(r3);
        return;
    }

    private void moveDataWindow() {
        r6 = this;
        r5 = 1;
        r4 = 0;
        r2 = r6.mScrollY;
        r3 = r6.mSpec;
        r3 = r3.mCellSpacing;
        r2 = r2 - r3;
        r3 = r6.mBlockHeight;
        r1 = r2 / r3;
        r2 = r6.mScrollY;
        r3 = r6.getHeight();
        r2 = r2 + r3;
        r3 = r6.mSpec;
        r3 = r3.mCellSpacing;
        r2 = r2 - r3;
        r2 = r2 - r5;
        r3 = r6.mBlockHeight;
        r2 = r2 / r3;
        r0 = r2 + 1;
        r2 = r6.mRows;
        r2 = r2 - r5;
        r2 = java.lang.Math.min(r1, r2);
        r1 = java.lang.Math.max(r2, r4);
        r2 = r6.mRows;
        r2 = java.lang.Math.min(r0, r2);
        r0 = java.lang.Math.max(r2, r4);
        r2 = r6.mImageBlockManager;
        r2.setVisibleRows(r1, r0);
        return;
    }

    private void paintDecoration(android.graphics.Canvas r14) {
        r13 = this;
        r6 = 1;
        r5 = 0;
        r0 = r13.mDrawAdapter;
        r0 = r0.needsDecoration();
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r0 = r13.mScrollY;
        r1 = r13.mSpec;
        r1 = r1.mCellSpacing;
        r0 = r0 - r1;
        r1 = r13.mBlockHeight;
        r12 = r0 / r1;
        r0 = r13.mScrollY;
        r1 = r13.getHeight();
        r0 = r0 + r1;
        r1 = r13.mSpec;
        r1 = r1.mCellSpacing;
        r0 = r0 - r1;
        r0 = r0 - r6;
        r1 = r13.mBlockHeight;
        r0 = r0 / r1;
        r8 = r0 + 1;
        r0 = r13.mRows;
        r0 = r0 - r6;
        r0 = java.lang.Math.min(r12, r0);
        r12 = java.lang.Math.max(r0, r5);
        r0 = r13.mRows;
        r0 = java.lang.Math.min(r8, r0);
        r8 = java.lang.Math.max(r0, r5);
        r0 = r13.mColumns;
        r11 = r12 * r0;
        r0 = r13.mColumns;
        r0 = r0 * r8;
        r1 = r13.mCount;
        r7 = java.lang.Math.min(r0, r1);
        r0 = r13.mSpec;
        r3 = r0.mLeftEdgePadding;
        r0 = r13.mSpec;
        r0 = r0.mCellSpacing;
        r1 = r13.mBlockHeight;
        r1 = r1 * r12;
        r4 = r0 + r1;
        r10 = 0;
        r9 = r11;
    L_0x0059:
        if (r9 >= r7) goto L_0x000a;
    L_0x005b:
        r0 = r13.mAllImages;
        r2 = r0.getImageAt(r9);
        r0 = r13.mDrawAdapter;
        r1 = r13.mSpec;
        r5 = r1.mCellWidth;
        r1 = r13.mSpec;
        r6 = r1.mCellHeight;
        r1 = r14;
        r0.drawDecoration(r1, r2, r3, r4, r5, r6);
        r10 = r10 + 1;
        r0 = r13.mColumns;
        if (r10 != r0) goto L_0x0080;
    L_0x0075:
        r0 = r13.mSpec;
        r3 = r0.mLeftEdgePadding;
        r0 = r13.mBlockHeight;
        r4 = r4 + r0;
        r10 = 0;
    L_0x007d:
        r9 = r9 + 1;
        goto L_0x0059;
    L_0x0080:
        r0 = r13.mSpec;
        r0 = r0.mCellWidth;
        r1 = r13.mSpec;
        r1 = r1.mCellSpacing;
        r0 = r0 + r1;
        r3 = r3 + r0;
        goto L_0x007d;
    }

    private void paintSelection(android.graphics.Canvas r12) {
        r11 = this;
        r7 = r11.mCurrentSelection;
        r8 = -1;
        if (r7 != r8) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r7 = r11.mCurrentSelection;
        r8 = r11.mColumns;
        r2 = r7 / r8;
        r7 = r11.mCurrentSelection;
        r8 = r11.mColumns;
        r8 = r8 * r2;
        r0 = r7 - r8;
        r7 = r11.mSpec;
        r3 = r7.mCellSpacing;
        r7 = r11.mSpec;
        r1 = r7.mLeftEdgePadding;
        r7 = r11.mSpec;
        r7 = r7.mCellWidth;
        r7 = r7 + r3;
        r7 = r7 * r0;
        r5 = r1 + r7;
        r7 = r11.mBlockHeight;
        r7 = r7 * r2;
        r6 = r3 + r7;
        r4 = 2;
        r7 = r11.mCurrentPressState;
        if (r7 == 0) goto L_0x002e;
    L_0x002d:
        r4 = 1;
    L_0x002e:
        r7 = r11.mOutline;
        r7 = r7[r4];
        r8 = (float) r5;
        r9 = (float) r6;
        r10 = 0;
        r12.drawBitmap(r7, r8, r9, r10);
        goto L_0x0005;
    }

    public void computeScroll() {
        r3 = this;
        r1 = r3.mScroller;
        if (r1 == 0) goto L_0x001e;
    L_0x0004:
        r1 = r3.mScroller;
        r0 = r1.computeScrollOffset();
        r1 = 0;
        r2 = r3.mScroller;
        r2 = r2.getCurrY();
        r3.scrollTo(r1, r2);
        if (r0 == 0) goto L_0x001a;
    L_0x0016:
        r3.invalidate();
    L_0x0019:
        return;
    L_0x001a:
        r1 = 0;
        r3.mScroller = r1;
        goto L_0x0019;
    L_0x001e:
        super.computeScroll();
        goto L_0x0019;
    }

    int computeSelectedIndex(float r10, float r11) {
        r9 = this;
        r4 = (int) r10;
        r5 = (int) r11;
        r6 = r9.mSpec;
        r3 = r6.mCellSpacing;
        r6 = r9.mSpec;
        r1 = r6.mLeftEdgePadding;
        r6 = r9.mScrollY;
        r6 = r6 + r5;
        r6 = r6 - r3;
        r7 = r9.mSpec;
        r7 = r7.mCellHeight;
        r7 = r7 + r3;
        r2 = r6 / r7;
        r6 = r9.mColumns;
        r7 = 1;
        r6 = r6 - r7;
        r7 = r4 - r1;
        r8 = r9.mSpec;
        r8 = r8.mCellWidth;
        r8 = r8 + r3;
        r7 = r7 / r8;
        r0 = java.lang.Math.min(r6, r7);
        r6 = r9.mColumns;
        r6 = r6 * r2;
        r6 = r6 + r0;
        return r6;
    }

    protected int computeVerticalScrollRange() {
        r2 = this;
        r0 = r2.mMaxScrollY;
        r1 = r2.getHeight();
        r0 = r0 + r1;
        return r0;
    }

    public int getCurrentSelection() {
        r1 = this;
        r0 = r1.mCurrentSelection;
        return r0;
    }

    android.graphics.Rect getRectForPosition(int r9) {
        r8 = this;
        r4 = r8.mColumns;
        r2 = r9 / r4;
        r4 = r8.mColumns;
        r4 = r4 * r2;
        r0 = r9 - r4;
        r4 = r8.mSpec;
        r4 = r4.mLeftEdgePadding;
        r5 = r8.mSpec;
        r5 = r5.mCellWidth;
        r6 = r8.mSpec;
        r6 = r6.mCellSpacing;
        r5 = r5 + r6;
        r5 = r5 * r0;
        r1 = r4 + r5;
        r4 = r8.mBlockHeight;
        r3 = r2 * r4;
        r4 = new android.graphics.Rect;
        r5 = r8.mSpec;
        r5 = r5.mCellWidth;
        r5 = r5 + r1;
        r6 = r8.mSpec;
        r6 = r6.mCellSpacing;
        r5 = r5 + r6;
        r6 = r8.mSpec;
        r6 = r6.mCellHeight;
        r6 = r6 + r3;
        r7 = r8.mSpec;
        r7 = r7.mCellSpacing;
        r6 = r6 + r7;
        r4.<init>(r1, r3, r5, r6);
        return r4;
    }

    public void invalidateImage(int r2) {
        r1 = this;
        r0 = -1;
        if (r2 == r0) goto L_0x0008;
    L_0x0003:
        r0 = r1.mImageBlockManager;
        r0.invalidateImage(r2);
    L_0x0008:
        return;
    }

    public void onDraw(android.graphics.Canvas r5) {
        r4 = this;
        super.onDraw(r5);
        r0 = r4.canHandleEvent();
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r0 = r4.mImageBlockManager;
        r1 = r4.getWidth();
        r2 = r4.getHeight();
        r3 = r4.mScrollY;
        r0.doDraw(r5, r1, r2, r3);
        r4.paintDecoration(r5);
        r4.paintSelection(r5);
        r4.moveDataWindow();
        goto L_0x0009;
    }

    public boolean onKeyDown(int r10, android.view.KeyEvent r11) {
        r9 = this;
        r8 = 1;
        r4 = r9.canHandleEvent();
        if (r4 != 0) goto L_0x0009;
    L_0x0007:
        r4 = 0;
    L_0x0008:
        return r4;
    L_0x0009:
        r1 = r9.mCurrentSelection;
        r4 = -1;
        if (r1 == r4) goto L_0x005c;
    L_0x000e:
        switch(r10) {
            case 19: goto L_0x0036;
            case 20: goto L_0x003e;
            case 21: goto L_0x002b;
            case 22: goto L_0x0016;
            case 23: goto L_0x0049;
            default: goto L_0x0011;
        };
    L_0x0011:
        r4 = super.onKeyDown(r10, r11);
        goto L_0x0008;
    L_0x0016:
        r4 = r9.mCount;
        r4 = r4 - r8;
        if (r1 == r4) goto L_0x0026;
    L_0x001b:
        r4 = r9.mColumns;
        r4 = r1 % r4;
        r5 = r9.mColumns;
        r5 = r5 - r8;
        if (r4 >= r5) goto L_0x0026;
    L_0x0024:
        r1 = r1 + 1;
    L_0x0026:
        r9.setSelectedIndex(r1);
        r4 = r8;
        goto L_0x0008;
    L_0x002b:
        if (r1 <= 0) goto L_0x0026;
    L_0x002d:
        r4 = r9.mColumns;
        r4 = r1 % r4;
        if (r4 == 0) goto L_0x0026;
    L_0x0033:
        r1 = r1 + -1;
        goto L_0x0026;
    L_0x0036:
        r4 = r9.mColumns;
        if (r1 < r4) goto L_0x0026;
    L_0x003a:
        r4 = r9.mColumns;
        r1 = r1 - r4;
        goto L_0x0026;
    L_0x003e:
        r4 = r9.mCount;
        r4 = r4 - r8;
        r5 = r9.mColumns;
        r5 = r5 + r1;
        r1 = java.lang.Math.min(r4, r5);
        goto L_0x0026;
    L_0x0049:
        r4 = r9.mCurrentPressState;
        r4 = r4 | 2;
        r9.mCurrentPressState = r4;
        r4 = r9.mHandler;
        r5 = r9.mLongPressCallback;
        r6 = android.view.ViewConfiguration.getLongPressTimeout();
        r6 = (long) r6;
        r4.postDelayed(r5, r6);
        goto L_0x0026;
    L_0x005c:
        switch(r10) {
            case 19: goto L_0x0064;
            case 20: goto L_0x0064;
            case 21: goto L_0x0064;
            case 22: goto L_0x0064;
            default: goto L_0x005f;
        };
    L_0x005f:
        r4 = super.onKeyDown(r10, r11);
        goto L_0x0008;
    L_0x0064:
        r4 = r9.mScrollY;
        r5 = r9.mSpec;
        r5 = r5.mCellSpacing;
        r4 = r4 - r5;
        r5 = r9.mBlockHeight;
        r2 = r4 / r5;
        r4 = r9.mColumns;
        r3 = r2 * r4;
        r0 = r9.getRectForPosition(r3);
        r4 = r0.top;
        r5 = r9.getScrollY();
        if (r4 >= r5) goto L_0x0082;
    L_0x007f:
        r4 = r9.mColumns;
        r3 = r3 + r4;
    L_0x0082:
        r4 = r9.mCount;
        r4 = r4 - r8;
        r3 = java.lang.Math.min(r4, r3);
        r1 = r3;
        goto L_0x0026;
    }

    public boolean onKeyUp(int r3, android.view.KeyEvent r4) {
        r2 = this;
        r0 = r2.canHandleEvent();
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        r0 = 0;
    L_0x0007:
        return r0;
    L_0x0008:
        r0 = 23;
        if (r3 != r0) goto L_0x0025;
    L_0x000c:
        r0 = r2.mCurrentPressState;
        r0 = r0 & -3;
        r2.mCurrentPressState = r0;
        r2.invalidate();
        r0 = r2.mHandler;
        r1 = r2.mLongPressCallback;
        r0.removeCallbacks(r1);
        r0 = r2.mListener;
        r1 = r2.mCurrentSelection;
        r0.onImageClicked(r1);
        r0 = 1;
        goto L_0x0007;
    L_0x0025:
        r0 = super.onKeyUp(r3, r4);
        goto L_0x0007;
    }

    public void onLayout(boolean r12, int r13, int r14, int r15, int r16) {
        r11 = this;
        super.onLayout(r12, r13, r14, r15, r16);
        r0 = r11.mRunning;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return;
    L_0x0008:
        r0 = r11.mCellSizeChoices;
        r1 = r11.mSizeChoice;
        r0 = r0[r1];
        r11.mSpec = r0;
        r8 = r15 - r13;
        r0 = r11.mSpec;
        r0 = r0.mCellWidth;
        r0 = r8 - r0;
        r1 = r11.mSpec;
        r1 = r1.mCellWidth;
        r2 = r11.mSpec;
        r2 = r2.mCellSpacing;
        r1 = r1 + r2;
        r0 = r0 / r1;
        r0 = r0 + 1;
        r11.mColumns = r0;
        r0 = r11.mSpec;
        r1 = r11.mColumns;
        r2 = 1;
        r1 = r1 - r2;
        r2 = r11.mSpec;
        r2 = r2.mCellSpacing;
        r1 = r1 * r2;
        r1 = r8 - r1;
        r2 = r11.mColumns;
        r3 = r11.mSpec;
        r3 = r3.mCellWidth;
        r2 = r2 * r3;
        r1 = r1 - r2;
        r1 = r1 / 2;
        r0.mLeftEdgePadding = r1;
        r0 = r11.mCount;
        r1 = r11.mColumns;
        r0 = r0 + r1;
        r1 = 1;
        r0 = r0 - r1;
        r1 = r11.mColumns;
        r0 = r0 / r1;
        r11.mRows = r0;
        r0 = r11.mSpec;
        r0 = r0.mCellSpacing;
        r1 = r11.mSpec;
        r1 = r1.mCellHeight;
        r0 = r0 + r1;
        r11.mBlockHeight = r0;
        r0 = r11.mSpec;
        r0 = r0.mCellSpacing;
        r1 = r11.mRows;
        r2 = r11.mBlockHeight;
        r1 = r1 * r2;
        r0 = r0 + r1;
        r1 = r16 - r14;
        r0 = r0 - r1;
        r11.mMaxScrollY = r0;
        r0 = 0;
        r1 = r11.mMaxScrollY;
        r2 = r11.mScrollY;
        r1 = java.lang.Math.min(r1, r2);
        r0 = java.lang.Math.max(r0, r1);
        r11.mScrollY = r0;
        r11.generateOutlineBitmap();
        r0 = r11.mImageBlockManager;
        if (r0 == 0) goto L_0x0080;
    L_0x007b:
        r0 = r11.mImageBlockManager;
        r0.recycle();
    L_0x0080:
        r0 = new com.techno.gallery.ImageBlockManager;
        r1 = r11.mHandler;
        r2 = r11.mRedrawCallback;
        r3 = r11.mAllImages;
        r4 = r11.mLoader;
        r5 = r11.mDrawAdapter;
        r6 = r11.mSpec;
        r7 = r11.mColumns;
        r9 = r11.mOutline;
        r10 = 0;
        r9 = r9[r10];
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9);
        r11.mImageBlockManager = r0;
        r0 = r11.mListener;
        r0.onLayoutComplete(r12);
        r11.moveDataWindow();
        r0 = 1;
        r11.mLayoutComplete = r0;
        goto L_0x0007;
    }

    public boolean onTouchEvent(android.view.MotionEvent r2) {
        r1 = this;
        r0 = r1.canHandleEvent();
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        r0 = 0;
    L_0x0007:
        return r0;
    L_0x0008:
        r0 = r2.getAction();
        switch(r0) {
            case 0: goto L_0x0016;
            case 1: goto L_0x0020;
            default: goto L_0x000f;
        };
    L_0x000f:
        r0 = r1.mGestureDetector;
        r0.onTouchEvent(r2);
        r0 = 1;
        goto L_0x0007;
    L_0x0016:
        r0 = r1.mCurrentPressState;
        r0 = r0 | 1;
        r1.mCurrentPressState = r0;
        r1.invalidate();
        goto L_0x000f;
    L_0x0020:
        r0 = r1.mCurrentPressState;
        r0 = r0 & -2;
        r1.mCurrentPressState = r0;
        r1.invalidate();
        goto L_0x000f;
    }

    public void scrollBy(int r3, int r4) {
        r2 = this;
        r0 = r2.mScrollX;
        r0 = r0 + r3;
        r1 = r2.mScrollY;
        r1 = r1 + r4;
        r2.scrollTo(r0, r1);
        return;
    }

    public void scrollTo(float r3) {
        r2 = this;
        r0 = 0;
        r1 = r2.mMaxScrollY;
        r1 = (float) r1;
        r1 = r1 * r3;
        r1 = java.lang.Math.round(r1);
        r2.scrollTo(r0, r1);
        return;
    }

    public void scrollTo(int r4, int r5) {
        r3 = this;
        r0 = 0;
        r1 = r3.mMaxScrollY;
        r1 = java.lang.Math.min(r1, r5);
        r5 = java.lang.Math.max(r0, r1);
        r0 = r3.mSpec;
        if (r0 == 0) goto L_0x001b;
    L_0x000f:
        r0 = r3.mListener;
        r1 = r3.mScrollY;
        r1 = (float) r1;
        r2 = r3.mMaxScrollY;
        r2 = (float) r2;
        r1 = r1 / r2;
        r0.onScroll(r1);
    L_0x001b:
        super.scrollTo(r4, r5);
        return;
    }

    public void scrollToImage(int r4) {
        r3 = this;
        r0 = r3.getRectForPosition(r4);
        r1 = 0;
        r2 = r0.top;
        r3.scrollTo(r1, r2);
        return;
    }

    public void scrollToVisible(int r7) {
        r6 = this;
        r5 = 0;
        r1 = r6.getRectForPosition(r7);
        r2 = r6.getScrollY();
        r3 = r6.getScrollY();
        r4 = r6.getHeight();
        r0 = r3 + r4;
        r3 = r1.bottom;
        if (r3 <= r0) goto L_0x0022;
    L_0x0017:
        r3 = r1.bottom;
        r4 = r6.getHeight();
        r3 = r3 - r4;
        r6.scrollTo(r5, r3);
    L_0x0021:
        return;
    L_0x0022:
        r3 = r1.top;
        if (r3 >= r2) goto L_0x0021;
    L_0x0026:
        r3 = r1.top;
        r6.scrollTo(r5, r3);
        goto L_0x0021;
    }

    public void setDrawAdapter(com.techno.gallery.GridViewSpecial.DrawAdapter r2) {
        r1 = this;
        r0 = r1.mRunning;
        if (r0 != 0) goto L_0x000b;
    L_0x0004:
        r0 = 1;
    L_0x0005:
        com.techno.gallery.Util.Assert(r0);
        r1.mDrawAdapter = r2;
        return;
    L_0x000b:
        r0 = 0;
        goto L_0x0005;
    }

    public void setImageList(com.techno.gallery.gallery.IImageList r2) {
        r1 = this;
        r0 = r1.mRunning;
        if (r0 != 0) goto L_0x0013;
    L_0x0004:
        r0 = 1;
    L_0x0005:
        com.techno.gallery.Util.Assert(r0);
        r1.mAllImages = r2;
        r0 = r1.mAllImages;
        r0 = r0.getCount();
        r1.mCount = r0;
        return;
    L_0x0013:
        r0 = 0;
        goto L_0x0005;
    }

    public void setListener(com.techno.gallery.GridViewSpecial.Listener r2) {
        r1 = this;
        r0 = r1.mRunning;
        if (r0 != 0) goto L_0x000b;
    L_0x0004:
        r0 = 1;
    L_0x0005:
        com.techno.gallery.Util.Assert(r0);
        r1.mListener = r2;
        return;
    L_0x000b:
        r0 = 0;
        goto L_0x0005;
    }

    public void setLoader(com.techno.gallery.ImageLoader r2) {
        r1 = this;
        r0 = r1.mRunning;
        if (r0 != 0) goto L_0x000b;
    L_0x0004:
        r0 = 1;
    L_0x0005:
        com.techno.gallery.Util.Assert(r0);
        r1.mLoader = r2;
        return;
    L_0x000b:
        r0 = 0;
        goto L_0x0005;
    }

    public void setSelectedIndex(int r3) {
        r2 = this;
        r0 = r2.mCurrentSelection;
        if (r0 != r3) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r2.mCount;
        r1 = 1;
        r0 = r0 - r1;
        r0 = java.lang.Math.min(r3, r0);
        r2.mCurrentSelection = r0;
        r0 = r2.mCurrentSelection;
        r1 = -1;
        if (r0 == r1) goto L_0x0019;
    L_0x0014:
        r0 = r2.mCurrentSelection;
        r2.ensureVisible(r0);
    L_0x0019:
        r2.invalidate();
        goto L_0x0004;
    }

    public void setSizeChoice(int r2) {
        r1 = this;
        r0 = r1.mRunning;
        if (r0 != 0) goto L_0x000d;
    L_0x0004:
        r0 = 1;
    L_0x0005:
        com.techno.gallery.Util.Assert(r0);
        r0 = r1.mSizeChoice;
        if (r0 != r2) goto L_0x000f;
    L_0x000c:
        return;
    L_0x000d:
        r0 = 0;
        goto L_0x0005;
    L_0x000f:
        r1.mSizeChoice = r2;
        goto L_0x000c;
    }

    public void start() {
        r3 = this;
        r2 = 0;
        r1 = 1;
        r0 = r3.mLoader;
        if (r0 == 0) goto L_0x0020;
    L_0x0006:
        r0 = r1;
    L_0x0007:
        com.techno.gallery.Util.Assert(r0);
        r0 = r3.mListener;
        if (r0 == 0) goto L_0x0022;
    L_0x000e:
        r0 = r1;
    L_0x000f:
        com.techno.gallery.Util.Assert(r0);
        r0 = r3.mDrawAdapter;
        if (r0 == 0) goto L_0x0024;
    L_0x0016:
        r0 = r1;
    L_0x0017:
        com.techno.gallery.Util.Assert(r0);
        r3.mRunning = r1;
        r3.requestLayout();
        return;
    L_0x0020:
        r0 = r2;
        goto L_0x0007;
    L_0x0022:
        r0 = r2;
        goto L_0x000f;
    L_0x0024:
        r0 = r2;
        goto L_0x0017;
    }

    public void stop() {
        r3 = this;
        r2 = 0;
        r0 = r3.mHandler;
        r1 = r3.mLongPressCallback;
        r0.removeCallbacks(r1);
        r3.mScroller = r2;
        r0 = r3.mImageBlockManager;
        if (r0 == 0) goto L_0x0015;
    L_0x000e:
        r0 = r3.mImageBlockManager;
        r0.recycle();
        r3.mImageBlockManager = r2;
    L_0x0015:
        r0 = 0;
        r3.mRunning = r0;
        r0 = -1;
        r3.mCurrentSelection = r0;
        return;
    }
}