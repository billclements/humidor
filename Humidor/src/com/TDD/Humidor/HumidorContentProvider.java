package com.TDD.Humidor;

import java.util.Arrays;
import java.util.HashSet;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

public class HumidorContentProvider extends ContentProvider {
	
	//database
	private DbHelper dataBase;
	
	// Used for the UriMacher
	private static final int CIGAR = 10;
	private static final int CIGAR_ID = 20;


	private static final String AUTHORITY = "com.TDD.Humidor";

	private static final String BASE_PATH = "TDD";
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
	    + "/" + BASE_PATH);

	public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
	    + "/TDD";
	public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
	    + "/TDD";

	private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	static {
	  sURIMatcher.addURI(AUTHORITY, BASE_PATH, CIGAR);
	  sURIMatcher.addURI(AUTHORITY, BASE_PATH + "/#", CIGAR_ID);
	}
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
	    int uriType = sURIMatcher.match(uri);
	    SQLiteDatabase sqlDB = dataBase.getWritableDatabase();
	    int rowsDeleted = 0;
	    switch (uriType) {
	    case CIGAR:
	      rowsDeleted = sqlDB.delete(DbHelper.DBTABLE, selection,
	          selectionArgs);
	      break;
	    case CIGAR_ID:
	      String id = uri.getLastPathSegment();
	      if (TextUtils.isEmpty(selection)) {
	        rowsDeleted = sqlDB.delete(DbHelper.DBTABLE,
	            DbHelper.KEY + "=" + id, null);
	      } else {
	        rowsDeleted = sqlDB.delete(DbHelper.DBTABLE,
	            DbHelper.KEY + "=" + id 
	            + " and " + selection,
	            selectionArgs);
	      }
	      break;
	    default:
	      throw new IllegalArgumentException("Unknown URI: " + uri);
	    }
	    getContext().getContentResolver().notifyChange(uri, null);
	    return rowsDeleted;
	  }

	@Override
	public String getType(Uri uri) {
		return null;
	}
	
	@Override
	public Uri insert(Uri uri, ContentValues values) {
	    int uriType = sURIMatcher.match(uri);
	    SQLiteDatabase sqlDB = dataBase.getWritableDatabase();
	    //int rowsDeleted = 0;  commented out to get rid of warning
	    long id = 0;
	    switch (uriType) {
	    case CIGAR:
	        id = sqlDB.insert(DbHelper.DBTABLE, null, values);
	        break;
	    default:
	        throw new IllegalArgumentException("Unknown URI: " + uri);
	    }
	    getContext().getContentResolver().notifyChange(uri, null);
	    return Uri.parse(BASE_PATH + "/" + id);
	  }

	
	@Override
	  public boolean onCreate() {
	    dataBase = new DbHelper(getContext());
	    return false;
	  }

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
	    String[] selectionArgs, String sortOrder) {

	  // Using SQLiteQueryBuilder instead of query() method
	    SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

	    // Check if the caller has requested a column which does not exists
	    checkColumns(projection);

	    // Set the table
	    queryBuilder.setTables(DbHelper.DBTABLE);

	    int uriType = sURIMatcher.match(uri);
	    switch (uriType) {
	    case CIGAR:
	      break;
	    case CIGAR_ID:
	      // Adding the ID to the original query
	      queryBuilder.appendWhere(DbHelper.KEY + "="
	          + uri.getLastPathSegment());
	      break;
	    default:
	      throw new IllegalArgumentException("Unknown URI: " + uri);
	      }
	    SQLiteDatabase db = dataBase.getWritableDatabase();
	    Cursor cursor = queryBuilder.query(db, projection, selection,
	        selectionArgs, null, null, sortOrder);
	    // Make sure that potential listeners are getting notified
	    cursor.setNotificationUri(getContext().getContentResolver(), uri);

	    return cursor;
	  }
	    

	@Override
	public int update(Uri uri, ContentValues values, String selection,
		      String[] selectionArgs) {

        int uriType = sURIMatcher.match(uri);
		SQLiteDatabase sqlDB = dataBase.getWritableDatabase();
		int rowsUpdated = 0;
		switch (uriType) {
		case CIGAR:
		  rowsUpdated = sqlDB.update(DbHelper.DBTABLE, values, selection, selectionArgs);
		  break;
		case CIGAR_ID:
		  String id = uri.getLastPathSegment();
		  if (TextUtils.isEmpty(selection)) {
		      rowsUpdated = sqlDB.update(DbHelper.DBTABLE, values, 
		    		  DbHelper.KEY + "=" + id, null);
		   }
		  else {
		    rowsUpdated = sqlDB.update(DbHelper.DBTABLE, values,
		    		DbHelper.KEY + "=" + id  + " and " + selection, selectionArgs);
		 }
		  break;
		default:
		  throw new IllegalArgumentException("Unknown URI: " + uri);
		}
		getContext().getContentResolver().notifyChange(uri, null);
		return rowsUpdated;
    }
	
	private void checkColumns(String[] projection) {
	   String[] available = { DbHelper.KEY, DbHelper.BRAND, DbHelper.TYPE,
	        DbHelper.WRAPPER, DbHelper.VITOLA, DbHelper.QUANTITY };
	    if (projection != null) {
	      HashSet<String> requestedColumns = new HashSet<String>(Arrays.asList(projection));
	      HashSet<String> availableColumns = new HashSet<String>(Arrays.asList(available));
	      // Check if all columns which are requested are available
	      if (!availableColumns.containsAll(requestedColumns)) {
	        throw new IllegalArgumentException("Unknown columns in projection");
	      }
	    }
	  }

}
