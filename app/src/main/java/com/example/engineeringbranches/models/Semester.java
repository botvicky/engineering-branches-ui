package com.example.engineeringbranches.models;

import java.util.List;

public class Semester {
    private int number;
    private List<Subject> subjects;

    public Semester(int number, List<Subject> subjects) {
        this.number = number;
        this.subjects = subjects;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
} 