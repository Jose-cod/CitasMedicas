package com.jose.citasmedicas.model;

import java.io.Serializable;
import java.util.Date;

public class Appointment implements Serializable {
    public int id;
    public String name;
    public Date datetime;
    public String speciality;
    public String status;

    public Appointment(int id,String name,Date datetime,String speciality, String status){
        this.id=id;
        this.name=name;
        this.datetime=datetime;
        this.status=status;
        this.speciality=speciality;
    }

}
