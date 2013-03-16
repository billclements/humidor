package com.TDD.Humidor;

/*
 * Author: Megan Clark
 */

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;

public class ViewInventoryActivity extends ListActivity implements
		LoaderManager.LoaderCallbacks<Cursor> {

	// This is the Adapter being used to display the list's data
	SimpleCursorAdapter mAdapter;

	// These are the rows that we retrieve
	// TODO correct these args for our app, Contacts ContentProvider used for
	// testing
	static final String[] PROJECTION = new String[] {
			ContactsContract.Data._ID, ContactsContract.Data.DISPLAY_NAME };

	// This is the selection criteria
	// TODO correct these args for our app, Contacts ContentProvider used for
	// testing
	static final String SELECTION = "((" + ContactsContract.Data.DISPLAY_NAME
			+ " NOTNULL) AND (" + ContactsContract.Data.DISPLAY_NAME
			+ " != '' ))";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// For the cursor adapter, specify which columns go into which views
		String[] fromColumns = { ContactsContract.Data.DISPLAY_NAME };
		int[] toViews = { android.R.id.text1 }; // The TextView in
												// simple_list_item_1

		// Create an empty adapter we will use to display the loaded data.
		// We pass null for the cursor, then update it in onLoadFinished()
		mAdapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_1, null, fromColumns,
				toViews, 0);
		setListAdapter(mAdapter);

		// Prepare the loader. Either re-connect with an existing one,
		// or start a new one.
		getLoaderManager().initLoader(0, null, this);
	}

	// Called when a new Loader needs to be created
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		// Now create and return a CursorLoader that will take care of
		// creating a Cursor for the data being displayed.
		return new CursorLoader(this, ContactsContract.Data.CONTENT_URI,
				PROJECTION, SELECTION, null, null);
	}

	// Called when a previously created loader has finished loading
	public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
		// Swap the new cursor in. (The framework will take care of closing the
		// old cursor once we return.)
		mAdapter.swapCursor(data);
	}

	// Called when a previously created loader is reset, making the data
	// unavailable
	public void onLoaderReset(Loader<Cursor> loader) {
		// This is called when the last Cursor provided to onLoadFinished()
		// above is about to be closed. We need to make sure we are no
		// longer using it.
		mAdapter.swapCursor(null);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// Do something when a list item is clicked
	}

}