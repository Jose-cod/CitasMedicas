package com.jose.citasmedicas.view.adapter;

import com.jose.citasmedicas.model.Appointment;

public interface IAppointmentListener {
    public void onAppointmentClicked(Appointment appointment, int position);
}
