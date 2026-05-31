package com.techno.gallery;

public class DeleteImage extends android.app.Activity {
    private static final java.lang.String TAG = "DeleteImage";
    private android.content.ContentResolver mContentResolver;
    private final java.lang.Runnable mDeleteNextRunnable;
    private final android.os.Handler mHandler;
    private int mIndex;
    private boolean mPausing;
    private android.widget.ProgressBar mProgressBar;
    private java.util.ArrayList<android.net.Uri> mUriList;

    public DeleteImage() {
        r1 = this;
        r1.<init>();
        r0 = 0;
        r1.mIndex = r0;
        r0 = new android.os.Handler;
        r0.<init>();
        r1.mHandler = r0;
        r0 = new com.techno.gallery.DeleteImage$1;
        r0.<init>(r1);
        r1.mDeleteNextRunnable = r0;
        return;
    }

    static /* synthetic */ void access$000(com.techno.gallery.DeleteImage r0) {
        r0.deleteNext();
        return;
    }

    private void deleteNext() {
        r5 = this;
        r4 = 0;
        r1 = r5.mPausing;
        if (r1 == 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r1 = r5.mIndex;
        r2 = r5.mUriList;
        r2 = r2.size();
        if (r1 < r2) goto L_0x0014;
    L_0x0010:
        r5.finish();
        goto L_0x0005;
    L_0x0014:
        r1 = r5.mUriList;
        r2 = r5.mIndex;
        r3 = r2 + 1;
        r5.mIndex = r3;
        r0 = r1.get(r2);
        r0 = (android.net.Uri) r0;
        r1 = r5.mProgressBar;
        r2 = r5.mIndex;
        r2 = r2 * 10000;
        r3 = r5.mUriList;
        r3 = r3.size();
        r2 = r2 / r3;
        r1.setProgress(r2);
        r1 = r5.mContentResolver;
        r1.delete(r0, r4, r4);
        r1 = r5.mHandler;
        r2 = r5.mDeleteNextRunnable;
        r1.post(r2);
        goto L_0x0005;
    }

    protected void onCreate(android.os.Bundle r3) {
        r2 = this;
        super.onCreate(r3);
        r0 = r2.getIntent();
        r1 = "delete-uris";
        r1 = r0.getParcelableArrayListExtra(r1);
        r2.mUriList = r1;
        r1 = r2.mUriList;
        if (r1 != 0) goto L_0x0016;
    L_0x0013:
        r2.finish();
    L_0x0016:
        r1 = 2130903045; // 0x7f030005 float:1.7412897E38 double:1.052805989E-314;
        r2.setContentView(r1);
        r1 = 2131427347; // 0x7f0b0013 float:1.8476308E38 double:1.053065029E-314;
        r1 = r2.findViewById(r1);
        r1 = (android.widget.ProgressBar) r1;
        r2.mProgressBar = r1;
        r1 = r2.getContentResolver();
        r2.mContentResolver = r1;
        return;
    }

    protected void onPause() {
        r1 = this;
        super.onPause();
        r0 = 1;
        r1.mPausing = r0;
        return;
    }

    protected void onResume() {
        r2 = this;
        super.onResume();
        r0 = 0;
        r2.mPausing = r0;
        r0 = r2.mHandler;
        r1 = r2.mDeleteNextRunnable;
        r0.post(r1);
        return;
    }
}