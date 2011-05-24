package test1.example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DbAdapter {

	public static final String KEY_ROWID = "_id";
	public static final String KEY_DATE = "date";
	public static final String KEY_FOOD = "food";
	public static final String KEY_TRANSPORT = "transport";
	public static final String KEY_LAUNDRY = "LAUNDRY";
	public static final String KEY_TOTAL = "total";
	private static final String DATABASE_TABLE = "table12";
	public Context context;
	public SQLiteDatabase db;
	public DbHelper dbHelper;
	
	public DbAdapter(Context context) {
		this.context = context;
	}
	
	public DbAdapter open() throws SQLException {
		dbHelper = new DbHelper(context);
		db = dbHelper.getWritableDatabase();
		return this;
	}
	
	public void close() {
		dbHelper.close();
	}
	
	/**
	 * Create a new expense If the expense is successfully created return the new
	 * rowId for that note, otherwise return a -1 to indicate failure.
	 */
	public long createExpense(String date, Integer food, Integer transport, Integer laundry, Integer total ) {
		ContentValues values = new ContentValues();
		values.put(KEY_DATE, date);
		values.put(KEY_FOOD, food);
		values.put(KEY_TRANSPORT, transport);
		values.put(KEY_LAUNDRY, laundry);
		values.put(KEY_TOTAL, total);
		return db.insert(DATABASE_TABLE, null, values);
	}
	
	public Cursor fetchAllExpense() {
		return db.query(DATABASE_TABLE, new String[] { KEY_ROWID,
				KEY_DATE, KEY_FOOD, KEY_TRANSPORT,KEY_LAUNDRY,KEY_TOTAL }, null, null, null,
				null, null, null);
	}
	
	
}
