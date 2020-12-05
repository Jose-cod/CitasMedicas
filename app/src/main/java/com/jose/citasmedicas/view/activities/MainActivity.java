package com.jose.citasmedicas.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.jose.citasmedicas.viewmodel.AppointmentViewModel;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jose.citasmedicas.R;
import com.jose.citasmedicas.model.Appointment;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView itemName;
    private TextView itemDate;
    private Button btnBookAppointment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemName=findViewById(R.id.tvItemDoctorName);
        itemDate=findViewById(R.id.tvDateAppointments);
        btnBookAppointment=findViewById(R.id.btnBookAppointment);

        AppointmentViewModel appointmentViewModel=new AppointmentViewModel();

        Date date=new Date();
        Appointment appointment=appointmentViewModel.createAppointments(1,"Viridiana Olivares",date);

        itemName.setText("Doctor: "+appointment.getName());
        itemDate.setText("Fecha: "+appointment.getDatetime().toString());

        btnBookAppointment.setOnClickListener(new View.OnClickListener(){
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
        });

    }
}