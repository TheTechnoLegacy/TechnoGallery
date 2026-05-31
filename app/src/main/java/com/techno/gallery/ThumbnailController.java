package com.techno.gallery;

public class ThumbnailController {
    private static final int BUFSIZE = 4096;
    private static final java.lang.String TAG = "ThumbnailController";
    private final android.widget.ImageView mButton;
    private final android.content.ContentResolver mContentResolver;
    private boolean mShouldAnimateButton;
    private boolean mShouldAnimateThumb;
    private final android.view.animation.Animation mShowButtonAnimation;
    private android.graphics.Bitmap mThumb;
    private android.graphics.drawable.TransitionDrawable mThumbTransition;
    private android.graphics.drawable.Drawable[] mThumbs;
    private android.net.Uri mUri;

    public ThumbnailController(android.widget.ImageView r4, android.content.ContentResolver r5) {
        r3 = this;
        r3.<init>();
        r0 = new android.view.animation.AlphaAnimation;
        r1 = 0;
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0.<init>(r1, r2);
        r3.mShowButtonAnimation = r0;
        r3.mButton = r4;
        r3.mContentResolver = r5;
        r0 = r3.mShowButtonAnimation;
        r1 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r0.setDuration(r1);
        return;
    }

    private void updateThumb(android.graphics.Bitmap r12) {
        r11 = this;
        r6 = 0;
        r7 = 4;
        r10 = 0;
        r9 = 1;
        if (r12 != 0) goto L_0x000b;
    L_0x0006:
        r11.mThumb = r6;
        r11.mThumbs = r6;
    L_0x000a:
        return;
    L_0x000b:
        r1 = 2;
        r0 = 2;
        r6 = r11.mButton;
        r5 = r6.getLayoutParams();
        r6 = r5.width;
        r4 = r6 - r7;
        r6 = r5.height;
        r3 = r6 - r7;
        r6 = com.techno.gallery.Util.extractMiniThumb(r12, r4, r3, r10);
        r11.mThumb = r6;
        r6 = r11.mThumbs;
        if (r6 != 0) goto L_0x004b;
    L_0x0025:
        r6 = 2;
        r6 = new android.graphics.drawable.Drawable[r6];
        r11.mThumbs = r6;
        r6 = r11.mThumbs;
        r7 = new android.graphics.drawable.BitmapDrawable;
        r8 = r11.mThumb;
        r7.<init>(r8);
        r6[r9] = r7;
        r6 = r11.mThumbs;
        r2 = r6[r9];
        r11.mShouldAnimateThumb = r10;
    L_0x003b:
        r6 = r11.mButton;
        r6.setImageDrawable(r2);
        r6 = r11.mButton;
        r6 = r6.getVisibility();
        if (r6 == 0) goto L_0x000a;
    L_0x0048:
        r11.mShouldAnimateButton = r9;
        goto L_0x000a;
    L_0x004b:
        r6 = r11.mThumbs;
        r7 = r11.mThumbs;
        r7 = r7[r9];
        r6[r10] = r7;
        r6 = r11.mThumbs;
        r7 = new android.graphics.drawable.BitmapDrawable;
        r8 = r11.mThumb;
        r7.<init>(r8);
        r6[r9] = r7;
        r6 = new android.graphics.drawable.TransitionDrawable;
        r7 = r11.mThumbs;
        r6.<init>(r7);
        r11.mThumbTransition = r6;
        r2 = r11.mThumbTransition;
        r11.mShouldAnimateThumb = r9;
        goto L_0x003b;
    }

    public android.graphics.Bitmap getThumb() {
        r1 = this;
        r0 = r1.mThumb;
        return r0;
    }

    public android.net.Uri getUri() {
        r1 = this;
        r0 = r1.mUri;
        return r0;
    }

    public boolean isUriValid() {
        r6 = this;
        r5 = 0;
        r2 = r6.mUri;
        if (r2 != 0) goto L_0x0007;
    L_0x0005:
        r2 = r5;
    L_0x0006:
        return r2;
    L_0x0007:
        r2 = r6.mContentResolver;	 Catch:{ IOException -> 0x0021 }
        r3 = r6.mUri;	 Catch:{ IOException -> 0x0021 }
        r4 = "r";
        r1 = r2.openFileDescriptor(r3, r4);	 Catch:{ IOException -> 0x0021 }
        if (r1 != 0) goto L_0x001c;
    L_0x0013:
        r2 = "ThumbnailController";
        r3 = "Fail to open URI.";
        android.util.Log.e(r2, r3);	 Catch:{ IOException -> 0x0021 }
        r2 = r5;
        goto L_0x0006;
    L_0x001c:
        r1.close();	 Catch:{ IOException -> 0x0021 }
        r2 = 1;
        goto L_0x0006;
    L_0x0021:
        r2 = move-exception;
        r0 = r2;
        r2 = r5;
        goto L_0x0006;
    }

    public boolean loadData(java.lang.String r11) {
        r10 = this;
        r5 = 0;
        r0 = 0;
        r2 = 0;
        r6 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0034, all -> 0x0041 }
        r6.<init>(r11);	 Catch:{ IOException -> 0x0034, all -> 0x0041 }
        r1 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0058, all -> 0x004c }
        r9 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r1.<init>(r6, r9);	 Catch:{ IOException -> 0x0058, all -> 0x004c }
        r3 = new java.io.DataInputStream;	 Catch:{ IOException -> 0x005c, all -> 0x004f }
        r3.<init>(r1);	 Catch:{ IOException -> 0x005c, all -> 0x004f }
        r9 = r3.readUTF();	 Catch:{ IOException -> 0x0061, all -> 0x0053 }
        r8 = android.net.Uri.parse(r9);	 Catch:{ IOException -> 0x0061, all -> 0x0053 }
        r7 = android.graphics.BitmapFactory.decodeStream(r3);	 Catch:{ IOException -> 0x0061, all -> 0x0053 }
        r10.setData(r8, r7);	 Catch:{ IOException -> 0x0061, all -> 0x0053 }
        r3.close();	 Catch:{ IOException -> 0x0061, all -> 0x0053 }
        com.techno.gallery.MenuHelper.closeSilently(r6);
        com.techno.gallery.MenuHelper.closeSilently(r1);
        com.techno.gallery.MenuHelper.closeSilently(r3);
        r9 = 1;
        r2 = r3;
        r0 = r1;
        r5 = r6;
    L_0x0033:
        return r9;
    L_0x0034:
        r9 = move-exception;
        r4 = r9;
    L_0x0036:
        r9 = 0;
        com.techno.gallery.MenuHelper.closeSilently(r5);
        com.techno.gallery.MenuHelper.closeSilently(r0);
        com.techno.gallery.MenuHelper.closeSilently(r2);
        goto L_0x0033;
    L_0x0041:
        r9 = move-exception;
    L_0x0042:
        com.techno.gallery.MenuHelper.closeSilently(r5);
        com.techno.gallery.MenuHelper.closeSilently(r0);
        com.techno.gallery.MenuHelper.closeSilently(r2);
        throw r9;
    L_0x004c:
        r9 = move-exception;
        r5 = r6;
        goto L_0x0042;
    L_0x004f:
        r9 = move-exception;
        r0 = r1;
        r5 = r6;
        goto L_0x0042;
    L_0x0053:
        r9 = move-exception;
        r2 = r3;
        r0 = r1;
        r5 = r6;
        goto L_0x0042;
    L_0x0058:
        r9 = move-exception;
        r4 = r9;
        r5 = r6;
        goto L_0x0036;
    L_0x005c:
        r9 = move-exception;
        r4 = r9;
        r0 = r1;
        r5 = r6;
        goto L_0x0036;
    L_0x0061:
        r9 = move-exception;
        r4 = r9;
        r2 = r3;
        r0 = r1;
        r5 = r6;
        goto L_0x0036;
    }

    public void setData(android.net.Uri r1, android.graphics.Bitmap r2) {
        r0 = this;
        if (r1 == 0) goto L_0x0004;
    L_0x0002:
        if (r2 != 0) goto L_0x0006;
    L_0x0004:
        r1 = 0;
        r2 = 0;
    L_0x0006:
        r0.mUri = r1;
        r0.updateThumb(r2);
        return;
    }

    public boolean storeData(java.lang.String r12) {
        r11 = this;
        r10 = 0;
        r7 = r11.mUri;
        if (r7 != 0) goto L_0x0007;
    L_0x0005:
        r7 = r10;
    L_0x0006:
        return r7;
    L_0x0007:
        r5 = 0;
        r0 = 0;
        r2 = 0;
        r6 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x003b, all -> 0x0048 }
        r6.<init>(r12);	 Catch:{ IOException -> 0x003b, all -> 0x0048 }
        r1 = new java.io.BufferedOutputStream;	 Catch:{ IOException -> 0x005f, all -> 0x0053 }
        r7 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r1.<init>(r6, r7);	 Catch:{ IOException -> 0x005f, all -> 0x0053 }
        r3 = new java.io.DataOutputStream;	 Catch:{ IOException -> 0x0063, all -> 0x0056 }
        r3.<init>(r1);	 Catch:{ IOException -> 0x0063, all -> 0x0056 }
        r7 = r11.mUri;	 Catch:{ IOException -> 0x0068, all -> 0x005a }
        r7 = r7.toString();	 Catch:{ IOException -> 0x0068, all -> 0x005a }
        r3.writeUTF(r7);	 Catch:{ IOException -> 0x0068, all -> 0x005a }
        r7 = r11.mThumb;	 Catch:{ IOException -> 0x0068, all -> 0x005a }
        r8 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ IOException -> 0x0068, all -> 0x005a }
        r9 = 100;
        r7.compress(r8, r9, r3);	 Catch:{ IOException -> 0x0068, all -> 0x005a }
        r3.close();	 Catch:{ IOException -> 0x0068, all -> 0x005a }
        com.techno.gallery.MenuHelper.closeSilently(r6);
        com.techno.gallery.MenuHelper.closeSilently(r1);
        com.techno.gallery.MenuHelper.closeSilently(r3);
        r7 = 1;
        goto L_0x0006;
    L_0x003b:
        r7 = move-exception;
        r4 = r7;
    L_0x003d:
        com.techno.gallery.MenuHelper.closeSilently(r5);
        com.techno.gallery.MenuHelper.closeSilently(r0);
        com.techno.gallery.MenuHelper.closeSilently(r2);
        r7 = r10;
        goto L_0x0006;
    L_0x0048:
        r7 = move-exception;
    L_0x0049:
        com.techno.gallery.MenuHelper.closeSilently(r5);
        com.techno.gallery.MenuHelper.closeSilently(r0);
        com.techno.gallery.MenuHelper.closeSilently(r2);
        throw r7;
    L_0x0053:
        r7 = move-exception;
        r5 = r6;
        goto L_0x0049;
    L_0x0056:
        r7 = move-exception;
        r0 = r1;
        r5 = r6;
        goto L_0x0049;
    L_0x005a:
        r7 = move-exception;
        r2 = r3;
        r0 = r1;
        r5 = r6;
        goto L_0x0049;
    L_0x005f:
        r7 = move-exception;
        r4 = r7;
        r5 = r6;
        goto L_0x003d;
    L_0x0063:
        r7 = move-exception;
        r4 = r7;
        r0 = r1;
        r5 = r6;
        goto L_0x003d;
    L_0x0068:
        r7 = move-exception;
        r4 = r7;
        r2 = r3;
        r0 = r1;
        r5 = r6;
        goto L_0x003d;
    }

    public void updateDisplayIfNeeded() {
        r3 = this;
        r2 = 0;
        r0 = r3.mUri;
        if (r0 != 0) goto L_0x000c;
    L_0x0005:
        r0 = r3.mButton;
        r1 = 4;
        r0.setVisibility(r1);
    L_0x000b:
        return;
    L_0x000c:
        r0 = r3.mShouldAnimateButton;
        if (r0 == 0) goto L_0x001e;
    L_0x0010:
        r0 = r3.mButton;
        r0.setVisibility(r2);
        r0 = r3.mButton;
        r1 = r3.mShowButtonAnimation;
        r0.startAnimation(r1);
        r3.mShouldAnimateButton = r2;
    L_0x001e:
        r0 = r3.mShouldAnimateThumb;
        if (r0 == 0) goto L_0x000b;
    L_0x0022:
        r0 = r3.mThumbTransition;
        r1 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r0.startTransition(r1);
        r3.mShouldAnimateThumb = r2;
        goto L_0x000b;
    }
}