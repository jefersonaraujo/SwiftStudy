package com.example.gcmtest;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class GcmIntentService extends IntentService {

	public GcmIntentService(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {

		Bundle extras = intent.getExtras();
		GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);

		String messageType = gcm.getMessageType(intent);

		if (!extras.isEmpty()) {

			if (GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR
					.equals(messageType)) {

				Log.e("APP", "ERROR");

			}
			if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {

				Log.e("APP", "MESSAGE");

			}
			if (GoogleCloudMessaging.MESSAGE_TYPE_DELETED.equals(messageType)) {

				Log.w("APP", "DELETED");

			}
		}

		GcmBroadcastReceiver.completeWakefulIntent(intent);

	}

}
