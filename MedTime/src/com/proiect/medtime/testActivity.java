package com.proiect.medtime;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

public class testActivity extends Activity{
	RelativeLayout un_layout = (RelativeLayout) findViewById(R.id.tes_layout);
	Calendar calendar = Calendar.getInstance();
	int calendar_week=calendar.get(Calendar.WEEK_OF_YEAR);
	//int n = calendar_week;
	//create_week_layout(n);
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout l = create_week_layout(2);
		//un_layout.addView(l);
		setContentView(un_layout);
		
	}
	
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		LayoutManager l = create_week_layout(calendar_week);
//		LinearLayout layouy = (LinearLayout) findViewById(R.id.layout_consultatii);
//		layouy.addView(l);
//		setContentView(create_week_layout(calendar_week));
//	}
//		FragmentManager manager = getFragmentManager();
//		FragmentTransaction transaction = manager.beginTransaction();
//		transaction.add(R.id.layout_consultatii,frag,"fragTag");
//		create_week_layout(calendar_week);
//		transaction.commit();
//		ImageButton back = (ImageButton)findViewById(R.id.butonConsultatiiBack);
//		ImageButton forward = (ImageButton)findViewById(R.id.butonConsultatiiForward);
//		back.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				n--;
//				
//				
//			}
//		});
//		
//		
//	
//	}
	
public LinearLayout create_week_layout(int n){
		
//		LinearLayout linLayout = new LinearLayout(this);
//		linLayout.setOrientation(LinearLayout.HORIZONTAL);
//		String s = "week"+n; 
//		linLayout.setId(n);
//		//bagat import import android.widget.LinearLayout.LayoutParams;
//		//sterge si incearca cu altu daca nu ii bine
//		linLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//		LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)linLayout.getLayoutParams();
//		   params.setMargins(0, 50, 0, 0); 
//		   linLayout.setLayoutParams(params);
		//String s = "week"+n; 
		
		LinearLayout linLayout = new LinearLayout(this);
		//linLayout.setOrientation(LinearLayout.HORIZONTAL);
		//linLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		//linLayout.setId(n);
		
		
		RelativeLayout mondayLayout = new RelativeLayout(this);
		//String mon = s+"monday";
		//mondayLayout.setTag(mon.toString());
		//mondayLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		linLayout.addView(mondayLayout);
		
//		RelativeLayout tuesdayLayout = new RelativeLayout(this);
//		String tue = s+"tuesday";
//		//tuesdayLayout.setTag(tue.toString());
//		tuesdayLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//		linLayout.addView(tuesdayLayout);
//		
//		RelativeLayout wednesdayLayout = new RelativeLayout(this);
//		String wed = s+"wednesday";
//		//wednesdayLayout.setTag(wed.toString());
//		wednesdayLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//		linLayout.addView(wednesdayLayout);
//		
//		RelativeLayout thursdayLayout = new RelativeLayout(this);
//		String thu = s+"thursday";
//		//thursdayLayout.setTag(thu.toString());
//		thursdayLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//		linLayout.addView(thursdayLayout);
//		
//		RelativeLayout fridayLayout = new RelativeLayout(this);
//		String fri = s+"friday";
//		//fridayLayout.setTag(fri.toString());
//		fridayLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//		linLayout.addView(fridayLayout);
		return linLayout;
		
	}

}
