package com.techno.gallery;

/* compiled from: GalleryPicker */
class GalleryPickerAdapter extends android.widget.BaseAdapter {
    android.view.LayoutInflater mInflater;
    java.util.ArrayList<com.techno.gallery.Item> mItems;

    GalleryPickerAdapter(android.view.LayoutInflater r2) {
        r1 = this;
        r1.<init>();
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1.mItems = r0;
        r1.mInflater = r2;
        return;
    }

    public void addItem(com.techno.gallery.Item r2) {
        r1 = this;
        r0 = r1.mItems;
        r0.add(r2);
        return;
    }

    public java.lang.String baseTitleForPosition(int r2) {
        r1 = this;
        r0 = r1.mItems;
        r1 = r0.get(r2);
        r1 = (com.techno.gallery.Item) r1;
        r0 = r1.mName;
        return r0;
    }

    public void clear() {
        r1 = this;
        r0 = r1.mItems;
        r0.clear();
        return;
    }

    public int getCount() {
        r1 = this;
        r0 = r1.mItems;
        r0 = r0.size();
        return r0;
    }

    public int getIncludeMediaTypes(int r2) {
        r1 = this;
        r0 = r1.mItems;
        r1 = r0.get(r2);
        r1 = (com.techno.gallery.Item) r1;
        r0 = r1.getIncludeMediaTypes();
        return r0;
    }

    public java.lang.Object getItem(int r2) {
        r1 = this;
        r0 = 0;
        return r0;
    }

    public long getItemId(int r3) {
        r2 = this;
        r0 = (long) r3;
        return r0;
    }

    public android.view.View getView(int r9, android.view.View r10, android.view.ViewGroup r11) {
        r8 = this;
        if (r10 != 0) goto L_0x005b;
    L_0x0002:
        r5 = r8.mInflater;
        r6 = 2130903048; // 0x7f030008 float:1.7412903E38 double:1.0528059906E-314;
        r7 = 0;
        r4 = r5.inflate(r6, r7);
    L_0x000c:
        r5 = 2131427348; // 0x7f0b0014 float:1.847631E38 double:1.0530650293E-314;
        r3 = r4.findViewById(r5);
        r3 = (android.widget.TextView) r3;
        r5 = 2131427389; // 0x7f0b003d float:1.8476393E38 double:1.0530650495E-314;
        r1 = r4.findViewById(r5);
        r1 = (com.techno.gallery.GalleryPickerItem) r1;
        r5 = r8.mItems;
        r0 = r5.get(r9);
        r0 = (com.techno.gallery.Item) r0;
        r5 = r0.getOverlay();
        r1.setOverlay(r5);
        r5 = r0.mThumbBitmap;
        if (r5 == 0) goto L_0x005d;
    L_0x0031:
        r5 = r0.mThumbBitmap;
        r1.setImageBitmap(r5);
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r0.mName;
        r5 = r5.append(r6);
        r6 = " (";
        r5 = r5.append(r6);
        r6 = r0.mCount;
        r5 = r5.append(r6);
        r6 = ")";
        r5 = r5.append(r6);
        r2 = r5.toString();
        r3.setText(r2);
    L_0x005a:
        return r4;
    L_0x005b:
        r4 = r10;
        goto L_0x000c;
    L_0x005d:
        r5 = 17170445; // 0x106000d float:2.461195E-38 double:8.483327E-317;
        r1.setImageResource(r5);
        r5 = r0.mName;
        r3.setText(r5);
        goto L_0x005a;
    }

    public void updateDisplay() {
        r0 = this;
        r0.notifyDataSetChanged();
        return;
    }
}