package com.proiect.medtime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayPacientInfo extends Activity {
	
	TextView name,age,cronic;
	Button back,delete;
	String delete_name;
	DBAdapter dbAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_pacient_info);
		
		dbAdapter = new DBAdapter(this);
		
		name = (TextView)findViewById(R.id.textView_pacientsName);
		age = (TextView)findViewById(R.id.textView_pacientsAge);
		cronic = (TextView)findViewById(R.id.textView_pacientsCronic);
	
		name.setText(this.getIntent().getStringExtra("Tag_name"));
		age.setText(this.getIntent().getStringExtra("Tag_age"));
		cronic.setText(this.getIntent().getStringExtra("Tag_cronic"));
		delete_name =name.getText().toString();
		
		back = (Button)findViewById(R.id.button_back);
		delete = (Button)findViewById(R.id.button_delete_pacient);
		
		
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent myIntent = new Intent(DisplayPacientInfo.this, Pacienti.class); 
				
				DisplayPacientInfo.this.startActivity(myIntent);

				
			}
					
		});
		delete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				long i = dbAdapter.deletePacient(delete_name);
				if(i<=0){
					Toast.makeText(getBaseContext(), "Pacient "+ delete_name +" was not deleted!", Toast.LENGTH_LONG).show();
					
				}else{Toast.makeText(getBaseContext(), "Pacient "+ delete_name +" was deleted!", Toast.LENGTH_LONG).show();}
				
				Intent intent = new Intent(DisplayPacientInfo.this, Pacienti.class); 
				DisplayPacientInfo.this.startActivity(intent);
				
									
			}
		});
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_pacient_info, menu);
		return true;
	}
	
	


}
