package com.example.listtest;

import android.os.Bundle;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;

public class NotActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not);

		NotificationManager notMgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notMgr.cancel(1);
    }

	@Override
	public void onBackPressed() {
		Intent i = new Intent(this, MainActivity.class);
		startActivity(i);
		super.onBackPressed();
	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.not, menu);
        return true;
    }
    
}
