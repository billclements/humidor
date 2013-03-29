package com.TDD.Humidor.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.TDD.Humidor.CigarDetailActivity;
import com.TDD.Humidor.R;

public class TestCigarDetailActivity extends ActivityInstrumentationTestCase2<CigarDetailActivity> {
	
	private CigarDetailActivity mActivity;
	
	private Button mConfirmButton;
	private Spinner mCategory;
	private SpinnerAdapter mRating;
	private EditText mBrandText;
	private EditText mTypeText;
	private EditText mWrapperText;
	private EditText mVitolaText;
	private EditText mQuantityText;	
	
	public static final int ADAPTER_COUNT = 6;	  // number of selections in spinner	
	
	public TestCigarDetailActivity() {
		super(CigarDetailActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		// disable touch features
		setActivityInitialTouchMode(false);
		
		//gets activity under test
	    mActivity = getActivity();
	    
	    mConfirmButton = (Button) mActivity.findViewById(R.id.cigar_edit_button);
	    mCategory = (Spinner) mActivity.findViewById(R.id.category);
	    mRating = mCategory.getAdapter();
	    mBrandText = (EditText) mActivity.findViewById(R.id.cigar_edit_brand);
	    mTypeText = (EditText) mActivity.findViewById(R.id.cigar_edit_type);
	    mWrapperText = (EditText) mActivity.findViewById(R.id.cigar_edit_wrapper);
	    mVitolaText = (EditText) mActivity.findViewById(R.id.cigar_edit_vitola);
	    mQuantityText = (EditText) mActivity.findViewById(R.id.cigar_edit_quantity);
	}
	
	protected void tearDown() throws Exception {
		getActivity().finish();
		//TODO delete "Test Cigar" from list
		super.tearDown();
	}	
	
	// tests if setUp() has been properly executed
	@SmallTest
	public void testPreConditions() throws Exception {
		assertNotNull(mActivity);		
		assertTrue(mRating != null);
		assertEquals(mRating.getCount(), ADAPTER_COUNT);		
		assertNotNull(mCategory);
		assertNotNull(mBrandText);
		assertNotNull(mTypeText);
		assertNotNull(mWrapperText);
		assertNotNull(mVitolaText);
		assertNotNull(mQuantityText);
		assertNotNull(mConfirmButton);
		
	} // end of testPreConditions() method definition	
	
	// tests if all input fields are blank and if the spinner defaults to the the first item
	@SmallTest
	public void testInputAreEmpty() {
		assertEquals(0, mCategory.getSelectedItemId());
		assertEquals("", mBrandText.getText().toString());
		assertEquals("", mTypeText.getText().toString());
		assertEquals("", mTypeText.getText().toString());
		assertEquals("", mVitolaText.getText().toString());
		assertEquals("", mVitolaText.getText().toString());
	}
	
	// test that data is not saved when inputs are empty
	@MediumTest
	public void testConfirmClickNotSaved(){	
		
		// clicks mConfirmButton
		TouchUtils.clickView(this, mConfirmButton);

		assertFalse(mActivity.saved);
		
		// tests if onDestory() has been called after click
		assertFalse(mActivity.isDestroyed());
		
	}

	@MediumTest
	public void testConfirmClickSaved(){		
		mActivity.runOnUiThread(new Runnable() {
			public void run() {
				// enter text for a test cigar
				mCategory.setSelection(5);
				mBrandText.setText("Test Cigar");
				mTypeText.setText("Test Type");
				mWrapperText.setText("Test Wrapper");
				mVitolaText.setText("Test Vitola");
				mQuantityText.setText("5");				
			}		
		});		
		
		// clicks mConfirmButton
		TouchUtils.clickView(this, mConfirmButton);
		
		// test is saved is true
		assertTrue(mActivity.saved);
		
		// tests if onDestory() has been called after click
		assertTrue(mActivity.isDestroyed());		
	}
	
	//TODO test to confirm that "Test Cigar" has been added to ListView
	
}
