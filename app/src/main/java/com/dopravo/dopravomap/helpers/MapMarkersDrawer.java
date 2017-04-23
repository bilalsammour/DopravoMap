package com.dopravo.dopravomap.helpers;


import com.dopravo.dopravomap.models.thin.PlaceModel;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.List;

public class MapMarkersDrawer {

    private static final float ZOOMING = 14.0f;

    private GoogleMap googleMap;
    private HashMap<MarkerOptions, PlaceModel> markerPlaceHashMap;

    public MapMarkersDrawer(GoogleMap googleMap) {
        this.googleMap = googleMap;
        this.markerPlaceHashMap = new HashMap<>();
    }

    public void drawPlaces(List<PlaceModel> placesList) {
        if (hasPlaces(placesList)) {
            addPlacesList(placesList);

            moveToFirstPlace(placesList);
        }
    }

    private boolean hasPlaces(List<PlaceModel> placesList) {
        return placesList != null && !placesList.isEmpty();
    }

    private void addPlacesList(List<PlaceModel> placesList) {
        for (PlaceModel placeModel : placesList) {
            pairMarkerWithPlace(placeModel);

            addPlace(placeModel);
        }
    }

    private void pairMarkerWithPlace(PlaceModel placeModel) {
        markerPlaceHashMap.put(placeModel.toMarkerOptions(), placeModel);
    }

    private void addPlace(PlaceModel placeModel) {
        MarkerOptions markerOptions = placeModel.toMarkerOptions();

        addPlaceMarker(markerOptions);
    }

    private void addPlaceMarker(MarkerOptions markerOptions) {
        googleMap.addMarker(markerOptions);
    }

    private void moveToFirstPlace(List<PlaceModel> placesList) {
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

    private void showMarkerInfo(Marker marker) {

    }
}
