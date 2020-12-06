package com.jose.citasmedicas.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jose.citasmedicas.R;
import com.jose.citasmedicas.model.Appointment;
import com.jose.citasmedicas.view.ui.fragments.AppointmentFragmentDirections;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ViewHolder> {
    private static final String TAG = "AppointmentAdapter";

    private ArrayList<Appointment> appointments = new ArrayList<>();
    private IAppointmentListener appointmentListener;
    private Context context;
    private int mSelectedAppoinmentIndex;

    public AppointmentAdapter(Context context,IAppointmentListener appointmentListener) {
        //this.appointments=appointments;
        this.context=context;
        this.appointmentListener=appointmentListener;
    }

    @NonNull
    @Override
    public AppointmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AppointmentAdapter.ViewHolder holder;
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_cita, parent, false);

        holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentAdapter.ViewHolder holder, int position) {
        if(holder instanceof ViewHolder){
            ((ViewHolder) holder).tvDoctorName.setText(appointments.get(position).name);
            ((ViewHolder) holder).tvSpeciality.setText(appointments.get(position).speciality);
            System.out.println("desde el adapter---------------------------");
            System.out.println(appointments.get(position).name);
            ((ViewHolder) holder).tvDate.setText(dateToString(appointments.get(position).datetime));
            ((ViewHolder) holder).tvHour.setText(hourToString(appointments.get(position).datetime));
            //((ViewHolder) holder).tvCitaHourAMPM.setText(hourToStringAMPM(appointments.get(position).datetime));
            //onlistener
            ((ViewHolder) holder).itemView.setOnClickListener(it->{
                appointmentListener.onAppointmentClicked(appointments.get(position),position);
            });
        }
    }

    @Override
    public int getItemCount() {
        return appointments.size();
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


    public void updateData(ArrayList<Appointment> data){
        appointments.clear();
        appointments.addAll(data);
        notifyDataSetChanged();
    }


    /*@Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        appointmentListener = (IAppointmentListener) context;
    }*/

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvDate;
        TextView tvDoctorName;
        TextView tvSpeciality;
        TextView tvCitaHourAMPM;
        TextView tvHour;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDate= itemView.findViewById(R.id.tvItemFecha);
            tvDoctorName= itemView.findViewById(R.id.tvItemDoctorName);
            tvSpeciality= itemView.findViewById(R.id.tvItemSpeciality);
            tvCitaHourAMPM= itemView.findViewById(R.id.tvCitaHourAMPM);
            tvHour= itemView.findViewById(R.id.tvHour);
            //itemView.setOnClickListener(this);

        }




    }

}


