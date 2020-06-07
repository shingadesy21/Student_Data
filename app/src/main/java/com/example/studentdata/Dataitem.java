package com.example.studentdata;

import androidx.annotation.NonNull;

class Dataitem {
    String Fname,Lname,Class_,Roll,Grade,Contact;

    public Dataitem(String fname, String lname, String aClass, String roll, String grade, String contact) {
        Fname = fname;
        Lname = lname;
        Class_ = aClass;
        Roll = roll;
        Grade = grade;
        Contact = contact;
    }

    public Dataitem(String fname, String lname, String grade) {
        Fname = fname;
        Lname = lname;
        Grade = grade;
    }

    public Dataitem(StringBuffer name, StringBuffer class_name, StringBuffer grade) {
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }


    public String getClass_() {
        return Class_;
    }

    public void setClass(String aClass) {
        Class_ = aClass;
    }

    public String getRoll() {
        return Roll;
    }

    public void setRoll(String roll) {
        Roll = roll;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }
}