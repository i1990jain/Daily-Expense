package test1.example;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class expense extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.expense);//expense.xml as screen
	    // TODO Auto-generated method stub
	    
	    
	    Bundle bundle = this.getIntent().getExtras();
	    final String title1 = bundle.getString("title1");//receiving date
	    final String title2 = bundle.getString("title2");//receiving month
	    final String title3 = bundle.getString("title3");//receiving month
	    
	    ((TextView)findViewById(R.id.expenseTitle)).setText(title1+"/"+title2+"/"+title3);
	    final String date1 = title1+title2+title3;
	    
	    
	    Button mainNext = (Button) findViewById(R.id.totalbutton1);//button click event
        mainNext.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	
            	EditText foodbox = (EditText)findViewById(R.id.foodbox1);
         	    
            	int food;
            	 food = Integer.parseInt(foodbox.getText().toString());
         	   //taking values from edittext boxes
            	    EditText transportbox = (EditText)findViewById(R.id.transportbox1);
            	    int transport;
            	    //string to integer
            	    transport = Integer.parseInt(transportbox.getText().toString());
            	    
            	    EditText laundrybox = (EditText)findViewById(R.id.laundrybox1);
            	    int laundry;
            	    laundry = Integer.parseInt(laundrybox.getText().toString());
            	    
            	    int total1;
            	    total1 = food + transport + laundry; 
            	    //integer to string
            	    String tota = Integer.toString(total1);
            	    ((EditText)findViewById(R.id.totalbox1)).setText(tota);
            	    
            	    try {
            	        File root = Environment.getExternalStorageDirectory();
            	        if (root.canWrite()){
            	            File output = new File(root,date1+".txt");
            	            FileWriter outputwriter = new FileWriter(output,true);
            	            BufferedWriter out = new BufferedWriter(outputwriter);
            	            out.write("Total Expense for "+title1+"/"+title2+"/"+title3+"is"+" ");
            	            out.write(tota+"\n");
            	            out.close();
            	        }
            	    } catch (IOException e) {
            	        Log.e("Could not write file " + e.getMessage(), tota);
            	    }  
            	    
            	   
            	   
            	 
               }
           });
	   }
	
}
