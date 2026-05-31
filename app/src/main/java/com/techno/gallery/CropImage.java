package com.techno.gallery;

public class CropImage extends com.techno.gallery.MonitoredActivity {
    private static final java.lang.String TAG = "CropImage";
    private com.techno.gallery.gallery.IImageList mAllImages;
    private int mAspectX;
    private int mAspectY;
    private android.graphics.Bitmap mBitmap;
    private boolean mCircleCrop;
    private android.content.ContentResolver mContentResolver;
    com.techno.gallery.HighlightView mCrop;
    private final com.techno.gallery.BitmapManager.ThreadSet mDecodingThreads;
    private boolean mDoFaceDetection;
    private final android.os.Handler mHandler;
    private com.techno.gallery.gallery.IImage mImage;
    private com.techno.gallery.CropImageView mImageView;
    private android.graphics.Bitmap.CompressFormat mOutputFormat;
    private int mOutputX;
    private int mOutputY;
    java.lang.Runnable mRunFaceDetection;
    private android.net.Uri mSaveUri;
    boolean mSaving;
    private boolean mScale;
    private boolean mScaleUp;
    boolean mWaitingToPick;

    public CropImage() {
        r2 = this;
        r1 = 1;
        r2.<init>();
        r0 = android.graphics.Bitmap.CompressFormat.JPEG;
        r2.mOutputFormat = r0;
        r0 = 0;
        r2.mSaveUri = r0;
        r2.mDoFaceDetection = r1;
        r0 = 0;
        r2.mCircleCrop = r0;
        r0 = new android.os.Handler;
        r0.<init>();
        r2.mHandler = r0;
        r2.mScaleUp = r1;
        r0 = new com.techno.gallery.BitmapManager$ThreadSet;
        r0.<init>();
        r2.mDecodingThreads = r0;
        r0 = new com.techno.gallery.CropImage$5;
        r0.<init>(r2);
        r2.mRunFaceDetection = r0;
        return;
    }

    static /* synthetic */ void access$000(com.techno.gallery.CropImage r0) {
        r0.onSaveClicked();
        return;
    }

    static /* synthetic */ com.techno.gallery.gallery.IImage access$100(com.techno.gallery.CropImage r1) {
        r0 = r1.mImage;
        return r0;
    }

    static /* synthetic */ android.graphics.Bitmap access$200(com.techno.gallery.CropImage r1) {
        r0 = r1.mBitmap;
        return r0;
    }

    static /* synthetic */ android.graphics.Bitmap access$202(com.techno.gallery.CropImage r0, android.graphics.Bitmap r1) {
        r0.mBitmap = r1;
        return r1;
    }

    static /* synthetic */ com.techno.gallery.CropImageView access$300(com.techno.gallery.CropImage r1) {
        r0 = r1.mImageView;
        return r0;
    }

    static /* synthetic */ android.os.Handler access$400(com.techno.gallery.CropImage r1) {
        r0 = r1.mHandler;
        return r0;
    }

    static /* synthetic */ void access$500(com.techno.gallery.CropImage r0, android.graphics.Bitmap r1) {
        r0.saveOutput(r1);
        return;
    }

    static /* synthetic */ boolean access$600(com.techno.gallery.CropImage r1) {
        r0 = r1.mCircleCrop;
        return r0;
    }

    static /* synthetic */ int access$700(com.techno.gallery.CropImage r1) {
        r0 = r1.mAspectX;
        return r0;
    }

    static /* synthetic */ int access$800(com.techno.gallery.CropImage r1) {
        r0 = r1.mAspectY;
        return r0;
    }

    static /* synthetic */ boolean access$900(com.techno.gallery.CropImage r1) {
        r0 = r1.mDoFaceDetection;
        return r0;
    }

    private void onSaveClicked() {
        r24 = this;
        r0 = r24;
        r0 = r0.mSaving;
        r20 = r0;
        if (r20 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = r24;
        r0 = r0.mCrop;
        r20 = r0;
        if (r20 == 0) goto L_0x0008;
    L_0x0011:
        r20 = 1;
        r0 = r20;
        r1 = r24;
        r1.mSaving = r0;
        r0 = r24;
        r0 = r0.mCrop;
        r20 = r0;
        r17 = r20.getCropRect();
        r19 = r17.width();
        r13 = r17.height();
        r0 = r24;
        r0 = r0.mCircleCrop;
        r20 = r0;
        if (r20 == 0) goto L_0x014a;
    L_0x0033:
        r20 = android.graphics.Bitmap.Config.ARGB_8888;
    L_0x0035:
        r0 = r19;
        r1 = r13;
        r2 = r20;
        r8 = android.graphics.Bitmap.createBitmap(r0, r1, r2);
        r7 = new android.graphics.Canvas;
        r7.<init>(r8);
        r9 = new android.graphics.Rect;
        r20 = 0;
        r21 = 0;
        r0 = r9;
        r1 = r20;
        r2 = r21;
        r3 = r19;
        r4 = r13;
        r0.<init>(r1, r2, r3, r4);
        r0 = r24;
        r0 = r0.mBitmap;
        r20 = r0;
        r21 = 0;
        r0 = r7;
        r1 = r20;
        r2 = r17;
        r3 = r9;
        r4 = r21;
        r0.drawBitmap(r1, r2, r3, r4);
        r0 = r24;
        r0 = r0.mCircleCrop;
        r20 = r0;
        if (r20 == 0) goto L_0x00b8;
    L_0x006f:
        r6 = new android.graphics.Canvas;
        r6.<init>(r8);
        r16 = new android.graphics.Path;
        r16.<init>();
        r0 = r19;
        r0 = (float) r0;
        r20 = r0;
        r21 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r20 = r20 / r21;
        r0 = r13;
        r0 = (float) r0;
        r21 = r0;
        r22 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r21 = r21 / r22;
        r0 = r19;
        r0 = (float) r0;
        r22 = r0;
        r23 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r22 = r22 / r23;
        r23 = android.graphics.Path.Direction.CW;
        r0 = r16;
        r1 = r20;
        r2 = r21;
        r3 = r22;
        r4 = r23;
        r0.addCircle(r1, r2, r3, r4);
        r20 = android.graphics.Region.Op.DIFFERENCE;
        r0 = r6;
        r1 = r16;
        r2 = r20;
        r0.clipPath(r1, r2);
        r20 = 0;
        r21 = android.graphics.PorterDuff.Mode.CLEAR;
        r0 = r6;
        r1 = r20;
        r2 = r21;
        r0.drawColor(r1, r2);
    L_0x00b8:
        r0 = r24;
        r0 = r0.mOutputX;
        r20 = r0;
        if (r20 == 0) goto L_0x00fa;
    L_0x00c0:
        r0 = r24;
        r0 = r0.mOutputY;
        r20 = r0;
        if (r20 == 0) goto L_0x00fa;
    L_0x00c8:
        r0 = r24;
        r0 = r0.mScale;
        r20 = r0;
        if (r20 == 0) goto L_0x014e;
    L_0x00d0:
        r15 = r8;
        r20 = new android.graphics.Matrix;
        r20.<init>();
        r0 = r24;
        r0 = r0.mOutputX;
        r21 = r0;
        r0 = r24;
        r0 = r0.mOutputY;
        r22 = r0;
        r0 = r24;
        r0 = r0.mScaleUp;
        r23 = r0;
        r0 = r20;
        r1 = r8;
        r2 = r21;
        r3 = r22;
        r4 = r23;
        r8 = com.techno.gallery.Util.transform(r0, r1, r2, r3, r4);
        if (r15 == r8) goto L_0x00fa;
    L_0x00f7:
        r15.recycle();
    L_0x00fa:
        r20 = r24.getIntent();
        r14 = r20.getExtras();
        if (r14 == 0) goto L_0x01f5;
    L_0x0104:
        r20 = "data";
        r0 = r14;
        r1 = r20;
        r20 = r0.getParcelable(r1);
        if (r20 != 0) goto L_0x011a;
    L_0x010f:
        r20 = "return-data";
        r0 = r14;
        r1 = r20;
        r20 = r0.getBoolean(r1);
        if (r20 == 0) goto L_0x01f5;
    L_0x011a:
        r12 = new android.os.Bundle;
        r12.<init>();
        r20 = "data";
        r0 = r12;
        r1 = r20;
        r2 = r8;
        r0.putParcelable(r1, r2);
        r20 = -1;
        r21 = new android.content.Intent;
        r21.<init>();
        r22 = "inline-data";
        r21 = r21.setAction(r22);
        r0 = r21;
        r1 = r12;
        r21 = r0.putExtras(r1);
        r0 = r24;
        r1 = r20;
        r2 = r21;
        r0.setResult(r1, r2);
        r24.finish();
        goto L_0x0008;
    L_0x014a:
        r20 = android.graphics.Bitmap.Config.RGB_565;
        goto L_0x0035;
    L_0x014e:
        r0 = r24;
        r0 = r0.mOutputX;
        r20 = r0;
        r0 = r24;
        r0 = r0.mOutputY;
        r21 = r0;
        r22 = android.graphics.Bitmap.Config.RGB_565;
        r5 = android.graphics.Bitmap.createBitmap(r20, r21, r22);
        r7 = new android.graphics.Canvas;
        r7.<init>(r5);
        r0 = r24;
        r0 = r0.mCrop;
        r20 = r0;
        r18 = r20.getCropRect();
        r9 = new android.graphics.Rect;
        r20 = 0;
        r21 = 0;
        r0 = r24;
        r0 = r0.mOutputX;
        r22 = r0;
        r0 = r24;
        r0 = r0.mOutputY;
        r23 = r0;
        r0 = r9;
        r1 = r20;
        r2 = r21;
        r3 = r22;
        r4 = r23;
        r0.<init>(r1, r2, r3, r4);
        r20 = r18.width();
        r21 = r9.width();
        r20 = r20 - r21;
        r10 = r20 / 2;
        r20 = r18.height();
        r21 = r9.height();
        r20 = r20 - r21;
        r11 = r20 / 2;
        r20 = 0;
        r0 = r20;
        r1 = r10;
        r20 = java.lang.Math.max(r0, r1);
        r21 = 0;
        r0 = r21;
        r1 = r11;
        r21 = java.lang.Math.max(r0, r1);
        r0 = r18;
        r1 = r20;
        r2 = r21;
        r0.inset(r1, r2);
        r20 = 0;
        r0 = r10;
        r0 = -r0;
        r21 = r0;
        r20 = java.lang.Math.max(r20, r21);
        r21 = 0;
        r0 = r11;
        r0 = -r0;
        r22 = r0;
        r21 = java.lang.Math.max(r21, r22);
        r0 = r9;
        r1 = r20;
        r2 = r21;
        r0.inset(r1, r2);
        r0 = r24;
        r0 = r0.mBitmap;
        r20 = r0;
        r21 = 0;
        r0 = r7;
        r1 = r20;
        r2 = r18;
        r3 = r9;
        r4 = r21;
        r0.drawBitmap(r1, r2, r3, r4);
        r8.recycle();
        r8 = r5;
        goto L_0x00fa;
    L_0x01f5:
        r5 = r8;
        r20 = 0;
        r21 = r24.getResources();
        r22 = 2131296275; // 0x7f090013 float:1.8210462E38 double:1.0530002706E-314;
        r21 = r21.getString(r22);
        r22 = new com.techno.gallery.CropImage$4;
        r0 = r22;
        r1 = r24;
        r2 = r5;
        r0.<init>(r1, r2);
        r0 = r24;
        r0 = r0.mHandler;
        r23 = r0;
        r0 = r24;
        r1 = r20;
        r2 = r21;
        r3 = r22;
        r4 = r23;
        com.techno.gallery.Util.startBackgroundJob(r0, r1, r2, r3, r4);
        goto L_0x0008;
    }

    private void saveOutput(android.graphics.Bitmap r25) {
        r24 = this;
        r0 = r24;
        r0 = r0.mSaveUri;
        r5 = r0;
        if (r5 == 0) goto L_0x0082;
    L_0x0007:
        r22 = 0;
        r0 = r24;
        r0 = r0.mContentResolver;	 Catch:{ IOException -> 0x0055 }
        r5 = r0;
        r0 = r24;
        r0 = r0.mSaveUri;	 Catch:{ IOException -> 0x0055 }
        r6 = r0;
        r22 = r5.openOutputStream(r6);	 Catch:{ IOException -> 0x0055 }
        if (r22 == 0) goto L_0x0029;
    L_0x0019:
        r0 = r24;
        r0 = r0.mOutputFormat;	 Catch:{ IOException -> 0x0055 }
        r5 = r0;
        r6 = 75;
        r0 = r25;
        r1 = r5;
        r2 = r6;
        r3 = r22;
        r0.compress(r1, r2, r3);	 Catch:{ IOException -> 0x0055 }
    L_0x0029:
        com.techno.gallery.Util.closeSilently(r22);
    L_0x002c:
        r18 = new android.os.Bundle;
        r18.<init>();
        r5 = -1;
        r6 = new android.content.Intent;
        r0 = r24;
        r0 = r0.mSaveUri;
        r7 = r0;
        r7 = r7.toString();
        r6.<init>(r7);
        r0 = r6;
        r1 = r18;
        r6 = r0.putExtras(r1);
        r0 = r24;
        r1 = r5;
        r2 = r6;
        r0.setResult(r1, r2);
    L_0x004e:
        r25.recycle();
        r24.finish();
        return;
    L_0x0055:
        r5 = move-exception;
        r16 = r5;
        r5 = "CropImage";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x007d }
        r6.<init>();	 Catch:{ all -> 0x007d }
        r7 = "Cannot open file: ";
        r6 = r6.append(r7);	 Catch:{ all -> 0x007d }
        r0 = r24;
        r0 = r0.mSaveUri;	 Catch:{ all -> 0x007d }
        r7 = r0;
        r6 = r6.append(r7);	 Catch:{ all -> 0x007d }
        r6 = r6.toString();	 Catch:{ all -> 0x007d }
        r0 = r5;
        r1 = r6;
        r2 = r16;
        android.util.Log.e(r0, r1, r2);	 Catch:{ all -> 0x007d }
        com.techno.gallery.Util.closeSilently(r22);
        goto L_0x002c;
    L_0x007d:
        r5 = move-exception;
        com.techno.gallery.Util.closeSilently(r22);
        throw r5;
    L_0x0082:
        r18 = new android.os.Bundle;
        r18.<init>();
        r5 = "rect";
        r0 = r24;
        r0 = r0.mCrop;
        r6 = r0;
        r6 = r6.getCropRect();
        r6 = r6.toString();
        r0 = r18;
        r1 = r5;
        r2 = r6;
        r0.putString(r1, r2);
        r21 = new java.io.File;
        r0 = r24;
        r0 = r0.mImage;
        r5 = r0;
        r5 = r5.getDataPath();
        r0 = r21;
        r1 = r5;
        r0.<init>(r1);
        r15 = new java.io.File;
        r5 = r21.getParent();
        r15.<init>(r5);
        r23 = 0;
        r19 = r21.getName();
        r5 = 0;
        r6 = ".";
        r0 = r19;
        r1 = r6;
        r6 = r0.lastIndexOf(r1);
        r0 = r19;
        r1 = r5;
        r2 = r6;
        r19 = r0.substring(r1, r2);
    L_0x00cf:
        r23 = r23 + 1;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r15.toString();
        r5 = r5.append(r6);
        r6 = "/";
        r5 = r5.append(r6);
        r0 = r5;
        r1 = r19;
        r5 = r0.append(r1);
        r6 = "-";
        r5 = r5.append(r6);
        r0 = r5;
        r1 = r23;
        r5 = r0.append(r1);
        r6 = ".jpg";
        r5 = r5.append(r6);
        r14 = r5.toString();
        r5 = new java.io.File;
        r5.<init>(r14);
        r17 = r5.exists();
        if (r17 != 0) goto L_0x00cf;
    L_0x010d:
        r0 = r24;
        r0 = r0.mContentResolver;	 Catch:{ Exception -> 0x0184 }
        r5 = r0;
        r0 = r24;
        r0 = r0.mImage;	 Catch:{ Exception -> 0x0184 }
        r6 = r0;
        r6 = r6.getTitle();	 Catch:{ Exception -> 0x0184 }
        r0 = r24;
        r0 = r0.mImage;	 Catch:{ Exception -> 0x0184 }
        r7 = r0;
        r7 = r7.getDateTaken();	 Catch:{ Exception -> 0x0184 }
        r9 = 0;
        r10 = 0;
        r11 = r15.toString();	 Catch:{ Exception -> 0x0184 }
        r12 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0184 }
        r12.<init>();	 Catch:{ Exception -> 0x0184 }
        r0 = r12;
        r1 = r19;
        r12 = r0.append(r1);	 Catch:{ Exception -> 0x0184 }
        r13 = "-";
        r12 = r12.append(r13);	 Catch:{ Exception -> 0x0184 }
        r0 = r12;
        r1 = r23;
        r12 = r0.append(r1);	 Catch:{ Exception -> 0x0184 }
        r13 = ".jpg";
        r12 = r12.append(r13);	 Catch:{ Exception -> 0x0184 }
        r12 = r12.toString();	 Catch:{ Exception -> 0x0184 }
        r20 = com.techno.gallery.ImageManager.addImage(r5, r6, r7, r9, r10, r11, r12);	 Catch:{ Exception -> 0x0184 }
        r0 = r24;
        r0 = r0.mContentResolver;	 Catch:{ Exception -> 0x0184 }
        r5 = r0;
        r6 = 0;
        r7 = 0;
        r0 = r20;
        r1 = r5;
        r2 = r6;
        r3 = r25;
        r4 = r7;
        r13 = com.techno.gallery.ImageManager.storeImage(r0, r1, r2, r3, r4);	 Catch:{ Exception -> 0x0184 }
        r13.get();	 Catch:{ Exception -> 0x0184 }
        r5 = -1;
        r6 = new android.content.Intent;	 Catch:{ Exception -> 0x0184 }
        r6.<init>();	 Catch:{ Exception -> 0x0184 }
        r7 = r20.toString();	 Catch:{ Exception -> 0x0184 }
        r6 = r6.setAction(r7);	 Catch:{ Exception -> 0x0184 }
        r0 = r6;
        r1 = r18;
        r6 = r0.putExtras(r1);	 Catch:{ Exception -> 0x0184 }
        r0 = r24;
        r1 = r5;
        r2 = r6;
        r0.setResult(r1, r2);	 Catch:{ Exception -> 0x0184 }
        goto L_0x004e;
    L_0x0184:
        r5 = move-exception;
        r16 = r5;
        r5 = "CropImage";
        r6 = "store image fail, continue anyway";
        r0 = r5;
        r1 = r6;
        r2 = r16;
        android.util.Log.e(r0, r1, r2);
        goto L_0x004e;
    }

    private void startFaceDetection() {
        r4 = this;
        r0 = r4.isFinishing();
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r4.mImageView;
        r1 = r4.mBitmap;
        r2 = 1;
        r0.setImageBitmapResetBase(r1, r2);
        r0 = 0;
        r1 = r4.getResources();
        r2 = 2131296276; // 0x7f090014 float:1.8210464E38 double:1.053000271E-314;
        r1 = r1.getString(r2);
        r2 = new com.techno.gallery.CropImage$3;
        r2.<init>(r4);
        r3 = r4.mHandler;
        com.techno.gallery.Util.startBackgroundJob(r4, r0, r1, r2, r3);
        goto L_0x0006;
    }

    public void onCreate(android.os.Bundle r8) {
        r7 = this;
        r5 = 1;
        r6 = "noFaceDetection";
        super.onCreate(r8);
        r4 = r7.getContentResolver();
        r7.mContentResolver = r4;
        r7.requestWindowFeature(r5);
        r4 = 2130903043; // 0x7f030003 float:1.7412893E38 double:1.052805988E-314;
        r7.setContentView(r4);
        r4 = 2131427341; // 0x7f0b000d float:1.8476296E38 double:1.053065026E-314;
        r4 = r7.findViewById(r4);
        r4 = (com.techno.gallery.CropImageView) r4;
        r7.mImageView = r4;
        com.techno.gallery.MenuHelper.showStorageToast(r7);
        r1 = r7.getIntent();
        r0 = r1.getExtras();
        if (r0 == 0) goto L_0x00a4;
    L_0x002d:
        r4 = "circleCrop";
        r4 = r0.getString(r4);
        if (r4 == 0) goto L_0x003b;
    L_0x0035:
        r7.mCircleCrop = r5;
        r7.mAspectX = r5;
        r7.mAspectY = r5;
    L_0x003b:
        r4 = "output";
        r4 = r0.getParcelable(r4);
        r4 = (android.net.Uri) r4;
        r7.mSaveUri = r4;
        r4 = r7.mSaveUri;
        if (r4 == 0) goto L_0x0057;
    L_0x0049:
        r4 = "outputFormat";
        r2 = r0.getString(r4);
        if (r2 == 0) goto L_0x0057;
    L_0x0051:
        r4 = android.graphics.Bitmap.CompressFormat.valueOf(r2);
        r7.mOutputFormat = r4;
    L_0x0057:
        r4 = "data";
        r4 = r0.getParcelable(r4);
        r4 = (android.graphics.Bitmap) r4;
        r7.mBitmap = r4;
        r4 = "aspectX";
        r4 = r0.getInt(r4);
        r7.mAspectX = r4;
        r4 = "aspectY";
        r4 = r0.getInt(r4);
        r7.mAspectY = r4;
        r4 = "outputX";
        r4 = r0.getInt(r4);
        r7.mOutputX = r4;
        r4 = "outputY";
        r4 = r0.getInt(r4);
        r7.mOutputY = r4;
        r4 = "scale";
        r4 = r0.getBoolean(r4, r5);
        r7.mScale = r4;
        r4 = "scaleUpIfNeeded";
        r4 = r0.getBoolean(r4, r5);
        r7.mScaleUp = r4;
        r4 = "noFaceDetection";
        r4 = r0.containsKey(r6);
        if (r4 == 0) goto L_0x00d2;
    L_0x0099:
        r4 = "noFaceDetection";
        r4 = r0.getBoolean(r6);
        if (r4 != 0) goto L_0x00d0;
    L_0x00a1:
        r4 = r5;
    L_0x00a2:
        r7.mDoFaceDetection = r4;
    L_0x00a4:
        r4 = r7.mBitmap;
        if (r4 != 0) goto L_0x00c8;
    L_0x00a8:
        r3 = r1.getData();
        r4 = r7.mContentResolver;
        r4 = com.techno.gallery.ImageManager.makeImageList(r3, r4, r5);
        r7.mAllImages = r4;
        r4 = r7.mAllImages;
        r4 = r4.getImageForUri(r3);
        r7.mImage = r4;
        r4 = r7.mImage;
        if (r4 == 0) goto L_0x00c8;
    L_0x00c0:
        r4 = r7.mImage;
        r4 = r4.thumbBitmap(r5);
        r7.mBitmap = r4;
    L_0x00c8:
        r4 = r7.mBitmap;
        if (r4 != 0) goto L_0x00d4;
    L_0x00cc:
        r7.finish();
    L_0x00cf:
        return;
    L_0x00d0:
        r4 = 0;
        goto L_0x00a2;
    L_0x00d2:
        r4 = r5;
        goto L_0x00a2;
    L_0x00d4:
        r4 = r7.getWindow();
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4.addFlags(r5);
        r4 = 2131427343; // 0x7f0b000f float:1.84763E38 double:1.053065027E-314;
        r4 = r7.findViewById(r4);
        r5 = new com.techno.gallery.CropImage$1;
        r5.<init>(r7);
        r4.setOnClickListener(r5);
        r4 = 2131427342; // 0x7f0b000e float:1.8476298E38 double:1.0530650263E-314;
        r4 = r7.findViewById(r4);
        r5 = new com.techno.gallery.CropImage$2;
        r5.<init>(r7);
        r4.setOnClickListener(r5);
        r7.startFaceDetection();
        goto L_0x00cf;
    }

    protected void onDestroy() {
        r1 = this;
        r0 = r1.mAllImages;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r1.mAllImages;
        r0.deactivate();
    L_0x0009:
        super.onDestroy();
        return;
    }

    protected void onPause() {
        r2 = this;
        super.onPause();
        r0 = com.techno.gallery.BitmapManager.instance();
        r1 = r2.mDecodingThreads;
        r0.cancelThreadDecoding(r1);
        return;
    }
}