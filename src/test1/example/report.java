package test1.example;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class report extends Activity {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);//set report.xml as the screen
	
        final DbAdapter db = new DbAdapter(this);
        int totalfood = 0;
        int totaltransport=0 ;
        int totallaundry=0;
        int totalexpense=0;
        db.open();
        
        Cursor c = db.fetchAllExpense();
        if (c.moveToFirst())
        {
            do {       
            	Toast.makeText(this, 
     	               "id: " + c.getString(0) + "\n" +
     	               "Date " + c.getString(1) + "\n" +
     	               "Food: " + c.getInt(2) + "\n" +
     	                "Transport:  " + c.getInt(3)+"\n"+ "Laundry"+c.getInt(4)+"\n"+ "Total ="+c.getInt(5),
     	               Toast.LENGTH_LONG).show();
           
            	totalfood=totalfood+c.getInt(2);
            	totaltransport=totaltransport+c.getInt(3);
            	totallaundry=totallaundry+c.getInt(4);
            	totalexpense=totalexpense+c.getInt(5);
            	
            } while (c.moveToNext());
        
        }
        String food1 = Integer.toString(totalfood);
        String transport1 = Integer.toString(totaltransport);
        String laundry1 = Integer.toString(totallaundry);
        String total1 = Integer.toString(totalexpense);
       
       ((TextView)findViewById(R.id.totalfood)).setText("Total Expenses on food :" + food1);
       ((TextView)findViewById(R.id.totaltransport)).setText("Total Expenses on transport:"+transport1);
	    ((TextView)findViewById(R.id.totallaundry)).setText("Total Expenses on laundry :"+laundry1);
	    ((TextView)findViewById(R.id.totalexpense)).setText("Total Expenses : "+ total1);
       
       
       db.close();
        	
}
    
	
}
