package com.techno.gallery;

enum BitmapManager$State {
    private static final /* synthetic */ com.techno.gallery.BitmapManager$State[] $VALUES = null;
    public static final com.techno.gallery.BitmapManager$State ALLOW = null;
    public static final com.techno.gallery.BitmapManager$State CANCEL = null;

    static {
        r3 = 1;
        r2 = 0;
        r0 = new com.techno.gallery.BitmapManager$State;
        r1 = "CANCEL";
        r0.<init>(r1, r2);
        CANCEL = r0;
        r0 = new com.techno.gallery.BitmapManager$State;
        r1 = "ALLOW";
        r0.<init>(r1, r3);
        ALLOW = r0;
        r0 = 2;
        r0 = new com.techno.gallery.BitmapManager$State[r0];
        r1 = CANCEL;
        r0[r2] = r1;
        r1 = ALLOW;
        r0[r3] = r1;
        $VALUES = r0;
        return;
    }

    private BitmapManager$State(java.lang.String r1, int r2) {
        r0 = this;
        r0.<init>(r1, r2);
        return;
    }

    public static com.techno.gallery.BitmapManager$State valueOf(java.lang.String r1) {
        r0 = com.techno.gallery.BitmapManager$State.class;
        r1 = java.lang.Enum.valueOf(r0, r1);
        r1 = (com.techno.gallery.BitmapManager$State) r1;
        return r1;
    }

    public static final com.techno.gallery.BitmapManager$State[] values() {
        r0 = $VALUES;
        r0 = r0.clone();
        r0 = (com.techno.gallery.BitmapManager$State[]) r0;
        return r0;
    }
}