package com.jose.citasmedicas.view.ui.fragments.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jose.citasmedicas.viewmodel.AppointmentViewModel;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.jose.citasmedicas.R;
import com.jose.citasmedicas.model.Appointment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView itemName;
    private TextView itemDate;
    private Button btnBookAppointment;
    private AppointmentViewModel appointmentViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*itemName=findViewById(R.id.tvItemDoctorName);
        itemDate=findViewById(R.id.tvDateAppointments);
        btnBookAppointment=findViewById(R.id.btnBookAppointment);

        AppointmentViewModel appointmentViewModel=new AppointmentViewModel();

        Date date=new Date();
        Appointment appointment=appointmentViewModel.createAppointments(1,"Viridiana Olivares",date);

        itemName.setText("Doctor: "+appointment.getName());
        itemDate.setText("Fecha: "+appointment.getDatetime().toString());*/
        appointmentViewModel= new AppointmentViewModel();
        //ArrayList<Appointment> appointments;
        //appointments=appointmentViewModel.getAppointments();

        /*for(Appointment appointment: appointments){
            System.out.println(appointment.name);
            System.out.println(appointment.speciality);
        }*/
        configNav();

        /*btnBookAppointment.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //Notificación
                NotificationCompat.Builder notificationBuild = new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("CitasMedicas")
                        .setContentText("Tu cita se ha registrado exitosamente")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

// notificationID allows you to update the notification later on.
                mNotificationManager.notify(1, notificationBuild.build());

            }
        });*/

    }

    public void configNav(){
        BottomNavigationView bnvMenu=findViewById(R.id.bnvMenu);
        NavigationUI.setupWithNavController(bnvMenu, Navigation.findNavController(this,R.id.fragContent));
    }
}