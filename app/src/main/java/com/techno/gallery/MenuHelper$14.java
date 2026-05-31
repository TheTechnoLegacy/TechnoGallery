package com.techno.gallery;

class MenuHelper$14 implements android.view.MenuItem.OnMenuItemClickListener {
    final /* synthetic */ android.app.Activity val$activity;
    final /* synthetic */ java.lang.Runnable val$onDelete;
    final /* synthetic */ com.techno.gallery.MenuHelper.MenuInvoker val$onInvoke;

    MenuHelper$14(com.techno.gallery.MenuHelper.MenuInvoker r1, android.app.Activity r2, java.lang.Runnable r3) {
        r0 = this;
        r0.val$onInvoke = r1;
        r0.val$activity = r2;
        r0.val$onDelete = r3;
        r0.<init>();
        return;
    }

    public boolean onMenuItemClick(android.view.MenuItem r4) {
        r3 = this;
        r0 = r3.val$onInvoke;
        r1 = r3.val$activity;
        r2 = r3.val$onDelete;
        r0 = com.techno.gallery.MenuHelper.access$900(r0, r1, r2);
        return r0;
    }
}