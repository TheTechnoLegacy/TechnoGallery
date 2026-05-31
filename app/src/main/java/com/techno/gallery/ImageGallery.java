package com.techno.gallery;

public class ImageGallery extends android.app.Activity implements com.techno.gallery.GridViewSpecial.Listener, com.techno.gallery.GridViewSpecial.DrawAdapter {
    public static final int CROP_MSG = 2;
    private static final float INVALID_POSITION = -1.0f;
    private static final java.lang.String STATE_SCROLL_POSITION = "scroll_position";
    private static final java.lang.String STATE_SELECTED_INDEX = "first_index";
    private static final java.lang.String TAG = "ImageGallery";
    private com.techno.gallery.gallery.IImageList mAllImages;
    private boolean mConfigurationChanged;
    private android.net.Uri mCropResultUri;
    private final java.lang.Runnable mDeletePhotoRunnable;
    private final android.graphics.Rect mDstRect;
    private android.view.animation.Animation mFooterAppear;
    private android.view.animation.Animation mFooterDisappear;
    private android.view.View mFooterOrganizeView;
    private com.techno.gallery.GridViewSpecial mGvs;
    private final android.os.Handler mHandler;
    private int mInclusion;
    private boolean mLayoutComplete;
    private com.techno.gallery.ImageLoader mLoader;
    private android.app.Dialog mMediaScanningDialog;
    private android.graphics.Bitmap mMissingImageThumbnailBitmap;
    private android.graphics.Bitmap mMissingVideoThumbnailBitmap;
    private android.graphics.drawable.Drawable mMultiSelectFalse;
    private android.graphics.drawable.Drawable mMultiSelectTrue;
    private java.util.HashSet<com.techno.gallery.gallery.IImage> mMultiSelected;
    private android.view.View mNoImagesView;
    private boolean mPausing;
    private android.content.SharedPreferences mPrefs;
    private android.content.BroadcastReceiver mReceiver;
    private float mScrollPosition;
    private int mSelectedIndex;
    private android.view.MenuItem mSlideShowItem;
    boolean mSortAscending;
    private final android.graphics.Rect mSrcRect;
    private android.graphics.drawable.Drawable mVideoMmsErrorOverlay;
    private android.graphics.drawable.Drawable mVideoOverlay;
    private long mVideoSizeLimit;

    public ImageGallery() {
        r4 = this;
        r3 = 0;
        r2 = 0;
        r4.<init>();
        r4.mSortAscending = r2;
        r0 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r4.mVideoSizeLimit = r0;
        r4.mReceiver = r3;
        r0 = new android.os.Handler;
        r0.<init>();
        r4.mHandler = r0;
        r0 = 1;
        r4.mPausing = r0;
        r0 = -1;
        r4.mSelectedIndex = r0;
        r0 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r4.mScrollPosition = r0;
        r4.mConfigurationChanged = r2;
        r4.mMultiSelected = r3;
        r0 = new com.techno.gallery.ImageGallery$4;
        r0.<init>(r4);
        r4.mDeletePhotoRunnable = r0;
        r0 = new android.graphics.Rect;
        r0.<init>();
        r4.mSrcRect = r0;
        r0 = new android.graphics.Rect;
        r0.<init>();
        r4.mDstRect = r0;
        return;
    }

    static /* synthetic */ void access$100(com.techno.gallery.ImageGallery r0) {
        r0.onDeleteMultipleClicked();
        return;
    }

    static /* synthetic */ boolean access$1100(com.techno.gallery.ImageGallery r1) {
        r0 = r1.isInMultiSelectMode();
        return r0;
    }

    static /* synthetic */ void access$1200(com.techno.gallery.ImageGallery r0) {
        r0.openMultiSelectMode();
        return;
    }

    static /* synthetic */ boolean access$1300(com.techno.gallery.ImageGallery r1) {
        r0 = r1.mLayoutComplete;
        return r0;
    }

    static /* synthetic */ android.os.Handler access$1400(com.techno.gallery.ImageGallery r1) {
        r0 = r1.mHandler;
        return r0;
    }

    static /* synthetic */ boolean access$1700(com.techno.gallery.ImageGallery r1) {
        r0 = r1.mPausing;
        return r0;
    }

    static /* synthetic */ int access$1800(com.techno.gallery.ImageGallery r1) {
        r0 = r1.mInclusion;
        return r0;
    }

    static /* synthetic */ java.lang.Runnable access$1900(com.techno.gallery.ImageGallery r1) {
        r0 = r1.mDeletePhotoRunnable;
        return r0;
    }

    static /* synthetic */ void access$200(com.techno.gallery.ImageGallery r0) {
        r0.closeMultiSelectMode();
        return;
    }

    static /* synthetic */ android.net.Uri access$2000(com.techno.gallery.ImageGallery r1) {
        r0 = r1.getCurrentImageUri();
        return r0;
    }

    static /* synthetic */ android.view.MenuItem access$2100(com.techno.gallery.ImageGallery r1, android.view.Menu r2, int r3) {
        r0 = r1.addSlideShowMenu(r2, r3);
        return r0;
    }

    static /* synthetic */ java.util.HashSet access$2200(com.techno.gallery.ImageGallery r1) {
        r0 = r1.mMultiSelected;
        return r0;
    }

    static /* synthetic */ void access$300(com.techno.gallery.ImageGallery r0) {
        r0.stopCheckingThumbnails();
        return;
    }

    static /* synthetic */ com.techno.gallery.gallery.IImage access$400(com.techno.gallery.ImageGallery r1) {
        r0 = r1.getCurrentImage();
        return r0;
    }

    static /* synthetic */ com.techno.gallery.GridViewSpecial access$500(com.techno.gallery.ImageGallery r1) {
        r0 = r1.mGvs;
        return r0;
    }

    static /* synthetic */ com.techno.gallery.gallery.IImageList access$600(com.techno.gallery.ImageGallery r1) {
        r0 = r1.mAllImages;
        return r0;
    }

    static /* synthetic */ void access$700(com.techno.gallery.ImageGallery r0) {
        r0.checkThumbnails();
        return;
    }

    static /* synthetic */ android.view.View access$800(com.techno.gallery.ImageGallery r1) {
        r0 = r1.mNoImagesView;
        return r0;
    }

    static /* synthetic */ void access$900(com.techno.gallery.ImageGallery r0, boolean r1, boolean r2) {
        r0.rebake(r1, r2);
        return;
    }

    private android.view.MenuItem addSlideShowMenu(android.view.Menu r4, int r5) {
        r3 = this;
        r0 = 0;
        r1 = 207; // 0xcf float:2.9E-43 double:1.023E-321;
        r2 = 2131296284; // 0x7f09001c float:1.821048E38 double:1.053000275E-314;
        r0 = r4.add(r0, r1, r5, r2);
        r1 = new com.techno.gallery.ImageGallery$3;
        r1.<init>(r3);
        r0 = r0.setOnMenuItemClickListener(r1);
        r1 = 17301587; // 0x1080053 float:2.4979488E-38 double:8.54812E-317;
        r0 = r0.setIcon(r1);
        return r0;
    }

    private com.techno.gallery.gallery.IImageList allImages(boolean r8) {
        r7 = this;
        r2 = r7.getIntent();
        r1 = r2.getData();
        if (r8 != 0) goto L_0x000f;
    L_0x000a:
        r0 = com.techno.gallery.ImageManager.emptyImageList();
    L_0x000e:
        return r0;
    L_0x000f:
        r2 = r7.getContentResolver();
        r3 = com.techno.gallery.ImageManager.DataLocation.EXTERNAL;
        r4 = r7.mInclusion;
        r5 = r7.mSortAscending;
        if (r5 == 0) goto L_0x0029;
    L_0x001b:
        r5 = 1;
    L_0x001c:
        if (r1 == 0) goto L_0x002b;
    L_0x001e:
        r6 = "bucketId";
        r6 = r1.getQueryParameter(r6);
    L_0x0024:
        r0 = com.techno.gallery.ImageManager.allImages(r2, r3, r4, r5, r6);
        goto L_0x000e;
    L_0x0029:
        r5 = 2;
        goto L_0x001c;
    L_0x002b:
        r6 = 0;
        goto L_0x0024;
    }

    private void checkThumbnails() {
        r3 = this;
        r0 = new com.techno.gallery.ImageGallery$MyThumbCheckCallback;
        r1 = 0;
        r0.<init>(r3, r1);
        r1 = r3.mLoader;
        r2 = r3.mAllImages;
        r1.startCheckingThumbnails(r2, r0);
        return;
    }

    private void closeMultiSelectMode() {
        r1 = this;
        r0 = r1.mMultiSelected;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = 0;
        r1.mMultiSelected = r0;
        r0 = r1.mGvs;
        r0.invalidate();
        r1.hideFooter();
        goto L_0x0004;
    }

    private com.techno.gallery.gallery.IImage getCurrentImage() {
        r2 = this;
        r1 = r2.mGvs;
        r0 = r1.getCurrentSelection();
        if (r0 < 0) goto L_0x0010;
    L_0x0008:
        r1 = r2.mAllImages;
        r1 = r1.getCount();
        if (r0 < r1) goto L_0x0012;
    L_0x0010:
        r1 = 0;
    L_0x0011:
        return r1;
    L_0x0012:
        r1 = r2.mAllImages;
        r1 = r1.getImageAt(r0);
        goto L_0x0011;
    }

    private android.net.Uri getCurrentImageUri() {
        r2 = this;
        r0 = r2.getCurrentImage();
        if (r0 == 0) goto L_0x000b;
    L_0x0006:
        r1 = r0.fullSizeImageUri();
    L_0x000a:
        return r1;
    L_0x000b:
        r1 = 0;
        goto L_0x000a;
    }

    private void hideFooter() {
        r2 = this;
        r1 = 8;
        r0 = r2.mFooterOrganizeView;
        r0 = r0.getVisibility();
        if (r0 == r1) goto L_0x0023;
    L_0x000a:
        r0 = r2.mFooterOrganizeView;
        r0.setVisibility(r1);
        r0 = r2.mFooterDisappear;
        if (r0 != 0) goto L_0x001c;
    L_0x0013:
        r0 = 2130968577; // 0x7f040001 float:1.7545812E38 double:1.0528383663E-314;
        r0 = android.view.animation.AnimationUtils.loadAnimation(r2, r0);
        r2.mFooterDisappear = r0;
    L_0x001c:
        r0 = r2.mFooterOrganizeView;
        r1 = r2.mFooterDisappear;
        r0.startAnimation(r1);
    L_0x0023:
        return;
    }

    private void initializeFooterButtons() {
        r3 = this;
        r2 = 2131427396; // 0x7f0b0044 float:1.8476407E38 double:1.053065053E-314;
        r1 = r3.findViewById(r2);
        r1 = (android.widget.Button) r1;
        r2 = new com.techno.gallery.ImageGallery$1;
        r2.<init>(r3);
        r1.setOnClickListener(r2);
        r2 = 2131427397; // 0x7f0b0045 float:1.847641E38 double:1.0530650535E-314;
        r0 = r3.findViewById(r2);
        r0 = (android.widget.Button) r0;
        r2 = new com.techno.gallery.ImageGallery$2;
        r2.<init>(r3);
        r0.setOnClickListener(r2);
        return;
    }

    private void initializeMultiSelectDrawables() {
        r2 = this;
        r0 = r2.mMultiSelectTrue;
        if (r0 != 0) goto L_0x0011;
    L_0x0004:
        r0 = r2.getResources();
        r1 = 2130837524; // 0x7f020014 float:1.7280005E38 double:1.0527736175E-314;
        r0 = r0.getDrawable(r1);
        r2.mMultiSelectTrue = r0;
    L_0x0011:
        r0 = r2.mMultiSelectFalse;
        if (r0 != 0) goto L_0x0022;
    L_0x0015:
        r0 = r2.getResources();
        r1 = 2130837523; // 0x7f020013 float:1.7280002E38 double:1.052773617E-314;
        r0 = r0.getDrawable(r1);
        r2.mMultiSelectFalse = r0;
    L_0x0022:
        return;
    }

    private boolean isImageType(java.lang.String r2) {
        r1 = this;
        r0 = "vnd.android.cursor.dir/image";
        r0 = r2.equals(r0);
        if (r0 != 0) goto L_0x0010;
    L_0x0008:
        r0 = "image/*";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x0012;
    L_0x0010:
        r0 = 1;
    L_0x0011:
        return r0;
    L_0x0012:
        r0 = 0;
        goto L_0x0011;
    }

    private boolean isInMultiSelectMode() {
        r1 = this;
        r0 = r1.mMultiSelected;
        if (r0 == 0) goto L_0x0006;
    L_0x0004:
        r0 = 1;
    L_0x0005:
        return r0;
    L_0x0006:
        r0 = 0;
        goto L_0x0005;
    }

    private boolean isPickIntent() {
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

    private boolean isVideoSelected() {
        r2 = this;
        r0 = r2.getCurrentImage();
        if (r0 == 0) goto L_0x000e;
    L_0x0006:
        r1 = com.techno.gallery.ImageManager.isVideo(r0);
        if (r1 == 0) goto L_0x000e;
    L_0x000c:
        r1 = 1;
    L_0x000d:
        return r1;
    L_0x000e:
        r1 = 0;
        goto L_0x000d;
    }

    private boolean isVideoType(java.lang.String r2) {
        r1 = this;
        r0 = "vnd.android.cursor.dir/video";
        r0 = r2.equals(r0);
        if (r0 != 0) goto L_0x0010;
    L_0x0008:
        r0 = "video/*";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x0012;
    L_0x0010:
        r0 = 1;
    L_0x0011:
        return r0;
    L_0x0012:
        r0 = 0;
        goto L_0x0011;
    }

    private void launchCropperOrFinish(com.techno.gallery.gallery.IImage r14) {
        r13 = this;
        r12 = 0;
        r11 = -1;
        r9 = r13.getIntent();
        r4 = r9.getExtras();
        r7 = com.techno.gallery.MenuHelper.getImageFileSize(r14);
        r9 = 0;
        r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r9 >= 0) goto L_0x0015;
    L_0x0014:
        return;
    L_0x0015:
        r9 = r13.mVideoSizeLimit;
        r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r9 <= 0) goto L_0x0045;
    L_0x001b:
        r1 = new com.techno.gallery.ImageGallery$5;
        r1.<init>(r13);
        r9 = new android.app.AlertDialog$Builder;
        r9.<init>(r13);
        r10 = 17301659; // 0x108009b float:2.497969E-38 double:8.5481553E-317;
        r9 = r9.setIcon(r10);
        r10 = 2131296431; // 0x7f0900af float:1.8210778E38 double:1.0530003477E-314;
        r9 = r9.setTitle(r10);
        r10 = 2131296432; // 0x7f0900b0 float:1.821078E38 double:1.053000348E-314;
        r9 = r9.setMessage(r10);
        r10 = 2131296410; // 0x7f09009a float:1.8210736E38 double:1.0530003373E-314;
        r9 = r9.setNeutralButton(r10, r1);
        r9.show();
        goto L_0x0014;
    L_0x0045:
        if (r4 == 0) goto L_0x0080;
    L_0x0047:
        r9 = "crop";
        r9 = r4.getString(r9);
        r3 = r9;
    L_0x004e:
        if (r3 == 0) goto L_0x0082;
    L_0x0050:
        r5 = new android.os.Bundle;
        r5.<init>();
        r9 = "circle";
        r9 = r3.equals(r9);
        if (r9 == 0) goto L_0x0064;
    L_0x005d:
        r9 = "circleCrop";
        r10 = "true";
        r5.putString(r9, r10);
    L_0x0064:
        r2 = new android.content.Intent;
        r2.<init>();
        r9 = r14.fullSizeImageUri();
        r2.setData(r9);
        r9 = com.techno.gallery.CropImage.class;
        r2.setClass(r13, r9);
        r2.putExtras(r5);
        r2.putExtras(r4);
        r9 = 2;
        r13.startActivityForResult(r2, r9);
        goto L_0x0014;
    L_0x0080:
        r3 = r12;
        goto L_0x004e;
    L_0x0082:
        r6 = new android.content.Intent;
        r9 = r14.fullSizeImageUri();
        r6.<init>(r12, r9);
        if (r4 == 0) goto L_0x00a3;
    L_0x008d:
        r9 = "return-data";
        r9 = r4.getBoolean(r9);
        if (r9 == 0) goto L_0x00a3;
    L_0x0095:
        r9 = 102400; // 0x19000 float:1.43493E-40 double:5.05923E-319;
        r0 = r14.fullSizeBitmap(r11, r9);
        if (r0 == 0) goto L_0x00a3;
    L_0x009e:
        r9 = "data";
        r6.putExtra(r9, r0);
    L_0x00a3:
        r13.setResult(r11, r6);
        r13.finish();
        goto L_0x0014;
    }

    private void onDeleteMultipleClicked() {
        r1 = this;
        r0 = new com.techno.gallery.ImageGallery$9;
        r0.<init>(r1);
        com.techno.gallery.MenuHelper.deleteMultiple(r1, r0);
        return;
    }

    private void openMultiSelectMode() {
        r1 = this;
        r0 = r1.mMultiSelected;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = new java.util.HashSet;
        r0.<init>();
        r1.mMultiSelected = r0;
        r0 = r1.mGvs;
        r0.invalidate();
        goto L_0x0004;
    }

    private void rebake(boolean r6, boolean r7) {
        r5 = this;
        r4 = 0;
        r3 = 0;
        r2 = 1;
        r5.stopCheckingThumbnails();
        r0 = r5.mGvs;
        r0.stop();
        r0 = r5.mAllImages;
        if (r0 == 0) goto L_0x0016;
    L_0x000f:
        r0 = r5.mAllImages;
        r0.deactivate();
        r5.mAllImages = r3;
    L_0x0016:
        r0 = r5.mMediaScanningDialog;
        if (r0 == 0) goto L_0x0021;
    L_0x001a:
        r0 = r5.mMediaScanningDialog;
        r0.cancel();
        r5.mMediaScanningDialog = r3;
    L_0x0021:
        if (r7 == 0) goto L_0x0034;
    L_0x0023:
        r0 = r5.getResources();
        r1 = 2131296270; // 0x7f09000e float:1.8210452E38 double:1.053000268E-314;
        r0 = r0.getString(r1);
        r0 = android.app.ProgressDialog.show(r5, r3, r0, r2, r2);
        r5.mMediaScanningDialog = r0;
    L_0x0034:
        if (r6 != 0) goto L_0x006a;
    L_0x0036:
        if (r7 != 0) goto L_0x006a;
    L_0x0038:
        r0 = r2;
    L_0x0039:
        r0 = r5.allImages(r0);
        r5.mAllImages = r0;
        r0 = r5.mGvs;
        r1 = r5.mAllImages;
        r0.setImageList(r1);
        r0 = r5.mGvs;
        r0.setDrawAdapter(r5);
        r0 = r5.mGvs;
        r1 = r5.mLoader;
        r0.setLoader(r1);
        r0 = r5.mGvs;
        r0.start();
        r5.checkThumbnails();
        r0 = r5.mNoImagesView;
        r1 = r5.mAllImages;
        r1 = r1.getCount();
        if (r1 <= 0) goto L_0x006c;
    L_0x0064:
        r1 = 8;
    L_0x0066:
        r0.setVisibility(r1);
        return;
    L_0x006a:
        r0 = r4;
        goto L_0x0039;
    L_0x006c:
        r1 = r4;
        goto L_0x0066;
    }

    private void setupInclusion() {
        r7 = this;
        r5 = 5;
        r7.mInclusion = r5;
        r1 = r7.getIntent();
        if (r1 == 0) goto L_0x007c;
    L_0x0009:
        r4 = r1.resolveType(r7);
        r5 = 2131427345; // 0x7f0b0011 float:1.8476304E38 double:1.053065028E-314;
        r2 = r7.findViewById(r5);
        r2 = (android.widget.TextView) r2;
        if (r4 == 0) goto L_0x0042;
    L_0x0018:
        r5 = r7.isImageType(r4);
        if (r5 == 0) goto L_0x002d;
    L_0x001e:
        r5 = 1;
        r7.mInclusion = r5;
        r5 = r7.isPickIntent();
        if (r5 == 0) goto L_0x007d;
    L_0x0027:
        r5 = 2131296415; // 0x7f09009f float:1.8210746E38 double:1.05300034E-314;
        r2.setText(r5);
    L_0x002d:
        r5 = r7.isVideoType(r4);
        if (r5 == 0) goto L_0x0042;
    L_0x0033:
        r5 = 4;
        r7.mInclusion = r5;
        r5 = r7.isPickIntent();
        if (r5 == 0) goto L_0x0084;
    L_0x003c:
        r5 = 2131296417; // 0x7f0900a1 float:1.821075E38 double:1.0530003407E-314;
        r2.setText(r5);
    L_0x0042:
        r0 = r1.getExtras();
        if (r0 == 0) goto L_0x008b;
    L_0x0048:
        r5 = "windowTitle";
        r5 = r0.getString(r5);
        r3 = r5;
    L_0x004f:
        if (r3 == 0) goto L_0x005a;
    L_0x0051:
        r5 = r3.length();
        if (r5 <= 0) goto L_0x005a;
    L_0x0057:
        r2.setText(r3);
    L_0x005a:
        if (r0 == 0) goto L_0x0068;
    L_0x005c:
        r5 = "mediaTypes";
        r6 = r7.mInclusion;
        r5 = r0.getInt(r5, r6);
        r5 = r5 & 5;
        r7.mInclusion = r5;
    L_0x0068:
        if (r0 == 0) goto L_0x007c;
    L_0x006a:
        r5 = "pick-drm";
        r5 = r0.getBoolean(r5);
        if (r5 == 0) goto L_0x007c;
    L_0x0072:
        r5 = "ImageGallery";
        r6 = "pick-drm is true";
        android.util.Log.d(r5, r6);
        r5 = 2;
        r7.mInclusion = r5;
    L_0x007c:
        return;
    L_0x007d:
        r5 = 2131296414; // 0x7f09009e float:1.8210744E38 double:1.0530003393E-314;
        r2.setText(r5);
        goto L_0x002d;
    L_0x0084:
        r5 = 2131296416; // 0x7f0900a0 float:1.8210748E38 double:1.0530003403E-314;
        r2.setText(r5);
        goto L_0x0042;
    L_0x008b:
        r5 = 0;
        r3 = r5;
        goto L_0x004f;
    }

    private void showFooter() {
        r2 = this;
        r0 = r2.mFooterOrganizeView;
        r1 = 0;
        r0.setVisibility(r1);
        r0 = r2.mFooterAppear;
        if (r0 != 0) goto L_0x0012;
    L_0x000a:
        r0 = 2130968576; // 0x7f040000 float:1.754581E38 double:1.052838366E-314;
        r0 = android.view.animation.AnimationUtils.loadAnimation(r2, r0);
        r2.mFooterAppear = r0;
    L_0x0012:
        r0 = r2.mFooterOrganizeView;
        r1 = r2.mFooterAppear;
        r0.startAnimation(r1);
        return;
    }

    private void stopCheckingThumbnails() {
        r1 = this;
        r0 = r1.mLoader;
        r0.stopCheckingThumbnails();
        return;
    }

    private void toggleMultiSelected(com.techno.gallery.gallery.IImage r3) {
        r2 = this;
        r1 = r2.mMultiSelected;
        r0 = r1.size();
        r1 = r2.mMultiSelected;
        r1 = r1.add(r3);
        if (r1 != 0) goto L_0x0013;
    L_0x000e:
        r1 = r2.mMultiSelected;
        r1.remove(r3);
    L_0x0013:
        r1 = r2.mGvs;
        r1.invalidate();
        if (r0 != 0) goto L_0x001d;
    L_0x001a:
        r2.showFooter();
    L_0x001d:
        r1 = r2.mMultiSelected;
        r1 = r1.size();
        if (r1 != 0) goto L_0x0028;
    L_0x0025:
        r2.hideFooter();
    L_0x0028:
        return;
    }

    boolean canHandleEvent() {
        r1 = this;
        r0 = r1.mPausing;
        if (r0 != 0) goto L_0x000a;
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

    public void drawDecoration(android.graphics.Canvas r9, com.techno.gallery.gallery.IImage r10, int r11, int r12, int r13, int r14) {
        r8 = this;
        r5 = r8.mMultiSelected;
        if (r5 == 0) goto L_0x0033;
    L_0x0004:
        r8.initializeMultiSelectDrawables();
        r5 = r8.mMultiSelected;
        r5 = r5.contains(r10);
        if (r5 == 0) goto L_0x0034;
    L_0x000f:
        r5 = r8.mMultiSelectTrue;
        r0 = r5;
    L_0x0012:
        r4 = r0.getIntrinsicWidth();
        r1 = r0.getIntrinsicHeight();
        r2 = r11 + 5;
        r5 = r14 - r1;
        r6 = 5;
        r5 = r5 - r6;
        r3 = r5 + r12;
        r5 = r8.mSrcRect;
        r6 = r2 + r4;
        r7 = r3 + r1;
        r5.set(r2, r3, r6, r7);
        r5 = r8.mSrcRect;
        r0.setBounds(r5);
        r0.draw(r9);
    L_0x0033:
        return;
    L_0x0034:
        r5 = r8.mMultiSelectFalse;
        r0 = r5;
        goto L_0x0012;
    }

    public void drawImage(android.graphics.Canvas r26, com.techno.gallery.gallery.IImage r27, android.graphics.Bitmap r28, int r29, int r30, int r31, int r32) {
        r25 = this;
        if (r28 == 0) goto L_0x00f8;
    L_0x0002:
        r12 = r28.getWidth();
        r11 = r28.getHeight();
        r14 = r12 - r31;
        r13 = r11 - r32;
        r5 = 10;
        if (r14 >= r5) goto L_0x00c4;
    L_0x0012:
        r5 = 10;
        if (r13 >= r5) goto L_0x00c4;
    L_0x0016:
        r17 = r14 / 2;
        r16 = r13 / 2;
        r0 = r25;
        r0 = r0.mSrcRect;
        r5 = r0;
        r6 = r17 + 0;
        r7 = r16 + 0;
        r8 = r12 - r17;
        r9 = r11 - r16;
        r5.set(r6, r7, r8, r9);
        r0 = r25;
        r0 = r0.mDstRect;
        r5 = r0;
        r6 = r29 + r31;
        r7 = r30 + r32;
        r0 = r5;
        r1 = r29;
        r2 = r30;
        r3 = r6;
        r4 = r7;
        r0.set(r1, r2, r3, r4);
        r0 = r25;
        r0 = r0.mSrcRect;
        r5 = r0;
        r0 = r25;
        r0 = r0.mDstRect;
        r6 = r0;
        r7 = 0;
        r0 = r26;
        r1 = r28;
        r2 = r5;
        r3 = r6;
        r4 = r7;
        r0.drawBitmap(r1, r2, r3, r4);
    L_0x0052:
        r5 = com.techno.gallery.ImageManager.isVideo(r27);
        if (r5 == 0) goto L_0x00c3;
    L_0x0058:
        r20 = 0;
        r21 = com.techno.gallery.MenuHelper.getImageFileSize(r27);
        r5 = 0;
        r5 = (r21 > r5 ? 1 : (r21 == r5 ? 0 : -1));
        if (r5 < 0) goto L_0x014e;
    L_0x0064:
        r0 = r25;
        r0 = r0.mVideoSizeLimit;
        r5 = r0;
        r5 = (r21 > r5 ? 1 : (r21 == r5 ? 0 : -1));
        if (r5 > 0) goto L_0x014e;
    L_0x006d:
        r0 = r25;
        r0 = r0.mVideoOverlay;
        r5 = r0;
        if (r5 != 0) goto L_0x0084;
    L_0x0074:
        r5 = r25.getResources();
        r6 = 2130837587; // 0x7f020053 float:1.7280132E38 double:1.0527736486E-314;
        r5 = r5.getDrawable(r6);
        r0 = r5;
        r1 = r25;
        r1.mVideoOverlay = r0;
    L_0x0084:
        r0 = r25;
        r0 = r0.mVideoOverlay;
        r20 = r0;
    L_0x008a:
        r24 = r20.getIntrinsicWidth();
        r18 = r20.getIntrinsicHeight();
        r5 = r31 - r24;
        r5 = r5 / 2;
        r19 = r5 + r29;
        r5 = r32 - r18;
        r5 = r5 / 2;
        r23 = r5 + r30;
        r0 = r25;
        r0 = r0.mSrcRect;
        r5 = r0;
        r6 = r19 + r24;
        r7 = r23 + r18;
        r0 = r5;
        r1 = r19;
        r2 = r23;
        r3 = r6;
        r4 = r7;
        r0.set(r1, r2, r3, r4);
        r0 = r25;
        r0 = r0.mSrcRect;
        r5 = r0;
        r0 = r20;
        r1 = r5;
        r0.setBounds(r1);
        r0 = r20;
        r1 = r26;
        r0.draw(r1);
    L_0x00c3:
        return;
    L_0x00c4:
        r0 = r25;
        r0 = r0.mSrcRect;
        r5 = r0;
        r6 = 0;
        r7 = 0;
        r5.set(r6, r7, r12, r11);
        r0 = r25;
        r0 = r0.mDstRect;
        r5 = r0;
        r6 = r29 + r31;
        r7 = r30 + r32;
        r0 = r5;
        r1 = r29;
        r2 = r30;
        r3 = r6;
        r4 = r7;
        r0.set(r1, r2, r3, r4);
        r0 = r25;
        r0 = r0.mSrcRect;
        r5 = r0;
        r0 = r25;
        r0 = r0.mDstRect;
        r6 = r0;
        r7 = 0;
        r0 = r26;
        r1 = r28;
        r2 = r5;
        r3 = r6;
        r4 = r7;
        r0.drawBitmap(r1, r2, r3, r4);
        goto L_0x0052;
    L_0x00f8:
        r0 = r25;
        r1 = r27;
        r15 = r0.getErrorBitmap(r1);
        r24 = r15.getWidth();
        r18 = r15.getHeight();
        r0 = r25;
        r0 = r0.mSrcRect;
        r5 = r0;
        r6 = 0;
        r7 = 0;
        r0 = r5;
        r1 = r6;
        r2 = r7;
        r3 = r24;
        r4 = r18;
        r0.set(r1, r2, r3, r4);
        r5 = r31 - r24;
        r5 = r5 / 2;
        r19 = r5 + r29;
        r5 = r31 - r18;
        r5 = r5 / 2;
        r23 = r5 + r30;
        r0 = r25;
        r0 = r0.mDstRect;
        r5 = r0;
        r6 = r19 + r24;
        r7 = r23 + r18;
        r0 = r5;
        r1 = r19;
        r2 = r23;
        r3 = r6;
        r4 = r7;
        r0.set(r1, r2, r3, r4);
        r0 = r25;
        r0 = r0.mSrcRect;
        r5 = r0;
        r0 = r25;
        r0 = r0.mDstRect;
        r6 = r0;
        r7 = 0;
        r0 = r26;
        r1 = r15;
        r2 = r5;
        r3 = r6;
        r4 = r7;
        r0.drawBitmap(r1, r2, r3, r4);
        goto L_0x0052;
    L_0x014e:
        r0 = r25;
        r0 = r0.mVideoMmsErrorOverlay;
        r5 = r0;
        if (r5 != 0) goto L_0x0165;
    L_0x0155:
        r5 = r25.getResources();
        r6 = 2130837585; // 0x7f020051 float:1.7280128E38 double:1.0527736476E-314;
        r5 = r5.getDrawable(r6);
        r0 = r5;
        r1 = r25;
        r1.mVideoMmsErrorOverlay = r0;
    L_0x0165:
        r0 = r25;
        r0 = r0.mVideoMmsErrorOverlay;
        r20 = r0;
        r10 = new android.graphics.Paint;
        r10.<init>();
        r5 = 128; // 0x80 float:1.8E-43 double:6.3E-322;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r10.setARGB(r5, r6, r7, r8);
        r0 = r29;
        r0 = (float) r0;
        r6 = r0;
        r0 = r30;
        r0 = (float) r0;
        r7 = r0;
        r5 = r29 + r31;
        r8 = (float) r5;
        r5 = r30 + r32;
        r9 = (float) r5;
        r5 = r26;
        r5.drawRect(r6, r7, r8, r9, r10);
        goto L_0x008a;
    }

    public android.graphics.Bitmap getErrorBitmap(com.techno.gallery.gallery.IImage r3) {
        r2 = this;
        r0 = com.techno.gallery.ImageManager.isImage(r3);
        if (r0 == 0) goto L_0x001a;
    L_0x0006:
        r0 = r2.mMissingImageThumbnailBitmap;
        if (r0 != 0) goto L_0x0017;
    L_0x000a:
        r0 = r2.getResources();
        r1 = 2130837602; // 0x7f020062 float:1.7280163E38 double:1.052773656E-314;
        r0 = android.graphics.BitmapFactory.decodeResource(r0, r1);
        r2.mMissingImageThumbnailBitmap = r0;
    L_0x0017:
        r0 = r2.mMissingImageThumbnailBitmap;
    L_0x0019:
        return r0;
    L_0x001a:
        r0 = r2.mMissingVideoThumbnailBitmap;
        if (r0 != 0) goto L_0x002b;
    L_0x001e:
        r0 = r2.getResources();
        r1 = 2130837603; // 0x7f020063 float:1.7280165E38 double:1.0527736565E-314;
        r0 = android.graphics.BitmapFactory.decodeResource(r0, r1);
        r2.mMissingVideoThumbnailBitmap = r0;
    L_0x002b:
        r0 = r2.mMissingVideoThumbnailBitmap;
        goto L_0x0019;
    }

    public boolean needsDecoration() {
        r1 = this;
        r0 = r1.mMultiSelected;
        if (r0 == 0) goto L_0x0006;
    L_0x0004:
        r0 = 1;
    L_0x0005:
        return r0;
    L_0x0006:
        r0 = 0;
        goto L_0x0005;
    }

    protected void onActivityResult(int r2, int r3, android.content.Intent r4) {
        r1 = this;
        r0 = -1;
        switch(r2) {
            case 2: goto L_0x0012;
            case 490: goto L_0x0005;
            default: goto L_0x0004;
        };
    L_0x0004:
        return;
    L_0x0005:
        if (r3 != r0) goto L_0x0004;
    L_0x0007:
        r0 = r4.getAction();
        r0 = android.net.Uri.parse(r0);
        r1.mCropResultUri = r0;
        goto L_0x0004;
    L_0x0012:
        if (r3 != r0) goto L_0x0004;
    L_0x0014:
        r1.setResult(r3, r4);
        r1.finish();
        goto L_0x0004;
    }

    public void onConfigurationChanged(android.content.res.Configuration r2) {
        r1 = this;
        super.onConfigurationChanged(r2);
        r0 = 1;
        r1.mConfigurationChanged = r0;
        return;
    }

    public void onCreate(android.os.Bundle r6) {
        r5 = this;
        r3 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r2 = 7;
        super.onCreate(r6);
        r0 = android.preference.PreferenceManager.getDefaultSharedPreferences(r5);
        r5.mPrefs = r0;
        r5.requestWindowFeature(r2);
        r0 = 2130903051; // 0x7f03000b float:1.741291E38 double:1.052805992E-314;
        r5.setContentView(r0);
        r0 = r5.getWindow();
        r1 = 2130903044; // 0x7f030004 float:1.7412895E38 double:1.0528059887E-314;
        r0.setFeatureInt(r2, r1);
        r0 = 2131427392; // 0x7f0b0040 float:1.8476399E38 double:1.053065051E-314;
        r0 = r5.findViewById(r0);
        r5.mNoImagesView = r0;
        r0 = 2131427394; // 0x7f0b0042 float:1.8476403E38 double:1.053065052E-314;
        r0 = r5.findViewById(r0);
        r0 = (com.techno.gallery.GridViewSpecial) r0;
        r5.mGvs = r0;
        r0 = r5.mGvs;
        r0.setListener(r5);
        r0 = 2131427395; // 0x7f0b0043 float:1.8476405E38 double:1.0530650525E-314;
        r0 = r5.findViewById(r0);
        r5.mFooterOrganizeView = r0;
        r0 = r5.mFooterOrganizeView;
        r1 = com.techno.gallery.Util.getNullOnClickListener();
        r0.setOnClickListener(r1);
        r5.initializeFooterButtons();
        r0 = r5.isPickIntent();
        if (r0 == 0) goto L_0x006f;
    L_0x0056:
        r0 = r5.getIntent();
        r1 = "android.intent.extra.sizeLimit";
        r0 = r0.getLongExtra(r1, r3);
        r5.mVideoSizeLimit = r0;
    L_0x0062:
        r5.setupInclusion();
        r0 = new com.techno.gallery.ImageLoader;
        r1 = r5.mHandler;
        r0.<init>(r1);
        r5.mLoader = r0;
        return;
    L_0x006f:
        r5.mVideoSizeLimit = r3;
        r0 = r5.mGvs;
        r1 = new com.techno.gallery.ImageGallery$CreateContextMenuListener;
        r2 = 0;
        r1.<init>(r5, r2);
        r0.setOnCreateContextMenuListener(r1);
        goto L_0x0062;
    }

    public boolean onCreateOptionsMenu(android.view.Menu r6) {
        r5 = this;
        r4 = 0;
        r2 = r5.isPickIntent();
        if (r2 == 0) goto L_0x0026;
    L_0x0007:
        r2 = r5.getIntent();
        r1 = r2.resolveType(r5);
        if (r1 == 0) goto L_0x001a;
    L_0x0011:
        r2 = r5.isImageType(r1);
        if (r2 == 0) goto L_0x001c;
    L_0x0017:
        com.techno.gallery.MenuHelper.addCapturePictureMenuItems(r6, r5);
    L_0x001a:
        r2 = 1;
        return r2;
    L_0x001c:
        r2 = r5.isVideoType(r1);
        if (r2 == 0) goto L_0x001a;
    L_0x0022:
        com.techno.gallery.MenuHelper.addCaptureVideoMenuItems(r6, r5);
        goto L_0x001a;
    L_0x0026:
        com.techno.gallery.MenuHelper.addCaptureMenuItems(r6, r5);
        r2 = r5.mInclusion;
        r2 = r2 & 1;
        if (r2 == 0) goto L_0x0036;
    L_0x002f:
        r2 = 5;
        r2 = r5.addSlideShowMenu(r6, r2);
        r5.mSlideShowItem = r2;
    L_0x0036:
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3 = 2131296373; // 0x7f090075 float:1.821066E38 double:1.053000319E-314;
        r0 = r6.add(r4, r4, r2, r3);
        r2 = new com.techno.gallery.ImageGallery$7;
        r2.<init>(r5);
        r0.setOnMenuItemClickListener(r2);
        r2 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r0.setAlphabeticShortcut(r2);
        r2 = 17301577; // 0x1080049 float:2.497946E-38 double:8.548115E-317;
        r0.setIcon(r2);
        r2 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        r3 = 2131296285; // 0x7f09001d float:1.8210482E38 double:1.0530002755E-314;
        r0 = r6.add(r4, r4, r2, r3);
        r2 = new com.techno.gallery.ImageGallery$8;
        r2.<init>(r5);
        r0.setOnMenuItemClickListener(r2);
        r2 = 2130837598; // 0x7f02005e float:1.7280155E38 double:1.052773654E-314;
        r0.setIcon(r2);
        goto L_0x001a;
    }

    public void onImageClicked(int r5) {
        r4 = this;
        if (r5 < 0) goto L_0x000a;
    L_0x0002:
        r2 = r4.mAllImages;
        r2 = r2.getCount();
        if (r5 < r2) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r4.mSelectedIndex = r5;
        r2 = r4.mGvs;
        r2.setSelectedIndex(r5);
        r2 = r4.mAllImages;
        r0 = r2.getImageAt(r5);
        r2 = r4.isInMultiSelectMode();
        if (r2 == 0) goto L_0x0022;
    L_0x001e:
        r4.toggleMultiSelected(r0);
        goto L_0x000a;
    L_0x0022:
        r2 = r4.isPickIntent();
        if (r2 == 0) goto L_0x002c;
    L_0x0028:
        r4.launchCropperOrFinish(r0);
        goto L_0x000a;
    L_0x002c:
        r2 = r0 instanceof com.techno.gallery.gallery.VideoObject;
        if (r2 == 0) goto L_0x0045;
    L_0x0030:
        r1 = new android.content.Intent;
        r2 = "android.intent.action.VIEW";
        r3 = r0.fullSizeImageUri();
        r1.<init>(r2, r3);
        r2 = "android.intent.extra.screenOrientation";
        r3 = 0;
        r1.putExtra(r2, r3);
    L_0x0041:
        r4.startActivity(r1);
        goto L_0x000a;
    L_0x0045:
        r1 = new android.content.Intent;
        r2 = com.techno.gallery.ViewImage.class;
        r1.<init>(r4, r2);
        r2 = "image_list";
        r3 = r4.mAllImages;
        r1.putExtra(r2, r3);
        r2 = r0.fullSizeImageUri();
        r1.setData(r2);
        goto L_0x0041;
    }

    public void onImageTapped(int r3) {
        r2 = this;
        r0 = r2.isInMultiSelectMode();
        if (r0 == 0) goto L_0x0016;
    L_0x0006:
        r0 = r2.mGvs;
        r1 = -1;
        r0.setSelectedIndex(r1);
        r0 = r2.mAllImages;
        r0 = r0.getImageAt(r3);
        r2.toggleMultiSelected(r0);
    L_0x0015:
        return;
    L_0x0016:
        r2.onImageClicked(r3);
        goto L_0x0015;
    }

    public boolean onKeyDown(int r4, android.view.KeyEvent r5) {
        r3 = this;
        r1 = r3.canHandleEvent();
        if (r1 != 0) goto L_0x0008;
    L_0x0006:
        r1 = 0;
    L_0x0007:
        return r1;
    L_0x0008:
        switch(r4) {
            case 67: goto L_0x0010;
            default: goto L_0x000b;
        };
    L_0x000b:
        r1 = super.onKeyDown(r4, r5);
        goto L_0x0007;
    L_0x0010:
        r0 = r3.getCurrentImage();
        if (r0 == 0) goto L_0x001f;
    L_0x0016:
        r1 = r3.mDeletePhotoRunnable;
        r2 = r3.getCurrentImage();
        com.techno.gallery.MenuHelper.deleteImage(r3, r1, r2);
    L_0x001f:
        r1 = 1;
        goto L_0x0007;
    }

    public void onLayoutComplete(boolean r5) {
        r4 = this;
        r3 = 0;
        r1 = 1;
        r4.mLayoutComplete = r1;
        r1 = r4.mCropResultUri;
        if (r1 == 0) goto L_0x001d;
    L_0x0008:
        r1 = r4.mAllImages;
        r2 = r4.mCropResultUri;
        r0 = r1.getImageForUri(r2);
        r1 = 0;
        r4.mCropResultUri = r1;
        if (r0 == 0) goto L_0x001d;
    L_0x0015:
        r1 = r4.mAllImages;
        r1 = r1.getImageIndex(r0);
        r4.mSelectedIndex = r1;
    L_0x001d:
        r1 = r4.mGvs;
        r2 = r4.mSelectedIndex;
        r1.setSelectedIndex(r2);
        r1 = r4.mScrollPosition;
        r2 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r1 != 0) goto L_0x0042;
    L_0x002c:
        r1 = r4.mSortAscending;
        if (r1 == 0) goto L_0x003c;
    L_0x0030:
        r1 = r4.mGvs;
        r2 = r4.mGvs;
        r2 = r2.getHeight();
        r1.scrollTo(r3, r2);
    L_0x003b:
        return;
    L_0x003c:
        r1 = r4.mGvs;
        r1.scrollToImage(r3);
        goto L_0x003b;
    L_0x0042:
        r1 = r4.mConfigurationChanged;
        if (r1 == 0) goto L_0x0060;
    L_0x0046:
        r4.mConfigurationChanged = r3;
        r1 = r4.mGvs;
        r2 = r4.mScrollPosition;
        r1.scrollTo(r2);
        r1 = r4.mGvs;
        r1 = r1.getCurrentSelection();
        r2 = -1;
        if (r1 == r2) goto L_0x003b;
    L_0x0058:
        r1 = r4.mGvs;
        r2 = r4.mSelectedIndex;
        r1.scrollToVisible(r2);
        goto L_0x003b;
    L_0x0060:
        r1 = r4.mGvs;
        r2 = r4.mScrollPosition;
        r1.scrollTo(r2);
        goto L_0x003b;
    }

    public void onPause() {
        r2 = this;
        r1 = 0;
        super.onPause();
        r0 = 1;
        r2.mPausing = r0;
        r0 = r2.mLoader;
        r0.stop();
        r0 = r2.mGvs;
        r0.stop();
        r0 = r2.mReceiver;
        if (r0 == 0) goto L_0x001c;
    L_0x0015:
        r0 = r2.mReceiver;
        r2.unregisterReceiver(r0);
        r2.mReceiver = r1;
    L_0x001c:
        r0 = r2.mAllImages;
        r0.deactivate();
        r2.mAllImages = r1;
        return;
    }

    public boolean onPrepareOptionsMenu(android.view.Menu r5) {
        r4 = this;
        r3 = 1;
        r2 = 0;
        r1 = r4.canHandleEvent();
        if (r1 != 0) goto L_0x000a;
    L_0x0008:
        r1 = r2;
    L_0x0009:
        return r1;
    L_0x000a:
        r1 = r4.mInclusion;
        r1 = r1 & 1;
        if (r1 == 0) goto L_0x0020;
    L_0x0010:
        r0 = r4.isVideoSelected();
        r1 = r4.mSlideShowItem;
        if (r1 == 0) goto L_0x0020;
    L_0x0018:
        r1 = r4.mSlideShowItem;
        if (r0 != 0) goto L_0x001d;
    L_0x001c:
        r2 = r3;
    L_0x001d:
        r1.setEnabled(r2);
    L_0x0020:
        r1 = r3;
        goto L_0x0009;
    }

    protected void onRestoreInstanceState(android.os.Bundle r3) {
        r2 = this;
        super.onRestoreInstanceState(r3);
        r0 = "scroll_position";
        r1 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r0 = r3.getFloat(r0, r1);
        r2.mScrollPosition = r0;
        r0 = "first_index";
        r1 = 0;
        r0 = r3.getInt(r0, r1);
        r2.mSelectedIndex = r0;
        return;
    }

    public void onResume() {
        r7 = this;
        r6 = 0;
        super.onResume();
        r2 = r7.mGvs;
        r3 = r7.mPrefs;
        r4 = "pref_gallery_size_key";
        r5 = "1";
        r3 = r3.getString(r4, r5);
        r3 = java.lang.Integer.parseInt(r3);
        r2.setSizeChoice(r3);
        r2 = r7.mGvs;
        r2.requestFocus();
        r2 = r7.mPrefs;
        r3 = "pref_gallery_sort_key";
        r4 = 0;
        r1 = r2.getString(r3, r4);
        if (r1 == 0) goto L_0x002f;
    L_0x0027:
        r2 = "ascending";
        r2 = r1.equals(r2);
        r7.mSortAscending = r2;
    L_0x002f:
        r7.mPausing = r6;
        r0 = new android.content.IntentFilter;
        r2 = "android.intent.action.MEDIA_MOUNTED";
        r0.<init>(r2);
        r2 = "android.intent.action.MEDIA_UNMOUNTED";
        r0.addAction(r2);
        r2 = "android.intent.action.MEDIA_SCANNER_STARTED";
        r0.addAction(r2);
        r2 = "android.intent.action.MEDIA_SCANNER_FINISHED";
        r0.addAction(r2);
        r2 = "android.intent.action.MEDIA_EJECT";
        r0.addAction(r2);
        r2 = "file";
        r0.addDataScheme(r2);
        r2 = new com.techno.gallery.ImageGallery$6;
        r2.<init>(r7);
        r7.mReceiver = r2;
        r2 = r7.mReceiver;
        r7.registerReceiver(r2, r0);
        r2 = r7.getContentResolver();
        r2 = com.techno.gallery.ImageManager.isMediaScannerScanning(r2);
        r7.rebake(r6, r2);
        return;
    }

    protected void onSaveInstanceState(android.os.Bundle r3) {
        r2 = this;
        super.onSaveInstanceState(r3);
        r0 = "scroll_position";
        r1 = r2.mScrollPosition;
        r3.putFloat(r0, r1);
        r0 = "first_index";
        r1 = r2.mSelectedIndex;
        r3.putInt(r0, r1);
        return;
    }

    public void onScroll(float r1) {
        r0 = this;
        r0.mScrollPosition = r1;
        return;
    }

    public boolean onSlideShowClicked() {
        r9 = this;
        r6 = 0;
        r7 = 1;
        r8 = "bucketId";
        r5 = r9.canHandleEvent();
        if (r5 != 0) goto L_0x000c;
    L_0x000a:
        r5 = r6;
    L_0x000b:
        return r5;
    L_0x000c:
        r1 = r9.getCurrentImage();
        if (r1 != 0) goto L_0x001c;
    L_0x0012:
        r5 = r9.mAllImages;
        r1 = r5.getImageAt(r6);
        if (r1 != 0) goto L_0x001c;
    L_0x001a:
        r5 = r7;
        goto L_0x000b;
    L_0x001c:
        r3 = r1.fullSizeImageUri();
        r5 = r9.getIntent();
        r4 = r5.getData();
        if (r4 == 0) goto L_0x0040;
    L_0x002a:
        r5 = "bucketId";
        r0 = r4.getQueryParameter(r8);
        if (r0 == 0) goto L_0x0040;
    L_0x0032:
        r5 = r3.buildUpon();
        r6 = "bucketId";
        r5 = r5.appendQueryParameter(r8, r0);
        r3 = r5.build();
    L_0x0040:
        r2 = new android.content.Intent;
        r5 = "android.intent.action.VIEW";
        r2.<init>(r5, r3);
        r5 = "slideshow";
        r2.putExtra(r5, r7);
        r9.startActivity(r2);
        r5 = r7;
        goto L_0x000b;
    }
}