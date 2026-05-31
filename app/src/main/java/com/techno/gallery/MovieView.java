package com.techno.gallery;

public class MovieView extends android.app.Activity {
    private static final java.lang.String TAG = "MovieView";
    private com.techno.gallery.MovieViewControl mControl;
    private boolean mFinishOnCompletion;

    public MovieView() {
        r0 = this;
        r0.<init>();
        return;
    }

    static /* synthetic */ boolean access$000(com.techno.gallery.MovieView r1) {
        r0 = r1.mFinishOnCompletion;
        return r0;
    }

    public void onCreate(android.os.Bundle r7) {
        r6 = this;
        r5 = "android.intent.extra.screenOrientation";
        super.onCreate(r7);
        r3 = 2130903052; // 0x7f03000c float:1.7412911E38 double:1.0528059926E-314;
        r6.setContentView(r3);
        r3 = 2131427390; // 0x7f0b003e float:1.8476395E38 double:1.05306505E-314;
        r2 = r6.findViewById(r3);
        r0 = r6.getIntent();
        r3 = new com.techno.gallery.MovieView$1;
        r4 = r0.getData();
        r3.<init>(r6, r2, r6, r4);
        r6.mControl = r3;
        r3 = "android.intent.extra.screenOrientation";
        r3 = r0.hasExtra(r5);
        if (r3 == 0) goto L_0x0039;
    L_0x0029:
        r3 = "android.intent.extra.screenOrientation";
        r3 = -1;
        r1 = r0.getIntExtra(r5, r3);
        r3 = r6.getRequestedOrientation();
        if (r1 == r3) goto L_0x0039;
    L_0x0036:
        r6.setRequestedOrientation(r1);
    L_0x0039:
        r3 = "android.intent.extra.finishOnCompletion";
        r4 = 1;
        r3 = r0.getBooleanExtra(r3, r4);
        r6.mFinishOnCompletion = r3;
        return;
    }

    public void onPause() {
        r1 = this;
        r0 = r1.mControl;
        r0.onPause();
        super.onPause();
        return;
    }

    public void onResume() {
        r1 = this;
        r0 = r1.mControl;
        r0.onResume();
        super.onResume();
        return;
    }
}