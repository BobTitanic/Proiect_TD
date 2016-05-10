package com.proiect.medtime;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Consultatii extends Activity {

	Calendar calendar = Calendar.getInstance();
	int calendar_week = calendar.get(Calendar.WEEK_OF_YEAR);
	int n = calendar_week;
	// nu pot declara butoanele aici
	Context context = this;
	FragmentCalendar frag = new FragmentCalendar();
	FragmentManager manager = getFragmentManager();
	RelativeLayout lay_fragment;
	RelativeLayout la_layout;
	// findViewById(R.id.layout_fragment);
	// FragmentTransaction transaction = manager.beginTransaction();
	

	public void addNewButton(RelativeLayout rl, String pacient_name) {
		Button b = new Button(Consultatii.this);
		b.setBackgroundColor((int) Math.random());
		
		b.setText(pacient_name);
		rl.addView(b);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_consultatii);
		
		
		
		FragmentTransaction trans = manager.beginTransaction();
		trans.add(R.id.layout_consultatii, frag, "tagFrag");
		trans.commit();
		
		
		ImageButton back = (ImageButton) findViewById(R.id.butonConsultatiiBack);
		ImageButton forward = (ImageButton) findViewById(R.id.butonConsultatiiForward);
	
		RelativeLayout la_fragment = new RelativeLayout(Consultatii.this);
		la_fragment = (RelativeLayout) findViewById(R.id.layout_fragment);
		LinearLayout lLayout = new LinearLayout(Consultatii.this);
		//la_fragment.addView(lLayout);
		
		
		back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				n--;
				String s = "week" + n;
				lay_fragment = new RelativeLayout(Consultatii.this);
				lay_fragment = (RelativeLayout) findViewById(R.id.layout_fragment);
				Toast.makeText(Consultatii.this, "" + n, Toast.LENGTH_SHORT).show();
				LinearLayout linLayout = new LinearLayout(Consultatii.this);
				linLayout.setOrientation(LinearLayout.HORIZONTAL);
				linLayout.setId(n);
				RelativeLayout mondayLayout = new RelativeLayout(Consultatii.this);
				RelativeLayout tuesdayLayout = new RelativeLayout(Consultatii.this);
				RelativeLayout wednesdayLayout = new RelativeLayout(Consultatii.this);
				RelativeLayout thursdayLayout = new RelativeLayout(Consultatii.this);
				RelativeLayout fridayLayout = new RelativeLayout(Consultatii.this);
				String mon = s + "monday";
				mondayLayout.setTag(mon.toString());
				addNewButton(mondayLayout, "Monday");
				addNewButton(tuesdayLayout, "Tuesday");
				addNewButton(wednesdayLayout, "Wednesday");
				addNewButton(thursdayLayout, "Thursday");
				addNewButton(fridayLayout, "Friday");
				// adaugat import linearlayout.layoutparams
				int width = 150;
				mondayLayout.setLayoutParams(new LayoutParams(width, LayoutParams.MATCH_PARENT));
				// mondayLayout.setWidth
				LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				linLayout.addView(mondayLayout);
				linLayout.addView(tuesdayLayout);
				linLayout.addView(wednesdayLayout);
				linLayout.addView(thursdayLayout);
				linLayout.addView(fridayLayout);
				// addNewButton(mondayLayout, "Luni");
				if (lay_fragment != null) {
					lay_fragment.removeAllViews();
					lay_fragment.addView(linLayout);
				} else {
					// lay_fragment = new RelativeLayout(Consultatii.this);
					lay_fragment.addView(linLayout);
					lay_fragment.setBackgroundColor(Color.BLACK);
				}

			}
		});

		forward.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				n++;
				Toast.makeText(Consultatii.this, "" + n, Toast.LENGTH_SHORT).show();
				String s = "week" + n;
				lay_fragment = new RelativeLayout(Consultatii.this);
				lay_fragment = (RelativeLayout) findViewById(R.id.layout_fragment);
				
				LinearLayout linLayout = new LinearLayout(Consultatii.this);
				linLayout.setOrientation(LinearLayout.HORIZONTAL);
				linLayout.setId(n);
				RelativeLayout mondayLayout = new RelativeLayout(Consultatii.this);
				RelativeLayout tuesdayLayout = new RelativeLayout(Consultatii.this);
				RelativeLayout wednesdayLayout = new RelativeLayout(Consultatii.this);
				RelativeLayout thursdayLayout = new RelativeLayout(Consultatii.this);
				RelativeLayout fridayLayout = new RelativeLayout(Consultatii.this);
				String mon = s + "monday";
				mondayLayout.setTag(mon.toString());
				addNewButton(mondayLayout, "Monday");
				addNewButton(tuesdayLayout, "Tuesday");
				addNewButton(wednesdayLayout, "Wednesday");
				addNewButton(thursdayLayout, "Thursday");
				addNewButton(fridayLayout, "Friday");
				// adaugat import linearlayout.layoutparams
				int width = 150;
				mondayLayout.setLayoutParams(new LayoutParams(width, LayoutParams.MATCH_PARENT));
				// mondayLayout.setWidth
				LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				linLayout.addView(mondayLayout);
				linLayout.addView(tuesdayLayout);
				linLayout.addView(wednesdayLayout);
				linLayout.addView(thursdayLayout);
				linLayout.addView(fridayLayout);
				// addNewButton(mondayLayout, "Luni");
				if (lay_fragment != null) {
					lay_fragment.removeAllViews();
					lay_fragment.addView(linLayout);
				} else {
					// lay_fragment = new RelativeLayout(Consultatii.this);
					lay_fragment.addView(linLayout);
					lay_fragment.setBackgroundColor(Color.BLACK);
				}

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.consultatii, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.plus) {

			// OPENING DIALOG FOR INSERT PACIENT ACTION HERE
			showInsertDialog();
			return true;

		}

		return super.onOptionsItemSelected(item);
	}

	public void showInsertDialog() {

		// Create an instance of the dialog fragment and show it
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		LayoutInflater inflater = this.getLayoutInflater();
		builder.setView(inflater.inflate(R.layout.dialog_add_appointment, null))
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						Dialog f = (Dialog) dialog;

						EditText Name;
						Name = (EditText) f.findViewById(R.id.editText_appointment_pacient_name);

						String n = Name.getText().toString();

					}
				})

				.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.dismiss();
					}
				});

		builder.create().show();

	}

}

// }
// public LayoutManager create_week_layout(int n){

// LinearLayout linLayout = new LinearLayout(this);
// linLayout.setOrientation(LinearLayout.HORIZONTAL);
// String s = "week"+n;
// linLayout.setId(n);
// //bagat import import android.widget.LinearLayout.LayoutParams;
// //sterge si incearca cu altu daca nu ii bine
// linLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
// LayoutParams.MATCH_PARENT));
// LinearLayout.LayoutParams params =
// (LinearLayout.LayoutParams)linLayout.getLayoutParams();
// params.setMargins(0, 50, 0, 0);
// linLayout.setLayoutParams(params);
// String s = "week"+n;

// LinearLayout linLayout = new LinearLayout(this);
// //linLayout.setOrientation(LinearLayout.HORIZONTAL);
// linLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
// LayoutParams.MATCH_PARENT));
// linLayout.setId(n);

// RelativeLayout mondayLayout = new RelativeLayout(this);
// String mon = s+"monday";
// mondayLayout.setTag(mon.toString());
//// mondayLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
// LayoutParams.MATCH_PARENT));
// linLayout.addView(mondayLayout);

// RelativeLayout tuesdayLayout = new RelativeLayout(this);
// String tue = s+"tuesday";
// tuesdayLayout.setTag(tue.toString());
// tuesdayLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
// LayoutParams.MATCH_PARENT));
// linLayout.addView(tuesdayLayout);
//
// RelativeLayout wednesdayLayout = new RelativeLayout(this);
// String wed = s+"wednesday";
// wednesdayLayout.setTag(wed.toString());
// wednesdayLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
// LayoutParams.MATCH_PARENT));
// linLayout.addView(wednesdayLayout);
//
// RelativeLayout thursdayLayout = new RelativeLayout(this);
// String thu = s+"thursday";
// thursdayLayout.setTag(thu.toString());
// thursdayLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
// LayoutParams.MATCH_PARENT));
// linLayout.addView(thursdayLayout);
//
// RelativeLayout fridayLayout = new RelativeLayout(this);
// String fri = s+"friday";
// fridayLayout.setTag(fri.toString());
// fridayLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
// LayoutParams.MATCH_PARENT));
// linLayout.addView(fridayLayout);
// return linLayout;
//
