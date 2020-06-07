package com.example.studentdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Add_Details extends AppCompatActivity {
Button save,cancel;
EditText fname,lname,class_name,roll,grade,contact;

    Helper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__details);

        save=findViewById(R.id.save_btn);
        cancel=findViewById(R.id.cancel_btn);
        fname=findViewById(R.id.first_name);
        lname=findViewById(R.id.lirst_name);
        class_name=findViewById(R.id.class_id);
        roll=findViewById(R.id.roll_no);
        grade=findViewById(R.id.grade_txt);
        contact=findViewById(R.id.conatct_txt);


        helper =new Helper(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddData();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Operetion Cancel........",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        });



    }

    private void AddData() {
        String first_name,last_name,class_str,roll_no,grade_str,contact_no;

        first_name=fname.getText().toString();
        last_name=lname.getText().toString();
        class_str=class_name.getText().toString();
        roll_no=roll.getText().toString();
        grade_str=grade.getText().toString();
        contact_no=contact.getText().toString();

        if(first_name.isEmpty() || last_name.isEmpty()|| class_str.isEmpty() || roll_no.isEmpty() || grade_str.isEmpty() || contact_no.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Enter valid data",Toast.LENGTH_LONG).show();
        }
        else
        {
            boolean isInserted=helper.insert(first_name,last_name,class_str,roll_no,grade_str,contact_no);
            if (isInserted=true) {
                Toast.makeText(getApplicationContext(), "Data inserted", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
            else {
                Toast.makeText(getApplicationContext(), "Data not inserted", Toast.LENGTH_LONG).show();
            }



        }

    }
}