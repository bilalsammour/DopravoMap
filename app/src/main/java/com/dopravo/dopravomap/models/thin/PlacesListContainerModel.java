package com.dopravo.dopravomap.models.thin;


import java.util.List;

@SuppressWarnings("unused")
public class PlacesListContainerModel {

    @SuppressWarnings("CanBeFinal")
    private List<PlaceModel> list;

    public List<PlaceModel> getList() {
        return list;
    }

    private boolean hasList() {
        return (list != null && !list.isEmpty());
    }

    public void addBranchesToEachPlace() {
        if (!hasList())
            return;

        for (PlaceModel placeModel : list)
            tryAddBranchesToPlace(placeModel);
    }

    private void tryAddBranchesToPlace(PlaceModel placeModel) {
        if (placeModel.canAddBranches()) {
            placeModel.initBranches();

            addBranchesToPlace(placeModel);
        }
    }

    private void addBranchesToPlace(PlaceModel placeModel) {
        for (long id : placeModel.getBranchesIds()) {
            PlaceModel branch = getBranchById(id);

            addBranchIfFound(placeModel, branch);
        }
    }

    private PlaceModel getBranchById(long id) {
        PlaceModel searchable = new PlaceModel(id);

        if (list.contains(searchable)) {
            int index = list.indexOf(searchable);

            return list.get(index);

        } else {
            return null;
        }
    }

    private void addBranchIfFound(PlaceModel placeModel, PlaceModel branch) {
        if (branch != null)
            placeModel.addBranch(branch);
    }
}
