package com.TDD.Humidor.test;

/**
 * Author: Megan Clark
 */
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;

import com.TDD.Humidor.ViewInventoryActivity;

public class TestViewInventoryActivity extends
		ActivityInstrumentationTestCase2<ViewInventoryActivity> {

	private ViewInventoryActivity mActivity;
	private Instrumentation mInstrumentation;
	private ListView mListView;

	public TestViewInventoryActivity() {
		this("TestViewInventoryActivity");
	}

	public TestViewInventoryActivity(String name) {
		super(ViewInventoryActivity.class);
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

	public final void testPreconditions() {
		assertNotNull(mActivity);
		assertNotNull(mListView);
		// First item should be selected
		assertEquals(0, mListView.getFirstVisiblePosition());
	}
	
	//TODO Test ContentResolver to be sure we're getting data

	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
