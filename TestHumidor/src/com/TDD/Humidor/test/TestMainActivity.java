package com.TDD.Humidor.test;

import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.test.ActivityUnitTestCase;
import android.test.TouchUtils;
import android.test.UiThreadTest;
import android.view.View;
import android.widget.ListView;

import com.TDD.Humidor.MainActivity;

public class TestMainActivity extends
		ActivityUnitTestCase<MainActivity> {

	private Intent mStartIntent;
	private ListView mListView;
	private Instrumentation mInstrumentation;
	private MainActivity mActivity;
	private Context mContext;

	public TestMainActivity() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mStartIntent = new Intent(Intent.ACTION_MAIN);
		mInstrumentation = getInstrumentation();
		mActivity = startActivity(mStartIntent, null, null);
		mListView = (ListView) mActivity.findViewById(android.R.id.list);
		mContext = getInstrumentation().getTargetContext();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/*
	 * ====================================================================
	 * TESTS
	 */
	public void testPreconditions() {
		assertNotNull(mActivity);
		assertNotNull(mListView);
	}

	// Is the list view populated?
	public final void testListIsPopulated() {
		assertNotNull(mListView.getChildCount());
	}

	// is the new activity launched on click?
	public void testSubLaunch() {
		int i;
		int count = mListView.getChildCount();
		mInstrumentation.waitForIdleSync();
		final IntentFilter intentFilter = new IntentFilter();
		ActivityMonitor monitor = mInstrumentation.addMonitor(intentFilter,
				null, true);
		assertEquals(0, monitor.getHits());
		// click each entry in the list and check that it receives the click, a
		// new activity is started, and this activity shuts down properly
		for (i = 0; i < count; i++) {
			View child = mListView.getChildAt(i);
			TouchUtils.clickView(this, child);
			monitor.waitForActivityWithTimeout(3000);
			assertEquals(i + 1, monitor.getHits());
			assertNotNull(getStartedActivityIntent());
			assertTrue(isFinishCalled());
		}
		mInstrumentation.removeMonitor(monitor);
	}

	// can the selection be set to specific position?
	@UiThreadTest
	public void testSetSelection() {
		int childCount = mListView.getChildCount();
		for (int i = 0; i < childCount; i++) {
			mListView.setSelection(i);
			assertEquals("Set selection", i,
					mListView.getSelectedItemPosition());
		}
	}

	// TODO find test contextmenu
	// TODO find test contentresolver
	// TODO find test progressbar
	// TODO find test lifecycle

}