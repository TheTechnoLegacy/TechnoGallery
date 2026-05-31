package com.techno.gallery;

public class ReverseGeocoderTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.String> {
    private static final java.lang.String TAG = "ReverseGeocoder";
    private com.techno.gallery.ReverseGeocoderTask.Callback mCallback;
    private android.location.Geocoder mGeocoder;
    private float mLat;
    private float mLng;

    public ReverseGeocoderTask(android.location.Geocoder r2, float[] r3, com.techno.gallery.ReverseGeocoderTask.Callback r4) {
        r1 = this;
        r1.<init>();
        r1.mGeocoder = r2;
        r0 = 0;
        r0 = r3[r0];
        r1.mLat = r0;
        r0 = 1;
        r0 = r3[r0];
        r1.mLng = r0;
        r1.mCallback = r4;
        return;
    }

    protected /* bridge */ /* synthetic */ java.lang.Object doInBackground(java.lang.Object[] r2) {
        r1 = this;
        r2 = (java.lang.Void[]) r2;
        r0 = r1.doInBackground(r2);
        return r0;
    }

    protected java.lang.String doInBackground(java.lang.Void... r14) {
        r13 = this;
        r12 = "";
        r0 = r13.mGeocoder;	 Catch:{ IOException -> 0x0030, RuntimeException -> 0x0041 }
        r1 = r13.mLat;	 Catch:{ IOException -> 0x0030, RuntimeException -> 0x0041 }
        r1 = (double) r1;	 Catch:{ IOException -> 0x0030, RuntimeException -> 0x0041 }
        r3 = r13.mLng;	 Catch:{ IOException -> 0x0030, RuntimeException -> 0x0041 }
        r3 = (double) r3;	 Catch:{ IOException -> 0x0030, RuntimeException -> 0x0041 }
        r5 = 1;
        r7 = r0.getFromLocation(r1, r3, r5);	 Catch:{ IOException -> 0x0030, RuntimeException -> 0x0041 }
        r11 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0030, RuntimeException -> 0x0041 }
        r11.<init>();	 Catch:{ IOException -> 0x0030, RuntimeException -> 0x0041 }
        r9 = r7.iterator();	 Catch:{ IOException -> 0x0030, RuntimeException -> 0x0041 }
    L_0x0018:
        r0 = r9.hasNext();	 Catch:{ IOException -> 0x0030, RuntimeException -> 0x0041 }
        if (r0 == 0) goto L_0x003c;
    L_0x001e:
        r6 = r9.next();	 Catch:{ IOException -> 0x0030, RuntimeException -> 0x0041 }
        r6 = (android.location.Address) r6;	 Catch:{ IOException -> 0x0030, RuntimeException -> 0x0041 }
        r10 = r6.getMaxAddressLineIndex();	 Catch:{ IOException -> 0x0030, RuntimeException -> 0x0041 }
        r0 = r6.getAddressLine(r10);	 Catch:{ IOException -> 0x0030, RuntimeException -> 0x0041 }
        r11.append(r0);	 Catch:{ IOException -> 0x0030, RuntimeException -> 0x0041 }
        goto L_0x0018;
    L_0x0030:
        r0 = move-exception;
        r8 = r0;
        r12 = "";
        r0 = "ReverseGeocoder";
        r1 = "Geocoder exception: ";
        android.util.Log.e(r0, r1, r8);
    L_0x003b:
        return r12;
    L_0x003c:
        r12 = r11.toString();
        goto L_0x003b;
    L_0x0041:
        r0 = move-exception;
        r8 = r0;
        r12 = "";
        r0 = "ReverseGeocoder";
        r1 = "Geocoder exception: ";
        android.util.Log.e(r0, r1, r8);
        goto L_0x003b;
    }

    protected /* bridge */ /* synthetic */ void onPostExecute(java.lang.Object r1) {
        r0 = this;
        r1 = (java.lang.String) r1;
        r0.onPostExecute(r1);
        return;
    }

    protected void onPostExecute(java.lang.String r2) {
        r1 = this;
        r0 = r1.mCallback;
        r0.onComplete(r2);
        return;
    }
}