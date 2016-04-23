package com.proiect.medtime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class LogIn extends Activity {

	Button	login;
	EditText user,pass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_in);

		login = (Button)findViewById(R.id.button_login);
		user = (EditText)findViewById(R.id.editText_username);
		pass = (EditText)findViewById(R.id.editText_password);

		login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				if (user.getText().toString().equals("admin") && pass.getText().toString().equals("admin"))
				{
					Intent logare = new Intent(LogIn.this, Welcome.class);
					LogIn.this.startActivity(logare);
				}
			}
		});


	}

}
