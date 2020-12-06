package com.jose.citasmedicas.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jose.citasmedicas.model.Appointment;
import com.jose.citasmedicas.model.repository.FirebaseAPI;
import com.jose.citasmedicas.model.repository.IFirebaseCallback;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentViewModel extends ViewModel {
    FirebaseAPI firebaseAPI= new FirebaseAPI();
    public MutableLiveData<ArrayList<Appointment>> listAppointment= new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading= new MutableLiveData<Boolean>();

    public void refresh(){

        getAppointments();
    }
    /*public Appointment createAppointments(int id, String name, Date datetime){

        return new Appointment(id,name,datetime);
    }*/
    /*
    public void bookAppointment(Appointment appointment){
        System.out.println("Cita");
        System.out.println("Doctor: "+appointment.getName());
    }*/
    /*public ArrayList<Appointment> getAppointments(){
        return firebaseAPI.getAppointments();
    }*/
    public void getAppointments(){
        firebaseAPI.getAppointments(new IFirebaseCallback<ArrayList<Appointment>>() {
            @Override
            public void onSuccess(ArrayList<Appointment> result) {
                listAppointment.postValue(result);


                processFinished();
            }

            @Override
            public void onFailed(Exception exception) {
                processFinished();
            }

            public void processFinished(){
                isLoading.setValue(true);
            }
        });
    }


}
