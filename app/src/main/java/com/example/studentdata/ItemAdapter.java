package com.example.studentdata;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private Context context;
    private Helper mDatabase;
    private Activity activity;
    private ArrayList fname,lname,classname,roll,grade,contact;



    public ItemAdapter(Activity activity,Context context, ArrayList fname, ArrayList classname, ArrayList grade) {
        this.activity=activity;
        this.context = context;
        this.fname = fname;
        this.classname = classname;
        this.grade = grade;
    }

    public ItemAdapter(ArrayList lname, ArrayList roll, ArrayList contact) {
        this.lname = lname;
        this.roll = roll;
        this.contact = contact;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_data,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.fname.setText(String.valueOf(fname.get(position)));
        holder.cname.setText(String.valueOf(classname.get(position)));
        holder.main_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,Show_Data.class);
                intent.putExtra("First_name",String.valueOf(fname.get(position)));
                intent.putExtra("Last_name",String.valueOf(lname.get(position)));
                intent.putExtra("Class",String.valueOf(classname.get(position)));
                intent.putExtra("Grade",String.valueOf(grade.get(position)));
                intent.putExtra("Roll_No",String.valueOf(roll.get(position)));
                intent.putExtra("Contact_No",String.valueOf(contact.get(position)));
                activity.startActivityForResult(intent,1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return fname.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView fname,cname;
        LinearLayout main_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fname=itemView.findViewById(R.id.first);
            cname=itemView.findViewById(R.id.class_name);
            main_layout=itemView.findViewById(R.id.mainlayout);
        }
    }
}
