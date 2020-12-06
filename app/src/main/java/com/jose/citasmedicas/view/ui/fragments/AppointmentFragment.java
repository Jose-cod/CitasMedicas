package com.jose.citasmedicas.view.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.jose.citasmedicas.R;
import com.jose.citasmedicas.model.Appointment;
import com.jose.citasmedicas.view.adapter.AppointmentAdapter;
import com.jose.citasmedicas.view.adapter.IAppointmentListener;
import com.jose.citasmedicas.viewmodel.AppointmentViewModel;

import java.util.ArrayList;


public class AppointmentFragment extends Fragment implements IAppointmentListener {
    private AppointmentViewModel appointmentViewModel;
    private RecyclerView rvCita;
    private RelativeLayout rlBaseCita;
    private AppointmentAdapter appointmentAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_appointment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        appointmentViewModel= ViewModelProviders.of(this).get(AppointmentViewModel.class);
        ArrayList<Appointment> appointments= appointmentViewModel.getAppointments();

        appointmentAdapter= new AppointmentAdapter(this.getContext(),appointments);
        rvCita= view.findViewById(R.id.rvCitas);
        rlBaseCita= view.findViewById(R.id.rlBaseCita);
        rvCita.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvCita.setAdapter(appointmentAdapter);


    }

    @Override
    public void onAppointmentClicked(Appointment appointment, int position) {

    }
}