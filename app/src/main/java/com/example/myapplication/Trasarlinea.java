package com.example.myapplication;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.myapplication.Utils.Utils;


public class Trasarlinea extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap nMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trasarlinea);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        nMap = googleMap;
        nMap.setMyLocationEnabled(true);
        nMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        ArrayList<LatLng> points = null;
        PolylineOptions lineOptions = null;

        for(int i = 0; i< Utils.routes.size(); i++){
            Log.d("aqui", String.valueOf(Utils.routes.size()));
            points = new ArrayList<LatLng>();
            lineOptions = new PolylineOptions();
            List<HashMap<String, String>> path = Utils.routes.get(i);
            for(int j=0;j<path.size();j++){
                HashMap<String,String> point = path.get(j);

                double lat = Double.parseDouble(point.get("lat"));
                double lng = Double.parseDouble(point.get("lng"));
                LatLng position = new LatLng(lat, lng);

                points.add(position);
            }
            lineOptions.addAll(points);
            lineOptions.width(9);
            lineOptions.color(Color.BLUE);
        }
    }
}
