package com.TDD.Humidor;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/*
 * Author: Megan Clark
 */

public class MainActivity extends ListActivity {

	/** Called when the activity is first created */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] values = new String[] { "Add New Inventory", "View Inventory" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, values);
		setListAdapter(adapter);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		String item = (String) getListAdapter().getItem(position);
		Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
		switch (position) {
		case 0:
			Intent newInventoryActivity = new Intent(this, AddInventoryActivity.class);
			startActivity(newInventoryActivity);
			break;
		case 1:
			Intent viewInventoryActivity = new Intent(this, ViewInventoryActivity.class);
			startActivity(viewInventoryActivity);
			break;

		}
	}
}
