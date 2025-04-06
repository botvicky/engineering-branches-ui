package com.example.engineeringbranches.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.engineeringbranches.R;
import com.example.engineeringbranches.models.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {
    private final List<Subject> subjects;

    public SubjectAdapter() {
        this.subjects = new ArrayList<>();
    }

    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_subject, parent, false);
        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {
        Subject subject = subjects.get(position);
        holder.bind(subject);
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    public void setSubjects(List<Subject> newSubjects) {
        subjects.clear();
        if (newSubjects != null) {
            subjects.addAll(newSubjects);
        }
        notifyDataSetChanged();
    }

    public static class SubjectViewHolder extends RecyclerView.ViewHolder {
        private final ImageView subjectIconImageView;
        private final TextView subjectNameTextView;
        private final TextView creditsTextView;

        public SubjectViewHolder(@NonNull View itemView) {
            super(itemView);
            subjectIconImageView = itemView.findViewById(R.id.subjectIconImageView);
            subjectNameTextView = itemView.findViewById(R.id.subjectNameTextView);
            creditsTextView = itemView.findViewById(R.id.creditsTextView);
        }

        public void bind(Subject subject) {
            if (subject != null) {
                subjectNameTextView.setText(subject.getName());
                creditsTextView.setText(String.format(Locale.getDefault(), "%d Credits", subject.getCredits()));
                subjectIconImageView.setContentDescription(String.format(Locale.getDefault(), 
                    "Icon for %s", subject.getName()));
            }
        }
    }
} 