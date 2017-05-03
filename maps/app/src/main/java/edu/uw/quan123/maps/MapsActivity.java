package edu.uw.quan123.maps;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private MarkerOptions markerOptions;

    private Marker myMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Add a marker at Drumheller Fountain
        LatLng drumheller = new LatLng(47.6538, -122.3078);
        markerOptions = new MarkerOptions()
                .position(drumheller)
                .snippet("The ducks are cool!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));

        final Marker myMarker = mMap.addMarker(markerOptions);

        // Set a listener to show snipper once marker is clicked
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(MapsActivity.this, myMarker.getSnippet(), Toast.LENGTH_LONG).show();
                return true;
            }
        });

        // Draw a 'W' at Drumheller Fountain
        PolylineOptions wOptions = new PolylineOptions()
                .add(new LatLng(47.65394, -122.30813))
                .add(new LatLng(47.65381, -122.30793))
                .add(new LatLng(47.65396, -122.30779))
                .add(new LatLng(47.65381, -122.30766))
                .add(new LatLng(47.65396, -122.30749))
                .color(Color.MAGENTA);

        // Add polyline to map
        Polyline polyline = mMap.addPolyline(wOptions);

    }
}
