package com.example.tp1mmm;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private String  nom;
	private String prenom;
	private String ville;
	private String dateNaissance;
	
	private static int REQUEST_CODE=5;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // EditText nomTxt= (EditText) findViewById(R.id.editTextNom);
      // For to hid the keyboeard
       
      
        		    
     
         Button btn= (Button) findViewById(R.id.buttonValider);
        /* btn.setOnClickListener( new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				/*String message ="";
				nom  =  ((EditText) findViewById(R.id.editTextNom)).getText().toString();
				prenom  =  ((EditText)findViewById(R.id.editTextPrenom)).getText().toString();
				ville  =  ((EditText) findViewById(R.id.editTextVille)).getText().toString();
				// get the date 
				 DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker1);
				 int day = datePicker.getDayOfMonth();
				 int month = datePicker.getMonth() + 1;
				 int year = datePicker.getYear();
				
			
		     		message += " Nom :"+nom+" ,  Prenom :"+prenom+" ,  ville: "+ville+
		     				"Date naiss : "+  "Day :"+day+" Month :"+month +" year "+year;
		     				;
				    Toast.makeText(getApplicationContext(), message , 
					       	Toast.LENGTH_LONG).show();
					
				 
			     	       	
			}} ) ;*/
         
        		
    }

    public void onClick(View view) {
    	/*  Intent i = new Intent(this, ActivityTwo.class);
    	  i.putExtra("Value1", "This value one for ActivityTwo ");
    	  i.putExtra("Value2", "This value two ActivityTwo");
    	  // Set the request code to any code you like, you can identify the
    	  // callback via this code
    	  startActivityForResult(i, REQUEST_CODE);*/
    	
    	//::---  sending data using parcelable objects
    	MyData da = new MyData();
    	da.setNom("duck"); da.setPrenom("Rachel");
    	Intent i = new Intent(this, ActivityTwo.class);
    	i.putExtra("myobj", da);
    	startActivity(i);
    	
      }
 
     // Second method of android 
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	// Tis is done by parsing the menu  XML file
        getMenuInflater().inflate(R.menu.main, menu);
        return true;    
    }
    
     @Override
    public boolean onOptionsItemSelected(MenuItem item)
    { 
	    switch (item.getItemId())
	    {
	      case R.id.menu_clearchamps:
	       
	        Toast.makeText(this, "search is Selected", Toast.LENGTH_SHORT).show();
	        ((EditText) findViewById(R.id.editTextNom)).getText().clear();
	        return true;
	
	      case R.id.menu_addTel:
	       // Toast.makeText(this, "Save is Selected", Toast.LENGTH_SHORT).show();
	    	/*  LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    	  View v = vi.inflate(R.layout.activity_main, null);
	    	 // LinearLayout ll = new LinearLayout(this);
	    	 // ll.setOrientation(LinearLayout.VERTICAL);
	    	  // Add text
	    	  TextView tv = new TextView(this);
	    	  tv.setText("My TexT");
	    	  EditText editxt =  new EditText(this);
	    	 // ll.addView(tv);
	    	  //new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
	    	  // Add the LinearLayout element to the ScrollView
	    	  ((ViewGroup) v).addView(tv);
	    	  ((ViewGroup) v).addView(tv);
	    	  ((ViewGroup) v).addView(editxt);
	    	 
	    	     // Display the view
	    	    setContentView(v);*/
	    	  
	      //---> Trying  to invoke a web browser 	  
	    	  
	    	  Intent inte =  new Intent(Intent.ACTION_VIEW, Uri.parse("http://fr.wikipedia.org/wiki/Algérie"));
	    	  startActivity(inte);
	    }
		return true;
    }  
     
     
     @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
         if (data.hasExtra("returnKey1")) {
           Toast.makeText(this, data.getExtras().getString("returnKey1"),
             Toast.LENGTH_SHORT).show();
         }
       }
     }  
    
    
}
