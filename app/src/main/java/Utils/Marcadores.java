package Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

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

        uno(-11.99401543464486, -77.06063057630045,  "Chilis");
        dos(-12.076030243406363, -77.035886976451,  "Kfc");
        tres(-12.115008386815042, -77.03614172073505,  "Pizza Hut");
        cuatro(-12.0551371286709, -77.10183047310046,  "Popeyes");
        cinco(-12.057444582114298, -77.1400556832061,  "Little Caesars");
        seis(-12.049056059046421, -76.96340972716715,  "Rustica");

    }

    public void uno(Double latitud,Double longitud,String titulo){
        LatLng punto=new LatLng(latitud,longitud);
        int height = 140;
        int width = 165;
        BitmapDrawable uno=(BitmapDrawable)context.getResources().getDrawable(R.drawable.ic_location);
        Bitmap unos=uno.getBitmap();
        Bitmap uns=Bitmap.createScaledBitmap(unos,width,height,false);
        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo).snippet("uno")
                .icon(BitmapDescriptorFactory.fromBitmap(uns)));

    }

    public void dos(Double latitud,Double longitud,String titulo){
        LatLng punto=new LatLng(latitud,longitud);
        int height = 140;
        int width = 165;
        BitmapDrawable uno=(BitmapDrawable)context.getResources().getDrawable(R.drawable.ic_location);
        Bitmap unos=uno.getBitmap();
        Bitmap uns=Bitmap.createScaledBitmap(unos,width,height,false);
        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo).snippet("uno")
                .icon(BitmapDescriptorFactory.fromBitmap(uns)));

    }

    public void tres(Double latitud,Double longitud,String titulo){
        LatLng punto=new LatLng(latitud,longitud);
        int height = 140;
        int width = 165;
        BitmapDrawable uno=(BitmapDrawable)context.getResources().getDrawable(R.drawable.ic_location);
        Bitmap unos=uno.getBitmap();
        Bitmap uns=Bitmap.createScaledBitmap(unos,width,height,false);
        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo).snippet("uno")
                .icon(BitmapDescriptorFactory.fromBitmap(uns)));

    }
    public void cuatro(Double latitud,Double longitud,String titulo){
        LatLng punto=new LatLng(latitud,longitud);
        int height = 140;
        int width = 165;
        BitmapDrawable uno=(BitmapDrawable)context.getResources().getDrawable(R.drawable.ic_location);
        Bitmap unos=uno.getBitmap();
        Bitmap uns=Bitmap.createScaledBitmap(unos,width,height,false);
        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo).snippet("uno")
                .icon(BitmapDescriptorFactory.fromBitmap(uns)));

    }
    public void cinco(Double latitud,Double longitud,String titulo){
        LatLng punto=new LatLng(latitud,longitud);
        int height = 140;
        int width = 165;
        BitmapDrawable uno=(BitmapDrawable)context.getResources().getDrawable(R.drawable.ic_location);
        Bitmap unos=uno.getBitmap();
        Bitmap uns=Bitmap.createScaledBitmap(unos,width,height,false);
        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo).snippet("uno")
                .icon(BitmapDescriptorFactory.fromBitmap(uns)));

    }
    public void seis(Double latitud,Double longitud,String titulo){
        LatLng punto=new LatLng(latitud,longitud);
        int height = 140;
        int width = 165;
        BitmapDrawable uno=(BitmapDrawable)context.getResources().getDrawable(R.drawable.ic_location);
        Bitmap unos=uno.getBitmap();
        Bitmap uns=Bitmap.createScaledBitmap(unos,width,height,false);
        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo).snippet("uno")
                .icon(BitmapDescriptorFactory.fromBitmap(uns)));

    }
}
