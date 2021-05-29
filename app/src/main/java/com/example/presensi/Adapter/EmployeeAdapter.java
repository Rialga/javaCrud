package com.example.presensi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.presensi.Model.EmployeeModel;
import com.example.presensi.R;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder>{
    private Context ctx;
    private List<EmployeeModel> listEmployee;

    public EmployeeAdapter(Context ctx, List<EmployeeModel> listEmployee) {
        this.ctx = ctx;
        this.listEmployee = listEmployee;
    }

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_item,parent,false);
        EmployeeHolder holder = new EmployeeHolder(layout);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {
        EmployeeModel em =listEmployee.get(position);

        holder.tv_id.setText(em.getId());
        holder.tv_firstname.setText(em.getFirst_name());
        holder.tv_lastname.setText(em.getLast_name());
        holder.tv_role.setText(em.getRole());
        holder.tv_mail.setText(em.getEmail());
        holder.tv_salary.setText(String.valueOf(em.getSalary()));
        holder.tv_createdAt.setText(String.valueOf(em.getCreatedAt()));

    }

    @Override
    public int getItemCount() {
        return listEmployee.size();
    }

    public class EmployeeHolder extends RecyclerView.ViewHolder{
        TextView tv_id, tv_firstname, tv_lastname, tv_role, tv_salary, tv_createdAt, tv_phone, tv_mail;

        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);

            tv_id = itemView.findViewById(R.id.tv_id);
            tv_firstname = itemView.findViewById(R.id.tv_firstname);
            tv_lastname = itemView.findViewById(R.id.tv_lastname);
            tv_role = itemView.findViewById(R.id.tv_role);
            tv_mail = itemView.findViewById(R.id.tv_mail);
            tv_phone = itemView.findViewById(R.id.tv_phone);
            tv_salary = itemView.findViewById(R.id.tv_salary);
            tv_createdAt = itemView.findViewById(R.id.tv_createdAt);

        }
    }
}
