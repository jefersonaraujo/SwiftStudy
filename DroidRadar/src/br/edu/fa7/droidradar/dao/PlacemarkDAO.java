package br.edu.fa7.droidradar.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.edu.fa7.droidradar.model.Placemark;

public class PlacemarkDAO extends GenericDAO<Placemark> {

	private static final String TABLE_NAME = "placemarks";

	public PlacemarkDAO(Context context) {
		super(context);
	}

	@Override
	public long insert(Placemark obj) {
		return db.insert(TABLE_NAME, null, createContextValues(obj));
	}

	@Override
	public long update(Placemark obj) {
		return db.update(TABLE_NAME, createContextValues(obj), "_id = ?",
				new String[] { obj.getId().toString() });
	}

	@Override
	public long delete(Placemark obj) {
		return db.delete(TABLE_NAME, "_id = ?", new String[] { obj.getId()
				.toString() });
	}

	@Override
	public Placemark getById(Long id) {

		Placemark placemark = null;

		Cursor c = db.query(TABLE_NAME, null, "_id = ?",
				new String[] { id.toString() }, null, null, null);

		if (c.getCount() > 0) {

			c.moveToFirst();

			placemark = new Placemark();
			placemark.setId(c.getLong(0));
			placemark.setDescription(c.getString(1));
			placemark.setType(c.getString(2));
			placemark.setLongitude(c.getDouble(3));
			placemark.setLatitude(c.getDouble(4));
			placemark.setHeading(c.getInt(5));
			placemark.setRange(c.getInt(6));

		}

		return placemark;

	}

	@Override
	public List<Placemark> getAll() {

		List<Placemark> placemarks = null;

		Cursor c = db.query(TABLE_NAME, null, null, null, null, null, "_id");

		if (c.getCount() > 0) {

			placemarks = new ArrayList<Placemark>();

			while (c.moveToNext()) {

				Placemark placemark = new Placemark();

				// Set the attributes
				placemark.setId(c.getLong(0));
				placemark.setDescription(c.getString(1));
				placemark.setType(c.getString(2));
				placemark.setLongitude(c.getDouble(3));
				placemark.setLatitude(c.getDouble(4));
				placemark.setHeading(c.getInt(5));
				placemark.setRange(c.getInt(6));

				placemarks.add(placemark);

			}

		}

		return placemarks;
	}

	@Override
	protected ContentValues createContextValues(Placemark obj) {
		
		ContentValues values = new ContentValues();

		values.put("_id", obj.getId());
		values.put("description", obj.getDescription());
		values.put("type", obj.getType());
		values.put("longitude", obj.getLongitude());
		values.put("latitude", obj.getLatitude());
		values.put("heading", obj.getHeading());
		values.put("range", obj.getRange());

		return values;
	}

}
