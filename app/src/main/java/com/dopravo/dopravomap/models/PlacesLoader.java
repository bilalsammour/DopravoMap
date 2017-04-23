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
        return new ArrayList<>();
    }
}
