package com.example.myapplication;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

    //구글맵 키제한 AIzaSyB3EQtRgVN1hH3TWxFPptBfi0ekC-n53TE

public class map_page_7 extends AppCompatActivity implements OnMapReadyCallback {
    private Button btn_start;
    private Button btn_end;
    private FragmentManager fragmentManager;
    private MapFragment mapFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_page_7);
        fragmentManager = getFragmentManager();
        mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        btn_end = (Button)findViewById(R.id.btn_end);
        btn_end.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(map_page_7.this, page_8.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng location = new LatLng(35.17,126.91);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("테스트");
        markerOptions.position(location);
        googleMap.addMarker(markerOptions);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 10));

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener(){
            public void onMapClick(LatLng point){
                Toast.makeText(getBaseContext(),point.latitude + ", " + point.longitude,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }


}

