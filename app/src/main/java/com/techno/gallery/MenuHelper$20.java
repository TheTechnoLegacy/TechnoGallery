package com.techno.gallery;

class MenuHelper$20 implements android.view.MenuItem.OnMenuItemClickListener {
    final /* synthetic */ java.lang.String val$action;
    final /* synthetic */ android.app.Activity val$activity;

    MenuHelper$20(android.app.Activity r1, java.lang.String r2) {
        r0 = this;
        r0.val$activity = r1;
        r0.val$action = r2;
        r0.<init>();
        return;
    }

    public boolean onMenuItemClick(android.view.MenuItem r3) {
        r2 = this;
        r0 = r2.val$activity;
        r1 = r2.val$action;
        com.techno.gallery.MenuHelper.access$1300(r0, r1);
        r0 = 1;
        return r0;
    }
}