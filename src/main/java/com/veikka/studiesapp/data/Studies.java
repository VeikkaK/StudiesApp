package com.veikka.studiesapp.data;

public class Studies {
    private String studentnames;
    private String course;
    private String teacher;
    private int grade;
    private int classroom;
    private static int count = 1;

    public Studies() {
        this("", "", "", 0);
    }

    public Studies(String studentnames, String course, String teacher, int classroom) {
        this.studentnames = studentnames;
        this.course = course;
        this.teacher = teacher;
        this.classroom = classroom;
        this.grade = count++;
    }

    public String getstudentnames() {
        return this.studentnames;
    }

    public void setstudentnames(String studentnames) {
        this.studentnames = studentnames;
    }

    public String getcourse() {
        return this.course;
    }

    public void setcourse(String course) {
        this.course = course;
    }

    public int getgrade() {
        return this.grade;
    }

    public String getteacher() {
        return this.teacher;
    }

    public void setteacher(String teacher) {
        this.teacher = teacher;
    }

    public int getclassroom() {
        return this.classroom;
    }

    public void setclassroom(int classroom) {
        this.classroom = classroom;
    }
}