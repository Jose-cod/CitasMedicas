package com.jose.citasmedicas.view.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
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
import java.util.Observable;


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
        //ArrayList<Appointment> appointments= appointmentViewModel.getAppointments();
        appointmentAdapter= new AppointmentAdapter(this.getContext(),this);
        //appointmentAdapter= new AppointmentAdapter(this.getContext(),appointments);
        appointmentViewModel.refresh();

        rvCita= view.findViewById(R.id.rvCitas);
        rlBaseCita= view.findViewById(R.id.rlBaseCita);
        rvCita.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvCita.setAdapter(appointmentAdapter);
        observerViewModel();

    }


    public void observerViewModel(){
        appointmentViewModel.listAppointment.observe(getViewLifecycleOwner(), new Observer<ArrayList<Appointment>>() {
            @Override
            public void onChanged(ArrayList<Appointment> appointments) {
                appointmentAdapter.updateData(appointments);
            }
        });

        final Observer<Boolean> nameObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable final Boolean isLoading) {
                // Update the UI, in this case, a TextView.
                if(isLoading!=null)
                    rlBaseCita.setVisibility(View.INVISIBLE);
            }
        };
        appointmentViewModel.isLoading.observe(getViewLifecycleOwner(),nameObserver);


    }
    @Override
    public void onAppointmentClicked(Appointment appointment, int position) {
        //AppointmentFragmentDirections.toAppointmentDetail action= new AppointmentFragmentDirections.toAppointmentDetail(appointment);
        //NavDirections action = AppointmentFragmentDirections.toAppointmentDetail(appointment);
        //Navigation.findNavController(getView()).navigate(action);
    }

    /*
    fun observeViewModel(){
        personViewmodel.listPerson.observe( viewLifecycleOwner,Observer<List<Person>>{ person->
            personAdapter.updateData(person)
        })


        personViewmodel.isLoading.observe(viewLifecycleOwner, Observer<Boolean> {
            if(it!=null)
                rlBasePerson.visibility= View.INVISIBLE
        })
    }
    * */
}