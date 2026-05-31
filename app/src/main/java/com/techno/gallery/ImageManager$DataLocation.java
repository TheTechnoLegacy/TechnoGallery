package com.techno.gallery;

public enum ImageManager$DataLocation {
    private static final /* synthetic */ com.techno.gallery.ImageManager$DataLocation[] $VALUES = null;
    public static final com.techno.gallery.ImageManager$DataLocation ALL = null;
    public static final com.techno.gallery.ImageManager$DataLocation EXTERNAL = null;
    public static final com.techno.gallery.ImageManager$DataLocation INTERNAL = null;
    public static final com.techno.gallery.ImageManager$DataLocation NONE = null;

    static {
        r5 = 3;
        r4 = 2;
        r3 = 1;
        r2 = 0;
        r0 = new com.techno.gallery.ImageManager$DataLocation;
        r1 = "NONE";
        r0.<init>(r1, r2);
        NONE = r0;
        r0 = new com.techno.gallery.ImageManager$DataLocation;
        r1 = "INTERNAL";
        r0.<init>(r1, r3);
        INTERNAL = r0;
        r0 = new com.techno.gallery.ImageManager$DataLocation;
        r1 = "EXTERNAL";
        r0.<init>(r1, r4);
        EXTERNAL = r0;
        r0 = new com.techno.gallery.ImageManager$DataLocation;
        r1 = "ALL";
        r0.<init>(r1, r5);
        ALL = r0;
        r0 = 4;
        r0 = new com.techno.gallery.ImageManager$DataLocation[r0];
        r1 = NONE;
        r0[r2] = r1;
        r1 = INTERNAL;
        r0[r3] = r1;
        r1 = EXTERNAL;
        r0[r4] = r1;
        r1 = ALL;
        r0[r5] = r1;
        $VALUES = r0;
        return;
    }

    private ImageManager$DataLocation(java.lang.String r1, int r2) {
        r0 = this;
        r0.<init>(r1, r2);
        return;
    }

    public static com.techno.gallery.ImageManager$DataLocation valueOf(java.lang.String r1) {
        r0 = com.techno.gallery.ImageManager$DataLocation.class;
        r1 = java.lang.Enum.valueOf(r0, r1);
        r1 = (com.techno.gallery.ImageManager$DataLocation) r1;
        return r1;
    }

    public static final com.techno.gallery.ImageManager$DataLocation[] values() {
        r0 = $VALUES;
        r0 = r0.clone();
        r0 = (com.techno.gallery.ImageManager$DataLocation[]) r0;
        return r0;
    }
}