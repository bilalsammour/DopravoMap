package com.dopravo.dopravomap.models;


import android.content.Context;

import com.dopravo.dopravomap.events.OnPlacesReadyListener;
import com.dopravo.dopravomap.models.thin.PlaceModel;
import com.dopravo.dopravomap.models.thin.PlacesListContainerModel;
import com.dopravo.dopravomap.protocols.IAssetsConstants;
import com.dopravo.dopravomap.protocols.IPlacesLoaderProtocol;
import com.dopravo.dopravomap.utils.AssetsFileManager;
import com.dopravo.dopravomap.utils.JsonParser;

import java.io.IOException;
import java.util.List;

public class PlacesLoader implements IAssetsConstants, IPlacesLoaderProtocol {

    private Context context;
    private OnPlacesReadyListener onPlacesReadyListener;

    public PlacesLoader(Context context) {
        this.context = context;
    }

    @Override
    public void retrievePlaces() {
        try {
            PlacesListContainerModel placesListContainerModel = retrievePlacesFromFile();

            placesListContainerModel.addBranchesToEachPlace();

            returnPlacesList(placesListContainerModel.getList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PlacesListContainerModel retrievePlacesFromFile() throws IOException {
        String source = AssetsFileManager.readFile(context, STORES_DATA_FILE_NAME);

        return parsePlacesText(source);
    }

    private PlacesListContainerModel parsePlacesText(String source) {
        return JsonParser.parseFromJson(source, PlacesListContainerModel.class);
    }

    private void returnPlacesList(List<PlaceModel> placesList) {
        if (onPlacesReadyListener != null)
            onPlacesReadyListener.onPlacesReady(placesList);
    }

    @Override
    public void setOnPlacesReadyListener(OnPlacesReadyListener onPlacesReadyListener) {
        this.onPlacesReadyListener = onPlacesReadyListener;
    }
}
