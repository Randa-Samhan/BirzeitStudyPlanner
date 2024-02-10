package com.example.birzeitstudyplanner;

public class StudentModel {
    private String firstName;
    private String lastName;
    private String birthdate;
    private String gpa;
    private String registrationDate;


    public  StudentModel(String firstName, String lastName, String birthdate,String gpa,String registrationDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gpa = gpa;
        this.registrationDate = registrationDate;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getGpa() {
        return gpa;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
}
