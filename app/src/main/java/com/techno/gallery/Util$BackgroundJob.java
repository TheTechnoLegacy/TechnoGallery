package com.techno.gallery;

class Util$BackgroundJob extends com.techno.gallery.MonitoredActivity.LifeCycleAdapter implements java.lang.Runnable {
    private final com.techno.gallery.MonitoredActivity mActivity;
    private final java.lang.Runnable mCleanupRunner;
    private final android.app.ProgressDialog mDialog;
    private final android.os.Handler mHandler;
    private final java.lang.Runnable mJob;

    public Util$BackgroundJob(com.techno.gallery.MonitoredActivity r2, java.lang.Runnable r3, android.app.ProgressDialog r4, android.os.Handler r5) {
        r1 = this;
        r1.<init>();
        r0 = new com.techno.gallery.Util$BackgroundJob$1;
        r0.<init>(r1);
        r1.mCleanupRunner = r0;
        r1.mActivity = r2;
        r1.mDialog = r4;
        r1.mJob = r3;
        r0 = r1.mActivity;
        r0.addLifeCycleListener(r1);
        r1.mHandler = r5;
        return;
    }

    static /* synthetic */ com.techno.gallery.MonitoredActivity access$000(com.techno.gallery.Util$BackgroundJob r1) {
        r0 = r1.mActivity;
        return r0;
    }

    static /* synthetic */ android.app.ProgressDialog access$100(com.techno.gallery.Util$BackgroundJob r1) {
        r0 = r1.mDialog;
        return r0;
    }

    public void onActivityDestroyed(com.techno.gallery.MonitoredActivity r3) {
        r2 = this;
        r0 = r2.mCleanupRunner;
        r0.run();
        r0 = r2.mHandler;
        r1 = r2.mCleanupRunner;
        r0.removeCallbacks(r1);
        return;
    }

    public void onActivityStarted(com.techno.gallery.MonitoredActivity r2) {
        r1 = this;
        r0 = r1.mDialog;
        r0.show();
        return;
    }

    public void onActivityStopped(com.techno.gallery.MonitoredActivity r2) {
        r1 = this;
        r0 = r1.mDialog;
        r0.hide();
        return;
    }

    public void run() {
        r3 = this;
        r0 = r3.mJob;	 Catch:{ all -> 0x000d }
        r0.run();	 Catch:{ all -> 0x000d }
        r0 = r3.mHandler;
        r1 = r3.mCleanupRunner;
        r0.post(r1);
        return;
    L_0x000d:
        r0 = move-exception;
        r1 = r3.mHandler;
        r2 = r3.mCleanupRunner;
        r1.post(r2);
        throw r0;
    }
}