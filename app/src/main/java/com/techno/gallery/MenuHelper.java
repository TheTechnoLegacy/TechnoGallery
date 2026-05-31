package com.techno.gallery;

public class MenuHelper {
    public static final int CANNOT_STAT_ERROR = -2;
    public static final java.lang.String EMPTY_STRING = "";
    public static final int GENERIC_ITEM = 1;
    public static final int IMAGE_MODE_ITEM = 4;
    public static final int IMAGE_SAVING_ITEM = 2;
    public static final int INCLUDE_ALL = -1;
    public static final int INCLUDE_CROP_MENU = 8;
    public static final int INCLUDE_DELETE_MENU = 16;
    public static final int INCLUDE_DETAILS_MENU = 64;
    public static final int INCLUDE_ROTATE_MENU = 32;
    public static final int INCLUDE_SET_MENU = 4;
    public static final int INCLUDE_SHARE_MENU = 2;
    public static final int INCLUDE_SHOWMAP_MENU = 128;
    public static final int INCLUDE_VIEWPLAY_MENU = 1;
    public static final float INVALID_LATLNG = 255.0f;
    public static final java.lang.String JPEG_MIME_TYPE = "image/jpeg";
    public static final int MENU_CAPTURE_PICTURE = 1;
    public static final int MENU_CAPTURE_VIDEO = 2;
    public static final int MENU_IMAGE_CROP = 18;
    public static final int MENU_IMAGE_ROTATE = 19;
    public static final int MENU_IMAGE_ROTATE_LEFT = 20;
    public static final int MENU_IMAGE_ROTATE_RIGHT = 21;
    public static final int MENU_IMAGE_SET = 14;
    public static final int MENU_IMAGE_SET_WALLPAPER = 15;
    public static final int MENU_IMAGE_SHARE = 10;
    public static final int MENU_IMAGE_TOSS = 22;
    public static final int MENU_ITEM_MAX = 5;
    public static final int MENU_SWITCH_CAMERA_MODE = 0;
    public static final int MENU_VIDEO_PLAY = 23;
    public static final int MENU_VIDEO_SHARE = 24;
    public static final int NO_STORAGE_ERROR = -1;
    public static final int RESULT_COMMON_MENU_CROP = 490;
    private static final java.lang.String TAG = "MenuHelper";
    public static final int VIDEO_MODE_ITEM = 5;
    public static final int VIDEO_SAVING_ITEM = 3;

    public MenuHelper() {
        r0 = this;
        r0.<init>();
        return;
    }

    static /* synthetic */ void access$000(android.view.View r0, java.lang.String r1, int r2) {
        setDetailsValue(r0, r1, r2);
        return;
    }

    static /* synthetic */ void access$100(android.view.View r0, int r1) {
        hideDetailsRow(r0, r1);
        return;
    }

    static /* synthetic */ boolean access$1000(com.techno.gallery.MenuHelper.MenuInvoker r1, android.os.Handler r2, android.app.Activity r3) {
        r0 = onDetailsClicked(r1, r2, r3);
        return r0;
    }

    static /* synthetic */ boolean access$1100(com.techno.gallery.MenuHelper.MenuInvoker r1, android.os.Handler r2, android.app.Activity r3) {
        r0 = onShowMapClicked(r1, r2, r3);
        return r0;
    }

    static /* synthetic */ boolean access$1200(com.techno.gallery.MenuHelper.MenuInvoker r1, android.app.Activity r2) {
        r0 = onViewPlayClicked(r1, r2);
        return r0;
    }

    static /* synthetic */ void access$1300(android.app.Activity r0, java.lang.String r1) {
        startCameraActivity(r0, r1);
        return;
    }

    static /* synthetic */ boolean access$1400(android.app.Activity r1) {
        r0 = onCapturePictureClicked(r1);
        return r0;
    }

    static /* synthetic */ boolean access$1500(android.app.Activity r1) {
        r0 = onCaptureVideoClicked(r1);
        return r0;
    }

    static /* synthetic */ java.util.HashMap access$200(com.techno.gallery.gallery.IImage r1) {
        r0 = getExifData(r1);
        return r0;
    }

    static /* synthetic */ void access$300(com.techno.gallery.gallery.IImage r0, android.view.View r1, android.app.Activity r2) {
        showExifInformation(r0, r1, r2);
        return;
    }

    static /* synthetic */ void access$400(android.view.View r0) {
        hideExifInformation(r0);
        return;
    }

    static /* synthetic */ boolean access$500(com.techno.gallery.MenuHelper.MenuInvoker r1, int r2) {
        r0 = onRotateClicked(r1, r2);
        return r0;
    }

    static /* synthetic */ boolean access$600(com.techno.gallery.MenuHelper.MenuInvoker r1, android.app.Activity r2) {
        r0 = onCropClicked(r1, r2);
        return r0;
    }

    static /* synthetic */ boolean access$700(com.techno.gallery.MenuHelper.MenuInvoker r1, android.app.Activity r2) {
        r0 = onSetAsClicked(r1, r2);
        return r0;
    }

    static /* synthetic */ boolean access$800(com.techno.gallery.MenuHelper.MenuInvoker r1, android.app.Activity r2) {
        r0 = onImageShareClicked(r1, r2);
        return r0;
    }

    static /* synthetic */ boolean access$900(com.techno.gallery.MenuHelper.MenuInvoker r1, android.app.Activity r2, java.lang.Runnable r3) {
        r0 = onDeleteClicked(r1, r2, r3);
        return r0;
    }

    public static void addCaptureMenuItems(android.view.Menu r0, android.app.Activity r1) {
        addCapturePictureMenuItems(r0, r1);
        addCaptureVideoMenuItems(r0, r1);
        return;
    }

    static void addCapturePictureMenuItems(android.view.Menu r3, android.app.Activity r4) {
        r2 = 1;
        r0 = 0;
        r1 = 2131296286; // 0x7f09001e float:1.8210484E38 double:1.053000276E-314;
        r0 = r3.add(r0, r2, r2, r1);
        r1 = new com.techno.gallery.MenuHelper$21;
        r1.<init>(r4);
        r0 = r0.setOnMenuItemClickListener(r1);
        r1 = 17301559; // 0x1080037 float:2.497941E-38 double:8.548106E-317;
        r0.setIcon(r1);
        return;
    }

    static void addCaptureVideoMenuItems(android.view.Menu r3, android.app.Activity r4) {
        r2 = 2;
        r0 = 0;
        r1 = 2131296287; // 0x7f09001f float:1.8210486E38 double:1.0530002765E-314;
        r0 = r3.add(r0, r2, r2, r1);
        r1 = new com.techno.gallery.MenuHelper$22;
        r1.<init>(r4);
        r0 = r0.setOnMenuItemClickListener(r1);
        r1 = 2130837594; // 0x7f02005a float:1.7280146E38 double:1.052773652E-314;
        r0.setIcon(r1);
        return;
    }

    static com.techno.gallery.MenuHelper.MenuItemsResult addImageMenuItems(android.view.Menu r10, int r11, android.app.Activity r12, android.os.Handler r13, java.lang.Runnable r14, com.techno.gallery.MenuHelper.MenuInvoker r15) {
        r4 = new java.util.ArrayList;
        r4.<init>();
        r2 = new java.util.ArrayList;
        r2.<init>();
        r1 = new java.util.ArrayList;
        r1.<init>();
        r3 = new java.util.ArrayList;
        r3.<init>();
        r0 = r11 & 32;
        if (r0 == 0) goto L_0x007b;
    L_0x0018:
        r0 = 2;
        r5 = 19;
        r6 = 40;
        r7 = 2131296281; // 0x7f090019 float:1.8210474E38 double:1.0530002736E-314;
        r0 = r10.addSubMenu(r0, r5, r6, r7);
        r5 = 17301581; // 0x108004d float:2.497947E-38 double:8.548117E-317;
        r6 = r0.setIcon(r5);
        r0 = 0;
        r5 = 20;
        r7 = 50;
        r8 = 2131296282; // 0x7f09001a float:1.8210476E38 double:1.053000274E-314;
        r0 = r6.add(r0, r5, r7, r8);
        r5 = new com.techno.gallery.MenuHelper$9;
        r5.<init>(r15);
        r0 = r0.setOnMenuItemClickListener(r5);
        r5 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        r0 = r0.setAlphabeticShortcut(r5);
        r5 = 0;
        r7 = 21;
        r8 = 60;
        r9 = 2131296283; // 0x7f09001b float:1.8210478E38 double:1.0530002745E-314;
        r5 = r6.add(r5, r7, r8, r9);
        r7 = new com.techno.gallery.MenuHelper$10;
        r7.<init>(r15);
        r5 = r5.setOnMenuItemClickListener(r7);
        r7 = 114; // 0x72 float:1.6E-43 double:5.63E-322;
        r5 = r5.setAlphabeticShortcut(r7);
        r7 = r6.getItem();
        r4.add(r7);
        r4.add(r0);
        r4.add(r5);
        r6 = r6.getItem();
        r1.add(r6);
        r1.add(r0);
        r1.add(r5);
    L_0x007b:
        r0 = r11 & 8;
        if (r0 == 0) goto L_0x009f;
    L_0x007f:
        r0 = 2;
        r5 = 18;
        r6 = 73;
        r7 = 2131296309; // 0x7f090035 float:1.8210531E38 double:1.0530002874E-314;
        r0 = r10.add(r0, r5, r6, r7);
        r5 = 17301562; // 0x108003a float:2.4979418E-38 double:8.5481074E-317;
        r0.setIcon(r5);
        r5 = new com.techno.gallery.MenuHelper$11;
        r5.<init>(r15, r12);
        r0.setOnMenuItemClickListener(r5);
        r4.add(r0);
        r1.add(r0);
    L_0x009f:
        r0 = r11 & 4;
        if (r0 == 0) goto L_0x00c0;
    L_0x00a3:
        r0 = 2;
        r5 = 14;
        r6 = 75;
        r7 = 2131296305; // 0x7f090031 float:1.8210523E38 double:1.0530002854E-314;
        r0 = r10.add(r0, r5, r6, r7);
        r5 = 17301585; // 0x1080051 float:2.4979482E-38 double:8.548119E-317;
        r0.setIcon(r5);
        r5 = new com.techno.gallery.MenuHelper$12;
        r5.<init>(r15, r12);
        r0.setOnMenuItemClickListener(r5);
        r1.add(r0);
    L_0x00c0:
        r0 = r11 & 2;
        if (r0 == 0) goto L_0x00e3;
    L_0x00c4:
        r0 = 2;
        r5 = 10;
        r6 = 10;
        r7 = 2131296304; // 0x7f090030 float:1.821052E38 double:1.053000285E-314;
        r0 = r10.add(r0, r5, r6, r7);
        r5 = new com.techno.gallery.MenuHelper$13;
        r5.<init>(r15, r12);
        r0 = r0.setOnMenuItemClickListener(r5);
        r5 = 17301586; // 0x1080052 float:2.4979485E-38 double:8.5481193E-317;
        r0.setIcon(r5);
        r0 = r0;
        r2.add(r0);
    L_0x00e3:
        r0 = r11 & 16;
        if (r0 == 0) goto L_0x010b;
    L_0x00e7:
        r0 = 2;
        r5 = 22;
        r6 = 70;
        r7 = 2131296302; // 0x7f09002e float:1.8210517E38 double:1.053000284E-314;
        r0 = r10.add(r0, r5, r6, r7);
        r4.add(r0);
        r5 = new com.techno.gallery.MenuHelper$14;
        r5.<init>(r15, r12, r14);
        r14 = r0.setOnMenuItemClickListener(r5);
        r0 = 100;
        r14 = r14.setAlphabeticShortcut(r0);
        r0 = 17301564; // 0x108003c float:2.4979423E-38 double:8.5481084E-317;
        r14.setIcon(r0);
    L_0x010b:
        r14 = r11 & 64;
        if (r14 == 0) goto L_0x0129;
    L_0x010f:
        r14 = 0;
        r0 = 0;
        r5 = 80;
        r6 = 2131296279; // 0x7f090017 float:1.821047E38 double:1.0530002726E-314;
        r14 = r10.add(r14, r0, r5, r6);
        r0 = new com.techno.gallery.MenuHelper$15;
        r0.<init>(r15, r13, r12);
        r14 = r14.setOnMenuItemClickListener(r0);
        r0 = 2130837601; // 0x7f020061 float:1.728016E38 double:1.0527736555E-314;
        r14.setIcon(r0);
    L_0x0129:
        r14 = r11 & 128;
        if (r14 == 0) goto L_0x014b;
    L_0x012d:
        r14 = 0;
        r0 = 0;
        r5 = 80;
        r6 = 2131296280; // 0x7f090018 float:1.8210472E38 double:1.053000273E-314;
        r14 = r10.add(r14, r0, r5, r6);
        r0 = new com.techno.gallery.MenuHelper$16;
        r0.<init>(r15, r13, r12);
        r13 = r14.setOnMenuItemClickListener(r0);
        r14 = 2130837591; // 0x7f020057 float:1.728014E38 double:1.0527736506E-314;
        r13 = r13.setIcon(r14);
        r1.add(r13);
    L_0x014b:
        r11 = r11 & 1;
        if (r11 == 0) goto L_0x016c;
    L_0x014f:
        r11 = 3;
        r13 = 23;
        r14 = 0;
        r0 = 2131296312; // 0x7f090038 float:1.8210537E38 double:1.053000289E-314;
        r10 = r10.add(r11, r13, r14, r0);
        r11 = new com.techno.gallery.MenuHelper$17;
        r11.<init>(r15, r12);
        r10 = r10.setOnMenuItemClickListener(r11);
        r11 = 17301906; // 0x1080192 float:2.4980382E-38 double:8.5482774E-317;
        r10.setIcon(r11);
        r3.add(r10);
    L_0x016c:
        r10 = new com.techno.gallery.MenuHelper$18;
        r10.<init>(r4, r2, r1, r3);
        return r10;
    }

    static void addSwitchModeMenuItem(android.view.Menu r7, android.app.Activity r8, boolean r9) {
        r6 = 0;
        if (r9 == 0) goto L_0x0027;
    L_0x0003:
        r5 = 4;
        r1 = r5;
    L_0x0005:
        if (r9 == 0) goto L_0x002a;
    L_0x0007:
        r5 = 2131296265; // 0x7f090009 float:1.8210442E38 double:1.0530002656E-314;
        r4 = r5;
    L_0x000b:
        if (r9 == 0) goto L_0x002f;
    L_0x000d:
        r5 = 2130837594; // 0x7f02005a float:1.7280146E38 double:1.052773652E-314;
        r2 = r5;
    L_0x0011:
        if (r9 == 0) goto L_0x0034;
    L_0x0013:
        r5 = "android.media.action.VIDEO_CAMERA";
        r0 = r5;
    L_0x0016:
        r5 = r7.add(r1, r6, r6, r4);
        r6 = new com.techno.gallery.MenuHelper$20;
        r6.<init>(r8, r0);
        r3 = r5.setOnMenuItemClickListener(r6);
        r3.setIcon(r2);
        return;
    L_0x0027:
        r5 = 5;
        r1 = r5;
        goto L_0x0005;
    L_0x002a:
        r5 = 2131296266; // 0x7f09000a float:1.8210444E38 double:1.053000266E-314;
        r4 = r5;
        goto L_0x000b;
    L_0x002f:
        r5 = 17301559; // 0x1080037 float:2.497941E-38 double:8.548106E-317;
        r2 = r5;
        goto L_0x0011;
    L_0x0034:
        r5 = "android.media.action.STILL_IMAGE_CAMERA";
        r0 = r5;
        goto L_0x0016;
    }

    public static int calculatePicturesRemaining() {
        r4 = com.techno.gallery.ImageManager.hasStorage();	 Catch:{ Exception -> 0x0027 }
        if (r4 != 0) goto L_0x0008;
    L_0x0006:
        r4 = -1;
    L_0x0007:
        return r4;
    L_0x0008:
        r4 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x0027 }
        r3 = r4.toString();	 Catch:{ Exception -> 0x0027 }
        r2 = new android.os.StatFs;	 Catch:{ Exception -> 0x0027 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0027 }
        r4 = r2.getAvailableBlocks();	 Catch:{ Exception -> 0x0027 }
        r4 = (float) r4;	 Catch:{ Exception -> 0x0027 }
        r5 = r2.getBlockSize();	 Catch:{ Exception -> 0x0027 }
        r5 = (float) r5;
        r4 = r4 * r5;
        r5 = 1220759552; // 0x48c35000 float:400000.0 double:6.031353565E-315;
        r1 = r4 / r5;
        r4 = (int) r1;
        goto L_0x0007;
    L_0x0027:
        r4 = move-exception;
        r0 = r4;
        r4 = -2;
        goto L_0x0007;
    }

    public static void closeSilently(java.io.Closeable r1) {
        if (r1 == 0) goto L_0x0005;
    L_0x0002:
        r1.close();	 Catch:{ Throwable -> 0x0006 }
    L_0x0005:
        return;
    L_0x0006:
        r0 = move-exception;
        goto L_0x0005;
    }

    public static void confirmAction(android.content.Context r3, java.lang.String r4, java.lang.String r5, java.lang.Runnable r6) {
        r0 = new com.techno.gallery.MenuHelper$19;
        r0.<init>(r6);
        r1 = new android.app.AlertDialog$Builder;
        r1.<init>(r3);
        r2 = 17301543; // 0x1080027 float:2.4979364E-38 double:8.548098E-317;
        r1 = r1.setIcon(r2);
        r1 = r1.setTitle(r4);
        r1 = r1.setMessage(r5);
        r2 = 17039370; // 0x104000a float:2.42446E-38 double:8.4185673E-317;
        r1 = r1.setPositiveButton(r2, r0);
        r2 = 17039360; // 0x1040000 float:2.424457E-38 double:8.4185624E-317;
        r1 = r1.setNegativeButton(r2, r0);
        r1 = r1.create();
        r1.show();
        return;
    }

    static void deleteImage(android.app.Activity r1, java.lang.Runnable r2, com.techno.gallery.gallery.IImage r3) {
        r0 = com.techno.gallery.ImageManager.isImage(r3);
        deleteImpl(r1, r2, r0);
        return;
    }

    static void deleteImpl(android.app.Activity r6, java.lang.Runnable r7, boolean r8) {
        r3 = android.preference.PreferenceManager.getDefaultSharedPreferences(r6);
        r4 = "pref_gallery_confirm_delete_key";
        r5 = 1;
        r1 = r3.getBoolean(r4, r5);
        if (r1 != 0) goto L_0x0013;
    L_0x000d:
        if (r7 == 0) goto L_0x0012;
    L_0x000f:
        r7.run();
    L_0x0012:
        return;
    L_0x0013:
        r3 = 2131296290; // 0x7f090022 float:1.8210493E38 double:1.053000278E-314;
        r2 = r6.getString(r3);
        if (r8 == 0) goto L_0x0027;
    L_0x001c:
        r3 = 2131296291; // 0x7f090023 float:1.8210495E38 double:1.0530002785E-314;
    L_0x001f:
        r0 = r6.getString(r3);
        confirmAction(r6, r2, r0, r7);
        goto L_0x0012;
    L_0x0027:
        r3 = 2131296292; // 0x7f090024 float:1.8210497E38 double:1.053000279E-314;
        goto L_0x001f;
    }

    public static void deleteMultiple(android.content.Context r6, java.lang.Runnable r7) {
        r3 = android.preference.PreferenceManager.getDefaultSharedPreferences(r6);
        r4 = "pref_gallery_confirm_delete_key";
        r5 = 1;
        r1 = r3.getBoolean(r4, r5);
        if (r1 != 0) goto L_0x0013;
    L_0x000d:
        if (r7 == 0) goto L_0x0012;
    L_0x000f:
        r7.run();
    L_0x0012:
        return;
    L_0x0013:
        r3 = 2131296290; // 0x7f090022 float:1.8210493E38 double:1.053000278E-314;
        r2 = r6.getString(r3);
        r3 = 2131296293; // 0x7f090025 float:1.8210499E38 double:1.0530002795E-314;
        r0 = r6.getString(r3);
        confirmAction(r6, r2, r0, r7);
        goto L_0x0012;
    }

    static void deletePhoto(android.app.Activity r1, java.lang.Runnable r2) {
        r0 = 1;
        deleteImpl(r1, r2, r0);
        return;
    }

    static void deleteVideo(android.app.Activity r1, java.lang.Runnable r2) {
        r0 = 0;
        deleteImpl(r1, r2, r0);
        return;
    }

    public static void enableShareMenuItem(android.view.Menu r2, boolean r3) {
        r1 = 10;
        r0 = r2.findItem(r1);
        if (r0 == 0) goto L_0x000e;
    L_0x0008:
        r0.setVisible(r3);
        r0.setEnabled(r3);
    L_0x000e:
        return;
    }

    public static java.lang.String formatDuration(android.content.Context r11, int r12) {
        r10 = 2;
        r9 = 1;
        r8 = 0;
        r0 = r12 / 1000;
        r2 = r0 / 3600;
        r5 = r2 * 3600;
        r5 = r0 - r5;
        r3 = r5 / 60;
        r5 = r2 * 3600;
        r6 = r3 * 60;
        r5 = r5 + r6;
        r4 = r0 - r5;
        if (r2 != 0) goto L_0x0030;
    L_0x0016:
        r5 = 2131296405; // 0x7f090095 float:1.8210726E38 double:1.053000335E-314;
        r5 = r11.getString(r5);
        r6 = new java.lang.Object[r10];
        r7 = java.lang.Integer.valueOf(r3);
        r6[r8] = r7;
        r7 = java.lang.Integer.valueOf(r4);
        r6[r9] = r7;
        r1 = java.lang.String.format(r5, r6);
    L_0x002f:
        return r1;
    L_0x0030:
        r5 = 2131296406; // 0x7f090096 float:1.8210728E38 double:1.0530003353E-314;
        r5 = r11.getString(r5);
        r6 = 3;
        r6 = new java.lang.Object[r6];
        r7 = java.lang.Integer.valueOf(r2);
        r6[r8] = r7;
        r7 = java.lang.Integer.valueOf(r3);
        r6[r9] = r7;
        r7 = java.lang.Integer.valueOf(r4);
        r6[r10] = r7;
        r1 = java.lang.String.format(r5, r6);
        goto L_0x002f;
    }

    private static java.util.HashMap<java.lang.String, java.lang.String> getExifData(com.techno.gallery.gallery.IImage r2) {
        r0 = "image/jpeg";
        r1 = r2.getMimeType();
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x000e;
    L_0x000c:
        r0 = 0;
    L_0x000d:
        return r0;
    L_0x000e:
        r0 = r2.getDataPath();
        r0 = android.media.ExifInterface.loadExifData(r0);
        goto L_0x000d;
    }

    public static long getImageFileSize(com.techno.gallery.gallery.IImage r4) {
        r2 = -1;
        r0 = r4.fullSizeImageData();
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return r2;
    L_0x0009:
        r2 = r0.available();	 Catch:{ IOException -> 0x0012, all -> 0x0017 }
        r2 = (long) r2;
        closeSilently(r0);
        goto L_0x0008;
    L_0x0012:
        r1 = move-exception;
        closeSilently(r0);
        goto L_0x0008;
    L_0x0017:
        r2 = move-exception;
        closeSilently(r0);
        throw r2;
    }

    public static void gotoCameraImageGallery(android.app.Activity r2) {
        r0 = 2131296262; // 0x7f090006 float:1.8210436E38 double:1.053000264E-314;
        r1 = 1;
        gotoGallery(r2, r0, r1);
        return;
    }

    public static void gotoCameraMode(android.app.Activity r1) {
        r0 = "android.media.action.STILL_IMAGE_CAMERA";
        startCameraActivity(r1, r0);
        return;
    }

    public static void gotoCameraVideoGallery(android.app.Activity r2) {
        r0 = 2131296263; // 0x7f090007 float:1.8210438E38 double:1.0530002647E-314;
        r1 = 4;
        gotoGallery(r2, r0, r1);
        return;
    }

    private static void gotoGallery(android.app.Activity r6, int r7, int r8) {
        r3 = android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        r3 = r3.buildUpon();
        r4 = "bucketId";
        r5 = com.techno.gallery.ImageManager.CAMERA_IMAGE_BUCKET_ID;
        r3 = r3.appendQueryParameter(r4, r5);
        r2 = r3.build();
        r1 = new android.content.Intent;
        r3 = "android.intent.action.VIEW";
        r1.<init>(r3, r2);
        r3 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.3156184E-316;
        r1.addFlags(r3);
        r3 = "windowTitle";
        r4 = r6.getString(r7);
        r1.putExtra(r3, r4);
        r3 = "mediaTypes";
        r1.putExtra(r3, r8);
        r6.startActivity(r1);	 Catch:{ ActivityNotFoundException -> 0x0030 }
    L_0x002f:
        return;
    L_0x0030:
        r0 = move-exception;
        r3 = "MenuHelper";
        r4 = "Could not start gallery activity";
        android.util.Log.e(r3, r4, r0);
        goto L_0x002f;
    }

    public static void gotoVideoMode(android.app.Activity r1) {
        r0 = "android.media.action.VIDEO_CAMERA";
        startCameraActivity(r1, r0);
        return;
    }

    private static void hideDetailsRow(android.view.View r2, int r3) {
        r0 = r2.findViewById(r3);
        r1 = 8;
        r0.setVisibility(r1);
        return;
    }

    private static void hideExifInformation(android.view.View r1) {
        r0 = 2131427363; // 0x7f0b0023 float:1.847634E38 double:1.0530650367E-314;
        hideDetailsRow(r1, r0);
        r0 = 2131427365; // 0x7f0b0025 float:1.8476344E38 double:1.0530650377E-314;
        hideDetailsRow(r1, r0);
        r0 = 2131427367; // 0x7f0b0027 float:1.8476348E38 double:1.0530650386E-314;
        hideDetailsRow(r1, r0);
        r0 = 2131427369; // 0x7f0b0029 float:1.8476352E38 double:1.0530650396E-314;
        hideDetailsRow(r1, r0);
        r0 = 2131427371; // 0x7f0b002b float:1.8476356E38 double:1.0530650406E-314;
        hideDetailsRow(r1, r0);
        r0 = 2131427373; // 0x7f0b002d float:1.847636E38 double:1.0530650416E-314;
        hideDetailsRow(r1, r0);
        r0 = 2131427375; // 0x7f0b002f float:1.8476364E38 double:1.0530650426E-314;
        hideDetailsRow(r1, r0);
        return;
    }

    public static boolean isWhiteListUri(android.net.Uri r6) {
        r5 = 1;
        r4 = 0;
        if (r6 != 0) goto L_0x0006;
    L_0x0004:
        r3 = r4;
    L_0x0005:
        return r3;
    L_0x0006:
        r2 = r6.getScheme();
        r0 = r6.getAuthority();
        r3 = "content";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x0020;
    L_0x0016:
        r3 = "media";
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x0020;
    L_0x001e:
        r3 = r5;
        goto L_0x0005;
    L_0x0020:
        r3 = "file";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x0042;
    L_0x0028:
        r1 = r6.getPathSegments();
        r3 = r1.size();
        if (r3 < r5) goto L_0x0042;
    L_0x0032:
        r6 = r1.get(r4);
        r6 = (java.lang.String) r6;
        r3 = "sdcard";
        r3 = r6.equals(r3);
        if (r3 == 0) goto L_0x0042;
    L_0x0040:
        r3 = r5;
        goto L_0x0005;
    L_0x0042:
        r3 = r4;
        goto L_0x0005;
    }

    private static boolean onCapturePictureClicked(android.app.Activity r2) {
        r0 = new android.content.Intent;
        r1 = "android.media.action.STILL_IMAGE_CAMERA";
        r0.<init>(r1);
        r1 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.3156184E-316;
        r0.addFlags(r1);
        r2.startActivity(r0);	 Catch:{ ActivityNotFoundException -> 0x0011 }
    L_0x000f:
        r1 = 1;
        return r1;
    L_0x0011:
        r1 = move-exception;
        goto L_0x000f;
    }

    private static boolean onCaptureVideoClicked(android.app.Activity r2) {
        r0 = new android.content.Intent;
        r1 = "android.media.action.VIDEO_CAMERA";
        r0.<init>(r1);
        r1 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.3156184E-316;
        r0.addFlags(r1);
        r2.startActivity(r0);	 Catch:{ ActivityNotFoundException -> 0x0011 }
    L_0x000f:
        r1 = 1;
        return r1;
    L_0x0011:
        r1 = move-exception;
        goto L_0x000f;
    }

    private static boolean onCropClicked(com.techno.gallery.MenuHelper.MenuInvoker r1, android.app.Activity r2) {
        r0 = new com.techno.gallery.MenuHelper$4;
        r0.<init>(r2);
        r1.run(r0);
        r0 = 1;
        return r0;
    }

    private static boolean onDeleteClicked(com.techno.gallery.MenuHelper.MenuInvoker r1, android.app.Activity r2, java.lang.Runnable r3) {
        r0 = new com.techno.gallery.MenuHelper$8;
        r0.<init>(r2, r3);
        r1.run(r0);
        r0 = 1;
        return r0;
    }

    private static boolean onDetailsClicked(com.techno.gallery.MenuHelper.MenuInvoker r1, android.os.Handler r2, android.app.Activity r3) {
        r0 = new com.techno.gallery.MenuHelper$2;
        r0.<init>(r3, r2);
        r1.run(r0);
        r0 = 1;
        return r0;
    }

    private static boolean onImageShareClicked(com.techno.gallery.MenuHelper.MenuInvoker r1, android.app.Activity r2) {
        r0 = new com.techno.gallery.MenuHelper$6;
        r0.<init>(r2);
        r1.run(r0);
        r0 = 1;
        return r0;
    }

    private static boolean onRotateClicked(com.techno.gallery.MenuHelper.MenuInvoker r1, int r2) {
        r0 = new com.techno.gallery.MenuHelper$3;
        r0.<init>(r2);
        r1.run(r0);
        r0 = 1;
        return r0;
    }

    private static boolean onSetAsClicked(com.techno.gallery.MenuHelper.MenuInvoker r1, android.app.Activity r2) {
        r0 = new com.techno.gallery.MenuHelper$5;
        r0.<init>(r2);
        r1.run(r0);
        r0 = 1;
        return r0;
    }

    private static boolean onShowMapClicked(com.techno.gallery.MenuHelper.MenuInvoker r1, android.os.Handler r2, android.app.Activity r3) {
        r0 = new com.techno.gallery.MenuHelper$1;
        r0.<init>(r2, r3);
        r1.run(r0);
        r0 = 1;
        return r0;
    }

    private static boolean onViewPlayClicked(com.techno.gallery.MenuHelper.MenuInvoker r1, android.app.Activity r2) {
        r0 = new com.techno.gallery.MenuHelper$7;
        r0.<init>(r2);
        r1.run(r0);
        r0 = 1;
        return r0;
    }

    private static void setDetailsValue(android.view.View r0, java.lang.String r1, int r2) {
        r0 = r0.findViewById(r2);
        r0 = (android.widget.TextView) r0;
        r0.setText(r1);
        return;
    }

    private static void setLatLngDetails(android.view.View r10, android.app.Activity r11, java.util.HashMap<java.lang.String, java.lang.String> r12) {
        r9 = 2131427373; // 0x7f0b002d float:1.847636E38 double:1.0530650416E-314;
        r8 = 2131427371; // 0x7f0b002b float:1.8476356E38 double:1.0530650406E-314;
        r7 = 1;
        r6 = 1132396544; // 0x437f0000 float:255.0 double:5.5947823E-315;
        r5 = 0;
        r2 = android.media.ExifInterface.getLatLng(r12);
        if (r2 == 0) goto L_0x005b;
    L_0x0010:
        r3 = r2[r5];
        r3 = java.lang.String.valueOf(r3);
        r4 = 2131427372; // 0x7f0b002c float:1.8476358E38 double:1.053065041E-314;
        setDetailsValue(r10, r3, r4);
        r3 = r2[r7];
        r3 = java.lang.String.valueOf(r3);
        r4 = 2131427374; // 0x7f0b002e float:1.8476362E38 double:1.053065042E-314;
        setDetailsValue(r10, r3, r4);
        r3 = r2[r5];
        r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r3 == 0) goto L_0x0034;
    L_0x002e:
        r3 = r2[r7];
        r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r3 != 0) goto L_0x0041;
    L_0x0034:
        hideDetailsRow(r10, r8);
        hideDetailsRow(r10, r9);
        r3 = 2131427375; // 0x7f0b002f float:1.8476364E38 double:1.0530650426E-314;
        hideDetailsRow(r10, r3);
    L_0x0040:
        return;
    L_0x0041:
        r0 = new com.techno.gallery.MenuHelper$UpdateLocationCallback;
        r3 = new java.lang.ref.WeakReference;
        r3.<init>(r10);
        r0.<init>(r3);
        r1 = new android.location.Geocoder;
        r1.<init>(r11);
        r3 = new com.techno.gallery.ReverseGeocoderTask;
        r3.<init>(r1, r2, r0);
        r4 = new java.lang.Void[r5];
        r3.execute(r4);
        goto L_0x0040;
    L_0x005b:
        hideDetailsRow(r10, r8);
        hideDetailsRow(r10, r9);
        r3 = 2131427375; // 0x7f0b002f float:1.8476364E38 double:1.0530650426E-314;
        hideDetailsRow(r10, r3);
        goto L_0x0040;
    }

    private static void showExifInformation(com.techno.gallery.gallery.IImage r3, android.view.View r4, android.app.Activity r5) {
        r0 = getExifData(r3);
        if (r0 != 0) goto L_0x000a;
    L_0x0006:
        hideExifInformation(r4);
    L_0x0009:
        return;
    L_0x000a:
        r2 = "Make";
        r1 = r0.get(r2);
        r1 = (java.lang.String) r1;
        if (r1 == 0) goto L_0x004c;
    L_0x0014:
        r2 = 2131427366; // 0x7f0b0026 float:1.8476346E38 double:1.053065038E-314;
        setDetailsValue(r4, r1, r2);
    L_0x001a:
        r2 = "Model";
        r1 = r0.get(r2);
        r1 = (java.lang.String) r1;
        if (r1 == 0) goto L_0x0053;
    L_0x0024:
        r2 = 2131427368; // 0x7f0b0028 float:1.847635E38 double:1.053065039E-314;
        setDetailsValue(r4, r1, r2);
    L_0x002a:
        r2 = "WhiteBalance";
        r1 = r0.get(r2);
        r1 = (java.lang.String) r1;
        if (r1 == 0) goto L_0x003c;
    L_0x0034:
        r2 = java.lang.Integer.parseInt(r1);
        r1 = android.media.ExifInterface.whiteBalanceToString(r2);
    L_0x003c:
        if (r1 == 0) goto L_0x005a;
    L_0x003e:
        r2 = "";
        if (r1 == r2) goto L_0x005a;
    L_0x0042:
        r2 = 2131427370; // 0x7f0b002a float:1.8476354E38 double:1.05306504E-314;
        setDetailsValue(r4, r1, r2);
    L_0x0048:
        setLatLngDetails(r4, r5, r0);
        goto L_0x0009;
    L_0x004c:
        r2 = 2131427365; // 0x7f0b0025 float:1.8476344E38 double:1.0530650377E-314;
        hideDetailsRow(r4, r2);
        goto L_0x001a;
    L_0x0053:
        r2 = 2131427367; // 0x7f0b0027 float:1.8476348E38 double:1.0530650386E-314;
        hideDetailsRow(r4, r2);
        goto L_0x002a;
    L_0x005a:
        r2 = 2131427369; // 0x7f0b0029 float:1.8476352E38 double:1.0530650396E-314;
        hideDetailsRow(r4, r2);
        goto L_0x0048;
    }

    public static void showStorageToast(android.app.Activity r1) {
        r0 = calculatePicturesRemaining();
        showStorageToast(r1, r0);
        return;
    }

    public static void showStorageToast(android.app.Activity r3, int r4) {
        r0 = 0;
        r2 = -1;
        if (r4 != r2) goto L_0x0027;
    L_0x0004:
        r1 = android.os.Environment.getExternalStorageState();
        r2 = "checking";
        if (r1 != r2) goto L_0x001f;
    L_0x000c:
        r2 = 2131296273; // 0x7f090011 float:1.8210458E38 double:1.0530002696E-314;
        r0 = r3.getString(r2);
    L_0x0013:
        if (r0 == 0) goto L_0x001e;
    L_0x0015:
        r2 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r2 = android.widget.Toast.makeText(r3, r0, r2);
        r2.show();
    L_0x001e:
        return;
    L_0x001f:
        r2 = 2131296271; // 0x7f09000f float:1.8210454E38 double:1.0530002686E-314;
        r0 = r3.getString(r2);
        goto L_0x0013;
    L_0x0027:
        r2 = 1;
        if (r4 >= r2) goto L_0x0013;
    L_0x002a:
        r2 = 2131296272; // 0x7f090010 float:1.8210456E38 double:1.053000269E-314;
        r0 = r3.getString(r2);
        goto L_0x0013;
    }

    private static void startCameraActivity(android.app.Activity r2, java.lang.String r3) {
        r0 = new android.content.Intent;
        r0.<init>(r3);
        r1 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.3156184E-316;
        r0.addFlags(r1);
        r1 = 33554432; // 0x2000000 float:9.403955E-38 double:1.6578092E-316;
        r0.addFlags(r1);
        r1 = com.techno.gallery.CameraHolder.instance();
        r1.keep();
        r2.startActivity(r0);
        return;
    }
}