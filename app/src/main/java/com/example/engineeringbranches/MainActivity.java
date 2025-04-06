package com.example.engineeringbranches;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.engineeringbranches.adapters.EngineeringBranchAdapter;
import com.example.engineeringbranches.models.EngineeringBranch;
import com.example.engineeringbranches.models.Semester;
import com.example.engineeringbranches.models.Subject;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EngineeringBranchAdapter.OnBranchClickListener {
    private EngineeringBranchAdapter adapter;
    private TextInputEditText searchEditText;
    private List<EngineeringBranch> allBranches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        RecyclerView branchesRecyclerView = findViewById(R.id.branchesRecyclerView);
        searchEditText = findViewById(R.id.searchEditText);
        ImageView profileAvatar = findViewById(R.id.profileAvatar);

        // Setup RecyclerView
        branchesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EngineeringBranchAdapter(this);
        branchesRecyclerView.setAdapter(adapter);

        // Setup search functionality
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                adapter.filterBranches(s.toString());
            }
        });

        // Load engineering branches data
        loadEngineeringBranches();
    }

    @Override
    public void onBranchClick(EngineeringBranch branch) {
        Intent intent = new Intent(this, BranchDetailsActivity.class);
        intent.putExtra("branch_name", branch.getName());
        intent.putExtra("semester_count", branch.getSemesterCount());
        startActivity(intent);
    }

    private void loadEngineeringBranches() {
        allBranches = new ArrayList<>();

        // Computer Engineering
        List<Subject> computerSem1Subjects = Arrays.asList(
            new Subject("Mathematics I", 4),
            new Subject("Physics I", 3),
            new Subject("Programming Fundamentals", 3),
            new Subject("Digital Electronics", 3)
        );
        List<Subject> computerSem2Subjects = Arrays.asList(
            new Subject("Mathematics II", 4),
            new Subject("Physics II", 3),
            new Subject("Data Structures", 3),
            new Subject("Computer Architecture", 3)
        );
        List<Subject> computerSem3Subjects = Arrays.asList(
            new Subject("Operating Systems", 3),
            new Subject("Computer Networks", 3),
            new Subject("Database Systems", 3),
            new Subject("Software Engineering", 3)
        );
        List<Subject> computerSem4Subjects = Arrays.asList(
            new Subject("Machine Learning", 3),
            new Subject("Cloud Computing", 3),
            new Subject("Cybersecurity", 3),
            new Subject("Mobile Development", 3)
        );
        List<Subject> computerSem5Subjects = Arrays.asList(
            new Subject("Deep Learning", 3),
            new Subject("IoT Systems", 3),
            new Subject("Blockchain Technology", 3),
            new Subject("Project Management", 3)
        );
        List<Subject> computerSem6Subjects = Arrays.asList(
            new Subject("Capstone Project", 6),
            new Subject("Professional Ethics", 2),
            new Subject("Technical Writing", 2),
            new Subject("Industry Internship", 4)
        );
        List<Semester> computerSemesters = Arrays.asList(
            new Semester(1, computerSem1Subjects),
            new Semester(2, computerSem2Subjects),
            new Semester(3, computerSem3Subjects),
            new Semester(4, computerSem4Subjects),
            new Semester(5, computerSem5Subjects),
            new Semester(6, computerSem6Subjects)
        );
        allBranches.add(new EngineeringBranch("Computer Engineering", 6, computerSemesters));

        // Software Engineering
        List<Subject> softwareSem1Subjects = Arrays.asList(
            new Subject("Mathematics I", 4),
            new Subject("Programming Fundamentals", 3),
            new Subject("Web Development", 3),
            new Subject("Computer Organization", 3)
        );
        List<Subject> softwareSem2Subjects = Arrays.asList(
            new Subject("Data Structures", 3),
            new Subject("Object-Oriented Programming", 3),
            new Subject("Software Design Patterns", 3),
            new Subject("Database Systems", 3)
        );
        List<Subject> softwareSem3Subjects = Arrays.asList(
            new Subject("Software Architecture", 3),
            new Subject("Mobile App Development", 3),
            new Subject("Cloud Computing", 3),
            new Subject("DevOps Practices", 3)
        );
        List<Subject> softwareSem4Subjects = Arrays.asList(
            new Subject("Machine Learning", 3),
            new Subject("Big Data Analytics", 3),
            new Subject("Microservices Architecture", 3),
            new Subject("Software Testing", 3)
        );
        List<Subject> softwareSem5Subjects = Arrays.asList(
            new Subject("Blockchain Development", 3),
            new Subject("AI Applications", 3),
            new Subject("Security Engineering", 3),
            new Subject("Project Management", 3)
        );
        List<Subject> softwareSem6Subjects = Arrays.asList(
            new Subject("Capstone Project", 6),
            new Subject("Professional Ethics", 2),
            new Subject("Technical Writing", 2),
            new Subject("Industry Internship", 4)
        );
        List<Semester> softwareSemesters = Arrays.asList(
            new Semester(1, softwareSem1Subjects),
            new Semester(2, softwareSem2Subjects),
            new Semester(3, softwareSem3Subjects),
            new Semester(4, softwareSem4Subjects),
            new Semester(5, softwareSem5Subjects),
            new Semester(6, softwareSem6Subjects)
        );
        allBranches.add(new EngineeringBranch("Software Engineering", 6, softwareSemesters));

        // Industrial and Manufacturing Engineering
        List<Subject> industrialSem1Subjects = Arrays.asList(
            new Subject("Mathematics I", 4),
            new Subject("Physics I", 3),
            new Subject("Engineering Mechanics", 3),
            new Subject("Manufacturing Processes", 3)
        );
        List<Subject> industrialSem2Subjects = Arrays.asList(
            new Subject("Operations Research", 3),
            new Subject("Quality Control", 3),
            new Subject("Industrial Safety", 3),
            new Subject("Materials Science", 3)
        );
        List<Subject> industrialSem3Subjects = Arrays.asList(
            new Subject("Production Planning", 3),
            new Subject("Supply Chain Management", 3),
            new Subject("Automation Systems", 3),
            new Subject("Ergonomics", 3)
        );
        List<Subject> industrialSem4Subjects = Arrays.asList(
            new Subject("Lean Manufacturing", 3),
            new Subject("Six Sigma", 3),
            new Subject("Robotics", 3),
            new Subject("CAD/CAM", 3)
        );
        List<Subject> industrialSem5Subjects = Arrays.asList(
            new Subject("Industrial IoT", 3),
            new Subject("Smart Manufacturing", 3),
            new Subject("Process Optimization", 3),
            new Subject("Project Management", 3)
        );
        List<Subject> industrialSem6Subjects = Arrays.asList(
            new Subject("Capstone Project", 6),
            new Subject("Professional Ethics", 2),
            new Subject("Technical Writing", 2),
            new Subject("Industry Internship", 4)
        );
        List<Semester> industrialSemesters = Arrays.asList(
            new Semester(1, industrialSem1Subjects),
            new Semester(2, industrialSem2Subjects),
            new Semester(3, industrialSem3Subjects),
            new Semester(4, industrialSem4Subjects),
            new Semester(5, industrialSem5Subjects),
            new Semester(6, industrialSem6Subjects)
        );
        allBranches.add(new EngineeringBranch("Industrial and Manufacturing Engineering", 6, industrialSemesters));

        // Chemical Engineering
        List<Subject> chemicalSem1Subjects = Arrays.asList(
            new Subject("Mathematics I", 4),
            new Subject("Physics I", 3),
            new Subject("Chemistry I", 3),
            new Subject("Engineering Mechanics", 3)
        );
        List<Subject> chemicalSem2Subjects = Arrays.asList(
            new Subject("Mathematics II", 4),
            new Subject("Physics II", 3),
            new Subject("Chemistry II", 3),
            new Subject("Thermodynamics", 3)
        );
        List<Subject> chemicalSem3Subjects = Arrays.asList(
            new Subject("Chemical Process Principles", 3),
            new Subject("Fluid Mechanics", 3),
            new Subject("Heat Transfer", 3),
            new Subject("Mass Transfer", 3)
        );
        List<Subject> chemicalSem4Subjects = Arrays.asList(
            new Subject("Chemical Reactor Design", 3),
            new Subject("Process Control", 3),
            new Subject("Separation Processes", 3),
            new Subject("Process Safety", 3)
        );
        List<Subject> chemicalSem5Subjects = Arrays.asList(
            new Subject("Plant Design", 3),
            new Subject("Environmental Engineering", 3),
            new Subject("Biochemical Engineering", 3),
            new Subject("Project Management", 3)
        );
        List<Subject> chemicalSem6Subjects = Arrays.asList(
            new Subject("Capstone Project", 6),
            new Subject("Professional Ethics", 2),
            new Subject("Technical Writing", 2),
            new Subject("Industry Internship", 4)
        );
        List<Semester> chemicalSemesters = Arrays.asList(
            new Semester(1, chemicalSem1Subjects),
            new Semester(2, chemicalSem2Subjects),
            new Semester(3, chemicalSem3Subjects),
            new Semester(4, chemicalSem4Subjects),
            new Semester(5, chemicalSem5Subjects),
            new Semester(6, chemicalSem6Subjects)
        );
        allBranches.add(new EngineeringBranch("Chemical Engineering", 6, chemicalSemesters));

        adapter.setBranches(allBranches);
    }
} 