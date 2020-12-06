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

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AppointmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "AppointmentAdapter";

    private ArrayList<Appointment> appointments = new ArrayList<>();
    private IAppointmentListener appointmentListener;
    private Context context;
    private int mSelectedAppoinmentIndex;

    public AppointmentAdapter(Context context, ArrayList<Appointment> appointments) {
        this.appointments=appointments;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_cita, parent, false);

        holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewHolder){
            ((ViewHolder) holder).tvDoctorName.setText(appointments.get(position).name);
            ((ViewHolder) holder).tvSpeciality.setText(appointments.get(position).speciality);
        }
    }

    @Override
    public int getItemCount() {
        return appointments.size();
    }


//SimpleDateFormat spf = new SimpleDateFormat("MMM dd, yyyy");
    //String date = spf.format(mNotes.get(position).getTimestamp());
/*fun updateData(data:List<Person>){
    listPerson.clear()
    listPerson.addAll(data)
    notifyDataSetChanged()
}*/
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mSelectedAppoinmentIndex = getAdapterPosition();
            appointmentListener.onAppointmentClicked(appointments.get(mSelectedAppoinmentIndex),mSelectedAppoinmentIndex);
        }
    }

}


