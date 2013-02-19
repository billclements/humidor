package com.TDD.Humidor;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentAddInventory extends Fragment {
	/*
	 * ===================================================== 
	 * Lifecycle Methods
	 * =====================================================
	 */

	// Called when the Fragment is attached to its parent activity
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		/*
		 * get a reference to the parent activity
		 */
	}

	// Called to do the initial creation of the fragment
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*
		 * initialize the fragment
		 */
	}

	// Called once the fragment has been created so it can create its UI
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/*
		 * create or inflate the fragment's ui and return it. If this fragment
		 * has no UI then return null
		 */
		// TODO insert proper args in form
		// inflater.inflate(R.layout.my_fragment, container, false)
		return null;
	}

	// Called once the parent Activity and fragment UI have been created
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		/*
		 * Complete the fragment initialization, particularly anything that
		 * requires the parent activity to be initialized or the fragment's view
		 * to be fully inflated
		 */
	}

	// Called at the start of the visible lifetime
	@Override
	public void onStart() {
		super.onStart();
		/*
		 * apply any required Ui change now that the frag is visible
		 */
	}

	// Called at the start of the visible lifetime
	@Override
	public void onResume() {
		super.onResume();
		/*
		 * resume any paused ui updates, threads, or processes required but
		 * suspended when it became inactive
		 */
	}

	// Called at the end of the active lifetime
	public void onPause() {
		/*
		 * suspend ui updates, threads or processes that don't need to be
		 * updated when the activity isn't the foreground activity. Persist all
		 * edits and state changes since after this call the activity is likely
		 * to be killed
		 */
		super.onPause();
	}

	// Called to save UI state changes at the end of the active lifecycle
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		/*
		 * Save the ui state changes to savedInstanceState; this bundle will be
		 * passed to onCreate and onCreateView if the parent activity is killed
		 * and restarted
		 */
		super.onSaveInstanceState(savedInstanceState);
	}

	// Called at the end of the visible lifetime
	@Override
	public void onStop() {
		/*
		 * suspend ui updates, threads or processes that aren't required when
		 * the fragment isn't visible
		 */
		super.onStop();
	}

	// Called when the fragment's view has been detached
	@Override
	public void onDestroyView() {
		/*
		 * clean up resources related to the view
		 */
		super.onDestroyView();
	}

	// Called at the end of the full lifetime
	@Override
	public void onDestroy() {
		/*
		 * clean up any resources, end threads, close DB connections, etc
		 */
		super.onDestroy();
	}
	
	/*
	 * =====================================================
	 * End of Lifecycle Methods
	 * =====================================================
	 */
}
