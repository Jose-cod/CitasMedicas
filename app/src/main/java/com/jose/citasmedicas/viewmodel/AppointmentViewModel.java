package com.jose.citasmedicas.viewmodel;

import androidx.lifecycle.ViewModel;

import com.jose.citasmedicas.model.Appointment;

import java.util.Date;

public class AppointmentViewModel extends ViewModel {

    public Appointment createAppointments(int id, String name, Date datetime){

        return new Appointment(id,name,datetime);
    }

    public void bookAppointment(Appointment appointment){
        System.out.println("Cita");
        System.out.println("Doctor: "+appointment.getName());
    }
}
