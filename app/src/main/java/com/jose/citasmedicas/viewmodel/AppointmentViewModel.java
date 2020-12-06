package com.jose.citasmedicas.viewmodel;

import androidx.lifecycle.ViewModel;

import com.jose.citasmedicas.model.Appointment;
import com.jose.citasmedicas.model.repository.FirebaseAPI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentViewModel extends ViewModel {
    FirebaseAPI firebaseAPI= new FirebaseAPI();

    /*public Appointment createAppointments(int id, String name, Date datetime){

        return new Appointment(id,name,datetime);
    }*/
    /*
    public void bookAppointment(Appointment appointment){
        System.out.println("Cita");
        System.out.println("Doctor: "+appointment.getName());
    }*/
    public ArrayList<Appointment> getAppointments(){
        return firebaseAPI.getAppointments();
    }
}
