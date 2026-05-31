package com.techno.gallery;

class PhotoAppWidgetBind extends android.app.Activity {
    private static final java.lang.String EXTRA_APPWIDGET_BITMAPS = "com.techno.gallery.appwidgetbitmaps";
    private static final java.lang.String TAG = "PhotoAppWidgetBind";

    PhotoAppWidgetBind() {
        r0 = this;
        r0.<init>();
        return;
    }

    protected void onCreate(android.os.Bundle r12) {
        r11 = this;
        super.onCreate(r12);
        r11.finish();
        r7 = r11.getIntent();
        r4 = r7.getExtras();
        r9 = "appWidgetIds";
        r1 = r4.getIntArray(r9);
        r9 = "com.techno.gallery.appwidgetbitmaps";
        r3 = r4.getParcelableArrayList(r9);
        if (r1 == 0) goto L_0x0025;
    L_0x001c:
        if (r3 == 0) goto L_0x0025;
    L_0x001e:
        r9 = r1.length;
        r10 = r3.size();
        if (r9 == r10) goto L_0x002d;
    L_0x0025:
        r9 = "PhotoAppWidgetBind";
        r10 = "Problem parsing photo widget bind request";
        android.util.Log.e(r9, r10);
    L_0x002c:
        return;
    L_0x002d:
        r2 = android.appwidget.AppWidgetManager.getInstance(r11);
        r5 = new com.techno.gallery.PhotoAppWidgetProvider$PhotoDatabaseHelper;
        r5.<init>(r11);
        r6 = 0;
    L_0x0037:
        r9 = r1.length;
        if (r6 >= r9) goto L_0x0055;
    L_0x003a:
        r0 = r1[r6];
        r9 = r3.get(r6);
        r9 = (android.graphics.Bitmap) r9;
        r5.setPhoto(r0, r9);
        r8 = com.techno.gallery.PhotoAppWidgetProvider.buildUpdate(r11, r0, r5);
        r9 = 1;
        r9 = new int[r9];
        r10 = 0;
        r9[r10] = r0;
        r2.updateAppWidget(r9, r8);
        r6 = r6 + 1;
        goto L_0x0037;
    L_0x0055:
        r5.close();
        goto L_0x002c;
    }
}