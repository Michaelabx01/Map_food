package com.example.myapplication.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.example.myapplication.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Marcadores {
    GoogleMap nMap;
    Context context;

    public Marcadores(GoogleMap nMap, Context context) {
        this.nMap = nMap;
        this.context = context;
    }
    public void addMarkersDefault(){
//        uno(-11.993470, -77.059171,  "Chilis");
        uno(-11.993470, -77.059171,  "Chilis");
//        dos(-12.076010, -77.035823,  "Kfc");
//        tres(-12.114871, -77.036139,  "Pizza Hut");
//        cuatro(-12.054436, -77.102034,  "Popeyes");
//        cinco(-12.057478, -77.140105,  "Little Caesars");
//        seis(-12.049020, -76.963323,  "Rustica");
    }

    public void uno(Double latitud,Double longitud,String titulo){
        LatLng punto=new LatLng(latitud,longitud);
        int height = 500;
        int width = 500;

        Drawable drawable = context.getResources().getDrawable(R.drawable.ic_location, context.getApplicationContext().getTheme());

        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap bitmapEscalado = Bitmap.createScaledBitmap(bitmap, width, height, false);
            nMap.addMarker(new MarkerOptions()
                    .position(punto)
                    .title(titulo).snippet("uno")
                    .icon(BitmapDescriptorFactory.fromBitmap(bitmapEscalado)));
        } else {
            // Si es un VectorDrawable, manejarlo de manera diferente o lanzar una excepción
            // Dependiendo de tus necesidades.
        }
//        BitmapDrawable uno=(BitmapDrawable)context.getResources().getDrawable(R.drawable.ic_location, context.getApplicationContext().getTheme());
//        Bitmap unos=uno.getBitmap();
//        Bitmap uns=Bitmap.createScaledBitmap(unos,width,height,false);
//        nMap.addMarker(new MarkerOptions()
//                .position(punto)
//                .title(titulo).snippet("uno")
//                .icon(BitmapDescriptorFactory.fromBitmap(uns)));

    }

    public void dos(Double latitud,Double longitud,String titulo){
        LatLng punto=new LatLng(latitud,longitud);
        int height = 140;
        int width = 165;
        Drawable drawable = context.getResources().getDrawable(R.drawable.ic_location, context.getApplicationContext().getTheme());

        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap bitmapEscalado = Bitmap.createScaledBitmap(bitmap, width, height, false);
            nMap.addMarker(new MarkerOptions()
                    .position(punto)
                    .title(titulo).snippet("uno")
                    .icon(BitmapDescriptorFactory.fromBitmap(bitmapEscalado)));
        } else {
            // Si es un VectorDrawable, manejarlo de manera diferente o lanzar una excepción
            // Dependiendo de tus necesidades.
        }

//        BitmapDrawable uno=(BitmapDrawable)context.getResources().getDrawable(R.drawable.ic_location, context.getApplicationContext().getTheme());
//        Bitmap unos=uno.getBitmap();
//        Bitmap uns=Bitmap.createScaledBitmap(unos,width,height,false);
//        nMap.addMarker(new MarkerOptions()
//                .position(punto)
//                .title(titulo).snippet("uno")
//                .icon(BitmapDescriptorFactory.fromBitmap(uns)));

    }

    public void tres(Double latitud,Double longitud,String titulo){
        LatLng punto=new LatLng(latitud,longitud);
        int height = 140;
        int width = 165;
        Drawable drawable = context.getResources().getDrawable(R.drawable.ic_location, context.getApplicationContext().getTheme());

        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap bitmapEscalado = Bitmap.createScaledBitmap(bitmap, width, height, false);
            nMap.addMarker(new MarkerOptions()
                    .position(punto)
                    .title(titulo).snippet("uno")
                    .icon(BitmapDescriptorFactory.fromBitmap(bitmapEscalado)));
        } else {
            // Si es un VectorDrawable, manejarlo de manera diferente o lanzar una excepción
            // Dependiendo de tus necesidades.
        }
//        BitmapDrawable uno=(BitmapDrawable)context.getResources().getDrawable(R.drawable.ic_location, context.getApplicationContext().getTheme());
//        Bitmap unos=uno.getBitmap();
//        Bitmap uns=Bitmap.createScaledBitmap(unos,width,height,false);
//        nMap.addMarker(new MarkerOptions()
//                .position(punto)
//                .title(titulo).snippet("uno")
//                .icon(BitmapDescriptorFactory.fromBitmap(uns)));

    }
    public void cuatro(Double latitud,Double longitud,String titulo){
        LatLng punto=new LatLng(latitud,longitud);
        int height = 140;
        int width = 165;
        Drawable drawable = context.getResources().getDrawable(R.drawable.ic_location, context.getApplicationContext().getTheme());

        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap bitmapEscalado = Bitmap.createScaledBitmap(bitmap, width, height, false);
            nMap.addMarker(new MarkerOptions()
                    .position(punto)
                    .title(titulo).snippet("uno")
                    .icon(BitmapDescriptorFactory.fromBitmap(bitmapEscalado)));
        } else {
            // Si es un VectorDrawable, manejarlo de manera diferente o lanzar una excepción
            // Dependiendo de tus necesidades.
        }
//        BitmapDrawable uno=(BitmapDrawable)context.getResources().getDrawable(R.drawable.ic_location, context.getApplicationContext().getTheme());
//        Bitmap unos=uno.getBitmap();
//        Bitmap uns=Bitmap.createScaledBitmap(unos,width,height,false);
//        nMap.addMarker(new MarkerOptions()
//                .position(punto)
//                .title(titulo).snippet("uno")
//                .icon(BitmapDescriptorFactory.fromBitmap(uns)));

    }
    public void cinco(Double latitud,Double longitud,String titulo){
        LatLng punto=new LatLng(latitud,longitud);
        int height = 140;
        int width = 165;
        Drawable drawable = context.getResources().getDrawable(R.drawable.ic_location, context.getApplicationContext().getTheme());

        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap bitmapEscalado = Bitmap.createScaledBitmap(bitmap, width, height, false);
            nMap.addMarker(new MarkerOptions()
                    .position(punto)
                    .title(titulo).snippet("uno")
                    .icon(BitmapDescriptorFactory.fromBitmap(bitmapEscalado)));
        } else {
            // Si es un VectorDrawable, manejarlo de manera diferente o lanzar una excepción
            // Dependiendo de tus necesidades.
        }
//        BitmapDrawable uno=(BitmapDrawable)context.getResources().getDrawable(R.drawable.ic_location, context.getApplicationContext().getTheme());
//        Bitmap unos=uno.getBitmap();
//        Bitmap uns=Bitmap.createScaledBitmap(unos,width,height,false);
//        nMap.addMarker(new MarkerOptions()
//                .position(punto)
//                .title(titulo).snippet("uno")
//                .icon(BitmapDescriptorFactory.fromBitmap(uns)));

    }
    public void seis(Double latitud,Double longitud,String titulo){
        LatLng punto=new LatLng(latitud,longitud);
        int height = 140;
        int width = 165;
        Drawable drawable = context.getResources().getDrawable(R.drawable.ic_location, context.getApplicationContext().getTheme());

        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap bitmapEscalado = Bitmap.createScaledBitmap(bitmap, width, height, false);
            nMap.addMarker(new MarkerOptions()
                    .position(punto)
                    .title(titulo).snippet("uno")
                    .icon(BitmapDescriptorFactory.fromBitmap(bitmapEscalado)));
        } else {
            // Si es un VectorDrawable, manejarlo de manera diferente o lanzar una excepción
            // Dependiendo de tus necesidades.
        }
//        BitmapDrawable uno=(BitmapDrawable)context.getResources().getDrawable(R.drawable.ic_location, context.getApplicationContext().getTheme());
//        Bitmap unos=uno.getBitmap();
//        Bitmap uns=Bitmap.createScaledBitmap(unos,width,height,false);
//        nMap.addMarker(new MarkerOptions()
//                .position(punto)
//                .title(titulo).snippet("uno")
//                .icon(BitmapDescriptorFactory.fromBitmap(uns)));

    }
}
