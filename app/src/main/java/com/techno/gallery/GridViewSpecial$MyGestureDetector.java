package com.techno.gallery;

class GridViewSpecial$MyGestureDetector extends android.view.GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ com.techno.gallery.GridViewSpecial this$0;

    private GridViewSpecial$MyGestureDetector(com.techno.gallery.GridViewSpecial r1) {
        r0 = this;
        r0.this$0 = r1;
        r0.<init>();
        return;
    }

    /* synthetic */ GridViewSpecial$MyGestureDetector(com.techno.gallery.GridViewSpecial r1, com.techno.gallery.GridViewSpecial.1 r2) {
        r0 = this;
        r0.<init>(r1);
        return;
    }

    public boolean onDown(android.view.MotionEvent r6) {
        r5 = this;
        r4 = 1;
        r2 = 0;
        r1 = r5.this$0;
        r1 = com.techno.gallery.GridViewSpecial.access$100(r1);
        if (r1 != 0) goto L_0x000c;
    L_0x000a:
        r1 = r2;
    L_0x000b:
        return r1;
    L_0x000c:
        r1 = r5.this$0;
        r1 = com.techno.gallery.GridViewSpecial.access$200(r1);
        if (r1 == 0) goto L_0x002b;
    L_0x0014:
        r1 = r5.this$0;
        r1 = com.techno.gallery.GridViewSpecial.access$200(r1);
        r1 = r1.isFinished();
        if (r1 != 0) goto L_0x002b;
    L_0x0020:
        r1 = r5.this$0;
        r1 = com.techno.gallery.GridViewSpecial.access$200(r1);
        r1.forceFinished(r4);
        r1 = r2;
        goto L_0x000b;
    L_0x002b:
        r1 = r5.this$0;
        r2 = r6.getX();
        r3 = r6.getY();
        r0 = r1.computeSelectedIndex(r2, r3);
        if (r0 < 0) goto L_0x004a;
    L_0x003b:
        r1 = r5.this$0;
        r1 = com.techno.gallery.GridViewSpecial.access$300(r1);
        if (r0 >= r1) goto L_0x004a;
    L_0x0043:
        r1 = r5.this$0;
        r1.setSelectedIndex(r0);
    L_0x0048:
        r1 = r4;
        goto L_0x000b;
    L_0x004a:
        r1 = r5.this$0;
        r2 = -1;
        r1.setSelectedIndex(r2);
        goto L_0x0048;
    }

    public boolean onFling(android.view.MotionEvent r10, android.view.MotionEvent r11, float r12, float r13) {
        r9 = this;
        r1 = 0;
        r0 = r9.this$0;
        r0 = com.techno.gallery.GridViewSpecial.access$100(r0);
        if (r0 != 0) goto L_0x000b;
    L_0x0009:
        r0 = r1;
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = 1159479296; // 0x451c4000 float:2500.0 double:5.72858887E-315;
        r0 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x004d;
    L_0x0012:
        r13 = 1159479296; // 0x451c4000 float:2500.0 double:5.72858887E-315;
    L_0x0015:
        r0 = r9.this$0;
        r2 = -1;
        r0.setSelectedIndex(r2);
        r0 = r9.this$0;
        r2 = new android.widget.Scroller;
        r3 = r9.this$0;
        r3 = r3.getContext();
        r2.<init>(r3);
        com.techno.gallery.GridViewSpecial.access$202(r0, r2);
        r0 = r9.this$0;
        r0 = com.techno.gallery.GridViewSpecial.access$200(r0);
        r2 = r9.this$0;
        r2 = com.techno.gallery.GridViewSpecial.access$400(r2);
        r3 = (int) r13;
        r4 = -r3;
        r3 = r9.this$0;
        r8 = com.techno.gallery.GridViewSpecial.access$500(r3);
        r3 = r1;
        r5 = r1;
        r6 = r1;
        r7 = r1;
        r0.fling(r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = r9.this$0;
        r0.computeScroll();
        r0 = 1;
        goto L_0x000a;
    L_0x004d:
        r0 = -988004352; // 0xffffffffc51c4000 float:-2500.0 double:NaN;
        r0 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x0015;
    L_0x0054:
        r13 = -988004352; // 0xffffffffc51c4000 float:-2500.0 double:NaN;
        goto L_0x0015;
    }

    public void onLongPress(android.view.MotionEvent r2) {
        r1 = this;
        r0 = r1.this$0;
        r0 = com.techno.gallery.GridViewSpecial.access$100(r0);
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = r1.this$0;
        r0.performLongClick();
        goto L_0x0008;
    }

    public boolean onScroll(android.view.MotionEvent r4, android.view.MotionEvent r5, float r6, float r7) {
        r3 = this;
        r2 = 0;
        r0 = r3.this$0;
        r0 = com.techno.gallery.GridViewSpecial.access$100(r0);
        if (r0 != 0) goto L_0x000b;
    L_0x0009:
        r0 = r2;
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = r3.this$0;
        r1 = -1;
        r0.setSelectedIndex(r1);
        r0 = r3.this$0;
        r1 = (int) r7;
        r0.scrollBy(r2, r1);
        r0 = r3.this$0;
        r0.invalidate();
        r0 = 1;
        goto L_0x000a;
    }

    public boolean onSingleTapConfirmed(android.view.MotionEvent r6) {
        r5 = this;
        r4 = 0;
        r1 = r5.this$0;
        r1 = com.techno.gallery.GridViewSpecial.access$100(r1);
        if (r1 != 0) goto L_0x000b;
    L_0x0009:
        r1 = r4;
    L_0x000a:
        return r1;
    L_0x000b:
        r1 = r5.this$0;
        r2 = r6.getX();
        r3 = r6.getY();
        r0 = r1.computeSelectedIndex(r2, r3);
        if (r0 < 0) goto L_0x002e;
    L_0x001b:
        r1 = r5.this$0;
        r1 = com.techno.gallery.GridViewSpecial.access$300(r1);
        if (r0 >= r1) goto L_0x002e;
    L_0x0023:
        r1 = r5.this$0;
        r1 = com.techno.gallery.GridViewSpecial.access$600(r1);
        r1.onImageTapped(r0);
        r1 = 1;
        goto L_0x000a;
    L_0x002e:
        r1 = r4;
        goto L_0x000a;
    }
}