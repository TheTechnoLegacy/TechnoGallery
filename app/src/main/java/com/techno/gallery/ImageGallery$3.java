package com.techno.gallery;

class ImageGallery$3 implements android.view.MenuItem.OnMenuItemClickListener {
    final /* synthetic */ com.techno.gallery.ImageGallery this$0;

    ImageGallery$3(com.techno.gallery.ImageGallery r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    public boolean onMenuItemClick(android.view.MenuItem r2) {
        r1 = this;
        r0 = r1.this$0;
        r0 = r0.onSlideShowClicked();
        return r0;
    }
}