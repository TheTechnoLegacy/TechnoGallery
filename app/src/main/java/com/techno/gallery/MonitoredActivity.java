package com.techno.gallery;

public class MonitoredActivity extends android.app.Activity {
    private final java.util.ArrayList<com.techno.gallery.MonitoredActivity.LifeCycleListener> mListeners;

    public MonitoredActivity() {
        r1 = this;
        r1.<init>();
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1.mListeners = r0;
        return;
    }

    public void addLifeCycleListener(com.techno.gallery.MonitoredActivity.LifeCycleListener r2) {
        r1 = this;
        r0 = r1.mListeners;
        r0 = r0.contains(r2);
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = r1.mListeners;
        r0.add(r2);
        goto L_0x0008;
    }

    protected void onCreate(android.os.Bundle r4) {
        r3 = this;
        super.onCreate(r4);
        r2 = r3.mListeners;
        r0 = r2.iterator();
    L_0x0009:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x0019;
    L_0x000f:
        r1 = r0.next();
        r1 = (com.techno.gallery.MonitoredActivity.LifeCycleListener) r1;
        r1.onActivityCreated(r3);
        goto L_0x0009;
    L_0x0019:
        return;
    }

    protected void onDestroy() {
        r3 = this;
        super.onDestroy();
        r2 = r3.mListeners;
        r0 = r2.iterator();
    L_0x0009:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x0019;
    L_0x000f:
        r1 = r0.next();
        r1 = (com.techno.gallery.MonitoredActivity.LifeCycleListener) r1;
        r1.onActivityDestroyed(r3);
        goto L_0x0009;
    L_0x0019:
        return;
    }

    protected void onStart() {
        r3 = this;
        super.onStart();
        r2 = r3.mListeners;
        r0 = r2.iterator();
    L_0x0009:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x0019;
    L_0x000f:
        r1 = r0.next();
        r1 = (com.techno.gallery.MonitoredActivity.LifeCycleListener) r1;
        r1.onActivityStarted(r3);
        goto L_0x0009;
    L_0x0019:
        return;
    }

    protected void onStop() {
        r3 = this;
        super.onStop();
        r2 = r3.mListeners;
        r0 = r2.iterator();
    L_0x0009:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x0019;
    L_0x000f:
        r1 = r0.next();
        r1 = (com.techno.gallery.MonitoredActivity.LifeCycleListener) r1;
        r1.onActivityStopped(r3);
        goto L_0x0009;
    L_0x0019:
        return;
    }

    public void removeLifeCycleListener(com.techno.gallery.MonitoredActivity.LifeCycleListener r2) {
        r1 = this;
        r0 = r1.mListeners;
        r0.remove(r2);
        return;
    }
}