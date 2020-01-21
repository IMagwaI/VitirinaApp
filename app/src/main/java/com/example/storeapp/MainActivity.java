package com.example.storeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment =(SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng StoreRiad = new LatLng(33.954110,-6.8540982);
        map.addMarker( new MarkerOptions().position(StoreRiad).title("Store 1 "));
        map.moveCamera(CameraUpdateFactory.newLatLng(StoreRiad));
        googleMap.getUiSettings().setScrollGesturesEnabled(false); // locked screen xd
        googleMap.setMaxZoomPreference(14.0f);
        googleMap.setMinZoomPreference(11.0f);

        LatLng StoreBour = new LatLng(34.0194205,-6.8169564);
        //map.addMarker( new MarkerOptions().position(StoreBour).title("Store2"));
        //map.moveCamera(CameraUpdateFactory.newLatLng(StoreBour));
        MarkerOptions options = new MarkerOptions().position(StoreBour).title("Store 2");
        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        map.addMarker(options);
    }
}
