package com.jose.citasmedicas.view.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jose.citasmedicas.R;
import com.jose.citasmedicas.model.Appointment;

import java.text.SimpleDateFormat;
import java.util.Date;


public class AppointmentDetail extends DialogFragment {

    TextView tvName;
    TextView tvSpeciality;
    TextView  tvDate;
    TextView tvHour;
    Button btnBookAppointment;
    Appointment appointment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_appointment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvName= view.findViewById(R.id.tvDetailDoctorName);
        tvDate= view.findViewById(R.id.tvDetailDate);
        tvSpeciality= view.findViewById(R.id.tvDetailSpeciality);
        tvHour= view.findViewById(R.id.tvDetailHour);
        btnBookAppointment= view.findViewById(R.id.btnBookAppointment);
        appointment= AppointmentDetailArgs.fromBundle(getArguments()).getAppointment();

        tvName.setText(appointment.name);
        tvDate.setText(dateToString(appointment.datetime));
        tvSpeciality.setText(appointment.speciality);
        tvHour.setText(hourToString(appointment.datetime));

        btnBookAppointment.setOnClickListener(v -> {
            Toast.makeText(this.getContext(),"Tu cita ha sido agendada",Toast.LENGTH_LONG).show();
        });
    }

    public String dateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaComoCadena = sdf.format(date);
        return fechaComoCadena;
    }

    public String hourToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        //SimpleDateFormat simpleDateFormatAMPM= new SimpleDateFormat("a");
        //String fechaComoCadena = sdf.format(date);
        String hourFormato= sdf.format(date);
        return hourFormato;

    }
}