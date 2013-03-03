package com.TDD.Humidor;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentAddInventory extends Fragment {
	
	final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;
    
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

        // If activity recreated (such as from screen rotate), restore
        // the previous article selection set by onSaveInstanceState().
        // This is primarily necessary when in the two-pane layout.
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }
        
        View view = inflater.inflate(R.layout.fragment_add_inventory, container, false);
        
        // all text field
		EditText brand = (EditText) view.findViewById(R.id.editText_Brand);
		EditText type = (EditText) view.findViewById(R.id.editText_Type);
		EditText wrapper = (EditText) view.findViewById(R.id.editText_Wrapper);
		EditText vitola = (EditText) view.findViewById(R.id.editText_Vitola);
		EditText quantity = (EditText) view.findViewById(R.id.editText_Quantity);
		
		
		// clear text fields
		brand.setText("");
		type.setText("");
		wrapper.setText("");
		vitola.setText("");
		quantity.setText("");		
		
		Button add = (Button) view.findViewById(R.id.button_Add);
		add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/*
				 * 
				 * code for adding cigar to inventory
				 * 
				 */	
				
			}
		});
		
		Button clear = (Button) view.findViewById(R.id.button_Clear);
		clear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/*
				 * 
				 * code for clearing all text fields
				 * 
				 */	
				
			}
		});
        
		Button cancel = (Button) view.findViewById(R.id.button_Cancel);
		cancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/*
				 * 
				 * code for returning to inventory list
				 * 
				 */				
			}
		});
        
        // Inflate the layout for this fragment
        return view;
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

	@Override
    public void onStart() {
        super.onStart();

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.
        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            updateArticleView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateArticleView(mCurrentPosition);
        }
    }

	// Called at the start of the visible lifetime
	@Override
	public void onResume() {
		super.onResume();
		/*
		 * resume any paused UI updates, threads, or processes required but
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
	
	public void updateArticleView(int position) {
        mCurrentPosition = position;
    }
	
	// Called to save UI state changes at the end of the active lifecycle
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }

	// Called at the end of the visible lifetime
	@Override
	public void onStop() {
		/*
		 * suspend UI updates, threads or processes that aren't required when
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
