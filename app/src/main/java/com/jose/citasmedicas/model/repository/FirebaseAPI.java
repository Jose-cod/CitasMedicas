package com.jose.citasmedicas.model.repository;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.jose.citasmedicas.model.Appointment;

import java.util.ArrayList;
import java.util.List;


public class FirebaseAPI {
    final String collectionCitas="citas";
    FirebaseFirestore db_firebase=FirebaseFirestore.getInstance();


    public ArrayList<Appointment> getAppointments(){
        CollectionReference citasReference= db_firebase.collection(collectionCitas);
        ArrayList<Appointment> appointments= new ArrayList<Appointment>();

        citasReference.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                for(QueryDocumentSnapshot document: task.getResult()){
                    //Appointment appointment= document.toObject(Appointment.class);
                    int id=Integer.parseInt(document.getId());
                    String name=document.getString("name");
                    //String datetime=document.getString("date");
                    String speciality=document.getString("speciality");
                    String status=document.getString("status");
                    Appointment appointment= new Appointment(id,name,speciality,status);
                    System.out.println("------------------------------------------------------------------");
                    System.out.println(id+name+speciality);
                    appointments.add(appointment);

                }
            }else{
                System.out.println("fallo la obtencion de documentos");
            }
        });

        return appointments;

    }


    //val settings=FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()
    /*public ArrayList<Appointment> getAppointments(){
        ArrayList<Appointment> appointments = null;

        bd_firebase.collection(collectionCitas).get().addOnSuccessListener(
                new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for(QueryDocumentSnapshot appointment: queryDocumentSnapshots){
                            int id=Integer.parseInt(appointment.getId());
                            String name = appointment.getString("name");
                            String speciality = appointment.getString("speciality");
                            String date = appointment.getString("date");
                            String status = appointment.getString("status");

                            Appointment appointment1= new Appointment(id,name,speciality,date,status);
                            appointments.add(appointment1);
                        }
                    }
                }
        );
        return appointments;

    }*/

}
