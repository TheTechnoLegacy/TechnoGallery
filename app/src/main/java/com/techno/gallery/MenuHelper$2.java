package com.techno.gallery;

class MenuHelper$2 implements com.techno.gallery.MenuHelper.MenuCallback {
    final /* synthetic */ android.app.Activity val$activity;
    final /* synthetic */ android.os.Handler val$handler;

    MenuHelper$2(android.app.Activity r1, android.os.Handler r2) {
        r0 = this;
        r0.val$activity = r1;
        r0.val$handler = r2;
        r0.<init>();
        return;
    }

    public void run(android.net.Uri r36, com.techno.gallery.gallery.IImage r37) {
        r35 = this;
        if (r37 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r7 = new android.app.AlertDialog$Builder;
        r0 = r35;
        r0 = r0.val$activity;
        r28 = r0;
        r0 = r7;
        r1 = r28;
        r0.<init>(r1);
        r0 = r35;
        r0 = r0.val$activity;
        r28 = r0;
        r29 = 2130903047; // 0x7f030007 float:1.74129E38 double:1.05280599E-314;
        r30 = 0;
        r9 = android.view.View.inflate(r28, r29, r30);
        r28 = 2131427360; // 0x7f0b0020 float:1.8476334E38 double:1.053065035E-314;
        r0 = r9;
        r1 = r28;
        r21 = r0.findViewById(r1);
        r21 = (android.widget.ImageView) r21;
        r28 = r37.miniThumbBitmap();
        r0 = r21;
        r1 = r28;
        r0.setImageBitmap(r1);
        r28 = 2131427361; // 0x7f0b0021 float:1.8476336E38 double:1.0530650357E-314;
        r0 = r9;
        r1 = r28;
        r26 = r0.findViewById(r1);
        r26 = (android.widget.TextView) r26;
        r28 = r37.getDisplayName();
        r0 = r26;
        r1 = r28;
        r0.setText(r1);
        r22 = com.techno.gallery.MenuHelper.getImageFileSize(r37);
        r28 = 0;
        r28 = (r22 > r28 ? 1 : (r22 == r28 ? 0 : -1));
        if (r28 >= 0) goto L_0x017e;
    L_0x0058:
        r28 = "";
        r24 = r28;
    L_0x005c:
        r28 = 2131427362; // 0x7f0b0022 float:1.8476338E38 double:1.053065036E-314;
        r0 = r9;
        r1 = r28;
        r36 = r0.findViewById(r1);
        r36 = (android.widget.TextView) r36;
        r0 = r36;
        r1 = r24;
        r0.setText(r1);
        r15 = 0;
        r14 = 0;
        r28 = com.techno.gallery.ImageManager.isImage(r37);
        if (r28 == 0) goto L_0x0190;
    L_0x0077:
        r15 = r37.getWidth();
        r14 = r37.getHeight();
        r28 = 2131427377; // 0x7f0b0031 float:1.8476369E38 double:1.0530650436E-314;
        r0 = r9;
        r1 = r28;
        r28 = r0.findViewById(r1);
        r29 = 8;
        r28.setVisibility(r29);
        r28 = 2131427379; // 0x7f0b0033 float:1.8476373E38 double:1.0530650446E-314;
        r0 = r9;
        r1 = r28;
        r28 = r0.findViewById(r1);
        r29 = 8;
        r28.setVisibility(r29);
        r28 = 2131427381; // 0x7f0b0035 float:1.8476377E38 double:1.0530650456E-314;
        r0 = r9;
        r1 = r28;
        r28 = r0.findViewById(r1);
        r29 = 8;
        r28.setVisibility(r29);
        r28 = 2131427383; // 0x7f0b0037 float:1.847638E38 double:1.0530650465E-314;
        r0 = r9;
        r1 = r28;
        r28 = r0.findViewById(r1);
        r29 = 8;
        r28.setVisibility(r29);
        r28 = 2131427385; // 0x7f0b0039 float:1.8476385E38 double:1.0530650475E-314;
        r0 = r9;
        r1 = r28;
        r28 = r0.findViewById(r1);
        r29 = 8;
        r28.setVisibility(r29);
    L_0x00ca:
        r27 = 0;
        if (r15 <= 0) goto L_0x00f9;
    L_0x00ce:
        if (r14 <= 0) goto L_0x00f9;
    L_0x00d0:
        r0 = r35;
        r0 = r0.val$activity;
        r28 = r0;
        r29 = 2131296404; // 0x7f090094 float:1.8210724E38 double:1.0530003343E-314;
        r28 = r28.getString(r29);
        r29 = 2;
        r0 = r29;
        r0 = new java.lang.Object[r0];
        r29 = r0;
        r30 = 0;
        r31 = java.lang.Integer.valueOf(r15);
        r29[r30] = r31;
        r30 = 1;
        r31 = java.lang.Integer.valueOf(r14);
        r29[r30] = r31;
        r27 = java.lang.String.format(r28, r29);
    L_0x00f9:
        if (r27 == 0) goto L_0x0347;
    L_0x00fb:
        r28 = 2131427364; // 0x7f0b0024 float:1.8476342E38 double:1.053065037E-314;
        r0 = r9;
        r1 = r27;
        r2 = r28;
        com.techno.gallery.MenuHelper.access$000(r0, r1, r2);
    L_0x0106:
        r27 = "";
        r12 = r37.getDateTaken();
        r28 = 0;
        r28 = (r12 > r28 ? 1 : (r12 == r28 ? 0 : -1));
        if (r28 == 0) goto L_0x0127;
    L_0x0112:
        r10 = new java.util.Date;
        r28 = r37.getDateTaken();
        r0 = r10;
        r1 = r28;
        r0.<init>(r1);
        r11 = new java.text.SimpleDateFormat;
        r11.<init>();
        r27 = r11.format(r10);
    L_0x0127:
        r28 = "";
        r0 = r27;
        r1 = r28;
        if (r0 == r1) goto L_0x0352;
    L_0x012f:
        r28 = 2131427388; // 0x7f0b003c float:1.847639E38 double:1.053065049E-314;
        r0 = r9;
        r1 = r27;
        r2 = r28;
        com.techno.gallery.MenuHelper.access$000(r0, r1, r2);
    L_0x013a:
        r28 = "image/jpeg";
        r29 = r37.getMimeType();
        r28 = r28.equals(r29);
        if (r28 == 0) goto L_0x035d;
    L_0x0146:
        r0 = r35;
        r0 = r0.val$activity;
        r28 = r0;
        r0 = r37;
        r1 = r9;
        r2 = r28;
        com.techno.gallery.MenuHelper.access$300(r0, r1, r2);
    L_0x0154:
        r28 = 2131296410; // 0x7f09009a float:1.8210736E38 double:1.0530003373E-314;
        r29 = new com.techno.gallery.MenuHelper$2$1;
        r0 = r29;
        r1 = r35;
        r0.<init>(r1);
        r0 = r7;
        r1 = r28;
        r2 = r29;
        r0.setNeutralButton(r1, r2);
        r0 = r35;
        r0 = r0.val$handler;
        r28 = r0;
        r29 = new com.techno.gallery.MenuHelper$2$2;
        r0 = r29;
        r1 = r35;
        r2 = r7;
        r3 = r9;
        r0.<init>(r1, r2, r3);
        r28.post(r29);
        goto L_0x0002;
    L_0x017e:
        r0 = r35;
        r0 = r0.val$activity;
        r28 = r0;
        r0 = r28;
        r1 = r22;
        r28 = android.text.format.Formatter.formatFileSize(r0, r1);
        r24 = r28;
        goto L_0x005c;
    L_0x0190:
        r25 = new android.media.MediaMetadataRetriever;
        r25.<init>();
        r28 = 1;
        r0 = r25;
        r1 = r28;
        r0.setMode(r1);	 Catch:{ RuntimeException -> 0x02d8, all -> 0x02f5 }
        r28 = r37.getDataPath();	 Catch:{ RuntimeException -> 0x02d8, all -> 0x02f5 }
        r0 = r25;
        r1 = r28;
        r0.setDataSource(r1);	 Catch:{ RuntimeException -> 0x02d8, all -> 0x02f5 }
        r28 = 20;
        r0 = r25;
        r1 = r28;
        r28 = r0.extractMetadata(r1);	 Catch:{ NumberFormatException -> 0x02bd }
        r15 = java.lang.Integer.parseInt(r28);	 Catch:{ NumberFormatException -> 0x02bd }
        r28 = 19;
        r0 = r25;
        r1 = r28;
        r28 = r0.extractMetadata(r1);	 Catch:{ NumberFormatException -> 0x02bd }
        r14 = java.lang.Integer.parseInt(r28);	 Catch:{ NumberFormatException -> 0x02bd }
    L_0x01c5:
        r28 = 9;
        r0 = r25;
        r1 = r28;
        r28 = r0.extractMetadata(r1);	 Catch:{ NumberFormatException -> 0x02c4 }
        r16 = java.lang.Integer.parseInt(r28);	 Catch:{ NumberFormatException -> 0x02c4 }
        r0 = r35;
        r0 = r0.val$activity;	 Catch:{ NumberFormatException -> 0x02c4 }
        r28 = r0;
        r0 = r28;
        r1 = r16;
        r17 = com.techno.gallery.MenuHelper.formatDuration(r0, r1);	 Catch:{ NumberFormatException -> 0x02c4 }
        r28 = 2131427378; // 0x7f0b0032 float:1.847637E38 double:1.053065044E-314;
        r0 = r9;
        r1 = r28;
        r36 = r0.findViewById(r1);	 Catch:{ NumberFormatException -> 0x02c4 }
        r36 = (android.widget.TextView) r36;	 Catch:{ NumberFormatException -> 0x02c4 }
        r0 = r36;
        r1 = r17;
        r0.setText(r1);	 Catch:{ NumberFormatException -> 0x02c4 }
    L_0x01f4:
        r0 = r35;
        r0 = r0.val$activity;	 Catch:{ NumberFormatException -> 0x02e1 }
        r28 = r0;
        r29 = 2131296407; // 0x7f090097 float:1.821073E38 double:1.053000336E-314;
        r28 = r28.getString(r29);	 Catch:{ NumberFormatException -> 0x02e1 }
        r29 = 1;
        r0 = r29;
        r0 = new java.lang.Object[r0];	 Catch:{ NumberFormatException -> 0x02e1 }
        r29 = r0;
        r30 = 0;
        r31 = 17;
        r0 = r25;
        r1 = r31;
        r31 = r0.extractMetadata(r1);	 Catch:{ NumberFormatException -> 0x02e1 }
        r31 = java.lang.Integer.parseInt(r31);	 Catch:{ NumberFormatException -> 0x02e1 }
        r31 = java.lang.Integer.valueOf(r31);	 Catch:{ NumberFormatException -> 0x02e1 }
        r29[r30] = r31;	 Catch:{ NumberFormatException -> 0x02e1 }
        r20 = java.lang.String.format(r28, r29);	 Catch:{ NumberFormatException -> 0x02e1 }
        r28 = 2131427380; // 0x7f0b0034 float:1.8476375E38 double:1.053065045E-314;
        r0 = r9;
        r1 = r28;
        r36 = r0.findViewById(r1);	 Catch:{ NumberFormatException -> 0x02e1 }
        r36 = (android.widget.TextView) r36;	 Catch:{ NumberFormatException -> 0x02e1 }
        r0 = r36;
        r1 = r20;
        r0.setText(r1);	 Catch:{ NumberFormatException -> 0x02e1 }
    L_0x0236:
        r28 = 16;
        r0 = r25;
        r1 = r28;
        r28 = r0.extractMetadata(r1);	 Catch:{ NumberFormatException -> 0x0328 }
        r4 = java.lang.Long.parseLong(r28);	 Catch:{ NumberFormatException -> 0x0328 }
        r28 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r28 = (r4 > r28 ? 1 : (r4 == r28 ? 0 : -1));
        if (r28 >= 0) goto L_0x02fa;
    L_0x024b:
        r0 = r35;
        r0 = r0.val$activity;	 Catch:{ NumberFormatException -> 0x0328 }
        r28 = r0;
        r29 = 2131296408; // 0x7f090098 float:1.8210732E38 double:1.0530003363E-314;
        r28 = r28.getString(r29);	 Catch:{ NumberFormatException -> 0x0328 }
        r29 = 1;
        r0 = r29;
        r0 = new java.lang.Object[r0];	 Catch:{ NumberFormatException -> 0x0328 }
        r29 = r0;
        r30 = 0;
        r31 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r31 = r4 / r31;
        r31 = java.lang.Long.valueOf(r31);	 Catch:{ NumberFormatException -> 0x0328 }
        r29[r30] = r31;	 Catch:{ NumberFormatException -> 0x0328 }
        r6 = java.lang.String.format(r28, r29);	 Catch:{ NumberFormatException -> 0x0328 }
    L_0x0270:
        r28 = 2131427382; // 0x7f0b0036 float:1.8476379E38 double:1.053065046E-314;
        r0 = r9;
        r1 = r28;
        r36 = r0.findViewById(r1);	 Catch:{ NumberFormatException -> 0x0328 }
        r36 = (android.widget.TextView) r36;	 Catch:{ NumberFormatException -> 0x0328 }
        r0 = r36;
        r1 = r6;
        r0.setText(r1);	 Catch:{ NumberFormatException -> 0x0328 }
    L_0x0282:
        r28 = 18;
        r0 = r25;
        r1 = r28;
        r19 = r0.extractMetadata(r1);
        r28 = 2131427384; // 0x7f0b0038 float:1.8476383E38 double:1.053065047E-314;
        r0 = r9;
        r1 = r28;
        r36 = r0.findViewById(r1);
        r36 = (android.widget.TextView) r36;
        r0 = r36;
        r1 = r19;
        r0.setText(r1);
        r28 = 12;
        r0 = r25;
        r1 = r28;
        r8 = r0.extractMetadata(r1);
        if (r8 == 0) goto L_0x033c;
    L_0x02ab:
        r28 = 2131427386; // 0x7f0b003a float:1.8476387E38 double:1.053065048E-314;
        r0 = r9;
        r1 = r8;
        r2 = r28;
        com.techno.gallery.MenuHelper.access$000(r0, r1, r2);
    L_0x02b5:
        r25.release();	 Catch:{ RuntimeException -> 0x02ba }
        goto L_0x00ca;
    L_0x02ba:
        r28 = move-exception;
        goto L_0x00ca;
    L_0x02bd:
        r28 = move-exception;
        r18 = r28;
        r15 = 0;
        r14 = 0;
        goto L_0x01c5;
    L_0x02c4:
        r28 = move-exception;
        r18 = r28;
        r28 = 2131427379; // 0x7f0b0033 float:1.8476373E38 double:1.0530650446E-314;
        r0 = r9;
        r1 = r28;
        r28 = r0.findViewById(r1);
        r29 = 8;
        r28.setVisibility(r29);
        goto L_0x01f4;
    L_0x02d8:
        r28 = move-exception;
        r25.release();	 Catch:{ RuntimeException -> 0x02de }
        goto L_0x00ca;
    L_0x02de:
        r28 = move-exception;
        goto L_0x00ca;
    L_0x02e1:
        r28 = move-exception;
        r18 = r28;
        r28 = 2131427379; // 0x7f0b0033 float:1.8476373E38 double:1.0530650446E-314;
        r0 = r9;
        r1 = r28;
        r28 = r0.findViewById(r1);
        r29 = 8;
        r28.setVisibility(r29);
        goto L_0x0236;
    L_0x02f5:
        r28 = move-exception;
        r25.release();	 Catch:{ RuntimeException -> 0x0362 }
    L_0x02f9:
        throw r28;
    L_0x02fa:
        r0 = r35;
        r0 = r0.val$activity;
        r28 = r0;
        r29 = 2131296409; // 0x7f090099 float:1.8210734E38 double:1.053000337E-314;
        r28 = r28.getString(r29);
        r29 = 1;
        r0 = r29;
        r0 = new java.lang.Object[r0];
        r29 = r0;
        r30 = 0;
        r0 = r4;
        r0 = (double) r0;
        r31 = r0;
        r33 = 4696837146684686336; // 0x412e848000000000 float:0.0 double:1000000.0;
        r31 = r31 / r33;
        r31 = java.lang.Double.valueOf(r31);
        r29[r30] = r31;
        r6 = java.lang.String.format(r28, r29);
        goto L_0x0270;
    L_0x0328:
        r28 = move-exception;
        r18 = r28;
        r28 = 2131427381; // 0x7f0b0035 float:1.8476377E38 double:1.0530650456E-314;
        r0 = r9;
        r1 = r28;
        r28 = r0.findViewById(r1);
        r29 = 8;
        r28.setVisibility(r29);
        goto L_0x0282;
    L_0x033c:
        r28 = 2131427385; // 0x7f0b0039 float:1.8476385E38 double:1.0530650475E-314;
        r0 = r9;
        r1 = r28;
        com.techno.gallery.MenuHelper.access$100(r0, r1);
        goto L_0x02b5;
    L_0x0347:
        r28 = 2131427363; // 0x7f0b0023 float:1.847634E38 double:1.0530650367E-314;
        r0 = r9;
        r1 = r28;
        com.techno.gallery.MenuHelper.access$100(r0, r1);
        goto L_0x0106;
    L_0x0352:
        r28 = 2131427387; // 0x7f0b003b float:1.8476389E38 double:1.0530650485E-314;
        r0 = r9;
        r1 = r28;
        com.techno.gallery.MenuHelper.access$100(r0, r1);
        goto L_0x013a;
    L_0x035d:
        com.techno.gallery.MenuHelper.access$400(r9);
        goto L_0x0154;
    L_0x0362:
        r29 = move-exception;
        goto L_0x02f9;
    }
}