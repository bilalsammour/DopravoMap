package com.dopravo.dopravomap.events;


import com.dopravo.dopravomap.models.thin.PlaceModel;

public interface OnMapPlaceChosenListener {

    void onMapPlaceChosen(PlaceModel placeModel);

    void onMapPlaceChooseNothing();
}
