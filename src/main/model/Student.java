package main.model;

import java.sql.Date;

public class Student {
    private int studentNo;
    private String studentName;
    private String studentSex;
    private Date studentBirth;

    @Override
    public String toString(){

        return "No:" + studentNo + "\nName:" + studentName + "\nSex:" + studentSex + "\nBirth:" + studentBirth + "\n";
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public Date getStudentBirth() {
        return studentBirth;
    }

    public void setStudentBirth(Date studentBirth) {
        this.studentBirth = studentBirth;
    }
}
