package test1.example;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class screen extends Activity{
	 private TextView mDateDisplay;
	    private Button mPickDate;
	    private int mYear;
	    private int mMonth;
	    private int mDay;

	    static final int DATE_DIALOG_ID = 0;
	    
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.screen);

	        Button mainNext = (Button) findViewById(R.id.nextGo);//go button click event
	        mainNext.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	                Intent i = new Intent();
	                i.setClassName("test1.example", "test1.example.expense");//loading expense
	                
	        
	        Bundle bundle = new Bundle();//new bundle to carry value
	        bundle.putString("title1",Integer.toString(mDay));
	        bundle.putString("title2",Integer.toString(mMonth+ 1));
	        bundle.putString("title3",Integer.toString(mYear));
	        i.putExtras(bundle);
	        startActivity(i);//start activity
	            };   
	        });   
	        
	        
	        
	        
	        // capture our View elements
	        mDateDisplay = (TextView) findViewById(R.id.datedisplay);
	        mPickDate = (Button) findViewById(R.id.pickdate);

	        // add a click listener to the button
	        mPickDate.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                showDialog(DATE_DIALOG_ID);
	            }
	        });

	        // get the current date
	        final Calendar c = Calendar.getInstance();
	        mYear = c.get(Calendar.YEAR);
	        mMonth = c.get(Calendar.MONTH);
	        mDay = c.get(Calendar.DAY_OF_MONTH);

	        // display the current date (this method is below)
	        updateDisplay();
	    }

		private void updateDisplay() {
			// TODO Auto-generated method stub
			mDateDisplay.setText(
		            new StringBuilder()
		                    // Month is 0 based so add 1
		                    .append(mDay).append("/")
		                    .append(mMonth + 1).append("/")
		                    .append(mYear).append(" "));

		}
		
		
		// the callback received when the user "sets" the date in the dialog
	    private DatePickerDialog.OnDateSetListener mDateSetListener =
	            new DatePickerDialog.OnDateSetListener() {

	                public void onDateSet(DatePicker view, int year, 
	                                      int monthOfYear, int dayOfMonth) {
	                    mYear = year;
	                    mMonth = monthOfYear;
	                    mDay = dayOfMonth;
	                    updateDisplay();
	                }
	            };
	            
	            
	            @Override
	            protected Dialog onCreateDialog(int id) {
	                switch (id) {
	                case DATE_DIALOG_ID:
	                    return new DatePickerDialog(this,
	                                mDateSetListener,
	                                mYear, mMonth, mDay);
	                }
	                return null;
	            }

}