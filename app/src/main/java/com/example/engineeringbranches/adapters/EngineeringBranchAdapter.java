package com.example.engineeringbranches.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.engineeringbranches.R;
import com.example.engineeringbranches.models.EngineeringBranch;

import java.util.ArrayList;
import java.util.List;

public class EngineeringBranchAdapter extends RecyclerView.Adapter<EngineeringBranchAdapter.BranchViewHolder> {
    private List<EngineeringBranch> branches;
    private List<EngineeringBranch> filteredBranches;
    private OnBranchClickListener listener;

    public interface OnBranchClickListener {
        void onBranchClick(EngineeringBranch branch);
    }

    public EngineeringBranchAdapter(OnBranchClickListener listener) {
        this.branches = new ArrayList<>();
        this.filteredBranches = new ArrayList<>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public BranchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_engineering_branch, parent, false);
        return new BranchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BranchViewHolder holder, int position) {
        EngineeringBranch branch = filteredBranches.get(position);
        holder.bind(branch);
    }

    @Override
    public int getItemCount() {
        return filteredBranches.size();
    }

    public void setBranches(List<EngineeringBranch> branches) {
        this.branches = branches;
        this.filteredBranches = new ArrayList<>(branches);
        notifyDataSetChanged();
    }

    public void filterBranches(String query) {
        filteredBranches.clear();
        if (query.isEmpty()) {
            filteredBranches.addAll(branches);
        } else {
            for (EngineeringBranch branch : branches) {
                if (branch.getName().toLowerCase().contains(query.toLowerCase())) {
                    filteredBranches.add(branch);
                }
            }
        }
        notifyDataSetChanged();
    }

    class BranchViewHolder extends RecyclerView.ViewHolder {
        private TextView branchNameTextView;
        private TextView semesterCountTextView;

        public BranchViewHolder(@NonNull View itemView) {
            super(itemView);
            branchNameTextView = itemView.findViewById(R.id.branchNameTextView);
            semesterCountTextView = itemView.findViewById(R.id.semesterCountTextView);

            itemView.findViewById(R.id.viewDetailsButton).setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onBranchClick(filteredBranches.get(position));
                }
            });
        }

        public void bind(EngineeringBranch branch) {
            branchNameTextView.setText(branch.getName());
            semesterCountTextView.setText(String.format("%d Semesters", branch.getSemesterCount()));
        }
    }
} 