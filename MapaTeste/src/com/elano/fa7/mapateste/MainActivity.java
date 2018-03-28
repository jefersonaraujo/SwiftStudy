package com.elano.fa7.mapateste;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity 
{

	private GoogleMap map;
	private LocationManager manager;
	private NetworkUtil network;
	
	private LocationListener locationListener = new LocationListener() {
		
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onLocationChanged(Location location) {
			updateMyPosition(location);
			updateMarker(location);
			
		}

		private void updateMyPosition(Location location) {
			LatLng position = new LatLng(location.getLatitude(), location.getLongitude());
			CameraPosition cameraPosition = CameraPosition.builder() 
					.target(position)
					.bearing(0)
					.tilt(0)
					.zoom(10)
					.build();
			CameraUpdate update = CameraUpdateFactory.newCameraPosition(cameraPosition);
			map.animateCamera(update);
			
		}
		
		private void updateMarker(Location location){
			double lat = location.getLatitude() + 0.5;
			double lon = location.getLongitude() + 0.5;
			
			MarkerOptions markerOptions = new MarkerOptions();
			markerOptions.position(new LatLng(lat, lon));
			markerOptions.title("Marcador de teste");
			
			map.clear();
			map.addMarker(markerOptions);
			
		}
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        network = NetworkUtil.getInstance();
        map =  ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        map.setMyLocationEnabled(true);
        manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        
        network.ping("www.google.com");
        
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
    }
    
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    	manager.removeUpdates(locationListener);
    }



    
}
