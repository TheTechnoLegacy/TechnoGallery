package com.techno.gallery.gallery;

class Image$SaveImageContentsCancelable extends com.techno.gallery.gallery.BaseCancelable<java.lang.Void> {
    private final android.graphics.Bitmap mImage;
    private final byte[] mJpegData;
    final /* synthetic */ com.techno.gallery.gallery.Image this$0;

    Image$SaveImageContentsCancelable(com.techno.gallery.gallery.Image r1, android.graphics.Bitmap r2, byte[] r3, int r4, java.lang.String r5) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        r0.mImage = r2;
        r0.mJpegData = r3;
        return;
    }

    public /* bridge */ /* synthetic */ java.lang.Object execute() throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        r1 = this;
        r0 = r1.execute();
        return r0;
    }

    public java.lang.Object execute() {
        r5 = this;
        r0 = 0;
        r2 = r5.this$0;
        r2 = r2.mContainer;
        r3 = r5.this$0;
        r3 = r3.mId;
        r1 = r2.contentUri(r3);
        r2 = r5.this$0;
        r3 = r5.mImage;
        r4 = r5.mJpegData;
        r2 = r2.compressImageToFile(r3, r4, r1);
        r5.runSubTask(r2);
        r2 = 0;
        return r2;
    }
}