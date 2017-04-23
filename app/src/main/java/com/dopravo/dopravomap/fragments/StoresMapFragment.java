package com.dopravo.dopravomap.fragments;


import android.os.Bundle;

import com.dopravo.dopravomap.events.OnMapReadyListener;
import com.dopravo.dopravomap.helpers.MapMarkersDrawer;
import com.dopravo.dopravomap.models.thin.PlaceModel;
import com.dopravo.dopravomap.protocols.IMapProtocol;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;

import java.util.List;

public class StoresMapFragment extends SupportMapFragment
        implements IMapProtocol {

    private static final float ZOOMING = 14.0f;

    private MapMarkersDrawer mapMarkersDrawer;
    private GoogleMap googleMap;
    private List<PlaceModel> placesList;

    private OnMapReadyListener onMapReadyListener;


    public StoresMapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                onMapReadyCallback(googleMap);
            }
        });
    }

    private void onMapReadyCallback(GoogleMap googleMap) {
        initGoogleMap(googleMap);

        if (onMapReadyListener != null)
            onMapReadyListener.onMapReady();
    }

    private void initGoogleMap(GoogleMap googleMap) {
        this.googleMap = googleMap;

        mapMarkersDrawer = new MapMarkersDrawer(googleMap);

        googleMap.getUiSettings().setCompassEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                // showMarkerInfo(marker);

                return true;
            }
        });
    }

    @Override
    public void setOnMapReadyListener(OnMapReadyListener onMapReadyListener) {
        this.onMapReadyListener = onMapReadyListener;
    }

    @Override
    public void setPlacesList(List<PlaceModel> placesList) {
        this.placesList = placesList;
    }

    @Override
    public void drawPlaces() {
        mapMarkersDrawer.drawPlaces(placesList);
    }
}
