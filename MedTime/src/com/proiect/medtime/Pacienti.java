package com.proiect.medtime;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


public class Pacienti extends Activity {
	DBAdapter dbAdapter;
	ListView listview;
	Cursor cursor;
	String pacienti_delete_name;

	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pacienti);

		dbAdapter = new DBAdapter(this);
		listview = (ListView) findViewById(R.id.lista);
		String[] from = { DBAdapter.DBHelper.NAME };
		int[] to = { R.id.list_pacient };
		cursor = dbAdapter.queryName();
		SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this,
				R.layout.list_pacient, cursor, from, to);
		listview.setAdapter(cursorAdapter);

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(Pacienti.this,
						DisplayPacientInfo.class);
				myIntent.putExtra("Tag_name", cursor.getString(1));
				myIntent.putExtra("Tag_age", cursor.getString(2));
				myIntent.putExtra("Tag_cronic", cursor.getString(3));
				Pacienti.this.startActivity(myIntent);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pacienti, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.action_addPacient) {

			// OPENING DIALOG FOR INSERT PACIENT ACTION HERE
			showInsertDialog();
			return true;
		}else if(id == R.id.action_back){
			Intent myIntent = new Intent(Pacienti.this,
					Welcome.class);
			Pacienti.this.startActivity(myIntent);
		}
		
		return super.onOptionsItemSelected(item);
	}

	public void showInsertDialog() {

		// Create an instance of the dialog fragment and show it
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		LayoutInflater inflater = this.getLayoutInflater();
		builder.setView(inflater.inflate(R.layout.dialog_insert, null))

				.setPositiveButton(R.string.insert,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {

								Dialog f = (Dialog) dialog;

								EditText Name, age, cronic;
								Name = (EditText) f
										.findViewById(R.id.editText_pacientsName);
								age = (EditText) f
										.findViewById(R.id.editText_pacientsAge);
								cronic = (EditText) f
										.findViewById(R.id.editText_pacientsCronic);

								String n = Name.getText().toString();
								int a = Integer.parseInt(age.getText()
										.toString());
								String c = cronic.getText().toString();

								if (dbAdapter.insert(n, a, c) > 0) {

									Toast.makeText(getBaseContext(),
											"Pacient Added!", Toast.LENGTH_LONG)
											.show();

								} else {

									Toast.makeText(getBaseContext(),
											"Failed to insert!",
											Toast.LENGTH_LONG).show();

								}
							}
						})

				.setNegativeButton(R.string.cancel,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.dismiss();
							}
						});

		builder.create().show();

	}
}
