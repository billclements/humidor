package com.TDD.Humidor;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
	private static final String DBNAME = "HumidorDB";
	private static final int DBVERSION = 1;
	
	//The table 
	public static final String DBTABLE = "InventoryTable";	
	// The primary key
	public static final String KEY = "_id";
	// Column headings
	public static final String BRAND = "Brand";
	public static final String TYPE = "Type";
	public static final String WRAPPER = "Wrapper";
	public static final String VITOLA =	"Vitola";
	public static final String QUANTITY ="Quantity";
	
	
	// SQL Statement to create a new database.
	private static final String CREATE_DB = "create table " +
	DBTABLE + " (" + KEY + " integer primary key autoincrement, " +
	BRAND + " varchar, " +
	TYPE + " varchar, " +
	WRAPPER + " varchar, " +
	VITOLA + " varchar, " +
	QUANTITY + " integer);";
	
	// Sting[] of columns not including the _id
	//to be used for queries
	String[] columns = new String[]{BRAND, TYPE, WRAPPER, VITOLA, QUANTITY};

	public DbHelper(Context context) {
		super(context, DBNAME, null, DBVERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//uses the String made earlier to create the db
		db.execSQL(CREATE_DB);
		
		//Following code block will provide sample data
		//It should be deleted or commented out upon completion		
		SQLiteDatabase d = this.getWritableDatabase();

	    ContentValues values = new ContentValues();
	    
	    values.put(BRAND, "Perdomo");
	    values.put(TYPE, "Lot 23");
	    values.put(WRAPPER, "Connecticut");
	    values.put(VITOLA, "Robusto");
	    values.put(QUANTITY, 5);
	    d.insert(DBTABLE, null, values);
	    
	    values.put(BRAND, "Alec Bradley");
	    values.put(TYPE, "Tempus");
	    values.put(WRAPPER, "Natural");
	    values.put(VITOLA, "Toro");
	    values.put(QUANTITY, 5);
	    d.insert(DBTABLE, null, values);
	    
	    values.put(BRAND, "5 Vegas");
	    values.put(TYPE, "Miami");
	    values.put(WRAPPER, "Habano");
	    values.put(VITOLA, "Toro");
	    values.put(QUANTITY, 10);
	    d.insert(DBTABLE, null, values);
		
	    values.put(BRAND, "5 Vegas");
	    values.put(TYPE, "Triple-A");
	    values.put(WRAPPER, "Maduro");
	    values.put(VITOLA, "Lancero");
	    values.put(QUANTITY, 5);
	    d.insert(DBTABLE, null, values);
	    
	    values.put(BRAND, "Perdomo");
	    values.put(TYPE, "Habano");
	    values.put(WRAPPER, "Connecticut");
	    values.put(VITOLA, "Toro");
	    values.put(QUANTITY, 15);
	    d.insert(DBTABLE, null, values);
	    
	    values.put(BRAND, "Man O' War");
	    values.put(TYPE, "Ruination");
	    values.put(WRAPPER, "Natural");
	    values.put(VITOLA, "Robusto");
	    values.put(QUANTITY, 12);
	    d.insert(DBTABLE, null, values);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// This seems like it will just destroy all the old
		//data, there has to be a better way....
		db.execSQL("DROP TABLE IF IT EXISTS " + DBTABLE);
		// Create a new one.
		onCreate(db);
		
	}
	       
	
}
