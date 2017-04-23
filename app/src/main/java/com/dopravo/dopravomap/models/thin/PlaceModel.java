package com.dopravo.dopravomap.models.thin;


import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class PlaceModel {

    private long id;
    private String name;
    private String description;
    private String image;
    private LatLng position;
    private List<Long> branchesIds;
    private List<PlaceModel> branches;
    private MarkerOptions markerOptions;

    public PlaceModel(long id) {
        this.id = id;
    }

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

    public List<Long> getBranchesIds() {
        return branchesIds;
    }

    public List<PlaceModel> getBranches() {
        return branches;
    }

    public boolean canAddBranches() {
        return (branchesIds != null && !branchesIds.isEmpty());
    }

    public void initBranches() {
        branches = new ArrayList<>();
    }

    public void addBranch(PlaceModel branch) {
        branches.add(branch);
    }

    public MarkerOptions toMarkerOptions() {
        if (this.markerOptions == null)
            this.markerOptions = new MarkerOptions();

        updateMarker();

        return this.markerOptions;
    }

    private void updateMarker() {
        markerOptions.title(name);
        markerOptions.position(position);
        markerOptions.snippet(description);
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
