package com.TDD.Humidor.test;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;

import com.TDD.Humidor.CigarDetailActivity;
import com.TDD.Humidor.R;

public class TestCigarDetailActivity extends ActivityInstrumentationTestCase2<CigarDetailActivity> {
	
	private Activity mActivity;
	private Instrumentation mInstrumentation;
	private Button mConfirmButton;
	private EditText mBrandText;
	private EditText mTypeText;
	private EditText mWrapperText;
	private EditText mVitolaText;
	private EditText mQuantityText;
	
	public TestCigarDetailActivity() {
		this("TestCigarDetailActivity");
	}
	
	public TestCigarDetailActivity(String name) {
		super(CigarDetailActivity.class);
		setName(name);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	
	    setActivityInitialTouchMode(false);
	
	    mActivity = getActivity();
	    
	    mConfirmButton = (Button) mActivity.findViewById(R.id.cigar_edit_button);	    
	    mBrandText = (EditText) mActivity.findViewById(R.id.cigar_edit_brand);
	    mTypeText = (EditText) mActivity.findViewById(R.id.cigar_edit_type);
	    mWrapperText = (EditText) mActivity.findViewById(R.id.cigar_edit_wrapper);
	    mVitolaText = (EditText) mActivity.findViewById(R.id.cigar_edit_vitola);
	    mQuantityText = (EditText) mActivity.findViewById(R.id.cigar_edit_quantity);
	  
	} // end of setUp() method definition
	
	public void testPreConditions() {
		assertNotSame("", mBrandText.getText());
	} // end of testPreConditions() method definition
	
	public void testConfirmClick(){
		
	}
	

}
