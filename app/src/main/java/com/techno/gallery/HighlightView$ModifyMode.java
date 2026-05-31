package com.techno.gallery;

enum HighlightView$ModifyMode {
    private static final /* synthetic */ com.techno.gallery.HighlightView$ModifyMode[] $VALUES = null;
    public static final com.techno.gallery.HighlightView$ModifyMode Grow = null;
    public static final com.techno.gallery.HighlightView$ModifyMode Move = null;
    public static final com.techno.gallery.HighlightView$ModifyMode None = null;

    static {
        r4 = 2;
        r3 = 1;
        r2 = 0;
        r0 = new com.techno.gallery.HighlightView$ModifyMode;
        r1 = "None";
        r0.<init>(r1, r2);
        None = r0;
        r0 = new com.techno.gallery.HighlightView$ModifyMode;
        r1 = "Move";
        r0.<init>(r1, r3);
        Move = r0;
        r0 = new com.techno.gallery.HighlightView$ModifyMode;
        r1 = "Grow";
        r0.<init>(r1, r4);
        Grow = r0;
        r0 = 3;
        r0 = new com.techno.gallery.HighlightView$ModifyMode[r0];
        r1 = None;
        r0[r2] = r1;
        r1 = Move;
        r0[r3] = r1;
        r1 = Grow;
        r0[r4] = r1;
        $VALUES = r0;
        return;
    }

    private HighlightView$ModifyMode(java.lang.String r1, int r2) {
        r0 = this;
        r0.<init>(r1, r2);
        return;
    }

    public static com.techno.gallery.HighlightView$ModifyMode valueOf(java.lang.String r1) {
        r0 = com.techno.gallery.HighlightView$ModifyMode.class;
        r1 = java.lang.Enum.valueOf(r0, r1);
        r1 = (com.techno.gallery.HighlightView$ModifyMode) r1;
        return r1;
    }

    public static final com.techno.gallery.HighlightView$ModifyMode[] values() {
        r0 = $VALUES;
        r0 = r0.clone();
        r0 = (com.techno.gallery.HighlightView$ModifyMode[]) r0;
        return r0;
    }
}