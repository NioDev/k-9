package com.fsck.k9.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;

import com.fsck.k9.activity.K9ActivityCommon.K9ActivityMagic;
import com.fsck.k9.activity.misc.SwipeGestureDetector.OnSwipeGestureListener;

public class K9FragmentActivity extends ActionBarActivity implements K9ActivityMagic
{

	private K9ActivityCommon mBase;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		mBase = K9ActivityCommon.newInstance(this);
		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event)
	{
		mBase.preDispatchTouchEvent(event);
		return super.dispatchTouchEvent(event);
	}

	@Override
	public void setupGestureDetector(OnSwipeGestureListener listener)
	{
		mBase.setupGestureDetector(listener);
	}

	// Backwards compatible recreate().
	@SuppressLint("NewApi")
	public void recreate()
	{
		if (android.os.Build.VERSION.SDK_INT >= 11)
		{
			super.recreate();
		}
		else
		{
			startActivity(getIntent());
			finish();
		}
	}
}