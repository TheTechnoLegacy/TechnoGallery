package com.techno.gallery.gallery;

import android.graphics.Bitmap;
import android.net.Uri;
import com.techno.gallery.Util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

class BaseImage$CompressImageToFile extends BaseCancelable<Boolean> {
    private final Bitmap mBitmap;
    private final Uri mDestinationUri;
    private final byte[] mJpegData;
    private ThreadSafeOutputStream mOutputStream = null;
    final /* synthetic */ BaseImage this$0;

    public Boolean execute() throws Exception {
        Boolean valueOf;
        try {
            OutputStream openOutputStream = this.this$0.mContentResolver.openOutputStream(this.mDestinationUri);
            synchronized (this) {
                this.mOutputStream = new ThreadSafeOutputStream(openOutputStream);
            }
            if (this.mBitmap != null) {
                this.mBitmap.compress(this.this$0.compressionType(), 75, this.mOutputStream);
            } else {
                this.mOutputStream.write(this.mJpegData);
            }
            valueOf = Boolean.valueOf(true);
        } catch (FileNotFoundException e) {
            FileNotFoundException fileNotFoundException = e;
            valueOf = Boolean.valueOf(false);
        } catch (IOException e2) {
            IOException iOException = e2;
            valueOf = Boolean.valueOf(false);
        } finally {
            Util.closeSilently(this.mOutputStream);
        }
        return valueOf;
    }

    public BaseImage$CompressImageToFile(BaseImage baseImage, Bitmap bitmap, byte[] bArr, Uri uri) {
        this.this$0 = baseImage;
        this.mBitmap = bitmap;
        this.mDestinationUri = uri;
        this.mJpegData = bArr;
    }

    public boolean requestCancel() {
        if (!super.requestCancel()) {
            return false;
        }
        if (this.mOutputStream != null) {
            this.mOutputStream.close();
        }
        return true;
    }
}