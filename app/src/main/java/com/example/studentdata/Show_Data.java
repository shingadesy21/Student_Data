package com.example.studentdata;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class Show_Data extends AppCompatActivity {
TextView fname_show,lname_show,class_show,grade_show,roll_show,contact_show;
String fname_show_txt,lname_show_txt,class_show_txt,grade_show_txt,roll_show_txt,contact_show_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__data);
        fname_show=findViewById(R.id.show_fname);
        lname_show=findViewById(R.id.show_lname);
        class_show=findViewById(R.id.show_class);
        grade_show=findViewById(R.id.show_grade);
        roll_show=findViewById(R.id.show_grade);
        contact_show=findViewById(R.id.show_contact);


        getnsetIntent();

        ActionBar bar=getSupportActionBar();
        if(bar!=null)
        {
            bar.setTitle(fname_show_txt);
        }

    }

    private void getnsetIntent() {
        if(getIntent().hasExtra("First_name") && getIntent().hasExtra("Last_name") && getIntent().hasExtra("Class") && getIntent().hasExtra("Grade") && getIntent().hasExtra("Roll_No") && getIntent().hasExtra("Contact_No"))
        {
            fname_show_txt = getIntent().getStringExtra("First_name");
            lname_show_txt = getIntent().getStringExtra("Last_name");
            class_show_txt = getIntent().getStringExtra("Class");
            grade_show_txt = getIntent().getStringExtra("Grade");
            roll_show_txt = getIntent().getStringExtra("Roll_No");
            contact_show_txt = getIntent().getStringExtra("Contact_No");

            fname_show.setText(fname_show_txt);
            lname_show.setText(lname_show_txt);
            class_show.setText(class_show_txt);
            grade_show.setText(grade_show_txt);
            roll_show.setText(roll_show_txt);
            contact_show.setText(contact_show_txt);

            Log.d("data", fname_show_txt + " " + lname_show_txt + " " + class_show_txt + " " + grade_show_txt + " " + roll_show_txt + " " + contact_show_txt);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_LONG).show();

        }



    }
}