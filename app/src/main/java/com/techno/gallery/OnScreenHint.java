package com.techno.gallery;

public class OnScreenHint {
    static final boolean LOCAL_LOGV = false;
    static final java.lang.String TAG = "OnScreenHint";
    final android.content.Context mContext;
    int mGravity;
    private final android.os.Handler mHandler;
    private final java.lang.Runnable mHide;
    float mHorizontalMargin;
    android.view.View mNextView;
    private final android.view.WindowManager.LayoutParams mParams;
    private final java.lang.Runnable mShow;
    float mVerticalMargin;
    android.view.View mView;
    private final android.view.WindowManager mWM;
    int mX;
    int mY;

    public OnScreenHint(android.content.Context r4) {
        r3 = this;
        r2 = -2;
        r3.<init>();
        r0 = 81;
        r3.mGravity = r0;
        r0 = new android.view.WindowManager$LayoutParams;
        r0.<init>();
        r3.mParams = r0;
        r0 = new android.os.Handler;
        r0.<init>();
        r3.mHandler = r0;
        r0 = new com.techno.gallery.OnScreenHint$1;
        r0.<init>(r3);
        r3.mShow = r0;
        r0 = new com.techno.gallery.OnScreenHint$2;
        r0.<init>(r3);
        r3.mHide = r0;
        r3.mContext = r4;
        r0 = "window";
        r0 = r4.getSystemService(r0);
        r0 = (android.view.WindowManager) r0;
        r3.mWM = r0;
        r0 = r4.getResources();
        r1 = 2131230720; // 0x7f080000 float:1.80775E38 double:1.052967882E-314;
        r0 = r0.getDimensionPixelSize(r1);
        r3.mY = r0;
        r0 = r3.mParams;
        r0.height = r2;
        r0 = r3.mParams;
        r0.width = r2;
        r0 = r3.mParams;
        r1 = 24;
        r0.flags = r1;
        r0 = r3.mParams;
        r1 = -3;
        r0.format = r1;
        r0 = r3.mParams;
        r1 = 2131361795; // 0x7f0a0003 float:1.8343352E38 double:1.053032642E-314;
        r0.windowAnimations = r1;
        r0 = r3.mParams;
        r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0.type = r1;
        r0 = r3.mParams;
        r1 = "OnScreenHint";
        r0.setTitle(r1);
        return;
    }

    static /* synthetic */ void access$000(com.techno.gallery.OnScreenHint r0) {
        r0.handleShow();
        return;
    }

    static /* synthetic */ void access$100(com.techno.gallery.OnScreenHint r0) {
        r0.handleHide();
        return;
    }

    private synchronized void handleHide() {
        r2 = this;
        monitor-enter(r2);
        r0 = r2.mView;	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x0017;
    L_0x0005:
        r0 = r2.mView;	 Catch:{ all -> 0x0019 }
        r0 = r0.getParent();	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x0014;
    L_0x000d:
        r0 = r2.mWM;	 Catch:{ all -> 0x0019 }
        r1 = r2.mView;	 Catch:{ all -> 0x0019 }
        r0.removeView(r1);	 Catch:{ all -> 0x0019 }
    L_0x0014:
        r0 = 0;
        r2.mView = r0;	 Catch:{ all -> 0x0019 }
    L_0x0017:
        monitor-exit(r2);
        return;
    L_0x0019:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    }

    private synchronized void handleShow() {
        r4 = this;
        monitor-enter(r4);
        r1 = r4.mView;	 Catch:{ all -> 0x005d }
        r2 = r4.mNextView;	 Catch:{ all -> 0x005d }
        if (r1 == r2) goto L_0x005b;
    L_0x0007:
        r4.handleHide();	 Catch:{ all -> 0x005d }
        r1 = r4.mNextView;	 Catch:{ all -> 0x005d }
        r4.mView = r1;	 Catch:{ all -> 0x005d }
        r0 = r4.mGravity;	 Catch:{ all -> 0x005d }
        r1 = r4.mParams;	 Catch:{ all -> 0x005d }
        r1.gravity = r0;	 Catch:{ all -> 0x005d }
        r1 = r0 & 7;
        r2 = 7;
        if (r1 != r2) goto L_0x001f;
    L_0x0019:
        r1 = r4.mParams;	 Catch:{ all -> 0x005d }
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r1.horizontalWeight = r2;	 Catch:{ all -> 0x005d }
    L_0x001f:
        r1 = r0 & 112;
        r2 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        if (r1 != r2) goto L_0x002b;
    L_0x0025:
        r1 = r4.mParams;	 Catch:{ all -> 0x005d }
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r1.verticalWeight = r2;	 Catch:{ all -> 0x005d }
    L_0x002b:
        r1 = r4.mParams;	 Catch:{ all -> 0x005d }
        r2 = r4.mX;	 Catch:{ all -> 0x005d }
        r1.x = r2;	 Catch:{ all -> 0x005d }
        r1 = r4.mParams;	 Catch:{ all -> 0x005d }
        r2 = r4.mY;	 Catch:{ all -> 0x005d }
        r1.y = r2;	 Catch:{ all -> 0x005d }
        r1 = r4.mParams;	 Catch:{ all -> 0x005d }
        r2 = r4.mVerticalMargin;	 Catch:{ all -> 0x005d }
        r1.verticalMargin = r2;	 Catch:{ all -> 0x005d }
        r1 = r4.mParams;	 Catch:{ all -> 0x005d }
        r2 = r4.mHorizontalMargin;	 Catch:{ all -> 0x005d }
        r1.horizontalMargin = r2;	 Catch:{ all -> 0x005d }
        r1 = r4.mView;	 Catch:{ all -> 0x005d }
        r1 = r1.getParent();	 Catch:{ all -> 0x005d }
        if (r1 == 0) goto L_0x0052;
    L_0x004b:
        r1 = r4.mWM;	 Catch:{ all -> 0x005d }
        r2 = r4.mView;	 Catch:{ all -> 0x005d }
        r1.removeView(r2);	 Catch:{ all -> 0x005d }
    L_0x0052:
        r1 = r4.mWM;	 Catch:{ all -> 0x005d }
        r2 = r4.mView;	 Catch:{ all -> 0x005d }
        r3 = r4.mParams;	 Catch:{ all -> 0x005d }
        r1.addView(r2, r3);	 Catch:{ all -> 0x005d }
    L_0x005b:
        monitor-exit(r4);
        return;
    L_0x005d:
        r1 = move-exception;
        monitor-exit(r4);
        throw r1;
    }

    public static com.techno.gallery.OnScreenHint makeText(android.content.Context r1, int r2) throws android.content.res.Resources.NotFoundException {
        r0 = r1.getResources();
        r0 = r0.getText(r2);
        r0 = makeText(r1, r0);
        return r0;
    }

    public static com.techno.gallery.OnScreenHint makeText(android.content.Context r6, java.lang.CharSequence r7) {
        r1 = new com.techno.gallery.OnScreenHint;
        r1.<init>(r6);
        r4 = "layout_inflater";
        r0 = r6.getSystemService(r4);
        r0 = (android.view.LayoutInflater) r0;
        r4 = 2130903053; // 0x7f03000d float:1.7412913E38 double:1.052805993E-314;
        r5 = 0;
        r3 = r0.inflate(r4, r5);
        r4 = 2131427400; // 0x7f0b0048 float:1.8476415E38 double:1.053065055E-314;
        r2 = r3.findViewById(r4);
        r2 = (android.widget.TextView) r2;
        r2.setText(r7);
        r1.mNextView = r3;
        return r1;
    }

    public void cancel() {
        r2 = this;
        r0 = r2.mHandler;
        r1 = r2.mHide;
        r0.post(r1);
        return;
    }

    public android.view.View getView() {
        r1 = this;
        r0 = r1.mNextView;
        return r0;
    }

    public void setText(int r2) {
        r1 = this;
        r0 = r1.mContext;
        r0 = r0.getText(r2);
        r1.setText(r0);
        return;
    }

    public void setText(java.lang.CharSequence r5) {
        r4 = this;
        r3 = "This OnScreenHint was not created with OnScreenHint.makeText()";
        r1 = r4.mNextView;
        if (r1 != 0) goto L_0x000e;
    L_0x0006:
        r1 = new java.lang.RuntimeException;
        r2 = "This OnScreenHint was not created with OnScreenHint.makeText()";
        r1.<init>(r3);
        throw r1;
    L_0x000e:
        r1 = r4.mNextView;
        r2 = 2131427400; // 0x7f0b0048 float:1.8476415E38 double:1.053065055E-314;
        r0 = r1.findViewById(r2);
        r0 = (android.widget.TextView) r0;
        if (r0 != 0) goto L_0x0023;
    L_0x001b:
        r1 = new java.lang.RuntimeException;
        r2 = "This OnScreenHint was not created with OnScreenHint.makeText()";
        r1.<init>(r3);
        throw r1;
    L_0x0023:
        r0.setText(r5);
        return;
    }

    public void setView(android.view.View r1) {
        r0 = this;
        r0.mNextView = r1;
        return;
    }

    public void show() {
        r2 = this;
        r0 = r2.mNextView;
        if (r0 != 0) goto L_0x000c;
    L_0x0004:
        r0 = new java.lang.RuntimeException;
        r1 = "setView must have been called";
        r0.<init>(r1);
        throw r0;
    L_0x000c:
        r0 = r2.mHandler;
        r1 = r2.mShow;
        r0.post(r1);
        return;
    }
}