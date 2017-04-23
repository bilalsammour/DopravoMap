package com.dopravo.dopravomap.fragments;


import android.os.Bundle;

import com.dopravo.dopravomap.events.OnMapReadyListener;
import com.dopravo.dopravomap.models.thin.PlaceModel;
import com.dopravo.dopravomap.protocols.IMapProtocol;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class StoresMapFragment extends SupportMapFragment
        implements IMapProtocol {

    private static final float ZOOMING = 14.0f;

    private List<PlaceModel> placesList;

    private GoogleMap googleMap;
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
        this.googleMap = googleMap;

        if (onMapReadyListener != null)
            onMapReadyListener.onMapReady();
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
        if (hasPlaces()) {
            addPlacesList(placesList);

            moveToFirstPlace();
        }
    }

    private boolean hasPlaces() {
        return placesList != null && !placesList.isEmpty();
    }

    private void addPlacesList(List<PlaceModel> placesList) {
        for (PlaceModel placeModel : placesList) {
            addPlace(placeModel);
        }
    }

    private void addPlace(PlaceModel placeModel) {
        MarkerOptions markerOptions = placeModel.toMarkerOptions();

        addPlaceMarker(markerOptions);
    }

    private void addPlaceMarker(MarkerOptions markerOptions) {
        googleMap.addMarker(markerOptions);
    }

    private void moveToFirstPlace() {
        PlaceModel firstPlace = placesList.get(0);

        moveToMarker(firstPlace.toMarkerOptions());
    }

    private void moveToMarker(MarkerOptions markerOptions) {
        CameraUpdate cameraUpdate = buildCameraPositionWithZoom
                (markerOptions.getPosition());

        googleMap.animateCamera(cameraUpdate);
    }

    private CameraUpdate buildCameraPositionWithZoom(LatLng position) {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(position)
                .zoom(ZOOMING)
                .build();

        return CameraUpdateFactory.newCameraPosition(cameraPosition);
    }
}
