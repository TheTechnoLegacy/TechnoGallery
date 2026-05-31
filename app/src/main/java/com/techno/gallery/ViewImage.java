package com.techno.gallery;

public class ViewImage extends android.app.Activity implements android.view.View.OnClickListener {
    private static final java.lang.String EXTRA_SLIDESHOW = "slideshow";
    public static final java.lang.String KEY_IMAGE_LIST = "image_list";
    static final int MODE_NORMAL = 1;
    static final int MODE_SLIDESHOW = 2;
    private static final java.lang.String PREF_SHUFFLE_SLIDESHOW = "pref_gallery_slideshow_shuffle_key";
    private static final java.lang.String PREF_SLIDESHOW_REPEAT = "pref_gallery_slideshow_repeat_key";
    private static final java.lang.String STATE_SHOW_CONTROLS = "show_controls";
    private static final java.lang.String STATE_SLIDESHOW = "slideshow";
    private static final java.lang.String STATE_URI = "uri";
    private static final java.lang.String TAG = "ViewImage";
    private static final int[] sOrderAdjacents = null;
    private static final int[] sOrderSlideshow = null;
    private android.view.View mActionIconPanel;
    com.techno.gallery.gallery.IImageList mAllImages;
    private com.techno.gallery.gallery.IImageList mAllImagesState;
    private int mAnimationIndex;
    private com.techno.gallery.BitmapCache mCache;
    int mCurrentPosition;
    protected java.lang.Runnable mDeletePhotoRunnable;
    private final java.lang.Runnable mDismissOnScreenControlRunner;
    private boolean mFullScreenInNormalMode;
    android.view.GestureDetector mGestureDetector;
    private com.techno.gallery.ImageGetter mGetter;
    final com.techno.gallery.GetterHandler mHandler;
    private final android.view.animation.Animation mHideNextImageViewAnimation;
    private final android.view.animation.Animation mHidePrevImageViewAnimation;
    private com.techno.gallery.MenuHelper.MenuItemsResult mImageMenuRunnable;
    private com.techno.gallery.ImageViewTouch mImageView;
    private int mLastSlideShowImage;
    private int mMode;
    private android.view.View mNextImageView;
    private boolean mPaused;
    private android.content.SharedPreferences mPrefs;
    private android.view.View mPrevImageView;
    private final java.util.Random mRandom;
    private android.net.Uri mSavedUri;
    private boolean mShowActionIcons;
    private boolean mShowControls;
    private final android.view.animation.Animation mShowNextImageViewAnimation;
    private final android.view.animation.Animation mShowPrevImageViewAnimation;
    private int[] mShuffleOrder;
    private int mSlideShowImageCurrent;
    private final com.techno.gallery.ImageViewTouchBase[] mSlideShowImageViews;
    private android.view.animation.Animation[] mSlideShowInAnimation;
    private int mSlideShowInterval;
    private boolean mSlideShowLoop;
    private android.view.animation.Animation[] mSlideShowOutAnimation;
    private boolean mUseShuffleOrder;
    private android.widget.ZoomButtonsController mZoomButtonsController;

    static {
        r1 = 0;
        r0 = 3;
        r0 = new int[r0];
        r0 = {0, 1, -1};
        sOrderAdjacents = r0;
        r0 = 1;
        r0 = new int[r0];
        r0[r1] = r1;
        sOrderSlideshow = r0;
        return;
    }

    public ViewImage() {
        r7 = this;
        r6 = 1;
        r5 = 0;
        r4 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = 0;
        r7.<init>();
        r7.mPaused = r6;
        r7.mShowControls = r6;
        r0 = new com.techno.gallery.GetterHandler;
        r0.<init>();
        r7.mHandler = r0;
        r0 = new java.util.Random;
        r1 = java.lang.System.currentTimeMillis();
        r0.<init>(r1);
        r7.mRandom = r0;
        r0 = 0;
        r7.mShuffleOrder = r0;
        r7.mUseShuffleOrder = r5;
        r7.mSlideShowLoop = r5;
        r7.mMode = r6;
        r7.mCurrentPosition = r5;
        r0 = new android.view.animation.AlphaAnimation;
        r0.<init>(r4, r3);
        r7.mHideNextImageViewAnimation = r0;
        r0 = new android.view.animation.AlphaAnimation;
        r0.<init>(r4, r3);
        r7.mHidePrevImageViewAnimation = r0;
        r0 = new android.view.animation.AlphaAnimation;
        r0.<init>(r3, r4);
        r7.mShowNextImageViewAnimation = r0;
        r0 = new android.view.animation.AlphaAnimation;
        r0.<init>(r3, r4);
        r7.mShowPrevImageViewAnimation = r0;
        r7.mSlideShowImageCurrent = r5;
        r0 = 2;
        r0 = new com.techno.gallery.ImageViewTouchBase[r0];
        r7.mSlideShowImageViews = r0;
        r0 = new com.techno.gallery.ViewImage$1;
        r0.<init>(r7);
        r7.mDismissOnScreenControlRunner = r0;
        r0 = new com.techno.gallery.ViewImage$9;
        r0.<init>(r7);
        r7.mDeletePhotoRunnable = r0;
        return;
    }

    static /* synthetic */ void access$000(com.techno.gallery.ViewImage r0) {
        r0.hideOnScreenControls();
        return;
    }

    static /* synthetic */ void access$100(com.techno.gallery.ViewImage r0) {
        r0.showOnScreenControls();
        return;
    }

    static /* synthetic */ int[] access$1000() {
        r0 = sOrderAdjacents;
        return r0;
    }

    static /* synthetic */ int[] access$1100() {
        r0 = sOrderSlideshow;
        return r0;
    }

    static /* synthetic */ int access$1200(com.techno.gallery.ViewImage r1) {
        r0 = r1.mMode;
        return r0;
    }

    static /* synthetic */ com.techno.gallery.ImageViewTouchBase[] access$1300(com.techno.gallery.ViewImage r1) {
        r0 = r1.mSlideShowImageViews;
        return r0;
    }

    static /* synthetic */ int access$1400(com.techno.gallery.ViewImage r1) {
        r0 = r1.mSlideShowImageCurrent;
        return r0;
    }

    static /* synthetic */ int access$1402(com.techno.gallery.ViewImage r0, int r1) {
        r0.mSlideShowImageCurrent = r1;
        return r1;
    }

    static /* synthetic */ int access$1404(com.techno.gallery.ViewImage r1) {
        r0 = r1.mSlideShowImageCurrent;
        r0 = r0 + 1;
        r1.mSlideShowImageCurrent = r0;
        return r0;
    }

    static /* synthetic */ int access$1500(com.techno.gallery.ViewImage r1) {
        r0 = r1.mAnimationIndex;
        return r0;
    }

    static /* synthetic */ android.view.animation.Animation[] access$1600(com.techno.gallery.ViewImage r1) {
        r0 = r1.mSlideShowInAnimation;
        return r0;
    }

    static /* synthetic */ java.util.Random access$1700(com.techno.gallery.ViewImage r1) {
        r0 = r1.mRandom;
        return r0;
    }

    static /* synthetic */ android.view.animation.Animation[] access$1800(com.techno.gallery.ViewImage r1) {
        r0 = r1.mSlideShowOutAnimation;
        return r0;
    }

    static /* synthetic */ boolean access$1900(com.techno.gallery.ViewImage r1) {
        r0 = r1.mSlideShowLoop;
        return r0;
    }

    static /* synthetic */ void access$200(com.techno.gallery.ViewImage r0) {
        r0.scheduleDismissOnScreenControls();
        return;
    }

    static /* synthetic */ boolean access$2000(com.techno.gallery.ViewImage r1) {
        r0 = r1.mUseShuffleOrder;
        return r0;
    }

    static /* synthetic */ void access$2100(com.techno.gallery.ViewImage r0) {
        r0.generateShuffleOrder();
        return;
    }

    static /* synthetic */ int access$2200(com.techno.gallery.ViewImage r1) {
        r0 = r1.mSlideShowInterval;
        return r0;
    }

    static /* synthetic */ void access$400(com.techno.gallery.ViewImage r0) {
        r0.updateZoomButtonsEnabled();
        return;
    }

    static /* synthetic */ com.techno.gallery.ImageViewTouch access$500(com.techno.gallery.ViewImage r1) {
        r0 = r1.mImageView;
        return r0;
    }

    static /* synthetic */ int access$600(com.techno.gallery.ViewImage r1) {
        r0 = r1.mLastSlideShowImage;
        return r0;
    }

    static /* synthetic */ int access$602(com.techno.gallery.ViewImage r0, int r1) {
        r0.mLastSlideShowImage = r1;
        return r1;
    }

    static /* synthetic */ void access$700(com.techno.gallery.ViewImage r0, int r1, long r2, boolean r4) {
        r0.loadNextImage(r1, r2, r4);
        return;
    }

    static /* synthetic */ boolean access$800(com.techno.gallery.ViewImage r1) {
        r0 = r1.mPaused;
        return r0;
    }

    static /* synthetic */ com.techno.gallery.BitmapCache access$900(com.techno.gallery.ViewImage r1) {
        r0 = r1.mCache;
        return r0;
    }

    private com.techno.gallery.gallery.IImageList buildImageListFromUri(android.net.Uri r6) {
        r5 = this;
        r2 = r5.mPrefs;
        r3 = "pref_gallery_sort_key";
        r4 = "descending";
        r1 = r2.getString(r3, r4);
        r2 = "ascending";
        r2 = r1.equals(r2);
        if (r2 == 0) goto L_0x001d;
    L_0x0012:
        r2 = 1;
        r0 = r2;
    L_0x0014:
        r2 = r5.getContentResolver();
        r2 = com.techno.gallery.ImageManager.makeImageList(r6, r2, r0);
        return r2;
    L_0x001d:
        r2 = 2;
        r0 = r2;
        goto L_0x0014;
    }

    private void generateShuffleOrder() {
        r6 = this;
        r4 = r6.mShuffleOrder;
        if (r4 == 0) goto L_0x000f;
    L_0x0004:
        r4 = r6.mShuffleOrder;
        r4 = r4.length;
        r5 = r6.mAllImages;
        r5 = r5.getCount();
        if (r4 == r5) goto L_0x0026;
    L_0x000f:
        r4 = r6.mAllImages;
        r4 = r4.getCount();
        r4 = new int[r4];
        r6.mShuffleOrder = r4;
        r0 = 0;
        r4 = r6.mShuffleOrder;
        r1 = r4.length;
    L_0x001d:
        if (r0 >= r1) goto L_0x0026;
    L_0x001f:
        r4 = r6.mShuffleOrder;
        r4[r0] = r0;
        r0 = r0 + 1;
        goto L_0x001d;
    L_0x0026:
        r4 = r6.mShuffleOrder;
        r4 = r4.length;
        r5 = 1;
        r0 = r4 - r5;
    L_0x002c:
        if (r0 < 0) goto L_0x004b;
    L_0x002e:
        r4 = r6.mRandom;
        r5 = r0 + 1;
        r2 = r4.nextInt(r5);
        if (r2 == r0) goto L_0x0048;
    L_0x0038:
        r4 = r6.mShuffleOrder;
        r3 = r4[r2];
        r4 = r6.mShuffleOrder;
        r5 = r6.mShuffleOrder;
        r5 = r5[r0];
        r4[r2] = r5;
        r4 = r6.mShuffleOrder;
        r4[r0] = r3;
    L_0x0048:
        r0 = r0 + -1;
        goto L_0x002c;
    L_0x004b:
        return;
    }

    private android.net.Uri getCurrentUri() {
        r3 = this;
        r1 = r3.mAllImages;
        r1 = r1.getCount();
        if (r1 != 0) goto L_0x000a;
    L_0x0008:
        r1 = 0;
    L_0x0009:
        return r1;
    L_0x000a:
        r1 = r3.mAllImages;
        r2 = r3.mCurrentPosition;
        r0 = r1.getImageAt(r2);
        r1 = r0.fullSizeImageUri();
        goto L_0x0009;
    }

    private static int getPreferencesInteger(android.content.SharedPreferences r5, java.lang.String r6, int r7) {
        r2 = 0;
        r1 = r5.getString(r6, r2);
        if (r1 != 0) goto L_0x0009;
    L_0x0007:
        r2 = r7;
    L_0x0008:
        return r2;
    L_0x0009:
        r2 = java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x000e }
        goto L_0x0008;
    L_0x000e:
        r0 = move-exception;
        r2 = "ViewImage";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "couldn't parse preference: ";
        r3 = r3.append(r4);
        r3 = r3.append(r1);
        r3 = r3.toString();
        android.util.Log.e(r2, r3, r0);
        r2 = r7;
        goto L_0x0008;
    }

    private void hideOnScreenControls() {
        r7 = this;
        r5 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r4 = 4;
        r2 = r7.mShowActionIcons;
        if (r2 == 0) goto L_0x0024;
    L_0x0007:
        r2 = r7.mActionIconPanel;
        r2 = r2.getVisibility();
        if (r2 != 0) goto L_0x0024;
    L_0x000f:
        r1 = new android.view.animation.AlphaAnimation;
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = 0;
        r1.<init>(r2, r3);
        r1.setDuration(r5);
        r2 = r7.mActionIconPanel;
        r2.startAnimation(r1);
        r2 = r7.mActionIconPanel;
        r2.setVisibility(r4);
    L_0x0024:
        r2 = r7.mNextImageView;
        r2 = r2.getVisibility();
        if (r2 != 0) goto L_0x003b;
    L_0x002c:
        r0 = r7.mHideNextImageViewAnimation;
        r0.setDuration(r5);
        r2 = r7.mNextImageView;
        r2.startAnimation(r0);
        r2 = r7.mNextImageView;
        r2.setVisibility(r4);
    L_0x003b:
        r2 = r7.mPrevImageView;
        r2 = r2.getVisibility();
        if (r2 != 0) goto L_0x0052;
    L_0x0043:
        r0 = r7.mHidePrevImageViewAnimation;
        r0.setDuration(r5);
        r2 = r7.mPrevImageView;
        r2.startAnimation(r0);
        r2 = r7.mPrevImageView;
        r2.setVisibility(r4);
    L_0x0052:
        r2 = r7.mZoomButtonsController;
        r3 = 0;
        r2.setVisible(r3);
        return;
    }

    private boolean init(android.net.Uri r5, com.techno.gallery.gallery.IImageList r6) {
        r4 = this;
        r3 = 0;
        if (r5 != 0) goto L_0x0005;
    L_0x0003:
        r1 = r3;
    L_0x0004:
        return r1;
    L_0x0005:
        if (r6 != 0) goto L_0x0024;
    L_0x0007:
        r1 = r4.buildImageListFromUri(r5);
    L_0x000b:
        r4.mAllImagesState = r1;
        r1 = r4.mAllImagesState;
        r4.mAllImages = r1;
        r1 = r4.mAllImages;
        r2 = r4.getContentResolver();
        r1.open(r2);
        r1 = r4.mAllImages;
        r0 = r1.getImageForUri(r5);
        if (r0 != 0) goto L_0x0026;
    L_0x0022:
        r1 = r3;
        goto L_0x0004;
    L_0x0024:
        r1 = r6;
        goto L_0x000b;
    L_0x0026:
        r1 = r4.mAllImages;
        r1 = r1.getImageIndex(r0);
        r4.mCurrentPosition = r1;
        r1 = r4.mCurrentPosition;
        r4.mLastSlideShowImage = r1;
        r1 = 1;
        goto L_0x0004;
    }

    private void loadNextImage(int r8, long r9, boolean r11) {
        r7 = this;
        if (r11 == 0) goto L_0x0009;
    L_0x0002:
        r1 = r7.mUseShuffleOrder;
        if (r1 == 0) goto L_0x0009;
    L_0x0006:
        r7.generateShuffleOrder();
    L_0x0009:
        r4 = java.lang.System.currentTimeMillis();
        r2 = r4 + r9;
        r0 = new com.techno.gallery.ViewImage$11;
        r1 = r7;
        r4 = r8;
        r5 = r11;
        r0.<init>(r1, r2, r4, r5);
        r1 = r7.mGetter;
        if (r1 == 0) goto L_0x002d;
    L_0x001b:
        r6 = r8;
        r1 = r7.mShuffleOrder;
        if (r1 == 0) goto L_0x0024;
    L_0x0020:
        r1 = r7.mShuffleOrder;
        r6 = r1[r6];
    L_0x0024:
        r1 = r7.mGetter;
        r4 = r7.mAllImages;
        r5 = r7.mHandler;
        r1.setPosition(r6, r0, r4, r5);
    L_0x002d:
        return;
    }

    private void makeGetter() {
        r1 = this;
        r0 = new com.techno.gallery.ImageGetter;
        r0.<init>();
        r1.mGetter = r0;
        return;
    }

    private android.view.animation.Animation makeInAnimation(int r2) {
        r1 = this;
        r0 = android.view.animation.AnimationUtils.loadAnimation(r1, r2);
        return r0;
    }

    private android.view.animation.Animation makeOutAnimation(int r2) {
        r1 = this;
        r0 = android.view.animation.AnimationUtils.loadAnimation(r1, r2);
        return r0;
    }

    private void moveNextOrPrevious(int r3) {
        r2 = this;
        r1 = r2.mCurrentPosition;
        r0 = r1 + r3;
        if (r0 < 0) goto L_0x0015;
    L_0x0006:
        r1 = r2.mAllImages;
        r1 = r1.getCount();
        if (r0 >= r1) goto L_0x0015;
    L_0x000e:
        r1 = 1;
        r2.setImage(r0, r1);
        r2.showOnScreenControls();
    L_0x0015:
        return;
    }

    private void scheduleDismissOnScreenControls() {
        r4 = this;
        r0 = r4.mHandler;
        r1 = r4.mDismissOnScreenControlRunner;
        r0.removeCallbacks(r1);
        r0 = r4.mHandler;
        r1 = r4.mDismissOnScreenControlRunner;
        r2 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r0.postDelayed(r1, r2);
        return;
    }

    private void setupOnScreenControls(android.view.View r3) {
        r2 = this;
        r0 = new com.techno.gallery.ViewImage$3;
        r0.<init>(r2);
        r3.setOnTouchListener(r0);
        r2.setupZoomButtonController(r3, r0);
        r1 = 2131427412; // 0x7f0b0054 float:1.847644E38 double:1.053065061E-314;
        r1 = r2.findViewById(r1);
        r2.mNextImageView = r1;
        r1 = 2131427411; // 0x7f0b0053 float:1.8476437E38 double:1.0530650604E-314;
        r1 = r2.findViewById(r1);
        r2.mPrevImageView = r1;
        r1 = r2.mNextImageView;
        r1.setOnClickListener(r2);
        r1 = r2.mPrevImageView;
        r1.setOnClickListener(r2);
        r1 = r2.mNextImageView;
        r1.setOnTouchListener(r0);
        r1 = r2.mPrevImageView;
        r1.setOnTouchListener(r0);
        return;
    }

    private void setupZoomButtonController(android.view.View r4, android.view.View.OnTouchListener r5) {
        r3 = this;
        r0 = new android.view.GestureDetector;
        r1 = new com.techno.gallery.ViewImage$MyGestureListener;
        r2 = 0;
        r1.<init>(r3, r2);
        r0.<init>(r3, r1);
        r3.mGestureDetector = r0;
        r0 = new android.widget.ZoomButtonsController;
        r0.<init>(r4);
        r3.mZoomButtonsController = r0;
        r0 = r3.mZoomButtonsController;
        r1 = 0;
        r0.setAutoDismissed(r1);
        r0 = r3.mZoomButtonsController;
        r1 = 100;
        r0.setZoomSpeed(r1);
        r0 = r3.mZoomButtonsController;
        r1 = new com.techno.gallery.ViewImage$4;
        r1.<init>(r3, r4, r5);
        r0.setOnZoomListener(r1);
        return;
    }

    private void showOnScreenControls() {
        r5 = this;
        r4 = 0;
        r2 = r5.mPaused;
        if (r2 == 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r2 = r5.mActionIconPanel;
        r2 = r2.getWindowToken();
        if (r2 != 0) goto L_0x0019;
    L_0x000e:
        r2 = r5.mHandler;
        r3 = new com.techno.gallery.ViewImage$2;
        r3.<init>(r5);
        r2.postGetterCallback(r3);
        goto L_0x0005;
    L_0x0019:
        r5.updateNextPrevControls();
        r2 = r5.mAllImages;
        r3 = r5.mCurrentPosition;
        r1 = r2.getImageAt(r3);
        r2 = r1 instanceof com.techno.gallery.gallery.VideoObject;
        if (r2 == 0) goto L_0x0051;
    L_0x0028:
        r2 = r5.mZoomButtonsController;
        r2.setVisible(r4);
    L_0x002d:
        r2 = r5.mShowActionIcons;
        if (r2 == 0) goto L_0x0005;
    L_0x0031:
        r2 = r5.mActionIconPanel;
        r2 = r2.getVisibility();
        if (r2 == 0) goto L_0x0005;
    L_0x0039:
        r0 = new android.view.animation.AlphaAnimation;
        r2 = 0;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0.<init>(r2, r3);
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r0.setDuration(r2);
        r2 = r5.mActionIconPanel;
        r2.startAnimation(r0);
        r2 = r5.mActionIconPanel;
        r2.setVisibility(r4);
        goto L_0x0005;
    L_0x0051:
        r5.updateZoomButtonsEnabled();
        r2 = r5.mZoomButtonsController;
        r3 = 1;
        r2.setVisible(r3);
        goto L_0x002d;
    }

    private void startPlayVideoActivity() {
        r6 = this;
        r3 = r6.mAllImages;
        r4 = r6.mCurrentPosition;
        r1 = r3.getImageAt(r4);
        r2 = new android.content.Intent;
        r3 = "android.intent.action.VIEW";
        r4 = r1.fullSizeImageUri();
        r2.<init>(r3, r4);
        r6.startActivity(r2);	 Catch:{ ActivityNotFoundException -> 0x0017 }
    L_0x0016:
        return;
    L_0x0017:
        r0 = move-exception;
        r3 = "ViewImage";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Couldn't view video ";
        r4 = r4.append(r5);
        r5 = r1.fullSizeImageUri();
        r4 = r4.append(r5);
        r4 = r4.toString();
        android.util.Log.e(r3, r4, r0);
        goto L_0x0016;
    }

    private void startShareMediaActivity(com.techno.gallery.gallery.IImage r6) {
        r5 = this;
        r2 = r6 instanceof com.techno.gallery.gallery.VideoObject;
        r1 = new android.content.Intent;
        r1.<init>();
        r3 = "android.intent.action.SEND";
        r1.setAction(r3);
        r3 = r6.getMimeType();
        r1.setType(r3);
        r3 = "android.intent.extra.STREAM";
        r4 = r6.fullSizeImageUri();
        r1.putExtra(r3, r4);
        if (r2 == 0) goto L_0x002d;
    L_0x001e:
        r3 = 2131296421; // 0x7f0900a5 float:1.8210758E38 double:1.0530003427E-314;
    L_0x0021:
        r3 = r5.getText(r3);	 Catch:{ ActivityNotFoundException -> 0x0031 }
        r3 = android.content.Intent.createChooser(r1, r3);	 Catch:{ ActivityNotFoundException -> 0x0031 }
        r5.startActivity(r3);	 Catch:{ ActivityNotFoundException -> 0x0031 }
    L_0x002c:
        return;
    L_0x002d:
        r3 = 2131296419; // 0x7f0900a3 float:1.8210754E38 double:1.0530003417E-314;
        goto L_0x0021;
    L_0x0031:
        r3 = move-exception;
        r0 = r3;
        if (r2 == 0) goto L_0x0041;
    L_0x0035:
        r3 = 2131296310; // 0x7f090036 float:1.8210533E38 double:1.053000288E-314;
    L_0x0038:
        r4 = 0;
        r3 = android.widget.Toast.makeText(r5, r3, r4);
        r3.show();
        goto L_0x002c;
    L_0x0041:
        r3 = 2131296311; // 0x7f090037 float:1.8210535E38 double:1.0530002884E-314;
        goto L_0x0038;
    }

    private void updateActionIcons() {
        r8 = this;
        r7 = 2131427419; // 0x7f0b005b float:1.8476454E38 double:1.0530650643E-314;
        r6 = 2131427418; // 0x7f0b005a float:1.8476452E38 double:1.053065064E-314;
        r5 = 8;
        r4 = 0;
        r2 = r8.isPickIntent();
        if (r2 == 0) goto L_0x0010;
    L_0x000f:
        return;
    L_0x0010:
        r2 = r8.mAllImages;
        r3 = r8.mCurrentPosition;
        r0 = r2.getImageAt(r3);
        r1 = r8.mActionIconPanel;
        r2 = r0 instanceof com.techno.gallery.gallery.VideoObject;
        if (r2 == 0) goto L_0x002d;
    L_0x001e:
        r2 = r1.findViewById(r6);
        r2.setVisibility(r5);
        r2 = r1.findViewById(r7);
        r2.setVisibility(r4);
        goto L_0x000f;
    L_0x002d:
        r2 = r1.findViewById(r6);
        r2.setVisibility(r4);
        r2 = r1.findViewById(r7);
        r2.setVisibility(r5);
        goto L_0x000f;
    }

    private void updateNextPrevControls() {
        r12 = this;
        r11 = 8;
        r9 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r8 = 1;
        r7 = 0;
        r5 = r12.mCurrentPosition;
        if (r5 <= 0) goto L_0x0050;
    L_0x000a:
        r4 = r8;
    L_0x000b:
        r5 = r12.mCurrentPosition;
        r6 = r12.mAllImages;
        r6 = r6.getCount();
        r6 = r6 - r8;
        if (r5 >= r6) goto L_0x0052;
    L_0x0016:
        r3 = r8;
    L_0x0017:
        r5 = r12.mPrevImageView;
        r5 = r5.getVisibility();
        if (r5 != 0) goto L_0x0054;
    L_0x001f:
        r2 = r8;
    L_0x0020:
        r5 = r12.mNextImageView;
        r5 = r5.getVisibility();
        if (r5 != 0) goto L_0x0056;
    L_0x0028:
        r1 = r8;
    L_0x0029:
        if (r4 == 0) goto L_0x0058;
    L_0x002b:
        if (r2 != 0) goto L_0x0058;
    L_0x002d:
        r0 = r12.mShowPrevImageViewAnimation;
        r0.setDuration(r9);
        r5 = r12.mPrevImageView;
        r5.startAnimation(r0);
        r5 = r12.mPrevImageView;
        r5.setVisibility(r7);
    L_0x003c:
        if (r3 == 0) goto L_0x006c;
    L_0x003e:
        if (r1 != 0) goto L_0x006c;
    L_0x0040:
        r0 = r12.mShowNextImageViewAnimation;
        r0.setDuration(r9);
        r5 = r12.mNextImageView;
        r5.startAnimation(r0);
        r5 = r12.mNextImageView;
        r5.setVisibility(r7);
    L_0x004f:
        return;
    L_0x0050:
        r4 = r7;
        goto L_0x000b;
    L_0x0052:
        r3 = r7;
        goto L_0x0017;
    L_0x0054:
        r2 = r7;
        goto L_0x0020;
    L_0x0056:
        r1 = r7;
        goto L_0x0029;
    L_0x0058:
        if (r4 != 0) goto L_0x003c;
    L_0x005a:
        if (r2 == 0) goto L_0x003c;
    L_0x005c:
        r0 = r12.mHidePrevImageViewAnimation;
        r0.setDuration(r9);
        r5 = r12.mPrevImageView;
        r5.startAnimation(r0);
        r5 = r12.mPrevImageView;
        r5.setVisibility(r11);
        goto L_0x003c;
    L_0x006c:
        if (r3 != 0) goto L_0x004f;
    L_0x006e:
        if (r1 == 0) goto L_0x004f;
    L_0x0070:
        r0 = r12.mHideNextImageViewAnimation;
        r0.setDuration(r9);
        r5 = r12.mNextImageView;
        r5.startAnimation(r0);
        r5 = r12.mNextImageView;
        r5.setVisibility(r11);
        goto L_0x004f;
    }

    private void updateZoomButtonsEnabled() {
        r6 = this;
        r5 = 1;
        r4 = 0;
        r0 = r6.mImageView;
        r1 = r0.getScale();
        r2 = r6.mZoomButtonsController;
        r3 = r0.mMaxZoom;
        r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r3 >= 0) goto L_0x0021;
    L_0x0010:
        r3 = r5;
    L_0x0011:
        r2.setZoomInEnabled(r3);
        r2 = r6.mZoomButtonsController;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r3 <= 0) goto L_0x0023;
    L_0x001c:
        r3 = r5;
    L_0x001d:
        r2.setZoomOutEnabled(r3);
        return;
    L_0x0021:
        r3 = r4;
        goto L_0x0011;
    L_0x0023:
        r3 = r4;
        goto L_0x001d;
    }

    public boolean dispatchTouchEvent(android.view.MotionEvent r4) {
        r3 = this;
        r2 = 1;
        r0 = r3.mPaused;
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        r0 = r2;
    L_0x0006:
        return r0;
    L_0x0007:
        r0 = r3.mZoomButtonsController;
        r0 = r0.isVisible();
        if (r0 == 0) goto L_0x001b;
    L_0x000f:
        r0 = r3.mZoomButtonsController;
        r1 = 0;
        r0 = r0.onTouch(r1, r4);
        if (r0 == 0) goto L_0x001b;
    L_0x0018:
        r3.scheduleDismissOnScreenControls();
    L_0x001b:
        r0 = super.dispatchTouchEvent(r4);
        if (r0 != 0) goto L_0x0028;
    L_0x0021:
        r0 = r3.mGestureDetector;
        r0 = r0.onTouchEvent(r4);
        goto L_0x0006;
    L_0x0028:
        r0 = r2;
        goto L_0x0006;
    }

    boolean isPickIntent() {
        r2 = this;
        r1 = r2.getIntent();
        r0 = r1.getAction();
        r1 = "android.intent.action.PICK";
        r1 = r1.equals(r0);
        if (r1 != 0) goto L_0x0018;
    L_0x0010:
        r1 = "android.intent.action.GET_CONTENT";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x001a;
    L_0x0018:
        r1 = 1;
    L_0x0019:
        return r1;
    L_0x001a:
        r1 = 0;
        goto L_0x0019;
    }

    protected void onActivityResult(int r4, int r5, android.content.Intent r6) {
        r3 = this;
        switch(r4) {
            case 490: goto L_0x0004;
            default: goto L_0x0003;
        };
    L_0x0003:
        return;
    L_0x0004:
        r1 = -1;
        if (r5 != r1) goto L_0x0003;
    L_0x0007:
        r1 = r6.getAction();
        r1 = android.net.Uri.parse(r1);
        r3.mSavedUri = r1;
        r1 = r3.mAllImages;
        if (r1 == 0) goto L_0x0003;
    L_0x0015:
        r1 = r3.mAllImages;
        r2 = r3.mSavedUri;
        r0 = r1.getImageForUri(r2);
        r1 = r3.mAllImages;
        r1 = r1.getImageIndex(r0);
        r3.mCurrentPosition = r1;
        r1 = r3.mCurrentPosition;
        r2 = 0;
        r3.setImage(r1, r2);
        goto L_0x0003;
    }

    public void onClick(android.view.View r6) {
        r5 = this;
        r3 = r6.getId();
        switch(r3) {
            case 2131427343: goto L_0x0008;
            case 2131427411: goto L_0x0056;
            case 2131427412: goto L_0x0051;
            case 2131427418: goto L_0x0028;
            case 2131427419: goto L_0x000e;
            case 2131427420: goto L_0x0012;
            default: goto L_0x0007;
        };
    L_0x0007:
        return;
    L_0x0008:
        r3 = r5.mDeletePhotoRunnable;
        com.techno.gallery.MenuHelper.deletePhoto(r5, r3);
        goto L_0x0007;
    L_0x000e:
        r5.startPlayVideoActivity();
        goto L_0x0007;
    L_0x0012:
        r3 = r5.mAllImages;
        r4 = r5.mCurrentPosition;
        r1 = r3.getImageAt(r4);
        r3 = r1.fullSizeImageUri();
        r3 = com.techno.gallery.MenuHelper.isWhiteListUri(r3);
        if (r3 == 0) goto L_0x0007;
    L_0x0024:
        r5.startShareMediaActivity(r1);
        goto L_0x0007;
    L_0x0028:
        r3 = r5.mAllImages;
        r4 = r5.mCurrentPosition;
        r1 = r3.getImageAt(r4);
        r2 = com.techno.gallery.Util.createSetAsIntent(r1);
        r3 = 2131296420; // 0x7f0900a4 float:1.8210756E38 double:1.053000342E-314;
        r3 = r5.getText(r3);	 Catch:{ ActivityNotFoundException -> 0x0043 }
        r3 = android.content.Intent.createChooser(r2, r3);	 Catch:{ ActivityNotFoundException -> 0x0043 }
        r5.startActivity(r3);	 Catch:{ ActivityNotFoundException -> 0x0043 }
        goto L_0x0007;
    L_0x0043:
        r3 = move-exception;
        r0 = r3;
        r3 = 2131296311; // 0x7f090037 float:1.8210535E38 double:1.0530002884E-314;
        r4 = 0;
        r3 = android.widget.Toast.makeText(r5, r3, r4);
        r3.show();
        goto L_0x0007;
    L_0x0051:
        r3 = 1;
        r5.moveNextOrPrevious(r3);
        goto L_0x0007;
    L_0x0056:
        r3 = -1;
        r5.moveNextOrPrevious(r3);
        goto L_0x0007;
    }

    public void onCreate(android.os.Bundle r20) {
        r19 = this;
        super.onCreate(r20);
        r8 = r19.getIntent();
        r16 = "android.intent.extra.fullScreen";
        r17 = 1;
        r0 = r8;
        r1 = r16;
        r2 = r17;
        r16 = r0.getBooleanExtra(r1, r2);
        r0 = r16;
        r1 = r19;
        r1.mFullScreenInNormalMode = r0;
        r16 = "android.intent.extra.showActionIcons";
        r17 = 1;
        r0 = r8;
        r1 = r16;
        r2 = r17;
        r16 = r0.getBooleanExtra(r1, r2);
        r0 = r16;
        r1 = r19;
        r1.mShowActionIcons = r0;
        r16 = android.preference.PreferenceManager.getDefaultSharedPreferences(r19);
        r0 = r16;
        r1 = r19;
        r1.mPrefs = r0;
        r16 = 2;
        r0 = r19;
        r1 = r16;
        r0.setDefaultKeyMode(r1);
        r16 = 1;
        r0 = r19;
        r1 = r16;
        r0.requestWindowFeature(r1);
        r16 = 2130903058; // 0x7f030012 float:1.7412923E38 double:1.0528059956E-314;
        r0 = r19;
        r1 = r16;
        r0.setContentView(r1);
        r16 = 2131427341; // 0x7f0b000d float:1.8476296E38 double:1.053065026E-314;
        r0 = r19;
        r1 = r16;
        r3 = r0.findViewById(r1);
        r3 = (com.techno.gallery.ImageViewTouch) r3;
        r0 = r3;
        r1 = r19;
        r1.mImageView = r0;
        r0 = r19;
        r0 = r0.mImageView;
        r16 = r0;
        r17 = 1;
        r16.setEnableTrackballScroll(r17);
        r16 = new com.techno.gallery.BitmapCache;
        r17 = 3;
        r16.<init>(r17);
        r0 = r16;
        r1 = r19;
        r1.mCache = r0;
        r0 = r19;
        r0 = r0.mImageView;
        r16 = r0;
        r0 = r19;
        r0 = r0.mCache;
        r17 = r0;
        r16.setRecycler(r17);
        r19.makeGetter();
        r16 = -1;
        r0 = r16;
        r1 = r19;
        r1.mAnimationIndex = r0;
        r16 = 3;
        r0 = r16;
        r0 = new android.view.animation.Animation[r0];
        r16 = r0;
        r17 = 0;
        r18 = 2130968584; // 0x7f040008 float:1.7545826E38 double:1.0528383697E-314;
        r0 = r19;
        r1 = r18;
        r18 = r0.makeInAnimation(r1);
        r16[r17] = r18;
        r17 = 1;
        r18 = 2130968580; // 0x7f040004 float:1.7545818E38 double:1.0528383677E-314;
        r0 = r19;
        r1 = r18;
        r18 = r0.makeInAnimation(r1);
        r16[r17] = r18;
        r17 = 2;
        r18 = 2130968581; // 0x7f040005 float:1.754582E38 double:1.052838368E-314;
        r0 = r19;
        r1 = r18;
        r18 = r0.makeInAnimation(r1);
        r16[r17] = r18;
        r0 = r16;
        r1 = r19;
        r1.mSlideShowInAnimation = r0;
        r16 = 3;
        r0 = r16;
        r0 = new android.view.animation.Animation[r0];
        r16 = r0;
        r17 = 0;
        r18 = 2130968585; // 0x7f040009 float:1.7545828E38 double:1.05283837E-314;
        r0 = r19;
        r1 = r18;
        r18 = r0.makeOutAnimation(r1);
        r16[r17] = r18;
        r17 = 1;
        r18 = 2130968582; // 0x7f040006 float:1.7545822E38 double:1.0528383687E-314;
        r0 = r19;
        r1 = r18;
        r18 = r0.makeOutAnimation(r1);
        r16[r17] = r18;
        r17 = 2;
        r18 = 2130968583; // 0x7f040007 float:1.7545824E38 double:1.052838369E-314;
        r0 = r19;
        r1 = r18;
        r18 = r0.makeOutAnimation(r1);
        r16[r17] = r18;
        r0 = r16;
        r1 = r19;
        r1.mSlideShowOutAnimation = r0;
        r0 = r19;
        r0 = r0.mSlideShowImageViews;
        r16 = r0;
        r17 = 0;
        r18 = 2131427408; // 0x7f0b0050 float:1.8476431E38 double:1.053065059E-314;
        r0 = r19;
        r1 = r18;
        r3 = r0.findViewById(r1);
        r3 = (com.techno.gallery.ImageViewTouchBase) r3;
        r16[r17] = r3;
        r0 = r19;
        r0 = r0.mSlideShowImageViews;
        r16 = r0;
        r17 = 1;
        r18 = 2131427409; // 0x7f0b0051 float:1.8476433E38 double:1.0530650594E-314;
        r0 = r19;
        r1 = r18;
        r3 = r0.findViewById(r1);
        r3 = (com.techno.gallery.ImageViewTouchBase) r3;
        r16[r17] = r3;
        r0 = r19;
        r0 = r0.mSlideShowImageViews;
        r3 = r0;
        r9 = r3.length;
        r5 = 0;
    L_0x0142:
        if (r5 >= r9) goto L_0x015d;
    L_0x0144:
        r14 = r3[r5];
        r16 = 4;
        r0 = r14;
        r1 = r16;
        r0.setVisibility(r1);
        r0 = r19;
        r0 = r0.mCache;
        r16 = r0;
        r0 = r14;
        r1 = r16;
        r0.setRecycler(r1);
        r5 = r5 + 1;
        goto L_0x0142;
    L_0x015d:
        r16 = 2131427417; // 0x7f0b0059 float:1.847645E38 double:1.0530650633E-314;
        r0 = r19;
        r1 = r16;
        r16 = r0.findViewById(r1);
        r0 = r16;
        r1 = r19;
        r1.mActionIconPanel = r0;
        r16 = r19.getIntent();
        r13 = r16.getData();
        r16 = r19.getIntent();
        r17 = "image_list";
        r7 = r16.getParcelableExtra(r17);
        r7 = (com.techno.gallery.gallery.IImageList) r7;
        r16 = "slideshow";
        r17 = 0;
        r0 = r8;
        r1 = r16;
        r2 = r17;
        r12 = r0.getBooleanExtra(r1, r2);
        if (r20 == 0) goto L_0x01bf;
    L_0x0191:
        r16 = "uri";
        r0 = r20;
        r1 = r16;
        r13 = r0.getParcelable(r1);
        r13 = (android.net.Uri) r13;
        r16 = "slideshow";
        r17 = 0;
        r0 = r20;
        r1 = r16;
        r2 = r17;
        r12 = r0.getBoolean(r1, r2);
        r16 = "show_controls";
        r17 = 1;
        r0 = r20;
        r1 = r16;
        r2 = r17;
        r16 = r0.getBoolean(r1, r2);
        r0 = r16;
        r1 = r19;
        r1.mShowControls = r0;
    L_0x01bf:
        r0 = r19;
        r1 = r13;
        r2 = r7;
        r16 = r0.init(r1, r2);
        if (r16 != 0) goto L_0x01cd;
    L_0x01c9:
        r19.finish();
    L_0x01cc:
        return;
    L_0x01cd:
        r16 = com.techno.gallery.MenuHelper.isWhiteListUri(r13);
        if (r16 != 0) goto L_0x01db;
    L_0x01d3:
        r16 = 0;
        r0 = r16;
        r1 = r19;
        r1.mShowActionIcons = r0;
    L_0x01db:
        r0 = r19;
        r0 = r0.mShowActionIcons;
        r16 = r0;
        if (r16 == 0) goto L_0x0222;
    L_0x01e3:
        r16 = 2;
        r0 = r16;
        r0 = new int[r0];
        r11 = r0;
        r11 = {2131427421, 2131427422};
        r16 = 4;
        r0 = r16;
        r0 = new int[r0];
        r10 = r0;
        r10 = {2131427418, 2131427419, 2131427420, 2131427343};
        r16 = r19.isPickIntent();
        if (r16 == 0) goto L_0x0220;
    L_0x01fd:
        r4 = r11;
    L_0x01fe:
        r3 = r4;
        r9 = r3.length;
        r5 = 0;
    L_0x0201:
        if (r5 >= r9) goto L_0x0222;
    L_0x0203:
        r6 = r3[r5];
        r0 = r19;
        r0 = r0.mActionIconPanel;
        r16 = r0;
        r0 = r16;
        r1 = r6;
        r15 = r0.findViewById(r1);
        r16 = 0;
        r15.setVisibility(r16);
        r0 = r15;
        r1 = r19;
        r0.setOnClickListener(r1);
        r5 = r5 + 1;
        goto L_0x0201;
    L_0x0220:
        r4 = r10;
        goto L_0x01fe;
    L_0x0222:
        r16 = r13.toString();
        r16 = com.techno.gallery.ImageManager.isSingleImageMode(r16);
        if (r16 == 0) goto L_0x023e;
    L_0x022c:
        r0 = r19;
        r0 = r0.mActionIconPanel;
        r16 = r0;
        r17 = 2131427343; // 0x7f0b000f float:1.84763E38 double:1.053065027E-314;
        r16 = r16.findViewById(r17);
        r17 = 8;
        r16.setVisibility(r17);
    L_0x023e:
        if (r12 == 0) goto L_0x025d;
    L_0x0240:
        r16 = 2;
        r0 = r19;
        r1 = r16;
        r0.setMode(r1);
    L_0x0249:
        r16 = 2131427410; // 0x7f0b0052 float:1.8476435E38 double:1.05306506E-314;
        r0 = r19;
        r1 = r16;
        r16 = r0.findViewById(r1);
        r0 = r19;
        r1 = r16;
        r0.setupOnScreenControls(r1);
        goto L_0x01cc;
    L_0x025d:
        r0 = r19;
        r0 = r0.mFullScreenInNormalMode;
        r16 = r0;
        if (r16 == 0) goto L_0x026e;
    L_0x0265:
        r16 = r19.getWindow();
        r17 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r16.addFlags(r17);
    L_0x026e:
        r0 = r19;
        r0 = r0.mShowActionIcons;
        r16 = r0;
        if (r16 == 0) goto L_0x0249;
    L_0x0276:
        r0 = r19;
        r0 = r0.mActionIconPanel;
        r16 = r0;
        r17 = 0;
        r16.setVisibility(r17);
        goto L_0x0249;
    }

    public boolean onCreateOptionsMenu(android.view.Menu r12) {
        r11 = this;
        r10 = 2131296373; // 0x7f090075 float:1.821066E38 double:1.053000319E-314;
        r9 = 196608; // 0x30000 float:2.75506E-40 double:9.71373E-319;
        r8 = 203; // 0xcb float:2.84E-43 double:1.003E-321;
        r7 = 0;
        super.onCreateOptionsMenu(r12);
        r0 = 2131296284; // 0x7f09001c float:1.821048E38 double:1.053000275E-314;
        r6 = r12.add(r9, r8, r7, r0);
        r0 = new com.techno.gallery.ViewImage$5;
        r0.<init>(r11);
        r6.setOnMenuItemClickListener(r0);
        r0 = 17301587; // 0x1080053 float:2.4979488E-38 double:8.54812E-317;
        r6.setIcon(r0);
        r1 = -1;
        r3 = r11.mHandler;
        r4 = r11.mDeletePhotoRunnable;
        r5 = new com.techno.gallery.ViewImage$6;
        r5.<init>(r11);
        r0 = r12;
        r2 = r11;
        r0 = com.techno.gallery.MenuHelper.addImageMenuItems(r0, r1, r2, r3, r4, r5);
        r11.mImageMenuRunnable = r0;
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r12.add(r9, r8, r0, r10);
        r0 = new com.techno.gallery.ViewImage$7;
        r0.<init>(r11);
        r6.setOnMenuItemClickListener(r0);
        r0 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r6.setAlphabeticShortcut(r0);
        r0 = 17301577; // 0x1080049 float:2.497946E-38 double:8.548115E-317;
        r6.setIcon(r0);
        r0 = r12.add(r9, r8, r7, r10);
        r1 = new com.techno.gallery.ViewImage$8;
        r1.<init>(r11);
        r0 = r0.setOnMenuItemClickListener(r1);
        r1 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        r0 = r0.setAlphabeticShortcut(r1);
        r0.setVisible(r7);
        r0 = 1;
        return r0;
    }

    protected void onDestroy() {
        r2 = this;
        r0 = r2.mZoomButtonsController;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r2.mZoomButtonsController;
        r1 = 0;
        r0.setVisible(r1);
    L_0x000a:
        super.onDestroy();
        return;
    }

    public boolean onMenuItemSelected(int r5, android.view.MenuItem r6) {
        r4 = this;
        r0 = super.onMenuItemSelected(r5, r6);
        r1 = r4.mImageMenuRunnable;
        if (r1 == 0) goto L_0x0015;
    L_0x0008:
        r1 = r4.mImageMenuRunnable;
        r2 = r4.mAllImages;
        r3 = r4.mCurrentPosition;
        r2 = r2.getImageAt(r3);
        r1.aboutToCall(r6, r2);
    L_0x0015:
        return r0;
    }

    public boolean onPrepareOptionsMenu(android.view.Menu r6) {
        r5 = this;
        r4 = 1;
        super.onPrepareOptionsMenu(r6);
        r1 = r5.mPaused;
        if (r1 == 0) goto L_0x000a;
    L_0x0008:
        r1 = 0;
    L_0x0009:
        return r1;
    L_0x000a:
        r5.setMode(r4);
        r1 = r5.mImageMenuRunnable;
        if (r1 == 0) goto L_0x001e;
    L_0x0011:
        r1 = r5.mImageMenuRunnable;
        r2 = r5.mAllImages;
        r3 = r5.mCurrentPosition;
        r2 = r2.getImageAt(r3);
        r1.gettingReadyToOpen(r6, r2);
    L_0x001e:
        r1 = r5.mAllImages;
        r2 = r5.mCurrentPosition;
        r1 = r1.getImageAt(r2);
        r0 = r1.fullSizeImageUri();
        r1 = com.techno.gallery.MenuHelper.isWhiteListUri(r0);
        com.techno.gallery.MenuHelper.enableShareMenuItem(r6, r1);
        r1 = r4;
        goto L_0x0009;
    }

    public void onSaveInstanceState(android.os.Bundle r4) {
        r3 = this;
        super.onSaveInstanceState(r4);
        r0 = "uri";
        r1 = r3.mAllImages;
        r2 = r3.mCurrentPosition;
        r1 = r1.getImageAt(r2);
        r1 = r1.fullSizeImageUri();
        r4.putParcelable(r0, r1);
        r0 = "slideshow";
        r1 = r3.mMode;
        r2 = 2;
        if (r1 != r2) goto L_0x0020;
    L_0x001b:
        r1 = 1;
    L_0x001c:
        r4.putBoolean(r0, r1);
        return;
    L_0x0020:
        r1 = 0;
        goto L_0x001c;
    }

    public void onStart() {
        r5 = this;
        r4 = 1;
        r3 = 0;
        super.onStart();
        r5.mPaused = r3;
        r1 = r5.mSavedUri;
        r2 = r5.mAllImagesState;
        r5.init(r1, r2);
        r1 = r5.mAllImages;
        r0 = r1.getCount();
        if (r0 != 0) goto L_0x001a;
    L_0x0016:
        r5.finish();
    L_0x0019:
        return;
    L_0x001a:
        r1 = r5.mCurrentPosition;
        if (r0 > r1) goto L_0x0022;
    L_0x001e:
        r1 = r0 - r4;
        r5.mCurrentPosition = r1;
    L_0x0022:
        r1 = r5.mGetter;
        if (r1 != 0) goto L_0x0029;
    L_0x0026:
        r5.makeGetter();
    L_0x0029:
        r1 = r5.mMode;
        r2 = 2;
        if (r1 != r2) goto L_0x0036;
    L_0x002e:
        r1 = r5.mCurrentPosition;
        r2 = 0;
        r5.loadNextImage(r1, r2, r4);
        goto L_0x0019;
    L_0x0036:
        r1 = r5.mCurrentPosition;
        r2 = r5.mShowControls;
        r5.setImage(r1, r2);
        r5.mShowControls = r3;
        goto L_0x0019;
    }

    public void onStop() {
        r7 = this;
        r6 = 0;
        r5 = 1;
        super.onStop();
        r7.mPaused = r5;
        r4 = r7.mGetter;
        r4.cancelCurrent();
        r4 = r7.mGetter;
        r4.stop();
        r7.mGetter = r6;
        r7.setMode(r5);
        r4 = r7.mHandler;
        r4.removeAllGetterCallbacks();
        r4 = r7.getCurrentUri();
        r7.mSavedUri = r4;
        r4 = r7.mAllImages;
        r4.deactivate();
        r4 = r7.mAllImages;
        r4.close();
        r7.mAllImages = r6;
        r7.hideOnScreenControls();
        r4 = r7.mImageView;
        r4.clear();
        r4 = r7.mCache;
        r4.clear();
        r0 = r7.mSlideShowImageViews;
        r3 = r0.length;
        r1 = 0;
    L_0x003e:
        if (r1 >= r3) goto L_0x0048;
    L_0x0040:
        r2 = r0[r1];
        r2.clear();
        r1 = r1 + 1;
        goto L_0x003e;
    L_0x0048:
        return;
    }

    void setImage(int r7, boolean r8) {
        r6 = this;
        r6.mCurrentPosition = r7;
        r3 = r6.mCache;
        r0 = r3.getBitmap(r7);
        if (r0 == 0) goto L_0x0022;
    L_0x000a:
        r3 = r6.mAllImages;
        r2 = r3.getImageAt(r7);
        r3 = r6.mImageView;
        r4 = new com.techno.gallery.RotateBitmap;
        r5 = r2.getDegreesRotated();
        r4.<init>(r0, r5);
        r5 = 1;
        r3.setImageRotateBitmapResetBase(r4, r5);
        r6.updateZoomButtonsEnabled();
    L_0x0022:
        r1 = new com.techno.gallery.ViewImage$10;
        r1.<init>(r6);
        r3 = r6.mGetter;
        if (r3 == 0) goto L_0x0034;
    L_0x002b:
        r3 = r6.mGetter;
        r4 = r6.mAllImages;
        r5 = r6.mHandler;
        r3.setPosition(r7, r1, r4, r5);
    L_0x0034:
        r6.updateActionIcons();
        if (r8 == 0) goto L_0x003c;
    L_0x0039:
        r6.showOnScreenControls();
    L_0x003c:
        r6.scheduleDismissOnScreenControls();
        return;
    }

    void setMode(int r15) {
        r14 = this;
        r13 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r12 = -1;
        r10 = 8;
        r11 = 0;
        r9 = r14.mMode;
        if (r9 != r15) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r9 = 2131427407; // 0x7f0b004f float:1.847643E38 double:1.0530650584E-314;
        r7 = r14.findViewById(r9);
        r9 = 2131427410; // 0x7f0b0052 float:1.8476435E38 double:1.05306506E-314;
        r6 = r14.findViewById(r9);
        r8 = r14.getWindow();
        r14.mMode = r15;
        r9 = 2;
        if (r15 != r9) goto L_0x0071;
    L_0x0022:
        r7.setVisibility(r11);
        r6.setVisibility(r10);
        r9 = 1152; // 0x480 float:1.614E-42 double:5.69E-321;
        r8.addFlags(r9);
        r9 = r14.mImageView;
        r9.clear();
        r9 = r14.mActionIconPanel;
        r9.setVisibility(r10);
        r9 = r7.getRootView();
        r9.requestLayout();
        r9 = r14.mPrefs;
        r10 = "pref_gallery_slideshow_shuffle_key";
        r9 = r9.getBoolean(r10, r11);
        r14.mUseShuffleOrder = r9;
        r9 = r14.mPrefs;
        r10 = "pref_gallery_slideshow_repeat_key";
        r9 = r9.getBoolean(r10, r11);
        r14.mSlideShowLoop = r9;
        r9 = r14.mPrefs;
        r10 = "pref_gallery_slideshow_transition_key";
        r9 = getPreferencesInteger(r9, r10, r11);
        r14.mAnimationIndex = r9;
        r9 = r14.mPrefs;
        r10 = "pref_gallery_slideshow_interval_key";
        r11 = 3;
        r9 = getPreferencesInteger(r9, r10, r11);
        r9 = r9 * 1000;
        r14.mSlideShowInterval = r9;
        r9 = r14.mUseShuffleOrder;
        if (r9 == 0) goto L_0x000a;
    L_0x006d:
        r14.generateShuffleOrder();
        goto L_0x000a;
    L_0x0071:
        r7.setVisibility(r10);
        r6.setVisibility(r11);
        r9 = 128; // 0x80 float:1.8E-43 double:6.3E-322;
        r8.clearFlags(r9);
        r9 = r14.mFullScreenInNormalMode;
        if (r9 == 0) goto L_0x00bb;
    L_0x0080:
        r8.addFlags(r13);
    L_0x0083:
        r9 = r14.mGetter;
        if (r9 == 0) goto L_0x008c;
    L_0x0087:
        r9 = r14.mGetter;
        r9.cancelCurrent();
    L_0x008c:
        r9 = r14.mShowActionIcons;
        if (r9 == 0) goto L_0x00a7;
    L_0x0090:
        r0 = new android.view.animation.AlphaAnimation;
        r9 = 0;
        r10 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0.<init>(r9, r10);
        r9 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r0.setDuration(r9);
        r9 = r14.mActionIconPanel;
        r9.setAnimation(r0);
        r9 = r14.mActionIconPanel;
        r9.setVisibility(r11);
    L_0x00a7:
        r2 = r14.mImageView;
        r2.mLastXTouchPos = r12;
        r2.mLastYTouchPos = r12;
        r1 = r14.mSlideShowImageViews;
        r5 = r1.length;
        r3 = 0;
    L_0x00b1:
        if (r3 >= r5) goto L_0x00bf;
    L_0x00b3:
        r4 = r1[r3];
        r4.clear();
        r3 = r3 + 1;
        goto L_0x00b1;
    L_0x00bb:
        r8.clearFlags(r13);
        goto L_0x0083;
    L_0x00bf:
        r9 = 0;
        r14.mShuffleOrder = r9;
        r9 = r14.mGetter;
        if (r9 == 0) goto L_0x000a;
    L_0x00c6:
        r9 = r14.mCurrentPosition;
        r10 = 1;
        r14.setImage(r9, r10);
        goto L_0x000a;
    }
}