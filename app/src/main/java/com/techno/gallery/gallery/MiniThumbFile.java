package com.techno.gallery.gallery;

class MiniThumbFile {
    public static final int BYTES_PER_MINTHUMB = 10000;
    private static final int HEADER_SIZE = 13;
    private static final int MINI_THUMB_DATA_FILE_VERSION = 3;
    private static final java.lang.String TAG = "MiniThumbFile";
    private java.io.RandomAccessFile mMiniThumbFile;
    private android.net.Uri mUri;

    public MiniThumbFile(android.net.Uri r1) {
        r0 = this;
        r0.<init>();
        r0.mUri = r1;
        return;
    }

    private java.io.RandomAccessFile miniThumbDataFile() {
        r7 = this;
        r4 = r7.mMiniThumbFile;
        if (r4 != 0) goto L_0x004b;
    L_0x0004:
        r7.removeOldFile();
        r4 = 3;
        r3 = r7.randomAccessFilePath(r4);
        r4 = new java.io.File;
        r4.<init>(r3);
        r0 = r4.getParentFile();
        r4 = r0.isDirectory();
        if (r4 != 0) goto L_0x003d;
    L_0x001b:
        r4 = r0.mkdirs();
        if (r4 != 0) goto L_0x003d;
    L_0x0021:
        r4 = "MiniThumbFile";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Unable to create .thumbnails directory ";
        r5 = r5.append(r6);
        r6 = r0.toString();
        r5 = r5.append(r6);
        r5 = r5.toString();
        android.util.Log.e(r4, r5);
    L_0x003d:
        r2 = new java.io.File;
        r2.<init>(r3);
        r4 = new java.io.RandomAccessFile;	 Catch:{ IOException -> 0x004e }
        r5 = "rw";
        r4.<init>(r2, r5);	 Catch:{ IOException -> 0x004e }
        r7.mMiniThumbFile = r4;	 Catch:{ IOException -> 0x004e }
    L_0x004b:
        r4 = r7.mMiniThumbFile;
        return r4;
    L_0x004e:
        r4 = move-exception;
        r1 = r4;
        r4 = new java.io.RandomAccessFile;	 Catch:{ IOException -> 0x005a }
        r5 = "r";
        r4.<init>(r2, r5);	 Catch:{ IOException -> 0x005a }
        r7.mMiniThumbFile = r4;	 Catch:{ IOException -> 0x005a }
        goto L_0x004b;
    L_0x005a:
        r4 = move-exception;
        goto L_0x004b;
    }

    private java.lang.String randomAccessFilePath(int r4) {
        r3 = this;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = android.os.Environment.getExternalStorageDirectory();
        r2 = r2.toString();
        r1 = r1.append(r2);
        r2 = "/DCIM/.thumbnails";
        r1 = r1.append(r2);
        r0 = r1.toString();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r0);
        r2 = "/.thumbdata";
        r1 = r1.append(r2);
        r1 = r1.append(r4);
        r2 = "-";
        r1 = r1.append(r2);
        r2 = r3.mUri;
        r2 = r2.hashCode();
        r1 = r1.append(r2);
        r1 = r1.toString();
        return r1;
    }

    private void removeOldFile() {
        r3 = this;
        r2 = 2;
        r1 = r3.randomAccessFilePath(r2);
        r0 = new java.io.File;
        r0.<init>(r1);
        r2 = r0.exists();
        if (r2 == 0) goto L_0x0013;
    L_0x0010:
        r0.delete();	 Catch:{ SecurityException -> 0x0014 }
    L_0x0013:
        return;
    L_0x0014:
        r2 = move-exception;
        goto L_0x0013;
    }

    public void deactivate() {
        r1 = this;
        r0 = r1.mMiniThumbFile;
        if (r0 == 0) goto L_0x000c;
    L_0x0004:
        r0 = r1.mMiniThumbFile;	 Catch:{ IOException -> 0x000d }
        r0.close();	 Catch:{ IOException -> 0x000d }
        r0 = 0;
        r1.mMiniThumbFile = r0;	 Catch:{ IOException -> 0x000d }
    L_0x000c:
        return;
    L_0x000d:
        r0 = move-exception;
        goto L_0x000c;
    }

    public long getMagic(long r13) {
        r12 = this;
        r5 = r12.miniThumbDataFile();
        if (r5 == 0) goto L_0x0034;
    L_0x0006:
        monitor-enter(r5);
        r6 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r3 = r13 * r6;
        r6 = r5.length();	 Catch:{ IOException -> 0x002a }
        r8 = 1;
        r8 = r8 + r3;
        r10 = 8;
        r8 = r8 + r10;
        r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r6 < 0) goto L_0x0033;
    L_0x0019:
        r5.seek(r3);	 Catch:{ IOException -> 0x002a }
        r6 = r5.readByte();	 Catch:{ IOException -> 0x002a }
        r7 = 1;
        if (r6 != r7) goto L_0x0033;
    L_0x0023:
        r1 = r5.readLong();	 Catch:{ IOException -> 0x002a }
        monitor-exit(r5);	 Catch:{ all -> 0x0037 }
        r6 = r1;
    L_0x0029:
        return r6;
    L_0x002a:
        r6 = move-exception;
        r0 = r6;
        r6 = "MiniThumbFile";
        r7 = "Got exception checking file magic: ";
        android.util.Log.v(r6, r7, r0);	 Catch:{ all -> 0x0037 }
    L_0x0033:
        monitor-exit(r5);	 Catch:{ all -> 0x0037 }
    L_0x0034:
        r6 = 0;
        goto L_0x0029;
    L_0x0037:
        r6 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0037 }
        throw r6;
    }

    byte[] getMiniThumbFromFile(long r11, byte[] r13, long r14) {
        r10 = this;
        r7 = r10.miniThumbDataFile();
        if (r7 != 0) goto L_0x0008;
    L_0x0006:
        r8 = 0;
    L_0x0007:
        return r8;
    L_0x0008:
        r8 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r5 = r11 * r8;
        monitor-enter(r7);
        r7.seek(r5);	 Catch:{ IOException -> 0x0039 }
        r8 = r7.readByte();	 Catch:{ IOException -> 0x0039 }
        r9 = 1;
        if (r8 != r9) goto L_0x0036;
    L_0x0017:
        r3 = r7.readLong();	 Catch:{ IOException -> 0x0039 }
        r8 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1));
        if (r8 == 0) goto L_0x0025;
    L_0x001f:
        r8 = 0;
        monitor-exit(r7);	 Catch:{ all -> 0x0022 }
        goto L_0x0007;
    L_0x0022:
        r8 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x0022 }
        throw r8;
    L_0x0025:
        r2 = r7.readInt();
        r8 = 0;
        r1 = r7.read(r13, r8, r2);
        if (r1 == r2) goto L_0x0033;
    L_0x0030:
        r8 = 0;
        monitor-exit(r7);
        goto L_0x0007;
    L_0x0033:
        monitor-exit(r7);
        r8 = r13;
        goto L_0x0007;
    L_0x0036:
        r8 = 0;
        monitor-exit(r7);
        goto L_0x0007;
    L_0x0039:
        r8 = move-exception;
        r0 = r8;
        r8 = 0;
        monitor-exit(r7);
        goto L_0x0007;
    }

    public void saveMiniThumbToFile(android.graphics.Bitmap r7, long r8, long r10) throws java.io.IOException {
        r6 = this;
        r1 = com.techno.gallery.Util.miniThumbData(r7);
        r0 = r6;
        r2 = r8;
        r4 = r10;
        r0.saveMiniThumbToFile(r1, r2, r4);
        return;
    }

    public void saveMiniThumbToFile(byte[] r8, long r9, long r11) throws java.io.IOException {
        r7 = this;
        r3 = r7.miniThumbDataFile();
        if (r3 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r4 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r1 = r9 * r4;
        monitor-enter(r3);
        if (r8 == 0) goto L_0x0038;
    L_0x000e:
        r4 = r8.length;	 Catch:{ IOException -> 0x003e }
        r5 = 9987; // 0x2703 float:1.3995E-41 double:4.934E-320;
        if (r4 <= r5) goto L_0x0018;
    L_0x0013:
        monitor-exit(r3);	 Catch:{ all -> 0x0015 }
        goto L_0x0006;
    L_0x0015:
        r4 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0015 }
        throw r4;
    L_0x0018:
        r3.seek(r1);
        r4 = 0;
        r3.writeByte(r4);
        r4 = 0;
        r4 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1));
        if (r4 != 0) goto L_0x003a;
    L_0x0025:
        r4 = 8;
        r3.skipBytes(r4);
    L_0x002a:
        r4 = r8.length;
        r3.writeInt(r4);
        r3.write(r8);
        r3.seek(r1);
        r4 = 1;
        r3.writeByte(r4);
    L_0x0038:
        monitor-exit(r3);
        goto L_0x0006;
    L_0x003a:
        r3.writeLong(r11);
        goto L_0x002a;
    L_0x003e:
        r4 = move-exception;
        r0 = r4;
        r4 = "MiniThumbFile";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "couldn't save mini thumbnail data for ";
        r5 = r5.append(r6);
        r5 = r5.append(r9);
        r6 = "; ";
        r5 = r5.append(r6);
        r5 = r5.toString();
        android.util.Log.e(r4, r5, r0);
        throw r0;
    }
}