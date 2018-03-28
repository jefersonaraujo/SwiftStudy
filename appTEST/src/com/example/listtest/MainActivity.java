package com.example.listtest;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.TaskStackBuilder;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity{
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	public void onClick(View v) {
		Intent i = new Intent(this, NotActivity.class);
		TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
		taskStackBuilder.addNextIntent(i);
		Builder notBuilder = new NotificationCompat.Builder(this);
		notBuilder.setSmallIcon(android.R.drawable.ic_menu_share);
		notBuilder.setContentTitle("Notification Arrived.");
		notBuilder.setContentIntent(taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT));
		switch (v.getId()) {
			case R.id.button1:
				notBuilder.setContentText("Text of the notification small.");
				break;
			case R.id.button2:
				notBuilder.setContentText("Text of the notification big.");
				NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
				inboxStyle.setBigContentTitle("Big Context title");
				notBuilder.setStyle(inboxStyle);
				break;
		default:
			break;
		}
		NotificationManager notMgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		notMgr.notify(1, notBuilder.build());
	}

}
