package com.example.birzeitstudyplanner;

public class InstroctorModel {
    private String name;
    private String hours;

    public InstroctorModel(String name, String hours){
        this.name = name;
        this.hours = hours;
    }
    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
