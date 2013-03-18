package com.TDD.Humidor;



import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.TDD.Humidor.ContentProvider.HumidorContentProvider;
import com.TDD.Humidor.Database.HumidorTable;

public class CigarDetailActivity extends Activity {
	  private Spinner mCategory;
	  private EditText mBrandText;
	  private EditText mTypeText;
	  private EditText mWrapperText;
	  private EditText mVitolaText;
	  private EditText mQuantityText;

	  private Uri cigarUri;

	  @Override
	  protected void onCreate(Bundle bundle) {
	    super.onCreate(bundle);
	    setContentView(R.layout.cigar_edit);

	    mCategory = (Spinner) findViewById(R.id.category);
	    mBrandText = (EditText) findViewById(R.id.cigar_edit_brand);
	    mTypeText = (EditText) findViewById(R.id.cigar_edit_type);
	    mWrapperText = (EditText) findViewById(R.id.cigar_edit_wrapper);
	    mVitolaText = (EditText) findViewById(R.id.cigar_edit_vitola);
	    mQuantityText = (EditText) findViewById(R.id.cigar_edit_quantity);
	    Button confirmButton = (Button) findViewById(R.id.cigar_edit_button);

	    Bundle extras = getIntent().getExtras();

	    // Check from the saved Instance
	    cigarUri = (bundle == null) ? null : (Uri) bundle
	        .getParcelable(HumidorContentProvider.CONTENT_ITEM_TYPE);

	    // Or passed from the other activity
	    if (extras != null) {
	      cigarUri = extras
	          .getParcelable(HumidorContentProvider.CONTENT_ITEM_TYPE);

	      fillData(cigarUri);
	    }

	    confirmButton.setOnClickListener(new View.OnClickListener() {
	      public void onClick(View view) {
	        if (TextUtils.isEmpty(mBrandText.getText().toString())) {
	          makeToast();
	        } else {
	          setResult(RESULT_OK);
	          finish();
	        }
	      }

	    });
	  }

	  private void fillData(Uri uri) {
	    String[] projection = { HumidorTable.COLUMN_BRAND,
	        HumidorTable.COLUMN_TYPE, HumidorTable.COLUMN_WRAPPER,
	        HumidorTable.COLUMN_VITOLA, HumidorTable.COLUMN_QUANTITY, HumidorTable.COLUMN_CATEGORY };
	    Cursor cursor = getContentResolver().query(uri, projection, null, null,
	        null);
	    if (cursor != null) {
	      cursor.moveToFirst();
	      String category = cursor.getString(cursor
	          .getColumnIndexOrThrow(HumidorTable.COLUMN_CATEGORY));

	      for (int i = 0; i < mCategory.getCount(); i++) {

	        String s = (String) mCategory.getItemAtPosition(i);
	        if (s.equalsIgnoreCase(category)) {
	          mCategory.setSelection(i);
	        }
	      }

	      mBrandText.setText(cursor.getString(cursor
	          .getColumnIndexOrThrow(HumidorTable.COLUMN_BRAND)));
	      mTypeText.setText(cursor.getString(cursor
	          .getColumnIndexOrThrow(HumidorTable.COLUMN_TYPE)));
	      mWrapperText.setText(cursor.getString(cursor
	              .getColumnIndexOrThrow(HumidorTable.COLUMN_WRAPPER)));
	      mVitolaText.setText(cursor.getString(cursor
	              .getColumnIndexOrThrow(HumidorTable.COLUMN_VITOLA)));
	      mQuantityText.setText(cursor.getString(cursor
	              .getColumnIndexOrThrow(HumidorTable.COLUMN_QUANTITY)));

	      // Always close the cursor
	      cursor.close();
	    }
	  }

	  protected void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    saveState();
	    outState.putParcelable(HumidorContentProvider.CONTENT_ITEM_TYPE, cigarUri);
	  }

	  @Override
	  protected void onPause() {
	    super.onPause();
	    saveState();
	  }

	  private void saveState() {
	    String category = (String) mCategory.getSelectedItem();
	    String brand = mBrandText.getText().toString();
	    String type = mTypeText.getText().toString();
	    String wrapper = mWrapperText.getText().toString();
	    String vitola = mVitolaText.getText().toString();
	    String quantity = mQuantityText.getText().toString();

	    // Only save if either brand or type
	    // is available

	    if (brand.length() == 0 && type.length() == 0) {
	      return;
	    }

	    ContentValues values = new ContentValues();
	    values.put(HumidorTable.COLUMN_CATEGORY, category);
	    values.put(HumidorTable.COLUMN_BRAND, brand);
	    values.put(HumidorTable.COLUMN_TYPE, type);
	    values.put(HumidorTable.COLUMN_WRAPPER, wrapper);
	    values.put(HumidorTable.COLUMN_VITOLA, vitola);
	    values.put(HumidorTable.COLUMN_QUANTITY, quantity);
	    

	    if (cigarUri == null) {
	      // New cigar
	      cigarUri = getContentResolver().insert(HumidorContentProvider.CONTENT_URI, values);
	    } else {
	      // Update cigar
	      getContentResolver().update(cigarUri, values, null, null);
	    }
	  }

	  private void makeToast() {
	    Toast.makeText(CigarDetailActivity.this, "Please maintain a summary",
	        Toast.LENGTH_LONG).show();
	  }
	} 
