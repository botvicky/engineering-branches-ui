package com.example.engineeringbranches.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.engineeringbranches.R;
import com.example.engineeringbranches.models.Semester;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SemesterAdapter extends RecyclerView.Adapter<SemesterAdapter.SemesterViewHolder> {
    private final List<Semester> semesters;

    public SemesterAdapter() {
        this.semesters = new ArrayList<>();
    }

    @NonNull
    @Override
    public SemesterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_semester, parent, false);
        return new SemesterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SemesterViewHolder holder, int position) {
        Semester semester = semesters.get(position);
        holder.bind(semester);
    }

    @Override
    public int getItemCount() {
        return semesters.size();
    }

    public void setSemesters(List<Semester> newSemesters) {
        semesters.clear();
        if (newSemesters != null) {
            semesters.addAll(newSemesters);
        }
        notifyDataSetChanged();
    }

    public static class SemesterViewHolder extends RecyclerView.ViewHolder {
        private final TextView semesterNumberTextView;
        private final TextView subjectCountTextView;
        private final RecyclerView subjectsRecyclerView;
        private final SubjectAdapter subjectAdapter;

        public SemesterViewHolder(@NonNull View itemView) {
            super(itemView);
            semesterNumberTextView = itemView.findViewById(R.id.semesterNumberTextView);
            subjectCountTextView = itemView.findViewById(R.id.subjectCountTextView);
            subjectsRecyclerView = itemView.findViewById(R.id.subjectsRecyclerView);

            // Configure the nested RecyclerView
            subjectsRecyclerView.setHasFixedSize(true);
            subjectsRecyclerView.setNestedScrollingEnabled(false);
            
            // Use a LinearLayoutManager with vertical orientation
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            subjectsRecyclerView.setLayoutManager(layoutManager);

            // Initialize the subject adapter
            subjectAdapter = new SubjectAdapter();
            subjectsRecyclerView.setAdapter(subjectAdapter);
        }

        public void bind(Semester semester) {
            if (semester != null) {
                semesterNumberTextView.setText(String.format(Locale.getDefault(), "Semester %d", semester.getNumber()));
                int subjectCount = semester.getSubjects() != null ? semester.getSubjects().size() : 0;
                subjectCountTextView.setText(String.format(Locale.getDefault(), "%d Subjects", subjectCount));
                subjectAdapter.setSubjects(semester.getSubjects());
            }
        }
    }
} 