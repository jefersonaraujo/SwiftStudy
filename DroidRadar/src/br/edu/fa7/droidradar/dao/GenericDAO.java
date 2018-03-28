package br.edu.fa7.droidradar.dao;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public abstract class GenericDAO<T> {

	protected static final String DATABASE_NAME = "droidradar";
	protected static final int DATABASE_VERSION = 1;
	protected Context context;
	protected SQLiteHelper dbHelper;
	protected SQLiteDatabase db;
	
	public GenericDAO(Context context){
		this.context = context;
		dbHelper = new SQLiteHelper(context, DATABASE_NAME, DATABASE_VERSION);
		db = dbHelper.getWritableDatabase();
	}
	
	public abstract long insert(T obj);

	public abstract long update(T obj);
	
	public abstract long delete(T obj);
	
	public abstract T getById(Long id);
	
	public abstract List<T> getAll();
	
	protected abstract ContentValues createContextValues(T obj);
	
}
