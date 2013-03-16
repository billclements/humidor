package com.TDD.Humidor.test;

/*
 * Author: Megan Clark
 */

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;

import com.TDD.Humidor.AddInventoryActivity;

public class TestAddInventoryActivity extends
		ActivityInstrumentationTestCase2<AddInventoryActivity> {

	private Activity mActivity;
	private Instrumentation mInstrumentation;

	public TestAddInventoryActivity() {
		this("TestAddInventoryActivity");
	}

	public TestAddInventoryActivity(String name) {
		super(AddInventoryActivity.class);
		setName(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		// This must be called before getActivity
		// disabling touch mode allows sending key events
		setActivityInitialTouchMode(false);
		mActivity = getActivity();
		mInstrumentation = getInstrumentation();

	}

	/* Test all preconditions and ensure that fixture has been created correctly */
	public final void testPreconditions() {
		assertNotNull(mActivity);
		assertNotNull(mInstrumentation);
	}

	// Is the UI displaying all needed views
	public final void testViews() {
		// TODO
	}
	
	// Are views collecting correct input type
	public final void testInputTypes(){
		//TODO
	}

	// Does the insert contain proper information
	public final void testCursorContentt(){
		//TODO
	}
	// Do we have the ContentResolver?
	public final void contentResolverIsAvailable() {
		// TODO
	}
	
	// Can we insert the data
	public final void testInsertData(){
		//TODO
	}
	


}
