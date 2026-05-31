package com.techno.gallery;

public class PhotoAppWidgetProvider extends android.appwidget.AppWidgetProvider {
    private static final boolean LOGD = true;
    private static final java.lang.String TAG = "PhotoAppWidgetProvider";

    public PhotoAppWidgetProvider() {
        r0 = this;
        r0.<init>();
        return;
    }

    static android.widget.RemoteViews buildUpdate(android.content.Context r4, int r5, com.techno.gallery.PhotoAppWidgetProvider.PhotoDatabaseHelper r6) {
        r1 = 0;
        r0 = r6.getPhoto(r5);
        if (r0 == 0) goto L_0x0019;
    L_0x0007:
        r1 = new android.widget.RemoteViews;
        r2 = r4.getPackageName();
        r3 = 2130903054; // 0x7f03000e float:1.7412915E38 double:1.0528059936E-314;
        r1.<init>(r2, r3);
        r2 = 2131427401; // 0x7f0b0049 float:1.8476417E38 double:1.0530650554E-314;
        r1.setImageViewBitmap(r2, r0);
    L_0x0019:
        return r1;
    }

    public void onDeleted(android.content.Context r6, int[] r7) {
        r5 = this;
        r2 = new com.techno.gallery.PhotoAppWidgetProvider$PhotoDatabaseHelper;
        r2.<init>(r6);
        r1 = r7;
        r4 = r1.length;
        r3 = 0;
    L_0x0008:
        if (r3 >= r4) goto L_0x0012;
    L_0x000a:
        r0 = r1[r3];
        r2.deletePhoto(r0);
        r3 = r3 + 1;
        goto L_0x0008;
    L_0x0012:
        r2.close();
        return;
    }

    public void onUpdate(android.content.Context r11, android.appwidget.AppWidgetManager r12, int[] r13) {
        r10 = this;
        r2 = new com.techno.gallery.PhotoAppWidgetProvider$PhotoDatabaseHelper;
        r2.<init>(r11);
        r1 = r13;
        r4 = r1.length;
        r3 = 0;
    L_0x0008:
        if (r3 >= r4) goto L_0x003e;
    L_0x000a:
        r0 = r1[r3];
        r7 = 1;
        r5 = new int[r7];
        r7 = 0;
        r5[r7] = r0;
        r6 = buildUpdate(r11, r0, r2);
        r7 = "PhotoAppWidgetProvider";
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "sending out views=";
        r8 = r8.append(r9);
        r8 = r8.append(r6);
        r9 = " for id=";
        r8 = r8.append(r9);
        r8 = r8.append(r0);
        r8 = r8.toString();
        android.util.Log.d(r7, r8);
        r12.updateAppWidget(r5, r6);
        r3 = r3 + 1;
        goto L_0x0008;
    L_0x003e:
        r2.close();
        return;
    }
}