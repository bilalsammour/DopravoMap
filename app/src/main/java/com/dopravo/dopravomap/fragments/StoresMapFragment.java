package com.dopravo.dopravomap.fragments;


import android.os.Bundle;

import com.dopravo.dopravomap.events.OnMapPlaceChosenListener;
import com.dopravo.dopravomap.events.OnMapReadyListener;
import com.dopravo.dopravomap.helpers.MapMarkersDrawer;
import com.dopravo.dopravomap.models.thin.PlaceModel;
import com.dopravo.dopravomap.protocols.IMapProtocol;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import java.util.List;

public class StoresMapFragment extends SupportMapFragment
        implements IMapProtocol {

    private MapMarkersDrawer mapMarkersDrawer;
    private List<PlaceModel> placesList;

    private OnMapReadyListener onMapReadyListener;
    private OnMapPlaceChosenListener onMapPlaceChosenListener;


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
        mapMarkersDrawer = new MapMarkersDrawer(googleMap);

        googleMap.getUiSettings().setCompassEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                onMapPlaceChooseNothing();
            }
        });

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                marker.showInfoWindow();

                PlaceModel placeModel = mapMarkersDrawer.getPlaceByMarker(marker);

                onPlaceModelClicked(placeModel);

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

    @Override
    public void goToBranch(PlaceModel branch) {
        mapMarkersDrawer.moveToPlace(branch);
    }

    public void setOnMapPlaceChosenListener(OnMapPlaceChosenListener onMapPlaceChosenListener) {
        this.onMapPlaceChosenListener = onMapPlaceChosenListener;
    }

    private void onPlaceModelClicked(PlaceModel placeModel) {
        if (onMapPlaceChosenListener != null)
            onMapPlaceChosenListener.onMapPlaceChosen(placeModel);
    }

    private void onMapPlaceChooseNothing() {
        if (onMapPlaceChosenListener != null)
            onMapPlaceChosenListener.onMapPlaceChooseNothing();
    }
}
