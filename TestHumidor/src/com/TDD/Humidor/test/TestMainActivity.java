package com.TDD.Humidor.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.TDD.Humidor.MainActivity;

public class TestMainActivity extends ActivityInstrumentationTestCase2<MainActivity> {

	private Activity mActivity;

	public TestMainActivity() {
		this("TestMainActivity");
	}

	public TestMainActivity(String name) {
		super(MainActivity.class);
		setName(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		/*
		 * getActivity() has the side effect of starting an activity if it is
		 * not already running. This causes problems when getActivity() is used
		 * as a simple accessor several times in a test and for some reason the
		 * Activity finishes or crashes before test completion. for this reason,
		 * getActivity is used in the fixture
		 */
		mActivity = getActivity();
	}

	/*
	 * Test all preconditions and ensure that the fixture has been created
	 * correctly
	 */
	public final void testPreconditions() {
		assertNotNull(mActivity);
	}

	//TODO test the existence of UI components
}
