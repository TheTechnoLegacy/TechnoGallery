package com.techno.gallery;

class ViewImage$5 implements android.view.MenuItem.OnMenuItemClickListener {
    final /* synthetic */ com.techno.gallery.ViewImage this$0;

    ViewImage$5(com.techno.gallery.ViewImage r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    public boolean onMenuItemClick(android.view.MenuItem r6) {
        r5 = this;
        r4 = 1;
        r0 = r5.this$0;
        r1 = 2;
        r0.setMode(r1);
        r0 = r5.this$0;
        r1 = r5.this$0;
        r1 = r1.mCurrentPosition;
        com.techno.gallery.ViewImage.access$602(r0, r1);
        r0 = r5.this$0;
        r1 = r5.this$0;
        r1 = r1.mCurrentPosition;
        r2 = 0;
        com.techno.gallery.ViewImage.access$700(r0, r1, r2, r4);
        return r4;
    }
}