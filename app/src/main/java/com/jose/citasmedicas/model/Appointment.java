package com.jose.citasmedicas.model;

import java.util.Date;

public class Appointment {
    private int id;
    private String name;
    private Date datetime;

    public Appointment(int id,String name,Date datetime){
        this.id=id;
        this.name=name;
        this.datetime=datetime;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
    public Date getDatetime(){
        return this.datetime;
    }
}
