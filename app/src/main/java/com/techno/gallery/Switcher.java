package com.techno.gallery;

public class Switcher extends android.widget.ImageView implements android.view.View.OnTouchListener {
    private static final int ANIMATION_SPEED = 200;
    private static final long NO_ANIMATION = -1;
    private static final java.lang.String TAG = "Switcher";
    private long mAnimationStartTime;
    private com.techno.gallery.Switcher.OnSwitchListener mListener;
    private int mPosition;
    private boolean mSwitch;

    public Switcher(android.content.Context r3, android.util.AttributeSet r4) {
        r2 = this;
        r0 = 0;
        r2.<init>(r3, r4);
        r2.mSwitch = r0;
        r2.mPosition = r0;
        r0 = 0;
        r2.mAnimationStartTime = r0;
        return;
    }

    private void startParkingAnimation() {
        r4 = this;
        r2 = r4.getDrawable();
        r0 = r2.getIntrinsicHeight();
        r2 = r4.mSwitch;
        if (r2 == 0) goto L_0x001c;
    L_0x000c:
        r2 = r4.getHeight();
        r2 = r2 - r0;
        r3 = r4.mPaddingBottom;
        r2 = r2 - r3;
        r1 = r2;
    L_0x0015:
        r2 = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
        r4.mAnimationStartTime = r2;
        return;
    L_0x001c:
        r2 = r4.mPaddingTop;
        r1 = r2;
        goto L_0x0015;
    }

    private void trackTouchEvent(android.view.MotionEvent r8) {
        r7 = this;
        r1 = r7.getDrawable();
        r2 = r1.getIntrinsicHeight();
        r3 = r7.getHeight();
        r5 = r7.mPaddingTop;
        r5 = r3 - r5;
        r6 = r7.mPaddingBottom;
        r5 = r5 - r6;
        r0 = r5 - r2;
        r5 = r8.getY();
        r4 = (int) r5;
        r5 = r7.mPaddingTop;
        r5 = r4 - r5;
        r6 = r2 / 2;
        r5 = r5 - r6;
        r7.mPosition = r5;
        r5 = r7.mPosition;
        if (r5 >= 0) goto L_0x002a;
    L_0x0027:
        r5 = 0;
        r7.mPosition = r5;
    L_0x002a:
        r5 = r7.mPosition;
        if (r5 <= r0) goto L_0x0030;
    L_0x002e:
        r7.mPosition = r0;
    L_0x0030:
        r7.invalidate();
        return;
    }

    private void tryToSetSwitch(boolean r2) {
        r1 = this;
        r0 = r1.mSwitch;	 Catch:{ all -> 0x001e }
        if (r0 != r2) goto L_0x0008;
    L_0x0004:
        r1.startParkingAnimation();
    L_0x0007:
        return;
    L_0x0008:
        r0 = r1.mListener;
        if (r0 == 0) goto L_0x0018;
    L_0x000c:
        r0 = r1.mListener;
        r0 = r0.onSwitchChanged(r1, r2);
        if (r0 != 0) goto L_0x0018;
    L_0x0014:
        r1.startParkingAnimation();
        goto L_0x0007;
    L_0x0018:
        r1.mSwitch = r2;
        r1.startParkingAnimation();
        goto L_0x0007;
    L_0x001e:
        r0 = move-exception;
        r1.startParkingAnimation();
        throw r0;
    }

    public void addTouchView(android.view.View r1) {
        r0 = this;
        r1.setOnTouchListener(r0);
        return;
    }

    protected void onDraw(android.graphics.Canvas r21) {
        r20 = this;
        r6 = r20.getDrawable();
        r7 = r6.getIntrinsicHeight();
        r8 = r6.getIntrinsicWidth();
        if (r6 != 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        if (r8 == 0) goto L_0x000e;
    L_0x0011:
        if (r7 == 0) goto L_0x000e;
    L_0x0013:
        r0 = r20;
        r0 = r0.mAnimationStartTime;
        r14 = r0;
        r16 = -1;
        r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r14 == 0) goto L_0x008a;
    L_0x001e:
        r14 = r20.getHeight();
        r0 = r20;
        r0 = r0.mPaddingTop;
        r15 = r0;
        r14 = r14 - r15;
        r0 = r20;
        r0 = r0.mPaddingBottom;
        r15 = r0;
        r14 = r14 - r15;
        r3 = r14 - r7;
        r12 = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
        r0 = r20;
        r0 = r0.mAnimationStartTime;
        r14 = r0;
        r4 = r12 - r14;
        r0 = r20;
        r0 = r0.mPosition;
        r14 = r0;
        r14 = (long) r14;
        r16 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r0 = r20;
        r0 = r0.mSwitch;
        r18 = r0;
        if (r18 == 0) goto L_0x00c7;
    L_0x004b:
        r18 = r4;
    L_0x004d:
        r16 = r16 * r18;
        r18 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r16 = r16 / r18;
        r14 = r14 + r16;
        r14 = (int) r14;
        r0 = r14;
        r1 = r20;
        r1.mPosition = r0;
        r0 = r12;
        r2 = r20;
        r2.mAnimationStartTime = r0;
        r0 = r20;
        r0 = r0.mPosition;
        r14 = r0;
        if (r14 >= 0) goto L_0x006d;
    L_0x0067:
        r14 = 0;
        r0 = r14;
        r1 = r20;
        r1.mPosition = r0;
    L_0x006d:
        r0 = r20;
        r0 = r0.mPosition;
        r14 = r0;
        if (r14 <= r3) goto L_0x0079;
    L_0x0074:
        r0 = r3;
        r1 = r20;
        r1.mPosition = r0;
    L_0x0079:
        r0 = r20;
        r0 = r0.mPosition;
        r14 = r0;
        if (r14 == 0) goto L_0x00cc;
    L_0x0080:
        r0 = r20;
        r0 = r0.mPosition;
        r14 = r0;
        if (r14 == r3) goto L_0x00cc;
    L_0x0087:
        r20.postInvalidate();
    L_0x008a:
        r0 = r20;
        r0 = r0.mPaddingTop;
        r14 = r0;
        r0 = r20;
        r0 = r0.mPosition;
        r15 = r0;
        r10 = r14 + r15;
        r14 = r20.getWidth();
        r14 = r14 - r8;
        r0 = r20;
        r0 = r0.mPaddingLeft;
        r15 = r0;
        r14 = r14 - r15;
        r0 = r20;
        r0 = r0.mPaddingRight;
        r15 = r0;
        r14 = r14 - r15;
        r9 = r14 / 2;
        r11 = r21.getSaveCount();
        r21.save();
        r14 = (float) r9;
        r15 = (float) r10;
        r0 = r21;
        r1 = r14;
        r2 = r15;
        r0.translate(r1, r2);
        r0 = r6;
        r1 = r21;
        r0.draw(r1);
        r0 = r21;
        r1 = r11;
        r0.restoreToCount(r1);
        goto L_0x000e;
    L_0x00c7:
        r0 = r4;
        r0 = -r0;
        r18 = r0;
        goto L_0x004d;
    L_0x00cc:
        r14 = -1;
        r0 = r14;
        r2 = r20;
        r2.mAnimationStartTime = r0;
        goto L_0x008a;
    }

    public boolean onTouch(android.view.View r2, android.view.MotionEvent r3) {
        r1 = this;
        r1.onTouchEvent(r3);
        r0 = 1;
        return r0;
    }

    public boolean onTouchEvent(android.view.MotionEvent r6) {
        r5 = this;
        r4 = 1;
        r3 = 0;
        r1 = r5.isEnabled();
        if (r1 != 0) goto L_0x000a;
    L_0x0008:
        r1 = r3;
    L_0x0009:
        return r1;
    L_0x000a:
        r1 = r5.getHeight();
        r2 = r5.mPaddingTop;
        r1 = r1 - r2;
        r2 = r5.mPaddingBottom;
        r1 = r1 - r2;
        r2 = r5.getDrawable();
        r2 = r2.getIntrinsicHeight();
        r0 = r1 - r2;
        r1 = r6.getAction();
        switch(r1) {
            case 0: goto L_0x0027;
            case 1: goto L_0x0036;
            case 2: goto L_0x0032;
            case 3: goto L_0x0049;
            default: goto L_0x0025;
        };
    L_0x0025:
        r1 = r4;
        goto L_0x0009;
    L_0x0027:
        r1 = -1;
        r5.mAnimationStartTime = r1;
        r5.setPressed(r4);
        r5.trackTouchEvent(r6);
        goto L_0x0025;
    L_0x0032:
        r5.trackTouchEvent(r6);
        goto L_0x0025;
    L_0x0036:
        r5.trackTouchEvent(r6);
        r1 = r5.mPosition;
        r2 = r0 / 2;
        if (r1 < r2) goto L_0x0047;
    L_0x003f:
        r1 = r4;
    L_0x0040:
        r5.tryToSetSwitch(r1);
        r5.setPressed(r3);
        goto L_0x0025;
    L_0x0047:
        r1 = r3;
        goto L_0x0040;
    L_0x0049:
        r1 = r5.mSwitch;
        r5.tryToSetSwitch(r1);
        r5.setPressed(r3);
        goto L_0x0025;
    }

    public void setOnSwitchListener(com.techno.gallery.Switcher.OnSwitchListener r1) {
        r0 = this;
        r0.mListener = r1;
        return;
    }

    public void setSwitch(boolean r2) {
        r1 = this;
        r0 = r1.mSwitch;
        if (r0 != r2) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r1.mSwitch = r2;
        r1.invalidate();
        goto L_0x0004;
    }
}