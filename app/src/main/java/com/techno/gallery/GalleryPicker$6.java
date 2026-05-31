package com.techno.gallery;

class GalleryPicker$6 implements android.view.MenuItem.OnMenuItemClickListener {
    final /* synthetic */ com.techno.gallery.GalleryPicker this$0;
    final /* synthetic */ android.view.ContextMenu.ContextMenuInfo val$menuInfo;

    GalleryPicker$6(com.techno.gallery.GalleryPicker r1, android.view.ContextMenu.ContextMenuInfo r2) {
        r0 = this;
        r0.this$0 = r1;
        r0.val$menuInfo = r2;
        r0.<init>();
        return;
    }

    public boolean onMenuItemClick(android.view.MenuItem r3) {
        r2 = this;
        r0 = r2.this$0;
        r1 = r2.val$menuInfo;
        r0 = com.techno.gallery.GalleryPicker.access$500(r0, r1);
        return r0;
    }
}