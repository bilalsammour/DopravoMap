package com.dopravo.dopravomap.models.thin;


import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class PlaceModel {

    private String name;
    private String description;
    private String addressText;
    private String image;
    private LatLng position;
    private List<PlaceModel> branches;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddressText() {
        return addressText;
    }

    public void setAddressText(String addressText) {
        this.addressText = addressText;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<PlaceModel> getBranches() {
        return branches;
    }

    public void setBranches(List<PlaceModel> branches) {
        this.branches = branches;
    }

    public LatLng getPosition() {
        return position;
    }

    public void setPosition(LatLng position) {
        this.position = position;
    }

    public void setLocation(double latitude, double longitude) {
        setPosition(new LatLng(latitude, longitude));
    }

    public MarkerOptions toMarkerOptions() {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title(name);
        markerOptions.position(position);

        return markerOptions;
    }
}
