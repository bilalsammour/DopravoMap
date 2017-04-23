package com.dopravo.dopravomap.protocols;


import com.dopravo.dopravomap.events.OnPlacesReadyListener;

public interface IPlacesLoaderProtocol {

    void retrievePlaces();

    void setOnPlacesReadyListener(OnPlacesReadyListener onPlacesReadyListener);
}
