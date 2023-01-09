package vn.iotstar.polysys.model;

import android.content.Intent;

import java.util.Date;

public class Student {
    private String studentId;
    private String studentName;
    private Date Dob;
    private Integer classId;

    public Student() {
    }

    public Student(String studentId, String studentName, Date dob, Integer classId) {
        this.studentId = studentId;
        this.studentName = studentName;
        Dob = dob;
        this.classId = classId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getDob() {
        return Dob;
    }

    public void setDob(Date dob) {
        Dob = dob;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}
