package com.example.aric.databinding.Model;

/**
 * Created by aric on 16/5/30.
 */
public class Student {
    private final String name;
    private final String uid;

    public Student(String name, String uid) {
        this.name = name;
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }
}
