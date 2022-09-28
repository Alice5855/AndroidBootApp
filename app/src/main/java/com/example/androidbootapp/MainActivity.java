package com.example.androidbootapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import retrofit2.http.Tag;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    GoogleMap gMap;
    MapFragment mapFrag;
    GroundOverlayOptions videoMark;
    private Marker hMarker;
    private Marker bMarker;
    private Marker gMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo60x40);
        setTitle("AniBucket 매장 찾기");
        if (getIntent().getStringExtra("login") == null) {
            getIntent().putExtra("login", "0");
        }

        mapFrag = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFrag.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        gMap = map;
        gMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        gMap.getUiSettings().setZoomControlsEnabled(true);
        gMap.setOnMarkerClickListener(this);

        LatLng hwasung = new LatLng(37.135418, 126.909661);
        LatLng bucheon = new LatLng(37.484771, 126.783472);
        LatLng guro = new LatLng(37.503267, 126.881071);

        hMarker = gMap.addMarker(new MarkerOptions().position(hwasung).title("화성점").snippet("AniBucket 화성점입니다")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        bMarker = gMap.addMarker(new MarkerOptions().position(bucheon).title("부천점").snippet("AniBucket 부천점입니다")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        gMarker = gMap.addMarker(new MarkerOptions().position(guro).title("구로점").snippet("AniBucket 구로점입니다")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        gMap.moveCamera(CameraUpdateFactory.newLatLng(guro));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0, 1, 0, "위성 지도");
        menu.add(0, 2, 0, "일반 지도");
        menu.add(2, 3, 0, "로그아웃");
        menu.add(1, 4, 0, "로그인");
        menu.add(1, 5, 0, "회원가입");

        SubMenu sMenu = menu.addSubMenu("오프샵 바로가기");
        sMenu.add(0, 6, 0, "화성점");
        sMenu.add(0, 7, 0, "부천점");
        sMenu.add(0, 8, 0, "구로점");

        SubMenu sMenu2 = menu.addSubMenu("서브 페이지");
        sMenu2.add(3, 9, 0, "회사 소개");
        sMenu2.add(3, 10, 0, "Contact Us");
        sMenu2.add(3, 11, 0, "FAQ");

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(@NonNull Menu menu) {
        Intent getIntent = getIntent();
        // Toast.makeText(getApplicationContext(), getIntent().getStringExtra("login"), Toast.LENGTH_SHORT).show();
        if (getIntent.getStringExtra("login").equals("1")) {
            menu.setGroupVisible(1,true);
            menu.setGroupVisible(1, false);
        } else {
            menu.setGroupVisible(1,true);
            menu.setGroupVisible(2,false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                gMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;
            case 2:
                gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case 3:
                Intent signout = new Intent(getApplicationContext(), MainActivity.class);
                signout.putExtra("login", "0");

                startActivity(signout);
                return true;
            case 4:
                Intent signin = new Intent(getApplicationContext(), SignInActivity.class);

                startActivity(signin);
                return true;
            case 5:
                Intent signup = new Intent(getApplicationContext(), SignUpActivity.class);

                startActivity(signup);
                return true;
            case 6:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                        37.135418, 126.909661), 15));
                return true;
            case 7:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                        37.484771, 126.783472), 15));
                return true;
            case 8:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                        37.503267, 126.881071), 15));
                return true;
            case 9:
                Intent about = new Intent(getApplicationContext(), About.class);
                Intent getIntent1 = getIntent();

                if (getIntent1.getStringExtra("login").equals("1")) {
                    about.putExtra("login", "1");
                } else {
                    about.putExtra("login", "0");
                }

                startActivity(about);

                return true;
            case 10:
                Intent contactus = new Intent(getApplicationContext(), ContactUs.class);
                Intent getIntent2 = getIntent();

                if (getIntent2.getStringExtra("login").equals("1")) {
                    contactus.putExtra("login", "1");
                } else {
                    contactus.putExtra("login", "0");
                }
                
                startActivity(contactus);
                return true;
            case 11:
                Intent faq = new Intent(getApplicationContext(), Faq.class);
                Intent getIntent3 = getIntent();

                if (getIntent3.getStringExtra("login").equals("1")) {
                    faq.putExtra("login", "1");
                } else {
                    faq.putExtra("login", "0");
                }

                startActivity(faq);

        }
        return false;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.equals(hMarker)){
            Toast.makeText(this, "hMarker Clicked", Toast.LENGTH_SHORT).show();
            Log.d("markerlog", "hMarker");
        } else if (marker.equals(bMarker)){
            Toast.makeText(this, "bMarker Clicked", Toast.LENGTH_SHORT).show();
            Log.d("markerlog", "bMarker");
        } else if (marker.equals(gMarker)){
            Toast.makeText(this, "gMarker Clicked", Toast.LENGTH_SHORT).show();
            Log.d("markerlog", "gMarker");
        }
        return false;
    }
}
