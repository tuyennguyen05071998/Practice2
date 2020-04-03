package net.tuyenoc.practice2;

import java.io.Serializable;

public class Student implements Serializable {
    private String studentId, name;
    private double mark;

    public Student(String studentId, String name, double mark) {
        this.studentId = studentId;
        this.name = name;
        this.mark = mark;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getMark() {
        return mark;
    }
}
