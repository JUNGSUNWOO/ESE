package com.example.myapplication;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

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
        btn_start = (Button)findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });
        btn_end = (Button)findViewById(R.id.btn_end);
        btn_end.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(map_page_7.this, page_8.class);
                startActivity(intent);
            }
        });
    }
    public class JSONTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                //JSONObject를 만들고 key value 형식으로 값을 저장해준다.
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("speed", "speed_1");
                jsonObject.accumulate("time", "time_1");
                HttpURLConnection con = null;
                BufferedWriter writer = null;

                try {
                    URL url = new URL(urls[0]);//url을 가져온다.
                    con = (HttpURLConnection) url.openConnection();
                    //추가된부분
                    con.setRequestMethod("POST");
                    con.setRequestProperty("Cache-Control", "no-cache");//캐시 설정
                    con.setRequestProperty("Content-Type", "application/json");//application JSON 형식으로 전송
                    con.setRequestProperty("Accept", "text/html");//서버에 response 데이터를 html로 받음
                    con.setDoOutput(true);//Outstream으로 post 데이터를 넘겨주겠다는 의미
                    con.setDoInput(true);//Inputstream으로 서버로부터 응답을 받겠다는 의미
                    //
                    con.connect();//연결 수행

                    //입력 스트림 생성
                    OutputStream outputStream = con.getOutputStream();
                    writer = new BufferedWriter((new OutputStreamWriter(outputStream)));
                    Log.d("test2", jsonObject.toString());
                    writer.write(jsonObject.toString());
                    writer.flush();
                    writer.close();//버퍼를 받아줌

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    //종료가 되면 disconnect메소드를 호출한다.
                    if (con != null) {
                        con.disconnect();
                    }
                    Log.d("check point", "finally");
                }//finally 부분
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
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

