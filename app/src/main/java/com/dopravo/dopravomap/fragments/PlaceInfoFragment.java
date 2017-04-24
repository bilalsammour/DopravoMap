package com.dopravo.dopravomap.fragments;


import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dopravo.dopravomap.R;
import com.dopravo.dopravomap.adapters.BranchesAdapter;
import com.dopravo.dopravomap.events.OnBranchChosenListener;
import com.dopravo.dopravomap.models.thin.PlaceModel;
import com.dopravo.dopravomap.protocols.IAssetsConstants;
import com.dopravo.dopravomap.protocols.IPlaceInfoProtocol;

import java.io.IOException;
import java.io.InputStream;

public class PlaceInfoFragment extends Fragment
        implements IAssetsConstants, IPlaceInfoProtocol {

    private View parent;
    private ImageView infoImage;
    private TextView title;
    private TextView description;
    private View branchesPanel;
    private RecyclerView branchesList;

    private BranchesAdapter branchesAdapter;

    private OnBranchChosenListener onBranchChosenListener;

    public PlaceInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_place_info, container, false);

        initViews(rootView);

        initBranchesList();

        return rootView;
    }

    private void initViews(View rootView) {
        parent = rootView.findViewById(R.id.parent);
        infoImage = (ImageView) rootView.findViewById(R.id.infoImage);
        title = (TextView) rootView.findViewById(R.id.title);
        description = (TextView) rootView.findViewById(R.id.description);

        branchesPanel = rootView.findViewById(R.id.branchesPanel);
        branchesList = (RecyclerView) rootView.findViewById(R.id.branchesList);
    }

    private void initBranchesList() {
        branchesAdapter = new BranchesAdapter();
        branchesAdapter.setOnBranchChosenListener(new OnBranchChosenListener() {
            @Override
            public void onBranchChosen(PlaceModel branch) {
                sendChosenBranch(branch);
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        branchesList.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(getContext(), LinearLayout.VERTICAL);
        branchesList.addItemDecoration(dividerItemDecoration);

        branchesList.setItemAnimator(new DefaultItemAnimator());
        branchesList.setAdapter(branchesAdapter);
    }

    @Override
    public void showPlaceInfo(PlaceModel placeModel) {
        showPlaceImage(placeModel);

        title.setText(placeModel.getName());

        description.setText(placeModel.getDescription());

        showPlaceInfoPanel();

        showBranches(placeModel);
    }

    @Override
    public void hidePlaceInfoPanel() {
        parent.setVisibility(View.GONE);
    }

    @Override
    public void setOnBranchChosenListener(OnBranchChosenListener onBranchChosenListener) {
        this.onBranchChosenListener = onBranchChosenListener;
    }

    private void showPlaceInfoPanel() {
        parent.setVisibility(View.VISIBLE);
    }

    private void showPlaceImage(PlaceModel placeModel) {
        String fullName = getFullImageName(placeModel.getImage());
        Bitmap bitmap = getBitmapFromAssets(fullName);

        infoImage.setImageBitmap(bitmap);
    }

    private String getFullImageName(String image) {
        return STORES_FOLDER_NAME + "/" + image;
    }

    private Bitmap getBitmapFromAssets(String fileName) {
        AssetManager assetManager = getContext().getAssets();

        InputStream inputStream = null;
        try {
            inputStream = assetManager.open(fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return BitmapFactory.decodeStream(inputStream);
    }

    private void showBranches(PlaceModel placeModel) {
        if (placeModel.hasBranches()) {
            branchesPanel.setVisibility(View.VISIBLE);

            branchesAdapter.setBranches(placeModel.getBranches());

        } else {
            branchesPanel.setVisibility(View.GONE);
        }
    }

    private void sendChosenBranch(PlaceModel branch) {
        if (onBranchChosenListener != null)
            onBranchChosenListener.onBranchChosen(branch);
    }
}
