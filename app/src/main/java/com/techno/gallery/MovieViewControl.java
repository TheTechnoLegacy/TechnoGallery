package com.techno.gallery;

public class MovieViewControl implements android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnCompletionListener {
    private static final java.lang.String CMDNAME = "command";
    private static final java.lang.String CMDPAUSE = "pause";
    private static final int FIVE_MINUTES = 300000;
    private static final int ONE_MINUTE = 60000;
    private static final java.lang.String SERVICECMD = "com.android.music.musicservicecommand";
    private static final java.lang.String TAG = "MovieViewControl";
    private static final int TWO_MINUTES = 120000;
    private final android.content.ContentResolver mContentResolver;
    android.os.Handler mHandler;
    java.lang.Runnable mPlayingChecker;
    private int mPositionWhenPaused;
    private final android.view.View mProgressView;
    private final android.net.Uri mUri;
    private final android.widget.VideoView mVideoView;
    private boolean mWasPlayingWhenPaused;

    public MovieViewControl(android.view.View r10, android.content.Context r11, android.net.Uri r12) {
        r9 = this;
        r8 = 0;
        r9.<init>();
        r4 = -1;
        r9.mPositionWhenPaused = r4;
        r9.mWasPlayingWhenPaused = r8;
        r4 = new android.os.Handler;
        r4.<init>();
        r9.mHandler = r4;
        r4 = new com.techno.gallery.MovieViewControl$1;
        r4.<init>(r9);
        r9.mPlayingChecker = r4;
        r4 = r11.getContentResolver();
        r9.mContentResolver = r4;
        r4 = 2131427398; // 0x7f0b0046 float:1.8476411E38 double:1.053065054E-314;
        r4 = r10.findViewById(r4);
        r4 = (android.widget.VideoView) r4;
        r9.mVideoView = r4;
        r4 = 2131427399; // 0x7f0b0047 float:1.8476413E38 double:1.0530650545E-314;
        r4 = r10.findViewById(r4);
        r9.mProgressView = r4;
        r9.mUri = r12;
        r4 = r9.mUri;
        r3 = r4.getScheme();
        r4 = "http";
        r4 = r4.equalsIgnoreCase(r3);
        if (r4 != 0) goto L_0x0049;
    L_0x0041:
        r4 = "rtsp";
        r4 = r4.equalsIgnoreCase(r3);
        if (r4 == 0) goto L_0x00d1;
    L_0x0049:
        r4 = r9.mHandler;
        r5 = r9.mPlayingChecker;
        r6 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r4.postDelayed(r5, r6);
    L_0x0052:
        r4 = r9.mVideoView;
        r4.setOnErrorListener(r9);
        r4 = r9.mVideoView;
        r4.setOnCompletionListener(r9);
        r4 = r9.mVideoView;
        r5 = r9.mUri;
        r4.setVideoURI(r5);
        r4 = r9.mVideoView;
        r5 = new android.widget.MediaController;
        r5.<init>(r11);
        r4.setMediaController(r5);
        r4 = r9.mVideoView;
        r4.requestFocus();
        r2 = new android.content.Intent;
        r4 = "com.android.music.musicservicecommand";
        r2.<init>(r4);
        r4 = "command";
        r5 = "pause";
        r2.putExtra(r4, r5);
        r11.sendBroadcast(r2);
        r0 = r9.getBookmark();
        if (r0 == 0) goto L_0x00da;
    L_0x0089:
        r1 = new android.app.AlertDialog$Builder;
        r1.<init>(r11);
        r4 = 2131296425; // 0x7f0900a9 float:1.8210766E38 double:1.0530003447E-314;
        r1.setTitle(r4);
        r4 = 2131296426; // 0x7f0900aa float:1.8210768E38 double:1.053000345E-314;
        r4 = r11.getString(r4);
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = r0.intValue();
        r6 = com.techno.gallery.MenuHelper.formatDuration(r11, r6);
        r5[r8] = r6;
        r4 = java.lang.String.format(r4, r5);
        r1.setMessage(r4);
        r4 = new com.techno.gallery.MovieViewControl$2;
        r4.<init>(r9);
        r1.setOnCancelListener(r4);
        r4 = 2131296427; // 0x7f0900ab float:1.821077E38 double:1.0530003457E-314;
        r5 = new com.techno.gallery.MovieViewControl$3;
        r5.<init>(r9, r0);
        r1.setPositiveButton(r4, r5);
        r4 = 2131296428; // 0x7f0900ac float:1.8210772E38 double:1.053000346E-314;
        r5 = new com.techno.gallery.MovieViewControl$4;
        r5.<init>(r9);
        r1.setNegativeButton(r4, r5);
        r1.show();
    L_0x00d0:
        return;
    L_0x00d1:
        r4 = r9.mProgressView;
        r5 = 8;
        r4.setVisibility(r5);
        goto L_0x0052;
    L_0x00da:
        r4 = r9.mVideoView;
        r4.start();
        goto L_0x00d0;
    }

    static /* synthetic */ android.widget.VideoView access$000(com.techno.gallery.MovieViewControl r1) {
        r0 = r1.mVideoView;
        return r0;
    }

    static /* synthetic */ android.view.View access$100(com.techno.gallery.MovieViewControl r1) {
        r0 = r1.mProgressView;
        return r0;
    }

    private java.lang.Integer getBookmark() {
        r10 = this;
        r3 = 1;
        r1 = 0;
        r9 = 0;
        r0 = r10.mUri;
        r0 = uriSupportsBookmarks(r0);
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        r0 = r9;
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = 2;
        r2 = new java.lang.String[r0];
        r0 = "duration";
        r2[r1] = r0;
        r0 = "bookmark";
        r2[r3] = r0;
        r0 = r10.mContentResolver;	 Catch:{ SQLiteException -> 0x0053 }
        r1 = r10.mUri;	 Catch:{ SQLiteException -> 0x0053 }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r7 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ SQLiteException -> 0x0053 }
        if (r7 == 0) goto L_0x0054;
    L_0x0025:
        r0 = r7.moveToFirst();	 Catch:{ all -> 0x005a }
        if (r0 == 0) goto L_0x0056;
    L_0x002b:
        r0 = 0;
        r8 = getCursorInteger(r7, r0);	 Catch:{ all -> 0x005a }
        r0 = 1;
        r6 = getCursorInteger(r7, r0);	 Catch:{ all -> 0x005a }
        r0 = 120000; // 0x1d4c0 float:1.68156E-40 double:5.9288E-319;
        if (r6 < r0) goto L_0x0046;
    L_0x003a:
        r0 = 300000; // 0x493e0 float:4.2039E-40 double:1.482197E-318;
        if (r8 < r0) goto L_0x0046;
    L_0x003f:
        r0 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r0 = r8 - r0;
        if (r6 <= r0) goto L_0x004b;
    L_0x0046:
        r7.close();
        r0 = r9;
        goto L_0x000c;
    L_0x004b:
        r0 = java.lang.Integer.valueOf(r6);
        r7.close();
        goto L_0x000c;
    L_0x0053:
        r0 = move-exception;
    L_0x0054:
        r0 = r9;
        goto L_0x000c;
    L_0x0056:
        r7.close();
        goto L_0x0054;
    L_0x005a:
        r0 = move-exception;
        r7.close();
        throw r0;
    }

    private static int getCursorInteger(android.database.Cursor r2, int r3) {
        r1 = 0;
        r1 = r2.getInt(r3);	 Catch:{ SQLiteException -> 0x0006, NumberFormatException -> 0x0008 }
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = move-exception;
        goto L_0x0005;
    L_0x0008:
        r0 = move-exception;
        goto L_0x0005;
    }

    private void setBookmark(int r6) {
        r5 = this;
        r1 = r5.mUri;
        r1 = uriSupportsBookmarks(r1);
        if (r1 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = new android.content.ContentValues;
        r0.<init>();
        r1 = "bookmark";
        r2 = java.lang.Integer.toString(r6);
        r0.put(r1, r2);
        r1 = r5.mContentResolver;	 Catch:{ SecurityException -> 0x0021, SQLiteException -> 0x0025, UnsupportedOperationException -> 0x0023 }
        r2 = r5.mUri;	 Catch:{ SecurityException -> 0x0021, SQLiteException -> 0x0025, UnsupportedOperationException -> 0x0023 }
        r3 = 0;
        r4 = 0;
        r1.update(r2, r0, r3, r4);	 Catch:{ SecurityException -> 0x0021, SQLiteException -> 0x0025, UnsupportedOperationException -> 0x0023 }
        goto L_0x0008;
    L_0x0021:
        r1 = move-exception;
        goto L_0x0008;
    L_0x0023:
        r1 = move-exception;
        goto L_0x0008;
    L_0x0025:
        r1 = move-exception;
        goto L_0x0008;
    }

    private static boolean uriSupportsBookmarks(android.net.Uri r3) {
        r1 = r3.getScheme();
        r0 = r3.getAuthority();
        r2 = "content";
        r2 = r2.equalsIgnoreCase(r1);
        if (r2 == 0) goto L_0x001a;
    L_0x0010:
        r2 = "media";
        r2 = r2.equalsIgnoreCase(r0);
        if (r2 == 0) goto L_0x001a;
    L_0x0018:
        r2 = 1;
    L_0x0019:
        return r2;
    L_0x001a:
        r2 = 0;
        goto L_0x0019;
    }

    public void onCompletion() {
        r0 = this;
        return;
    }

    public void onCompletion(android.media.MediaPlayer r1) {
        r0 = this;
        r0.onCompletion();
        return;
    }

    public boolean onError(android.media.MediaPlayer r3, int r4, int r5) {
        r2 = this;
        r0 = r2.mHandler;
        r1 = 0;
        r0.removeCallbacksAndMessages(r1);
        r0 = r2.mProgressView;
        r1 = 8;
        r0.setVisibility(r1);
        r0 = 0;
        return r0;
    }

    public void onPause() {
        r2 = this;
        r0 = r2.mHandler;
        r1 = 0;
        r0.removeCallbacksAndMessages(r1);
        r0 = r2.mVideoView;
        r0 = r0.getCurrentPosition();
        r2.setBookmark(r0);
        r0 = r2.mVideoView;
        r0 = r0.getCurrentPosition();
        r2.mPositionWhenPaused = r0;
        r0 = r2.mVideoView;
        r0 = r0.isPlaying();
        r2.mWasPlayingWhenPaused = r0;
        r0 = r2.mVideoView;
        r0.stopPlayback();
        return;
    }

    public void onResume() {
        r2 = this;
        r0 = r2.mPositionWhenPaused;
        if (r0 < 0) goto L_0x001b;
    L_0x0004:
        r0 = r2.mVideoView;
        r1 = r2.mUri;
        r0.setVideoURI(r1);
        r0 = r2.mVideoView;
        r1 = r2.mPositionWhenPaused;
        r0.seekTo(r1);
        r0 = r2.mWasPlayingWhenPaused;
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r0 = r2.mVideoView;
        r0.start();
    L_0x001b:
        return;
    }
}