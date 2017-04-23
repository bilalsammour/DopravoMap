package com.dopravo.dopravomap.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.dopravo.dopravomap.R;
import com.dopravo.dopravomap.events.OnMapReadyListener;
import com.dopravo.dopravomap.events.OnPlacesReadyListener;
import com.dopravo.dopravomap.models.PlacesLoader;
import com.dopravo.dopravomap.models.thin.PlaceModel;
import com.dopravo.dopravomap.protocols.IMapProtocol;
import com.dopravo.dopravomap.protocols.IPlacesLoaderProtocol;

import java.util.List;

public class MapsActivity extends FragmentActivity {

    private IMapProtocol map;
    private IPlacesLoaderProtocol placesLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        map = (IMapProtocol) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        map.setOnMapReadyListener(new OnMapReadyListener() {
            @Override
            public void onMapReady() {
                retrievePlacesList();
            }
        });

        placesLoader = new PlacesLoader(this);
        placesLoader.setOnPlacesReadyListener(new OnPlacesReadyListener() {
            @Override
            public void onPlacesReady(List<PlaceModel> placesList) {
                addPlacesToMap(placesList);
            }
        });
    }

    private void retrievePlacesList() {
        placesLoader.retrievePlaces();
    }

    private void addPlacesToMap(List<PlaceModel> placesList) {
        map.setPlacesList(placesList);

        map.drawPlaces();
    }
}
