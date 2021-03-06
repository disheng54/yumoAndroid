/**
 * TouchEventChild.java
 * yumo
 * 2014-12-2
 * TODO
 */
package com.yumo.android.common.widget;

import com.yumo.common.android.YmTouchEventUtil;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * yumo
 *
 */
public class TouchEventChild extends LinearLayout {
	private final String TAG = TouchEventChild.class.getSimpleName() + " ";
	/**
	 * @param context
	 */
	public TouchEventChild(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public TouchEventChild(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, TAG + " | dispatchTouchEvent --> " + YmTouchEventUtil.getTouchAction(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i(TAG, TAG + " | onInterceptTouchEvent --> " + YmTouchEventUtil.getTouchAction(ev.getAction()));
        return super.onInterceptTouchEvent(ev);
    }

    public boolean onTouchEvent(MotionEvent ev) {
        Log.d(TAG, TAG+ " | onTouchEvent --> " + YmTouchEventUtil.getTouchAction(ev.getAction()));
        return super.onTouchEvent(ev);
    }

}
