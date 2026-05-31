package com.techno.gallery;

class ViewImage$7 implements android.view.MenuItem.OnMenuItemClickListener {
    final /* synthetic */ com.techno.gallery.ViewImage this$0;

    ViewImage$7(com.techno.gallery.ViewImage r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    public boolean onMenuItemClick(android.view.MenuItem r4) {
        r3 = this;
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = r3.this$0;
        r2 = com.techno.gallery.GallerySettings.class;
        r0.setClass(r1, r2);
        r1 = r3.this$0;
        r1.startActivity(r0);
        r1 = 1;
        return r1;
    }
}