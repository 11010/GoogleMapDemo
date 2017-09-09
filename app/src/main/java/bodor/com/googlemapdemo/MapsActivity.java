package bodor.com.googlemapdemo;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        spinner  = findViewById(R.id.spinner);
       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
             switch (position){
                 case 0:
                     mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                     break;
                 case 1:
                     mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                     break;
                 case 2:
                     mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                     break;
                 case 3:
                     mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                     break;
                 case 4:
                     mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                     break;
                 case 5:
                     mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                     break;
                 default:
                     mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                     break;
             }
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {
                //
           }
       });

        //Location Manager


    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

}
