package com.techno.gallery;

public class PhotoAppWidgetConfigure extends android.app.Activity {
    static final int REQUEST_GET_PHOTO = 2;
    private static final java.lang.String TAG = "PhotoAppWidgetConfigure";
    int mAppWidgetId;

    public PhotoAppWidgetConfigure() {
        r1 = this;
        r1.<init>();
        r0 = -1;
        r1.mAppWidgetId = r0;
        return;
    }

    protected void onActivityResult(int r9, int r10, android.content.Intent r11) {
        r8 = this;
        r6 = -1;
        if (r10 != r6) goto L_0x0048;
    L_0x0003:
        r5 = r8.mAppWidgetId;
        if (r5 == r6) goto L_0x0048;
    L_0x0007:
        r5 = "data";
        r1 = r11.getParcelableExtra(r5);
        r1 = (android.graphics.Bitmap) r1;
        r2 = new com.techno.gallery.PhotoAppWidgetProvider$PhotoDatabaseHelper;
        r2.<init>(r8);
        r5 = r8.mAppWidgetId;
        r5 = r2.setPhoto(r5, r1);
        if (r5 == 0) goto L_0x0032;
    L_0x001c:
        r10 = -1;
        r5 = r8.mAppWidgetId;
        r4 = com.techno.gallery.PhotoAppWidgetProvider.buildUpdate(r8, r5, r2);
        r0 = android.appwidget.AppWidgetManager.getInstance(r8);
        r5 = 1;
        r5 = new int[r5];
        r6 = 0;
        r7 = r8.mAppWidgetId;
        r5[r6] = r7;
        r0.updateAppWidget(r5, r4);
    L_0x0032:
        r2.close();
    L_0x0035:
        r3 = new android.content.Intent;
        r3.<init>();
        r5 = "appWidgetId";
        r6 = r8.mAppWidgetId;
        r3.putExtra(r5, r6);
        r8.setResult(r10, r3);
        r8.finish();
        return;
    L_0x0048:
        r10 = 0;
        goto L_0x0035;
    }

    protected void onCreate(android.os.Bundle r7) {
        r6 = this;
        r5 = 192; // 0xc0 float:2.69E-43 double:9.5E-322;
        r4 = -1;
        r3 = 1;
        super.onCreate(r7);
        r1 = r6.getIntent();
        r2 = "appWidgetId";
        r1 = r1.getIntExtra(r2, r4);
        r6.mAppWidgetId = r1;
        r1 = r6.mAppWidgetId;
        if (r1 != r4) goto L_0x001e;
    L_0x0017:
        r1 = 0;
        r6.setResult(r1);
        r6.finish();
    L_0x001e:
        r0 = new android.content.Intent;
        r1 = "android.intent.action.GET_CONTENT";
        r2 = 0;
        r0.<init>(r1, r2);
        r1 = "image/*";
        r0.setType(r1);
        r1 = "crop";
        r2 = "true";
        r0.putExtra(r1, r2);
        r1 = "aspectX";
        r0.putExtra(r1, r3);
        r1 = "aspectY";
        r0.putExtra(r1, r3);
        r1 = "outputX";
        r0.putExtra(r1, r5);
        r1 = "outputY";
        r0.putExtra(r1, r5);
        r1 = "noFaceDetection";
        r0.putExtra(r1, r3);
        r1 = "return-data";
        r0.putExtra(r1, r3);
        r1 = 2;
        r6.startActivityForResult(r0, r1);
        return;
    }
}