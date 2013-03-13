package com.TDD.Humidor.test;

import android.app.Activity;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.app.ListActivity;
import android.content.IntentFilter;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.UiThreadTest;
import android.widget.ListView;

import com.TDD.Humidor.MainActivity;

public class TestMainActivity extends
		ActivityInstrumentationTestCase2<MainActivity> {
	private Activity mActivity;
	private Instrumentation mInstrumentation;
	private IntentFilter mIntentFilter;
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
		mIntentFilter = new IntentFilter();
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

	public final void testListPopulatedCorrectly() {
		assertEquals(2, ((ListActivity) mActivity).getListView()
				.getChildCount());
		assertEquals("Add New Inventory", ((ListActivity) mActivity)
				.getListView().getItemAtPosition(0).toString());
		assertEquals("View Inventory", ((ListActivity) mActivity).getListView()
				.getItemAtPosition(1).toString());
	}

	@UiThreadTest
	public final void testListClickStartsActivity() {
		//TODO
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
