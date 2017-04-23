package com.dopravo.dopravomap.protocols;


import com.dopravo.dopravomap.events.OnMapPlaceChosenListener;
import com.dopravo.dopravomap.events.OnMapReadyListener;
import com.dopravo.dopravomap.models.thin.PlaceModel;

import java.util.List;

public interface IMapProtocol {

    void setPlacesList(List<PlaceModel> placesList);

    void setOnMapReadyListener(OnMapReadyListener onMapReadyListener);

    void setOnMapPlaceChosenListener(OnMapPlaceChosenListener onMapPlaceChosenListener);

    void drawPlaces();
}