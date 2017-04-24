package com.dopravo.dopravomap.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dopravo.dopravomap.R;
import com.dopravo.dopravomap.models.thin.PlaceModel;

import java.util.ArrayList;
import java.util.List;

public class BranchesAdapter extends
        RecyclerView.Adapter<BranchesAdapter.BranchViewHolder> {

    private List<PlaceModel> branches;

    public BranchesAdapter() {
        this.branches = new ArrayList<>();
    }

    @Override
    public BranchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_branch, parent, false);

        return new BranchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BranchViewHolder holder, int position) {
        PlaceModel placeModel = branches.get(position);

        holder.getTitle().setText(placeModel.getName());
        holder.getDescription().setText(placeModel.getDescription());
    }

    @Override
    public int getItemCount() {
        return branches.size();
    }

    public void setBranches(List<PlaceModel> branches) {
        this.branches = branches;

        notifyDataSetChanged();
    }

    class BranchViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView description;

        BranchViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
        }

        public TextView getTitle() {
            return title;
        }

        public TextView getDescription() {
            return description;
        }
    }
}
