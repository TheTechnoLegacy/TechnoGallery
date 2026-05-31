package com.techno.gallery;

class MenuHelper$15 implements android.view.MenuItem.OnMenuItemClickListener {
    final /* synthetic */ android.app.Activity val$activity;
    final /* synthetic */ android.os.Handler val$handler;
    final /* synthetic */ com.techno.gallery.MenuHelper.MenuInvoker val$onInvoke;

    MenuHelper$15(com.techno.gallery.MenuHelper.MenuInvoker r1, android.os.Handler r2, android.app.Activity r3) {
        r0 = this;
        r0.val$onInvoke = r1;
        r0.val$handler = r2;
        r0.val$activity = r3;
        r0.<init>();
        return;
    }

    public boolean onMenuItemClick(android.view.MenuItem r4) {
        r3 = this;
        r0 = r3.val$onInvoke;
        r1 = r3.val$handler;
        r2 = r3.val$activity;
        r0 = com.techno.gallery.MenuHelper.access$1000(r0, r1, r2);
        return r0;
    }
}