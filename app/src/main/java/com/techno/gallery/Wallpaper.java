package com.techno.gallery;

public class Wallpaper extends android.app.Activity {
    static final int CROP_DONE = 2;
    static final java.lang.String DO_LAUNCH_ICICLE = "do_launch";
    static final int FINISH = 1;
    private static final java.lang.String LOG_TAG = "Camera";
    static final int PHOTO_PICKED = 1;
    static final int SHOW_PROGRESS = 0;
    static final java.lang.String TEMP_FILE_PATH_ICICLE = "temp_file_path";
    private boolean mDoLaunch;
    private final android.os.Handler mHandler;
    private android.app.ProgressDialog mProgressDialog;
    private java.io.File mTempFile;

    public Wallpaper() {
        r1 = this;
        r1.<init>();
        r0 = 0;
        r1.mProgressDialog = r0;
        r0 = 1;
        r1.mDoLaunch = r0;
        r0 = new com.techno.gallery.Wallpaper$1;
        r0.<init>(r1);
        r1.mHandler = r0;
        return;
    }

    static /* synthetic */ android.app.ProgressDialog access$002(com.techno.gallery.Wallpaper r0, android.app.ProgressDialog r1) {
        r0.mProgressDialog = r1;
        return r1;
    }

    static /* synthetic */ void access$100(com.techno.gallery.Wallpaper r0) {
        r0.closeProgressDialog();
        return;
    }

    private synchronized void closeProgressDialog() {
        r1 = this;
        monitor-enter(r1);
        r0 = r1.mProgressDialog;	 Catch:{ all -> 0x000f }
        if (r0 == 0) goto L_0x000d;
    L_0x0005:
        r0 = r1.mProgressDialog;	 Catch:{ all -> 0x000f }
        r0.dismiss();	 Catch:{ all -> 0x000f }
        r0 = 0;
        r1.mProgressDialog = r0;	 Catch:{ all -> 0x000f }
    L_0x000d:
        monitor-exit(r1);
        return;
    L_0x000f:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    }

    protected void formatIntent(android.content.Intent r5) {
        r4 = this;
        r3 = 1;
        r2 = "temp-wallpaper";
        r2 = r4.getFileStreamPath(r2);
        r4.mTempFile = r2;
        r2 = r4.mTempFile;
        r2 = r2.getParentFile();
        r2.mkdirs();
        r1 = r4.getWallpaperDesiredMinimumWidth();
        r0 = r4.getWallpaperDesiredMinimumHeight();
        r2 = "outputX";
        r5.putExtra(r2, r1);
        r2 = "outputY";
        r5.putExtra(r2, r0);
        r2 = "aspectX";
        r5.putExtra(r2, r1);
        r2 = "aspectY";
        r5.putExtra(r2, r0);
        r2 = "scale";
        r5.putExtra(r2, r3);
        r2 = "noFaceDetection";
        r5.putExtra(r2, r3);
        r2 = "output";
        r3 = r4.mTempFile;
        r3 = android.net.Uri.fromFile(r3);
        r5.putExtra(r2, r3);
        r2 = "outputFormat";
        r3 = android.graphics.Bitmap.CompressFormat.PNG;
        r3 = r3.name();
        r5.putExtra(r2, r3);
        return;
    }

    protected void onActivityResult(int r8, int r9, android.content.Intent r10) {
        r7 = this;
        r4 = 0;
        r6 = "Camera";
        r3 = 1;
        if (r8 == r3) goto L_0x0009;
    L_0x0006:
        r3 = 2;
        if (r8 != r3) goto L_0x0071;
    L_0x0009:
        r3 = -1;
        if (r9 != r3) goto L_0x0071;
    L_0x000c:
        if (r10 == 0) goto L_0x0071;
    L_0x000e:
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0054 }
        r3 = r7.mTempFile;	 Catch:{ FileNotFoundException -> 0x0054 }
        r2.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0054 }
        r0 = android.graphics.BitmapFactory.decodeStream(r2);	 Catch:{ all -> 0x004f }
        if (r0 != 0) goto L_0x003c;
    L_0x001b:
        r3 = "Camera";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004f }
        r4.<init>();	 Catch:{ all -> 0x004f }
        r5 = "Failed to set wallpaper. Couldn't get bitmap for path ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x004f }
        r5 = r7.mTempFile;	 Catch:{ all -> 0x004f }
        r4 = r4.append(r5);	 Catch:{ all -> 0x004f }
        r4 = r4.toString();	 Catch:{ all -> 0x004f }
        android.util.Log.e(r3, r4);	 Catch:{ all -> 0x004f }
    L_0x0035:
        r3 = 0;
        r7.mDoLaunch = r3;	 Catch:{ all -> 0x004f }
        com.techno.gallery.Util.closeSilently(r2);
    L_0x003b:
        return;
    L_0x003c:
        r3 = r7.mHandler;
        r4 = 0;
        r3.sendEmptyMessage(r4);
        r3 = new com.techno.gallery.Wallpaper$SetWallpaperThread;
        r4 = r7.mHandler;
        r5 = r7.mTempFile;
        r3.<init>(r0, r4, r7, r5);
        r3.start();
        goto L_0x0035;
    L_0x004f:
        r3 = move-exception;
        com.techno.gallery.Util.closeSilently(r2);
        throw r3;
    L_0x0054:
        r3 = move-exception;
        r1 = r3;
        r3 = "Camera";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "file not found: ";
        r3 = r3.append(r4);
        r4 = r7.mTempFile;
        r3 = r3.append(r4);
        r3 = r3.toString();
        android.util.Log.e(r6, r3, r1);
        goto L_0x003b;
    L_0x0071:
        r7.setResult(r4);
        r7.finish();
        goto L_0x003b;
    }

    protected void onCreate(android.os.Bundle r3) {
        r2 = this;
        super.onCreate(r3);
        if (r3 == 0) goto L_0x001a;
    L_0x0005:
        r0 = "do_launch";
        r0 = r3.getBoolean(r0);
        r2.mDoLaunch = r0;
        r0 = new java.io.File;
        r1 = "temp_file_path";
        r1 = r3.getString(r1);
        r0.<init>(r1);
        r2.mTempFile = r0;
    L_0x001a:
        return;
    }

    protected void onPause() {
        r0 = this;
        r0.closeProgressDialog();
        super.onPause();
        return;
    }

    protected void onResume() {
        r4 = this;
        super.onResume();
        r2 = r4.mDoLaunch;
        if (r2 != 0) goto L_0x0008;
    L_0x0007:
        return;
    L_0x0008:
        r2 = r4.getIntent();
        r0 = r2.getData();
        if (r0 == 0) goto L_0x0029;
    L_0x0012:
        r1 = new android.content.Intent;
        r1.<init>();
        r2 = "com.techno.gallery";
        r3 = "com.techno.gallery.CropImage";
        r1.setClassName(r2, r3);
        r1.setData(r0);
        r4.formatIntent(r1);
        r2 = 2;
        r4.startActivityForResult(r1, r2);
        goto L_0x0007;
    L_0x0029:
        r1 = new android.content.Intent;
        r2 = "android.intent.action.GET_CONTENT";
        r3 = 0;
        r1.<init>(r2, r3);
        r2 = "image/*";
        r1.setType(r2);
        r2 = "crop";
        r3 = "true";
        r1.putExtra(r2, r3);
        r4.formatIntent(r1);
        r2 = 1;
        r4.startActivityForResult(r1, r2);
        goto L_0x0007;
    }

    protected void onSaveInstanceState(android.os.Bundle r3) {
        r2 = this;
        r0 = "do_launch";
        r1 = r2.mDoLaunch;
        r3.putBoolean(r0, r1);
        r0 = "temp_file_path";
        r1 = r2.mTempFile;
        r1 = r1.getAbsolutePath();
        r3.putString(r0, r1);
        return;
    }
}