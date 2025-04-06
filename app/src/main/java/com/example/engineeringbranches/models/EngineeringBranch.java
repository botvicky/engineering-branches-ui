package com.example.engineeringbranches.models;

import java.util.List;

public class EngineeringBranch {
    private String name;
    private int semesterCount;
    private List<Semester> semesters;

    public EngineeringBranch(String name, int semesterCount, List<Semester> semesters) {
        this.name = name;
        this.semesterCount = semesterCount;
        this.semesters = semesters;
    }

    public String getName() {
        return name;
    }

    public int getSemesterCount() {
        return semesterCount;
    }

    public List<Semester> getSemesters() {
        return semesters;
    }
} 