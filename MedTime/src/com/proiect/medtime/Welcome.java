package com.proiect.medtime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Welcome extends Activity {

	Button pacienti,consultatii;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		pacienti = (Button)findViewById(R.id.button_pacienti);
		consultatii  = (Button)findViewById(R.id.button_consultatii);
		
		pacienti.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i_pacienti = new Intent(Welcome.this, Pacienti.class);
				Welcome.this.startActivity(i_pacienti);
				
			}
		});
		
		consultatii.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i_consultatii = new Intent(Welcome.this, Consultatii.class);
				Welcome.this.startActivity(i_consultatii);
				
			}
		});
		
	}

	
}
