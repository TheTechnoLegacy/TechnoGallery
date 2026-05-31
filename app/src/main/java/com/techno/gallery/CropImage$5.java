package com.techno.gallery;

class CropImage$5 implements java.lang.Runnable {
    android.media.FaceDetector.Face[] mFaces;
    android.graphics.Matrix mImageMatrix;
    int mNumFaces;
    float mScale;
    final /* synthetic */ com.techno.gallery.CropImage this$0;

    CropImage$5(com.techno.gallery.CropImage r2) {
        r1 = this;
        r1.this$0 = r2;
        r1.<init>();
        r0 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r1.mScale = r0;
        r0 = 3;
        r0 = new android.media.FaceDetector.Face[r0];
        r1.mFaces = r0;
        return;
    }

    static /* synthetic */ void access$1000(com.techno.gallery.CropImage$5 r0, android.media.FaceDetector.Face r1) {
        r0.handleFace(r1);
        return;
    }

    static /* synthetic */ void access$1100(com.techno.gallery.CropImage$5 r0) {
        r0.makeDefault();
        return;
    }

    private void handleFace(android.media.FaceDetector.Face r13) {
        r12 = this;
        r7 = new android.graphics.PointF;
        r7.<init>();
        r1 = r13.eyesDistance();
        r2 = r12.mScale;
        r1 = r1 * r2;
        r1 = (int) r1;
        r10 = r1 * 2;
        r13.getMidPoint(r7);
        r1 = r7.x;
        r2 = r12.mScale;
        r1 = r1 * r2;
        r7.x = r1;
        r1 = r7.y;
        r2 = r12.mScale;
        r1 = r1 * r2;
        r7.y = r1;
        r1 = r7.x;
        r8 = (int) r1;
        r1 = r7.y;
        r9 = (int) r1;
        r0 = new com.techno.gallery.HighlightView;
        r1 = r12.this$0;
        r1 = com.techno.gallery.CropImage.access$300(r1);
        r0.<init>(r1);
        r1 = r12.this$0;
        r1 = com.techno.gallery.CropImage.access$200(r1);
        r11 = r1.getWidth();
        r1 = r12.this$0;
        r1 = com.techno.gallery.CropImage.access$200(r1);
        r6 = r1.getHeight();
        r2 = new android.graphics.Rect;
        r1 = 0;
        r3 = 0;
        r2.<init>(r1, r3, r11, r6);
        r3 = new android.graphics.RectF;
        r1 = (float) r8;
        r4 = (float) r9;
        r5 = (float) r8;
        r6 = (float) r9;
        r3.<init>(r1, r4, r5, r6);
        r1 = -r10;
        r1 = (float) r1;
        r4 = -r10;
        r4 = (float) r4;
        r3.inset(r1, r4);
        r1 = r3.left;
        r4 = 0;
        r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1));
        if (r1 >= 0) goto L_0x006c;
    L_0x0063:
        r1 = r3.left;
        r1 = -r1;
        r4 = r3.left;
        r4 = -r4;
        r3.inset(r1, r4);
    L_0x006c:
        r1 = r3.top;
        r4 = 0;
        r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1));
        if (r1 >= 0) goto L_0x007c;
    L_0x0073:
        r1 = r3.top;
        r1 = -r1;
        r4 = r3.top;
        r4 = -r4;
        r3.inset(r1, r4);
    L_0x007c:
        r1 = r3.right;
        r4 = r2.right;
        r4 = (float) r4;
        r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1));
        if (r1 <= 0) goto L_0x0094;
    L_0x0085:
        r1 = r3.right;
        r4 = r2.right;
        r4 = (float) r4;
        r1 = r1 - r4;
        r4 = r3.right;
        r5 = r2.right;
        r5 = (float) r5;
        r4 = r4 - r5;
        r3.inset(r1, r4);
    L_0x0094:
        r1 = r3.bottom;
        r4 = r2.bottom;
        r4 = (float) r4;
        r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1));
        if (r1 <= 0) goto L_0x00ac;
    L_0x009d:
        r1 = r3.bottom;
        r4 = r2.bottom;
        r4 = (float) r4;
        r1 = r1 - r4;
        r4 = r3.bottom;
        r5 = r2.bottom;
        r5 = (float) r5;
        r4 = r4 - r5;
        r3.inset(r1, r4);
    L_0x00ac:
        r1 = r12.mImageMatrix;
        r4 = r12.this$0;
        r4 = com.techno.gallery.CropImage.access$600(r4);
        r5 = r12.this$0;
        r5 = com.techno.gallery.CropImage.access$700(r5);
        if (r5 == 0) goto L_0x00d2;
    L_0x00bc:
        r5 = r12.this$0;
        r5 = com.techno.gallery.CropImage.access$800(r5);
        if (r5 == 0) goto L_0x00d2;
    L_0x00c4:
        r5 = 1;
    L_0x00c5:
        r0.setup(r1, r2, r3, r4, r5);
        r1 = r12.this$0;
        r1 = com.techno.gallery.CropImage.access$300(r1);
        r1.add(r0);
        return;
    L_0x00d2:
        r5 = 0;
        goto L_0x00c5;
    }

    private void makeDefault() {
        r14 = this;
        r13 = 0;
        r0 = new com.techno.gallery.HighlightView;
        r1 = r14.this$0;
        r1 = com.techno.gallery.CropImage.access$300(r1);
        r0.<init>(r1);
        r1 = r14.this$0;
        r1 = com.techno.gallery.CropImage.access$200(r1);
        r9 = r1.getWidth();
        r1 = r14.this$0;
        r1 = com.techno.gallery.CropImage.access$200(r1);
        r8 = r1.getHeight();
        r2 = new android.graphics.Rect;
        r2.<init>(r13, r13, r9, r8);
        r1 = java.lang.Math.min(r9, r8);
        r1 = r1 * 4;
        r7 = r1 / 5;
        r6 = r7;
        r1 = r14.this$0;
        r1 = com.techno.gallery.CropImage.access$700(r1);
        if (r1 == 0) goto L_0x005b;
    L_0x0036:
        r1 = r14.this$0;
        r1 = com.techno.gallery.CropImage.access$800(r1);
        if (r1 == 0) goto L_0x005b;
    L_0x003e:
        r1 = r14.this$0;
        r1 = com.techno.gallery.CropImage.access$700(r1);
        r4 = r14.this$0;
        r4 = com.techno.gallery.CropImage.access$800(r4);
        if (r1 <= r4) goto L_0x0096;
    L_0x004c:
        r1 = r14.this$0;
        r1 = com.techno.gallery.CropImage.access$800(r1);
        r1 = r1 * r7;
        r4 = r14.this$0;
        r4 = com.techno.gallery.CropImage.access$700(r4);
        r6 = r1 / r4;
    L_0x005b:
        r1 = r9 - r7;
        r10 = r1 / 2;
        r1 = r8 - r6;
        r11 = r1 / 2;
        r3 = new android.graphics.RectF;
        r1 = (float) r10;
        r4 = (float) r11;
        r5 = r10 + r7;
        r5 = (float) r5;
        r12 = r11 + r6;
        r12 = (float) r12;
        r3.<init>(r1, r4, r5, r12);
        r1 = r14.mImageMatrix;
        r4 = r14.this$0;
        r4 = com.techno.gallery.CropImage.access$600(r4);
        r5 = r14.this$0;
        r5 = com.techno.gallery.CropImage.access$700(r5);
        if (r5 == 0) goto L_0x00a6;
    L_0x0080:
        r5 = r14.this$0;
        r5 = com.techno.gallery.CropImage.access$800(r5);
        if (r5 == 0) goto L_0x00a6;
    L_0x0088:
        r5 = 1;
    L_0x0089:
        r0.setup(r1, r2, r3, r4, r5);
        r1 = r14.this$0;
        r1 = com.techno.gallery.CropImage.access$300(r1);
        r1.add(r0);
        return;
    L_0x0096:
        r1 = r14.this$0;
        r1 = com.techno.gallery.CropImage.access$700(r1);
        r1 = r1 * r6;
        r4 = r14.this$0;
        r4 = com.techno.gallery.CropImage.access$800(r4);
        r7 = r1 / r4;
        goto L_0x005b;
    L_0x00a6:
        r5 = r13;
        goto L_0x0089;
    }

    private android.graphics.Bitmap prepareBitmap() {
        r8 = this;
        r1 = 0;
        r0 = r8.this$0;
        r0 = com.techno.gallery.CropImage.access$200(r0);
        if (r0 != 0) goto L_0x000b;
    L_0x0009:
        r0 = 0;
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = r8.this$0;
        r0 = com.techno.gallery.CropImage.access$200(r0);
        r0 = r0.getWidth();
        r2 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r0 <= r2) goto L_0x0029;
    L_0x0019:
        r0 = 1132462080; // 0x43800000 float:256.0 double:5.59510609E-315;
        r2 = r8.this$0;
        r2 = com.techno.gallery.CropImage.access$200(r2);
        r2 = r2.getWidth();
        r2 = (float) r2;
        r0 = r0 / r2;
        r8.mScale = r0;
    L_0x0029:
        r5 = new android.graphics.Matrix;
        r5.<init>();
        r0 = r8.mScale;
        r2 = r8.mScale;
        r5.setScale(r0, r2);
        r0 = r8.this$0;
        r0 = com.techno.gallery.CropImage.access$200(r0);
        r2 = r8.this$0;
        r2 = com.techno.gallery.CropImage.access$200(r2);
        r3 = r2.getWidth();
        r2 = r8.this$0;
        r2 = com.techno.gallery.CropImage.access$200(r2);
        r4 = r2.getHeight();
        r6 = 1;
        r2 = r1;
        r7 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6);
        r0 = r7;
        goto L_0x000a;
    }

    public void run() {
        r5 = this;
        r2 = r5.this$0;
        r2 = com.techno.gallery.CropImage.access$300(r2);
        r2 = r2.getImageMatrix();
        r5.mImageMatrix = r2;
        r1 = r5.prepareBitmap();
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = r5.mScale;
        r2 = r2 / r3;
        r5.mScale = r2;
        if (r1 == 0) goto L_0x0039;
    L_0x0019:
        r2 = r5.this$0;
        r2 = com.techno.gallery.CropImage.access$900(r2);
        if (r2 == 0) goto L_0x0039;
    L_0x0021:
        r0 = new android.media.FaceDetector;
        r2 = r1.getWidth();
        r3 = r1.getHeight();
        r4 = r5.mFaces;
        r4 = r4.length;
        r0.<init>(r2, r3, r4);
        r2 = r5.mFaces;
        r2 = r0.findFaces(r1, r2);
        r5.mNumFaces = r2;
    L_0x0039:
        if (r1 == 0) goto L_0x0046;
    L_0x003b:
        r2 = r5.this$0;
        r2 = com.techno.gallery.CropImage.access$200(r2);
        if (r1 == r2) goto L_0x0046;
    L_0x0043:
        r1.recycle();
    L_0x0046:
        r2 = r5.this$0;
        r2 = com.techno.gallery.CropImage.access$400(r2);
        r3 = new com.techno.gallery.CropImage$5$1;
        r3.<init>(r5);
        r2.post(r3);
        return;
    }
}