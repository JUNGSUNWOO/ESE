package com.example.speed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.icu.text.UFormat;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GPS2 extends AppCompatActivity implements LocationListener {

    private LocationManager locationManager;
    private Location mLastLocation = null;
    private TextView tvGetSpeed, tvCalSpeed,tvTime,tvLastTime,tvGpsEnable,tvTimeDif,tvDistDif,tvSumTime;
    private double speed;
    private Button btn, btn_end;
    private long start,end,difference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvGetSpeed = (TextView)findViewById(R.id.tvGetSpeed);
        tvCalSpeed = (TextView)findViewById(R.id.tvCalSpeed);
        tvTime = (TextView)findViewById(R.id.tvTime);
        tvLastTime = (TextView)findViewById(R.id.tvLastTime);
        tvGpsEnable = (TextView)findViewById(R.id.tvGPSEnabl);
        tvTimeDif = (TextView)findViewById(R.id.tvTimeDif);
        tvDistDif = (TextView)findViewById(R.id.tvDisDif);
        tvSumTime = (TextView)findViewById(R.id.tvSumTime);
        btn = (Button)findViewById(R.id.btn);
        btn_end = (Button)findViewById(R.id.btn_end);

        btn.setOnClickListener(new View.OnClickListener() { //출발 버튼을 누르면 생기는 이벤트
            @Override
            public void onClick(View v) {
                onStart(); //START 함수
                onResume(); //Resume 함수
                start = System.currentTimeMillis(); //시간측정 시작

            }
        });
        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPause();
                end = System.currentTimeMillis(); //시간측정 끝
                difference = (end - start)/1000; //계산

                tvSumTime.setText(": " + difference); //end 버튼을 누르면 계산결과 출력
            }
        });

        //권한 체크
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            return;
        }
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(lastKnownLocation != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); //시,분,초 형식으로 맞춰줌
            String formatDate = sdf.format(new Date(lastKnownLocation.getTime())); //getTime으로 시간 불러와서 포맷 변수에 string 값으로 넣어주기
            tvTime.setText(": " + formatDate); //Time 값 출력
        }
        //GPS 사용 가능 여부 확인
        boolean isEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        tvGpsEnable.setText(": " + isEnable); //GPS Enable
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,0,this);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        double deltaTime = 0;

        //getSpeed()함수를 이용하여 속도를 계산
        double getSpeed = Double.parseDouble(String.format("%.3f", location.getSpeed()));
        tvGetSpeed.setText(": " + getSpeed); //Get Speed
        String formaDate = sdf.format(new Date(location.getTime()));
        tvTime.setText(": " + formaDate); //Time

        //위치 변경이 두번째로 변경된 경우 계산에 의해 속도 계산
        if(mLastLocation != null)
        {
            deltaTime = (location.getTime() - mLastLocation.getTime()) / 1000.0; //시간간격
            tvTimeDif.setText(": " + deltaTime + " sec"); //Time Difference
            tvDistDif.setText(": " + mLastLocation.distanceTo(location) + " m"); //Distance Difference

            speed = mLastLocation.distanceTo(location) / deltaTime; //속도계산

            String formatLastDate = sdf.format(new Date(mLastLocation.getTime()));
            tvLastTime.setText(": " + formatLastDate); //Last Time

            double calSpeed = Double.parseDouble(String.format("%.3f", speed));
            tvCalSpeed.setText(": " + calSpeed); //Cal Speed
        }
        //현재위치를 지난 위치로 변경
        mLastLocation = location;


    }


    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        //권한 체크
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        //위치정보 업데이트
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, this);

    }
    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }
    @Override
    protected void onResume(){
        super.onResume();
        //권한 체크
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        //위치정보 업데이트
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, this);
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        //위치정보 가져오기 제거
        locationManager.removeUpdates(this);
    }
    protected void onStart()
    {
        super.onStart();
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //권한이 없을 경우 최초 권한 요청 또는 사용자에 의한 재요청 확인
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION) &&
                ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_COARSE_LOCATION)){
                //권한 재요청
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},100);
                return;
                }
            }
        }
    }
