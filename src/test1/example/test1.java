package test1.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class test1 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);//set main.xml as the screen
        
        Button mainNext = (Button) findViewById(R.id.nextScreen2);//button click event
        mainNext.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClassName("test1.example", "test1.example.screen");//loading screen
                startActivity(i);//starting activity
            };   
       });
        
        
        Button mainNext1 = (Button) findViewById(R.id.nextScreen3);//button click event
        mainNext1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent j = new Intent();
                j.setClassName("test1.example", "test1.example.report");//loading screen
                startActivity(j);//starting activity
            };   
       });
       
        
    }
}
