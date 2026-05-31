package com.techno.gallery;

/* compiled from: ViewImage */
class ImageViewTouch extends com.techno.gallery.ImageViewTouchBase {
    static final float PAN_RATE = 20.0f;
    static long nextChangePositionTime;
    private boolean mEnableTrackballScroll;
    private final com.techno.gallery.ViewImage mViewImage;

    public ImageViewTouch(android.content.Context r1) {
        r0 = this;
        r0.<init>(r1);
        r1 = (com.techno.gallery.ViewImage) r1;
        r0.mViewImage = r1;
        return;
    }

    public ImageViewTouch(android.content.Context r1, android.util.AttributeSet r2) {
        r0 = this;
        r0.<init>(r1, r2);
        r1 = (com.techno.gallery.ViewImage) r1;
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
            case 19: goto L_0x012d;
            case 20: goto L_0x0160;
            case 21: goto L_0x0087;
            case 22: goto L_0x00da;
            case 23: goto L_0x003c;
            case 67: goto L_0x0193;
            default: goto L_0x001b;
        };
    L_0x001b:
        if (r2 < 0) goto L_0x01a1;
    L_0x001d:
        r3 = r9.mViewImage;
        r3 = r3.mAllImages;
        r3 = r3.getCount();
        if (r2 >= r3) goto L_0x01a1;
    L_0x0027:
        r3 = r9.mViewImage;
        monitor-enter(r3);
        r4 = r9.mViewImage;	 Catch:{ all -> 0x019e }
        r5 = 1;
        r4.setMode(r5);	 Catch:{ all -> 0x019e }
        r4 = r9.mViewImage;	 Catch:{ all -> 0x019e }
        r5 = 1;
        r4.setImage(r2, r5);	 Catch:{ all -> 0x019e }
        monitor-exit(r3);	 Catch:{ all -> 0x019e }
    L_0x0037:
        r3 = super.onKeyDown(r10, r11);
        goto L_0x0012;
    L_0x003c:
        r3 = r9.mViewImage;	 Catch:{ all -> 0x0069 }
        r3 = r3.isPickIntent();	 Catch:{ all -> 0x0069 }
        if (r3 == 0) goto L_0x001b;
    L_0x0044:
        r3 = r9.mViewImage;	 Catch:{ all -> 0x0069 }
        r3 = r3.mAllImages;	 Catch:{ all -> 0x0069 }
        r4 = r9.mViewImage;	 Catch:{ all -> 0x0069 }
        r4 = r4.mCurrentPosition;	 Catch:{ all -> 0x0069 }
        r1 = r3.getImageAt(r4);	 Catch:{ all -> 0x0069 }
        r3 = r9.mViewImage;	 Catch:{ all -> 0x0069 }
        r4 = -1;
        r5 = new android.content.Intent;	 Catch:{ all -> 0x0069 }
        r5.<init>();	 Catch:{ all -> 0x0069 }
        r6 = r1.fullSizeImageUri();	 Catch:{ all -> 0x0069 }
        r5 = r5.setData(r6);	 Catch:{ all -> 0x0069 }
        r3.setResult(r4, r5);	 Catch:{ all -> 0x0069 }
        r3 = r9.mViewImage;	 Catch:{ all -> 0x0069 }
        r3.finish();	 Catch:{ all -> 0x0069 }
        goto L_0x001b;
    L_0x0069:
        r3 = move-exception;
        if (r2 < 0) goto L_0x01ab;
    L_0x006c:
        r4 = r9.mViewImage;
        r4 = r4.mAllImages;
        r4 = r4.getCount();
        if (r2 >= r4) goto L_0x01ab;
    L_0x0076:
        r4 = r9.mViewImage;
        monitor-enter(r4);
        r5 = r9.mViewImage;	 Catch:{ all -> 0x01a8 }
        r6 = 1;
        r5.setMode(r6);	 Catch:{ all -> 0x01a8 }
        r5 = r9.mViewImage;	 Catch:{ all -> 0x01a8 }
        r6 = 1;
        r5.setImage(r2, r6);	 Catch:{ all -> 0x01a8 }
        monitor-exit(r4);	 Catch:{ all -> 0x01a8 }
    L_0x0086:
        throw r3;
    L_0x0087:
        r3 = r9.getScale();
        r4 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));
        if (r3 > 0) goto L_0x00c5;
    L_0x0091:
        r3 = r11.getEventTime();
        r5 = nextChangePositionTime;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 < 0) goto L_0x00c5;
    L_0x009b:
        r2 = r0 - r7;
        r3 = r11.getEventTime();
        r5 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r3 = r3 + r5;
        nextChangePositionTime = r3;
    L_0x00a6:
        if (r2 < 0) goto L_0x00d4;
    L_0x00a8:
        r3 = r9.mViewImage;
        r3 = r3.mAllImages;
        r3 = r3.getCount();
        if (r2 >= r3) goto L_0x00d4;
    L_0x00b2:
        r3 = r9.mViewImage;
        monitor-enter(r3);
        r4 = r9.mViewImage;	 Catch:{ all -> 0x00d1 }
        r5 = 1;
        r4.setMode(r5);	 Catch:{ all -> 0x00d1 }
        r4 = r9.mViewImage;	 Catch:{ all -> 0x00d1 }
        r5 = 1;
        r4.setImage(r2, r5);	 Catch:{ all -> 0x00d1 }
        monitor-exit(r3);	 Catch:{ all -> 0x00d1 }
    L_0x00c2:
        r3 = r7;
        goto L_0x0012;
    L_0x00c5:
        r3 = 1101004800; // 0x41a00000 float:20.0 double:5.439686476E-315;
        r4 = 0;
        r9.panBy(r3, r4);
        r3 = 1;
        r4 = 0;
        r9.center(r3, r4);
        goto L_0x00a6;
    L_0x00d1:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
    L_0x00d4:
        if (r2 == r8) goto L_0x00c2;
    L_0x00d6:
        r9.center(r7, r7);
        goto L_0x00c2;
    L_0x00da:
        r3 = r9.getScale();
        r4 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));
        if (r3 > 0) goto L_0x0118;
    L_0x00e4:
        r3 = r11.getEventTime();
        r5 = nextChangePositionTime;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 < 0) goto L_0x0118;
    L_0x00ee:
        r2 = r0 + 1;
        r3 = r11.getEventTime();
        r5 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r3 = r3 + r5;
        nextChangePositionTime = r3;
    L_0x00f9:
        if (r2 < 0) goto L_0x0127;
    L_0x00fb:
        r3 = r9.mViewImage;
        r3 = r3.mAllImages;
        r3 = r3.getCount();
        if (r2 >= r3) goto L_0x0127;
    L_0x0105:
        r3 = r9.mViewImage;
        monitor-enter(r3);
        r4 = r9.mViewImage;	 Catch:{ all -> 0x0124 }
        r5 = 1;
        r4.setMode(r5);	 Catch:{ all -> 0x0124 }
        r4 = r9.mViewImage;	 Catch:{ all -> 0x0124 }
        r5 = 1;
        r4.setImage(r2, r5);	 Catch:{ all -> 0x0124 }
        monitor-exit(r3);	 Catch:{ all -> 0x0124 }
    L_0x0115:
        r3 = r7;
        goto L_0x0012;
    L_0x0118:
        r3 = -1046478848; // 0xffffffffc1a00000 float:-20.0 double:NaN;
        r4 = 0;
        r9.panBy(r3, r4);
        r3 = 1;
        r4 = 0;
        r9.center(r3, r4);
        goto L_0x00f9;
    L_0x0124:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
    L_0x0127:
        if (r2 == r8) goto L_0x0115;
    L_0x0129:
        r9.center(r7, r7);
        goto L_0x0115;
    L_0x012d:
        r3 = 0;
        r4 = 1101004800; // 0x41a00000 float:20.0 double:5.439686476E-315;
        r9.panBy(r3, r4);
        r3 = 0;
        r4 = 1;
        r9.center(r3, r4);
        if (r2 < 0) goto L_0x015a;
    L_0x013a:
        r3 = r9.mViewImage;
        r3 = r3.mAllImages;
        r3 = r3.getCount();
        if (r2 >= r3) goto L_0x015a;
    L_0x0144:
        r3 = r9.mViewImage;
        monitor-enter(r3);
        r4 = r9.mViewImage;	 Catch:{ all -> 0x0157 }
        r5 = 1;
        r4.setMode(r5);	 Catch:{ all -> 0x0157 }
        r4 = r9.mViewImage;	 Catch:{ all -> 0x0157 }
        r5 = 1;
        r4.setImage(r2, r5);	 Catch:{ all -> 0x0157 }
        monitor-exit(r3);	 Catch:{ all -> 0x0157 }
    L_0x0154:
        r3 = r7;
        goto L_0x0012;
    L_0x0157:
        r4 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0157 }
        throw r4;
    L_0x015a:
        if (r2 == r8) goto L_0x0154;
    L_0x015c:
        r9.center(r7, r7);
        goto L_0x0154;
    L_0x0160:
        r3 = 0;
        r4 = -1046478848; // 0xffffffffc1a00000 float:-20.0 double:NaN;
        r9.panBy(r3, r4);
        r3 = 0;
        r4 = 1;
        r9.center(r3, r4);
        if (r2 < 0) goto L_0x018d;
    L_0x016d:
        r3 = r9.mViewImage;
        r3 = r3.mAllImages;
        r3 = r3.getCount();
        if (r2 >= r3) goto L_0x018d;
    L_0x0177:
        r3 = r9.mViewImage;
        monitor-enter(r3);
        r4 = r9.mViewImage;	 Catch:{ all -> 0x018a }
        r5 = 1;
        r4.setMode(r5);	 Catch:{ all -> 0x018a }
        r4 = r9.mViewImage;	 Catch:{ all -> 0x018a }
        r5 = 1;
        r4.setImage(r2, r5);	 Catch:{ all -> 0x018a }
        monitor-exit(r3);	 Catch:{ all -> 0x018a }
    L_0x0187:
        r3 = r7;
        goto L_0x0012;
    L_0x018a:
        r4 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x018a }
        throw r4;
    L_0x018d:
        if (r2 == r8) goto L_0x0187;
    L_0x018f:
        r9.center(r7, r7);
        goto L_0x0187;
    L_0x0193:
        r3 = r9.mViewImage;
        r4 = r9.mViewImage;
        r4 = r4.mDeletePhotoRunnable;
        com.techno.gallery.MenuHelper.deletePhoto(r3, r4);
        goto L_0x001b;
    L_0x019e:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
    L_0x01a1:
        if (r2 == r8) goto L_0x0037;
    L_0x01a3:
        r9.center(r7, r7);
        goto L_0x0037;
    L_0x01a8:
        r3 = move-exception;
        monitor-exit(r4);
        throw r3;
    L_0x01ab:
        if (r2 == r8) goto L_0x0086;
    L_0x01ad:
        r9.center(r7, r7);
        goto L_0x0086;
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