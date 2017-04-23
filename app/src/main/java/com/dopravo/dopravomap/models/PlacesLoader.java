package com.dopravo.dopravomap.models;


import com.dopravo.dopravomap.events.OnPlacesReadyListener;
import com.dopravo.dopravomap.models.thin.PlaceModel;
import com.dopravo.dopravomap.protocols.IPlacesLoaderProtocol;

import java.util.ArrayList;
import java.util.List;

public class PlacesLoader implements IPlacesLoaderProtocol {

    private OnPlacesReadyListener onPlacesReadyListener;

    @Override
    public void retrievePlaces() {
        List<PlaceModel> placesList = getTempPlacesList();

        if (onPlacesReadyListener != null)
            onPlacesReadyListener.onPlacesReady(placesList);
    }

    @Override
    public void setOnPlacesReadyListener(OnPlacesReadyListener onPlacesReadyListener) {
        this.onPlacesReadyListener = onPlacesReadyListener;
    }

    // TODO remove
    private List<PlaceModel> getTempPlacesList() {
        PlaceModel place1 = new PlaceModel();
        place1.setName("CityMall");
        place1.setLocation(31.9806203, 35.8368819);

        PlaceModel place2 = new PlaceModel();
        place2.setName("Sydney");
        place2.setLocation(-34, 151);

        List<PlaceModel> placesList = new ArrayList<>();
        placesList.add(place1);
        placesList.add(place2);

        return placesList;
    }
}
