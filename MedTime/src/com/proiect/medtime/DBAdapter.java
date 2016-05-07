package com.proiect.medtime;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter {

	DBHelper dbHelper;
	

	public DBAdapter(Context context) {

		dbHelper = new DBHelper(context);

	}

	class DBHelper extends SQLiteOpenHelper {

		private static final String DATABASE_NAME = "pacients.db";
		private static final String TABLE_NAME = "Pacients";
		static final String NAME = "Name";
		static final String AGE = "Age";
		static final String CRONIC = "Cronic_Conditions";
		static final String KEY_ROWID = "_id";
		private static final int DATABASE_VERSION = 1;
		private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
				+ " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ NAME + " VARCHAR(255), " + AGE + " INTEGER, " + CRONIC
				+ " VARCHAR(255));";
		private static final String DROP_TABLE = "DROP TABLE IF EXISTS"
				+ TABLE_NAME;
		private Context context;

		public DBHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			this.context = context;
		}

		@Override
		public void onCreate(SQLiteDatabase db) {

			try {
				db.execSQL(CREATE_TABLE);
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

			try {
				db.execSQL(DROP_TABLE);
				onCreate(db);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}// end inner class

	
	public DBAdapter open() throws SQLException {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		dbHelper.close();
	}

	// INSERT INTO DATABASE
	public long insert(String name,int age, String cronic) {
		
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues initialValues = new ContentValues();
		initialValues.put(DBHelper.NAME, name);
		initialValues.put(DBHelper.AGE, age);
		initialValues.put(DBHelper.CRONIC, cronic);
		return db.insert(DBHelper.TABLE_NAME, null, initialValues);//if = -1 insert failed
		
	}
	
	
//	public List<Pacient> getAllData(){
//		
//		List<Pacient> pacientList = new ArrayList<Pacient>();
//		SQLiteDatabase db = dbHelper.getWritableDatabase();
//		
//		String[] columns ={DBHelper.NAME,DBHelper.AGE,DBHelper.CRONIC};
//		Cursor cursor = db.query(DBHelper.TABLE_NAME, columns, null, null, null, null, null);
//		while(cursor.moveToNext())
//		{
//			Pacient pacient = new Pacient();
//			
//			int index_nume = cursor.getColumnIndex(DBHelper.NAME);
//			int index_age = cursor.getColumnIndex(DBHelper.AGE);
//			int index_cronic = cursor.getColumnIndex(DBHelper.CRONIC);
//			
//			String name = cursor.getString(index_nume);
//			int age = cursor.getInt(index_age);
//			String cronic = cursor.getString(index_cronic);
//			
//			pacient.setName(name);
//			pacient.setAge(age);
//			pacient.setCronic(cronic);
//			
//			pacientList.add(pacient);
//						
//		}
//		return pacientList;
//		
//	}
	
	public int deletePacient(String name_param){
		
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String[] whereArgs = {name_param};
		int count = db.delete(DBHelper.TABLE_NAME,DBHelper.NAME+"=?",whereArgs );
		db.close();
		return count;
	}
	
	public Cursor queryName() {
		
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String[] columns ={DBHelper.KEY_ROWID,DBHelper.NAME,DBHelper.AGE,DBHelper.CRONIC};
		Cursor cursor = db.query(DBHelper.TABLE_NAME, columns, null, null, null, null, null);

		return cursor;

	}
	

}
