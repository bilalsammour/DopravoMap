package com.dopravo.dopravomap.models.thin;


import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class PlaceModel {

    private long id;
    private String name;
    private String description;
    private String image;
    private LatLng position;
    private List<Long> branches;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public LatLng getPosition() {
        return position;
    }

    public List<Long> getBranches() {
        return branches;
    }

    public MarkerOptions toMarkerOptions() {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title(name);
        markerOptions.position(position);

        return markerOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaceModel that = (PlaceModel) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
