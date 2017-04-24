package com.dopravo.dopravomap.protocols;


import com.dopravo.dopravomap.events.OnBranchChosenListener;
import com.dopravo.dopravomap.models.thin.PlaceModel;

public interface IPlaceInfoProtocol {

    void showPlaceInfo(PlaceModel placeModel);

    void hidePlaceInfoPanel();

    void setOnBranchChosenListener(OnBranchChosenListener onBranchChosenListener);
}
