package com.TDD.Humidor.test;

import java.util.ArrayList;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.TDD.Humidor.MainActivity;
import com.jayway.android.robotium.solo.Solo;

public class TestMainActivity extends
		ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;
	private MainActivity mActivity;
	private ListView mListView;

	// No-arg Constructor per Best Practice
	public TestMainActivity() {
		this("TestMainActivityInstrumentation");
	}

	public TestMainActivity(String name) {
		super(MainActivity.class);
		setName(name);
	}

	@Override
	protected void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
		mActivity = getActivity();
		mListView = (ListView) mActivity.findViewById(android.R.id.list);

	}

	@Override
	protected void tearDown() throws Exception {
		try {
			solo.finishOpenedActivities();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		getActivity().finish();
		super.tearDown();
	}

	/*
	 * ======================================================================
	 * Method Tests
	 * ======================================================================
	 */

	// Ensure that the fixture is correctly set up
	public void testPreconditions() {
		solo.assertCurrentActivity("wrong activity", MainActivity.class);
		assertNotNull(mActivity);
		assertNotNull(mListView);

	}

	// Ensure All views are on screen
	public void testViews() {
		assertNotNull(mActivity.findViewById(com.TDD.Humidor.R.id.insert));
		assertNotNull(mActivity.findViewById(android.R.id.list));
	}

	// TODO Is the list view populated?
	public void testIsListPopulated() {
		ArrayList<View> list = solo.getCurrentViews();
		Log.d("MegsLogTag",
				"number of list views on the screen: " + list.size());
	}

	// When a list item is clicked a new activity should be opened
	public void testOnListItemClick() {
		// select first entry
		solo.clickInList(1);
		solo.waitForActivity("CigarDetailActivity", 1000);
		// check that the CigarDetailActivity has been loaded
		solo.assertCurrentActivity("Expected CigarDetailActivity",
				"CigarDetailActivity");

	}

	// When the list is long-pressed a context menu should appear
	// with an option to delete the item. When item is deleted
	// the list should refresh and deleted entry should be gone
	public void testOnContextItemSelected() {
		int firstCount = mListView.getChildCount();
		solo.clickLongInList(0);
		solo.waitForDialogToOpen(1000);
		solo.clickOnText("Delete Cigar");
		solo.waitForDialogToClose(2000);
		int secondCount = mListView.getChildCount();
		assertNotSame(firstCount, secondCount);

	}

	// when the Insert button is clicked a new activity should be opened
	public void testOnOptionsItemSelected() {
		solo.clickOnMenuItem("Insert");
		// assert that CigarDetailActivity is opened
		solo.assertCurrentActivity("Expected CigarDetailActivity",
				"CigarDetailActivity");
	}

	/*
	 * ======================================================================
	 * Activity Lifecycle Tests
	 * ======================================================================
	 */

	// ensure that activity is properly reinitialized after orientation change
	public void testOrientationChange() {
		// get the current activity
		Activity originalActivity = solo.getCurrentActivity();
		// change the orientation
		solo.setActivityOrientation(Solo.LANDSCAPE);
		// wait for the activity to settle
		getInstrumentation().waitForIdleSync();
		// get the current activity
		Activity landscapeActivity = solo.getCurrentActivity();
		assertNotSame(originalActivity, landscapeActivity);

	}

}
