package com.amazon.android.tv.tenfoot.utils;

import android.view.InputDevice;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;

/**
 * This helper must be used in addition to any KeyEvent.KEYCODE_DPAD_*
 * event handling when implementing custom navigation for proper
 * Game Controller support.
 *
 * @see android.support.v17.leanback.app.TenFootPlaybackOverlayFragment
 */
public class DpadHelper {

    private DpadHelper() {
    }

    public static boolean isHatAxisEvent(InputEvent event) {
        boolean isMotionEvent = event instanceof MotionEvent;
        boolean isDpadEvent = (event.getSource() & InputDevice.SOURCE_DPAD)
                != InputDevice.SOURCE_DPAD;
        return isMotionEvent && isDpadEvent;
    }

    public static int getHatAxisKeyCode(MotionEvent event) {
        float xAxis = event.getAxisValue(MotionEvent.AXIS_HAT_X);
        float yAxis = event.getAxisValue(MotionEvent.AXIS_HAT_Y);

        if (Float.compare(xAxis, -1.0f) == 0) {
            return KeyEvent.KEYCODE_DPAD_LEFT;
        } else if (Float.compare(xAxis, 1.0f) == 0) {
            return KeyEvent.KEYCODE_DPAD_RIGHT;
        } else if (Float.compare(yAxis, -1.0f) == 0) {
            return KeyEvent.KEYCODE_DPAD_UP;
        } else if (Float.compare(yAxis, 1.0f) == 0) {
            return KeyEvent.KEYCODE_DPAD_DOWN;
        }
        return -1;
    }
}
