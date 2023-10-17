package com.example.myapplication;

import static com.example.myapplication.Utils.Utils.coordenadas;
import static com.example.myapplication.Utils.Utils.markersDefault;
import static com.example.myapplication.Utils.Utils.routes;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Utils.GPS_controler;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Maps_food extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener, GoogleMap.OnMapClickListener, GoogleMap.OnMarkerClickListener {

    Context context;
    GoogleMap nMap;
    JsonObjectRequest jsonObjectRequest;
    RequestQueue request;
    Location location;
    GPS_controler gpsTracker;
    double latitudeGlobalOrigin = 0;
    double longitudeGlobalOrigin = 0;
    private FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_food);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getLocation();
        } else {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
        }


        gpsTracker = new GPS_controler(getApplicationContext());
//        SupportMapFragment mapFragmaent=(SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragmaent.getMapAsync(  this);
        request = Volley.newRequestQueue(getApplicationContext());


    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.getLastLocation()
                .addOnCompleteListener(this, new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        if (task.isSuccessful() && task.getResult() != null) {
                            Location lastLocation = task.getResult();
                            double latitude = lastLocation.getLatitude();
                            double longitude = lastLocation.getLongitude();
                            Log.i("LOCATION------------ >", "Latitud: " + latitude +" Longitud: " + longitude);
                            // Aquí puedes utilizar 'latitude' y 'longitude'
                            latitudeGlobalOrigin = latitude;
                            longitudeGlobalOrigin = longitude;

                        }
                    }
                });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        nMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        nMap.setMyLocationEnabled(true);
        LatLng we = new LatLng(-11.9375836458254, -77.06901738170907);
        LatLng we2 = new LatLng(-12.023637768777364, -77.00172613667773);
        LatLng we3 =new LatLng(-12.014182185677132, -77.09715986935018);
        LatLng we4 =new LatLng(-11.967753412312058, -77.0712759685157);
        LatLng w5 =new LatLng(-11.995790286615186, -77.11934121573613);
        LatLng w6 =new LatLng(-12.091599750579848, -77.02586170675298);

        Bitmap originalBitmapKFC = BitmapFactory.decodeResource(getResources(), R.drawable.ic_kfc);

        Bitmap originalBitmapPopeyes = BitmapFactory.decodeResource(getResources(), R.drawable.ic_popeyes);

        Bitmap originalBitmapPizzahub = BitmapFactory.decodeResource(getResources(), R.drawable.ic_pizzahub);

        Bitmap originalBitmapBurgerking = BitmapFactory.decodeResource(getResources(), R.drawable.ic_burguerking);

        Bitmap originalBitmapMcDonalds = BitmapFactory.decodeResource(getResources(), R.drawable.ic_macdonals);

        Bitmap originalBitmapChilis = BitmapFactory.decodeResource(getResources(), R.drawable.ic_chilis);


        int width = 70;
        int height = 70;

        // Resize the original images
        Bitmap resizedBitmapKFC = Bitmap.createScaledBitmap(originalBitmapKFC, width, height, false);
        Bitmap resizedBitmapPopeyes = Bitmap.createScaledBitmap(originalBitmapPopeyes, width, height, false);
        Bitmap resizedBitmapPizzahub = Bitmap.createScaledBitmap(originalBitmapPizzahub, width, height, false);
        Bitmap resizedBitmapBurgerking = Bitmap.createScaledBitmap(originalBitmapBurgerking, width, height, false);
        Bitmap resizedBitmapMcDonalds = Bitmap.createScaledBitmap(originalBitmapMcDonalds, width, height, false);
        Bitmap resizedBitmapChilis = Bitmap.createScaledBitmap(originalBitmapChilis, width, height, false);

        // Create the BitmapDescriptor from the resized images
        BitmapDescriptor iconKFC = BitmapDescriptorFactory.fromBitmap(resizedBitmapKFC);
        BitmapDescriptor iconPopeyes = BitmapDescriptorFactory.fromBitmap(resizedBitmapPopeyes);
        BitmapDescriptor iconPizzahub = BitmapDescriptorFactory.fromBitmap(resizedBitmapPizzahub);
        BitmapDescriptor iconBurgerking = BitmapDescriptorFactory.fromBitmap(resizedBitmapBurgerking);
        BitmapDescriptor iconMcDonalds = BitmapDescriptorFactory.fromBitmap(resizedBitmapMcDonalds);
        BitmapDescriptor iconChilis = BitmapDescriptorFactory.fromBitmap(resizedBitmapChilis);

        nMap.addMarker(new MarkerOptions()
                .position(we)
                .title("KFC")
                .icon(iconKFC));

        nMap.addMarker(new MarkerOptions()
                .position(we2)
                .title("Popeyes")
                .icon(iconPopeyes));

        nMap.addMarker(new MarkerOptions()
                .position(we3)
                .title("Pizza Hub")
                .icon(iconPizzahub));

        nMap.addMarker(new MarkerOptions()
                .position(we4)
                .title("Burger King")
                .icon(iconBurgerking));

        nMap.addMarker(new MarkerOptions()
                .position(w5)
                .title("McDonalds")
                .icon(iconMcDonalds));

        nMap.addMarker(new MarkerOptions()
                .position(w6)
                .title("Chilis")
                .icon(iconChilis));


        nMap.moveCamera(CameraUpdateFactory.newLatLng(we));

        markersDefault(nMap, getApplicationContext());
        nMap.setOnMapClickListener(this);
        nMap.setOnMarkerClickListener(this);
    }

    @Override
    public void onMapLongClick(LatLng latLng) {

    coordenadas.setOrigenLat(latLng.latitude);
    coordenadas.setDestinoLat(latLng.longitude);
        Toast.makeText(Maps_food.this, "toque icono para que selecciones", Toast.LENGTH_LONG).show();


    }

    @Override
    public void onRequestPermissionsResult(final int requestCode, @NonNull final String[] permissions, @NonNull final int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 123) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocation();
            } else {

                Toast.makeText(this, "You didn't give permission to access device location", Toast.LENGTH_LONG).show();
                startInstalledAppDetailsActivity();
            }
        }
    }
    public void ObtenerRuta(String latInicial, String lngInicial, String latFinal, String lngFinal){

        String url = "https://maps.googleapis.com/maps/api/directions/json?origin=" + latInicial + "," + lngInicial + "&destination=" + latFinal + "," + lngFinal + "&key=AIzaSyClWzOgM1O9l8vXerddZY-mf0-WVROPS2I=drive";




        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONArray jRoutes = null;
                JSONArray jLegs = null;
                JSONArray jSteps = null;


                try {

                    jRoutes = response.getJSONArray("routes");


                    for(int i=0;i<jRoutes.length();i++){

                        jLegs = ( (JSONObject)jRoutes.get(i)).getJSONArray("legs");
                        List<HashMap<String, String>> path = new ArrayList<HashMap<String, String>>();

                        for(int j=0;j<jLegs.length();j++){
                            jSteps = ( (JSONObject)jLegs.get(j)).getJSONArray("steps");


                            for(int k=0;k<jSteps.length();k++){

                                String polyline = "";
                                polyline = (String)((JSONObject)((JSONObject)jSteps.get(k)).get("polyline")).get("points");
                                List<LatLng> list = decodePoly(polyline);

                                for(int l=0;l<list.size();l++){

                                    HashMap<String, String> hm = new HashMap<String, String>();
                                    hm.put("lat", Double.toString(((LatLng)list.get(l)).latitude) );
                                    hm.put("lng", Double.toString(((LatLng)list.get(l)).longitude) );
                                    path.add(hm);

                                }
                            }

                            routes.add(path);

                            Intent intent = new Intent(Maps_food.this, Trasarlinea.class);
                            startActivity(intent);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }catch (Exception e){
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "No se puede conectar "+error.toString(), Toast.LENGTH_LONG).show();
                System.out.println();
                Log.d("ERROR: ", error.toString());
            }
        }
        );

        request.add(jsonObjectRequest);

    }


    private List<LatLng> decodePoly(String encoded) {

        List<LatLng> poly = new ArrayList<LatLng>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng p = new LatLng((((double) lat / 1E5)),
                    (((double) lng / 1E5)));
            poly.add(p);
        }

        return poly;
    }

    @Override
    public void onMapClick(LatLng latLng) {

    }


    public  class MyAsyncTask extends AsyncTask<Integer, Integer, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Integer... integers) {

            try {
                while (location == null){
                    location = gpsTracker.getLocation();
                    publishProgress(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            location = gpsTracker.getLocation();
            publishProgress(2);

            return "Fin";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            if(values[0] == 0){
                Log.d("Asyntask", "null");
            }else{
                Log.d("Asyntask", "Coordenadas");
                Toast.makeText(Maps_food.this, "LISTO", Toast.LENGTH_SHORT).show();
                coordenadas.setOrigenLat(latitudeGlobalOrigin);
                coordenadas.setOrigenLng(longitudeGlobalOrigin);
                Log.d("Asyntask", String.valueOf(latitudeGlobalOrigin));
                Log.d("Asyntask", String.valueOf(longitudeGlobalOrigin));
                ObtenerRuta(String.valueOf(coordenadas.getOrigenLat()), String.valueOf(coordenadas.getOrigenLng()),
                        String.valueOf(coordenadas.getDestinoLat()), String.valueOf(coordenadas.getDestinoLng()));

            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("asyntask", "FIN");

        }
    }







    public void AlertShow(String title, final LatLng latLng){
        AlertDialog.Builder builder= new AlertDialog.Builder(Maps_food.this);

        builder.setMessage("Desea ir este punto?");
        builder.setTitle(title);
        builder.setCancelable(false);

        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                coordenadas.setDestinoLat(latLng.latitude);
                coordenadas.setDestinoLng(latLng.longitude);

                new MyAsyncTask().execute(0);

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        AlertShow(marker.getTitle(),marker.getPosition());
        return false;
    }
    private Boolean permissionsGranted() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == ((PackageManager.PERMISSION_GRANTED));
    }
    private void startInstalledAppDetailsActivity() {
        Intent i = new Intent();
        i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        i.addCategory(Intent.CATEGORY_DEFAULT);
        i.setData(Uri.parse("package:" + getPackageName()));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }


}
