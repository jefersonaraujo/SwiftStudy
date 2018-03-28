package com.example.gcmtest;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String PREFERENCE_NAME = "App";
	private static final String TAG = "APP";
	private static final String SENDER_ID = "95355520525";
	private SharedPreferences preferences;
	private GoogleCloudMessaging gcm;
	private String registrarionId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		preferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);

		if (checkPlayService()) {
			gcm = GoogleCloudMessaging.getInstance(this);
			registrarionId = getRegistrarionId(this);

			if (registrarionId.isEmpty()) {
				registerInBackground();
			}
		} else {
			Log.w(TAG, "No valid Google Play Services APK found");
		}
	}

	private void registerInBackground() {
		new AsyncTask<Void, Void, String>(){

			@Override
			protected String doInBackground(Void... params) {
				
				String msg = "";
				
				try {
					if(gcm == null){
						gcm = GoogleCloudMessaging.getInstance(MainActivity.this);
					}
				registrarionId = gcm.register(SENDER_ID);
				msg = "Device registred, registrarion ID=" + registrarionId;
				
				preferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
				SharedPreferences.Editor editor = preferences.edit();
				editor.putString("registrarion_id", registrarionId);
				editor.commit();
				
				} catch (Exception e) {
					msg = "Error: " + e;
					e.printStackTrace();
				}
				return msg;
			}
			
			protected void onPostExecute(String result) {
				Log.i(TAG, result);
				Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
			}
			
		}.execute();
		
	}

	private String getRegistrarionId(Context context) {
		preferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
		String id = preferences.getString("registrarion_id", "");
		if (id.isEmpty()) {
			Log.i(TAG, "Registrarion not found");
		}

		return id;
	}

	private boolean checkPlayService() {
		int resultCode = GooglePlayServicesUtil
				.isGooglePlayServicesAvailable(this);

		if (resultCode != ConnectionResult.SUCCESS) {
			if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
				GooglePlayServicesUtil.getErrorDialog(resultCode, this, 9000)
						.show();
			} else {
				Log.e(TAG, "This device is not supported");
				finish();
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
