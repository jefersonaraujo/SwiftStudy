package com.example.aulaext;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

	private TextView valueX, valueY, valueZ;
	private float x, y, z;
	private float accelX, accelY, accelZ;
	private float proxValue;
	private float xNoGravity, yNoGravity, zNoGravity;
	private SensorManager manager;
	private Sensor accelerometer, prox;
	private Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		valueX = (TextView) findViewById(R.id.tvValorX);
		valueY = (TextView) findViewById(R.id.tvValorY);
		valueZ = (TextView) findViewById(R.id.tvValorZ);

		handler = new Handler();

		manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		accelerometer = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		prox = manager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

	}

	@Override
	protected void onPause() {
		super.onPause();
		manager.unregisterListener(this, accelerometer);
	}

	@Override
	protected void onResume() {
		super.onResume();
		manager.registerListener(this, accelerometer,
				SensorManager.SENSOR_DELAY_NORMAL);
		manager.registerListener(this, prox, SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSensorChanged(SensorEvent event) {

		if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
			proxValue = event.values[0];
			
			if(proxValue >= prox.getMaximumRange()){
				//Ativar e desativar musica
			}
		}
		
		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			
			final double offSet = 10.0;
			
			x = event.values[0];
			y = event.values[1];
			z = event.values[2];
			
			double alpha1 = Math.sqrt(x + y + z);
			
			if(alpha1 >= offSet){
				//Mudar de musica
			}
			
/*			float alpha = 0.0f;

			x = x * alpha - (1 - alpha) * event.values[0];
			y = y * alpha - (1 - alpha) * event.values[1];
			z = z * alpha - (1 - alpha) * event.values[2];

			accelX = x - xNoGravity;
			accelX = y - yNoGravity;
			accelZ = z - zNoGravity;*/

			handler.post(new UpdateUi());
		}
	}

	private class UpdateUi implements Runnable {

		@Override
		public void run() {
			valueX.setText("Value X: " + String.valueOf(x));
			valueY.setText("Value X: " + String.valueOf(y));
			valueZ.setText("Value X: " + String.valueOf(z));
		}

	}

}
