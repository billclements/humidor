package com.TDD.Humidor.test;

/**
 * Author: Megan Clark
 */
import android.app.Activity;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.app.ListActivity;
import android.content.IntentFilter;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.view.View;
import android.widget.ListView;

import com.TDD.Humidor.MainActivity;

public class TestMainActivity extends
		ActivityInstrumentationTestCase2<MainActivity> {
	private Activity mActivity;
	private Instrumentation mInstrumentation;
	private ListView mListView;

	public TestMainActivity() {
		this("TestMainActivity");
	}

	public TestMainActivity(String name) {
		super(MainActivity.class);
		setName(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		// This must be called before getActivity
		// disabling touch mode allows sending key events
		setActivityInitialTouchMode(false);
		mActivity = getActivity();
		mInstrumentation = getInstrumentation();
		mListView = getActivity().getListView();
	}

	/*
	 * Test all preconditions and ensure that the fixture has been created
	 * correctly
	 */
	public final void testPreconditions() {
		assertNotNull(mActivity);
		assertNotNull(mListView);
	}

	// An array of 2 items should populate the ListView
	public final void testListPopulatedCorrectly() {
		assertNotNull(((ListActivity) mActivity).getListView().getChildCount());
	}

	// test onClick
	public final void testListClick() {
		int i;
		int count = mListView.getChildCount();
		mInstrumentation.waitForIdleSync();
		final IntentFilter intentFilter = new IntentFilter();
		ActivityMonitor monitor = mInstrumentation.addMonitor(intentFilter,
				null, true);
		assertEquals(0, monitor.getHits());
		// click each entry in the list and check that it receives the click
		for (i = 0; i < count; i++) {
			View child = mListView.getChildAt(i);
			TouchUtils.clickView(this, child);
			monitor.waitForActivityWithTimeout(3000);
			assertEquals(i + 1, monitor.getHits());
		}
		mInstrumentation.removeMonitor(monitor);

	}
	
	//TODO test on long press
	
	//TODO test content resolver working correctly

	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
