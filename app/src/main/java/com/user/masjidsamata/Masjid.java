package com.user.masjidsamata;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Masjid extends Fragment implements OnMapReadyCallback,View.OnClickListener {
    GoogleMap map;
    Button a;
    SupportMapFragment mp;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View s = inflater.inflate(R.layout.activity_masjid,null);
        mp = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapFragment);
        mp.getMapAsync(this);
        a = (Button)
                s.findViewById(R.id.terrain);
        s.findViewById(R.id.terrain);

        a.setOnClickListener(this);
        return s;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng Nurul_Abrar_Borong_Raukang = new LatLng(-5.1932907, 199.4949406);
        LatLng Nurun_Nur_Samata = new LatLng(-5.194472, 199.4922562);
        LatLng Babul_Jannah_Baruga_Samata = new LatLng(-5.194472, 199.4922562);
        LatLng Uin_Alauddin = new LatLng(-5.1756796, 199.4331797);


        map.addMarker(new MarkerOptions().position(Nurul_Abrar_Borong_Raukang).title("Nurul Abrar Borong Raukang"));
        map.addMarker(new MarkerOptions().position(Nurun_Nur_Samata).title("Nurun Nur Samata"));
        map.addMarker(new MarkerOptions().position(Babul_Jannah_Baruga_Samata).title("Babul Jannah Baruga Samata"));
        map.addMarker(new MarkerOptions().position(Uin_Alauddin).title("Uin Alauddin"));

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(Uin_Alauddin, 5));
    }

    @Override
    public void onClick(View v) {
        int tombol = v.getId();
        if (tombol == R.id.terrain) {
            map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        }
    }
}
