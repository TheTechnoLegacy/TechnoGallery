package com.techno.gallery;

class Wallpaper$SetWallpaperThread extends java.lang.Thread {
    private final android.graphics.Bitmap mBitmap;
    private final android.content.Context mContext;
    private final java.io.File mFile;
    private final android.os.Handler mHandler;

    public Wallpaper$SetWallpaperThread(android.graphics.Bitmap r1, android.os.Handler r2, android.content.Context r3, java.io.File r4) {
        r0 = this;
        r0.<init>();
        r0.mBitmap = r1;
        r0.mHandler = r2;
        r0.mContext = r3;
        r0.mFile = r4;
        return;
    }

    public void run() {
        r4 = this;
        r3 = 1;
        r1 = r4.mContext;	 Catch:{ IOException -> 0x0013 }
        r2 = r4.mBitmap;	 Catch:{ IOException -> 0x0013 }
        r1.setWallpaper(r2);	 Catch:{ IOException -> 0x0013 }
        r1 = r4.mHandler;
        r1.sendEmptyMessage(r3);
        r1 = r4.mFile;
        r1.delete();
    L_0x0012:
        return;
    L_0x0013:
        r1 = move-exception;
        r0 = r1;
        r1 = "Camera";
        r2 = "Failed to set wallpaper.";
        android.util.Log.e(r1, r2, r0);	 Catch:{ all -> 0x0027 }
        r1 = r4.mHandler;
        r1.sendEmptyMessage(r3);
        r1 = r4.mFile;
        r1.delete();
        goto L_0x0012;
    L_0x0027:
        r1 = move-exception;
        r2 = r4.mHandler;
        r2.sendEmptyMessage(r3);
        r2 = r4.mFile;
        r2.delete();
        throw r1;
    }
}