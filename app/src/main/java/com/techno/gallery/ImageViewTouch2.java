package com.techno.gallery;

/* compiled from: ReviewImage */
class ImageViewTouch2 extends com.techno.gallery.ImageViewTouchBase {
    static final float PAN_RATE = 20.0f;
    static long nextChangePositionTime;
    private boolean mEnableTrackballScroll;
    private final com.techno.gallery.ReviewImage mViewImage;

    public ImageViewTouch2(android.content.Context r1) {
        r0 = this;
        r0.<init>(r1);
        r1 = (com.techno.gallery.ReviewImage) r1;
        r0.mViewImage = r1;
        return;
    }

    public ImageViewTouch2(android.content.Context r1, android.util.AttributeSet r2) {
        r0 = this;
        r0.<init>(r1, r2);
        r1 = (com.techno.gallery.ReviewImage) r1;
        r0.mViewImage = r1;
        return;
    }

    public boolean onKeyDown(int r10, android.view.KeyEvent r11) {
        r9 = this;
        r8 = -2;
        r7 = 1;
        r3 = r9.mEnableTrackballScroll;
        if (r3 != 0) goto L_0x0013;
    L_0x0006:
        r3 = 19;
        if (r10 < r3) goto L_0x0013;
    L_0x000a:
        r3 = 22;
        if (r10 > r3) goto L_0x0013;
    L_0x000e:
        r3 = super.onKeyDown(r10, r11);
    L_0x0012:
        return r3;
    L_0x0013:
        r3 = r9.mViewImage;
        r0 = r3.mCurrentPosition;
        r2 = -2;
        switch(r10) {
            case 19: goto L_0x0115;
            case 20: goto L_0x0142;
            case 21: goto L_0x007b;
            case 22: goto L_0x00c8;
            case 23: goto L_0x0036;
            case 67: goto L_0x016f;
            default: goto L_0x001b;
        };
    L_0x001b:
        if (r2 < 0) goto L_0x017d;
    L_0x001d:
        r3 = r9.mViewImage;
        r3 = r3.mAllImages;
        r3 = r3.getCount();
        if (r2 >= r3) goto L_0x017d;
    L_0x0027:
        r3 = r9.mViewImage;
        monitor-enter(r3);
        r4 = r9.mViewImage;	 Catch:{ all -> 0x017a }
        r5 = 1;
        r4.setImage(r2, r5);	 Catch:{ all -> 0x017a }
        monitor-exit(r3);	 Catch:{ all -> 0x017a }
    L_0x0031:
        r3 = super.onKeyDown(r10, r11);
        goto L_0x0012;
    L_0x0036:
        r3 = r9.mViewImage;	 Catch:{ all -> 0x0063 }
        r3 = r3.isPickIntent();	 Catch:{ all -> 0x0063 }
        if (r3 == 0) goto L_0x001b;
    L_0x003e:
        r3 = r9.mViewImage;	 Catch:{ all -> 0x0063 }
        r3 = r3.mAllImages;	 Catch:{ all -> 0x0063 }
        r4 = r9.mViewImage;	 Catch:{ all -> 0x0063 }
        r4 = r4.mCurrentPosition;	 Catch:{ all -> 0x0063 }
        r1 = r3.getImageAt(r4);	 Catch:{ all -> 0x0063 }
        r3 = r9.mViewImage;	 Catch:{ all -> 0x0063 }
        r4 = -1;
        r5 = new android.content.Intent;	 Catch:{ all -> 0x0063 }
        r5.<init>();	 Catch:{ all -> 0x0063 }
        r6 = r1.fullSizeImageUri();	 Catch:{ all -> 0x0063 }
        r5 = r5.setData(r6);	 Catch:{ all -> 0x0063 }
        r3.setResult(r4, r5);	 Catch:{ all -> 0x0063 }
        r3 = r9.mViewImage;	 Catch:{ all -> 0x0063 }
        r3.finish();	 Catch:{ all -> 0x0063 }
        goto L_0x001b;
    L_0x0063:
        r3 = move-exception;
        if (r2 < 0) goto L_0x0187;
    L_0x0066:
        r4 = r9.mViewImage;
        r4 = r4.mAllImages;
        r4 = r4.getCount();
        if (r2 >= r4) goto L_0x0187;
    L_0x0070:
        r4 = r9.mViewImage;
        monitor-enter(r4);
        r5 = r9.mViewImage;	 Catch:{ all -> 0x0184 }
        r6 = 1;
        r5.setImage(r2, r6);	 Catch:{ all -> 0x0184 }
        monitor-exit(r4);	 Catch:{ all -> 0x0184 }
    L_0x007a:
        throw r3;
    L_0x007b:
        r3 = r9.getScale();
        r4 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));
        if (r3 > 0) goto L_0x00b3;
    L_0x0085:
        r3 = r11.getEventTime();
        r5 = nextChangePositionTime;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 < 0) goto L_0x00b3;
    L_0x008f:
        r2 = r0 - r7;
        r3 = r11.getEventTime();
        r5 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r3 = r3 + r5;
        nextChangePositionTime = r3;
    L_0x009a:
        if (r2 < 0) goto L_0x00c2;
    L_0x009c:
        r3 = r9.mViewImage;
        r3 = r3.mAllImages;
        r3 = r3.getCount();
        if (r2 >= r3) goto L_0x00c2;
    L_0x00a6:
        r3 = r9.mViewImage;
        monitor-enter(r3);
        r4 = r9.mViewImage;	 Catch:{ all -> 0x00bf }
        r5 = 1;
        r4.setImage(r2, r5);	 Catch:{ all -> 0x00bf }
        monitor-exit(r3);	 Catch:{ all -> 0x00bf }
    L_0x00b0:
        r3 = r7;
        goto L_0x0012;
    L_0x00b3:
        r3 = 1101004800; // 0x41a00000 float:20.0 double:5.439686476E-315;
        r4 = 0;
        r9.panBy(r3, r4);
        r3 = 1;
        r4 = 0;
        r9.center(r3, r4);
        goto L_0x009a;
    L_0x00bf:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
    L_0x00c2:
        if (r2 == r8) goto L_0x00b0;
    L_0x00c4:
        r9.center(r7, r7);
        goto L_0x00b0;
    L_0x00c8:
        r3 = r9.getScale();
        r4 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));
        if (r3 > 0) goto L_0x0100;
    L_0x00d2:
        r3 = r11.getEventTime();
        r5 = nextChangePositionTime;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 < 0) goto L_0x0100;
    L_0x00dc:
        r2 = r0 + 1;
        r3 = r11.getEventTime();
        r5 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r3 = r3 + r5;
        nextChangePositionTime = r3;
    L_0x00e7:
        if (r2 < 0) goto L_0x010f;
    L_0x00e9:
        r3 = r9.mViewImage;
        r3 = r3.mAllImages;
        r3 = r3.getCount();
        if (r2 >= r3) goto L_0x010f;
    L_0x00f3:
        r3 = r9.mViewImage;
        monitor-enter(r3);
        r4 = r9.mViewImage;	 Catch:{ all -> 0x010c }
        r5 = 1;
        r4.setImage(r2, r5);	 Catch:{ all -> 0x010c }
        monitor-exit(r3);	 Catch:{ all -> 0x010c }
    L_0x00fd:
        r3 = r7;
        goto L_0x0012;
    L_0x0100:
        r3 = -1046478848; // 0xffffffffc1a00000 float:-20.0 double:NaN;
        r4 = 0;
        r9.panBy(r3, r4);
        r3 = 1;
        r4 = 0;
        r9.center(r3, r4);
        goto L_0x00e7;
    L_0x010c:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
    L_0x010f:
        if (r2 == r8) goto L_0x00fd;
    L_0x0111:
        r9.center(r7, r7);
        goto L_0x00fd;
    L_0x0115:
        r3 = 0;
        r4 = 1101004800; // 0x41a00000 float:20.0 double:5.439686476E-315;
        r9.panBy(r3, r4);
        r3 = 0;
        r4 = 1;
        r9.center(r3, r4);
        if (r2 < 0) goto L_0x013c;
    L_0x0122:
        r3 = r9.mViewImage;
        r3 = r3.mAllImages;
        r3 = r3.getCount();
        if (r2 >= r3) goto L_0x013c;
    L_0x012c:
        r3 = r9.mViewImage;
        monitor-enter(r3);
        r4 = r9.mViewImage;	 Catch:{ all -> 0x0139 }
        r5 = 1;
        r4.setImage(r2, r5);	 Catch:{ all -> 0x0139 }
        monitor-exit(r3);	 Catch:{ all -> 0x0139 }
    L_0x0136:
        r3 = r7;
        goto L_0x0012;
    L_0x0139:
        r4 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0139 }
        throw r4;
    L_0x013c:
        if (r2 == r8) goto L_0x0136;
    L_0x013e:
        r9.center(r7, r7);
        goto L_0x0136;
    L_0x0142:
        r3 = 0;
        r4 = -1046478848; // 0xffffffffc1a00000 float:-20.0 double:NaN;
        r9.panBy(r3, r4);
        r3 = 0;
        r4 = 1;
        r9.center(r3, r4);
        if (r2 < 0) goto L_0x0169;
    L_0x014f:
        r3 = r9.mViewImage;
        r3 = r3.mAllImages;
        r3 = r3.getCount();
        if (r2 >= r3) goto L_0x0169;
    L_0x0159:
        r3 = r9.mViewImage;
        monitor-enter(r3);
        r4 = r9.mViewImage;	 Catch:{ all -> 0x0166 }
        r5 = 1;
        r4.setImage(r2, r5);	 Catch:{ all -> 0x0166 }
        monitor-exit(r3);	 Catch:{ all -> 0x0166 }
    L_0x0163:
        r3 = r7;
        goto L_0x0012;
    L_0x0166:
        r4 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0166 }
        throw r4;
    L_0x0169:
        if (r2 == r8) goto L_0x0163;
    L_0x016b:
        r9.center(r7, r7);
        goto L_0x0163;
    L_0x016f:
        r3 = r9.mViewImage;
        r4 = r9.mViewImage;
        r4 = r4.mDeletePhotoRunnable;
        com.techno.gallery.MenuHelper.deletePhoto(r3, r4);
        goto L_0x001b;
    L_0x017a:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
    L_0x017d:
        if (r2 == r8) goto L_0x0031;
    L_0x017f:
        r9.center(r7, r7);
        goto L_0x0031;
    L_0x0184:
        r3 = move-exception;
        monitor-exit(r4);
        throw r3;
    L_0x0187:
        if (r2 == r8) goto L_0x007a;
    L_0x0189:
        r9.center(r7, r7);
        goto L_0x007a;
    }

    protected void postTranslateCenter(float r2, float r3) {
        r1 = this;
        r0 = 1;
        super.postTranslate(r2, r3);
        r1.center(r0, r0);
        return;
    }

    public void setEnableTrackballScroll(boolean r1) {
        r0 = this;
        r0.mEnableTrackballScroll = r1;
        return;
    }
}