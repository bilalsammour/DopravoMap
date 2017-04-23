package com.dopravo.dopravomap.events;


import com.dopravo.dopravomap.models.thin.PlaceModel;

import java.util.List;

public interface OnPlacesReadyListener {

    void onPlacesReady(List<PlaceModel> placeList);
}
