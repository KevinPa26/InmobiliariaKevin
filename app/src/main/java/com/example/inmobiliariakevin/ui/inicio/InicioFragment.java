package com.example.inmobiliariakevin.ui.inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.inmobiliariakevin.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class InicioFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mapa;
    private LatLng SANLUIS = new LatLng(-33.280576, -66.332482);

    private TextView tvHome;


    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        InicioViewModel homeViewModel = new ViewModelProvider(this).get(InicioViewModel.class);
        View root = inflater.inflate(R.layout.fragment_inicio, container, false);
        tvHome = root.findViewById(R.id.text_home);
        tvHome.setText("Este es el fragmento Inicio");

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.frMap);

        mapFragment.getMapAsync(this);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mapa = googleMap;
        CameraPosition camPos = new CameraPosition.Builder()
                .target(SANLUIS)
                .zoom(19)
                .bearing(45)
                .tilt(70).build();
        CameraUpdate camUpdICT = CameraUpdateFactory.newCameraPosition(camPos);
        mapa.animateCamera(camUpdICT);

        mapa.addMarker(new MarkerOptions().position(SANLUIS)).setTitle("Inmuebles Kevin");
        mapa.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
}