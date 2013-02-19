package com.TDD.Humidor;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

/**
 * @author Megan Clark 
 * There are a lot of comments here for learning purposes
 */
public class MainActivity extends Activity {

	/*
	 * ===================================================== 
	 * Lifecycle Methods
	 * =====================================================
	 */

	// Called when the activity is first created
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	// Called after onCreate has finished, used to restore UI state
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		/*
		 * Restores the UI state from the savedInstanceState This bundle has
		 * also been passed to onCreate This will only be called if the activity
		 * has been killed by the system since it was last visible
		 */
	}

	// Called before subsequent visible lifetimes for an Activity process
	@Override
	public void onRestart() {
		super.onRestart();
		/*
		 * Load changes knowing that the activity has already been visible
		 * within this process
		 */
	}

	// Called at the start of the visible lifetime
	@Override
	public void onStart() {
		super.onStart();
		/*
		 * Apply any required UI change now that the activity is visible
		 */
	}

	// Called at the start of the active lifetime
	@Override
	public void onResume() {
		super.onResume();
		/*
		 * Resume any paused UI updates, threads or processes suspended when the
		 * activity was inactive
		 */

	}

	// Called to save UI state changes at the end of the active lifecycle
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		/*
		 * Save UI state changes to savedInstanceState. This bundle will be
		 * passed to onCreate and onRestoreInstanceState if the process is
		 * killed and restarted by the runtime.
		 */
		super.onSaveInstanceState(savedInstanceState);
	}

	// Called at the end of the active lifetime
	@Override
	public void onPause() {
		/*
		 * Suspend UI updates, threads or processes that don't need to be
		 * updated when the activity isn't the active foreground activity
		 */
		super.onPause();
	}

	// Called at the end of the visible lifetime
	@Override
	public void onStop() {
		/*
		 * Suspend remaining UI updates, threads or processes that aren't
		 * required when the activity isn't visible. Persist all state changes
		 * or edits because after this call the application is likely to be
		 * killed
		 */
		super.onStop();
	}

	// Called (sometimes) at the end of the full lifetime
	@Override
	public void onDestroy() {
		/*
		 * Clean up any resources, close database connections, etc.
		 */
		super.onDestroy();
	}

	/*
	 * =====================================================
	 * End of Lifecycle Methods
	 * =====================================================
	 */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
