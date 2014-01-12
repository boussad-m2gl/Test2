package com.example.tp1mmm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ActivityTwo  extends Activity{

	
	 @Override
	  public void onCreate(Bundle bundle) {
	    super.onCreate(bundle);
	    setContentView(R.layout.activity_result);
	    
	   /* Bundle b= getIntent().getExtras(); 
	    String name = b.getString("Value1").toString();
	    Toast.makeText(getApplicationContext(), " Received name is :"+name +"..", 
		       	Toast.LENGTH_LONG).show();
	    */
	    //:: -- getting data  via parcelable object
	    
	    Bundle b= getIntent().getExtras(); 
	    MyData obj = (MyData) b.get("myobj");
	    Toast.makeText(getApplicationContext(), " Received  data is nom is :"+obj.getNom() +", "+ 
	    		"prenom :"+obj.getPrenom(),
		       	Toast.LENGTH_LONG).show();
	  }
	 
	 @Override
	 public void finish() {
	   // Prepare data intent 
	   Intent data = new Intent();
	   data.putExtra("returnKey1", "Swinging on a star. ");
	   data.putExtra("returnKey2", "You could be better then you are. ");
	   // Activity finished ok, return the data
	   setResult(RESULT_OK, data);
	   super.finish();
	 } 
}
