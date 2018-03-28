package br.edu.fa7.droidradar.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {

	private static final String TAG = "DROID_RADAR";
	private Context context;
	private String name;
	private int version;

	public SQLiteHelper(Context context, String name, int version) {
		super(context, name, null, version);
		this.context = context;
		this.name = name;
		this.version = version;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		try {

			Log.i(TAG, "Initialize the database creation proccess");
			Log.i(TAG, "Database name: " + name);
			Log.i(TAG, "Database version: " + version);

			InputStream inputStream = context.getAssets()
					.open("droidradar.sql");

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(inputStream));

			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				db.execSQL(line);
				Log.i(TAG, "Executed SQL: " + line);
			}

			Log.i(TAG, "Finished the database creation proccess");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		if (newVersion > oldVersion) {

			Log.i(TAG, "Drop database version");
			db.execSQL("DROP TABLE IF EXISTS placemarks");
			db.execSQL("DROP TABLE IF EXISTS layers");

			onCreate(db);

		} else {
			Log.i(TAG, "Nothing to do!");
		}

	}

}
