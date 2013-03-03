package com.TDD.Humidor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DbDAO {
    // Database fields
	private SQLiteDatabase database;
	private DbHelper dbHelper;
	
	//Strings used in SQL statements
    private static final String table = DbHelper.DBTABLE;
	private String[] allColumns = {DbHelper.KEY, DbHelper.BRAND, DbHelper.TYPE,
	    DbHelper.WRAPPER, DbHelper.VITOLA, DbHelper.QUANTITY};

	//constructor  
	public DbDAO(Context context) {
		dbHelper = new DbHelper(context);
	}
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

	public void close() {
	    dbHelper.close();
	}
	
	
	
	
    public void addCigar(String[] cigarInfo){
	    //load the values from the string into a ContentValues object
		//Should this be taking from Cursor instead???
		ContentValues values = new ContentValues();
		values.put(DbHelper.BRAND, cigarInfo[0]);
		values.put(DbHelper.TYPE, cigarInfo[1]);
		values.put(DbHelper.WRAPPER, cigarInfo[2]);
		values.put(DbHelper.VITOLA, cigarInfo[3]);
		values.put(DbHelper.QUANTITY, Integer.parseInt(cigarInfo[4]));
		
		//now an insert statement to create the row
		try {
			database.insert(DbHelper.DBTABLE, null, values);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
    }
    
    
    
    public Cursor getCigarTable() { 
    	Cursor cursor;
		    cursor =  database.query(table, allColumns, null, null,
		    		null, null, allColumns[1]);
		    //this should return all rows in the table, might switch it to not return
		    //any rows where the Quantity == 0, but then again I might like to see
		    //that there was a stick that I had that I am out of...
		return cursor;
	}
    public int getID(String[] cigarInfo){
    	//This method is meant to return the integer value KEY field of
    	//a row. It takes the String[] from a displayed row as its argument.
    	//The id could then be used in the upDateQuantity method
    	Cursor cursor;
    	
    	ContentValues values = new ContentValues();
		values.put(DbHelper.BRAND, cigarInfo[0]);
		values.put(DbHelper.TYPE, cigarInfo[1]);
		values.put(DbHelper.WRAPPER, cigarInfo[2]);
		values.put(DbHelper.VITOLA, cigarInfo[3]);
		values.put(DbHelper.QUANTITY, Integer.parseInt(cigarInfo[4]));
		
		
		
		String where = "DbHelper.BRAND=? AND " +
				"DbHelper.TYPE=? AND DbHelper.WRAPPER=? AND DbHelper.VITOLA=? " +
				"AND DbHelper.QUANTITY=?";
		String[] args = {cigarInfo[0], cigarInfo[1], cigarInfo[2], 
				cigarInfo[3], cigarInfo[4]};
		try {
			cursor = database.query(table, allColumns, where, args, null, null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			cursor = null;
		}
		
		//this should return the integer value of the KEY column, as it is the 
		//first column (0) in the table
		return cursor.getInt(0);
    }
    
	public void updateQuantity(int id, int quantity){
		//takes the _id of the row and the new quantity
		//and updates the quantity for that particular _id
		ContentValues values = new ContentValues();
		values.put("QUANTITY", quantity);
		//I believe this will just swap the old quantity
		//with the new quantity
		String where = "DbHelper.KEY=?";
		String[] args = {String.valueOf(id)};
		try {
			database.update(table, values, where, args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
	
}//end of class
