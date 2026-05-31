package com.techno.gallery;

public class ReviewImage extends android.app.Activity implements android.view.View.OnClickListener {
    public static final java.lang.String KEY_IMAGE_LIST = "image_list";
    private static final java.lang.String STATE_SHOW_CONTROLS = "show_controls";
    private static final java.lang.String STATE_URI = "uri";
    private static final java.lang.String TAG = "ReviewImage";
    private static final int[] sOrderAdjacents = null;
    com.techno.gallery.gallery.IImageList mAllImages;
    private com.techno.gallery.BitmapCache mCache;
    private android.view.View mControlBar;
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
    private com.techno.gallery.ImageViewTouch2 mImageView;
    private android.view.View mNextImageView;
    private boolean mPaused;
    private android.content.SharedPreferences mPrefs;
    private android.view.View mPrevImageView;
    private android.view.View mRootView;
    private android.net.Uri mSavedUri;
    private boolean mShowControls;
    private final android.view.animation.Animation mShowNextImageViewAnimation;
    private final android.view.animation.Animation mShowPrevImageViewAnimation;
    private final com.techno.gallery.ImageViewTouchBase[] mSlideShowImageViews;
    private android.widget.ZoomButtonsController mZoomButtonsController;

    static {
        r0 = 3;
        r0 = new int[r0];
        r0 = {0, 1, -1};
        sOrderAdjacents = r0;
        return;
    }

    public ReviewImage() {
        r3 = this;
        r0 = 1;
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r1 = 0;
        r3.<init>();
        r3.mPaused = r0;
        r3.mShowControls = r0;
        r0 = new com.techno.gallery.GetterHandler;
        r0.<init>();
        r3.mHandler = r0;
        r0 = 0;
        r3.mCurrentPosition = r0;
        r0 = new android.view.animation.AlphaAnimation;
        r0.<init>(r2, r1);
        r3.mHideNextImageViewAnimation = r0;
        r0 = new android.view.animation.AlphaAnimation;
        r0.<init>(r2, r1);
        r3.mHidePrevImageViewAnimation = r0;
        r0 = new android.view.animation.AlphaAnimation;
        r0.<init>(r1, r2);
        r3.mShowNextImageViewAnimation = r0;
        r0 = new android.view.animation.AlphaAnimation;
        r0.<init>(r1, r2);
        r3.mShowPrevImageViewAnimation = r0;
        r0 = 2;
        r0 = new com.techno.gallery.ImageViewTouchBase[r0];
        r3.mSlideShowImageViews = r0;
        r0 = new com.techno.gallery.ReviewImage$1;
        r0.<init>(r3);
        r3.mDismissOnScreenControlRunner = r0;
        r0 = new com.techno.gallery.ReviewImage$8;
        r0.<init>(r3);
        r3.mDeletePhotoRunnable = r0;
        return;
    }

    static /* synthetic */ void access$000(com.techno.gallery.ReviewImage r0) {
        r0.hideOnScreenControls();
        return;
    }

    static /* synthetic */ void access$100(com.techno.gallery.ReviewImage r0) {
        r0.showOnScreenControls();
        return;
    }

    static /* synthetic */ void access$200(com.techno.gallery.ReviewImage r0) {
        r0.scheduleDismissOnScreenControls();
        return;
    }

    static /* synthetic */ void access$400(com.techno.gallery.ReviewImage r0) {
        r0.updateZoomButtonsEnabled();
        return;
    }

    static /* synthetic */ com.techno.gallery.ImageViewTouch2 access$500(com.techno.gallery.ReviewImage r1) {
        r0 = r1.mImageView;
        return r0;
    }

    static /* synthetic */ android.widget.ZoomButtonsController access$600(com.techno.gallery.ReviewImage r1) {
        r0 = r1.mZoomButtonsController;
        return r0;
    }

    static /* synthetic */ boolean access$700(com.techno.gallery.ReviewImage r1) {
        r0 = r1.mPaused;
        return r0;
    }

    static /* synthetic */ com.techno.gallery.BitmapCache access$800(com.techno.gallery.ReviewImage r1) {
        r0 = r1.mCache;
        return r0;
    }

    static /* synthetic */ int[] access$900() {
        r0 = sOrderAdjacents;
        return r0;
    }

    private com.techno.gallery.gallery.IImageList buildImageListFromUri(android.net.Uri r6) {
        r5 = this;
        r2 = r5.mPrefs;
        r3 = "pref_gallery_sort_key";
        r4 = "descending";
        r1 = r2.getString(r3, r4);
        r0 = 1;
        r2 = r5.getContentResolver();
        r2 = com.techno.gallery.ImageManager.makeImageList(r6, r2, r0);
        return r2;
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

    private void hideOnScreenControls() {
        r5 = this;
        r3 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r2 = 4;
        r1 = r5.mNextImageView;
        r1 = r1.getVisibility();
        if (r1 != 0) goto L_0x001a;
    L_0x000b:
        r0 = r5.mHideNextImageViewAnimation;
        r0.setDuration(r3);
        r1 = r5.mNextImageView;
        r1.startAnimation(r0);
        r1 = r5.mNextImageView;
        r1.setVisibility(r2);
    L_0x001a:
        r1 = r5.mPrevImageView;
        r1 = r1.getVisibility();
        if (r1 != 0) goto L_0x0031;
    L_0x0022:
        r0 = r5.mHidePrevImageViewAnimation;
        r0.setDuration(r3);
        r1 = r5.mPrevImageView;
        r1.startAnimation(r0);
        r1 = r5.mPrevImageView;
        r1.setVisibility(r2);
    L_0x0031:
        r1 = r5.mZoomButtonsController;
        r2 = 0;
        r1.setVisible(r2);
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
        if (r6 != 0) goto L_0x0020;
    L_0x0007:
        r1 = r4.buildImageListFromUri(r5);
    L_0x000b:
        r4.mAllImages = r1;
        r1 = r4.mAllImages;
        r2 = r4.getContentResolver();
        r1.open(r2);
        r1 = r4.mAllImages;
        r0 = r1.getImageForUri(r5);
        if (r0 != 0) goto L_0x0022;
    L_0x001e:
        r1 = r3;
        goto L_0x0004;
    L_0x0020:
        r1 = r6;
        goto L_0x000b;
    L_0x0022:
        r1 = r4.mAllImages;
        r1 = r1.getImageIndex(r0);
        r4.mCurrentPosition = r1;
        r1 = 1;
        goto L_0x0004;
    }

    private void makeGetter() {
        r1 = this;
        r0 = new com.techno.gallery.ImageGetter;
        r0.<init>();
        r1.mGetter = r0;
        return;
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

    private void setButtonPanelVisibility(int r3, int r4) {
        r2 = this;
        r1 = r2.mControlBar;
        r0 = r1.findViewById(r3);
        r2 = r0.getParent();
        r2 = (android.view.View) r2;
        r2.setVisibility(r4);
        return;
    }

    private void setupOnScreenControls(android.view.View r3) {
        r2 = this;
        r0 = new com.techno.gallery.ReviewImage$3;
        r0.<init>(r2);
        r3.setOnTouchListener(r0);
        r2.setupZoomButtonController(r3, r0);
        r1 = 2131427412; // 0x7f0b0054 float:1.847644E38 double:1.053065061E-314;
        r1 = r3.findViewById(r1);
        r2.mNextImageView = r1;
        r1 = 2131427411; // 0x7f0b0053 float:1.8476437E38 double:1.0530650604E-314;
        r1 = r3.findViewById(r1);
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
        r1 = new com.techno.gallery.ReviewImage$MyGestureListener;
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
        r1 = new com.techno.gallery.ReviewImage$4;
        r1.<init>(r3, r4, r5);
        r0.setOnZoomListener(r1);
        return;
    }

    private void showOnScreenControls() {
        r2 = this;
        r0 = r2.mRootView;
        r0 = r0.getWindowToken();
        if (r0 != 0) goto L_0x0013;
    L_0x0008:
        r0 = r2.mHandler;
        r1 = new com.techno.gallery.ReviewImage$2;
        r1.<init>(r2);
        r0.postGetterCallback(r1);
    L_0x0012:
        return;
    L_0x0013:
        r2.updateNextPrevControls();
        r0 = r2.mAllImages;
        r1 = r2.mCurrentPosition;
        r0 = r0.getImageAt(r1);
        r0 = com.techno.gallery.ImageManager.isImage(r0);
        if (r0 == 0) goto L_0x002e;
    L_0x0024:
        r2.updateZoomButtonsEnabled();
        r0 = r2.mZoomButtonsController;
        r1 = 1;
        r0.setVisible(r1);
        goto L_0x0012;
    L_0x002e:
        r0 = r2.mZoomButtonsController;
        r1 = 0;
        r0.setVisible(r1);
        goto L_0x0012;
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
        r3 = "ReviewImage";
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
        r7 = this;
        r6 = 2131427405; // 0x7f0b004d float:1.8476425E38 double:1.0530650574E-314;
        r5 = 2131427331; // 0x7f0b0003 float:1.8476275E38 double:1.053065021E-314;
        r4 = 8;
        r3 = 0;
        r1 = r7.isPickIntent();
        if (r1 == 0) goto L_0x0010;
    L_0x000f:
        return;
    L_0x0010:
        r1 = r7.mAllImages;
        r2 = r7.mCurrentPosition;
        r0 = r1.getImageAt(r2);
        r1 = r0 instanceof com.techno.gallery.gallery.VideoObject;
        if (r1 == 0) goto L_0x0023;
    L_0x001c:
        r7.setButtonPanelVisibility(r6, r4);
        r7.setButtonPanelVisibility(r5, r3);
        goto L_0x000f;
    L_0x0023:
        r7.setButtonPanelVisibility(r6, r3);
        r7.setButtonPanelVisibility(r5, r4);
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

    public boolean dispatchTouchEvent(android.view.MotionEvent r3) {
        r2 = this;
        r0 = r2.mZoomButtonsController;
        r0 = r0.isVisible();
        if (r0 == 0) goto L_0x0014;
    L_0x0008:
        r0 = r2.mZoomButtonsController;
        r1 = 0;
        r0 = r0.onTouch(r1, r3);
        if (r0 == 0) goto L_0x0014;
    L_0x0011:
        r2.scheduleDismissOnScreenControls();
    L_0x0014:
        r0 = super.dispatchTouchEvent(r3);
        if (r0 != 0) goto L_0x0021;
    L_0x001a:
        r0 = r2.mGestureDetector;
        r0 = r0.onTouchEvent(r3);
    L_0x0020:
        return r0;
    L_0x0021:
        r0 = 1;
        goto L_0x0020;
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

    protected void onActivityResult(int r2, int r3, android.content.Intent r4) {
        r1 = this;
        switch(r2) {
            case 490: goto L_0x0004;
            default: goto L_0x0003;
        };
    L_0x0003:
        return;
    L_0x0004:
        r0 = -1;
        if (r3 != r0) goto L_0x0003;
    L_0x0007:
        r0 = r4.getAction();
        r0 = android.net.Uri.parse(r0);
        r1.mSavedUri = r0;
        goto L_0x0003;
    }

    public void onClick(android.view.View r7) {
        r6 = this;
        r3 = r7.getId();
        switch(r3) {
            case 2131427331: goto L_0x0016;
            case 2131427333: goto L_0x0059;
            case 2131427403: goto L_0x0008;
            case 2131427404: goto L_0x001a;
            case 2131427405: goto L_0x0030;
            case 2131427411: goto L_0x0062;
            case 2131427412: goto L_0x005d;
            default: goto L_0x0007;
        };
    L_0x0007:
        return;
    L_0x0008:
        r3 = r6.mDeletePhotoRunnable;
        r4 = r6.mAllImages;
        r5 = r6.mCurrentPosition;
        r4 = r4.getImageAt(r5);
        com.techno.gallery.MenuHelper.deleteImage(r6, r3, r4);
        goto L_0x0007;
    L_0x0016:
        r6.startPlayVideoActivity();
        goto L_0x0007;
    L_0x001a:
        r3 = r6.mAllImages;
        r4 = r6.mCurrentPosition;
        r1 = r3.getImageAt(r4);
        r3 = r1.fullSizeImageUri();
        r3 = com.techno.gallery.MenuHelper.isWhiteListUri(r3);
        if (r3 == 0) goto L_0x0007;
    L_0x002c:
        r6.startShareMediaActivity(r1);
        goto L_0x0007;
    L_0x0030:
        r3 = r6.mAllImages;
        r4 = r6.mCurrentPosition;
        r1 = r3.getImageAt(r4);
        r2 = com.techno.gallery.Util.createSetAsIntent(r1);
        r3 = 2131296420; // 0x7f0900a4 float:1.8210756E38 double:1.053000342E-314;
        r3 = r6.getText(r3);	 Catch:{ ActivityNotFoundException -> 0x004b }
        r3 = android.content.Intent.createChooser(r2, r3);	 Catch:{ ActivityNotFoundException -> 0x004b }
        r6.startActivity(r3);	 Catch:{ ActivityNotFoundException -> 0x004b }
        goto L_0x0007;
    L_0x004b:
        r3 = move-exception;
        r0 = r3;
        r3 = 2131296311; // 0x7f090037 float:1.8210535E38 double:1.0530002884E-314;
        r4 = 0;
        r3 = android.widget.Toast.makeText(r6, r3, r4);
        r3.show();
        goto L_0x0007;
    L_0x0059:
        r6.finish();
        goto L_0x0007;
    L_0x005d:
        r3 = 1;
        r6.moveNextOrPrevious(r3);
        goto L_0x0007;
    L_0x0062:
        r3 = -1;
        r6.moveNextOrPrevious(r3);
        goto L_0x0007;
    }

    public void onCreate(android.os.Bundle r19) {
        r18 = this;
        super.onCreate(r19);
        r8 = r18.getIntent();
        r15 = "android.intent.extra.fullScreen";
        r16 = 1;
        r0 = r8;
        r1 = r15;
        r2 = r16;
        r15 = r0.getBooleanExtra(r1, r2);
        r0 = r15;
        r1 = r18;
        r1.mFullScreenInNormalMode = r0;
        r15 = android.preference.PreferenceManager.getDefaultSharedPreferences(r18);
        r0 = r15;
        r1 = r18;
        r1.mPrefs = r0;
        r15 = 2;
        r0 = r18;
        r1 = r15;
        r0.setDefaultKeyMode(r1);
        r15 = 1;
        r0 = r18;
        r1 = r15;
        r0.requestWindowFeature(r1);
        r15 = 2130903056; // 0x7f030010 float:1.741292E38 double:1.0528059946E-314;
        r0 = r18;
        r1 = r15;
        r0.setContentView(r1);
        r15 = 2131427390; // 0x7f0b003e float:1.8476395E38 double:1.05306505E-314;
        r0 = r18;
        r1 = r15;
        r15 = r0.findViewById(r1);
        r0 = r15;
        r1 = r18;
        r1.mRootView = r0;
        r15 = 2131427328; // 0x7f0b0000 float:1.847627E38 double:1.0530650194E-314;
        r0 = r18;
        r1 = r15;
        r15 = r0.findViewById(r1);
        r0 = r15;
        r1 = r18;
        r1.mControlBar = r0;
        r15 = 2131427341; // 0x7f0b000d float:1.8476296E38 double:1.053065026E-314;
        r0 = r18;
        r1 = r15;
        r3 = r0.findViewById(r1);
        r3 = (com.techno.gallery.ImageViewTouch2) r3;
        r0 = r3;
        r1 = r18;
        r1.mImageView = r0;
        r0 = r18;
        r0 = r0.mImageView;
        r15 = r0;
        r16 = 1;
        r15.setEnableTrackballScroll(r16);
        r15 = new com.techno.gallery.BitmapCache;
        r16 = 3;
        r15.<init>(r16);
        r0 = r15;
        r1 = r18;
        r1.mCache = r0;
        r0 = r18;
        r0 = r0.mImageView;
        r15 = r0;
        r0 = r18;
        r0 = r0.mCache;
        r16 = r0;
        r15.setRecycler(r16);
        r18.makeGetter();
        r0 = r18;
        r0 = r0.mSlideShowImageViews;
        r15 = r0;
        r16 = 0;
        r17 = 2131427408; // 0x7f0b0050 float:1.8476431E38 double:1.053065059E-314;
        r0 = r18;
        r1 = r17;
        r3 = r0.findViewById(r1);
        r3 = (com.techno.gallery.ImageViewTouchBase) r3;
        r15[r16] = r3;
        r0 = r18;
        r0 = r0.mSlideShowImageViews;
        r15 = r0;
        r16 = 1;
        r17 = 2131427409; // 0x7f0b0051 float:1.8476433E38 double:1.0530650594E-314;
        r0 = r18;
        r1 = r17;
        r3 = r0.findViewById(r1);
        r3 = (com.techno.gallery.ImageViewTouchBase) r3;
        r15[r16] = r3;
        r0 = r18;
        r0 = r0.mSlideShowImageViews;
        r3 = r0;
        r9 = r3.length;
        r5 = 0;
    L_0x00c0:
        if (r5 >= r9) goto L_0x00d3;
    L_0x00c2:
        r13 = r3[r5];
        r15 = 4;
        r13.setVisibility(r15);
        r0 = r18;
        r0 = r0.mCache;
        r15 = r0;
        r13.setRecycler(r15);
        r5 = r5 + 1;
        goto L_0x00c0;
    L_0x00d3:
        r15 = r18.getIntent();
        r12 = r15.getData();
        r15 = r18.getIntent();
        r16 = "image_list";
        r7 = r15.getParcelableExtra(r16);
        r7 = (com.techno.gallery.gallery.IImageList) r7;
        if (r19 == 0) goto L_0x0106;
    L_0x00e9:
        r15 = "uri";
        r0 = r19;
        r1 = r15;
        r12 = r0.getParcelable(r1);
        r12 = (android.net.Uri) r12;
        r15 = "show_controls";
        r16 = 1;
        r0 = r19;
        r1 = r15;
        r2 = r16;
        r15 = r0.getBoolean(r1, r2);
        r0 = r15;
        r1 = r18;
        r1.mShowControls = r0;
    L_0x0106:
        r0 = r18;
        r1 = r12;
        r2 = r7;
        r15 = r0.init(r1, r2);
        if (r15 != 0) goto L_0x0114;
    L_0x0110:
        r18.finish();
    L_0x0113:
        return;
    L_0x0114:
        r15 = 2;
        r10 = new int[r15];
        r10 = {2131427421, 2131427422};
        r15 = 5;
        r11 = new int[r15];
        r11 = {2131427403, 2131427404, 2131427405, 2131427331, 2131427333};
        r15 = r18.isPickIntent();
        if (r15 == 0) goto L_0x014d;
    L_0x0126:
        r4 = r10;
    L_0x0127:
        r3 = r4;
        r9 = r3.length;
        r5 = 0;
    L_0x012a:
        if (r5 >= r9) goto L_0x014f;
    L_0x012c:
        r6 = r3[r5];
        r0 = r18;
        r0 = r0.mControlBar;
        r15 = r0;
        r14 = r15.findViewById(r6);
        r0 = r14;
        r1 = r18;
        r0.setOnClickListener(r1);
        r19 = r14.getParent();
        r19 = (android.view.View) r19;
        r15 = 0;
        r0 = r19;
        r1 = r15;
        r0.setVisibility(r1);
        r5 = r5 + 1;
        goto L_0x012a;
    L_0x014d:
        r4 = r11;
        goto L_0x0127;
    L_0x014f:
        r0 = r18;
        r0 = r0.mFullScreenInNormalMode;
        r15 = r0;
        if (r15 == 0) goto L_0x015f;
    L_0x0156:
        r15 = r18.getWindow();
        r16 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r15.addFlags(r16);
    L_0x015f:
        r15 = 2131427406; // 0x7f0b004e float:1.8476427E38 double:1.053065058E-314;
        r0 = r18;
        r1 = r15;
        r15 = r0.findViewById(r1);
        r0 = r18;
        r1 = r15;
        r0.setupOnScreenControls(r1);
        goto L_0x0113;
    }

    public boolean onCreateOptionsMenu(android.view.Menu r12) {
        r11 = this;
        r10 = 2131296373; // 0x7f090075 float:1.821066E38 double:1.053000319E-314;
        r9 = 196608; // 0x30000 float:2.75506E-40 double:9.71373E-319;
        r8 = 203; // 0xcb float:2.84E-43 double:1.003E-321;
        r7 = 0;
        super.onCreateOptionsMenu(r12);
        r1 = -1;
        r3 = r11.mHandler;
        r4 = r11.mDeletePhotoRunnable;
        r5 = new com.techno.gallery.ReviewImage$5;
        r5.<init>(r11);
        r0 = r12;
        r2 = r11;
        r0 = com.techno.gallery.MenuHelper.addImageMenuItems(r0, r1, r2, r3, r4, r5);
        r11.mImageMenuRunnable = r0;
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r12.add(r9, r8, r0, r10);
        r0 = new com.techno.gallery.ReviewImage$6;
        r0.<init>(r11);
        r6.setOnMenuItemClickListener(r0);
        r0 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r6.setAlphabeticShortcut(r0);
        r0 = 17301577; // 0x1080049 float:2.497946E-38 double:8.548115E-317;
        r6.setIcon(r0);
        r0 = r12.add(r9, r8, r7, r10);
        r1 = new com.techno.gallery.ReviewImage$7;
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

    public boolean onPrepareOptionsMenu(android.view.Menu r5) {
        r4 = this;
        super.onPrepareOptionsMenu(r5);
        r1 = r4.mImageMenuRunnable;
        if (r1 == 0) goto L_0x0014;
    L_0x0007:
        r1 = r4.mImageMenuRunnable;
        r2 = r4.mAllImages;
        r3 = r4.mCurrentPosition;
        r2 = r2.getImageAt(r3);
        r1.gettingReadyToOpen(r5, r2);
    L_0x0014:
        r1 = r4.mAllImages;
        r2 = r4.mCurrentPosition;
        r1 = r1.getImageAt(r2);
        r0 = r1.fullSizeImageUri();
        r1 = com.techno.gallery.MenuHelper.isWhiteListUri(r0);
        com.techno.gallery.MenuHelper.enableShareMenuItem(r5, r1);
        r1 = 1;
        return r1;
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
        r0 = "show_controls";
        r1 = r3.mShowControls;
        r4.putBoolean(r0, r1);
        return;
    }

    public void onStart() {
        r4 = this;
        r3 = 0;
        super.onStart();
        r4.mPaused = r3;
        r1 = r4.mSavedUri;
        r2 = r4.mAllImages;
        r4.init(r1, r2);
        r1 = r4.mAllImages;
        r0 = r1.getCount();
        if (r0 != 0) goto L_0x0019;
    L_0x0015:
        r4.finish();
    L_0x0018:
        return;
    L_0x0019:
        r1 = r4.mCurrentPosition;
        if (r0 > r1) goto L_0x0022;
    L_0x001d:
        r1 = 1;
        r1 = r0 - r1;
        r4.mCurrentPosition = r1;
    L_0x0022:
        r1 = r4.mGetter;
        if (r1 != 0) goto L_0x0029;
    L_0x0026:
        r4.makeGetter();
    L_0x0029:
        r1 = r4.mCurrentPosition;
        r2 = r4.mShowControls;
        r4.setImage(r1, r2);
        r4.mShowControls = r3;
        goto L_0x0018;
    }

    public void onStop() {
        r5 = this;
        super.onStop();
        r4 = 1;
        r5.mPaused = r4;
        r4 = r5.mGetter;
        r4.cancelCurrent();
        r4 = r5.mGetter;
        r4.stop();
        r4 = 0;
        r5.mGetter = r4;
        r4 = r5.mHandler;
        r4.removeAllGetterCallbacks();
        r4 = r5.getCurrentUri();
        r5.mSavedUri = r4;
        r4 = r5.mAllImages;
        r4.deactivate();
        r5.hideOnScreenControls();
        r4 = r5.mImageView;
        r4.clear();
        r4 = r5.mCache;
        r4.clear();
        r0 = r5.mSlideShowImageViews;
        r3 = r0.length;
        r1 = 0;
    L_0x0034:
        if (r1 >= r3) goto L_0x003e;
    L_0x0036:
        r2 = r0[r1];
        r2.clear();
        r1 = r1 + 1;
        goto L_0x0034;
    L_0x003e:
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
        r1 = new com.techno.gallery.ReviewImage$9;
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
}