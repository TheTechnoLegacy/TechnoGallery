package com.techno.gallery;

public class DrmWallpaper extends com.techno.gallery.Wallpaper {
    public DrmWallpaper() {
        r0 = this;
        r0.<init>();
        return;
    }

    protected void formatIntent(android.content.Intent r3) {
        r2 = this;
        super.formatIntent(r3);
        r0 = "pick-drm";
        r1 = 1;
        r3.putExtra(r0, r1);
        return;
    }
}