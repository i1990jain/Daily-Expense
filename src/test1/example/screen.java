package test1.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class screen extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.screen);//screen.xml as screen
	    // TODO Auto-generated method stub
	    
	    Button mainNext = (Button) findViewById(R.id.nextGo);//go button click event
        mainNext.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClassName("test1.example", "test1.example.expense");//loading expense
                
        //sending date value    
        EditText expensedate = (EditText)findViewById(R.id.datebox1);
        EditText expensemonth = (EditText)findViewById(R.id.monthbox1);
        EditText expenseyear = (EditText)findViewById(R.id.yearbox1);
        Bundle bundle = new Bundle();//new bundle to carry value
        bundle.putString("title1",expensedate.getText().toString());
        bundle.putString("title2",expensemonth.getText().toString());
        bundle.putString("title3",expenseyear.getText().toString());
        i.putExtras(bundle);
        startActivity(i);//start activity
            };   
        });
    }

	    
	}

